/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.SanPham;
import model.DanhMuc;
import java.sql.PreparedStatement;

/**
 *
 * @author DELL
 */
public class QuanLySanPhamDAO {

    public static List<SanPham> ListSanPham(Connection conn) throws SQLException {
        List<SanPham> list = new ArrayList<>();
        String sql = "SELECT sp.MaSP, sp.TenSP, sp.DonGiaNhap, sp.DonGiaBan, sp.MaDM "
                + "FROM SanPham sp";

        PreparedStatement pst = conn.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();

        while (rs.next()) {
            // Tạo đối tượng SanPham và chỉ cần MaDM
            SanPham sp = new SanPham(
                    rs.getInt("MaSP"),
                    rs.getString("TenSP"),
                    rs.getDouble("DonGiaNhap"),
                    rs.getDouble("DonGiaBan"),
                    new DanhMuc(rs.getInt("MaDM"), "")
            );
            list.add(sp);
        }
        return list;
    }

    public static int addSanPham(Connection conn, SanPham sp) throws SQLException {
        // Lấy mã danh mục từ đối tượng SanPham
        int maDM = sp.getDanhMuc().getMaDM(); // Lấy mã danh mục từ đối tượng DanhMuc trong SanPham

        // Kiểm tra xem mã danh mục có hợp lệ hay không
        if (maDM == 0) {
            throw new SQLException("Mã danh mục không hợp lệ.");
        }

        // Tiến hành chèn sản phẩm vào cơ sở dữ liệu với mã danh mục đã có
        String sql = "INSERT INTO SanPham (TenSP, DonGiaNhap, DonGiaBan, MaDM) VALUES (?, ?, ?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, sp.getTenSP());
            pstmt.setDouble(2, sp.getDonGiaNhap());
            pstmt.setDouble(3, sp.getDonGiaBan());
            pstmt.setInt(4, maDM); // Sử dụng mã danh mục từ đối tượng SanPham
            return pstmt.executeUpdate();
        }
    }

    public static int deleteSanPham(Connection conn, int maSP) throws SQLException {
        String sql = "DELETE FROM SanPham WHERE MaSP = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, maSP);
        return pstmt.executeUpdate();
    }

    public static int updateSanPham(Connection conn, SanPham sp) throws SQLException {
        // SQL Update
        String sql = "UPDATE SanPham SET TenSP = ?, DonGiaNhap = ?, DonGiaBan = ?, MaDM = ? WHERE MaSP = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, sp.getTenSP());
        pstmt.setDouble(2, sp.getDonGiaNhap());
        pstmt.setDouble(3, sp.getDonGiaBan());
        pstmt.setInt(4, sp.getDanhMuc().getMaDM());  // Sử dụng mã danh mục trực tiếp từ đối tượng danh mục
        pstmt.setInt(5, sp.getMaSP());

        return pstmt.executeUpdate();
    }

    public static List<SanPham> searchSanPham(Connection conn, String keyword) throws SQLException {
        String sql = "SELECT sp.MaSP, sp.TenSP, sp.DonGiaNhap, sp.DonGiaBan, dm.MaDM, dm.TenDM "
                + "FROM SanPham sp "
                + "JOIN DanhMuc dm ON sp.MaDM = dm.MaDM "
                + "WHERE sp.MaSP LIKE ? OR sp.TenSP LIKE ? OR sp.DonGiaNhap LIKE ? OR "
                + "sp.DonGiaBan LIKE ? OR dm.MaDM LIKE ? OR dm.TenDM LIKE ?";

        PreparedStatement pstmt = conn.prepareStatement(sql);
        // Gán giá trị keyword cho tất cả các tham số
        pstmt.setString(1, "%" + keyword + "%");
        pstmt.setString(2, "%" + keyword + "%");
        pstmt.setString(3, "%" + keyword + "%");
        pstmt.setString(4, "%" + keyword + "%");
        pstmt.setString(5, "%" + keyword + "%");
        pstmt.setString(6, "%" + keyword + "%");

        ResultSet rs = pstmt.executeQuery();
        List<SanPham> list = new ArrayList<>();

        while (rs.next()) {
            int maSP = rs.getInt("MaSP");
            String tenSP = rs.getString("TenSP");
            double donGiaNhap = rs.getDouble("DonGiaNhap");
            double donGiaBan = rs.getDouble("DonGiaBan");
            int maDM = rs.getInt("MaDM");            

            DanhMuc danhMuc = new DanhMuc(maDM,"");
            SanPham sp = new SanPham(maSP, tenSP, donGiaNhap, donGiaBan, danhMuc);
            list.add(sp);
        }
        return list;
    }

}
