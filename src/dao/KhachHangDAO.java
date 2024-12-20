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
import model.KhachHang;

/**
 *
 * @author DELL
 */
public class KhachHangDAO {

    public static List<KhachHang> ListKhachHang(Connection conn) throws SQLException {
        List<KhachHang> list = new ArrayList<>();
        String sql = "SELECT * FROM KhachHang ";
        PreparedStatement pst = conn.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();

        while (rs.next()) {
            KhachHang kh = new KhachHang(
                    rs.getInt("MaKH"),
                    rs.getString("TenKH"),
                    rs.getString("DiaChi"),
                    rs.getString("Email"),
                    rs.getString("SoDT"),
                    rs.getString("GioiTinh")
            );

            list.add(kh);
        }
        return list;
    }

    public static int addKhachHang(Connection conn, KhachHang kh) throws SQLException {
        // Câu lệnh INSERT không bao gồm cột MaKH vì SQL Server sẽ tự động tạo giá trị cho cột này
        String sql = "INSERT INTO KhachHang (TenKH, DiaChi, Email, SoDT, GioiTinh) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement pst = conn.prepareStatement(sql);

        pst.setString(1, kh.getTen());
        pst.setString(2, kh.getDiaChi());
        pst.setString(3, kh.getEmail());
        pst.setString(4, kh.getSoDT());
        pst.setString(5, kh.getGioiTinh());

        return pst.executeUpdate();
    }

    public static int deleteKhachHang(Connection conn, int maKH) throws SQLException {
        String sql = "DELETE FROM KhachHang WHERE MaKH = ?";
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setInt(1, maKH);
        return pst.executeUpdate();
    }

    public static int updateKhachHang(Connection conn, KhachHang kh) throws SQLException {
        String sql = "UPDATE KhachHang SET TenKH = ?, DiaChi = ?, Email = ?, SoDT = ?, GioiTinh = ? WHERE MaKH = ?";
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setString(1, kh.getTen());
        pst.setString(2, kh.getDiaChi());
        pst.setString(3, kh.getEmail());
        pst.setString(4, kh.getSoDT());
        pst.setString(5, kh.getGioiTinh());
        pst.setInt(6, kh.getMaKH());
        return pst.executeUpdate();
    }

    public static List<KhachHang> searchKhachHang(Connection conn, String searchTerm) throws SQLException {
        List<KhachHang> list = new ArrayList<>();
        String sql = "SELECT * FROM KhachHang WHERE MaKH LIKE ? OR TenKH LIKE ? OR DiaChi LIKE ? OR Email LIKE ? OR SoDT LIKE ? OR GioiTinh LIKE ?";
        PreparedStatement pst = conn.prepareStatement(sql);
        String searchPattern = "%" + searchTerm + "%";
        pst.setString(1, searchPattern);
        pst.setString(2, searchPattern);
        pst.setString(3, searchPattern);
        pst.setString(4, searchPattern);
        pst.setString(5, searchPattern);
        pst.setString(6, searchPattern);
        ResultSet rs = pst.executeQuery();

        while (rs.next()) {
            KhachHang kh = new KhachHang(
                    rs.getInt("MaKH"),
                    rs.getString("TenKH"),
                    rs.getString("DiaChi"),
                    rs.getString("Email"),
                    rs.getString("SoDT"),
                    rs.getString("GioiTinh")
            );
            list.add(kh);
        }
        return list;
    }

    public static int getNextMaKH(Connection conn) throws SQLException {
        String sqlMax = "SELECT MAX(MaKH) FROM KhachHang";
        PreparedStatement pstMax = conn.prepareStatement(sqlMax);
        ResultSet rsMax = pstMax.executeQuery();
        int maxMaKH = 0;
        if (rsMax.next()) {
            maxMaKH = rsMax.getInt(1);  // Lấy giá trị MaKH lớn nhất
        }
        return maxMaKH + 1; // Trả về mã khách hàng tiếp theo
    }
}
