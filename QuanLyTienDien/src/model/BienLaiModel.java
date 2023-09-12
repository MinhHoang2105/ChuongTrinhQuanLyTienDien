package model;

import java.io.Serializable;

public class BienLaiModel extends HoaDonModel implements Serializable {
    private String taiKhoan;
    private String maSoCongTo;
    private String maHoaDon;
    private String hoTenChuNha;
    private String soDienThoai;
    private String diaChi;
    private String phong;
    private int chiSoCu;
    private int chiSoMoi;
    private double soTienPhaiTra;
    private int thang;
    private int nam;

    public BienLaiModel() {
    }

    public BienLaiModel(String maSoCongTo, String maHoaDon, String hoTenChuNha, String soDienThoai, String diaChi, String phong, int chiSoCu, int chiSoMoi, double soTienPhaiTra, int thang, int nam) {
        this.maSoCongTo = maSoCongTo;
        this.maHoaDon = maHoaDon;
        this.hoTenChuNha = hoTenChuNha;
        this.soDienThoai = soDienThoai;
        this.diaChi = diaChi;
        this.phong = phong;
        this.chiSoCu = chiSoCu;
        this.chiSoMoi = chiSoMoi;
        this.soTienPhaiTra = soTienPhaiTra;
        this.thang = thang;
        this.nam = nam;
    }

    public BienLaiModel(String taiKhoan, String maSoCongTo, String maHoaDon, String hoTenChuNha, String soDienThoai, String diaChi, String phong, int chiSoCu, int chiSoMoi, double soTienPhaiTra, int thang, int nam) {
        this.taiKhoan = taiKhoan;
        this.maSoCongTo = maSoCongTo;
        this.maHoaDon = maHoaDon;
        this.hoTenChuNha = hoTenChuNha;
        this.soDienThoai = soDienThoai;
        this.diaChi = diaChi;
        this.phong = phong;
        this.chiSoCu = chiSoCu;
        this.chiSoMoi = chiSoMoi;
        this.soTienPhaiTra = soTienPhaiTra;
        this.thang = thang;
        this.nam = nam;
    }

    public String getTaiKhoan() {
        return taiKhoan;
    }

    public void setTaiKhoan(String taiKhoan) {
        this.taiKhoan = taiKhoan;
    }

    public String getMaSoCongTo() {
        return maSoCongTo;
    }

    public void setMaSoCongTo(String maSoCongTo) {
        this.maSoCongTo = maSoCongTo;
    }

    public String getMaHoaDon() {
        return maHoaDon;
    }

    public void setMaHoaDon(String maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public String getHoTenChuNha() {
        return hoTenChuNha;
    }

    public void setHoTenChuNha(String hoTenChuNha) {
        this.hoTenChuNha = hoTenChuNha;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

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
        return soTienPhaiTra;
    }

    public void setSoTienPhaiTra(double soTienPhaiTra) {
        this.soTienPhaiTra = soTienPhaiTra;
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
    
    
    
}
