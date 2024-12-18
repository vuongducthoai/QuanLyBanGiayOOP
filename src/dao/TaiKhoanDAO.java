/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import SQLConnection.DBConnection;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
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

    public boolean checkTenTaiKhoan(String tenTK) {
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

        } catch (SQLException ex) {
            Logger.getLogger(TaiKhoanDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TaiKhoanDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return exists;
    }

    public boolean checkTaiKhoan(String tenTK, String matKhau) {
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

        } catch (SQLException ex) {
            Logger.getLogger(TaiKhoanDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TaiKhoanDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return exists;
    }

    // Lấy thông tin cá nhân khi đăng nhập
    public TaiKhoan getThongTinCaNhan(String tenTK) {

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
                nv.setGioiTinh(rs.getString(7));
                nv.setDiaChi(rs.getString(8));
                nv.setEmail(rs.getString(9));
                nv.setSoDT(rs.getString(10));
                taiKhoan.setTenTK(tenTK);
                taiKhoan.setMatKhau(rs.getString(2));
                taiKhoan.setChucVu(rs.getString(3));
                taiKhoan.setNv(nv);
            }

        } catch (SQLException ex) {
            Logger.getLogger(TaiKhoanDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TaiKhoanDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return taiKhoan;

    }

    public static void main(String[] args) throws ClassNotFoundException {
        TaiKhoanDAO dao = new TaiKhoanDAO();
//        System.out.println(dao.layChucVu("user1").getChucVu().equals(ChucVu.nhanVien));
    }
}
