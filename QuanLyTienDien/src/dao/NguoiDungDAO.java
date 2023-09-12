/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import database.JDBCUtil;
import java.sql.*;
import java.util.ArrayList;
import model.NguoiDungModel;

/**
 *
 * @author minh
 */
public class NguoiDungDAO {

    public NguoiDungDAO getInstance() {
        return new NguoiDungDAO();
    }

    public int insert(NguoiDungModel t) {
        int ketQua = 0;
        try {
            // Bước 1: tạo kết nối đến CSDL
            Connection con = JDBCUtil.getConnection();

            // Bước 2: tạo ra đối tượng PreparedStatement
            String sql = "INSERT INTO nguoidung (taiKhoan, matKhau, soDienThoai, email) "
                    + "VALUES (?, ?, ?, ?)";
            PreparedStatement st = con.prepareStatement(sql);

            // Bước 3: truyền giá trị cho các tham số
            st.setString(1, t.getTaiKhoan());
            st.setString(2, t.getMatKhau());
            st.setString(3, t.getSoDienThoai());
            st.setString(4, t.getEmail());

            // Bước 4: thực thi câu lệnh SQL
            ketQua = st.executeUpdate();

            // Bước 5: sử lí kết quả đầu ra
            System.out.println("Bạn đã thực thi: " + sql);
            System.out.println("Có " + ketQua + " dòng bị thay đổi!");

            // Bước 6: ngắt kết nối với CSDL
            JDBCUtil.closeConnection(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ketQua;
    }

    public int delete(NguoiDungModel t) {
        int ketQua = 0;
        try {
            // Bước 1: tạo kết nối đến CSDL
            Connection con = JDBCUtil.getConnection();

            // Bước 2: tạo ra đối tượng PreparedStatement
            String sql = "DELETE FROM nguoidung WHERE taiKhoan = ? AND matKhau = ?";
            PreparedStatement st = con.prepareStatement(sql);

            // Bước 3: truyền giá trị cho các tham số
            st.setString(1, t.getTaiKhoan());
            st.setString(2, t.getMatKhau());

            // Bước 4: thực thi câu lệnh SQL
            ketQua = st.executeUpdate();

            // Bước 5:
            System.out.println("Bạn đã thực thi: " + sql);
            System.out.println("Có " + ketQua + " dòng bị thay đổi!");

            // Bước 6:
            JDBCUtil.closeConnection(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ketQua;
    }

    public int update(NguoiDungModel t) {
        int ketQua = 0;
        try {
            // Bước 1: tạo kết nối đến CSDL
            Connection con = JDBCUtil.getConnection();

            // Bước 2: tạo ra đối tượng PreparedStatement
            String sql = "UPDATE nguoidung "
                    + "SET matKhau = ?, email = ?, soDienThoai = ? "
                    + "WHERE taiKhoan = ?";
            PreparedStatement st = con.prepareStatement(sql);

            // Bước 3: truyền giá trị cho các tham số
            st.setString(1, t.getMatKhau());
            st.setString(2, t.getEmail());
            st.setString(3, t.getSoDienThoai());
            st.setString(4, t.getTaiKhoan());

            // Bước 4: thực thi câu lệnh SQL
            ketQua = st.executeUpdate();

            // Bước 5:
            System.out.println("Bạn đã thực thi: " + sql);
            System.out.println("Có " + ketQua + " dòng bị thay đổi!");

            // Bước 6:
            JDBCUtil.closeConnection(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ketQua;
    }

    public ArrayList<NguoiDungModel> selectAll() {
        ArrayList<NguoiDungModel> ketQua = new ArrayList<NguoiDungModel>();
        try {
            // Bước 1: tạo kết nối đến CSDL
            Connection con = JDBCUtil.getConnection();

            // Bước 2: tạo ra đối tượng PreparedStatement
            String sql = "SELECT * FROM nguoidung";
            PreparedStatement st = con.prepareStatement(sql);

            // Bước 3: thực thi câu lệnh SQL
            ResultSet rs = st.executeQuery();

            // Bước 4:
            while (rs.next()) {
                String matKhau = rs.getString("matKhau");
                String taiKhoan = rs.getString("taiKhoan");
                String email = rs.getString("email");
                String soDienThoai = rs.getString("soDienThoai");

                NguoiDungModel nguoiDungModel = new NguoiDungModel(taiKhoan, matKhau, email, soDienThoai);

                ketQua.add(nguoiDungModel);
            }

            // Bước 5:
            JDBCUtil.closeConnection(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ketQua;
    }

    public boolean checkCredentials(String taiKhoan, String matKhau) {
        boolean isValid = false;
        try {
            // Bước 1: tạo kết nối đến CSDL
            Connection con = JDBCUtil.getConnection();

            // Bước 2: tạo đối tượng CallableStatement
            String sql = "{CALL check_credentials(?, ?)}";
            CallableStatement cs = con.prepareCall(sql);

            // Thiết lập giá trị đối số cho CallableStatement
            cs.setString(1, taiKhoan);
            cs.setString(2, matKhau);

            // Bước 3: thực thi câu lệnh SQL
            ResultSet rs = cs.executeQuery();

            // Bước 4: kiểm tra kết quả
            if (rs.next()) {
                isValid = true;
            }

            // Bước 5: đóng kết nối
            JDBCUtil.closeConnection(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return isValid;
    }
// Hàm đăng kí người dùng

    public boolean registerUser(String taiKhoan, String matKhau, String email, String soDienThoai) {
        boolean isSuccess = false;
        try {
            // Bước 1: Tạo kết nối đến CSDL
            Connection con = JDBCUtil.getConnection();

            // Bước 2: Tạo đối tượng CallableStatement
            String sql = "{CALL register_user(?, ?, ?, ?)}";
            CallableStatement cs = con.prepareCall(sql);

            // Thiết lập giá trị đối số cho CallableStatement
            cs.setString(1, taiKhoan);
            cs.setString(2, matKhau);
            cs.setString(3, email);
            cs.setString(4, soDienThoai);

            // Bước 3: Thực thi câu lệnh SQL
            int rowsAffected = cs.executeUpdate();

            // Bước 4: Kiểm tra kết quả
            if (rowsAffected > 0) {
                isSuccess = true;
            }

            // Bước 5: Đóng kết nối
            JDBCUtil.closeConnection(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return isSuccess;
    }

// Hàm kiểm tra tài khoản đã tồn tại hay chưa
    public boolean checkAccountExists(String taiKhoan) {
        boolean isExists = false;
        try {
            // Bước 1: Tạo kết nối đến CSDL
            Connection con = JDBCUtil.getConnection();

            // Bước 2: Tạo đối tượng CallableStatement
            String sql = "{CALL check_account_exists(?)}";
            CallableStatement cs = con.prepareCall(sql);

            // Thiết lập giá trị đối số cho CallableStatement
            cs.setString(1, taiKhoan);

            // Bước 3: Thực thi câu lệnh SQL
            ResultSet rs = cs.executeQuery();

            // Bước 4: Kiểm tra kết quả
            if (rs.next()) {
                isExists = true;
            }

            // Bước 5: Đóng kết nối
            JDBCUtil.closeConnection(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return isExists;
    }

}
