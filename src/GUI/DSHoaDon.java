/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI;

import SQLConnection.DBConnection;
import dao.HoaDonDAO;
import dao.XuatHoaDonDAO;
import dao.ChiTietHoaDonDAO;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.table.DefaultTableModel;
import model.HoaDon;
import model.ChiTietHoaDon;

/**
 *
 * @author ADMIN
 */
public class DSHoaDon extends javax.swing.JPanel {

    /**
     * Creates new form
     */
    private DefaultTableModel tableModel1 = new DefaultTableModel();
    private DefaultTableModel tableModel2 = new DefaultTableModel();

    public DSHoaDon() {
        try {
            initComponents();
            tblDshd.setModel(tableModel1);
            JSpinner.DateEditor editor = new JSpinner.DateEditor(jSpinnerNgaymua, "dd-MM-yyyy");
            jSpinnerNgaymua.setEditor(editor);
            LoadDSHoaDon();
            initMaHD();
            tblDscthd.setModel(tableModel2);
            initMaCTHD();
            LoadDSChiTietHoaDon();
            loadMaKhachHangList();
            loadMaNhanVienList();
            loadMaSanPhamList(); // Tải danh sách mã sản phẩm
            cbbMaSP.addActionListener(evt -> {
                try {
                    loadGiaBan();
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(DSHoaDon.class.getName()).log(Level.SEVERE, null, ex);
                }
            }); // Thêm sự kiện cho cbbMaSP

            // Thêm sự kiện MouseListener cho bảng tblDshd
            tblDshd.addMouseListener(new java.awt.event.MouseAdapter() {
                @Override
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    int selectedRow = tblDshd.getSelectedRow(); // Lấy chỉ số của hàng được chọn
                    if (selectedRow != -1) { // Kiểm tra nếu có hàng được chọn
                        // Lấy dữ liệu từ dòng được chọn
                        String maHD = tblDshd.getValueAt(selectedRow, 0).toString();
                        String maKH = tblDshd.getValueAt(selectedRow, 1).toString();
                        String maNV = tblDshd.getValueAt(selectedRow, 2).toString();
                        String ngayMua = tblDshd.getValueAt(selectedRow, 3).toString();
                        String pTTT = tblDshd.getValueAt(selectedRow, 4).toString();
                        String trangThai = tblDshd.getValueAt(selectedRow, 5).toString();
                        String tongTien = tblDshd.getValueAt(selectedRow, 6).toString();

                        // Hiển thị dữ liệu vào các TextField
                        txtMaHD.setText(maHD);
                        cbbMaKH.setSelectedItem(maKH);
                        cbbMaNV.setSelectedItem(maNV);

                        // Hiển thị ngày mua vào JSpinner
                        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
                        try {
                            Date date = dateFormat.parse(ngayMua); // Chuyển đổi chuỗi sang Date
                            jSpinnerNgaymua.setValue(date); // Thiết lập giá trị cho Spinner
                        } catch (ParseException e) {
                            e.printStackTrace();
                            JOptionPane.showMessageDialog(null, "Định dạng ngày không hợp lệ: " + ngayMua);
                        }

                        cbbPttt.setSelectedItem(pTTT);
                        cbbTrangthai.setSelectedItem(trangThai);
                        txtTongtien.setText(tongTien);
                    }
                }
            });
            // Thêm sự kiện MouseListener cho bảng tblDscthd
            tblDscthd.addMouseListener(new java.awt.event.MouseAdapter() {
                @Override
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    int selectedRow = tblDscthd.getSelectedRow(); // Lấy chỉ số của hàng được chọn
                    if (selectedRow != -1) { // Kiểm tra nếu có hàng được chọn
                        // Lấy dữ liệu từ dòng được chọn
                        String maCTHD = tblDscthd.getValueAt(selectedRow, 0).toString();
                        String maHD = tblDscthd.getValueAt(selectedRow, 1).toString();
                        String maSP = tblDscthd.getValueAt(selectedRow, 2).toString();
                        String soLuong = tblDscthd.getValueAt(selectedRow, 3).toString();
                        String donGiaBan = tblDscthd.getValueAt(selectedRow, 4).toString();

                        // Hiển thị dữ liệu vào các TextField
                        txtMaCTHD.setText(maCTHD);
                        txtMaHDinCTHD.setText(maHD);
                        cbbMaSP.setSelectedItem(maSP);
                        txtSoluong.setText(soLuong);
                        txtGiaban.setText(donGiaBan);
                    }
                }
            });
        } catch (Exception e) {
            // Bắt tất cả các ngoại lệ chung, xử lý lỗi
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Có lỗi xảy ra khi khởi tạo: " + e.getMessage());
        }
    }

    private void initMaHD() {
        try {
            // Kết nối tới cơ sở dữ liệu
            Connection conn = DBConnection.getConnection();

            int nextMaHD = HoaDonDAO.getNextMaHD(conn);

            txtMaHD.setText(String.valueOf(nextMaHD));
        } catch (SQLException | ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Có lỗi xảy ra khi lấy mã hóa đơn: " + ex.getMessage());
        }
    }

    private void initMaCTHD() {
        try {
            // Kết nối tới cơ sở dữ liệu
            Connection conn = DBConnection.getConnection();

            int nextMaCTHD = ChiTietHoaDonDAO.getNextMaCTHD(conn);

            txtMaCTHD.setText(String.valueOf(nextMaCTHD));
        } catch (SQLException | ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Có lỗi xảy ra khi lấy mã hóa đơn: " + ex.getMessage());
        }
    }

    private void loadMaKhachHangList() throws ClassNotFoundException {
        try {
            Connection conn = DBConnection.getConnection();
            List<Integer> maKhachHangList = HoaDonDAO.getMaKhachHangList(conn);
            cbbMaKH.removeAllItems(); // Xóa hết các item cũ
            for (Integer maKH : maKhachHangList) {
                cbbMaKH.addItem(maKH.toString()); // Thêm từng mã khách hàng vào combobox
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Lỗi khi tải danh sách mã khách hàng: " + ex.getMessage());
        }
    }

    private void loadMaNhanVienList() throws ClassNotFoundException {
        try {
            Connection conn = DBConnection.getConnection();
            List<Integer> maNhanVienList = HoaDonDAO.getMaNhanVienList(conn);
            cbbMaNV.removeAllItems();
            for (Integer maNV : maNhanVienList) {
                cbbMaNV.addItem(maNV.toString()); // Thêm từng mã nv vào combobox
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Lỗi khi tải danh sách mã khách hàng: " + ex.getMessage());
        }
    }

    private void loadMaSanPhamList() throws ClassNotFoundException {
        try {
            Connection conn = DBConnection.getConnection();
            List<Integer> maSanPhamList = HoaDonDAO.getMaSanPhamList(conn);

            cbbMaSP.removeAllItems(); // Xóa các item cũ
            for (int maSP : maSanPhamList) {
                cbbMaSP.addItem(String.valueOf(maSP)); // Thêm mã sản phẩm vào combobox
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Lỗi khi tải danh sách mã sản phẩm: " + ex.getMessage());
        }
    }

    private void loadGiaBan() throws ClassNotFoundException {
        try (Connection conn = DBConnection.getConnection()) {
            String selectedMaSP = (String) cbbMaSP.getSelectedItem(); // Lấy mã sản phẩm được chọn
            if (selectedMaSP == null) {
                return; // Nếu combobox chưa có giá trị, không thực hiện
            }

            int maSP = Integer.parseInt(selectedMaSP);
            double giaBan = HoaDonDAO.getGiaBanByMaSP(conn, maSP);

            txtGiaban.setText(String.valueOf(giaBan)); // Hiển thị giá bán lên TextField
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Lỗi khi tải giá bán: " + ex.getMessage());
        }
    }

    private ArrayList<HoaDon> list = new ArrayList<>();

    public void LoadDSHoaDon() throws SQLException, ClassNotFoundException {
        String[] colsName = {"Mã hóa đơn", "Mã khách hàng", "Mã nhân viên", "Ngày mua", "Phương thức TT", "Trạng thái", "Tổng tiền"};
        DefaultTableModel tableModel1 = (DefaultTableModel) tblDshd.getModel();
        tableModel1.setRowCount(0); // Xóa dữ liệu cũ trước khi load mới
        tableModel1.setColumnIdentifiers(colsName);

        Connection conn = DBConnection.getConnection();
        List<HoaDon> list = HoaDonDAO.ListHoaDon(conn);

        for (HoaDon hd : list) {
            String rows[] = new String[7];
            rows[0] = Integer.toString(hd.getMaHD());
            rows[1] = Integer.toString(hd.getMaKH());
            rows[2] = Integer.toString(hd.getMaNV());
            rows[3] = new SimpleDateFormat("dd-MM-yyyy").format(hd.getNgayMua());
            rows[4] = hd.getpTTT();
            rows[5] = hd.getTrangThai();
            rows[6] = Double.toString(hd.getTongTien());
            tableModel1.addRow(rows);
        }
    }

    private ArrayList<ChiTietHoaDon> list2 = new ArrayList<>();

    public void LoadDSChiTietHoaDon() throws SQLException, ClassNotFoundException {
        String[] colsName = {"Mã CTHD", "Mã hóa đơn", "Mã sản phẩm", "Số lượng", "Giá bán"};
        DefaultTableModel tableModel2 = (DefaultTableModel) tblDscthd.getModel();
        tableModel2.setRowCount(0); // Xóa dữ liệu cũ trước khi load mới
        tableModel2.setColumnIdentifiers(colsName);

        Connection conn = DBConnection.getConnection();
        List<ChiTietHoaDon> list2 = ChiTietHoaDonDAO.ListChiTietHoaDon(conn);

        for (ChiTietHoaDon cthd : list2) {
            String rows[] = new String[5];
            rows[0] = Integer.toString(cthd.getMaCTHD());
            rows[1] = Integer.toString(cthd.getMaHD());
            rows[2] = Integer.toString(cthd.getMaSP());
            rows[3] = Integer.toString(cthd.getSoLuong());
            rows[4] = Double.toString(cthd.getDonGiaBan());
            tableModel2.addRow(rows);
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
        txtMaHD = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnSuaHD = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        txtTimkiemHD = new javax.swing.JTextField();
        txtTongtien = new javax.swing.JTextField();
        btnTimkiemHD = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblDshd = new javax.swing.JTable();
        btnThemHD = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jSpinnerNgaymua = new javax.swing.JSpinner();
        jLabel6 = new javax.swing.JLabel();
        cbbPttt = new javax.swing.JComboBox<>();
        cbbTrangthai = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        btnReloadHD = new javax.swing.JButton();
        cbbMaKH = new javax.swing.JComboBox<>();
        cbbMaNV = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        txtMaCTHD = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtMaHDinCTHD = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtSoluong = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtGiaban = new javax.swing.JTextField();
        txtTimkiemCTHD = new javax.swing.JTextField();
        btnTimkiemCTHD = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblDscthd = new javax.swing.JTable();
        btnThemCTHD = new javax.swing.JButton();
        btnXoaCTHD = new javax.swing.JButton();
        btnSuaCTHD = new javax.swing.JButton();
        btnReloadCTHD = new javax.swing.JButton();
        cbbMaSP = new javax.swing.JComboBox<>();
        btnXuathoadon = new javax.swing.JButton();
        txtMaHDxuat = new javax.swing.JTextField();

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Hóa đơn", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N

        jLabel2.setText("Ngày mua:");

        txtMaHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaHDActionPerformed(evt);
            }
        });

        jLabel4.setText("Pttt:");

        jLabel5.setText("Trạng thái:");

        btnSuaHD.setBackground(new java.awt.Color(0, 153, 51));
        btnSuaHD.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSuaHD.setForeground(new java.awt.Color(255, 255, 255));
        btnSuaHD.setText("Sửa");
        btnSuaHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaHDActionPerformed(evt);
            }
        });

        jLabel7.setText("Mã hóa đơn:");

        txtTimkiemHD.setText("Tìm kiếm...");
        txtTimkiemHD.setToolTipText("");
        txtTimkiemHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTimkiemHDActionPerformed(evt);
            }
        });

        btnTimkiemHD.setText("Tìm");
        btnTimkiemHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimkiemHDActionPerformed(evt);
            }
        });

        tblDshd.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã hóa đơn", "Mã khách hàng", "Mã nhân viên", "Ngày mua", "Phương thức TT", "Trạng thái", "Tổng tiền"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblDshd);

        btnThemHD.setBackground(new java.awt.Color(0, 102, 255));
        btnThemHD.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnThemHD.setForeground(new java.awt.Color(255, 255, 255));
        btnThemHD.setText("Thêm");
        btnThemHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemHDActionPerformed(evt);
            }
        });

        jLabel9.setText("Mã KH:");

        jSpinnerNgaymua.setModel(new javax.swing.SpinnerDateModel());

        jLabel6.setText("Tổng tiền:");

        cbbPttt.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Chuyển khoản", "Tiền mặt" }));

        cbbTrangthai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Đã thanh toán", "Chưa thanh toán" }));

        jLabel14.setText("Mã NV:");

        btnReloadHD.setBackground(new java.awt.Color(0, 153, 153));
        btnReloadHD.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnReloadHD.setForeground(new java.awt.Color(255, 255, 255));
        btnReloadHD.setText("Reload");
        btnReloadHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReloadHDActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel14))
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jSpinnerNgaymua, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTongtien))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(cbbMaNV, 0, 143, Short.MAX_VALUE)
                                    .addComponent(txtMaHD))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(26, 26, 26)
                                        .addComponent(cbbPttt, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel9)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(cbbMaKH, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(6, 6, 6))))))
                    .addComponent(jScrollPane2)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(btnReloadHD)
                        .addGap(69, 69, 69)
                        .addComponent(btnThemHD)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSuaHD)
                        .addGap(53, 53, 53))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cbbTrangthai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                        .addComponent(txtTimkiemHD, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnTimkiemHD, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtMaHD, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(cbbMaKH, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cbbPttt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14)
                    .addComponent(cbbMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtTongtien, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jSpinnerNgaymua, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTimkiemHD, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(cbbTrangthai, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTimkiemHD, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSuaHD, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThemHD, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnReloadHD, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Chi tiết hóa đơn", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N

        jLabel8.setText("Mã CTHĐ:");

        txtMaCTHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaCTHDActionPerformed(evt);
            }
        });

        jLabel10.setText("Mã hóa đơn:");

        txtMaHDinCTHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaHDinCTHDActionPerformed(evt);
            }
        });

        jLabel11.setText("Mã sản phẩm:");

        jLabel12.setText("Giá bán:");

        txtSoluong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSoluongActionPerformed(evt);
            }
        });

        jLabel13.setText("Số lượng:");

        txtGiaban.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGiabanActionPerformed(evt);
            }
        });

        txtTimkiemCTHD.setText("Tìm kiếm...");
        txtTimkiemCTHD.setToolTipText("");
        txtTimkiemCTHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTimkiemCTHDActionPerformed(evt);
            }
        });

        btnTimkiemCTHD.setText("Tìm");
        btnTimkiemCTHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimkiemCTHDActionPerformed(evt);
            }
        });

        tblDscthd.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Mã CTHĐ", "Mã hóa đơn", "Mã sản phẩm", "Số lượng", "Giá bán"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Double.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tblDscthd);

        btnThemCTHD.setBackground(new java.awt.Color(0, 102, 255));
        btnThemCTHD.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnThemCTHD.setForeground(new java.awt.Color(255, 255, 255));
        btnThemCTHD.setText("Thêm");
        btnThemCTHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemCTHDActionPerformed(evt);
            }
        });

        btnXoaCTHD.setBackground(new java.awt.Color(255, 0, 0));
        btnXoaCTHD.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnXoaCTHD.setForeground(new java.awt.Color(255, 255, 255));
        btnXoaCTHD.setText("Xóa");
        btnXoaCTHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaCTHDActionPerformed(evt);
            }
        });

        btnSuaCTHD.setBackground(new java.awt.Color(0, 153, 51));
        btnSuaCTHD.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSuaCTHD.setForeground(new java.awt.Color(255, 255, 255));
        btnSuaCTHD.setText("Sửa");
        btnSuaCTHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaCTHDActionPerformed(evt);
            }
        });

        btnReloadCTHD.setBackground(new java.awt.Color(0, 153, 153));
        btnReloadCTHD.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnReloadCTHD.setForeground(new java.awt.Color(255, 255, 255));
        btnReloadCTHD.setText("Reload");
        btnReloadCTHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReloadCTHDActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtTimkiemCTHD, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnTimkiemCTHD)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addComponent(btnReloadCTHD)
                                .addGap(37, 37, 37)
                                .addComponent(btnThemCTHD)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnXoaCTHD)
                                .addGap(34, 34, 34)
                                .addComponent(btnSuaCTHD))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel12))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtMaCTHD)
                                            .addComponent(cbbMaSP, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel13))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtMaHDinCTHD, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
                                            .addComponent(txtSoluong)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(txtGiaban, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE)))))
                        .addGap(19, 19, 19))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtMaCTHD, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(txtMaHDinCTHD, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtSoluong, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(cbbMaSP, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtGiaban, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTimkiemCTHD, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTimkiemCTHD, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThemCTHD, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSuaCTHD, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnReloadCTHD, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXoaCTHD, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15))
        );

        btnXuathoadon.setBackground(new java.awt.Color(0, 153, 153));
        btnXuathoadon.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnXuathoadon.setForeground(new java.awt.Color(255, 255, 255));
        btnXuathoadon.setText("Xuất hóa đơn");
        btnXuathoadon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXuathoadonActionPerformed(evt);
            }
        });

        txtMaHDxuat.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        txtMaHDxuat.setText("Nhập mã hóa đơn để xuất!");
        txtMaHDxuat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaHDxuatActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(308, Short.MAX_VALUE)
                .addComponent(txtMaHDxuat, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnXuathoadon)
                .addGap(309, 309, 309))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnXuathoadon, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMaHDxuat, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtMaHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaHDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaHDActionPerformed

    private void txtTimkiemHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTimkiemHDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTimkiemHDActionPerformed

    private void btnThemHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemHDActionPerformed
        try {
            // Lấy dữ liệu từ các trường trên form
            int maKH = Integer.parseInt(cbbMaKH.getSelectedItem().toString());
            int maNV = Integer.parseInt(cbbMaNV.getSelectedItem().toString());
            Date ngayMua = (Date) jSpinnerNgaymua.getValue();
            String trangThai = cbbTrangthai.getSelectedItem().toString();
            String pTTT = cbbPttt.getSelectedItem().toString();
            double tongTien = Double.parseDouble(txtTongtien.getText());

            // Tạo đối tượng HoaDon
            HoaDon hd = new HoaDon();
            hd.setMaKH(maKH);
            hd.setMaNV(maNV);
            hd.setNgayMua(ngayMua);
            hd.setTrangThai(trangThai);
            hd.setpTTT(pTTT);
            hd.setTongTien(tongTien);

            // Kết nối tới cơ sở dữ liệu và thêm hóa đơn
            Connection conn = DBConnection.getConnection();

            int nextMaHD = HoaDonDAO.getNextMaHD(conn);
            int result = HoaDonDAO.addHoaDon(conn, hd);

            if (result > 0) {
                JOptionPane.showMessageDialog(this, "Thêm hóa đơn thành công!");
                LoadDSHoaDon(); // Cập nhật lại danh sách hóa đơn sau khi thêm
                clearForm1();
                txtMaHDinCTHD.setText(String.valueOf(nextMaHD));
                // Lấy mã hóa đơn tiếp theo từ txtMaHD
                txtMaHD.setText(String.valueOf(nextMaHD + 1));
            } else {
                JOptionPane.showMessageDialog(this, "Thêm hóa đơn thất bại!");
            }

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Dữ liệu không hợp lệ! Vui lòng kiểm tra các trường nhập.");
        } catch (SQLException | ClassNotFoundException e) {
            JOptionPane.showMessageDialog(this, "Có lỗi xảy ra khi thêm hóa đơn: " + e.getMessage());
        }
    }//GEN-LAST:event_btnThemHDActionPerformed

    private void btnXoaCTHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaCTHDActionPerformed
        try {
            // Lấy dữ liệu từ bảng chi tiết hóa đơn
            int selectedRow = tblDscthd.getSelectedRow(); // Lấy chỉ số của hàng được chọn trong bảng chi tiết hóa đơn
            if (selectedRow != -1) { // Kiểm tra nếu có hàng được chọn
                int maCTHD = Integer.parseInt(tblDscthd.getValueAt(selectedRow, 0).toString()); // Lấy mã chi tiết hóa đơn

                // Kết nối tới cơ sở dữ liệu và xóa chi tiết hóa đơn
                Connection conn = DBConnection.getConnection();
                int nextMaCTHD = ChiTietHoaDonDAO.getNextMaCTHD(conn);
                int result = ChiTietHoaDonDAO.deleteChiTietHoaDon(conn, maCTHD);

                if (result > 0) {
                    JOptionPane.showMessageDialog(this, "Xóa chi tiết hóa đơn thành công!");
                    LoadDSChiTietHoaDon(); // Cập nhật lại danh sách chi tiết hóa đơn sau khi xóa
                    clearForm2(); // Xóa các trường nhập liệu trong form chi tiết hóa đơn
                    // Lấy mã ct hóa đơn tiếp theo từ txtMaCTHD
                    txtMaCTHD.setText(String.valueOf(nextMaCTHD + 1));
                } else {
                    JOptionPane.showMessageDialog(this, "Xóa chi tiết hóa đơn thất bại!");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Vui lòng chọn chi tiết hóa đơn để xóa.");
            }
        } catch (SQLException | ClassNotFoundException e) {
            JOptionPane.showMessageDialog(this, "Có lỗi xảy ra khi xóa chi tiết hóa đơn: " + e.getMessage());
        }
    }//GEN-LAST:event_btnXoaCTHDActionPerformed

    private void btnThemCTHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemCTHDActionPerformed
        try {
            // Lấy dữ liệu từ các trường trên form
            int maHD = Integer.parseInt(txtMaHDinCTHD.getText()); // Mã hóa đơn từ ô nhập liệu
            int maSP = Integer.parseInt(cbbMaSP.getSelectedItem().toString()); // Mã sản phẩm từ ô nhập liệu
            int soLuong = Integer.parseInt(txtSoluong.getText()); // Số lượng từ ô nhập liệu
            double donGiaBan = Double.parseDouble(txtGiaban.getText()); // Giá bán từ ô nhập liệu

            // Tạo đối tượng ChiTietHoaDon
            ChiTietHoaDon cthd = new ChiTietHoaDon();
            cthd.setMaHD(maHD);
            cthd.setMaSP(maSP);
            cthd.setSoLuong(soLuong);
            cthd.setDonGiaBan(donGiaBan);

            // Kết nối tới cơ sở dữ liệu và thêm chi tiết hóa đơn
            Connection conn = DBConnection.getConnection();
            int nextMaCTHD = ChiTietHoaDonDAO.getNextMaCTHD(conn);
            int result = ChiTietHoaDonDAO.addChiTietHoaDon(conn, cthd);

            if (result > 0) {
                JOptionPane.showMessageDialog(this, "Thêm chi tiết hóa đơn thành công!");
                LoadDSChiTietHoaDon(); // Cập nhật lại danh sách chi tiết hóa đơn sau khi thêm
                clearForm2(); // Xóa các trường nhập liệu trong form chi tiết hóa đơn
                // Lấy mã ct hóa đơn tiếp theo từ txtMaCTHD
                txtMaCTHD.setText(String.valueOf(nextMaCTHD + 1));
            } else {
                JOptionPane.showMessageDialog(this, "Thêm chi tiết hóa đơn thất bại!");
            }

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Dữ liệu không hợp lệ! Vui lòng kiểm tra các trường nhập.");
        } catch (SQLException | ClassNotFoundException e) {
            JOptionPane.showMessageDialog(this, "Có lỗi xảy ra khi thêm chi tiết hóa đơn: " + e.getMessage());
        }
    }//GEN-LAST:event_btnThemCTHDActionPerformed

    private void txtTimkiemCTHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTimkiemCTHDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTimkiemCTHDActionPerformed

    private void txtGiabanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGiabanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGiabanActionPerformed

    private void txtSoluongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSoluongActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSoluongActionPerformed

    private void txtMaHDinCTHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaHDinCTHDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaHDinCTHDActionPerformed

    private void txtMaCTHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaCTHDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaCTHDActionPerformed

    private void btnSuaHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaHDActionPerformed
        try {
            // Lấy dữ liệu từ các trường trên form
            int maHD = Integer.parseInt(txtMaHD.getText());
            int maNV = Integer.parseInt(cbbMaNV.getSelectedItem().toString());
            int maKH = Integer.parseInt(cbbMaKH.getSelectedItem().toString());
            Date ngayMua = (Date) jSpinnerNgaymua.getValue();
            String trangThai = cbbTrangthai.getSelectedItem().toString();
            String pTTT = cbbPttt.getSelectedItem().toString();
            double tongTien = Double.parseDouble(txtTongtien.getText());

            // Tạo đối tượng HoaDon
            HoaDon hd = new HoaDon();
            hd.setMaHD(maHD);
            hd.setMaNV(maNV);
            hd.setMaKH(maKH);
            hd.setNgayMua(ngayMua);
            hd.setTrangThai(trangThai);
            hd.setpTTT(pTTT);
            hd.setTongTien(tongTien);

            // Kết nối tới cơ sở dữ liệu và cập nhật hóa đơn
            Connection conn = DBConnection.getConnection();
            int nextMaHD = HoaDonDAO.getNextMaHD(conn);
            int result = HoaDonDAO.updateHoaDon(conn, hd);

            if (result > 0) {
                JOptionPane.showMessageDialog(this, "Cập nhật hóa đơn thành công!");
                LoadDSHoaDon(); // Cập nhật lại danh sách hóa đơn sau khi sửa
                clearForm1();
                // Lấy mã hóa đơn tiếp theo từ txtMaHD
                txtMaHD.setText(String.valueOf(nextMaHD + 1));
            } else {
                JOptionPane.showMessageDialog(this, "Cập nhật hóa đơn thất bại!");
            }

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Dữ liệu không hợp lệ! Vui lòng kiểm tra các trường nhập.");
        } catch (SQLException | ClassNotFoundException e) {
            JOptionPane.showMessageDialog(this, "Có lỗi xảy ra khi cập nhật hóa đơn: " + e.getMessage());
        }
    }//GEN-LAST:event_btnSuaHDActionPerformed

    private void btnTimkiemHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimkiemHDActionPerformed
        // Lấy dữ liệu từ ô tìm kiếm
        String keyword = txtTimkiemHD.getText().trim();

        try {
            // Kết nối cơ sở dữ liệu
            Connection conn = DBConnection.getConnection();

            // Gọi phương thức tìm kiếm từ DAO
            List<HoaDon> dsHoaDon = HoaDonDAO.searchHoaDon(conn, keyword);

            // Hiển thị danh sách hóa đơn tìm được lên bảng
            DefaultTableModel model = (DefaultTableModel) tblDshd.getModel();
            model.setRowCount(0); // Xóa dữ liệu cũ trên bảng

            if (dsHoaDon.isEmpty()) {
                // Nếu không tìm thấy hóa đơn, load lại toàn bộ danh sách hóa đơn
                JOptionPane.showMessageDialog(this, "Không tìm thấy hóa đơn nào. Đang tải lại dữ liệu...");
                dsHoaDon = HoaDonDAO.ListHoaDon(conn); // Phương thức lấy toàn bộ hóa đơn
            }

            // Thêm dữ liệu vào bảng
            for (HoaDon hd : dsHoaDon) {
                model.addRow(new Object[]{
                    hd.getMaHD(),
                    hd.getMaKH(),
                    new SimpleDateFormat("dd-MM-yyyy").format(hd.getNgayMua()),
                    hd.getpTTT(),
                    hd.getTrangThai(),
                    hd.getTongTien()
                });
            }
        } catch (SQLException | ClassNotFoundException e) {
            JOptionPane.showMessageDialog(this, "Có lỗi xảy ra khi tìm kiếm: " + e.getMessage());
        }
    }//GEN-LAST:event_btnTimkiemHDActionPerformed

    private void btnSuaCTHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaCTHDActionPerformed
        try {
            // Lấy dữ liệu từ các trường trên form
            int maCTHD = Integer.parseInt(txtMaCTHD.getText());
            int maHD = Integer.parseInt(txtMaHDinCTHD.getText());
            int maSP = Integer.parseInt(cbbMaSP.getSelectedItem().toString());
            int soLuong = Integer.parseInt(txtSoluong.getText());
            double donGiaBan = Double.parseDouble(txtGiaban.getText());

            ChiTietHoaDon cthd = new ChiTietHoaDon();
            cthd.setMaCTHD(maCTHD);
            cthd.setMaHD(maHD);
            cthd.setMaSP(maSP);
            cthd.setSoLuong(soLuong);
            cthd.setDonGiaBan(donGiaBan);

            // Kết nối tới cơ sở dữ liệu và cập nhật hóa đơn
            Connection conn = DBConnection.getConnection();
            int nextMaCTHD = ChiTietHoaDonDAO.getNextMaCTHD(conn);
            int result = ChiTietHoaDonDAO.updateChiTietHoaDon(conn, cthd);

            if (result > 0) {
                JOptionPane.showMessageDialog(this, "Cập nhật chi tiết hóa đơn thành công!");
                LoadDSChiTietHoaDon(); // Cập nhật lại danh sách ct hóa đơn sau khi sửa
                clearForm2();
                // Lấy mã ct hóa đơn tiếp theo từ txtMaCTHD
                txtMaCTHD.setText(String.valueOf(nextMaCTHD + 1));
            } else {
                JOptionPane.showMessageDialog(this, "Cập nhật hóa đơn thất bại!");
            }

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Dữ liệu không hợp lệ! Vui lòng kiểm tra các trường nhập.");
        } catch (SQLException | ClassNotFoundException e) {
            JOptionPane.showMessageDialog(this, "Có lỗi xảy ra khi cập nhật chi tiết hóa đơn: " + e.getMessage());
        }
    }//GEN-LAST:event_btnSuaCTHDActionPerformed

    private void btnTimkiemCTHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimkiemCTHDActionPerformed
        String keyword = txtTimkiemCTHD.getText().trim();

        try {
            // Kết nối cơ sở dữ liệu
            Connection conn = DBConnection.getConnection();

            // Gọi phương thức tìm kiếm từ DAO
            List<ChiTietHoaDon> dsChiTietHoaDon = ChiTietHoaDonDAO.searchChiTietHoaDon(conn, keyword);

            // Hiển thị danh sách hóa đơn tìm được lên bảng
            DefaultTableModel model1 = (DefaultTableModel) tblDscthd.getModel();
            model1.setRowCount(0); // Xóa dữ liệu cũ trên bảng

            if (dsChiTietHoaDon.isEmpty()) {
                // Nếu không tìm thấy ct hóa đơn, load lại toàn bộ danh sách ct hóa đơn
                JOptionPane.showMessageDialog(this, "Không tìm thấy chi tiết hóa đơn nào. Đang tải lại dữ liệu...");
                dsChiTietHoaDon = ChiTietHoaDonDAO.ListChiTietHoaDon(conn); // Phương thức lấy toàn bộ ct hóa đơn
            }

            // Thêm dữ liệu vào bảng
            for (ChiTietHoaDon cthd : dsChiTietHoaDon) {
                model1.addRow(new Object[]{
                    cthd.getMaCTHD(),
                    cthd.getMaHD(),
                    cthd.getMaSP(),
                    cthd.getSoLuong(),
                    cthd.getDonGiaBan()
                });
            }
        } catch (SQLException | ClassNotFoundException e) {
            JOptionPane.showMessageDialog(this, "Có lỗi xảy ra khi tìm kiếm: " + e.getMessage());
        }
    }//GEN-LAST:event_btnTimkiemCTHDActionPerformed

    private void btnReloadHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReloadHDActionPerformed
        clearForm1();
        try {
            LoadDSHoaDon();
            // Kết nối cơ sở dữ liệu
            Connection conn = DBConnection.getConnection();
            int nextMaHD = HoaDonDAO.getNextMaHD(conn);
            // Lấy mã hóa đơn tiếp theo từ txtMaHD
            txtMaHD.setText(String.valueOf(nextMaHD));

        } catch (SQLException | ClassNotFoundException e) {
            JOptionPane.showMessageDialog(this, "Có lỗi xảy ra khi tìm kiếm: " + e.getMessage());
        }
    }//GEN-LAST:event_btnReloadHDActionPerformed

    private void btnReloadCTHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReloadCTHDActionPerformed
        clearForm2();
        try {
            LoadDSChiTietHoaDon();
            // Kết nối cơ sở dữ liệu
            Connection conn = DBConnection.getConnection();
            int nextMaCTHD = ChiTietHoaDonDAO.getNextMaCTHD(conn);
            // Lấy mã hóa đơn tiếp theo từ txtMaHD
            txtMaCTHD.setText(String.valueOf(nextMaCTHD));

        } catch (SQLException | ClassNotFoundException e) {
            JOptionPane.showMessageDialog(this, "Có lỗi xảy ra khi tìm kiếm: " + e.getMessage());
        }
    }//GEN-LAST:event_btnReloadCTHDActionPerformed

    private void btnXuathoadonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXuathoadonActionPerformed
        // Lấy mã hóa đơn từ txtMaHDxuat
        String maHD = txtMaHDxuat.getText().trim();

        // Kiểm tra mã hóa đơn có hợp lệ hay không
        if (maHD.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập mã hóa đơn!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try (Connection conn = DBConnection.getConnection()) {
            // Khởi tạo đối tượng XuatHoaDonDAO
            XuatHoaDonDAO xuatHoaDonDAO = new XuatHoaDonDAO();

            // Đường dẫn lưu file txt
            String filePath = "D:/HoaDon_" + maHD + ".txt"; // Đặt tên file theo mã hóa đơn

            // Gọi phương thức xuất hóa đơn ra file txt
            xuatHoaDonDAO.exportHoaDonToTxt(Integer.parseInt(maHD), conn, filePath);

            // Hiển thị thông báo thành công
            JOptionPane.showMessageDialog(this, "Hóa đơn đã được xuất thành công!", "Thành công", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            // Xử lý lỗi
            JOptionPane.showMessageDialog(this, "Lỗi xuất hóa đơn: " + e.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnXuathoadonActionPerformed

    private void txtMaHDxuatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaHDxuatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaHDxuatActionPerformed

    private void clearForm1() {
        txtTongtien.setText("");
    }

    private void clearForm2() {
        txtMaHDinCTHD.setText("");
        txtSoluong.setText("");
        txtGiaban.setText("");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnReloadCTHD;
    private javax.swing.JButton btnReloadHD;
    private javax.swing.JButton btnSuaCTHD;
    private javax.swing.JButton btnSuaHD;
    private javax.swing.JButton btnThemCTHD;
    private javax.swing.JButton btnThemHD;
    private javax.swing.JButton btnTimkiemCTHD;
    private javax.swing.JButton btnTimkiemHD;
    private javax.swing.JButton btnXoaCTHD;
    private javax.swing.JButton btnXuathoadon;
    private javax.swing.JComboBox<String> cbbMaKH;
    private javax.swing.JComboBox<String> cbbMaNV;
    private javax.swing.JComboBox<String> cbbMaSP;
    private javax.swing.JComboBox<String> cbbPttt;
    private javax.swing.JComboBox<String> cbbTrangthai;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSpinner jSpinnerNgaymua;
    public javax.swing.JTable tblDscthd;
    public javax.swing.JTable tblDshd;
    private javax.swing.JTextField txtGiaban;
    private javax.swing.JTextField txtMaCTHD;
    private javax.swing.JTextField txtMaHD;
    private javax.swing.JTextField txtMaHDinCTHD;
    private javax.swing.JTextField txtMaHDxuat;
    private javax.swing.JTextField txtSoluong;
    private javax.swing.JTextField txtTimkiemCTHD;
    private javax.swing.JTextField txtTimkiemHD;
    private javax.swing.JTextField txtTongtien;
    // End of variables declaration//GEN-END:variables
}
