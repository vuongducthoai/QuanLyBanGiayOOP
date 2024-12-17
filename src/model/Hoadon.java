/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.List;

/**
 *
 * @author DELL
 */
public class HoaDon {

    private int maHD;
    private KhachHang khachHang;
    private List<SanPham> dsSanPham;
    private String ngayMua;
    private int soLuong;
    private double donGiaBan;
    private String trangThai;
    private String pttt;

    public HoaDon() {
    }
    
    public HoaDon(int maHD, KhachHang khachHang, List<SanPham> dsSanPham, String ngayMua, int soLuong, double donGiaBan, String trangThai, String pttt) {
        this.maHD = maHD;
        this.khachHang = khachHang;
        this.dsSanPham = dsSanPham;
        this.ngayMua = ngayMua;
        this.soLuong = soLuong;
        this.donGiaBan = donGiaBan;
        this.trangThai = trangThai;
        this.pttt = pttt;
    }

    public int getMaHD() {
        return maHD;
    }

    public void setMaHD(int maHD) {
        this.maHD = maHD;
    }

    public KhachHang getKhachHang() {
        return khachHang;
    }

    public void setKhachHang(KhachHang khachHang) {
        this.khachHang = khachHang;
    }

    public List<SanPham> getDsSanPham() {
        return dsSanPham;
    }

    public void setDsSanPham(List<SanPham> dsSanPham) {
        this.dsSanPham = dsSanPham;
    }

    public String getNgayMua() {
        return ngayMua;
    }

    public void setNgayMua(String ngayMua) {
        this.ngayMua = ngayMua;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public double getDonGiaBan() {
        return donGiaBan;
    }

    public void setDonGiaBan(double donGiaBan) {
        this.donGiaBan = donGiaBan;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public String getPttt() {
        return pttt;
    }

    public void setPttt(String pttt) {
        this.pttt = pttt;
    }

    
}
