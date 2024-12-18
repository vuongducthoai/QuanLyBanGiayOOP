/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import SQLConnection.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.NhanVien;
import model.TaiKhoan;

/**
 *
 * @author ADMIN
 */
public class NhanVienDAO {

    Connection connection = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public NhanVienDAO() {
    }

    public List<TaiKhoan> getAllNhanVienWithTaiKhoan() throws ClassNotFoundException {
        List<TaiKhoan> taiKhoanList = new ArrayList<>();

        try {
            connection = DBConnection.getConnection();
            String sql = "SELECT nv.MaNV, nv.TenNV, nv.GioiTinh, nv.DiaChi, nv.Email, nv.SoDT, tk.TenTK, tk.MatKhau, tk.ChucVu "
                    + "FROM NhanVien nv "
                    + "JOIN TaiKhoan tk ON nv.MaNV = tk.MaNV";
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                NhanVien nhanVien = new NhanVien();
                nhanVien.setMaNV(rs.getInt("MaNV"));
                nhanVien.setTen(rs.getString("TenNV"));
                nhanVien.setGioiTinh(rs.getString("GioiTinh"));
                nhanVien.setDiaChi(rs.getString("DiaChi"));
                nhanVien.setEmail(rs.getString("Email"));
                nhanVien.setSoDT(rs.getString("SoDT"));

                TaiKhoan taiKhoan = new TaiKhoan();
                taiKhoan.setTenTK(rs.getString("TenTK"));
                taiKhoan.setMatKhau(rs.getString("MatKhau"));
                taiKhoan.setChucVu(rs.getString("ChucVu"));
                taiKhoan.setNv(nhanVien);

                taiKhoanList.add(taiKhoan);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
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

        return taiKhoanList;
    }

    public boolean addNhanVien(NhanVien nhanVien, TaiKhoan taiKhoan) {
        try {
            String insertNhanVienSQL = "INSERT INTO NhanVien (TenNV, GioiTinh, DiaChi, Email, SoDT) VALUES (?, ?, ?, ?, ?)";
            String insertTaiKhoanSQL = "INSERT INTO TaiKhoan (TenTK, MatKhau, ChucVu, MaNV) VALUES (?, ?, ?, ?)";

            connection = DBConnection.getConnection();

            ps = connection.prepareStatement(insertNhanVienSQL, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, nhanVien.getTen());
            ps.setString(2, nhanVien.getGioiTinh());
            ps.setString(3, nhanVien.getDiaChi());
            ps.setString(4, nhanVien.getEmail());
            ps.setString(5, nhanVien.getSoDT());

            int affectedRows = ps.executeUpdate();
            if (affectedRows == 0) {
                return false;
            }

            rs = ps.getGeneratedKeys();
            int maNV = 0;
            if (rs.next()) {
                maNV = rs.getInt(1);
            }

            ps = connection.prepareStatement(insertTaiKhoanSQL);
            ps.setString(1, taiKhoan.getTenTK());
            ps.setString(2, taiKhoan.getMatKhau());
            ps.setString(3, taiKhoan.getChucVu());
            ps.setInt(4, maNV);

            affectedRows = ps.executeUpdate();
            if (affectedRows == 0) {
                return false;
            }

            return true;
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public static void main(String[] args) {
        NhanVienDAO dao = new NhanVienDAO();

        try {
            for (TaiKhoan tk : dao.getAllNhanVienWithTaiKhoan()) {
                System.out.println(tk.getNv().getTen());
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
