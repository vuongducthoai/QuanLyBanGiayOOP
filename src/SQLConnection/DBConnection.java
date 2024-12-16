/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SQLConnection;

/**
 *
 * @author DELL
 */
import java.sql.*;
public class DBConnection {
    public static Connection getConnection() throws SQLException, ClassNotFoundException
    {
        return SQLServerConnection.initializeDatabase();
    }
}