package dao;

import database.JDBCUtil;
import java.sql.*;
import java.util.ArrayList;
import model.HoaDonModel;

public class HoaDonDAO {

    public static HoaDonDAO getInstance() {
        return new HoaDonDAO();
    }

    public int insert(HoaDonModel t) {
        int ketQua = 0;
        try {
            // Bước 1: tạo kết nối đến CSDL
            Connection con = JDBCUtil.getConnection();

            // Bước 2: tạo ra đối tượng PreparedStatement
            String sql = "INSERT INTO hoadon (taiKhoan, maHoaDon, maSoCongTo, chiSoCu, chiSoMoi, soTienPhaiTra, thang, nam) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement st = con.prepareStatement(sql);

            // Bước 3: truyền giá trị cho các tham số
            st.setString(1, t.getTaiKhoan());
            st.setString(2, t.getMaHoaDon());
            st.setString(3, t.getMaSoCongTo());
            st.setInt(4, t.getChiSoCu());
            st.setInt(5, t.getChiSoMoi());
            st.setDouble(6, t.getSoTienPhaiTra());
            st.setInt(7, t.getThang());
            st.setInt(8, t.getNam());

            // Bước 4: thực thi câu lệnh SQL
            ketQua = st.executeUpdate();

            // Bước 5: sử lí kết quả đầu ra
            System.out.println("Bạn đã thực thi: " + sql);
            System.out.println("Có " + ketQua + " dòng bị thay đổi!");

            // Bước 6: ngắt kết nối với CSDL
            JDBCUtil.closeConnection(con);
        } catch (SQLException e) {
            System.out.println("Lỗi trùng dữ liệu!, dữ liệu đã có trong cơ sở dữ liệu");
        }

        return ketQua;
    }

    public int delete(HoaDonModel t) {
        int ketQua = 0;
        try {
            // Bước 1: tạo kết nối đến CSDL
            Connection con = JDBCUtil.getConnection();

            // Bước 2: tạo ra đối tượng PreparedStatement
            String sql = "DELETE FROM hoadon WHERE taiKhoan = ? AND maSoCongTo = ? AND maHoaDon = ?";
            PreparedStatement st = con.prepareStatement(sql);

            // Bước 3: truyền giá trị cho các tham số
            st.setString(1, t.getTaiKhoan());
            st.setString(2, t.getMaSoCongTo());
            st.setString(3, t.getMaHoaDon());

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

    public int update(HoaDonModel t) {
        int ketQua = 0;
        try {
            // Bước 1: tạo kết nối đến CSDL
            Connection con = JDBCUtil.getConnection();

            // Bước 2: tạo ra đối tượng PreparedStatement
            String sql = "UPDATE hoadon "
                    + "SET maHoaDon = ?, maSoCongTo = ?, chiSoCu = ?, chiSoMoi = ?, soTienPhaiTra = ?, thang = ?, nam = ? "
                    + "WHERE taiKhoan = ? AND maHoaDon = ? AND maSoCongTo = ?";
            PreparedStatement st = con.prepareStatement(sql);

            // Bước 3: truyền giá trị cho các tham số
            st.setString(1, t.getMaHoaDon());
            st.setString(2, t.getMaSoCongTo());
            st.setInt(3, t.getChiSoCu());
            st.setInt(4, t.getChiSoMoi());
            st.setDouble(5, t.getSoTienPhaiTra());
            st.setInt(6, t.getThang());
            st.setInt(7, t.getNam());
            st.setString(8, t.getTaiKhoan());
            st.setString(9, t.getMaHoaDon());
            st.setString(10, t.getMaSoCongTo());

            // Bước 4: thực thi câu lệnh SQL
            ketQua = st.executeUpdate();

            // Bước 5:
            System.out.println("Bạn đã thực thi: " + sql);
            System.out.println("Có " + ketQua + " dòng bị thay đổi!");

            // Bước 6:
            JDBCUtil.closeConnection(con);
        } catch (SQLException e) {
            System.out.println("Lỗi trùng dữ liệu!, dữ liệu đã có trong cơ sở dữ liệu");
        }

        return ketQua;
    }

    public ArrayList<HoaDonModel> selectAll(String taiKhoan) {
        ArrayList<HoaDonModel> ketQua = new ArrayList<HoaDonModel>();
        try {
            // Bước 1: tạo kết nối đến CSDL
            Connection con = JDBCUtil.getConnection();

            // Bước 2: tạo ra đối tượng PreparedStatement
            String sql = "SELECT * FROM hoadon WHERE taiKhoan = ?";
            PreparedStatement st = con.prepareStatement(sql);

            // Bước 3: truyền giá trị cho các tham số
            st.setString(1, taiKhoan);

            // Bước 4: thực thi câu lệnh SQL
            ResultSet rs = st.executeQuery();

            // Bước 5:
            while (rs.next()) {
                String maHoaDon = rs.getString("maHoaDon");
                String maSoCongTo = rs.getString("maSoCongTo");
                int chiSoCu = rs.getInt("chiSoCu");
                int chiSoMoi = rs.getInt("chiSoMoi");
                double soTienPhaiTra = rs.getDouble("soTienPhaiTra");
                int thang = rs.getInt("thang");
                int nam = rs.getInt("nam");

                HoaDonModel hoaDonModel = new HoaDonModel(maHoaDon, maSoCongTo, chiSoCu, chiSoMoi, soTienPhaiTra, thang, nam);

                ketQua.add(hoaDonModel);
            }

            // Bước 6:
            JDBCUtil.closeConnection(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ketQua;
    }
}
