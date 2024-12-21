/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI;

/**
 *
 * @author DELL
 */
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.SanPham;
import model.DanhMuc;
import dao.QuanLySanPhamDAO;
import SQLConnection.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DSSanPham extends javax.swing.JPanel {

    /**
     * Creates new form DSSanPham
     */
    private DefaultTableModel tableModel = new DefaultTableModel();

    public DSSanPham() {
        try {
            initComponents();
            txtMaSP.setEditable(false);
            tblSanPham.setModel(tableModel);
            LoadDSSanpham();
            initMaSP();
            loadTenDanhMucList(); // Tải danh sách tên danh mục

            cbbSapxep.addActionListener(e -> {
                String selectedOption = cbbSapxep.getSelectedItem().toString();
                QuanLySanPhamDAO dao = new QuanLySanPhamDAO();
                try {
                    List<SanPham> sanPhamList = dao.getSanPhamBySapXep(selectedOption);
                    updateTable(sanPhamList); // Cập nhật bảng với danh sách sản phẩm mới
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(this, "Lỗi khi tải dữ liệu: " + ex.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(DSSanPham.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
            cbbTenDM.addActionListener(evt -> {
                try {
                    loadMaDanhMuc();
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(DSSanPham.class.getName()).log(Level.SEVERE, null, ex);
                }
            }); // Thêm sự kiện cho cbbTenDM
            txtMaDM.getDocument().addDocumentListener(new javax.swing.event.DocumentListener() {
                @Override
                public void insertUpdate(javax.swing.event.DocumentEvent e) {
                    try {
                        setTenDanhMucFromMaDM();
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(DSSanPham.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

                @Override
                public void removeUpdate(javax.swing.event.DocumentEvent e) {
                    try {
                        setTenDanhMucFromMaDM();
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(DSSanPham.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

                @Override
                public void changedUpdate(javax.swing.event.DocumentEvent e) {
                    try {
                        setTenDanhMucFromMaDM();
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(DSSanPham.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            });

            // Thêm sự kiện MouseListener cho bảng
            tblSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
                @Override
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    int selectedRow = tblSanPham.getSelectedRow(); // Lấy chỉ số của hàng được chọn
                    if (selectedRow != -1) { // Kiểm tra nếu có hàng được chọn
                        // Lấy dữ liệu từ các cột của hàng được chọn
                        String maSP = tblSanPham.getValueAt(selectedRow, 0).toString();
                        String tenSP = tblSanPham.getValueAt(selectedRow, 1).toString();
                        String giaNhap = tblSanPham.getValueAt(selectedRow, 2).toString();
                        String giaBan = tblSanPham.getValueAt(selectedRow, 3).toString();
                        String maDM = tblSanPham.getValueAt(selectedRow, 4).toString();

                        // Đưa dữ liệu vào các JTextField tương ứng
                        txtMaSP.setText(maSP);
                        txtTenSP.setText(tenSP);
                        txtGiaNhap.setText(giaNhap);
                        txtGiaBan.setText(giaBan);
                        txtMaDM.setText(maDM);
                    }
                }
            });
        } catch (SQLException e) {
            // Xử lý lỗi, ví dụ: in thông báo lỗi
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Có lỗi xảy ra khi kết nối cơ sở dữ liệu: " + e.getMessage());
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DSSanPham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }

    private void initMaSP() {
        try {

            Connection conn = DBConnection.getConnection();

            int nextMaSP = QuanLySanPhamDAO.getNextMaSP(conn);

            txtMaSP.setText(String.valueOf(nextMaSP));
        } catch (SQLException | ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Có lỗi xảy ra khi lấy mã khách hàng: " + ex.getMessage());
        }
    }

    private void loadTenDanhMucList() throws ClassNotFoundException {
        try (Connection conn = DBConnection.getConnection()) {
            List<String> tenDanhMucList = QuanLySanPhamDAO.getTenDanhMucList(conn);

            cbbTenDM.removeAllItems(); // Xóa các item cũ
            for (String tenDM : tenDanhMucList) {
                cbbTenDM.addItem(tenDM); // Thêm tên danh mục vào combobox
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Lỗi khi tải danh sách tên danh mục: " + ex.getMessage());
        }
    }

    private void loadMaDanhMuc() throws ClassNotFoundException {
        try (Connection conn = DBConnection.getConnection()) {
            String selectedTenDM = (String) cbbTenDM.getSelectedItem(); // Lấy tên danh mục được chọn
            if (selectedTenDM == null) {
                return; // Nếu combobox chưa có giá trị, không thực hiện
            }

            int maDM = QuanLySanPhamDAO.getMaDanhMucByTenDM(conn, selectedTenDM);

            txtMaDM.setText(String.valueOf(maDM)); // Hiển thị mã danh mục lên TextField
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Lỗi khi tải mã danh mục: " + ex.getMessage());
        }
    }

    private void setTenDanhMucFromMaDM() throws ClassNotFoundException {
        try (Connection conn = DBConnection.getConnection()) {
            String maDMText = txtMaDM.getText(); // Lấy mã danh mục từ TextField
            if (maDMText == null || maDMText.trim().isEmpty()) {
                return; // Nếu mã danh mục trống, không thực hiện
            }

            int maDM = Integer.parseInt(maDMText); // Chuyển đổi mã danh mục sang số nguyên
            String tenDM = QuanLySanPhamDAO.getTenDanhMucByMaDM(conn, maDM);

            cbbTenDM.setSelectedItem(tenDM); // Thiết lập tên danh mục tương ứng trong combobox
        } catch (NumberFormatException e) {
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Lỗi khi tải tên danh mục: " + ex.getMessage());
        }
    }

    private void updateTable(List<SanPham> sanPhamList) {
        DefaultTableModel model = (DefaultTableModel) tblSanPham.getModel();
        model.setRowCount(0); // Xóa dữ liệu cũ trong bảng

        for (SanPham sp : sanPhamList) {
            model.addRow(new Object[]{
                sp.getMaSP(),
                sp.getTenSP(),
                sp.getDonGiaNhap(),
                sp.getDonGiaBan(),
                sp.getDanhMuc() != null ? sp.getDanhMuc().getTenDM() : "N/A"
            });
        }
    }

    private ArrayList<SanPham> list = new ArrayList<>();

    public void LoadDSSanpham() throws SQLException, ClassNotFoundException {
        String[] colsName = {"Mã sản phẩm", "Tên sản phẩm", "Giá nhập", "Giá bán", "Mã danh mục", "Số lượng"};
        DefaultTableModel tableModel = (DefaultTableModel) tblSanPham.getModel();
        tableModel.setRowCount(0); // Xóa dữ liệu cũ trước khi load mới
        tableModel.setColumnIdentifiers(colsName);

        Connection conn = DBConnection.getConnection();
        List<SanPham> list = QuanLySanPhamDAO.ListSanPham(conn);

        for (SanPham sp : list) {
            String rows[] = new String[6];
            rows[0] = Integer.toString(sp.getMaSP());          // Mã sản phẩm
            rows[1] = sp.getTenSP();                          // Tên sản phẩm
            rows[2] = Double.toString(sp.getDonGiaNhap());    // Giá nhập
            rows[3] = Double.toString(sp.getDonGiaBan());     // Giá bán
            rows[4] = Integer.toString(sp.getDanhMuc().getMaDM()); // Lấy mã danh mục thay vì tên danh mục
            rows[5] = Integer.toString(sp.getSoLuong());
            tableModel.addRow(rows);
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
        txtGiaNhap = new javax.swing.JTextField();
        btnSua = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        txtTenSP = new javax.swing.JTextField();
        btnTimkiem = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblSanPham = new javax.swing.JTable();
        btnXoa = new javax.swing.JButton();
        txtTimKiem = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        cbbTenDM = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        txtMaSP = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtGiaBan = new javax.swing.JTextField();
        btnReloadSP = new javax.swing.JButton();
        txtMaDM = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        cbbSapxep = new javax.swing.JComboBox<>();
        btnXuatfile = new javax.swing.JButton();

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Quản lý sản phẩm", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N
        jPanel2.setAutoscrolls(true);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("Tên sản phẩm:");

        btnSua.setBackground(new java.awt.Color(0, 204, 102));
        btnSua.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSua.setForeground(new java.awt.Color(255, 255, 255));
        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setText("Mã sản phẩm:");

        txtTenSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTenSPActionPerformed(evt);
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

        tblSanPham.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        tblSanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Mã sản phẩm", "Tên sản phẩm", "Giá nhập", "Giá bán", "Mã danh Mục", "Số lượng"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Double.class, java.lang.Double.class, java.lang.Integer.class, java.lang.Integer.class
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
        jScrollPane2.setViewportView(tblSanPham);

        btnXoa.setBackground(new java.awt.Color(255, 0, 0));
        btnXoa.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnXoa.setForeground(new java.awt.Color(255, 255, 255));
        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        txtTimKiem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtTimKiemKeyPressed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel9.setText("Mã danh mục:");

        cbbTenDM.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbbTenDM.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5" }));
        cbbTenDM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbTenDMActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel10.setText("Đơn giá nhập:");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel11.setText("Đơn giá bán:");

        btnReloadSP.setBackground(new java.awt.Color(0, 153, 153));
        btnReloadSP.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnReloadSP.setForeground(new java.awt.Color(255, 255, 255));
        btnReloadSP.setText("Reload");
        btnReloadSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReloadSPActionPerformed(evt);
            }
        });

        txtMaDM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaDMActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setText("Sắp xếp:");

        cbbSapxep.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mặc định", "Giá bán từ thấp đến cao", "Giá bán từ cao đến thấp", "Mã sản phẩm giảm dần" }));

        btnXuatfile.setBackground(new java.awt.Color(0, 153, 153));
        btnXuatfile.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnXuatfile.setForeground(new java.awt.Color(255, 255, 255));
        btnXuatfile.setText("Xuất file");
        btnXuatfile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXuatfileActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtMaDM, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(cbbTenDM, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                            .addComponent(jLabel2)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(txtTenSP))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                            .addComponent(jLabel7)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(txtMaSP, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(86, 86, 86)
                                        .addComponent(jLabel10))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(88, 88, 88)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel1)
                                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtGiaBan, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtGiaNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbbSapxep, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 665, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnTimkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                            .addGap(189, 189, 189)
                            .addComponent(btnReloadSP, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(71, 71, 71)
                            .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(76, 76, 76)
                            .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(68, 68, 68)
                            .addComponent(btnXuatfile, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 872, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtGiaNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(txtMaSP, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtTenSP, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(txtGiaBan, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtMaDM, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbbTenDM)
                    .addComponent(jLabel1)
                    .addComponent(cbbSapxep, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTimkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                    .addComponent(btnReloadSP, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                    .addComponent(btnXoa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSua)
                    .addComponent(btnXuatfile))
                .addGap(16, 16, 16))
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

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        // Lấy mã sản phẩm từ txtMaSP
        String maSPStr = txtMaSP.getText();

        // Kiểm tra nếu mã sản phẩm trống
        if (maSPStr.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập mã sản phẩm cần xóa.");
            return;
        }

        try {
            // Chuyển mã sản phẩm sang kiểu int
            int maSP = Integer.parseInt(maSPStr);

            // Xác nhận hành động xóa
            int confirm = JOptionPane.showConfirmDialog(null,
                    "Bạn có chắc chắn muốn xóa sản phẩm có mã: " + maSP + "?",
                    "Xác nhận xóa",
                    JOptionPane.YES_NO_OPTION);

            if (confirm == JOptionPane.YES_OPTION) {
                // Kết nối tới cơ sở dữ liệu và xóa sản phẩm
                Connection conn = DBConnection.getConnection();
                int nextMaSP = QuanLySanPhamDAO.getNextMaSP(conn);
                int result = QuanLySanPhamDAO.deleteSanPham(conn, maSP);

                if (result > 0) {
                    // Nếu xóa thành công, thông báo cho người dùng và làm mới danh sách
                    JOptionPane.showMessageDialog(null, "Xóa sản phẩm thành công!");
                    LoadDSSanpham();  // Tải lại danh sách sản phẩm
                    clearForm();  // Xóa các trường nhập liệu
                    // Lấy mã sp  tiếp theo từ txtMaSP
                    txtMaSP.setText(String.valueOf(nextMaSP + 1));
                } else {
                    JOptionPane.showMessageDialog(null, "Xóa sản phẩm thất bại!");
                }
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Mã sản phẩm phải là một số hợp lệ.");
        } catch (SQLException | ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Có lỗi xảy ra khi xóa sản phẩm: " + e.getMessage());
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void cbbTenDMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbTenDMActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbbTenDMActionPerformed

    private void txtTenSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTenSPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTenSPActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        // Lấy dữ liệu từ các trường nhập liệu
        String maSPStr = txtMaSP.getText();
        String tenSP = txtTenSP.getText();
        String giaNhapStr = txtGiaNhap.getText();
        String giaBanStr = txtGiaBan.getText();
        String maDMStr = txtMaDM.getText();

        // Kiểm tra xem các trường nhập liệu có trống không
        if (maSPStr.isEmpty() || tenSP.isEmpty() || giaNhapStr.isEmpty() || giaBanStr.isEmpty() || maDMStr.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Vui lòng điền đầy đủ thông tin sản phẩm.");
            return;
        }

        try {
            // Chuyển đổi mã sản phẩm, giá nhập, giá bán và mã danh mục
            int maSP = Integer.parseInt(maSPStr);
            double giaNhap = Double.parseDouble(giaNhapStr);
            double giaBan = Double.parseDouble(giaBanStr);
            int maDM = Integer.parseInt(maDMStr);

            // Tạo đối tượng SanPham và DanhMuc
            DanhMuc danhMuc = new DanhMuc(maDM, "");
            SanPham sanPham = new SanPham(maSP, tenSP, giaNhap, giaBan, danhMuc);

            // Kết nối tới cơ sở dữ liệu và cập nhật sản phẩm
            Connection conn = DBConnection.getConnection();
            int nextMaSP = QuanLySanPhamDAO.getNextMaSP(conn);
            int result = QuanLySanPhamDAO.updateSanPham(conn, sanPham);

            if (result > 0) {
                // Nếu sửa thành công, thông báo cho người dùng và làm mới danh sách
                JOptionPane.showMessageDialog(null, "Sửa sản phẩm thành công!");
                LoadDSSanpham();  // Tải lại danh sách sản phẩm
                clearForm();  // Xóa các trường nhập liệu
                // Lấy mã sp  tiếp theo từ txtMaSP
                txtMaSP.setText(String.valueOf(nextMaSP + 1));
            } else {
                JOptionPane.showMessageDialog(null, "Sửa sản phẩm thất bại!");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Mã sản phẩm, giá nhập, giá bán và mã danh mục phải là các giá trị hợp lệ.");
        } catch (SQLException | ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Có lỗi xảy ra khi sửa sản phẩm: " + e.getMessage());
        }
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnTimkiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimkiemActionPerformed
        // Lấy dữ liệu từ ô tìm kiếm
        String keyword = txtTimKiem.getText().trim();

        try {
            // Kết nối cơ sở dữ liệu
            Connection conn = DBConnection.getConnection();

            // Gọi phương thức tìm kiếm từ DAO
            List<SanPham> dsSanPham = QuanLySanPhamDAO.searchSanPham(conn, keyword);

            // Hiển thị danh sách sản phẩm tìm được lên bảng
            DefaultTableModel model = (DefaultTableModel) tblSanPham.getModel();
            model.setRowCount(0); // Xóa dữ liệu cũ trên bảng

            if (dsSanPham.isEmpty()) {
                // Nếu không tìm thấy sản phẩm, load lại toàn bộ danh sách sản phẩm
                JOptionPane.showMessageDialog(this, "Không tìm thấy sản phẩm nào. Đang tải lại dữ liệu...");
                dsSanPham = QuanLySanPhamDAO.ListSanPham(conn); // Phương thức lấy toàn bộ sản phẩm
            }

            for (SanPham sp : dsSanPham) {
                model.addRow(new Object[]{
                    sp.getMaSP(),
                    sp.getTenSP(),
                    sp.getDonGiaNhap(),
                    sp.getDonGiaBan(),
                    sp.getDanhMuc().getMaDM()
                });
            }
        } catch (SQLException | ClassNotFoundException e) {
            JOptionPane.showMessageDialog(this, "Có lỗi xảy ra khi tìm kiếm: " + e.getMessage());
        }
    }//GEN-LAST:event_btnTimkiemActionPerformed

    private void btnReloadSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReloadSPActionPerformed
        clearForm();
        try {
            LoadDSSanpham();
            // Kết nối cơ sở dữ liệu
            Connection conn = DBConnection.getConnection();
            int nextMaSP = QuanLySanPhamDAO.getNextMaSP(conn);
            // Lấy mã sp tiếp theo từ txtMaSP
            txtMaSP.setText(String.valueOf(nextMaSP));

        } catch (SQLException | ClassNotFoundException e) {
            JOptionPane.showMessageDialog(this, "Có lỗi xảy ra khi tìm kiếm: " + e.getMessage());
        }
    }//GEN-LAST:event_btnReloadSPActionPerformed

    private void txtMaDMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaDMActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaDMActionPerformed

    private void btnXuatfileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXuatfileActionPerformed
        // TODO add your handling code here:
        String filePath = "D:\\danh_sach_san_pham.txt";
        QuanLySanPhamDAO qlspDAO = new QuanLySanPhamDAO();

        try {
            qlspDAO.xuatFileSanPham(filePath);
            JOptionPane.showMessageDialog(this, "Xuất file thành công: " + filePath);
        } catch (SQLException | IOException ex) {
            JOptionPane.showMessageDialog(this, "Lỗi khi xuất file: " + ex.getMessage());
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DSSanPham.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnXuatfileActionPerformed

    private void txtTimKiemKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKiemKeyPressed
        // TODO add your handling code here:
        String keyword = txtTimKiem.getText().trim();

        try {
            // Kết nối cơ sở dữ liệu
            Connection conn = DBConnection.getConnection();

            // Gọi phương thức tìm kiếm từ DAO
            List<SanPham> dsSanPham = QuanLySanPhamDAO.searchSanPham(conn, keyword);

            // Hiển thị danh sách sản phẩm tìm được lên bảng
            DefaultTableModel model = (DefaultTableModel) tblSanPham.getModel();
            model.setRowCount(0); // Xóa dữ liệu cũ trên bảng

            if (dsSanPham.isEmpty()) {
                // Nếu không tìm thấy sản phẩm, load lại toàn bộ danh sách sản phẩm
                dsSanPham = QuanLySanPhamDAO.ListSanPham(conn); // Phương thức lấy toàn bộ sản phẩm
            }

            for (SanPham sp : dsSanPham) {
                model.addRow(new Object[]{
                    sp.getMaSP(),
                    sp.getTenSP(),
                    sp.getDonGiaNhap(),
                    sp.getDonGiaBan(),
                    sp.getDanhMuc().getMaDM()
                });
            }
        } catch (SQLException | ClassNotFoundException e) {
            JOptionPane.showMessageDialog(this, "Có lỗi xảy ra khi tìm kiếm: " + e.getMessage());
        }
    }//GEN-LAST:event_txtTimKiemKeyPressed

    private void clearForm() {
        txtMaSP.setText("");
        txtTenSP.setText("");
        txtGiaNhap.setText("");
        txtGiaBan.setText("");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnReloadSP;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnTimkiem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JButton btnXuatfile;
    private javax.swing.JComboBox<String> cbbSapxep;
    private javax.swing.JComboBox<String> cbbTenDM;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    public javax.swing.JTable tblSanPham;
    private javax.swing.JTextField txtGiaBan;
    private javax.swing.JTextField txtGiaNhap;
    private javax.swing.JTextField txtMaDM;
    private javax.swing.JTextField txtMaSP;
    private javax.swing.JTextField txtTenSP;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables
}
