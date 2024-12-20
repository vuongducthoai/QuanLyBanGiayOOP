/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import SQLConnection.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.NhanVien;

/**
 *
 * @author ADMIN
 */
public class NhanVienDAO {

    Connection connection = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public NhanVienDAO() {
    }

    public NhanVien getNhanVienByMaNV(int maNV) {
        NhanVien nv = null;

        try {
            connection = DBConnection.getConnection();

            String sql = "SELECT * FROM NhanVien WHERE MaNV = ?";
            ps = connection.prepareStatement(sql);
            ps.setInt(1, maNV);

            rs = ps.executeQuery();

            while (rs.next()) {
                nv = new NhanVien();
                nv.setMaNV(rs.getInt("MaNV"));
                nv.setTen(rs.getString("TenNV"));
                nv.setGioiTinh(rs.getString("GioiTinh"));
                nv.setDiaChi(rs.getString("DiaChi"));
                nv.setEmail(rs.getString("Email"));
                nv.setSoDT(rs.getString("SoDT"));
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

        return nv;
    }

    public List<NhanVien> getAllNhanVien() throws ClassNotFoundException {
        List<NhanVien> dsNhanVien = new ArrayList<>();

        try {
            connection = DBConnection.getConnection();
            String sql = "SELECT * FROM NhanVien nv ";

            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            NhanVien nv = null;
            while (rs.next()) {

                nv = new NhanVien();
                nv.setMaNV(rs.getInt("MaNV"));
                nv.setTen(rs.getString("TenNV"));
                nv.setGioiTinh(rs.getString("GioiTinh"));
                nv.setDiaChi(rs.getString("DiaChi"));
                nv.setEmail(rs.getString("Email"));
                nv.setSoDT(rs.getString("SoDT"));

                dsNhanVien.add(nv);
            }

        } catch (SQLException e) {
            e.printStackTrace();
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
        return dsNhanVien;
    }

    public int addNhanVien(NhanVien nhanVien) {
        try {
            String sql = "INSERT INTO NhanVien (TenNV, GioiTinh, DiaChi, Email, SoDT) VALUES (?, ?, ?, ?, ?)";

            connection = DBConnection.getConnection();

            ps = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, nhanVien.getTen());
            ps.setString(2, nhanVien.getGioiTinh());
            ps.setString(3, nhanVien.getDiaChi());
            ps.setString(4, nhanVien.getEmail());
            ps.setString(5, nhanVien.getSoDT());

            int affectedRows = ps.executeUpdate();
            if (affectedRows == 0) {
                return 0;
            }

            rs = ps.getGeneratedKeys();
            int maNV = 0;
            if (rs.next()) {
                maNV = rs.getInt(1);
            }

            return maNV;

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

    public int capNhatNhanVien(NhanVien nhanVien) {
        try {
            String sql = "UPDATE NhanVien SET TenNV = ?, GioiTinh = ?, DiaChi = ?, Email = ?, SoDT = ? WHERE MaNV = ?";

            connection = DBConnection.getConnection();

            ps = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, nhanVien.getTen());
            ps.setString(2, nhanVien.getGioiTinh());
            ps.setString(3, nhanVien.getDiaChi());
            ps.setString(4, nhanVien.getEmail());
            ps.setString(5, nhanVien.getSoDT());
            ps.setInt(6, nhanVien.getMaNV());

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

    public int deleteNhanVien(int maNV) {

        try {
            connection = DBConnection.getConnection();

            String sql = "DELETE NhanVien WHERE MaNV = ?";
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

    public boolean checkEmail(String email) {

        try {
            connection = DBConnection.getConnection();
            String sql = "SELECT * FROM NhanVien WHERE email = ?";
            ps = connection.prepareStatement(sql);
            ps.setString(1, email);

            rs = ps.executeQuery();

            return rs.next();

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

        return false;
    }

    public boolean checkSDT(String sdt) {

        try {
            connection = DBConnection.getConnection();
            String sql = "SELECT * FROM NhanVien WHERE SoDT = ?";
            ps = connection.prepareStatement(sql);
            ps.setString(1, sdt);

            rs = ps.executeQuery();

            return rs.next();

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

        return false;
    }

    public List<NhanVien> searchNhanVien(String keyword, int type) {
        List<NhanVien> dsNhanVien = new ArrayList<>();
        try {
            connection = DBConnection.getConnection();

            String sql = "SELECT * FROM NhanVien "
                    + "WHERE ";

            if (type == 0) {
                sql += " MaNV LIKE ? ";
            } else if (type == 1) {
                sql += " TenNV LIKE ? ";
            } else if (type == 2) {
                sql += " DiaChi LIKE ? ";
            } else if (type == 3) {
                sql += " GioiTinh LIKE ? ";
            } else if (type == 4) {
                sql += " Email LIKE ? ";
            } else if (type == 5) {
                sql += " SoDT LIKE ?";
            };

            ps = connection.prepareStatement(sql);
            String searchKeyword = "%" + keyword + "%";
            ps.setString(1, searchKeyword);

            rs = ps.executeQuery();

            while (rs.next()) {
                NhanVien nv = new NhanVien();
                nv.setMaNV(rs.getInt("MaNV"));
                nv.setTen(rs.getString("TenNV"));
                nv.setGioiTinh(rs.getString("GioiTinh"));
                nv.setDiaChi(rs.getString("DiaChi"));
                nv.setEmail(rs.getString("Email"));
                nv.setSoDT(rs.getString("SoDT"));

                dsNhanVien.add(nv);
            }

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

        return dsNhanVien;
    }
}
