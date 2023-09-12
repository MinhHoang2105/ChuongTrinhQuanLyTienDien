package model;

import java.io.Serializable;
import java.util.Objects;

public class NguoiDungModel  implements Serializable {

    private String taiKhoan;
    private String matKhau;
    private String email;
    private String soDienThoai;

    public NguoiDungModel() {
    }

    public NguoiDungModel(String taiKhoan, String matKhau, String email, String soDienThoai) {
        this.taiKhoan = taiKhoan;
        this.matKhau = matKhau;
        this.email = email;
        this.soDienThoai = soDienThoai;
    }

    public NguoiDungModel(String taiKhoan) {
        this.taiKhoan = taiKhoan;
    }
    
    public NguoiDungModel(String taiKhoan, String email) {
        this.taiKhoan = taiKhoan;
        this.email = email;
    }

    public String getTaiKhoan() {
        return taiKhoan;
    }

    public void setTaiKhoan(String taiKhoan) {
        this.taiKhoan = taiKhoan;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, matKhau, soDienThoai, taiKhoan);
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
        NguoiDungModel other = (NguoiDungModel) obj;
        return Objects.equals(email, other.email) && Objects.equals(matKhau, other.matKhau)
                && Objects.equals(soDienThoai, other.soDienThoai) && Objects.equals(taiKhoan, other.taiKhoan);
    }

    @Override
    public String toString() {
        return "NguoiDungModel [taiKhoan=" + taiKhoan + ", matKhau=" + matKhau + ", email=" + email + ", soDienThoai="
                + soDienThoai + "]";
    }

}
