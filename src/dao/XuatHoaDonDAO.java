/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

/**
 *
 * @author DELL
 */
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import SQLConnection.DBConnection;

public class XuatHoaDonDAO {

    public void exportHoaDonToTxt(int maHD, Connection conn, String filePath) {
        String query = "SELECT HD.MaHD, SP.TenSP, CTHD.SoLuong, NV.TenNV, HD.TongTien "
                + "FROM HoaDon HD "
                + "JOIN ChiTietHoaDon CTHD ON HD.MaHD = CTHD.MaHD "
                + "JOIN SanPham SP ON CTHD.MaSP = SP.MaSP "
                + "JOIN NhanVien NV ON HD.MaNV = NV.MaNV "
                + "WHERE HD.MaHD = ?";

        try (PreparedStatement stmt = conn.prepareStatement(query); BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {

            stmt.setInt(1, maHD);
            ResultSet rs = stmt.executeQuery();

            if (!rs.isBeforeFirst()) {
                System.out.println("No data found for MaHD: " + maHD);
                return;
            }

            writer.write("Hóa Đơn: " + maHD);
            writer.newLine();
            writer.write(String.format("%-30s %-10s %-20s %-10s", "Tên Sản Phẩm", "Số Lượng", "Nhân Viên", "Tổng Tiền"));
            writer.newLine();
            writer.write("------------------------------------------------------------------");
            writer.newLine();

            while (rs.next()) {
                String tenSP = rs.getString("TenSP");
                int soLuong = rs.getInt("SoLuong");
                String tenNV = rs.getString("TenNV");
                double tongTien = rs.getDouble("TongTien");

                writer.write(String.format("%-30s %-10d %-20s %-10.2f", tenSP, soLuong, tenNV, tongTien));
                writer.newLine();
            }

            writer.write("------------------------------------------------------------------");
            writer.newLine();
            writer.write("Cảm ơn quý khách!");

            System.out.println("File hóa đơn đã được xuất tại: " + filePath);
        } catch (IOException e) {
            System.err.println("Lỗi ghi file: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Lỗi truy vấn cơ sở dữ liệu: " + e.getMessage());
        }
    }

}
