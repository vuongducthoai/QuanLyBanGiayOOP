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
import model.HoaDon;

/**
 *
 * @author DELL
 */
public class HoaDonDAO {

    public static List<HoaDon> ListHoaDon(Connection conn) throws SQLException {
        List<HoaDon> list = new ArrayList<>();
        String sql = "SELECT * FROM HoaDon ";
        PreparedStatement pst = conn.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();

        while (rs.next()) {
            HoaDon hd = new HoaDon(
                    rs.getInt("MaHD"),
                    rs.getInt("MaKH"),
                    rs.getInt("MaNV"),
                    rs.getDate("NgayMua"),
                    rs.getString("TrangThai"),
                    rs.getString("PTTT"),
                    rs.getDouble("TongTien")
            );

            list.add(hd);
        }
        return list;
    }

    public static int addHoaDon(Connection conn, HoaDon hd) throws SQLException {
        String sql = "INSERT INTO HoaDon (MaKH, MaNV, NgayMua, TrangThai, PTTT, TongTien) VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement pst = conn.prepareStatement(sql);

        pst.setInt(1, hd.getMaKH());
        pst.setInt(2, hd.getMaNV());
        pst.setDate(3, new java.sql.Date(hd.getNgayMua().getTime()));
        pst.setString(4, hd.getTrangThai());
        pst.setString(5, hd.getpTTT());
        pst.setDouble(6, hd.getTongTien());

        return pst.executeUpdate();
    }

    public static int deleteHoaDon(Connection conn, int maHD) throws SQLException {
        String sql = "DELETE FROM HoaDon WHERE MaHD = ?";
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setInt(1, maHD);

        return pst.executeUpdate();
    }

    public static int updateHoaDon(Connection conn, HoaDon hd) throws SQLException {
        String sql = "UPDATE HoaDon SET MaKH = ?, MaNV = ?, NgayMua = ?, TrangThai = ?, PTTT = ?, TongTien = ? WHERE MaHD = ?";
        PreparedStatement pst = conn.prepareStatement(sql);

        pst.setInt(1, hd.getMaKH());
        pst.setInt(2, hd.getMaNV());
        pst.setDate(3, new java.sql.Date(hd.getNgayMua().getTime()));
        pst.setString(4, hd.getTrangThai());
        pst.setString(5, hd.getpTTT());
        pst.setDouble(6, hd.getTongTien());
        pst.setInt(7, hd.getMaHD());

        return pst.executeUpdate();
    }

    public static List<HoaDon> searchHoaDon(Connection conn, String searchTerm) throws SQLException {
        List<HoaDon> list = new ArrayList<>();
        String sql = "SELECT * FROM HoaDon WHERE MaHD LIKE ? OR MaKH LIKE ? OR MaNV LIKE ? OR TrangThai LIKE ? OR PTTT LIKE ?";
        PreparedStatement pst = conn.prepareStatement(sql);

        String searchPattern = "%" + searchTerm + "%";
        pst.setString(1, searchPattern);
        pst.setString(2, searchPattern);
        pst.setString(3, searchPattern);
        pst.setString(4, searchPattern);
        pst.setString(5, searchPattern);

        ResultSet rs = pst.executeQuery();

        while (rs.next()) {
            HoaDon hd = new HoaDon(
                    rs.getInt("MaHD"),
                    rs.getInt("MaKH"),
                    rs.getInt("MaNV"),
                    rs.getDate("NgayMua"),
                    rs.getString("TrangThai"),
                    rs.getString("PTTT"),
                    rs.getDouble("TongTien")
            );

            list.add(hd);
        }
        return list;
    }
    public static int getNextMaHD(Connection conn) throws SQLException {
        String sqlMax = "SELECT MAX(MaHD) FROM HoaDon";
        PreparedStatement pstMax = conn.prepareStatement(sqlMax);
        ResultSet rsMax = pstMax.executeQuery();
        int maxMaHD = 0;
        if (rsMax.next()) {
            maxMaHD = rsMax.getInt(1);  // Lấy giá trị MaHD lớn nhất
        }
        return maxMaHD + 1;
    }
}
