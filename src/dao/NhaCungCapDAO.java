/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

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

    public static List<NhaCungCap> getNhaCungCapList(Connection conn) throws SQLException {
        String sql = "SELECT * FROM NhaCungCap";
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        List<NhaCungCap> nhaCungCapList = new ArrayList<>();
        while (rs.next()) {
            NhaCungCap nhaCungCap = new NhaCungCap();
            nhaCungCap.setMaNCC(rs.getInt("MaNCC"));
            nhaCungCap.setTenNCC(rs.getString("TenNCC"));
            nhaCungCap.setDiaChi(rs.getString("DiaChi"));
            nhaCungCap.setEmail(rs.getString("Email"));
            nhaCungCap.setSoDT(rs.getString("SoDT"));
            nhaCungCapList.add(nhaCungCap);
        }
        return nhaCungCapList;
    }

    public static void insertSupplier(Connection connection, NhaCungCap nhaCungCap) throws SQLException {
        String sql = "INSERT INTO NhaCungCap(TenNCC, DiaChi, Email, SoDT) VALUES(?, ?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, nhaCungCap.getTenNCC());
        preparedStatement.setString(2, nhaCungCap.getDiaChi());
        preparedStatement.setString(3, nhaCungCap.getEmail());
        preparedStatement.setString(4, nhaCungCap.getSoDT());
        preparedStatement.execute();
    }

    public static void updateSupplier(Connection connection, NhaCungCap nhaCungCap) throws SQLException {
        NhaCungCap nhaCunngCap1 = findNhaCungCap(connection, nhaCungCap.getMaNCC());
        if (nhaCunngCap1 != null) {
            String sql = "UPDATE NhaCungCap SET TenNCC = ?, DiaChi = ?, Email = ?, SoDT = ? WHERE MaNCC = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, nhaCungCap.getTenNCC());
            preparedStatement.setString(2, nhaCungCap.getDiaChi());
            preparedStatement.setString(3, nhaCungCap.getEmail());
            preparedStatement.setString(4, nhaCungCap.getSoDT());
            preparedStatement.setInt(5, nhaCungCap.getMaNCC());
            preparedStatement.executeUpdate();
        } else {
            insertSupplier(connection, nhaCungCap);
        }
    }

    public static NhaCungCap findNhaCungCap(Connection connection, int maNCC) throws SQLException {
        String sql = "SELECT * FROM NhaCungCap WHERE MaNCC = ?";
        PreparedStatement prepareStatement = connection.prepareStatement(sql);
        prepareStatement.setInt(1, maNCC);
        ResultSet rs = prepareStatement.executeQuery();
        NhaCungCap nhaCungCap = null;
        if (rs.next()) {
            nhaCungCap = new NhaCungCap();
            nhaCungCap.setMaNCC(rs.getInt("MaNCC"));
            nhaCungCap.setTenNCC(rs.getString("TenNCC"));
            nhaCungCap.setDiaChi(rs.getString("DiaChi"));
            nhaCungCap.setEmail(rs.getString("Email"));
            nhaCungCap.setSoDT(rs.getString("SoDT"));
        }
        return nhaCungCap;
    }

    public static void deleteNhaCungCap(Connection connection, NhaCungCap nhaCungCap) throws SQLException {
        String sql = "DELETE FROM NhaCungCap WHERE MaNCC = ?";
        PreparedStatement prepareStatement = connection.prepareStatement(sql);
        prepareStatement.setInt(1, nhaCungCap.getMaNCC());
        prepareStatement.execute();
    }

   public static List<NhaCungCap> searchNhaCungCap(Connection connection, String keyword) throws SQLException {
    List<NhaCungCap> list = new ArrayList<>();
    
     String searchKeyword = "%" + keyword + "%";
    
    String sql = "SELECT * FROM NhaCungCap " +
                     "WHERE MaNCC LIKE ? " +
                     "OR TenNCC COLLATE Latin1_General_CI_AI LIKE ? " +
                     "OR SoDT COLLATE Latin1_General_CI_AI LIKE ? " +
                     "OR Email COLLATE Latin1_General_CI_AI LIKE ? " +
                     "OR DiaChi COLLATE Latin1_General_CI_AI LIKE ?";

    try {
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setString(1, searchKeyword);  
        preparedStatement.setString(2, searchKeyword);  
        preparedStatement.setString(3, searchKeyword);  
        preparedStatement.setString(4, searchKeyword); 
        preparedStatement.setString(5, searchKeyword);  

        // Execute the query
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


    public static int getLastSupplierId(Connection connection) throws SQLException {
        String sql = "SELECT MAX(MaNCC) AS LastID FROM NhaCungCap";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet rs = preparedStatement.executeQuery();

        if (rs.next()) {
            return rs.getInt("LastID");
        }
        return 0;
    }

}
