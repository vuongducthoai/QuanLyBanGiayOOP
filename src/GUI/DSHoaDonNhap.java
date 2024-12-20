/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI;

import DAO.HoaDonNhapDAO;
import DAO.NhaCungCapDAO;
import SQLConnection.DBConnection;

import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import model.HoaDonNhap;
import model.NhaCungCap;
import model.NhanVien;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import util.Session;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import org.apache.poi.ss.usermodel.Font;

/**
 *
 * @author ADMIN
 */
public class DSHoaDonNhap extends javax.swing.JPanel {

    /**
     * Creates new form DSHoaDonNhap2
     */
    private DBConnection conn;
    private int maHDNhap;

    public DSHoaDonNhap() {
        initComponents();
        customizeTable();
        JSpinner.DateEditor dateEditor = new JSpinner.DateEditor(txtNgayNhap, "yyyy-MM-dd");
        txtMaHDN.setEditable(false);
        txtTongTien.setEditable(false);
        conn = new DBConnection();
        loadDataTableHDN();
        getLastHDNId();
        try {
            loadComboBoxTenNCC(); // Gọi loadComboBoxTenNCC trong constructor
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                loadDataTableHDN();
            }
        }, 4000, 4000);
    }

    private void customizeTable() {
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(javax.swing.JLabel.CENTER);

        for (int i = 0; i < tblHoaDonNhap.getColumnCount(); i++) {
            tblHoaDonNhap.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
        tblHoaDonNhap.getColumnModel().getColumn(0).setPreferredWidth(50);
        tblHoaDonNhap.getColumnModel().getColumn(1).setPreferredWidth(200);
        tblHoaDonNhap.getColumnModel().getColumn(2).setPreferredWidth(200);
        tblHoaDonNhap.getColumnModel().getColumn(3).setPreferredWidth(100);
        tblHoaDonNhap.getColumnModel().getColumn(4).setPreferredWidth(100);
        tblHoaDonNhap.getColumnModel().getColumn(5).setPreferredWidth(200);

        // Set chiều cao hàng
        tblHoaDonNhap.setRowHeight(25);

        // Tự động điều chỉnh kích thước
        tblHoaDonNhap.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
    }

    private void loadComboBoxTenNCC() throws ClassNotFoundException, SQLException {
        List<NhaCungCap> nhaCungCapList = NhaCungCapDAO.getNhaCungCapList(conn.getConnection());

        DefaultComboBoxModel<NhaCungCap> comboBoxModel = new DefaultComboBoxModel<>();

        for (NhaCungCap nhaCungCap : nhaCungCapList) {
            comboBoxModel.addElement(nhaCungCap);  // Thêm đối tượng NhaCungCap vào ComboBox
        }
        cmbTenNCC.setModel(comboBoxModel);
    }

    private void loadDataTableHDN() {
        try {
            List<HoaDonNhap> listHoaDonNhap = HoaDonNhapDAO.ListHoaDonNhap(conn.getConnection());
            DefaultTableModel model = (DefaultTableModel) tblHoaDonNhap.getModel();
            model.setRowCount(0);
            for (HoaDonNhap hdn : listHoaDonNhap) {
                Integer maHDN = hdn.getMaHDN();
                String MaHDNtr = maHDN.toString();
                String[] row = new String[]{
                    MaHDNtr,
                    hdn.getNhaCungCap().getTenNCC(),
                    hdn.getNhanVien().getTen(),
                    hdn.getNgayNhap().toString(),
                    hdn.getFormatTongTien(),
                    hdn.getTrangThai()
                };
                model.addRow(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getLastHDNId() {
        try {
            int newId = HoaDonNhapDAO.getNextMaHDN(conn.getConnection());
            txtMaHDN.setText(Integer.toString(newId));
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DSNhaCungCap.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        txtMaHDN = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtTimKiem = new javax.swing.JTextField();
        btnTimkiem = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblHoaDonNhap = new javax.swing.JTable();
        btnXoa = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        txtTongTien = new javax.swing.JTextField();
        txtNgayNhap = new javax.swing.JSpinner();
        cmbStatus = new javax.swing.JComboBox<>();
        btnSua = new javax.swing.JButton();
        btnThem1 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        cmbTenNCC = new javax.swing.JComboBox<>();
        jButton2 = new javax.swing.JButton();

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Hóa đơn nhập", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N

        txtMaHDN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaHDNActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setText("Ngày nhập:");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setText("Tổng tiền:");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setText("Mã hóa đơn nhập:");

        txtTimKiem.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtTimKiem.setForeground(new java.awt.Color(51, 51, 51));

        txtTimKiem.setText("Tìm kiếm...");
        txtTimKiem.setToolTipText("");
        txtTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTimKiemActionPerformed(evt);
            }
        });

        btnTimkiem.setBackground(new java.awt.Color(153, 255, 255));
        btnTimkiem.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnTimkiem.setText("Tìm");
        btnTimkiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimkiemActionPerformed(evt);
            }
        });

        tblHoaDonNhap.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Mã HDN", "Nhà cung cấp", "Nhân viên", "Ngày Nhập", "Tổng tiền", "Trạng thái"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblHoaDonNhap.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblHoaDonNhapMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblHoaDonNhap);

        btnXoa.setBackground(new java.awt.Color(255, 0, 0));
        btnXoa.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnXoa.setForeground(new java.awt.Color(255, 255, 255));
        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel9.setText("Tên nhà cung cấp:");


        txtNgayNhap.setModel(new javax.swing.SpinnerDateModel());

        cmbStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "CHƯA THANH TOÁN", "ĐÃ THANH TOÁN", " " }));

        btnSua.setBackground(new java.awt.Color(0, 153, 0));
        btnSua.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSua.setForeground(new java.awt.Color(255, 255, 255));
        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnThem1.setBackground(new java.awt.Color(0, 102, 255));
        btnThem1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnThem1.setForeground(new java.awt.Color(255, 255, 255));
        btnThem1.setText("Thêm");
        btnThem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThem1ActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(0, 153, 153));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Chi Tiết Hóa Đơn Nhập");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setText("Trạng thái:");

        jButton2.setBackground(new java.awt.Color(102, 255, 51));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton2.setText("Export Excel");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))

                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtTongTien)
                            .addComponent(cmbStatus, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtMaHDN, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE))
                        .addGap(139, 139, 139)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(47, 47, 47)
                                .addComponent(txtNgayNhap))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnTimkiem)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addGap(18, 18, 18)
                                .addComponent(cmbTenNCC, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(114, 114, 114))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 939, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(46, 46, 46)
                                .addComponent(btnThem1, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31)
                                .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(42, 42, 42)
                                .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(71, 71, 71)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(67, 67, 67)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(59, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtMaHDN, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(cmbTenNCC, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbStatus)
                            .addComponent(jLabel4)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(txtNgayNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel6)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)

                    .addComponent(jLabel5)
                    .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTimkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThem1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))

                .addGap(2, 2, 2))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 8, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtMaHDNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaHDNActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaHDNActionPerformed

    private void txtTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTimKiemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTimKiemActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        // TODO add your handling code here:
        int confirm = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn xóa hóa đơn nhập này không?", "Xác nhận", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            try {
                int maHDN = Integer.parseInt(txtMaHDN.getText());
                HoaDonNhapDAO.deleteHoaDonNhap(conn.getConnection(), maHDN);
                loadDataTableHDN();
                JOptionPane.showMessageDialog(this, "Xóa hóa đơn nhập thành công");
                clearInputFields();
                getLastHDNId();
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Đã xảy ra lỗi khi xóa hóa đơn nhập.");
            }
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void clearInputFields() {
        txtMaHDN.setText("");
        txtTongTien.setText("");
    }

    private void tblHoaDonNhapMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHoaDonNhapMouseClicked
        int selectedRow = tblHoaDonNhap.getSelectedRow();

        if (selectedRow != -1) {
            String maHDN = tblHoaDonNhap.getValueAt(selectedRow, 0).toString();
            String tenNCC = tblHoaDonNhap.getValueAt(selectedRow, 1).toString();
            String ngayNhap = tblHoaDonNhap.getValueAt(selectedRow, 3).toString();
            String tongTien = tblHoaDonNhap.getValueAt(selectedRow, 4).toString();
            String trangThai = tblHoaDonNhap.getValueAt(selectedRow, 5).toString();
            try {
                maHDNhap = Integer.parseInt(maHDN);
            } catch (NumberFormatException e) {
                maHDNhap = -1;
            }
            txtMaHDN.setText(maHDN);
            cmbTenNCC.setSelectedItem(tenNCC);
            cmbStatus.setSelectedItem(trangThai);
            txtNgayNhap.setValue(java.sql.Date.valueOf(ngayNhap));
            txtTongTien.setText(tongTien);
        }
    }//GEN-LAST:event_tblHoaDonNhapMouseClicked

    private void btnThem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThem1ActionPerformed
        // TODO add your handling code here:
        // TODO add your handling code here:
        HoaDonNhap hoaDonNhap = new HoaDonNhap();
        NhaCungCap selectedNCC = (NhaCungCap) cmbTenNCC.getSelectedItem();
        if (selectedNCC == null) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn nhà cung cấp.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }
        hoaDonNhap.setNhaCungCap(selectedNCC);

        String trangThai = (String) cmbStatus.getSelectedItem();
        hoaDonNhap.setTrangThai(trangThai);
        Date selectedDate = (Date) txtNgayNhap.getValue();
        hoaDonNhap.setNgayNhap(selectedDate);
        int maNV = Session.getMaNV();
        NhanVien nhanVien = new NhanVien();
        nhanVien.setMaNV(maNV);
        hoaDonNhap.setNhanVien(nhanVien);

        if (trangThai == null || trangThai.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn trạng thái.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (selectedDate == null) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn ngày nhập.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            HoaDonNhapDAO.addHoaDonNhap(conn.getConnection(), hoaDonNhap);
            loadDataTableHDN();
            JOptionPane.showMessageDialog(this, "Thêm hóa đơn nhập thành công.");
            getLastHDNId();
        } catch (SQLException ex) {
            Logger.getLogger(DSDanhMuc.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Đã xảy ra lỗi khi thêm hóa đơn nhập.");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DSDanhMuc.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Đã xảy ra lỗi kết nối cơ sở dữ liệu.");
        }

    }//GEN-LAST:event_btnThem1ActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        // TODO add your handling code here:
        try {
            HoaDonNhap hoaDonNhap = new HoaDonNhap();
            int maHDN = Integer.parseInt(txtMaHDN.getText());
            hoaDonNhap.setMaHDN(maHDN);
            NhaCungCap selectedNCC = (NhaCungCap) cmbTenNCC.getSelectedItem();
            if (selectedNCC == null) {
                JOptionPane.showMessageDialog(this, "Vui lòng chọn nhà cung cấp.", "Lỗi", JOptionPane.ERROR_MESSAGE);
                return;
            }
            hoaDonNhap.setNhaCungCap(selectedNCC);
            String trangThai = (String) cmbStatus.getSelectedItem();
            if (trangThai == null || trangThai.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Vui lòng chọn trạng thái.", "Lỗi", JOptionPane.ERROR_MESSAGE);
                return;
            }
            hoaDonNhap.setTrangThai(trangThai);
            Date selectedDate = (Date) txtNgayNhap.getValue();
            hoaDonNhap.setNgayNhap(selectedDate);
            HoaDonNhapDAO.updateHoaDonNhap(conn.getConnection(), hoaDonNhap);
            loadDataTableHDN();
            JOptionPane.showMessageDialog(this, "Sửa thông tin hóa đơn nhập thành công");
            clearInputFields();
            getLastHDNId();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Đã xảy ra lỗi khi sửa thông tin phiếu nhâp.");
        }
    }//GEN-LAST:event_btnSuaActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if (maHDNhap > 0) {
            DSChiTietHoaDonNhap dSChiTietHoaDonNhap = new DSChiTietHoaDonNhap(maHDNhap);
            dSChiTietHoaDonNhap.setVisible(true);
        } else {
            javax.swing.JOptionPane.showMessageDialog(this, "Mã hóa đơn nhập không hợp lệ!", "Lỗi", javax.swing.JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnTimkiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimkiemActionPerformed
        // TODO add your handling code here:
        try {
            String keyword = txtTimKiem.getText();
            List<HoaDonNhap> searchResults = HoaDonNhapDAO.searchHoaDonNhap(conn.getConnection(), keyword);
            DefaultTableModel model = (DefaultTableModel) tblHoaDonNhap.getModel();
            model.setRowCount(0);

            for (HoaDonNhap hdn : searchResults) {
                model.addRow(new Object[]{
                    hdn.getMaHDN(),
                    hdn.getNhaCungCap().getTenNCC(),
                    hdn.getNhanVien().getTen(),
                    hdn.getNgayNhap(),
                    hdn.getTongTien(),
                    hdn.getTrangThai()
                });
            }
            if (searchResults.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Không tìm thấy kết quả nào.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Đã xảy ra lỗi khi tìm kiếm.");

        }
    }//GEN-LAST:event_btnTimkiemActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        try {
            // Lấy danh sách nhà cung cấp
            List<HoaDonNhap> hoaDonNhapList = HoaDonNhapDAO.ListHoaDonNhap(conn.getConnection());

            // Hiển thị hộp thoại chọn nơi lưu file
            String filePath = chooseFileLocation();
            if (filePath != null) {
                // Xuất dữ liệu ra file Excel
                exportToExcel(hoaDonNhapList, filePath);

                // Thông báo xuất thành công
                javax.swing.JOptionPane.showMessageDialog(this, "Xuất dữ liệu ra file Excel thành công!");
            }

        } catch (SQLException | IOException e) {
            e.printStackTrace();
            javax.swing.JOptionPane.showMessageDialog(this, "Đã xảy ra lỗi: " + e.getMessage());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DSHoaDonNhap.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void exportToExcel(List<HoaDonNhap> hoaDonNhapList, String fileName) throws IOException {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Nhà Cung Cấp");

        // Tạo tiêu đề cột
        Row headerRow = sheet.createRow(0);
        String[] columns = {"Mã HDN", "Tên nhà cung cấp", "Tên nhân viên", "Ngày nhập", "Tổng tiền", "Trạng Thái"};

        for (int i = 0; i < columns.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(columns[i]);
            CellStyle style = workbook.createCellStyle();
            Font font = workbook.createFont();
            font.setBold(true);
            style.setFont(font);
            cell.setCellStyle(style);
        }

        // Điền dữ liệu
        int rowNum = 1;
        for (HoaDonNhap hoaDonNhap : hoaDonNhapList) {
            Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(hoaDonNhap.getMaHDN());
            row.createCell(1).setCellValue(hoaDonNhap.getNhaCungCap().getTenNCC());
            row.createCell(2).setCellValue(hoaDonNhap.getNhanVien().getTen());
            row.createCell(3).setCellValue(hoaDonNhap.getNgayNhap());
            row.createCell(4).setCellValue(hoaDonNhap.getFormatTongTien());
            row.createCell(5).setCellValue(hoaDonNhap.getTrangThai());
        }

        // Tự động điều chỉnh kích thước cột
        for (int i = 0; i < columns.length; i++) {
            sheet.autoSizeColumn(i);
        }

        // Ghi dữ liệu ra file
        try (FileOutputStream fileOut = new FileOutputStream(fileName)) {
            workbook.write(fileOut);
        }

        // Đóng workbook
        workbook.close();
    }

    private String chooseFileLocation() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Chọn nơi lưu file Excel");
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

        int userSelection = fileChooser.showSaveDialog(null);
        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File fileToSave = fileChooser.getSelectedFile();
            String filePath = fileToSave.getAbsolutePath();

            // Đảm bảo file có đuôi .xlsx
            if (!filePath.endsWith(".xlsx")) {
                filePath += ".xlsx";
            }
            return filePath;
        }
        return null;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem1;
    private javax.swing.JButton btnTimkiem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JComboBox<String> cmbStatus;
    private javax.swing.JComboBox<NhaCungCap> cmbTenNCC;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    public javax.swing.JTable tblHoaDonNhap;
    private javax.swing.JTextField txtMaHDN;
    private javax.swing.JSpinner txtNgayNhap;
    private javax.swing.JTextField txtTimKiem;
    private javax.swing.JTextField txtTongTien;
    // End of variables declaration//GEN-END:variables
}
