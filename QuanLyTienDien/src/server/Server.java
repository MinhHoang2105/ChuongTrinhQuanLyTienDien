/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package server;

import controller.*;
import view.*;
import dao.BienLaiDAO;
import dao.HoaDonDAO;
import dao.ThongTinKhachHangDAO;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.List;
import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.Serializable;
import java.util.ArrayList;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLServerSocket;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.SwingUtilities;
import model.BienLaiModel;
import model.DataObject;
import model.HoaDonModel;
import model.SerializableJList;
import model.ThongKeModel;
import model.ThongTinKhachHangModel;

/**
 *
 * @author minh
 */
public class Server extends javax.swing.JFrame {

    private volatile boolean isRunning;
    ServerSocket serverSocket;
    Socket clientSocket;
    DefaultListModel defaultListModelChat = new DefaultListModel();
    DefaultListModel defaultListModelTuongTac = new DefaultListModel();

    /**
     * Creates new form serverView
     */
    public Server() {
        initComponents();
        this.setTitle("Server View");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocation(20, 100);
        this.setSize(450, 570);
        this.setIcon();
    }

    public void setIcon() {
        // Lấy kích thước của JFrame
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;

        // Thiết lập kích thước của JLabel để phủ hết cửa sổ
        jLabel_bgr.setBounds(0, 0, screenWidth, screenHeight);
        jLabel_bgr.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(Server.class
                .getResource("/img/bgr_server.jpg"))));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jTextField_port = new javax.swing.JTextField();
        jButton_batDau = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jList_tuongTac = new javax.swing.JList<>();
        jLabel_bgr = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Bảng Client tương tác với Server");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, 370, -1));

        jTextField_port.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jTextField_port.setText("8888");
        jTextField_port.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_portActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField_port, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 30, 120, 30));

        jButton_batDau.setBackground(new java.awt.Color(0, 204, 255));
        jButton_batDau.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButton_batDau.setForeground(new java.awt.Color(255, 255, 255));
        jButton_batDau.setText("Bắt Đầu");
        jButton_batDau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_batDauActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_batDau, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 30, 80, 30));

        jLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("PORT NO.");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, 70, -1));

        jList_tuongTac.setBackground(new java.awt.Color(102, 255, 255));
        jList_tuongTac.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jScrollPane4.setViewportView(jList_tuongTac);

        getContentPane().add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 460, 430));
        getContentPane().add(jLabel_bgr, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 460, 210));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField_portActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_portActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_portActionPerformed

    public void setTextTuongTac(String text) {
        defaultListModelTuongTac.addElement(text);
        jList_tuongTac.setModel(defaultListModelTuongTac);
    }


    private void jButton_batDauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_batDauActionPerformed
        int port = Integer.parseInt(jTextField_port.getText());

        Thread serverThread = new Thread(() -> {
            startServer(port);
        });
        serverThread.start();
    }//GEN-LAST:event_jButton_batDauActionPerformed

    private void startServer(int port) {
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Server is running and waiting for connections...");
            setTextTuongTac("Server đang chạy và đang đợi các kết nối...");
            while (true) {
                Socket clientSocket = serverSocket.accept();
                if (clientSocket.isClosed()) {
                    System.out.println("clientSocket da dong");
                }
                Thread clientThread = new Thread(() -> {
                    handleClientRequest(clientSocket);
                });
                clientThread.start();
            }
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void handleClientRequest(Socket socket) {
        try {
            ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
            ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
            String request = (String) inputStream.readObject();
            String taiKhoan = inputStream.readObject().toString();

            while (!socket.isClosed() && socket.isConnected()) {

                System.out.println("Request: " + request);
                System.out.println("taiKhoan: " + taiKhoan);

                if (request.equals("getAllData")) {
                    DataObject response = handleRequest(taiKhoan);
                    String text = "Tài khoản " + taiKhoan + " đã lấy dữ liệu của 3 bảng";

                    if (!socket.isClosed() && socket.isConnected()) {
                        outputStream.writeObject(response);
                        outputStream.flush();
                        SwingUtilities.invokeLater(() -> {
                            setTextTuongTac("Tài khoản " + taiKhoan + " đã kết nối với Server ở địa chỉ: " + socket.getInetAddress());
                            setTextTuongTac(text);
                        });
                    }
                } else if (request.equals("addNewThongTinKhachHang")) {
                    ThongTinKhachHangModel thongTinKhachHangModel = (ThongTinKhachHangModel) inputStream.readObject();
                    ThongTinKhachHangDAO.getInstance().insert(thongTinKhachHangModel);
                    String text = "Tài khoản " + taiKhoan + " đã thêm vào một khách hàng mới";

                    if (!socket.isClosed() && socket.isConnected()) {
                        SwingUtilities.invokeLater(() -> {
                            setTextTuongTac(text);
                        });
                    }
                } else if (request.equals("removeThongTinKhachHang")) {
                    ThongTinKhachHangModel thongTinKhachHangModel = (ThongTinKhachHangModel) inputStream.readObject();
                    ThongTinKhachHangDAO.getInstance().delete(thongTinKhachHangModel);
                    String text = "Tài khoản " + taiKhoan + " đã xóa một khách hàng";

                    if (!socket.isClosed() && socket.isConnected()) {
                        SwingUtilities.invokeLater(() -> {
                            setTextTuongTac(text);
                        });
                    }
                } else if (request.equals("updateThongTinKhachHang")) {
                    ThongTinKhachHangModel thongTinKhachHangModel = (ThongTinKhachHangModel) inputStream.readObject();
                    ThongTinKhachHangDAO.getInstance().update(thongTinKhachHangModel);
                    String text = "Tài khoản " + taiKhoan + " đã sửa thông tin của một khách hàng";

                    if (!socket.isClosed() && socket.isConnected()) {
                        SwingUtilities.invokeLater(() -> {
                            setTextTuongTac(text);
                        });
                    }
                } else if (request.equals("addNewHoaDon")) {
                    HoaDonModel hoaDonModel = (HoaDonModel) inputStream.readObject();
                    HoaDonDAO.getInstance().insert(hoaDonModel);
                    String text = "Tài khoản " + taiKhoan + " đã thêm vào một hóa đơn [" + hoaDonModel.getMaHoaDon() + "]";

                    if (!socket.isClosed() && socket.isConnected()) {
                        SwingUtilities.invokeLater(() -> {
                            setTextTuongTac(text);
                        });
                    }
                } else if (request.equals("removeHoaDon")) {
                    HoaDonModel hoaDonModel = (HoaDonModel) inputStream.readObject();
                    HoaDonDAO.getInstance().delete(hoaDonModel);
                    String text = "Tài khoản " + taiKhoan + " đã xóa một hóa đơn [" + hoaDonModel.getMaHoaDon() + "]";

                    if (!socket.isClosed() && socket.isConnected()) {
                        SwingUtilities.invokeLater(() -> {
                            setTextTuongTac(text);
                        });
                    }
                } else if (request.equals("updateHoaDon")) {
                    HoaDonModel hoaDonModel = (HoaDonModel) inputStream.readObject();
                    HoaDonDAO.getInstance().update(hoaDonModel);
                    String text = "Tài khoản " + taiKhoan + " đã sửa thông tin của hóa đơn [" + hoaDonModel.getMaHoaDon() + "]";

                    if (!socket.isClosed() && socket.isConnected()) {
                        SwingUtilities.invokeLater(() -> {
                            setTextTuongTac(text);
                        });
                    }
                } else if (request.equals("getThongTinKhachHang")) {
                    String maSoCongTo = (String) inputStream.readObject();
                    ThongTinKhachHangModel thongTinKhachHangModel = ThongTinKhachHangDAO.getInstance().getThongTinKhachHang(taiKhoan, maSoCongTo);

                    if (!socket.isClosed() && socket.isConnected()) {
                        outputStream.writeObject(thongTinKhachHangModel);
                        outputStream.flush();
                        String text = "Tài khoản " + taiKhoan + " đã lấy thông tin khách hàng có mã số công tơ [" + thongTinKhachHangModel.getMaSoCongTo() + "]";
                        SwingUtilities.invokeLater(() -> {
                            setTextTuongTac(text);
                        });
                    }
                } else if (request.equals("addBienLai")) {
                    BienLaiModel bienLaiModel = (BienLaiModel) inputStream.readObject();
                    BienLaiDAO.getInstance().insert(bienLaiModel);
                    String text = "Tài khoản " + taiKhoan + " đã tạo ra biên lai [" + bienLaiModel.getMaHoaDon() + "]";

                    if (!socket.isClosed() && socket.isConnected()) {
                        SwingUtilities.invokeLater(() -> {
                            setTextTuongTac(text);
                        });
                    }
                } else if (request.equals("getTongTien")) {
                    int nam = (int) inputStream.readObject();
                    Double[] tongTien = new Double[12];
                    for (int i = 0; i < 12; i++) {
                        tongTien[i] = BienLaiDAO.getInstance().tongTienThang(taiKhoan, i + 1, nam);
                        if (Double.isNaN(tongTien[i]) || Double.isInfinite(tongTien[i])) {
                            tongTien[i] = 0.0;
                        }
                    }

                    if (!socket.isClosed() && socket.isConnected()) {
                        outputStream.writeObject(tongTien);
                        outputStream.flush();
                    }
                }

                // Kiểm tra lại kết nối trước khi tiếp tục vòng lặp
                if (socket.isClosed() || !socket.isConnected()) {
                    System.out.println("socket da ket thuc sau 1 yeu cau");
                    break;
                }
                // Đọc yêu cầu tiếp theo từ client
                request = (String) inputStream.readObject();
            }
        } catch (EOFException e) {
            // Xử lý khi client đóng kết nối
            System.out.println("Client đã đóng kết nối");
//            e.printStackTrace();
            setTextTuongTac("Không có client nào kết nối đến sever");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private DataObject handleRequest(String taiKhoan) {
        // Xử lý yêu cầu từ client và trả về kết quả tương ứng
        DataObject response = new DataObject();

        // Logic để lấy dữ liệu và thêm vào response
        ArrayList<ThongTinKhachHangModel> dataThonTinHoaDon = ThongTinKhachHangDAO.getInstance().selectAll(taiKhoan);
        ArrayList<HoaDonModel> dataHoaDon = HoaDonDAO.getInstance().selectAll(taiKhoan);
        ArrayList<BienLaiModel> dataBienLai = BienLaiDAO.getInstance().selectAll(taiKhoan);

        response.setListThongTinKhachHang(dataThonTinHoaDon);
        response.setListHoaDon(dataHoaDon);
        response.setListBienLai(dataBienLai);

        return response;
    }

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
            java.util.logging.Logger.getLogger(Server.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Server.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Server.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Server.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Server().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_batDau;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel_bgr;
    private javax.swing.JList<String> jList_tuongTac;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextField jTextField_port;
    // End of variables declaration//GEN-END:variables

}
