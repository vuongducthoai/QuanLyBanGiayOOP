/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI;

import DAO.NhaCungCapDAO;
import static DAO.NhaCungCapDAO.getNhaCungCapList;
import SQLConnection.DBConnection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import model.NhaCungCap;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.swing.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Asus
 */
public class DSNhaCungCap extends javax.swing.JPanel {

    /**
     * Creates new form DSNhaCungCap
     */
    private DBConnection conn;

    public DSNhaCungCap() {
        initComponents();
        customizeTable();
        txtMaNCC.setEditable(false);
        conn = new DBConnection();
        loadDataToTableNCC();
        getLastSupplerId();
    }

    private void customizeTable() {
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(javax.swing.JLabel.CENTER);

        for (int i = 0; i < TableDsncc.getColumnCount(); i++) {
            TableDsncc.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
        TableDsncc.getColumnModel().getColumn(0).setPreferredWidth(50);
        TableDsncc.getColumnModel().getColumn(1).setPreferredWidth(200);
        TableDsncc.getColumnModel().getColumn(2).setPreferredWidth(75);
        TableDsncc.getColumnModel().getColumn(3).setPreferredWidth(100);
        TableDsncc.getColumnModel().getColumn(4).setPreferredWidth(100);

        // Set chiều cao hàng
        TableDsncc.setRowHeight(25);

        // Tự động điều chỉnh kích thước
        TableDsncc.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
    }

    public void getLastSupplerId() {
        try {
            int lastId = NhaCungCapDAO.getLastSupplierId(conn.getConnection());
            int newId = lastId + 1;
            txtMaNCC.setText(Integer.toString(newId));
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
        jLabel2 = new javax.swing.JLabel();
        txtMaNCC = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnSua = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        txtTenNCC = new javax.swing.JTextField();
        txtTimkiem = new javax.swing.JTextField();
        txtDiaChi = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        txtSdt = new javax.swing.JTextField();
        btnTimkiem = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        TableDsncc = new javax.swing.JTable();
        btnThem = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jButton1 = new javax.swing.JButton();

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông tin nhà cung cấp", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N
        jPanel2.setPreferredSize(new java.awt.Dimension(912, 500));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("Tên NCC:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setText("Email:");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setText("Địa chỉ:");

        btnSua.setBackground(new java.awt.Color(0, 204, 51));
        btnSua.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSua.setForeground(new java.awt.Color(255, 255, 255));
        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setText("Mã NCC:");

        txtTimkiem.setToolTipText("");
        txtTimkiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTimkiemActionPerformed(evt);
            }
        });
        txtTimkiem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtTimkiemKeyPressed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setText("SĐT:");

        btnTimkiem.setBackground(new java.awt.Color(153, 255, 255));
        btnTimkiem.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnTimkiem.setForeground(new java.awt.Color(51, 51, 51));
        btnTimkiem.setText("Tìm");
        btnTimkiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimkiemActionPerformed(evt);
            }
        });

        TableDsncc.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Mã NCC", "Họ tên", "Địa chỉ", "Email", "Số điện thoại"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TableDsncc.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        TableDsncc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableDsnccMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(TableDsncc);

        btnThem.setBackground(new java.awt.Color(0, 0, 255));
        btnThem.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnThem.setForeground(new java.awt.Color(255, 255, 255));
        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnXoa.setBackground(new java.awt.Color(255, 0, 0));
        btnXoa.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnXoa.setForeground(new java.awt.Color(255, 255, 255));
        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(0, 153, 153));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Export Excel");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTenNCC))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtMaNCC)
                                    .addComponent(txtDiaChi))))
                        .addGap(76, 76, 76)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtSdt, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(txtTimkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnTimkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(36, 36, 36))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(38, 38, 38)
                                .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(47, 47, 47)
                                .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(50, 50, 50)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(94, 94, 94))
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 872, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(32, 32, 32))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txtMaNCC, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(27, 27, 27))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtTenNCC, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(txtSdt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTimkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTimkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE)
                        .addGap(12, 12, 12)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 930, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 515, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
    private void loadDataToTableNCC() {
        try {
            List<NhaCungCap> listNCC = NhaCungCapDAO.getNhaCungCapList(conn.getConnection());
            DefaultTableModel model = (DefaultTableModel) TableDsncc.getModel();
            model.setRowCount(0);
            for (NhaCungCap ncc : listNCC) {
                Integer MaNCC = ncc.getMaNCC();
                String MaNCCStr = MaNCC.toString();
                String[] row = new String[]{
                    MaNCCStr,
                    ncc.getTenNCC(),
                    ncc.getDiaChi(),
                    ncc.getEmail(),
                    ncc.getSoDT()
                };
                model.addRow(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        try {
            int maNCC = Integer.parseInt(txtMaNCC.getText());
            String tenNCC = txtTenNCC.getText();
            String diaChi = txtDiaChi.getText();
            String email = txtEmail.getText();
            String soDT = txtSdt.getText();

            if (tenNCC.isEmpty() || diaChi.isEmpty() || email.isEmpty() || soDT.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Tất cả các trường đều không được để trống.");
                return;
            }
            if (!email.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
                JOptionPane.showMessageDialog(this, "Email không hợp lệ.");
                return;
            }
            if (!soDT.matches("^\\d{10,15}$")) {
                JOptionPane.showMessageDialog(this, "Số điện thoại phải là số và có từ 10 đến 15 chữ số.");
                return;
            }

            NhaCungCap nhaCungCap = new NhaCungCap();
            nhaCungCap.setMaNCC(maNCC);
            nhaCungCap.setTenNCC(tenNCC);
            nhaCungCap.setDiaChi(diaChi);
            nhaCungCap.setEmail(email);
            nhaCungCap.setSoDT(soDT);

            NhaCungCapDAO.updateSupplier(conn.getConnection(), nhaCungCap);
            loadDataToTableNCC();
            JOptionPane.showMessageDialog(this, "Sửa thông tin nhà cung cấp thành công.");
            clearInputFields();
            getLastSupplerId();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Đã xảy ra lỗi khi sửa thông tin nhà cung cấp.");
        }
    }//GEN-LAST:event_btnSuaActionPerformed


    private void txtTimkiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTimkiemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTimkiemActionPerformed

    private void btnTimkiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimkiemActionPerformed
        try {
            String keyword = txtTimkiem.getText();
            List<NhaCungCap> searchResults = NhaCungCapDAO.searchNhaCungCap(conn.getConnection(), keyword);

            DefaultTableModel model = (DefaultTableModel) TableDsncc.getModel();
            model.setRowCount(0);

            for (NhaCungCap ncc : searchResults) {
                model.addRow(new Object[]{
                    ncc.getMaNCC(),
                    ncc.getTenNCC(),
                    ncc.getDiaChi(),
                    ncc.getEmail(),
                    ncc.getSoDT()
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

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
//        int maNCC = Integer.parseInt(txtMaNCC.getText());
        String tenNCC = txtTenNCC.getText();
        String diaChi = txtTenNCC.getText();
        String email = txtEmail.getText();
        String soDT = txtSdt.getText();

        if (tenNCC.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Tên nhà cung cấp không được để trống.");
            txtTenNCC.requestFocus();
            return;
        }
        if (diaChi.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Địa chỉ không được để trống.");
            txtDiaChi.requestFocus();
            return;
        }
        if (email.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Email không được để trống.");
            txtEmail.requestFocus();
            return;
        }
        if (!email.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
            JOptionPane.showMessageDialog(this, "Email không hợp lệ.");
            txtEmail.requestFocus();
            return;
        }
        if (soDT.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Số điện thoại không được để trống.");
            txtSdt.requestFocus();
            return;
        }
        if (!soDT.matches("^\\d{10,15}$")) {
            JOptionPane.showMessageDialog(this, "Số điện thoại phải là số và có từ 10 đến 15 chữ số.");
            txtSdt.requestFocus();
            return;
        }

        NhaCungCap nhaCungCap = new NhaCungCap();
        nhaCungCap.setTenNCC(tenNCC);
        nhaCungCap.setDiaChi(diaChi);
        nhaCungCap.setEmail(email);
        nhaCungCap.setSoDT(soDT);

        try {
            NhaCungCapDAO.insertSupplier(conn.getConnection(), nhaCungCap);
            loadDataToTableNCC();
            JOptionPane.showMessageDialog(this, "Thêm nhà cung cấp thành công.");
            getLastSupplerId();
        } catch (SQLException ex) {
            Logger.getLogger(DSNhaCungCap.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Đã xảy ra lỗi khi thêm nhà cung cấp.");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DSNhaCungCap.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Đã xảy ra lỗi kết nối cơ sở dữ liệu.");
        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        // TODO add your handling code here:
        int confirm = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xóa nhà cung cấp này không?", "Xác nhận", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            try {
                int maNCC = Integer.parseInt(txtMaNCC.getText());
                NhaCungCap nhaCungCap = new NhaCungCap();
                nhaCungCap.setMaNCC(maNCC);

                NhaCungCapDAO.deleteNhaCungCap(conn.getConnection(), nhaCungCap);
                loadDataToTableNCC();
                JOptionPane.showMessageDialog(this, "Xóa nhà cung cấp thành công.");
                clearInputFields();
                getLastSupplerId();
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Đã xảy ra lỗi khi xóa nhà cung cấp.");
            }
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void clearInputFields() {
        txtMaNCC.setText("");
        txtTenNCC.setText("");
        txtDiaChi.setText("");
        txtEmail.setText("");
        txtSdt.setText("");
    }

    private void TableDsnccMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableDsnccMouseClicked
        int selectedRow = TableDsncc.getSelectedRow();
        if (selectedRow != -1) {
            txtMaNCC.setText(TableDsncc.getValueAt(selectedRow, 0).toString());
            txtTenNCC.setText(TableDsncc.getValueAt(selectedRow, 1).toString());
            txtDiaChi.setText(TableDsncc.getValueAt(selectedRow, 2).toString());
            txtEmail.setText(TableDsncc.getValueAt(selectedRow, 3).toString());
            txtSdt.setText(TableDsncc.getValueAt(selectedRow, 4).toString());
        }
    }//GEN-LAST:event_TableDsnccMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        try {

            // Lấy danh sách nhà cung cấp
            List<NhaCungCap> nhaCungCapList = getNhaCungCapList(conn.getConnection());

            // Hiển thị hộp thoại chọn nơi lưu file
            String filePath = chooseFileLocation();
            if (filePath != null) {
                // Xuất dữ liệu ra file Excel
                exportToExcel(nhaCungCapList, filePath);

                // Thông báo xuất thành công
                javax.swing.JOptionPane.showMessageDialog(this, "Xuất dữ liệu ra file Excel thành công!");
            }

        } catch (SQLException e) {
            e.printStackTrace();
            javax.swing.JOptionPane.showMessageDialog(this, "Đã xảy ra lỗi: " + e.getMessage());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DSNhaCungCap.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DSNhaCungCap.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtTimkiemKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimkiemKeyPressed
        // TODO add your handling code here:
        try {
            String keyword = txtTimkiem.getText();
            List<NhaCungCap> searchResults = NhaCungCapDAO.searchNhaCungCap(conn.getConnection(), keyword);

            DefaultTableModel model = (DefaultTableModel) TableDsncc.getModel();
            model.setRowCount(0);

            for (NhaCungCap ncc : searchResults) {
                model.addRow(new Object[]{
                    ncc.getMaNCC(),
                    ncc.getTenNCC(),
                    ncc.getDiaChi(),
                    ncc.getEmail(),
                    ncc.getSoDT()
                });
            }

            if (searchResults.isEmpty()) {
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Đã xảy ra lỗi khi tìm kiếm.");
        }
    }//GEN-LAST:event_txtTimkiemKeyPressed
    private void exportToExcel(List<NhaCungCap> nhaCungCapList, String fileName) throws IOException {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Nhà Cung Cấp");

        // Tạo tiêu đề cột
        Row headerRow = sheet.createRow(0);
        String[] columns = {"Mã NCC", "Tên NCC", "Địa Chỉ", "Email", "Số ĐT"};

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
        for (NhaCungCap nhaCungCap : nhaCungCapList) {
            Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(nhaCungCap.getMaNCC());
            row.createCell(1).setCellValue(nhaCungCap.getTenNCC());
            row.createCell(2).setCellValue(nhaCungCap.getDiaChi());
            row.createCell(3).setCellValue(nhaCungCap.getEmail());
            row.createCell(4).setCellValue(nhaCungCap.getSoDT());
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
    public javax.swing.JTable TableDsncc;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnTimkiem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtMaNCC;
    private javax.swing.JTextField txtSdt;
    private javax.swing.JTextField txtTenNCC;
    private javax.swing.JTextField txtTimkiem;
    // End of variables declaration//GEN-END:variables
}
