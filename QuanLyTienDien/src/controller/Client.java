package controller;

import model.DataObject;
import model.ThongTinKhachHangModel;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Arrays;
import model.BienLaiModel;
import model.HoaDonModel;
import model.ThongKeModel;

public class Client {

    private Socket socket;
    private String taiKhoan;
    private ObjectOutputStream outputStream;
    private ObjectInputStream inputStream;

    public Client() {
    }

    public DataObject clientConnection(int port, String taiKhoan) {
        this.taiKhoan = taiKhoan;
        DataObject response = new DataObject();
        try {
            establishConnection(port);

            // Gửi yêu cầu đến server
            sendRequestToServer("getAllData", taiKhoan);

            // Nhận kết quả từ server
            response = (DataObject) inputStream.readObject();

        } catch (Exception e) {
            System.out.println("loi ham ket noi client");
        } finally {
//            disconnectFromServer();
        }
        return response;
    }

    private void sendRequestToServer(String request, Object data) {
        try {
            // Gửi yêu cầu và dữ liệu đến server
            outputStream.writeObject(request);
            outputStream.writeObject(data);
            System.out.println("client send request: " + request);
            System.out.println("client send data: " + data);
            outputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendNewThongTinKhachHangToServer(int port, ThongTinKhachHangModel thongTinKhachHangModel) {
        try {
            establishConnection(port);
            sendRequestToServer("addNewThongTinKhachHang", thongTinKhachHangModel);
            System.out.println("Request: addNewThongTinKhachHang");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void removeAThongTinKhachHangToServer(int port, ThongTinKhachHangModel thongTinKhachHangModel) {
        try {
            establishConnection(port);
            sendRequestToServer("removeThongTinKhachHang", thongTinKhachHangModel);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateAThongTinKhachHangToServer(int port, ThongTinKhachHangModel thongTinKhachHangModel) {
        try {
            establishConnection(port);
            sendRequestToServer("updateThongTinKhachHang", thongTinKhachHangModel);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void sendNewHoaDonToServer(int port, HoaDonModel hoaDonModel) {
        try {
            establishConnection(port);
            sendRequestToServer("addNewHoaDon", hoaDonModel);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void removeHoaDonToServer(int port, HoaDonModel hoaDonModel) {
        try {
            establishConnection(port);
            sendRequestToServer("removeHoaDon", hoaDonModel);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateHoaDonToServer(int port, HoaDonModel hoaDonModel) {
        try {
            establishConnection(port);
            sendRequestToServer("updateHoaDon", hoaDonModel);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ThongTinKhachHangModel getThongTinKhachHang(int port, String taiKhoan, String maSoCongTo) {
        ThongTinKhachHangModel thongTinKhachHangModel = null;
        try {
            establishConnection(port);
            sendRequestToServer("getThongTinKhachHang", maSoCongTo);

            thongTinKhachHangModel = (ThongTinKhachHangModel) inputStream.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return thongTinKhachHangModel;
    }

    public void sendNewBienLaiToServer(int port, BienLaiModel bienLaiModel) {
        try {
            establishConnection(port);
            sendRequestToServer("addBienLai", bienLaiModel);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Double[] getTongTien(int port, String taiKhoan, int nam) {
        Double[] tongTien = null;
        try {
            establishConnection(port);
            sendRequestToServer("getTongTien", nam);

            tongTien = (Double[]) inputStream.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (tongTien == null) {
            tongTien = new Double[12];
            Arrays.fill(tongTien, 0.0);
        }

        return tongTien;
    }

    public void disconnectFromServer() {
        try {
            if (inputStream != null) {
                inputStream.close();
            }
            if (outputStream != null) {
                outputStream.close();
            }
            if (socket != null && !socket.isClosed()) {
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void establishConnection(int port) throws IOException {
        if (socket == null || socket.isClosed()) {
            socket = new Socket("localhost", port);
            outputStream = new ObjectOutputStream(socket.getOutputStream());
            inputStream = new ObjectInputStream(socket.getInputStream());
        }
    }
}
