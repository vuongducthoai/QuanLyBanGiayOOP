/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI;

import dao.NhanVienDAO;
import dao.TaiKhoanDAO;
import java.awt.Color;
import java.awt.Component;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;
import model.NhanVien;
import model.TaiKhoan;

/**
 *
 * @author ADMIN
 */
public class DSNhanVien extends javax.swing.JPanel {

    NhanVienDAO nhanVienDAO = new NhanVienDAO();
    TaiKhoanDAO taiKhoanDAO = new TaiKhoanDAO();
    List<NhanVien> dsNhanVien = null;

    private int maNV;

    private int action = -1;

    /**
     * Creates new form NhanVien2
     */
    public DSNhanVien(int maNV) {
        this.maNV = maNV;
        initComponents();
        loadDSNhanVien();
        disableFields();
        setDisableColor();
    }

    private void loadDSNhanVien() {
        try {
            dsNhanVien = nhanVienDAO.getAllNhanVien();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DSNhanVien.class.getName()).log(Level.SEVERE, null, ex);
        }

        loadDataToTable(dsNhanVien);

    }

    private void loadDataToTable(List<NhanVien> dsNhanVien) {
        DefaultTableModel dt = (DefaultTableModel) tblNhanVien.getModel();
        dt.setRowCount(0);
        TaiKhoan tk = null;
        for (NhanVien nv : dsNhanVien) {
            Vector v = new Vector();
            v.add(nv.getMaNV());
            v.add(nv.getTen());
            v.add(nv.getDiaChi());
            v.add(nv.getGioiTinh());
            v.add(nv.getEmail());
            v.add(nv.getSoDT());

            tk = taiKhoanDAO.getTaiKhoanByMaNV(nv.getMaNV());
            
            v.add(tk.getTenTK());
            v.add(tk.getChucVu());

            dt.addRow(v);

            adjustTableColumnSize(tblNhanVien);
        }
    }

    private void adjustTableColumnSize(JTable table) {

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        for (int i = 0; i < table.getColumnCount(); i++) {
            table.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }

        final TableColumnModel columnModel = table.getColumnModel();

        for (int column = 0; column < table.getColumnCount(); column++) {
            int width = 20;
            for (int row = 0; row < table.getRowCount(); row++) {
                TableCellRenderer renderer = table.getCellRenderer(row, column);
                Component comp = table.prepareRenderer(renderer, row, column);
                width = Math.max(comp.getPreferredSize().width + 1, width);
            }

            int headerWidth = table.getTableHeader().getDefaultRenderer().getTableCellRendererComponent(
                    table, table.getColumnName(column), false, false, -1, column).getPreferredSize().width;
            width = Math.max(width, headerWidth);

            columnModel.getColumn(column).setPreferredWidth(width);
        }
    }

    private void clearFields() {
        txtMaNV.setText("");
        txtHoTen.setText("");
        txtDiaChi.setText("");
        txtEmail.setText("");
        txtSDT.setText("");
        txtTenTK.setText("");
        txtMatKhau.setText("");
        txtNhapLaiMK.setText("");
        cbxGioiTinh.setSelectedIndex(0);
        cbxChucVu.setSelectedIndex(0);
    }

    private void disableFields() {
        txtMaNV.setEnabled(false);
        txtHoTen.setEnabled(false);
        txtDiaChi.setEnabled(false);
        txtEmail.setEnabled(false);
        txtSDT.setEnabled(false);
        txtTenTK.setEnabled(false);
        txtNhapLaiMK.setEnabled(false);
        txtMatKhau.setEnabled(false);
        cbxGioiTinh.setEnabled(false);
        cbxChucVu.setEnabled(false);
    }

    private void setDisableColor() {
        txtMaNV.setBackground(Color.LIGHT_GRAY);
        txtHoTen.setBackground(Color.LIGHT_GRAY);
        txtDiaChi.setBackground(Color.LIGHT_GRAY);
        txtEmail.setBackground(Color.LIGHT_GRAY);
        txtSDT.setBackground(Color.LIGHT_GRAY);
        txtTenTK.setBackground(Color.LIGHT_GRAY);
        txtMatKhau.setBackground(Color.LIGHT_GRAY);
        txtNhapLaiMK.setBackground(Color.LIGHT_GRAY);
        cbxGioiTinh.setBackground(Color.LIGHT_GRAY);
        cbxChucVu.setBackground(Color.LIGHT_GRAY);
    }

    private void enableFields() {
        txtHoTen.setEnabled(true);
        txtDiaChi.setEnabled(true);
        txtEmail.setEnabled(true);
        txtSDT.setEnabled(true);
        if (action == -1 || action == 2) {
            txtTenTK.setEnabled(false);
        } else {
            txtTenTK.setEnabled(true);
        }
        txtMatKhau.setEnabled(true);
        txtNhapLaiMK.setEnabled(true);
        cbxGioiTinh.setEnabled(true);
        cbxChucVu.setEnabled(true);
        txtMaNV.setEnabled(false);
    }

    private void setEnableColor() {
        txtMaNV.setBackground(Color.WHITE);
        txtHoTen.setBackground(Color.WHITE);
        txtDiaChi.setBackground(Color.WHITE);
        txtEmail.setBackground(Color.WHITE);
        txtSDT.setBackground(Color.WHITE);

        if (!(action == -1 || action == 2)) {
            txtTenTK.setBackground(Color.WHITE);
        }

        txtMatKhau.setBackground(Color.WHITE);
        txtNhapLaiMK.setBackground(Color.WHITE);
        cbxGioiTinh.setBackground(Color.WHITE);
        cbxChucVu.setBackground(Color.WHITE);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel7 = new javax.swing.JPanel();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        txtMaNV = new javax.swing.JTextField();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        btnSua = new javax.swing.JButton();
        jLabel46 = new javax.swing.JLabel();
        txtHoTen = new javax.swing.JTextField();
        txtTenTK = new javax.swing.JTextField();
        txtDiaChi = new javax.swing.JTextField();
        jLabel47 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        txtSDT = new javax.swing.JTextField();
        btnTimkiem = new javax.swing.JButton();
        jScrollPane7 = new javax.swing.JScrollPane();
        tblNhanVien = new javax.swing.JTable();
        btnThem = new javax.swing.JButton();
        txtTimKiem = new javax.swing.JTextField();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        cbxChucVu = new javax.swing.JComboBox<>();
        cbxGioiTinh = new javax.swing.JComboBox<>();
        btnXoa = new javax.swing.JButton();
        lblMatKhau = new javax.swing.JLabel();
        txtMatKhau = new javax.swing.JPasswordField();
        lblNhapLaiMK = new javax.swing.JLabel();
        txtNhapLaiMK = new javax.swing.JPasswordField();
        btnDatLai = new javax.swing.JButton();
        btnThucThi = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(877, 563));

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder("Nhân viên"));

        jLabel42.setText("Họ tên:");

        jLabel43.setText("Giới tính:");

        txtMaNV.setDisabledTextColor(new java.awt.Color(153, 153, 153));
        txtMaNV.setEnabled(false);

        jLabel44.setText("Email:");

        jLabel45.setText("Địa chỉ:");

        btnSua.setText("Sửa");
        btnSua.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        jLabel46.setText("Mã nhân viên:");

        txtHoTen.setDisabledTextColor(new java.awt.Color(153, 153, 153));

        txtTenTK.setForeground(new java.awt.Color(0, 0, 0));
        txtTenTK.setToolTipText("");
        txtTenTK.setDisabledTextColor(new java.awt.Color(153, 153, 153));
        txtTenTK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTenTKActionPerformed(evt);
            }
        });

        txtDiaChi.setDisabledTextColor(new java.awt.Color(153, 153, 153));

        jLabel47.setText("SĐT:");

        txtEmail.setDisabledTextColor(new java.awt.Color(153, 153, 153));

        txtSDT.setDisabledTextColor(new java.awt.Color(153, 153, 153));

        btnTimkiem.setText("Tìm");
        btnTimkiem.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnTimkiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimkiemActionPerformed(evt);
            }
        });

        tblNhanVien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã nhân viên", "Họ tên", "Địa chỉ", "Giới tính", "Email", "Số điện thoại", "Tên tài khoản", "Chức vụ"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblNhanVien.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tblNhanVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblNhanVienMouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(tblNhanVien);

        btnThem.setText("Thêm");
        btnThem.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        jLabel48.setText("Tên tài khoản:");

        jLabel49.setText("Chức vụ:");

        cbxChucVu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nhân viên", "Quản lý" }));
        cbxChucVu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        cbxGioiTinh.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nam", "Nữ" }));
        cbxGioiTinh.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        btnXoa.setText("Xóa");
        btnXoa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        lblMatKhau.setText("Mật khẩu:");

        lblNhapLaiMK.setText("Nhập lại:");

        btnDatLai.setText("Đặt lại");
        btnDatLai.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDatLai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDatLaiActionPerformed(evt);
            }
        });

        btnThucThi.setText("Thực thi");
        btnThucThi.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnThucThi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThucThiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(txtTimKiem)
                                .addGap(18, 18, 18)
                                .addComponent(btnTimkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jLabel45, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel46, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel48, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtDiaChi, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE)
                                    .addComponent(txtHoTen, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtMaNV, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtTenTK))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel47, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblNhapLaiMK, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel43, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel44, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)))
                        .addGap(33, 33, 33)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(cbxGioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(35, 35, 35)
                                .addComponent(jLabel49, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cbxChucVu, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtEmail, javax.swing.GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE)
                                    .addComponent(txtSDT)
                                    .addComponent(txtMatKhau)
                                    .addComponent(txtNhapLaiMK))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnThem)
                        .addGap(18, 18, 18)
                        .addComponent(btnSua)
                        .addGap(18, 18, 18)
                        .addComponent(btnXoa)
                        .addGap(19, 19, 19)
                        .addComponent(btnThucThi)
                        .addGap(18, 18, 18)
                        .addComponent(btnDatLai)
                        .addGap(2, 2, 2))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 889, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jPanel7Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {txtDiaChi, txtEmail});

        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel46)
                    .addComponent(txtMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel43)
                    .addComponent(cbxGioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel49)
                    .addComponent(cbxChucVu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel44)
                    .addComponent(jLabel42)
                    .addComponent(txtHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel45)
                    .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel47)
                    .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtMatKhau, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtTenTK, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel48)
                        .addComponent(lblMatKhau)))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtNhapLaiMK, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblNhapLaiMK))
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnTimkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(14, 14, 14)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDatLai, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThucThi, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jPanel7Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {txtMatKhau, txtNhapLaiMK, txtSDT});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtTenTKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTenTKActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTenTKActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        // TODO add your handling code here:
        action = 3;
    }//GEN-LAST:event_btnXoaActionPerformed

    private void tblNhanVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblNhanVienMouseClicked
        // TODO add your handling code here:
        int row = tblNhanVien.getSelectedRow();
        if (row != -1) {
            String maNV = (String) String.valueOf(tblNhanVien.getValueAt(row, 0));
            String ten = (String) tblNhanVien.getValueAt(row, 1);
            String diaChi = (String) tblNhanVien.getValueAt(row, 2);
            String gioiTinh = (String) tblNhanVien.getValueAt(row, 3);
            String email = (String) tblNhanVien.getValueAt(row, 4);
            String soDT = (String) tblNhanVien.getValueAt(row, 5);
            String tenTK = (String) tblNhanVien.getValueAt(row, 6);
            String chucVu = (String) tblNhanVien.getValueAt(row, 7);

            txtMaNV.setText(maNV);
            txtHoTen.setText(ten);
            txtDiaChi.setText(diaChi);
            txtEmail.setText(email);
            txtSDT.setText(soDT);
            txtTenTK.setText(tenTK);

            cbxGioiTinh.setSelectedItem(gioiTinh);
            cbxChucVu.setSelectedItem(chucVu);

        }
    }//GEN-LAST:event_tblNhanVienMouseClicked

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
        action = 1;
        enableFields();
        setEnableColor();
        clearFields();
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        // TODO add your handling code here:
        action = 2;
        enableFields();
        setEnableColor();
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnDatLaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDatLaiActionPerformed
        // TODO add your handling code here:
        clearFields();
        disableFields();
        setDisableColor();
        action = -1;
    }//GEN-LAST:event_btnDatLaiActionPerformed

    private boolean kiemTraDuLieu() {
        if (txtHoTen.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Họ tên không được để trống", "Lỗi", JOptionPane.ERROR_MESSAGE);
            txtHoTen.requestFocus();
            return false;
        }

        if (txtEmail.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Email không được để trống", "Lỗi", JOptionPane.ERROR_MESSAGE);
            txtEmail.requestFocus();
            return false;
        }

        if (!txtEmail.getText().matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
            JOptionPane.showMessageDialog(this, "Email không hợp lệ", "Lỗi", JOptionPane.ERROR_MESSAGE);
            txtEmail.requestFocus();
            return false;
        }

        if (txtDiaChi.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Địa chỉ không được để trống", "Lỗi", JOptionPane.ERROR_MESSAGE);
            txtDiaChi.requestFocus();
            return false;
        }

        if (txtSDT.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Số điện thoại không được để trống", "Lỗi", JOptionPane.ERROR_MESSAGE);
            txtSDT.requestFocus();
            return false;
        }

        if (!txtSDT.getText().matches("\\d{10}")) {
            JOptionPane.showMessageDialog(this, "Số điện thoại không hợp lệ", "Lỗi", JOptionPane.ERROR_MESSAGE);
            txtSDT.requestFocus();
            return false;
        }

        if (txtSDT.getText().length() != 10) {
            JOptionPane.showMessageDialog(this, "Số điện thoại phải đúng 10 chữ số !", "Lỗi", JOptionPane.ERROR_MESSAGE);
            txtSDT.requestFocus();
            return false;
        }

        if (txtTenTK.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Tên tài khoản không được để trống", "Lỗi", JOptionPane.ERROR_MESSAGE);
            txtTenTK.requestFocus();
            return false;
        }

        if (action == 1) {
            if (txtMatKhau.getPassword().length == 0) {
                JOptionPane.showMessageDialog(this, "Mật khẩu không được để trống", "Lỗi", JOptionPane.ERROR_MESSAGE);
                txtMatKhau.requestFocus();
                return false;
            }

            if (txtNhapLaiMK.getPassword().length == 0) {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập lại mật khẩu", "Lỗi", JOptionPane.ERROR_MESSAGE);
                txtNhapLaiMK.requestFocus();
                return false;
            }

            if (!Arrays.equals(txtMatKhau.getPassword(), txtNhapLaiMK.getPassword())) {
                JOptionPane.showMessageDialog(this, "Mật khẩu nhập lại không khớp", "Lỗi", JOptionPane.ERROR_MESSAGE);
                txtNhapLaiMK.requestFocus();
                return false;
            }
        } else if (action == 2) {
            if (txtMatKhau.getPassword().length == 0) {
                return true;
            }

            if (txtNhapLaiMK.getPassword().length == 0) {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập lại mật khẩu", "Lỗi", JOptionPane.ERROR_MESSAGE);
                txtNhapLaiMK.requestFocus();
                return false;
            }

            if (!Arrays.equals(txtMatKhau.getPassword(), txtNhapLaiMK.getPassword())) {
                JOptionPane.showMessageDialog(this, "Mật khẩu nhập lại không khớp", "Lỗi", JOptionPane.ERROR_MESSAGE);
                txtNhapLaiMK.requestFocus();
                return false;
            }
        }

        if (nhanVienDAO.checkEmail(txtEmail.getText().trim())) {
            JOptionPane.showMessageDialog(this, "Email đã tồn tại !", "Lỗi", JOptionPane.ERROR_MESSAGE);
            txtEmail.requestFocus();
            return false;
        }

        if (nhanVienDAO.checkSDT(txtSDT.getText().trim())) {
            JOptionPane.showMessageDialog(this, "Số điện thoại đã tồn tại !", "Lỗi", JOptionPane.ERROR_MESSAGE);
            txtSDT.requestFocus();
            return false;
        }

        if (taiKhoanDAO.checkTenTaiKhoan(txtTenTK.getText().trim())) {
            JOptionPane.showMessageDialog(this, "Tên tài khoản đã tồn tại !", "Lỗi", JOptionPane.ERROR_MESSAGE);
            txtSDT.requestFocus();
            return false;
        }

        return true;
    }

    private void themNhanVien() {

        String hoTen = txtHoTen.getText().trim();
        String gioiTinh = cbxGioiTinh.getSelectedItem().toString().trim();
        String diaChi = txtDiaChi.getText();
        String email = txtEmail.getText();
        String sdt = txtSDT.getText();

        String tenTK = txtTenTK.getText();
        String matKhau = new String(txtMatKhau.getPassword());
        String chucVu = cbxChucVu.getSelectedItem().toString();

        NhanVien nv = new NhanVien(hoTen, diaChi, email, sdt, gioiTinh);

        int maNV = nhanVienDAO.addNhanVien(nv);

        TaiKhoan tk = new TaiKhoan(tenTK, matKhau, chucVu, maNV);

        if (taiKhoanDAO.addTaiKhoan(tk) > 0) {
            JOptionPane.showMessageDialog(this, "Thêm thành công !", "Thêm nhân viên", JOptionPane.INFORMATION_MESSAGE);
        }

    }

    private void suaNhanVien() {

        int maNV = Integer.valueOf(txtMaNV.getText().trim());
        String hoTen = txtHoTen.getText().trim();
        String gioiTinh = cbxGioiTinh.getSelectedItem().toString().trim();
        String diaChi = txtDiaChi.getText();
        String email = txtEmail.getText();
        String sdt = txtSDT.getText();

        String tenTK = txtTenTK.getText();
        String matKhau = new String(txtMatKhau.getPassword());
        String chucVu = cbxChucVu.getSelectedItem().toString();

        NhanVien nv = new NhanVien(maNV, hoTen, diaChi, email, sdt, gioiTinh);

        TaiKhoan tk = new TaiKhoan(tenTK, matKhau, chucVu, maNV);

        if (nhanVienDAO.capNhatNhanVien(nv) > 0 && taiKhoanDAO.capNhapTaiKhoan(tk) > 0) {
            JOptionPane.showMessageDialog(this, "Cập nhật thành công !", "Cập nhật nhân viên", JOptionPane.INFORMATION_MESSAGE);
        }

    }

    private void xoaNhanVien() {
        int choice = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xóa ?", "Xóa nhân viên", JOptionPane.YES_NO_OPTION);

        int maNV = Integer.valueOf(txtMaNV.getText().trim());

        if (choice == JOptionPane.YES_OPTION) {

            if (this.maNV == maNV) {
                JOptionPane.showMessageDialog(this, "Không thể xóa tài nhân viên này !", "Xóa", JOptionPane.INFORMATION_MESSAGE);
                return;
            }

            if (taiKhoanDAO.xoaTaiKhoan(maNV) > 0 && nhanVienDAO.deleteNhanVien(maNV) > 0) {
                JOptionPane.showMessageDialog(this, "Xóa thành công !", "Xóa", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }

    private void btnThucThiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThucThiActionPerformed
        // TODO add your handling code here:

        if (action == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn thao tác !", "Thao tác", JOptionPane.INFORMATION_MESSAGE);
        } else {
            if (action == 1) {
                if (!kiemTraDuLieu()) {
                    return;
                }
                themNhanVien();
            } else if (action == 2) {
                if (txtMaNV.getText().trim().length() == 0) {
                    JOptionPane.showMessageDialog(this, "Vui lòng chọn nhân viên !", "Lỗi", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                if (!kiemTraDuLieu()) {
                    return;
                }
                suaNhanVien();
            } else if (action == 3) {
                if (txtMaNV.getText().trim().length() == 0) {
                    JOptionPane.showMessageDialog(this, "Vui lòng chọn nhân viên !", "Lỗi", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                xoaNhanVien();
            }
            action = -1;
            disableFields();
            setDisableColor();
            clearFields();
            try {
                dsNhanVien = nhanVienDAO.getAllNhanVien();
                loadDataToTable(dsNhanVien);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(DSNhanVien.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }//GEN-LAST:event_btnThucThiActionPerformed

    private void btnTimkiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimkiemActionPerformed
        // TODO add your handling code here:

        txtTimKiem.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                checkTextField();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                checkTextField();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                checkTextField();
            }

            private void checkTextField() {
                String text = txtTimKiem.getText().trim();
                if (text.length() == 0) {
                    loadDSNhanVien();
                }
            }
        });

        String keyword = txtTimKiem.getText().trim();

        if (keyword.isEmpty()) {
            loadDSNhanVien();
        }

        if (keyword.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập thông tin tìm kiếm !", "Tìm kiếm", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        dsNhanVien = nhanVienDAO.searchNhanVien(keyword);
        loadDataToTable(dsNhanVien);
    }//GEN-LAST:event_btnTimkiemActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDatLai;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnThucThi;
    private javax.swing.JButton btnTimkiem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JComboBox<String> cbxChucVu;
    private javax.swing.JComboBox<String> cbxGioiTinh;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JLabel lblMatKhau;
    private javax.swing.JLabel lblNhapLaiMK;
    public javax.swing.JTable tblNhanVien;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtHoTen;
    private javax.swing.JTextField txtMaNV;
    private javax.swing.JPasswordField txtMatKhau;
    private javax.swing.JPasswordField txtNhapLaiMK;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtTenTK;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables
}
