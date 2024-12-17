/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import SQLConnection.DBConnection;
import constants.ChucVu;
import java.sql.*;
import model.NhanVien;
import model.TaiKhoan;

/**
 *
 * @author ADMIN
 */
public class TaiKhoanDAO {

    Connection connection = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public TaiKhoanDAO() {
    }

    public boolean checkTenTaiKhoan(String tenTK) throws ClassNotFoundException {
        boolean exists = false;

        try {
            connection = DBConnection.getConnection();

            String sql = "SELECT * FROM TaiKhoan WHERE TenTK = ?";

            ps = connection.prepareStatement(sql);
            ps.setString(1, tenTK);

            rs = ps.executeQuery();

            if (rs.next()) {
                exists = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return exists;
    }

    public boolean checkTaiKhoan(String tenTK, String matKhau) throws ClassNotFoundException {
        boolean exists = false;

        try {

            connection = DBConnection.getConnection();

            String sql = "SELECT * FROM TaiKhoan WHERE TenTK = ? AND matKhau = ?";

            ps = connection.prepareStatement(sql);
            ps.setString(1, tenTK);
            ps.setString(2, matKhau);

            rs = ps.executeQuery();

            if (rs.next()) {
                exists = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return exists;
    }

    public TaiKhoan layChucVu(String tenTK) throws ClassNotFoundException {
        TaiKhoan taiKhoan = null;

        try {

            connection = DBConnection.getConnection();
            String sql = "SELECT ChucVu FROM TaiKhoan WHERE TenTK = ?";

            ps = connection.prepareStatement(sql);
            ps.setString(1, tenTK);

            rs = ps.executeQuery();

            while (rs.next()) {
                taiKhoan = new TaiKhoan();
                taiKhoan.setChucVu(rs.getString(1));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return taiKhoan;
    }

    public TaiKhoan layThongTinCaNhan(String tenTK) throws ClassNotFoundException {
        TaiKhoan taiKhoan = null;
        NhanVien nv = null;

        try {

            connection = DBConnection.getConnection();
            String sql = "SELECT * FROM TaiKhoan JOIN NhanVien ON TaiKhoan.MaNV = NhanVien.MaNV WHERE TaiKhoan.TenTK = ?";

            ps = connection.prepareStatement(sql);
            ps.setString(1, tenTK);

            rs = ps.executeQuery();

            while (rs.next()) {
                nv = new NhanVien();
                taiKhoan = new TaiKhoan();
                
                nv.setMaNV(rs.getInt(5));
                nv.setTen(rs.getString(6));
                nv.setGioiTinh(rs.getBoolean(7));
                nv.setDiaChi(rs.getString(8));
                nv.setEmail(rs.getString(9));
                nv.setSoDT(rs.getString(10));
                taiKhoan.setTenTK(tenTK);
                taiKhoan.setMatKhau(rs.getString(2));
                taiKhoan.setChucVu(rs.getString(3));
                taiKhoan.setNv(nv);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return taiKhoan;
    }
    
    public static void main(String[] args) throws ClassNotFoundException {
        TaiKhoanDAO dao = new TaiKhoanDAO();
        System.out.println(dao.layChucVu("user1").getChucVu().equals(ChucVu.nhanVien));
    }
}
