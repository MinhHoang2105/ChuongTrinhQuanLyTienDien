package model;

import java.io.Serializable;
import java.util.Objects;

public class HoaDonModel extends ThongTinKhachHangModel implements Serializable {
    
    private String maHoaDon;
    private int chiSoCu;
    private int chiSoMoi;
    private double soTienPhaiTra;
    private int thang;
    private int nam;

    public HoaDonModel() {
    }

    public HoaDonModel(String maHoaDon, String maSoCongTo, int chiSoCu, int chiSoMoi, double soTienPhaiTra, int thang, int nam) {
        this.maHoaDon = maHoaDon;
        this.setMaSoCongTo(maSoCongTo); // Truyền mã số công tơ vào phương thức setter của lớp cha
        this.chiSoCu = chiSoCu;
        this.chiSoMoi = chiSoMoi;
        this.soTienPhaiTra = this.soTienPhaiTra();
        this.thang = thang;
        this.nam = nam;
    }

    public HoaDonModel(String taiKhoan, String maHoaDon, String maSoCongTo, int chiSoCu, int chiSoMoi, double soTienPhaiTra, int thang, int nam) {
        this.setTaiKhoan(taiKhoan);
        this.setMaSoCongTo(maSoCongTo);
        this.maHoaDon = maHoaDon;
        this.chiSoCu = chiSoCu;
        this.chiSoMoi = chiSoMoi;
        this.soTienPhaiTra = this.soTienPhaiTra();
        this.thang = thang;
        this.nam = nam;
    }

    public HoaDonModel(String taiKhoan) {
        super(taiKhoan);
    }

    public String getMaHoaDon() {
        return maHoaDon;
    }

    public void setMaHoaDon(String maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public int getChiSoCu() {
        return chiSoCu;
    }

    public void setChiSoCu(int chiSoCu) {
        this.chiSoCu = chiSoCu;
    }

    public int getChiSoMoi() {
        return chiSoMoi;
    }

    public void setChiSoMoi(int chiSoMoi) {
        this.chiSoMoi = chiSoMoi;
    }

    public double getSoTienPhaiTra() {
        int tieuThu = this.chiSoMoi - this.chiSoCu;
        if (tieuThu <= 50) {
            return tieuThu * 450;
        } else {
            return (50 * 450) + ((tieuThu - 50) * 800);
        }
    }

    private double soTienPhaiTra() {
        int tieuThu = this.chiSoMoi - this.chiSoCu;
        if (tieuThu <= 50) {
            return tieuThu * 450;
        } else {
            return (50 * 450) + ((tieuThu - 50) * 800);
        }
    }

    public int getThang() {
        return thang;
    }

    public void setThang(int thang) {
        this.thang = thang;
    }

    public int getNam() {
        return nam;
    }

    public void setNam(int nam) {
        this.nam = nam;
    }

    

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + Objects.hashCode(this.maHoaDon);
        hash = 23 * hash + this.chiSoCu;
        hash = 23 * hash + this.chiSoMoi;
        hash = 23 * hash + (int) (Double.doubleToLongBits(this.soTienPhaiTra) ^ (Double.doubleToLongBits(this.soTienPhaiTra) >>> 32));
        hash = 23 * hash + this.thang;
        hash = 23 * hash + this.nam;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final HoaDonModel other = (HoaDonModel) obj;
        if (this.chiSoCu != other.chiSoCu) {
            return false;
        }
        if (this.chiSoMoi != other.chiSoMoi) {
            return false;
        }
        if (Double.doubleToLongBits(this.soTienPhaiTra) != Double.doubleToLongBits(other.soTienPhaiTra)) {
            return false;
        }
        if (this.thang != other.thang) {
            return false;
        }
        if (this.nam != other.nam) {
            return false;
        }
        return Objects.equals(this.maHoaDon, other.maHoaDon);
    }

    @Override
    public String toString() {
        return "HoaDonModel{" + "maHoaDon=" + maHoaDon + ", chiSoCu=" + chiSoCu + ", chiSoMoi=" + chiSoMoi + ", soTienPhaiTra=" + soTienPhaiTra + ", thang=" + thang + ", nam=" + nam + '}';
    }

}
