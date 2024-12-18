/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SQLConnection;

/**
 *
 * @author DELL
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLServerConnection {

    public static Connection initializeDatabase() throws SQLException, ClassNotFoundException {
        String dbDriver = "com.microsoft.sqlserver." + "jdbc.SQLServerDriver";
        String dbURL = "jdbc:sqlserver://localhost:1433";
        String dbName = "QuanLyCuaHangBanGiay";
        String dbUsername = "sa";
        String dbPassword = "Thoai12309@";

        String connectionURL = dbURL + ";databaseName=" + dbName + ";encrypt=true;trustServerCertificate=true";
        Connection conn = null;
        try {
            Class.forName(dbDriver);
            conn = DriverManager.getConnection(connectionURL, dbUsername, dbPassword);
            System.out.println("connect successfully!");
        } catch (Exception ex) {
            System.out.println("connect failure!");
            ex.printStackTrace();
            System.out.println(ex.getMessage());
        }
        return conn;
    }
}
