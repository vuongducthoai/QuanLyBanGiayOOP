/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author DELL
 */
import java.util.Date;

public class Hoadonnhap {
    private int mahdnhap;
    private int mancc;
    private int manv;
    private Date ngaynhap;
    private String trangthai;

    public Hoadonnhap(int mahdnhap, int mancc, int manv, Date ngaynhap, String trangthai) {
        this.mahdnhap = mahdnhap;
        this.mancc = mancc;
        this.manv = manv;
        this.ngaynhap = ngaynhap;
        this.trangthai = trangthai;
    }

    /**
     * @return the mahdnhap
     */
    public int getMahdnhap() {
        return mahdnhap;
    }

    /**
     * @param mahdnhap the mahdnhap to set
     */
    public void setMahdnhap(int mahdnhap) {
        this.mahdnhap = mahdnhap;
    }

    /**
     * @return the mancc
     */
    public int getMancc() {
        return mancc;
    }

    /**
     * @param mancc the mancc to set
     */
    public void setMancc(int mancc) {
        this.mancc = mancc;
    }

    /**
     * @return the manv
     */
    public int getManv() {
        return manv;
    }

    /**
     * @param manv the manv to set
     */
    public void setManv(int manv) {
        this.manv = manv;
    }

    /**
     * @return the ngaynhap
     */
    public Date getNgaynhap() {
        return ngaynhap;
    }

    /**
     * @param ngaynhap the ngaynhap to set
     */
    public void setNgaynhap(Date ngaynhap) {
        this.ngaynhap = ngaynhap;
    }

    /**
     * @return the trangthai
     */
    public String getTrangthai() {
        return trangthai;
    }

    /**
     * @param trangthai the trangthai to set
     */
    public void setTrangthai(String trangthai) {
        this.trangthai = trangthai;
    }
}
