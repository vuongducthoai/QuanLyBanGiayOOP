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
public class HoaDon {

    private int maHD;
    private int maKH;
    private int maNV;
    private Date ngayMua;
    private String trangThai;
    private String pTTT;
    private double tongTien;

    public HoaDon(){
    }
    
    public HoaDon(int maHD, int maKH, int maNV, Date ngayMua, String trangThai, String pTTT, double tongTien) {
        this.maHD = maHD;
        this.maKH = maKH;
        this.maNV = maNV;
        this.ngayMua = ngayMua;
        this.trangThai = trangThai; 
        this.pTTT = pTTT;
        this.tongTien = tongTien;
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
     * @return the ngayMua
     */
    public Date getNgayMua() {
        return ngayMua;
    }

    /**
     * @param ngayMua the ngayMua to set
     */
    public void setNgayMua(Date ngayMua) {
        this.ngayMua = ngayMua;
    }

    /**
     * @return the trangThai
     */
    public String getTrangThai() {
        return trangThai;
    }

    /**
     * @param trangThai the trangThai to set
     */
    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    /**
     * @return the pTTT
     */
    public String getpTTT() {
        return pTTT;
    }

    /**
     * @param pTTT the pTTT to set
     */
    public void setpTTT(String pTTT) {
        this.pTTT = pTTT;
    }

    /**
     * @return the tongTien
     */
    public double getTongTien() {
        return tongTien;
    }

    /**
     * @param tongTien the tongTien to set
     */
    public void setTongTien(double tongTien) {
        this.tongTien = tongTien;
    }

    /**
     * @return the maKH
     */
    public int getMaKH() {
        return maKH;
    }

    /**
     * @param maKH the maKH to set
     */
    public void setMaKH(int maKH) {
        this.maKH = maKH;
    }

    /**
     * @return the maNV
     */
    public int getMaNV() {
        return maNV;
    }

    /**
     * @param maNV the maNV to set
     */
    public void setMaNV(int maNV) {
        this.maNV = maNV;
    }
}
