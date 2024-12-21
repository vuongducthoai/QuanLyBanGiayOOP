/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import DAO.HoaDonNhapDAO;
import SQLConnection.DBConnection;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.JPanel;
import model.HoaDon;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author Asus
 */
public class ChartHoaDon extends javax.swing.JFrame {

    /**
     * Creates new form ChartCTHDN
     */
    private DBConnection conn;

    public ChartHoaDon() {
        initComponents();
        for (int i = 1; i <= 12; i++) {
            cmbMonth.addItem(i); // Add integers for months
        }
        for (int i = 2020; i <= 2034; i++) {
            cmbYear.addItem(i); // Add integers for years
        }
        setDataToChartHoaDonNhap(jPanel1);
    }

    public void setDataToChartHoaDonNhap(JPanel jpnItem) {
        try {
            // Gọi hàm thongKe để lấy dữ liệu từ cơ sở dữ liệu
            List<HoaDon> listItem = HoaDonNhapDAO.thongKeHD(conn.getConnection());

            // Tạo dataset cho biểu đồ
            DefaultCategoryDataset dataset = new DefaultCategoryDataset();

            if (listItem != null) {
                for (HoaDon item : listItem) {
                    // Sử dụng NgayNhap và TongTien để làm dữ liệu cho biểu đồ
                    // Format NgayNhap thành chuỗi ngày tháng cho trục X, TongTien cho trục Y
                    String ngayMuaFormatted = new SimpleDateFormat("yyyy-MM-dd").format(item.getNgayMua());
                    double tongTien = item.getTongTien();
                    dataset.addValue(tongTien, "Tổng Tiền", ngayMuaFormatted);
                }
            }

            // Tạo biểu đồ từ dataset
            JFreeChart barChart = ChartFactory.createBarChart(
                    "Biểu đồ thống kê  doanh thu", // Tiêu đề
                    "Ngày Mua", // Trục X
                    "Tổng Tiền", // Trục Y
                    dataset, // Dataset
                    PlotOrientation.VERTICAL, // Định dạng biểu đồ (dọc)
                    false, // Không hiển thị chú thích
                    true, // Hiển thị tooltip
                    false // Không hiển thị URL
            );

            // Lấy trục Y và chỉnh sửa khoảng cách giữa các ticks
            CategoryPlot plot = (CategoryPlot) barChart.getPlot();
            NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();

            // Tạo một ChartPanel để chứa biểu đồ với kích thước mới
            ChartPanel chartPanel = new ChartPanel(barChart);
            chartPanel.setPreferredSize(new Dimension(jpnItem.getWidth(), 700)); // Đặt kích thước của biểu đồ
            // Xóa các thành phần cũ và thêm biểu đồ vào JPanel
            jpnItem.removeAll();
            jpnItem.setLayout(new CardLayout());
            jpnItem.add(chartPanel);
            jpnItem.validate(); // Cập nhật lại layout
            jpnItem.repaint();  // Vẽ lại JPanel
        } catch (SQLException ex) {
//            Logger.getLogger(ChartHDN.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(ChartHDN.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setDataToChartHoaDonNhap1(JPanel jpnItem) {
        try {
            int month = (Integer) cmbMonth.getSelectedItem();
            int year = (Integer) cmbYear.getSelectedItem();

            // Gọi hàm thongKe để lấy dữ liệu từ cơ sở dữ liệu
            List<HoaDon> listItem = HoaDonNhapDAO.thongKeHDByMonthOrYear(conn.getConnection(), month, year);

            // Tạo dataset cho biểu đồ
            DefaultCategoryDataset dataset = new DefaultCategoryDataset();

            if (listItem != null) {
                for (HoaDon item : listItem) {
                    // Sử dụng NgayNhap và TongTien để làm dữ liệu cho biểu đồ
                    // Format NgayNhap thành chuỗi ngày tháng cho trục X, TongTien cho trục Y
                    String ngayNhapFormatted = new SimpleDateFormat("yyyy-MM-dd").format(item.getNgayMua());
                    double tongTien = item.getTongTien();
                    dataset.addValue(tongTien, "Tổng Tiền", ngayNhapFormatted);
                }
            }

            // Tạo biểu đồ từ dataset
            JFreeChart barChart = ChartFactory.createBarChart(
                    "Biểu đồ thống kê doanh thu", // Tiêu đề
                    "Ngày Mua", // Trục X
                    "Tổng Tiền", // Trục Y
                    dataset, // Dataset
                    PlotOrientation.VERTICAL, // Định dạng biểu đồ (dọc)
                    false, // Không hiển thị chú thích
                    true, // Hiển thị tooltip
                    false // Không hiển thị URL
            );

            // Lấy trục Y và chỉnh sửa khoảng cách giữa các ticks
            CategoryPlot plot = (CategoryPlot) barChart.getPlot();
            NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();

            // Tạo một ChartPanel để chứa biểu đồ với kích thước mới
            ChartPanel chartPanel = new ChartPanel(barChart);
            chartPanel.setPreferredSize(new Dimension(jpnItem.getWidth(), 700)); // Đặt kích thước của biểu đồ
            // Xóa các thành phần cũ và thêm biểu đồ vào JPanel
//            jpnItem.removeAll();
            jpnItem.setLayout(new CardLayout());
            jpnItem.add(chartPanel);
            jpnItem.validate(); // Cập nhật lại layout
            jpnItem.repaint();  // Vẽ lại JPanel
        } catch (SQLException ex) {
//            Logger.getLogger(ChartHDN.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(ChartHDN.class.getName()).log(Level.SEVERE, null, ex);
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

        jPanel1 = new javax.swing.JPanel();
        cmbMonth = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cmbYear = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1266, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        cmbMonth.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setText("Month");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("Year");

        cmbYear.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        jButton1.setBackground(new java.awt.Color(102, 255, 51));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton1.setText("Filter");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbMonth, 0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbYear, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmbMonth, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cmbYear, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 452, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        jPanel1.removeAll();
        jPanel1.revalidate();
        jPanel1.repaint();

        // Add a new chart to jPanel1
        setDataToChartHoaDonNhap1(jPanel1);
//        setDataToChartHoaDonNhap1(jPanel1);
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(ChartHoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ChartHoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ChartHoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ChartHoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ChartHoaDon().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<Integer> cmbMonth;
    private javax.swing.JComboBox<Integer> cmbYear;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
