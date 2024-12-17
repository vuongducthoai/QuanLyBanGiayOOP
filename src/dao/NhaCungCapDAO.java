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
import java.util.ArrayList;
import java.util.List;
import model.NhaCungCap;

/**
 *
 * @author Asus
 */
public class NhaCungCapDAO {
    public static List<String[]> getNhaCungCapList(Connection conn) {
        List<String[]> list = new ArrayList<>();
        String sql = "SELECT * FROM NhaCungCap";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new String[]{
                    String.valueOf(rs.getInt("MaNCC")),
                    rs.getString("TenNCC"),
                    rs.getString("DiaChi"),
                    rs.getString("Email"),
                    rs.getString("SoDT")
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public static void insertSupplier(Connection connection, NhaCungCap nhaCungCap) throws SQLException{
        String sql = "INSERT INTO NhaCungCap(?, ?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, nhaCungCap.getTenNCC());
        preparedStatement.setString(2, nhaCungCap.getDiaChi());
        preparedStatement.setString(3, nhaCungCap.getEmail());
        preparedStatement.setString(4, nhaCungCap.getSoDT());
        preparedStatement.execute();
    }
    
    public static void updateSupplier(Connection connection, NhaCungCap nhaCungCap) throws SQLException {
        NhaCungCap nhaCunngCap1 = findNhaCungCap(connection, nhaCungCap.getMaNCC());
        if(nhaCunngCap1 != null){
            String sql = "UPDATE NhaCungCap SET TenNCC = ?, DiaChi = ?, Email = ?, SoDT = ? WHERE MaNCC = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, nhaCungCap.getTenNCC());
            preparedStatement.setString(2, nhaCungCap.getDiaChi());
            preparedStatement.setString(3, nhaCungCap.getEmail());
            preparedStatement.setString(4, nhaCungCap.getSoDT());
            preparedStatement.setInt(5, nhaCungCap.getMaNCC());
        } else{
            insertSupplier(connection, nhaCungCap);
        }
    }
    
    public static NhaCungCap findNhaCungCap(Connection connection, int maNCC) throws SQLException{
        String sql = "SELECT * FROM NhaCungCap WHERE MaNCC = ?";
        PreparedStatement prepareStatement = connection.prepareStatement(sql);
        prepareStatement.setInt(1, maNCC);
        ResultSet rs = prepareStatement.executeQuery();
        NhaCungCap nhaCungCap = null;
        if(rs.next()){
            nhaCungCap = new NhaCungCap();
            nhaCungCap.setMaNCC(maNCC);
        }
        return nhaCungCap;
    }
    
    public static void deleteNhaCungCap(Connection connection, NhaCungCap nhaCungCap) throws SQLException{
        String sql = "DELETE FROM NhaCungCap WHERE MaNCC = ?";
        PreparedStatement prepareStatement = connection.prepareStatement(sql);
        prepareStatement.setInt(1, nhaCungCap.getMaNCC());
        prepareStatement.execute();
    }
    
    public static List<NhaCungCap> searchNhaCungCap(Connection connection, String keyword) throws SQLException {
    List<NhaCungCap> list = new ArrayList<>();
    String sql = "SELECT * FROM NhaCungCap WHERE MaNCC LIKE ? OR TenNCC LIKE ? OR SoDT LIKE ? OR Email LIKE ?";
    try {
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        
        // Dùng '%' để tìm kiếm gần đúng (LIKE)
        preparedStatement.setString(1, "%" + keyword + "%"); // Tìm theo MaNCC
        preparedStatement.setString(2, "%" + keyword + "%"); // Tìm theo TenNCC
        preparedStatement.setString(3, "%" + keyword + "%"); // Tìm theo SoDT
        preparedStatement.setString(4, "%" + keyword + "%"); // Tìm theo Email
        
        ResultSet rs = preparedStatement.executeQuery();
        while (rs.next()) {
            NhaCungCap nhaCungCap = new NhaCungCap();
            nhaCungCap.setMaNCC(rs.getInt("MaNCC"));
            nhaCungCap.setTenNCC(rs.getString("TenNCC"));
            nhaCungCap.setDiaChi(rs.getString("DiaChi"));
            nhaCungCap.setEmail(rs.getString("Email"));
            nhaCungCap.setSoDT(rs.getString("SoDT"));
            
            list.add(nhaCungCap);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return list;
}

}