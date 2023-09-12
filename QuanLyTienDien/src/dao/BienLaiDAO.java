package dao;

import database.JDBCUtil;
import java.sql.*;
import java.util.ArrayList;
import model.BienLaiModel;

public class BienLaiDAO {

    public static BienLaiDAO getInstance() {
        return new BienLaiDAO();
    }

    public int insert(BienLaiModel t) {
        int ketQua = 0;
        try {
            // Bước 1: tạo kết nối đến CSDL
            Connection con = JDBCUtil.getConnection();

            // Bước 2: tạo ra đối tượng PreparedStatement
            String sql = "INSERT INTO bienlai (taiKhoan, maSoCongTo, maHoaDon, hoTenChuNha, soDienThoai, diaChi, phong, chiSoCu, chiSoMoi, soTienPhaiTra, thang, nam) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement st = con.prepareStatement(sql);

            // Bước 3: truyền giá trị cho các tham số
            st.setString(1, t.getTaiKhoan());
            st.setString(2, t.getMaSoCongTo());
            st.setString(3, t.getMaHoaDon());
            st.setString(4, t.getHoTenChuNha());
            st.setString(5, t.getSoDienThoai());
            st.setString(6, t.getDiaChi());
            st.setString(7, t.getPhong());
            st.setInt(8, t.getChiSoCu());
            st.setInt(9, t.getChiSoMoi());
            st.setDouble(10, t.getSoTienPhaiTra());
            st.setInt(11, t.getThang());
            st.setInt(12, t.getNam());

            // Bước 4: thực thi câu lệnh SQL
            ketQua = st.executeUpdate();

            // Bước 5:  sử lí kết quả đầu ra
            System.out.println("Bạn đã thực thi: " + sql);
            System.out.println("Có " + ketQua + " dòng bị thay đổi!");

            // Bước 6: ngắt kết nối với CSDL
            JDBCUtil.closeConnection(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ketQua;
    }

    public int delete(BienLaiModel t) {
        int ketQua = 0;
        try {
            // Bước 1: tạo kết nối đến CSDL
            Connection con = JDBCUtil.getConnection();

            // Bước 2: tạo ra đối tượng PreparedStatement
            String sql = "DELETE FROM bienlai WHERE taiKhoan = ? AND maSoCongTo = ? AND maHoaDon = ?";
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

    public int update(BienLaiModel t) {
        int ketQua = 0;
        try {
            // Bước 1: tạo kết nối đến CSDL
            Connection con = JDBCUtil.getConnection();

            // Bước 2: tạo ra đối tượng PreparedStatement
            String sql = "UPDATE bienlai "
                    + "SET hoTenChuNha = ?, soDienThoai = ?, diaChi = ?, phong = ?, chiSoCu = ?, chiSoMoi = ?, soTienPhaiTra = ?, thang = ?, nam = ? "
                    + "WHERE taiKhoan = ? AND maHoaDon = ? AND maSoCongTo = ?";
            PreparedStatement st = con.prepareStatement(sql);

            // Bước 3: truyền giá trị cho các tham số
            st.setString(1, t.getHoTenChuNha());
            st.setString(2, t.getSoDienThoai());
            st.setString(3, t.getDiaChi());
            st.setString(4, t.getPhong());
            st.setInt(5, t.getChiSoCu());
            st.setInt(6, t.getChiSoMoi());
            st.setDouble(7, t.getSoTienPhaiTra());
            st.setInt(8, t.getThang());
            st.setInt(9, t.getNam());
            st.setString(10, t.getTaiKhoan());
            st.setString(11, t.getMaHoaDon());
            st.setString(12, t.getMaSoCongTo());

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

    public ArrayList<BienLaiModel> selectAll(String taiKhoan) {
        ArrayList<BienLaiModel> ketQua = new ArrayList<BienLaiModel>();
        try {
            // Bước 1: tạo kết nối đến CSDL
            Connection con = JDBCUtil.getConnection();

            // Bước 2: tạo ra đối tượng PreparedStatement
            String sql = "SELECT * FROM bienlai WHERE taiKhoan = ?";
            PreparedStatement st = con.prepareStatement(sql);

            // Bước 3: truyền giá trị cho tham số
            st.setString(1, taiKhoan);

            // Bước 4: thực thi câu lệnh SQL
            ResultSet rs = st.executeQuery();

            // Bước 5:
            while (rs.next()) {
                String maSoCongTo = rs.getString("maSoCongTo");
                String maHoaDon = rs.getString("maHoaDon");
                String hoTenChuNha = rs.getString("hotenChuNha");
                String soDienThoai = rs.getString("soDienThoai");
                String diaChi = rs.getString("diaChi");
                String phong = rs.getString("phong");
                int chiSoCu = rs.getInt("chiSoCu");
                int chiSoMoi = rs.getInt("chiSoMoi");
                double soTienPhaiTra = rs.getDouble("soTienPhaiTra");
                int thang = rs.getInt("thang");
                int nam = rs.getInt("nam");

                BienLaiModel bienLaiModel = new BienLaiModel(maSoCongTo, maHoaDon, hoTenChuNha, soDienThoai, diaChi, phong, chiSoCu, chiSoMoi, soTienPhaiTra, thang, nam);
                ketQua.add(bienLaiModel);
            }

            // Bước 6:
            JDBCUtil.closeConnection(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ketQua;
    }

    public double tongTienThang(String taiKhoan, int thang, int nam) {
        double totalPrice = 0;
        try {
            // Kết nối tới cơ sở dữ liệu
            Connection conn = JDBCUtil.getConnection();

            // Tạo đối tượng PreparedStatement và thực thi câu lệnh SQL
            String sql = "SELECT SUM(soTienPhaiTra) AS total_price " +
                    "FROM bienlai " +
                    "WHERE thang = ? AND nam = ? AND taiKhoan = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            
            // Bước 3: truyền giá trị cho các tham số
            stmt.setInt(1, thang);
            stmt.setInt(2, nam);
            stmt.setString(3, taiKhoan);

            ResultSet rs = stmt.executeQuery();

            // Truy xuất kết quả từ ResultSet
            if (rs.next()) {
                totalPrice = rs.getDouble("total_price");
                // System.out.println("Tong tien thang " + thang + " la: " + totalPrice);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return totalPrice;
    }
}
