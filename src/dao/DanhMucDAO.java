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
import model.DanhMuc;
import model.NhaCungCap;
/**
 *
 * @author Asus
 */
public class DanhMucDAO {
     public static List<DanhMuc> getDanhMucList(Connection conn) throws SQLException {
        String sql = "SELECT * FROM DanhMuc";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
             List<DanhMuc> danhMucList = new ArrayList<>();
            while (rs.next()) {
                DanhMuc danhMuc = new DanhMuc();
                danhMuc.setMaDM(rs.getInt("MaDM"));
                danhMuc.setTenDM(rs.getString("TenDM"));
                danhMucList.add(danhMuc);
            }
        return danhMucList;
    }
     
     public static void insertDanhMuc(Connection connection, DanhMuc danhMuc) throws SQLException{
        String sql = "INSERT INTO DanhMuc VALUES (?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, danhMuc.getTenDM());
        preparedStatement.execute();
    }
     
         public static void updateDanhMuc(Connection connection, DanhMuc danhMuc) throws SQLException {
            DanhMuc danhMuc1 = findDanhMucById(connection, danhMuc.getMaDM());
            if(danhMuc1 != null){
                String sql = "UPDATE DanhMuc SET TenDM = ? WHERE MaDM = ?";
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, danhMuc.getTenDM());
                preparedStatement.setInt(2, danhMuc.getMaDM());
                 preparedStatement.executeUpdate();
            } else{
                insertDanhMuc(connection, danhMuc);
            }
    }
    
    public static DanhMuc findDanhMucById(Connection connection, int maDM) throws SQLException{
        String sql = "SELECT * FROM DanhMuc WHERE MaDM = ?";
        PreparedStatement prepareStatement = connection.prepareStatement(sql);
        prepareStatement.setInt(1, maDM);
        ResultSet rs = prepareStatement.executeQuery();
        DanhMuc danhMuc = null;
        if(rs.next()){
            danhMuc = new DanhMuc();
            danhMuc.setMaDM(maDM);
        }
        return danhMuc;
    }
    
    public static DanhMuc findDanhMucByTen(Connection connection, String tenDM) throws SQLException{
        String sql = "SELECT * FROM DanhMuc WHERE TenDM = ?";
        PreparedStatement prepareStatement = connection.prepareStatement(sql);
        prepareStatement.setString(1, tenDM);
        ResultSet rs = prepareStatement.executeQuery();
        DanhMuc danhMuc = null;
        if(rs.next()){
            danhMuc = new DanhMuc();
            danhMuc.setTenDM(tenDM);
        }
        return danhMuc;
    }
    
    public static void deleteDanhMuc(Connection connection, DanhMuc danhMuc) throws SQLException{
        String sql = "DELETE FROM DanhMuc WHERE MaDM = ?";
        PreparedStatement prepareStatement = connection.prepareStatement(sql);
        prepareStatement.setInt(1, danhMuc.getMaDM());
        prepareStatement.execute();
    }
    
    public static List<DanhMuc> searchDanhMuc(Connection connection, String keyword) throws SQLException {
        List<DanhMuc> list = new ArrayList<>();
        String sql = "SELECT * FROM DanhMuc WHERE MaDM LIKE ? OR TenDM COLLATE Latin1_General_CI_AI LIKE ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            // Dùng '%' để tìm kiếm gần đúng (LIKE)
            preparedStatement.setString(1, "%" + keyword + "%"); // Tìm theo MaNCC
            preparedStatement.setString(2, "%" + keyword + "%"); // Tìm theo TenNCC

            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                DanhMuc danhMuc = new DanhMuc();
                danhMuc.setMaDM(rs.getInt("MaDM"));
                danhMuc.setTenDM(rs.getString("TenDM"));

                list.add(danhMuc);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    
    
     public static int getLastCategoryId(Connection connection) throws SQLException {
        String sql = "SELECT MAX(MaDM) AS LastID FROM DanhMuc";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet rs = preparedStatement.executeQuery();

        if (rs.next()) {
            return rs.getInt("LastID");
        }
        return 0;
    }

}
