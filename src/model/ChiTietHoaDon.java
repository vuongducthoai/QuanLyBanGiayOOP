/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author DELL
 */
public class ChiTietHoaDon {
    private int maCTHD;
    private int maHD;
    private int maSP;
    private int soLuong;
    private double donGiaBan;

    public ChiTietHoaDon(){
    }
    
    public ChiTietHoaDon(int maCTHD, int maHD, int maSP, int soLuong, double donGiaBan) {
        this.maCTHD = maCTHD;
        this.maHD = maHD;
        this.maSP = maSP;
        this.soLuong = soLuong;
        this.donGiaBan = donGiaBan;
    }

    /**
     * @return the maCTHD
     */
    public int getMaCTHD() {
        return maCTHD;
    }

    /**
     * @param maCTHD the maCTHD to set
     */
    public void setMaCTHD(int maCTHD) {
        this.maCTHD = maCTHD;
    }

    /**
     * @return the maHD
     */
    public int getMaHD() {
        return maHD;
    }

    /**
     * @param maHD the maHD to set
     */
    public void setMaHD(int maHD) {
        this.maHD = maHD;
    }

    /**
     * @return the maSP
     */
    public int getMaSP() {
        return maSP;
    }

    /**
     * @param maSP the maSP to set
     */
    public void setMaSP(int maSP) {
        this.maSP = maSP;
    }

    /**
     * @return the soLuong
     */
    public int getSoLuong() {
        return soLuong;
    }

    /**
     * @param soLuong the soLuong to set
     */
    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    /**
     * @return the donGiaBan
     */
    public double getDonGiaBan() {
        return donGiaBan;
    }

    /**
     * @param donGiaBan the donGiaBan to set
     */
    public void setDonGiaBan(double donGiaBan) {
        this.donGiaBan = donGiaBan;
    }
    
}
