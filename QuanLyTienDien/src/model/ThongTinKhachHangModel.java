package model;

import java.io.Serializable;
import java.util.Objects;

public class ThongTinKhachHangModel extends NguoiDungModel implements Serializable {

    private String maSoCongTo;
    private String hoTenChuNha;
    private String soDienThoai;
    private String diaChi;
    private String phong;

    public ThongTinKhachHangModel() {
        super();
    }

    public ThongTinKhachHangModel(String maSoCongTo, String hoTenChuNha, String soDienThoai, String diaChi, String phong) {
        this.maSoCongTo = maSoCongTo;
        this.hoTenChuNha = hoTenChuNha;
        this.soDienThoai = soDienThoai;
        this.diaChi = diaChi;
        this.phong = phong;
    }

    public ThongTinKhachHangModel(String taiKhoan, String maSoCongTo, String hoTenChuNha, String soDienThoai, String diaChi, String phong) {
        super(taiKhoan);
        this.maSoCongTo = maSoCongTo;
        this.hoTenChuNha = hoTenChuNha;
        this.soDienThoai = soDienThoai;
        this.diaChi = diaChi;
        this.phong = phong;
    }

    public ThongTinKhachHangModel(String taiKhoan, String maSoCongTo) {
        super(taiKhoan);
        this.maSoCongTo = maSoCongTo;
    }

    public ThongTinKhachHangModel(String taiKhoan) {
        super(taiKhoan);
    }

    public String getMaSoCongTo() {
        return maSoCongTo;
    }

    public void setMaSoCongTo(String maSoCongTo) {
        this.maSoCongTo = maSoCongTo;
    }

    public String getHoTenChuNha() {
        return hoTenChuNha;
    }

    public void setHoTenChuNha(String hoTenChuNha) {
        this.hoTenChuNha = hoTenChuNha;
    }

    @Override
    public String getSoDienThoai() {
        return soDienThoai;
    }

    @Override
    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getPhong() {
        return phong;
    }

    public void setPhong(String phong) {
        this.phong = phong;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + Objects.hash(diaChi, hoTenChuNha, maSoCongTo, soDienThoai);
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!super.equals(obj)) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        ThongTinKhachHangModel other = (ThongTinKhachHangModel) obj;
        return Objects.equals(diaChi, other.diaChi) && Objects.equals(hoTenChuNha, other.hoTenChuNha)
                && Objects.equals(maSoCongTo, other.maSoCongTo) && Objects.equals(soDienThoai, other.soDienThoai);
    }

    @Override
    public String toString() {
        return "ThongTinKhachHangModel [maSoCongTo=" + maSoCongTo + ", hoTenChuNha=" + hoTenChuNha + ", soDienThoai="
                + soDienThoai + ", diaChi=" + diaChi + "]";
    }

}
