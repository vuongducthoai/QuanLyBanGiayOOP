/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import model.TaiKhoan;

/**
 *
 * @author ADMIN
 */
public class NhanVien extends javax.swing.JFrame {

    DSKhachHang kh = new DSKhachHang();
    DSHoaDon hd = new DSHoaDon();
    ThongTinCaNhan ttcn = null;

    /**
     * Creates new form NhanVien
     */
    public NhanVien() {
        initComponents();
        setTab();
    }

    public NhanVien(TaiKhoan tk) {
        initComponents();
        ttcn = new ThongTinCaNhan(tk);

        lblChucVu.setText(lblChucVu.getText() + tk.getChucVu());
        lblHoVaTen.setText(lblHoVaTen.getText() + tk.getNv().getTen());
        setTab();
    }

    private void setTab() {
        panelMain.add(kh);
        panelMain.add(hd);
        panelMain.add(ttcn);
        ttcn.setVisible(true);
        kh.setVisible(false);
        hd.setVisible(false);
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
        btnHoaDon = new javax.swing.JButton();
        btnDangXuat = new javax.swing.JButton();
        btnTTCN = new javax.swing.JButton();
        btnKhachHang = new javax.swing.JButton();
        lblChucVu = new javax.swing.JLabel();
        lblHoVaTen = new javax.swing.JLabel();
        panelMain = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Quản lý bán giày");
        setPreferredSize(new java.awt.Dimension(1200, 600));

        panelTab.setBackground(new java.awt.Color(0, 102, 102));

        btnHoaDon.setText("Hóa đơn");
        btnHoaDon.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHoaDonActionPerformed(evt);
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

        btnKhachHang.setText("Khách hàng");
        btnKhachHang.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnKhachHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKhachHangActionPerformed(evt);
            }
        });

        lblChucVu.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblChucVu.setForeground(new java.awt.Color(255, 255, 255));
        lblChucVu.setText("Chức vụ: ");

        lblHoVaTen.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblHoVaTen.setForeground(new java.awt.Color(255, 255, 255));
        lblHoVaTen.setText("Họ và tên: ");

        javax.swing.GroupLayout panelTabLayout = new javax.swing.GroupLayout(panelTab);
        panelTab.setLayout(panelTabLayout);
        panelTabLayout.setHorizontalGroup(
            panelTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTabLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(panelTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTTCN, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDangXuat, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelTabLayout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addGroup(panelTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblChucVu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblHoVaTen, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        panelTabLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnDangXuat, btnHoaDon, btnKhachHang, btnTTCN});

        panelTabLayout.setVerticalGroup(
            panelTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTabLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(lblHoVaTen)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblChucVu)
                .addGap(22, 22, 22)
                .addComponent(btnTTCN, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 327, Short.MAX_VALUE)
                .addComponent(btnDangXuat, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );

        panelTabLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnDangXuat, btnHoaDon});

        getContentPane().add(panelTab, java.awt.BorderLayout.LINE_START);

        panelMain.setLayout(new java.awt.CardLayout());
        getContentPane().add(panelMain, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHoaDonActionPerformed
        // TODO add your handling code here:kh.setVisible(true);
        ttcn.setVisible(false);
        hd.setVisible(true);
        kh.setVisible(false);
    }//GEN-LAST:event_btnHoaDonActionPerformed

    private void btnDangXuatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDangXuatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDangXuatActionPerformed

    private void btnTTCNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTTCNActionPerformed
        // TODO add your handling code here:
        ttcn.setVisible(true);
        hd.setVisible(false);
        kh.setVisible(false);
    }//GEN-LAST:event_btnTTCNActionPerformed

    private void btnKhachHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKhachHangActionPerformed
        // TODO add your handling code here:
        ttcn.setVisible(false);
        kh.setVisible(true);
        hd.setVisible(false);
    }//GEN-LAST:event_btnKhachHangActionPerformed

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
            java.util.logging.Logger.getLogger(NhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                NhanVien nv = new NhanVien();
                nv.setLocationRelativeTo(null);
                nv.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDangXuat;
    private javax.swing.JButton btnHoaDon;
    private javax.swing.JButton btnKhachHang;
    private javax.swing.JButton btnTTCN;
    private javax.swing.JLabel lblChucVu;
    private javax.swing.JLabel lblHoVaTen;
    private javax.swing.JPanel panelMain;
    private javax.swing.JPanel panelTab;
    // End of variables declaration//GEN-END:variables
}
