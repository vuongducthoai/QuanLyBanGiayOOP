/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.ChiTietHoaDon;

/**
 *
 * @author DELL
 */
public class ChiTietHoaDonDAO {

    public static List<ChiTietHoaDon> ListChiTietHoaDon(Connection conn) throws SQLException {
        List<ChiTietHoaDon> list = new ArrayList<>();
        String sql = "SELECT * FROM ChiTietHoaDon ";
        PreparedStatement pst = conn.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();

        while (rs.next()) {
            ChiTietHoaDon cthd = new ChiTietHoaDon(
                    rs.getInt("MaCTHD"),
                    rs.getInt("MaHD"),
                    rs.getInt("MaSP"),
                    rs.getInt("SoLuong"),
                    rs.getDouble("DonGiaBan")
            );

            list.add(cthd);
        }
        return list;
    }

    public static int addChiTietHoaDon(Connection conn, ChiTietHoaDon cthd) throws SQLException {
        // Bước 1: Thêm chi tiết hóa đơn vào bảng ChiTietHoaDon
        String sqlInsert = "INSERT INTO ChiTietHoaDon (MaHD, MaSP, SoLuong, DonGiaBan) VALUES (?, ?, ?, ?)";
        PreparedStatement pstInsert = conn.prepareStatement(sqlInsert);

        pstInsert.setInt(1, cthd.getMaHD());
        pstInsert.setInt(2, cthd.getMaSP());
        pstInsert.setInt(3, cthd.getSoLuong());
        pstInsert.setDouble(4, cthd.getDonGiaBan());

        int rowsAffected = pstInsert.executeUpdate();

        // Bước 2: Tính tổng giá trị (DonGiaBan * SoLuong)
        double totalPrice = cthd.getDonGiaBan() * cthd.getSoLuong();

        // Bước 3: Cập nhật giá trị cột TongTien trong bảng HoaDon
        String sqlUpdate = """
        UPDATE HoaDon
        SET TongTien = CASE
            WHEN TongTien IS NULL THEN ?
            ELSE TongTien + ?
        END
        WHERE MaHD = ?
        """;
        PreparedStatement pstUpdate = conn.prepareStatement(sqlUpdate);

        pstUpdate.setDouble(1, totalPrice);
        pstUpdate.setDouble(2, totalPrice);
        pstUpdate.setInt(3, cthd.getMaHD());

        pstUpdate.executeUpdate();

        return rowsAffected;
    }

    public static int deleteChiTietHoaDon(Connection conn, int maCTHD) throws SQLException {
        String sql = "DELETE FROM ChiTietHoaDon WHERE MaCTHD = ?";
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setInt(1, maCTHD);

        return pst.executeUpdate();
    }

    public static int updateChiTietHoaDon(Connection conn, ChiTietHoaDon cthd) throws SQLException {
        String sql = "UPDATE ChiTietHoaDon SET MaHD = ?, MaSP = ?, SoLuong = ?, DonGiaBan = ? WHERE MaCTHD = ?";
        PreparedStatement pst = conn.prepareStatement(sql);

        pst.setInt(1, cthd.getMaHD());
        pst.setInt(2, cthd.getMaSP());
        pst.setInt(3, cthd.getSoLuong());
        pst.setDouble(4, cthd.getDonGiaBan());
        pst.setInt(5, cthd.getMaCTHD());

        return pst.executeUpdate();
    }

    public static List<ChiTietHoaDon> searchChiTietHoaDon(Connection conn, String searchTerm) throws SQLException {
        List<ChiTietHoaDon> list = new ArrayList<>();
        String sql = "SELECT * FROM ChiTietHoaDon WHERE MaCTHD LIKE ? OR MaHD LIKE ? OR MaSP LIKE ? OR SoLuong LIKE ? OR DonGiaBan LIKE ?";
        PreparedStatement pst = conn.prepareStatement(sql);

        String searchPattern = "%" + searchTerm + "%";
        pst.setString(1, searchPattern);
        pst.setString(2, searchPattern);
        pst.setString(3, searchPattern);
        pst.setString(4, searchPattern);
        pst.setString(5, searchPattern);

        ResultSet rs = pst.executeQuery();

        while (rs.next()) {
            ChiTietHoaDon cthd = new ChiTietHoaDon(
                    rs.getInt("MaCTHD"),
                    rs.getInt("MaHD"),
                    rs.getInt("MaSP"),
                    rs.getInt("SoLuong"),
                    rs.getDouble("DonGiaBan")
            );

            list.add(cthd);
        }
        return list;
    }

    public static int getNextMaCTHD(Connection conn) throws SQLException {
        String sqlMax = "SELECT MAX(MaCTHD) FROM ChiTietHoaDon";
        PreparedStatement pstMax = conn.prepareStatement(sqlMax);
        ResultSet rsMax = pstMax.executeQuery();
        int maxMaCTHD = 0;
        if (rsMax.next()) {
            maxMaCTHD = rsMax.getInt(1);
        }
        return maxMaCTHD + 1;
    }
}
