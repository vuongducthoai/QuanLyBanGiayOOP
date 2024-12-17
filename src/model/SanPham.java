/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author DELL
 */
public class SanPham {

    private int maSP;
    private String tenSP;
    private double donGiaNhap;
    private double donGiaBan;
    private DanhMuc danhMuc;

    public SanPham() {
    }
    
    public SanPham(int maSP, String tenSP, double donGiaNhap, double donGiaBan, DanhMuc danhMuc) {
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.donGiaNhap = donGiaNhap;
        this.donGiaBan = donGiaBan;
        this.danhMuc = danhMuc;
    }

    public int getMaSP() {
        return maSP;
    }

    public void setMaSP(int maSP) {
        this.maSP = maSP;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public double getDonGiaNhap() {
        return donGiaNhap;
    }

    public void setDonGiaNhap(double donGiaNhap) {
        this.donGiaNhap = donGiaNhap;
    }

    public double getDonGiaBan() {
        return donGiaBan;
    }

    public void setDonGiaBan(double donGiaBan) {
        this.donGiaBan = donGiaBan;
    }

    public DanhMuc getDanhMuc() {
        return danhMuc;
    }

    public void setDanhMuc(DanhMuc danhMuc) {
        this.danhMuc = danhMuc;
    }
}
