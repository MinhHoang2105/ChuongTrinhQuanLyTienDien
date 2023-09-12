/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author minh
 */
import java.io.Serializable;
import java.util.ArrayList;

public class DataObject implements Serializable {
    
    private ThongTinKhachHangModel thongTinKhachHangModel;
    private HoaDonModel hoaDonModel;
    private BienLaiModel bienLaiModel;
    
    private ArrayList<ThongTinKhachHangModel> listThongTinKhachHang;
    private ArrayList<HoaDonModel> listHoaDon;
    private ArrayList<BienLaiModel> listBienLai;

    public DataObject() {
    }
    

    public DataObject(ArrayList<ThongTinKhachHangModel> listThongTinKhachHang, ArrayList<HoaDonModel> listHoaDon, ArrayList<BienLaiModel> listBienLai) {
        this.listThongTinKhachHang = listThongTinKhachHang;
        this.listHoaDon = listHoaDon;
        this.listBienLai = listBienLai;
    }

    public ArrayList<ThongTinKhachHangModel> getListThongTinKhachHang() {
        return listThongTinKhachHang;
    }

    public ArrayList<HoaDonModel> getListHoaDon() {
        return listHoaDon;
    }

    public ArrayList<BienLaiModel> getListBienLai() {
        return listBienLai;
    }

    public void setListThongTinKhachHang(ArrayList<ThongTinKhachHangModel> listThongTinKhachHang) {
        this.listThongTinKhachHang = listThongTinKhachHang;
    }

    public void setListHoaDon(ArrayList<HoaDonModel> listHoaDon) {
        this.listHoaDon = listHoaDon;
    }

    public void setListBienLai(ArrayList<BienLaiModel> listBienLai) {
        this.listBienLai = listBienLai;
    }

    public void add(ArrayList<Object> arrayList) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public ThongTinKhachHangModel getThongTinKhachHangModel() {
        return thongTinKhachHangModel;
    }

    public void setThongTinKhachHangModel(ThongTinKhachHangModel thongTinKhachHangModel) {
        this.thongTinKhachHangModel = thongTinKhachHangModel;
    }

    public HoaDonModel getHoaDonModel() {
        return hoaDonModel;
    }

    public void setHoaDonModel(HoaDonModel hoaDonModel) {
        this.hoaDonModel = hoaDonModel;
    }

    public BienLaiModel getBienLaiModel() {
        return bienLaiModel;
    }

    public void setBienLaiModel(BienLaiModel bienLaiModel) {
        this.bienLaiModel = bienLaiModel;
    }
    
    
}
