/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import SQLConnection.DBConnection;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.TaiKhoan;

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
        boolean exists = false;
        try {

            connection = DBConnection.getConnection();

            String sql = "SELECT * FROM TaiKhoan WHERE TenTK = ?";

            ps = connection.prepareStatement(sql);
            ps.setString(1, tenTK);

            rs = ps.executeQuery();

            if (rs.next()) {
                exists = true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(TaiKhoanDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TaiKhoanDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return exists;
    }

    public boolean checkTaiKhoan(String tenTK, String matKhau) {
        boolean exists = false;
        try {

            connection = DBConnection.getConnection();

            String sql = "SELECT * FROM TaiKhoan WHERE TenTK = ? AND MatKhau = ?";

            ps = connection.prepareStatement(sql);
            ps.setString(1, tenTK);
            ps.setString(2, matKhau);

            rs = ps.executeQuery();

            if (rs.next()) {
                exists = true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(TaiKhoanDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TaiKhoanDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return exists;
    }

    // Lấy thông tin cá nhân khi đăng nhập
    public TaiKhoan getThongTinTaiKhoan(String tenTK) {
        TaiKhoan tk = null;

        try {
            connection = DBConnection.getConnection();

            String sql = "SELECT * FROM TaiKhoan WHERE TenTK = ?";
            ps = connection.prepareStatement(sql);
            ps.setString(1, tenTK);

            rs = ps.executeQuery();

            while (rs.next()) {
                tk = new TaiKhoan();
                tk.setTenTK(rs.getString("TenTK"));
                tk.setMatKhau(rs.getString("MatKhau"));
                tk.setChucVu(rs.getString("ChucVu"));
                tk.setMaNV(rs.getInt("MaNV"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(TaiKhoanDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TaiKhoanDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return tk;
    }

    public TaiKhoan getTaiKhoanByMaNV(int maNV) {
        TaiKhoan tk = null;

        try {
            connection = DBConnection.getConnection();

            String sql = "SELECT TenTK, MatKhau, ChucVu FROM TaiKhoan WHERE MaNV = ?";
            ps = connection.prepareStatement(sql);
            ps.setInt(1, maNV);

            rs = ps.executeQuery();

            while (rs.next()) {
                tk = new TaiKhoan();
                tk.setTenTK(rs.getString("TenTK"));
                tk.setMatKhau(rs.getString("MatKhau"));
                tk.setChucVu(rs.getString("ChucVu"));
                tk.setMaNV(maNV);
            }

        } catch (SQLException ex) {
            Logger.getLogger(TaiKhoanDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TaiKhoanDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return tk;
    }

    public int addTaiKhoan(TaiKhoan tk) {
        try {
            String sql = "INSERT INTO TaiKhoan (TenTK, MatKhau, ChucVu, MaNV) VALUES (?, ?, ?, ?)";

            connection = DBConnection.getConnection();

            ps = connection.prepareStatement(sql);
            ps.setString(1, tk.getTenTK());
            ps.setString(2, tk.getMatKhau());
            ps.setString(3, tk.getChucVu());
            ps.setInt(4, tk.getMaNV());

            return ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    public int capNhapTaiKhoan(TaiKhoan tk) {
        try {
            String sql = "UPDATE TaiKhoan SET ";

            int index = 1;
            if (tk.getMatKhau().trim().length() > 0) {
                sql += " MatKhau = ?,";
            }

            sql += " ChucVu = ? WHERE TenTK = ? AND MaNV = ?";

            connection = DBConnection.getConnection();

            ps = connection.prepareStatement(sql);

            if (tk.getMatKhau().trim().length() > 0) {
                ps.setString(index++, tk.getMatKhau());
            }

            ps.setString(index++, tk.getChucVu());
            ps.setString(index++, tk.getTenTK());
            ps.setInt(index, tk.getMaNV());

            return ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    public int xoaTaiKhoan(int maNV) {
        try {
            connection = DBConnection.getConnection();

            String sql = "DELETE TaiKhoan WHERE MaNV = ?";
            ps = connection.prepareStatement(sql);

            ps.setInt(1, maNV);

            return ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(TaiKhoanDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TaiKhoanDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return 0;
    }

    public static void main(String[] args) throws ClassNotFoundException {
        TaiKhoanDAO dao = new TaiKhoanDAO();
        System.out.println(dao.getTaiKhoanByMaNV(1));
    }
}
