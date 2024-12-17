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
public class HoaDonNhap {

    private int maHDN;
    private NhaCungCap nhaCungCap;
    private NhanVien nhanVien;
    private List<SanPham> dsSanPham;
    private String ngayNhap;
    private int soLuong;
    private double donGiaNhap;
    private String trangThai;

    public HoaDonNhap(int maHDN, NhaCungCap nhaCungCap, NhanVien nhanVien, List<SanPham> dsSanPham, String ngayNhap, int soLuong, double donGiaNhap, String trangThai) {
        this.maHDN = maHDN;
        this.nhaCungCap = nhaCungCap;
        this.nhanVien = nhanVien;
        this.dsSanPham = dsSanPham;
        this.ngayNhap = ngayNhap;
        this.soLuong = soLuong;
        this.donGiaNhap = donGiaNhap;
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
        return nhanVien;
    }

    public void setNhanVien(NhanVien nhanVien) {
        this.nhanVien = nhanVien;
    }

    public List<SanPham> getDsSanPham() {
        return dsSanPham;
    }

    public void setDsSanPham(List<SanPham> dsSanPham) {
        this.dsSanPham = dsSanPham;
    }

    public String getNgayNhap() {
        return ngayNhap;
    }

    public void setNgayNhap(String ngayNhap) {
        this.ngayNhap = ngayNhap;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public double getDonGiaNhap() {
        return donGiaNhap;
    }

    public void setDonGiaNhap(double donGiaNhap) {
        this.donGiaNhap = donGiaNhap;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

}
