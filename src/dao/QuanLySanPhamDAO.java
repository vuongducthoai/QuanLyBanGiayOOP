/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import SQLConnection.DBConnection;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
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
        String sql = "SELECT sp.MaSP, sp.TenSP, sp.DonGiaNhap, sp.DonGiaBan, sp.MaDM, sp.SoLuong "
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
                    new DanhMuc(rs.getInt("MaDM"), ""),
                    rs.getInt("SoLuong")
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
    
     public static SanPham findSanPhamByTen(Connection connection, String tenSP) throws SQLException{
        String sql = "SELECT * FROM SanPham WHERE TenSP = ?";
        PreparedStatement prepareStatement = connection.prepareStatement(sql);
        prepareStatement.setString(1, tenSP);
        ResultSet rs = prepareStatement.executeQuery();
        SanPham sanPham = null;
        if(rs.next()){
            sanPham = new SanPham();
            sanPham.setTenSP(tenSP);
        }
        return sanPham;
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
            sanPham.setSoLuong(rs.getInt("SoLuong"));
        }
        return sanPham;
    }
     
     public static int updateSoLuongSanPhamByTen(Connection conn, SanPham sp) throws SQLException {
        // SQL Update
        String sql = "UPDATE SanPham SET SoLuong = ? WHERE TenSP = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, sp.getSoLuong());
        pstmt.setString(2, sp.getTenSP());
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

            DanhMuc danhMuc = new DanhMuc(maDM, "");
            SanPham sp = new SanPham(maSP, tenSP, donGiaNhap, donGiaBan, danhMuc);
            list.add(sp);
        }
        return list;
    }

    public static int getNextMaSP(Connection conn) throws SQLException {
        String sqlMax = "SELECT MAX(MaSP) FROM SanPham";
        PreparedStatement pstMax = conn.prepareStatement(sqlMax);
        ResultSet rsMax = pstMax.executeQuery();
        int maxMaSP = 0;
        if (rsMax.next()) {
            maxMaSP = rsMax.getInt(1);
        }
        return maxMaSP + 1;
    }

    public static List<String> getTenDanhMucList(Connection conn) throws SQLException {
        List<String> tenDanhMucList = new ArrayList<>();
        String sql = "SELECT TenDM FROM DanhMuc";
        PreparedStatement pst = conn.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();

        while (rs.next()) {
            tenDanhMucList.add(rs.getString("TenDM"));
        }
        return tenDanhMucList;
    }

    public static int getMaDanhMucByTenDM(Connection conn, String tenDM) throws SQLException {
        String sql = "SELECT MaDM FROM DanhMuc WHERE TenDM = ?";
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setString(1, tenDM);
        ResultSet rs = pst.executeQuery();

        if (rs.next()) {
            return rs.getInt("MaDM");
        }
        throw new SQLException("Không tìm thấy mã danh mục cho tên danh mục: " + tenDM);
    }

    public static String getTenDanhMucByMaDM(Connection conn, int maDM) throws SQLException {
        String sql = "SELECT TenDM FROM DanhMuc WHERE MaDM = ?";
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setInt(1, maDM);
        ResultSet rs = pst.executeQuery();

        if (rs.next()) {
            return rs.getString("TenDM");
        }
        throw new SQLException("Không tìm thấy tên danh mục cho mã danh mục: " + maDM);
    }

    public List<SanPham> getSanPhamBySapXep(String sapXep) throws SQLException, ClassNotFoundException {
        List<SanPham> list = new ArrayList<>();
        String sql = "SELECT * FROM SanPham";

        // Thay đổi câu lệnh SQL dựa vào tùy chọn sắp xếp
        switch (sapXep) {
            case "Giá bán từ thấp đến cao":
                sql += " ORDER BY DonGiaBan ASC";
                break;
            case "Giá bán từ cao đến thấp":
                sql += " ORDER BY DonGiaBan DESC";
                break;
            case "Mã sản phẩm giảm dần":
                sql += " ORDER BY MaSP DESC";
                break;
            default: // Mặc định
                break;
        }

        try (Connection conn = DBConnection.getConnection(); PreparedStatement pst = conn.prepareStatement(sql); ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                SanPham sanPham = new SanPham();
                sanPham.setMaSP(rs.getInt("MaSP"));
                sanPham.setTenSP(rs.getString("TenSP"));
                sanPham.setDonGiaNhap(rs.getDouble("DonGiaNhap"));
                sanPham.setDonGiaBan(rs.getDouble("DonGiaBan"));

                // Gọi phương thức để lấy đối tượng DanhMuc (giả sử có bảng DanhMuc)
                DanhMuc danhMuc = getDanhMucById(conn, rs.getInt("MaDM"));
                sanPham.setDanhMuc(danhMuc);

                list.add(sanPham);
            }
        }
        return list;
    }

// Phương thức bổ trợ để lấy thông tin DanhMuc
    private DanhMuc getDanhMucById(Connection conn, int maDanhMuc) throws SQLException {
        String sql = "SELECT * FROM DanhMuc WHERE MaDM = ?";
        try (PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setInt(1, maDanhMuc);
            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    DanhMuc danhMuc = new DanhMuc();
                    danhMuc.setMaDM(rs.getInt("MaDM"));
                    danhMuc.setTenDM(rs.getString("TenDM"));
                    return danhMuc;
                }
            }
        }
        return null; // Nếu không tìm thấy
    }

    public void xuatFileSanPham(String filePath) throws SQLException, IOException, ClassNotFoundException {
        String sql = "SELECT sp.MaSP, sp.TenSP, sp.DonGiaNhap, sp.DonGiaBan, dm.TenDM "
                + "FROM SanPham sp "
                + "JOIN DanhMuc dm ON sp.MaDM = dm.MaDM";

        try (Connection conn = DBConnection.getConnection(); PreparedStatement pst = conn.prepareStatement(sql); ResultSet rs = pst.executeQuery(); BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {

            // Ghi tiêu đề với căn chỉnh
            writer.write(String.format("%-10s %-30s %-15s %-15s %-20s", "Mã SP", "Tên SP", "Đơn Giá Nhập", "Đơn Giá Bán", "Tên Danh Mục"));
            writer.newLine();

            // Ghi dữ liệu
            while (rs.next()) {
                int maSP = rs.getInt("MaSP");
                String tenSP = rs.getString("TenSP");
                double donGiaNhap = rs.getDouble("DonGiaNhap");
                double donGiaBan = rs.getDouble("DonGiaBan");
                String tenDM = rs.getString("TenDM");

                writer.write(String.format("%-10d %-30s %-15.2f %-15.2f %-20s", maSP, tenSP, donGiaNhap, donGiaBan, tenDM));
                writer.newLine();
            }

            writer.flush();
        }
    }

}
