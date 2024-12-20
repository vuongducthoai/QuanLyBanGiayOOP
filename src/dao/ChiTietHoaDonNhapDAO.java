/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import dao.QuanLySanPhamDAO;
import java.sql.PreparedStatement;
import model.ChiTietHoaDonNhap;
import java.util.List;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.ChiTietHoaDon;
import model.DanhMuc;
import model.SanPham;

/**
 *
 * @author Asus
 */
public class ChiTietHoaDonNhapDAO {

    public static List<ChiTietHoaDonNhap> getChiTietHoaDonNhapList(Connection conn, int maHDN) throws SQLException {
        String sql = "SELECT MaCTHDN, TenSP, SoLuong, c.DonGiaNhap "
                + "FROM ChiTietHoaDonNhap as c INNER JOIN SanPham as s "
                + "ON c.MaSP = s.MaSP "
                + "WHERE C.MaHDN = ?";
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        preparedStatement.setInt(1, maHDN);
        ResultSet rs = preparedStatement.executeQuery();
        List<ChiTietHoaDonNhap> listChiTietHoaDonNhaps = new ArrayList<>();
        while (rs.next()) {
            ChiTietHoaDonNhap chiTietHoaDonNhap = new ChiTietHoaDonNhap();
            chiTietHoaDonNhap.setMaCTHDN(rs.getInt("MaCTHDN"));

            SanPham sanPham = new SanPham();
            sanPham.setTenSP(rs.getString("TenSP"));
            chiTietHoaDonNhap.setSanPham(sanPham);
            chiTietHoaDonNhap.setSoLuong(rs.getInt("SoLuong"));
            chiTietHoaDonNhap.setDonGiaNhap(rs.getDouble("DonGiaNhap"));
            listChiTietHoaDonNhaps.add(chiTietHoaDonNhap);
        }
        return listChiTietHoaDonNhaps;
    }

    public static SanPham findSanPhamByMaSP(Connection conn, int maSP) throws SQLException {
        SanPham sanPham = null;
        String sql = "SELECT * FROM SanPham WHERE MaSP = ?";
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setInt(1, maSP);
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            sanPham = new SanPham();
            sanPham.setMaSP(maSP);
            sanPham.setTenSP(rs.getString("TenSP"));
        }
        return sanPham;
    }

    public static int updateSanPhamByTenSP(Connection conn, SanPham sp) throws SQLException {
        // SQL Update
        String sql = "UPDATE SanPham SET DonGiaNhap = ? WHERE TenSP = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setDouble(1, sp.getDonGiaNhap());
        pstmt.setString(2, sp.getTenSP());
        return pstmt.executeUpdate();
    }
    
     public static int updateTongTien(Connection conn, double tongTien, int maHDN) throws SQLException{
         String sql = "UPDATE HoaDonNhap SET TongTien = ? WHERE MaHDN = ?";
         PreparedStatement pst = conn.prepareStatement(sql);
         pst.setDouble(1, tongTien);
         pst.setInt(2, maHDN);
         return pst.executeUpdate();
     }

    public static SanPham findSanPhamByTenSP(Connection conn, String tenSP) throws SQLException {
        SanPham sanPham = null;
        String sql = "SELECT * FROM SanPham WHERE TenSP = ?";
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setString(1, tenSP);
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            sanPham = new SanPham();
            sanPham.setMaSP(rs.getInt("MaSP"));
            sanPham.setTenSP(tenSP);
        }
        return sanPham;
    }

    public static double tongTien(Connection conn, int maHDN) throws SQLException {
        double tongTien = 0;
        String sql = "SELECT SUM(SoLuong * DonGiaNhap) as Total FROM ChiTietHoaDonNhap WHERE maHDN = ?";
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setInt(1, maHDN);
        ResultSet rs = pst.executeQuery();
        if (rs.next()) {
            tongTien = rs.getInt("Total");
        }
        return tongTien;
    }
    
    
   

    //Ktra xem san pham da ton tai trong database chua neu chua thi cap nhap
    public static int addChiTietHoaDonNhap(Connection conn, ChiTietHoaDonNhap chiTietHoaDonNhap) throws SQLException {
        SanPham sp = findSanPhamByTenSP(conn, chiTietHoaDonNhap.getSanPham().getTenSP());
        int maSP;
        if (sp == null) {
            //Insert san pham
            SanPham spNew = new SanPham();
            spNew.setTenSP(chiTietHoaDonNhap.getSanPham().getTenSP());
            spNew.setDonGiaNhap(chiTietHoaDonNhap.getDonGiaNhap());
            spNew.setDonGiaBan(0);
            DanhMuc danhMuc = new DanhMuc();
            danhMuc.setMaDM(1);
            spNew.setDanhMuc(danhMuc);
            QuanLySanPhamDAO.addSanPham(conn, spNew);
            maSP = getNextMaSP(conn);
        } else {
            //Update gia nhap
            SanPham sanPham = new SanPham();
            sanPham.setTenSP(chiTietHoaDonNhap.getSanPham().getTenSP());
            sanPham.setDonGiaNhap(chiTietHoaDonNhap.getDonGiaNhap());
            updateSanPhamByTenSP(conn, sanPham);
            maSP = sp.getMaSP();
        }
        String sql = "INSERT INTO ChiTietHoaDonNhap (MaHDN, MaSP, SoLuong, DonGiaNhap) VALUES (?, ?, ?, ?)";
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setInt(1, chiTietHoaDonNhap.getHoaDonNhap().getMaHDN());
        pst.setInt(2, maSP);
        pst.setInt(3, chiTietHoaDonNhap.getSoLuong());
        pst.setDouble(4, chiTietHoaDonNhap.getDonGiaNhap());
        return pst.executeUpdate();
    }

    public static int updateChiTietHoaDonNhap(Connection conn, ChiTietHoaDonNhap CTHDN) throws SQLException {

        String sql = "UPDATE ChiTietHoaDonNhap SET SoLuong = ?, DonGiaNhap = ? WHERE MaCTHDN = ?";
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setInt(1, CTHDN.getSoLuong());
        pst.setDouble(2, CTHDN.getDonGiaNhap());
        pst.setInt(3, CTHDN.getMaCTHDN());
        return pst.executeUpdate();
    }

    public double tongTienByMaHDN(Connection conn, int maHDN) {
        String sql = "SELECT SUM(SoLuong * DonGiaNhap) FROM ChiTietHoaDonNhap WHERE MaHDN = ?";
        double tongTien = 0.0;

        try (PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setInt(1, maHDN);
            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    tongTien = rs.getDouble(1); 
                }
            }
        } catch (SQLException e) {
            System.err.println("Error calculating total price: " + e.getMessage());
        }

        return tongTien;
    }

    public static int deleteChiTietHoaDonNhap(Connection conn, int maCTHDN) throws SQLException {
        String sql = "DELETE FROM ChiTietHoaDonNhap WHERE MaCTHDN = ?";
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setInt(1, maCTHDN);
        return pst.executeUpdate();
    }

    public static int getNextMaCTHDN(Connection conn) throws SQLException {
        String sql = "SELECT MAX(MaCTHDN) as LastID FROM ChiTietHoaDonNhap";
        PreparedStatement pstMax = conn.prepareStatement(sql);
        ResultSet rs = pstMax.executeQuery();
        if (rs.next()) {
            return rs.getInt("LastID");
        }
        return 0;
    }

    public static int getNextMaSP(Connection conn) throws SQLException {
        String sql = "SELECT MAX(MaSP) as LastID FROM SanPham";
        PreparedStatement pstMax = conn.prepareStatement(sql);
        ResultSet rs = pstMax.executeQuery();
        if (rs.next()) {
            return rs.getInt("LastID");
        }
        return 0;
    }

    
    public static List<ChiTietHoaDonNhap> searchChiTietHoaDonNhap(Connection conn, String searchTerm, int maHDN) throws SQLException {
        List<ChiTietHoaDonNhap> listChiTietHoaDonNhaps = new ArrayList<>();
        String sql = "SELECT MaCTHDN, TenSP, SoLuong, c.DonGiaNhap "
                + "FROM ChiTietHoaDonNhap as c INNER JOIN SanPham as s "
                + "ON c.MaSP = s.MaSP "
                + "WHERE C.MaHDN = ? AND TenSP LIKE ?";
        PreparedStatement pst = conn.prepareStatement(sql);

        String searchPattern = "%" + searchTerm + "%";
        pst.setInt(1, maHDN);
        pst.setString(2, searchPattern);

        ResultSet rs = pst.executeQuery();

        while (rs.next()) {
            
           ChiTietHoaDonNhap chiTietHoaDonNhap = new ChiTietHoaDonNhap();
            chiTietHoaDonNhap.setMaCTHDN(rs.getInt("MaCTHDN"));
            SanPham sanPham = new SanPham();
            sanPham.setTenSP(rs.getString("TenSP"));
            chiTietHoaDonNhap.setSanPham(sanPham);
            chiTietHoaDonNhap.setSoLuong(rs.getInt("SoLuong"));
            chiTietHoaDonNhap.setDonGiaNhap(rs.getDouble("DonGiaNhap"));
            listChiTietHoaDonNhaps.add(chiTietHoaDonNhap);
        }
        return listChiTietHoaDonNhaps;
    }
}
