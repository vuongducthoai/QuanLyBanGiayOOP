/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Asus
 */
public class ChiTietHoaDonNhap {
    private int maCTHDN;
    private HoaDonNhap hoaDonNhap;
    private SanPham sanPham;
    private int soLuong;
    private double donGiaNhap;

    public ChiTietHoaDonNhap() {
    }

    public ChiTietHoaDonNhap(int maCTHDN, HoaDonNhap hoaDonNhap, SanPham sanPham, int soLuong, double donGiaNhap) {
        this.maCTHDN = maCTHDN;
        this.hoaDonNhap = hoaDonNhap;
        this.sanPham = sanPham;
        this.soLuong = soLuong;
        this.donGiaNhap = donGiaNhap;
    }

    public int getMaCTHDN() {
        return maCTHDN;
    }

    public void setMaCTHDN(int maCTHDN) {
        this.maCTHDN = maCTHDN;
    }

    public HoaDonNhap getHoaDonNhap() {
        return hoaDonNhap;
    }

    public void setHoaDonNhap(HoaDonNhap hoaDonNhap) {
        this.hoaDonNhap = hoaDonNhap;
    }

    public SanPham getSanPham() {
        return sanPham;
    }

    public void setSanPham(SanPham sanPham) {
        this.sanPham = sanPham;
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
    
    
}
