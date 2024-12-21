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
    DSNhaCungCap ncc = new DSNhaCungCap();
    DSHoaDonNhap hdn = new DSHoaDonNhap();
    DSDanhMuc dm = new DSDanhMuc();
    DSSanPham dssp = new DSSanPham();
    ThongTinCaNhan ttcn = null;
    ChartCTHDN chartCTHDN = new ChartCTHDN();
    ChartHoaDon chartHD = new ChartHoaDon();

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
        ncc.setVisible(false);
        dm.setVisible(false);
        dssp.setVisible(false);

        panelMain.add(ttcn);
        panelMain.add(dsNhanVien);
        panelMain.add(ncc);
        panelMain.add(hdn);
        panelMain.add(dm);
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
        btnHDN1 = new javax.swing.JButton();
        panelMain = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Quản lý bán giày");
        setPreferredSize(new java.awt.Dimension(1200, 600));

        panelTab.setBackground(new java.awt.Color(0, 102, 102));
        panelTab.setPreferredSize(new java.awt.Dimension(200, 600));

        btnNhanVien.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnNhanVien.setText("Nhân viên");
        btnNhanVien.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNhanVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNhanVienActionPerformed(evt);
            }
        });

        btnNCC.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnNCC.setText("Nhà cung cấp");
        btnNCC.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNCC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNCCActionPerformed(evt);
            }
        });

        btnSanPham.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSanPham.setText("Sản phẩm");
        btnSanPham.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSanPhamActionPerformed(evt);
            }
        });

        btnDanhMuc.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnDanhMuc.setText("Danh mục");
        btnDanhMuc.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDanhMuc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDanhMucActionPerformed(evt);
            }
        });

        btnNhapHang.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnNhapHang.setText("Nhập hàng");
        btnNhapHang.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNhapHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNhapHangActionPerformed(evt);
            }
        });

        btnDangXuat.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnDangXuat.setText("Đăng xuất");
        btnDangXuat.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDangXuat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDangXuatActionPerformed(evt);
            }
        });

        btnTTCN.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnTTCN.setText("Thông tin cá nhân");
        btnTTCN.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnTTCN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTTCNActionPerformed(evt);
            }
        });

        btnHDN.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnHDN.setText("Thống kê nhập hàng");
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

        btnHDN1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnHDN1.setText("Thống kê doanh thu");
        btnHDN1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnHDN1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHDN1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelTabLayout = new javax.swing.GroupLayout(panelTab);
        panelTab.setLayout(panelTabLayout);
        panelTabLayout.setHorizontalGroup(
            panelTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTabLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblHoVaTen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelTabLayout.createSequentialGroup()
                        .addGroup(panelTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblChucVu, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelTabLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(panelTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnTTCN, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnDanhMuc, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnNhapHang, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnHDN, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnHDN1, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnDangXuat, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnNCC, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 31, Short.MAX_VALUE)))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnNCC, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnDanhMuc, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnNhapHang, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(btnHDN, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnHDN1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 167, Short.MAX_VALUE)
                .addComponent(btnDangXuat, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61))
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
        dm.setVisible(false);
        ncc.setVisible(false);

    }//GEN-LAST:event_btnTTCNActionPerformed

    private void btnNCCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNCCActionPerformed
        // TODO add your handling code here:
        ttcn.setVisible(false);
        dsNhanVien.setVisible(false);
        hdn.setVisible(false);
        ncc.setVisible(true);
        dm.setVisible(false);
    }//GEN-LAST:event_btnNCCActionPerformed

    private void btnDanhMucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDanhMucActionPerformed
        // TODO add your handling code here:
        ttcn.setVisible(false);
        dsNhanVien.setVisible(false);
        hdn.setVisible(false);
        ncc.setVisible(false);
        dssp.setVisible(false);
        dm.setVisible(true);
    }//GEN-LAST:event_btnDanhMucActionPerformed

    private void btnSanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSanPhamActionPerformed
        ncc.setVisible(false);
        ttcn.setVisible(false);
        dsNhanVien.setVisible(false);
        hdn.setVisible(false);
        dm.setVisible(false);
        // Hiển thị giao diện DSSanPham
        dssp.setVisible(true);
    }//GEN-LAST:event_btnSanPhamActionPerformed

    private void btnNhapHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNhapHangActionPerformed
        // TODO add your handling code here:
        ttcn.setVisible(false);
        dsNhanVien.setVisible(false);
        hdn.setVisible(true);
        dssp.setVisible(false);
        ncc.setVisible(false);
        dm.setVisible(false);
    }//GEN-LAST:event_btnNhapHangActionPerformed

    private void btnHDNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHDNActionPerformed
        // TODO add your handling code here:
        ttcn.setVisible(false);
        dsNhanVien.setVisible(false);
        hdn.setVisible(false);
        dssp.setVisible(false);
        ncc.setVisible(false);
        dm.setVisible(false);
        chartCTHDN.setVisible(true);
    }//GEN-LAST:event_btnHDNActionPerformed

    private void btnHDN1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHDN1ActionPerformed
        // TODO add your handling code here:
        ttcn.setVisible(false);
        dsNhanVien.setVisible(false);
        hdn.setVisible(false);
        dssp.setVisible(false);
        ncc.setVisible(false);
        dm.setVisible(false);
        chartCTHDN.setVisible(false);
        chartHD.setVisible(true);
    }//GEN-LAST:event_btnHDN1ActionPerformed

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
    private javax.swing.JButton btnHDN1;
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
