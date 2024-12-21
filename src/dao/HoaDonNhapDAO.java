/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import SQLConnection.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.HoaDon;
import model.HoaDonNhap;
import model.NhaCungCap;
import model.NhanVien;

/**
 *
 * @author Asus
 */
public class HoaDonNhapDAO {

    private DBConnection conn = new DBConnection();

    public static List<HoaDonNhap> ListHoaDonNhap(Connection conn) throws SQLException {
        List<HoaDonNhap> list = new ArrayList<>();
        String sql = "SELECT * FROM HoaDonNhap";
        PreparedStatement pst = conn.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        DecimalFormat df = new DecimalFormat("#,###");
        while (rs.next()) {
            int maHDN = rs.getInt("MaHDN");
            int maNCC = rs.getInt("MaNCC");
            Date ngayNhap = rs.getDate("NgayNhap");
            double tongTien = rs.getDouble("TongTien");
            int maNV = rs.getInt("MaNV");
            String trangThai = rs.getString("TrangThai");
            String formattedTongTien = df.format(tongTien);
            NhaCungCap nhaCungCap = findNhaCungCapByMaNCC(conn, maNCC);
            NhanVien nhanVien = findNhanVienByMaNV(conn, maNV);

            HoaDonNhap hoaDonNhap = new HoaDonNhap(maHDN, nhaCungCap, nhanVien, ngayNhap, formattedTongTien, trangThai);

            list.add(hoaDonNhap);
        }

        return list;
    }

    public static List<HoaDonNhap> thongKe(Connection conn) throws SQLException {
        List<HoaDonNhap> list = new ArrayList<>();
        String sql = "SELECT NgayNhap, TongTien FROM HoaDonNhap WHERE TrangThai LIKE N'ĐÃ THANH TOÁN' ORDER BY NgayNhap;";
        PreparedStatement pst = conn.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        DecimalFormat df = new DecimalFormat("#,###");
        while (rs.next()) {
            Date ngayNhap = rs.getDate("NgayNhap");
            double tongTien = rs.getDouble("TongTien");
            String formattedTongTien = df.format(tongTien);

            HoaDonNhap hoaDonNhap = new HoaDonNhap();
            hoaDonNhap.setNgayNhap(ngayNhap);
            hoaDonNhap.setFormatTongTien(formattedTongTien);
            list.add(hoaDonNhap);
        }

        return list;
    }
    
        public static List<HoaDon> thongKeHD(Connection conn) throws SQLException {
        List<HoaDon> list = new ArrayList<>();
        String sql = "SELECT NgayMua, TongTien FROM HoaDon WHERE TrangThai LIKE N'ĐÃ THANH TOÁN' ORDER BY NgayMua;";
        PreparedStatement pst = conn.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        DecimalFormat df = new DecimalFormat("#,###");
        while (rs.next()) {
            Date ngayMua = rs.getDate("NgayMua");
            double tongTien = rs.getDouble("TongTien");
//            String formattedTongTien = df.format(tongTien);

            HoaDon hoaDon = new HoaDon();
            hoaDon.setNgayMua(ngayMua);
            hoaDon.setTongTien(tongTien);
            list.add(hoaDon);
        }

        return list;
    }

    public static List<HoaDonNhap> thongKeByMonthOrYear(Connection conn, int month, int year) throws SQLException {
        List<HoaDonNhap> list = new ArrayList<>();
        String sql = "SELECT NgayNhap, TongTien FROM HoaDonNhap WHERE TrangThai LIKE N'ĐÃ THANH TOÁN' AND MONTH(NgayNhap) = ? AND YEAR(NgayNhap) = ? ORDER BY NgayNhap;";
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setInt(1, month);
        pst.setInt(2, year);
        ResultSet rs = pst.executeQuery();
        DecimalFormat df = new DecimalFormat("#,###");
        while (rs.next()) {
            Date ngayNhap = rs.getDate("NgayNhap");
            double tongTien = rs.getDouble("TongTien");
            String formattedTongTien = df.format(tongTien);

            HoaDonNhap hoaDonNhap = new HoaDonNhap();
            hoaDonNhap.setNgayNhap(ngayNhap);
            hoaDonNhap.setFormatTongTien(formattedTongTien);
            list.add(hoaDonNhap);
        }

        return list;
    }
    
      public static List<HoaDon> thongKeHDByMonthOrYear(Connection conn, int month, int year) throws SQLException {
        List<HoaDon> list = new ArrayList<>();
        String sql = "SELECT NgayMua, TongTien FROM HoaDon WHERE TrangThai LIKE N'ĐÃ THANH TOÁN' AND MONTH(NgayMua) = ? AND YEAR(NgayMua) = ?  ORDER BY NgayMua;";
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setInt(1, month);
        pst.setInt(2, year);
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            Date ngayMua = rs.getDate("NgayMua");
            double tongTien = rs.getDouble("TongTien");
            HoaDon hoaDon = new HoaDon();
            hoaDon.setNgayMua(ngayMua);
            hoaDon.setTongTien(tongTien);
            list.add(hoaDon);
        }
        return list;
    }
    
    

    public static NhaCungCap findNhaCungCapByMaNCC(Connection conn, int maNCC) throws SQLException {
        NhaCungCap nhaCungCap = null;
        String sql = "SELECT * FROM NhaCungCap WHERE MaNCC = ?";
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setInt(1, maNCC);
        ResultSet rs = pst.executeQuery();

        if (rs.next()) {
            String tenNCC = rs.getString("TenNCC");

            nhaCungCap = new NhaCungCap();
            nhaCungCap.setMaNCC(maNCC);
            nhaCungCap.setTenNCC(tenNCC);
        }
        return nhaCungCap;
    }

    public static HoaDonNhap findHoaDonNhapByMaHDN(Connection conn, int maHDN) throws SQLException {
        HoaDonNhap hoaDonNhap = null;
        String sql = "SELECT * FROM HoaDonNhap WHERE maHDN = ?";
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setInt(1, maHDN);
        ResultSet rs = pst.executeQuery();

        if (rs.next()) {
            hoaDonNhap = new HoaDonNhap();
            NhaCungCap nhaCungCap = new NhaCungCap();
            nhaCungCap.setMaNCC(rs.getInt("MaNCC"));
            NhanVien nhanVien = new NhanVien();
            nhanVien.setMaNV(rs.getInt("MaNV"));
            hoaDonNhap.setNhaCungCap(nhaCungCap);
            hoaDonNhap.setNhanVien(nhanVien);
            hoaDonNhap.setTongTien(rs.getDouble("TongTien"));
            hoaDonNhap.setTrangThai(rs.getString("TrangThai"));
            hoaDonNhap.setNgayNhap(rs.getDate("NgayNhap"));
        }
        return hoaDonNhap;
    }

    public static NhanVien findNhanVienByMaNV(Connection conn, int maNV) throws SQLException {
        NhanVien nhanVien = null;
        String sql = "SELECT * FROM NhanVien WHERE MaNV = ?";
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setInt(1, maNV); // Gán mã nhân viên vào câu truy vấn
        ResultSet rs = pst.executeQuery();

        if (rs.next()) {
            String tenNV = rs.getString("TenNV");

            nhanVien = new NhanVien();
            nhanVien.setMaNV(maNV);
            nhanVien.setTen(tenNV);
        }
        return nhanVien;
    }

    public static int addHoaDonNhap(Connection conn, HoaDonNhap hoaDonNhap) throws SQLException {
        String sql = "INSERT INTO HoaDonNhap (MaNCC, NgayNhap, MaNV, TrangThai) VALUES (?, ?, ?, ?)";
        PreparedStatement pst = conn.prepareStatement(sql);

        pst.setInt(1, hoaDonNhap.getNhaCungCap().getMaNCC());
        pst.setDate(2, new java.sql.Date(hoaDonNhap.getNgayNhap().getTime()));
        pst.setDouble(3, hoaDonNhap.getNhanVien().getMaNV());
        pst.setString(4, hoaDonNhap.getTrangThai());

        return pst.executeUpdate();
    }

    public static int deleteHoaDonNhap(Connection conn, int maHDN) throws SQLException {
        String sql = "DELETE FROM HoaDonNhap WHERE MaHDN = ?";
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setInt(1, maHDN);
        return pst.executeUpdate();
    }

    public static int updateHoaDonNhap(Connection conn, HoaDonNhap hoaDonNhap) throws SQLException {
        String sql = "UPDATE HoaDonNhap SET MaNCC = ?, NgayNhap = ?, TongTien = ?,MaNV = ?, TrangThai = ? WHERE MaHDN = ?";
        PreparedStatement pst = conn.prepareStatement(sql);

        pst.setInt(1, hoaDonNhap.getNhaCungCap().getMaNCC());
        pst.setDate(2,  new java.sql.Date(hoaDonNhap.getNgayNhap().getTime()));
        pst.setDouble(3, hoaDonNhap.getTongTien());
        pst.setDouble(4, hoaDonNhap.getNhanVien().getMaNV());
        pst.setString(5, hoaDonNhap.getTrangThai());
        pst.setInt(6, hoaDonNhap.getMaHDN());

        return pst.executeUpdate();
    }

    public static List<HoaDonNhap> searchHoaDonNhap(Connection conn, String searchTerm) throws SQLException {
        List<HoaDonNhap> list = new ArrayList<>();

        // Câu lệnh SQL với JOIN để kết hợp ba bảng: HoaDonNhap, NhaCungCap, NhanVien
        String sql = "SELECT h.MaHDN, n.MaNCC, n.TenNCC, nv.MaNV, nv.TenNV, h.NgayNhap, h.TongTien, h.TrangThai "
                + "FROM HoaDonNhap h "
                + "JOIN NhaCungCap n ON h.MaNCC = n.MaNCC "
                + "JOIN NhanVien nv ON h.MaNV = nv.MaNV "
                + "WHERE CAST(h.MaHDN AS CHAR) LIKE ? "
                + "OR n.TenNCC COLLATE Latin1_General_CI_AI LIKE ? "
                + "OR nv.TenNV COLLATE Latin1_General_CI_AI LIKE ? "
                + "OR h.TrangThai COLLATE Latin1_General_CI_AI LIKE ? "
                + "OR CAST(h.TongTien AS CHAR) LIKE ? "
                + "OR CAST(h.NgayNhap AS CHAR) LIKE ?";

        PreparedStatement pst = conn.prepareStatement(sql);

        String searchPattern = "%" + searchTerm + "%";

        // Gán giá trị tham số cho PreparedStatement
        pst.setString(1, searchPattern);
        pst.setString(2, searchPattern);
        pst.setString(3, searchPattern);
        pst.setString(4, searchPattern);
        pst.setString(5, searchPattern);
        pst.setString(6, searchPattern);

        ResultSet rs = pst.executeQuery();

        while (rs.next()) {
            // Tạo đối tượng NhaCungCap
            NhaCungCap nhaCungCap = new NhaCungCap();
            nhaCungCap.setMaNCC(rs.getInt("MaNCC"));
            nhaCungCap.setTenNCC(rs.getString("TenNCC"));

            // Tạo đối tượng NhanVien
            NhanVien nhanVien = new NhanVien();
            nhanVien.setMaNV(rs.getInt("MaNV"));
            nhanVien.setTen(rs.getString("TenNV"));

            // Tạo đối tượng HoaDonNhap
            HoaDonNhap hoaDonNhap = new HoaDonNhap(
                    rs.getInt("MaHDN"),
                    nhaCungCap,
                    nhanVien,
                    rs.getDate("NgayNhap"),
                    rs.getDouble("TongTien"),
                    rs.getString("TrangThai")
            );

            // Thêm vào danh sách kết quả
            list.add(hoaDonNhap);
        }

        return list;
    }

    public static int getNextMaHDN(Connection conn) throws SQLException {
        String sqlMax = "SELECT MAX(MaHDN) FROM HoaDonNhap";
        PreparedStatement pstMax = conn.prepareStatement(sqlMax);
        ResultSet rsMax = pstMax.executeQuery();
        int maxMaHDN = 0;
        if (rsMax.next()) {
            maxMaHDN = rsMax.getInt(1);
        }
        return maxMaHDN + 1;
    }
}
