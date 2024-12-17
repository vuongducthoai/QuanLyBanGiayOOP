/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import SQLConnection.DBConnection;
import java.sql.*;

/**
 *
 * @author ADMIN
 */
public class TaiKhoanDAO {
    
    Connection connection = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    public TaiKhoanDAO() {
    }
    
    public boolean checkTenTaiKhoan(String tenTK) {
        
        try {
            
            connection = DBConnection.getConnection();
            
            
            String sql = "SELECT * FROM TaiKhoan WHERE TenTK = ?";
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
        
        return false;
    }
    
}
