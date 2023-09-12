package dao;

import database.JDBCUtil;
import java.awt.Component;
import model.ThongTinKhachHangModel;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ThongTinKhachHangDAO {

    public static ThongTinKhachHangDAO getInstance() {
        return new ThongTinKhachHangDAO();
    }

    public int insert(ThongTinKhachHangModel t) {
        int ketQua = 0;
        try {
            // Bước 1: tạo kết nối đến CSDL
            Connection con = JDBCUtil.getConnection();

            // Bước 2: tạo ra đối tượng PreparedStatement
            String sql = "INSERT INTO thongtinkhachhang (taiKhoan, maSoCongTo, hotenChuNha, soDienThoai, diaChi, phong) "
                    + "VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement st = con.prepareStatement(sql);

            // Bước 3: truyền giá trị cho các tham số
            st.setString(1, t.getTaiKhoan());
            st.setString(2, t.getMaSoCongTo());
            st.setString(3, t.getHoTenChuNha());
            st.setString(4, t.getSoDienThoai());
            st.setString(5, t.getDiaChi());
            st.setString(6, t.getPhong());

            // Bước 4: thực thi câu lệnh SQL
            ketQua = st.executeUpdate();

            // Bước 5: sử lí kết quả đầu ra
            System.out.println("Bạn đã thực thi: " + sql);
            System.out.println("Có " + ketQua + " dòng bị thay đổi!");

            // Bước 6: ngắt kết nối với CSDL
            JDBCUtil.closeConnection(con);
        } catch (SQLException e) {
            Component clientView = null;
            // TODO Auto-generated catch block
            JOptionPane.showMessageDialog(clientView, "Khách Hàng đã tồn tại!");
            System.out.println("Khach Hang da ton tai");
        }

        return ketQua;
    }

    public int delete(ThongTinKhachHangModel t) {
        int ketQua = 0;
        try {
            // Bước 1: tạo kết nối đến CSDL
            Connection con = JDBCUtil.getConnection();

            // Bước 2: tạo ra đối tượng PreparedStatement
            String sql = "DELETE FROM thongtinkhachhang WHERE taiKhoan = ? AND maSoCongTo = ?";
            PreparedStatement st = con.prepareStatement(sql);

            // Bước 3: truyền giá trị cho các tham số
            st.setString(1, t.getTaiKhoan());
            st.setString(2, t.getMaSoCongTo());

            // Bước 4: thực thi câu lệnh SQL
            ketQua = st.executeUpdate();

            // Bước 5:
            System.out.println("Bạn đã thực thi: " + sql);
            System.out.println("Có " + ketQua + " dòng bị thay đổi!");

            // Bước 6:
            JDBCUtil.closeConnection(con);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return ketQua;
    }

    public int update(ThongTinKhachHangModel t) {
        int ketQua = 0;
        try {
            // Bước 1: tạo kết nối đến CSDL
            Connection con = JDBCUtil.getConnection();

            // Bước 2: tạo ra đối tượng PreparedStatement
            String sql = "UPDATE thongtinkhachhang "
                    + "SET hoTenChuNha = ?, soDienThoai = ?, diaChi = ?, phong = ? "
                    + "WHERE taiKhoan = ? AND maSoCongTo = ?";
            PreparedStatement st = con.prepareStatement(sql);

            // Bước 3: truyền giá trị cho các tham số
            st.setString(1, t.getHoTenChuNha());
            st.setString(2, t.getSoDienThoai());
            st.setString(3, t.getDiaChi());
            st.setString(4, t.getPhong());
            st.setString(5, t.getTaiKhoan());
            st.setString(6, t.getMaSoCongTo());

            // Bước 4: thực thi câu lệnh SQL
            ketQua = st.executeUpdate();

            // Bước 5:
            System.out.println("Bạn đã thực thi: " + sql);
            System.out.println("Có " + ketQua + " dòng bị thay đổi!");

            // Bước 6:
            JDBCUtil.closeConnection(con);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return ketQua;
    }

    public ArrayList<ThongTinKhachHangModel> selectAll(String taiKhoan) {
        ArrayList<ThongTinKhachHangModel> ketQua = new ArrayList<ThongTinKhachHangModel>();
        try {
            // Bước 1: tạo kết nối đến CSDL
            Connection con = JDBCUtil.getConnection();

            // Bước 2: tạo ra đối tượng PreparedStatement
            String sql = "SELECT * FROM thongtinkhachhang WHERE taiKhoan = ?";
            PreparedStatement st = con.prepareStatement(sql);

            // Bước 3: truyền giá trị cho các tham số
            st.setString(1, taiKhoan);

            // Bước 4: thực thi câu lệnh SQL
            ResultSet rs = st.executeQuery();

            // Bước 5:
            while (rs.next()) {
                String maSoCongTo = rs.getString("maSoCongTo");
                String hotenChuNha = rs.getString("hotenChuNha");
                String soDienThoai = rs.getString("soDienThoai");
                String diaChi = rs.getString("diaChi");
                String phong = rs.getString("phong");

                ThongTinKhachHangModel thongTinKhachHangModel = new ThongTinKhachHangModel(maSoCongTo, hotenChuNha, soDienThoai, diaChi, phong);
                ketQua.add(thongTinKhachHangModel);
            }

            // Bước 6:
            JDBCUtil.closeConnection(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ketQua;
    }

    public ThongTinKhachHangModel getThongTinKhachHang(String taiKhoan, String maSoCongTo) {
        ThongTinKhachHangModel thongTinKhachHangModel = null;
        try {
            // Bước 1: Tạo kết nối đến CSDL
            Connection con = JDBCUtil.getConnection();

            // Bước 2: Tạo đối tượng PreparedStatement
            String sql = "SELECT * FROM thongtinkhachhang WHERE taiKhoan = ? AND maSoCongTo = ?";
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, taiKhoan);
            preparedStatement.setString(2, maSoCongTo);

            // Bước 3: Thực thi câu lệnh SQL
            ResultSet resultSet = preparedStatement.executeQuery();

            // Bước 4: Xử lý kết quả đầu ra
            if (resultSet.next()) {
                // Lấy thông tin từ ResultSet và tạo đối tượng ThongTinKhachHangModel
                String maSoCongToResult = resultSet.getString("maSoCongTo");
                String hoTenChuNha = resultSet.getString("hoTenChuNha");
                String soDienThoai = resultSet.getString("soDienThoai");
                String diaChi = resultSet.getString("diaChi");
                String phong = resultSet.getString("phong");

                thongTinKhachHangModel = new ThongTinKhachHangModel(maSoCongToResult, hoTenChuNha, soDienThoai, diaChi, phong);
            }

            // Bước 5: Ngắt kết nối với CSDL
            JDBCUtil.closeConnection(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return thongTinKhachHangModel;
    }
}
