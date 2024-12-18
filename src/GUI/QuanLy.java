/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import dao.NhanVienDAO;
import javax.swing.JOptionPane;
import model.NhanVien;
import model.TaiKhoan;

/**
 *
 * @author ADMIN
 */
public class QuanLy extends javax.swing.JFrame {

    DSNhanVien dsNhanVien = null;
    DSHoaDonNhap hdn = new DSHoaDonNhap();
    DSSanPham dssp = new DSSanPham();
    ThongTinCaNhan ttcn = null;

    /**
     * Creates new form Admin
     */
    public QuanLy() {
        initComponents();
        dssp = new DSSanPham();
    }

    public QuanLy(TaiKhoan tk) {
        initComponents();
        
        NhanVienDAO dao = new NhanVienDAO();
        
        NhanVien nv = dao.getNhanVienByMaNV(tk.getMaNV());
        
        ttcn = new ThongTinCaNhan(nv, tk);
        dsNhanVien = new DSNhanVien(nv.getMaNV());

        lblChucVu.setText(lblChucVu.getText() + tk.getChucVu());
        lblHoVaTen.setText(lblHoVaTen.getText() + nv.getTen());
        setTab();

    }

    private void setTab() {
        ttcn.setVisible(true);
        dsNhanVien.setVisible(false);
        hdn.setVisible(false);
        dssp.setVisible(false);

        panelMain.add(ttcn);
        panelMain.add(dsNhanVien);
        panelMain.add(hdn);
        panelMain.add(dssp);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelTab = new javax.swing.JPanel();
        btnNhanVien = new javax.swing.JButton();
        btnNCC = new javax.swing.JButton();
        btnSanPham = new javax.swing.JButton();
        btnDanhMuc = new javax.swing.JButton();
        btnNhapHang = new javax.swing.JButton();
        btnDangXuat = new javax.swing.JButton();
        btnTTCN = new javax.swing.JButton();
        btnHDN = new javax.swing.JButton();
        lblHoVaTen = new javax.swing.JLabel();
        lblChucVu = new javax.swing.JLabel();
        panelMain = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Quản lý bán giày");
        setPreferredSize(new java.awt.Dimension(1200, 600));

        panelTab.setBackground(new java.awt.Color(0, 102, 102));
        panelTab.setPreferredSize(new java.awt.Dimension(200, 600));

        btnNhanVien.setText("Nhân viên");
        btnNhanVien.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNhanVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNhanVienActionPerformed(evt);
            }
        });

        btnNCC.setText("Nhà cung cấp");
        btnNCC.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNCC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNCCActionPerformed(evt);
            }
        });

        btnSanPham.setText("Sản phẩm");
        btnSanPham.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSanPhamActionPerformed(evt);
            }
        });

        btnDanhMuc.setText("Danh mục");
        btnDanhMuc.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDanhMuc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDanhMucActionPerformed(evt);
            }
        });

        btnNhapHang.setText("Nhập hàng");
        btnNhapHang.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNhapHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNhapHangActionPerformed(evt);
            }
        });

        btnDangXuat.setText("Đăng xuất");
        btnDangXuat.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDangXuat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDangXuatActionPerformed(evt);
            }
        });

        btnTTCN.setText("Thông tin cá nhân");
        btnTTCN.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnTTCN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTTCNActionPerformed(evt);
            }
        });

        btnHDN.setText("Hóa đơn nhập");
        btnHDN.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnHDN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHDNActionPerformed(evt);
            }
        });

        lblHoVaTen.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblHoVaTen.setForeground(new java.awt.Color(255, 255, 255));
        lblHoVaTen.setText("Họ và tên: ");

        lblChucVu.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblChucVu.setForeground(new java.awt.Color(255, 255, 255));
        lblChucVu.setText("Chức vụ: ");

        javax.swing.GroupLayout panelTabLayout = new javax.swing.GroupLayout(panelTab);
        panelTab.setLayout(panelTabLayout);
        panelTabLayout.setHorizontalGroup(
            panelTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTabLayout.createSequentialGroup()
                .addGroup(panelTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelTabLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblHoVaTen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panelTabLayout.createSequentialGroup()
                        .addGroup(panelTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelTabLayout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addGroup(panelTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                    .addComponent(btnNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnNCC, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnDanhMuc, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnNhapHang, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnTTCN, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnDangXuat, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelTabLayout.createSequentialGroup()
                                        .addGap(2, 2, 2)
                                        .addComponent(btnHDN, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(panelTabLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lblChucVu, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 30, Short.MAX_VALUE)))
                .addContainerGap())
        );

        panelTabLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnDangXuat, btnDanhMuc, btnHDN, btnNCC, btnNhanVien, btnNhapHang, btnSanPham, btnTTCN, lblChucVu});

        panelTabLayout.setVerticalGroup(
            panelTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTabLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(lblHoVaTen, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblChucVu, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnTTCN, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnNCC, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnDanhMuc, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnNhapHang, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnHDN, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 178, Short.MAX_VALUE)
                .addComponent(btnDangXuat, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50))
        );

        panelTabLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnDangXuat, btnDanhMuc, btnNCC, btnNhanVien, btnNhapHang, btnSanPham, btnTTCN});

        getContentPane().add(panelTab, java.awt.BorderLayout.LINE_START);

        panelMain.setForeground(new java.awt.Color(153, 153, 153));
        panelMain.setLayout(new javax.swing.BoxLayout(panelMain, javax.swing.BoxLayout.LINE_AXIS));
        getContentPane().add(panelMain, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNhanVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNhanVienActionPerformed
        // TODO add your handling code here:
        ttcn.setVisible(false);
        dsNhanVien.setVisible(true);
        hdn.setVisible(false);
        dssp.setVisible(false);
    }//GEN-LAST:event_btnNhanVienActionPerformed

    private void btnDangXuatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDangXuatActionPerformed
        // TODO add your handling code here:

        int choice = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn đăng xuất", "Đăng xuất", JOptionPane.YES_NO_OPTION);

        if (choice == JOptionPane.YES_OPTION) {

            this.dispose();

            DangNhap dangNhap = new DangNhap();
            dangNhap.setLocationRelativeTo(null);
            dangNhap.setVisible(true);
        }

    }//GEN-LAST:event_btnDangXuatActionPerformed

    private void btnTTCNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTTCNActionPerformed
        // TODO add your handling code here:
        ttcn.setVisible(true);
        dsNhanVien.setVisible(false);
        hdn.setVisible(false);
        dssp.setVisible(false);

    }//GEN-LAST:event_btnTTCNActionPerformed

    private void btnNCCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNCCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnNCCActionPerformed

    private void btnDanhMucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDanhMucActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDanhMucActionPerformed

    private void btnSanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSanPhamActionPerformed

        ttcn.setVisible(false);
        dsNhanVien.setVisible(false);
        hdn.setVisible(false);
        // Hiển thị giao diện DSSanPham
        dssp.setVisible(true);
    }//GEN-LAST:event_btnSanPhamActionPerformed

    private void btnNhapHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNhapHangActionPerformed
        // TODO add your handling code here:
        ttcn.setVisible(false);
        dsNhanVien.setVisible(false);
        hdn.setVisible(true);
        dssp.setVisible(false);
    }//GEN-LAST:event_btnNhapHangActionPerformed

    private void btnHDNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHDNActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnHDNActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(QuanLy.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QuanLy.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QuanLy.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QuanLy.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                QuanLy admin = new QuanLy();
                admin.setLocationRelativeTo(null);
                admin.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDangXuat;
    private javax.swing.JButton btnDanhMuc;
    private javax.swing.JButton btnHDN;
    private javax.swing.JButton btnNCC;
    private javax.swing.JButton btnNhanVien;
    private javax.swing.JButton btnNhapHang;
    private javax.swing.JButton btnSanPham;
    private javax.swing.JButton btnTTCN;
    private javax.swing.JLabel lblChucVu;
    private javax.swing.JLabel lblHoVaTen;
    private javax.swing.JPanel panelMain;
    private javax.swing.JPanel panelTab;
    // End of variables declaration//GEN-END:variables
}
