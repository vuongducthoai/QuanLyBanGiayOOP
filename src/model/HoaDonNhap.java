/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;

/**
 *
 * @author DELL
 */
public class HoaDonNhap {
    private int maHDN;
    private NhaCungCap nhaCungCap;
    private NhanVien nhanVien;
    private Date ngayNhap;
    private double tongTien;
    private String formatTongTien;
    private String trangThai;

    public HoaDonNhap() {
    }

    public HoaDonNhap(int maHDN, NhaCungCap nhaCungCap, NhanVien nhanVien, Date ngayNhap, double tongTien, String trangThai) {
        this.maHDN = maHDN;
        this.nhaCungCap = nhaCungCap;
        this.nhanVien = nhanVien;
        this.ngayNhap = ngayNhap;
        this.tongTien = tongTien;
        this.trangThai = trangThai;
    }

    public HoaDonNhap(int maHDN, NhaCungCap nhaCungCap, NhanVien nhanVien, Date ngayNhap, String formatTongTien, String trangThai) {
        this.maHDN = maHDN;
        this.nhaCungCap = nhaCungCap;
        this.nhanVien = nhanVien;
        this.ngayNhap = ngayNhap;
        this.formatTongTien = formatTongTien;
        this.trangThai = trangThai;
    }
    

    public int getMaHDN() {
        return maHDN;
    }

    public void setMaHDN(int maHDN) {
        this.maHDN = maHDN;
    }

    public NhaCungCap getNhaCungCap() {
        return nhaCungCap;
    }

    public void setNhaCungCap(NhaCungCap nhaCungCap) {
        this.nhaCungCap = nhaCungCap;
    }

    public NhanVien getNhanVien() {
        if (this.nhanVien == null)
            return new NhanVien();
        return nhanVien;
    }

    public void setNhanVien(NhanVien nhanVien) {
        this.nhanVien = nhanVien;
    }

    public Date getNgayNhap() {
        return ngayNhap;
    }

    public void setNgayNhap(Date ngayNhap) {
        this.ngayNhap = ngayNhap;
    }

    public double getTongTien() {
        return tongTien;
    }

    public void setTongTien(double tongTien) {
        this.tongTien = tongTien;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public String getFormatTongTien() {
        return formatTongTien;
    }

    public void setFormatTongTien(String formatTongTien) {
        this.formatTongTien = formatTongTien;
    }
    
    

}
