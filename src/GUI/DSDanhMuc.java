/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI;

import DAO.DanhMucDAO;
import SQLConnection.DBConnection;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import model.DanhMuc;

/**
 *
 * @author Asus
 */
public class DSDanhMuc extends javax.swing.JPanel {

    /**
     * Creates new form DanhMuc
     */
    private DBConnection conn;

    public DSDanhMuc() {
        initComponents();
        txtMaDM.setEditable(false);
        conn = new DBConnection();
        customizeTable();
        
        loadDataToTableDanhMuc();
        getLastDanhMucId();
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
        txtTenDM = new javax.swing.JTextField();
        btnSua = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        btnTimkiem = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblDanhMuc = new javax.swing.JTable();
        btnThem = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        txtTimKiem = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtMaDM = new javax.swing.JTextField();

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Quản lý danh mục", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N
        jPanel2.setAutoscrolls(true);

        btnSua.setBackground(new java.awt.Color(0, 153, 51));
        btnSua.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSua.setForeground(new java.awt.Color(255, 255, 255));
        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setText("Mã danh mục:");

        btnTimkiem.setBackground(new java.awt.Color(153, 255, 255));
        btnTimkiem.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnTimkiem.setText("Tìm");
        btnTimkiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimkiemActionPerformed(evt);
            }
        });

        tblDanhMuc.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        tblDanhMuc.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Mã danh mục", "Tên danh mục"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDanhMuc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDanhMucMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblDanhMuc);

        btnThem.setBackground(new java.awt.Color(0, 102, 255));
        btnThem.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnThem.setForeground(new java.awt.Color(255, 255, 255));
        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnXoa.setBackground(new java.awt.Color(255, 51, 0));
        btnXoa.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnXoa.setForeground(new java.awt.Color(255, 255, 255));
        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        txtTimKiem.setText("Tìm kiếm...");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel10.setText("Tên Danh Mục");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(187, 187, 187)
                        .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52)
                        .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45)
                        .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 864, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtTimKiem)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtMaDM, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(47, 47, 47)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel10)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtTenDM, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(btnTimkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtTenDM, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(txtMaDM, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTimkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(8, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
     public void getLastDanhMucId() {
        try {
            int lastId = DanhMucDAO.getLastCategoryId(conn.getConnection());
            int newId = lastId + 1;
            txtMaDM.setText(Integer.toString(newId));
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DSDanhMuc.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void loadDataToTableDanhMuc() {
        try {
            List<DanhMuc> listDM = DanhMucDAO.getDanhMucList(conn.getConnection());
            DefaultTableModel model = (DefaultTableModel) tblDanhMuc.getModel();
            model.setRowCount(0);
            for (DanhMuc dm : listDM) {
                Integer MaDM = dm.getMaDM();
                String MaDMStr = MaDM.toString();
                String[] row = new String[]{
                    MaDMStr,
                    dm.getTenDM(),};
                model.addRow(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
     private void customizeTable() {
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(javax.swing.JLabel.CENTER);

        for (int i = 0; i < tblDanhMuc.getColumnCount(); i++) {
            tblDanhMuc.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
        
    }

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        // TODO add your handling code here:
        int confirm = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xóa danh mục này không?", "Xác nhận", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            try {
                int maDM = Integer.parseInt(txtMaDM.getText());
                DanhMuc danhMuc = new DanhMuc();
                danhMuc.setMaDM(maDM);

                DanhMucDAO.deleteDanhMuc(conn.getConnection(), danhMuc);
                loadDataToTableDanhMuc();
                JOptionPane.showMessageDialog(this, "Xóa dạnh mục thành công.");
                clearInputFields();
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Đã xảy ra lỗi khi xóa danh mục.");
            }
        }
    }//GEN-LAST:event_btnXoaActionPerformed
    private void clearInputFields() {
        txtMaDM.setText("");
        txtTenDM.setText("");
    }
    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
        String tenDM = txtTenDM.getText();

        if (tenDM.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Tên danh mục không được để trống.");
            txtTenDM.requestFocus();
            return;
        }

        DanhMuc danhMuc = new DanhMuc();
        danhMuc.setTenDM(tenDM);

        try {
            DanhMucDAO.insertDanhMuc(conn.getConnection(), danhMuc);
            loadDataToTableDanhMuc();
            JOptionPane.showMessageDialog(this, "Thêm danh mục thành công.");
        } catch (SQLException ex) {
            Logger.getLogger(DSDanhMuc.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Đã xảy ra lỗi khi thêm danh mục.");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DSDanhMuc.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Đã xảy ra lỗi kết nối cơ sở dữ liệu.");
        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        // TODO add your handling code here:
         try {
            int maDM = Integer.parseInt(txtMaDM.getText());
            String tenDM = txtTenDM.getText();

            if (tenDM.isEmpty() ) {
                JOptionPane.showMessageDialog(this, "Tên danh mục không được để trống.");
                return;
            }
           

            DanhMuc danhMuc = new DanhMuc();
            danhMuc.setMaDM(maDM);
            danhMuc.setTenDM(tenDM);
            
            DanhMucDAO.updateDanhMuc(conn.getConnection(), danhMuc);
            loadDataToTableDanhMuc();
            JOptionPane.showMessageDialog(this, "Sửa thông tin danh mục thành công.");
            clearInputFields();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Đã xảy ra lỗi khi sửa thông tin danh mục.");
        }
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnTimkiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimkiemActionPerformed
        // TODO add your handling code here:
        try {
            String keyword = txtTimKiem.getText();
                List<DanhMuc> searchResults = DanhMucDAO.searchDanhMuc(conn.getConnection(), keyword);

            DefaultTableModel model = (DefaultTableModel) tblDanhMuc.getModel();
            model.setRowCount(0);

            for (DanhMuc dm : searchResults) {
                model.addRow(new Object[]{
                    dm.getMaDM(),
                    dm.getTenDM(),
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

    private void tblDanhMucMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDanhMucMouseClicked
        // TODO add your handling code here:
        int selectedRow = tblDanhMuc.getSelectedRow();
        if (selectedRow != -1) {
            txtMaDM.setText(tblDanhMuc.getValueAt(selectedRow, 0).toString());
            txtTenDM.setText(tblDanhMuc.getValueAt(selectedRow, 1).toString());
        }
    }//GEN-LAST:event_tblDanhMucMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnTimkiem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    public javax.swing.JTable tblDanhMuc;
    private javax.swing.JTextField txtMaDM;
    private javax.swing.JTextField txtTenDM;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables
}
