/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package client;

import server.Server;
import view.*;
import dao.NguoiDungDAO;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author minh
 */
public class DangNhapView extends javax.swing.JFrame {

    /**
     * Creates new form DangNhapView
     */
    public DangNhapView() {
        initComponents();
        this.setSize(470, 310);
        this.setLocation(650, 300);
        jButton_hienThiMatKhau.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(DangNhapView.class.getResource("/img/icon_eye.png"))));

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel_matKhau3 = new javax.swing.JLabel();
        jButton_DangKiTaiKhoan = new javax.swing.JButton();
        jButton_dangNhap = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel_taiKhoan3 = new javax.swing.JLabel();
        jTextField_taiKhoanDangNhap = new javax.swing.JTextField();
        jPasswordField_matKhau = new javax.swing.JPasswordField();
        jButton_hienThiMatKhau = new javax.swing.JButton();
        jComboBox_phanQuen = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel_matKhau3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel_matKhau3.setForeground(new java.awt.Color(51, 153, 255));
        jLabel_matKhau3.setText("Mật Khẩu:");
        getContentPane().add(jLabel_matKhau3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, 101, 29));

        jButton_DangKiTaiKhoan.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jButton_DangKiTaiKhoan.setForeground(new java.awt.Color(51, 153, 255));
        jButton_DangKiTaiKhoan.setText("Đăng kí tài khoản");
        jButton_DangKiTaiKhoan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_DangKiTaiKhoanActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_DangKiTaiKhoan, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 200, -1, -1));

        jButton_dangNhap.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jButton_dangNhap.setForeground(new java.awt.Color(51, 153, 255));
        jButton_dangNhap.setText("Đăng Nhập");
        jButton_dangNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_dangNhapActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_dangNhap, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 200, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 153, 255));
        jLabel3.setText("ĐĂNG NHẬP");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 20, 180, 27));

        jLabel_taiKhoan3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel_taiKhoan3.setForeground(new java.awt.Color(51, 153, 255));
        jLabel_taiKhoan3.setText("Tài Khoản: ");
        getContentPane().add(jLabel_taiKhoan3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, 101, 29));

        jTextField_taiKhoanDangNhap.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jTextField_taiKhoanDangNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_taiKhoanDangNhapActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField_taiKhoanDangNhap, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 70, 195, 30));

        jPasswordField_matKhau.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        getContentPane().add(jPasswordField_matKhau, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 130, 195, 30));

        jButton_hienThiMatKhau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_hienThiMatKhauActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_hienThiMatKhau, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 130, -1, 30));

        jComboBox_phanQuen.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jComboBox_phanQuen.setForeground(new java.awt.Color(51, 204, 255));
        jComboBox_phanQuen.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Admin", "Khách hàng" }));
        getContentPane().add(jComboBox_phanQuen, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 70, -1, 30));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_DangKiTaiKhoanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_DangKiTaiKhoanActionPerformed
        dispose();
        DangKiView dk = new DangKiView();
        dk.show();
    }//GEN-LAST:event_jButton_DangKiTaiKhoanActionPerformed

    private void jButton_hienThiMatKhauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_hienThiMatKhauActionPerformed
        // TODO add your handling code here:  
        // Kiểm tra trạng thái hiển thị mật khẩu
        if (jPasswordField_matKhau.getEchoChar() == 0) {
            // Mật khẩu đang được hiển thị, chuyển sang chế độ ẩn
            jPasswordField_matKhau.setEchoChar('*');
        } else {
            // Mật khẩu đang ẩn, chuyển sang chế độ hiển thị
            jPasswordField_matKhau.setEchoChar((char) 0);
        }
    }//GEN-LAST:event_jButton_hienThiMatKhauActionPerformed

    private void jButton_dangNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_dangNhapActionPerformed
        // TODO add your handling code here:
        String taiKhoan = jTextField_taiKhoanDangNhap.getText();
        char[] charMatKhau = jPasswordField_matKhau.getPassword();
        String matKhau = new String(charMatKhau);
//        System.out.println("taiKhoan: " + taiKhoan + "\nmatKhau: " + matKhau);
        
        NguoiDungDAO nguoiDungDAO = new NguoiDungDAO();
        if(jComboBox_phanQuen.getSelectedItem().equals("Admin") && taiKhoan.equals("admin") && matKhau.equals("123")){
            Server server = new Server();
            server.show();
        }else if (nguoiDungDAO.checkCredentials(taiKhoan, matKhau) && jComboBox_phanQuen.getSelectedItem().equals("Khách hàng")) {
            System.out.println("Đăng nhập thành công");
            client.ClientView cv = new ClientView(taiKhoan);
            cv.show();
        } else {
            JOptionPane.showMessageDialog(this, "Đăng nhập thất bại");
        }
    }//GEN-LAST:event_jButton_dangNhapActionPerformed

    private void jTextField_taiKhoanDangNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_taiKhoanDangNhapActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_taiKhoanDangNhapActionPerformed

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
            java.util.logging.Logger.getLogger(DangNhapView.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DangNhapView.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DangNhapView.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DangNhapView.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DangNhapView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_DangKiTaiKhoan;
    private javax.swing.JButton jButton_dangNhap;
    private javax.swing.JButton jButton_hienThiMatKhau;
    private javax.swing.JComboBox<String> jComboBox_phanQuen;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel_matKhau3;
    private javax.swing.JLabel jLabel_taiKhoan3;
    private javax.swing.JPasswordField jPasswordField_matKhau;
    private javax.swing.JTextField jTextField_taiKhoanDangNhap;
    // End of variables declaration//GEN-END:variables
}