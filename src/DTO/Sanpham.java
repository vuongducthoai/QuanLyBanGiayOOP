/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author DELL
 */
public class Sanpham {
    private int masp;
    private String tensp;
    private double gianhap;
    private double giaban;
    private int madanhmuc;

    public Sanpham(int masp, String tensp, double gianhap, double giaban, int madanhmuc) {
        this.masp = masp;
        this.tensp = tensp;
        this.gianhap = gianhap;
        this.giaban = giaban;
        this.madanhmuc = madanhmuc;
    }

    /**
     * @return the masp
     */
    public int getMasp() {
        return masp;
    }

    /**
     * @param masp the masp to set
     */
    public void setMasp(int masp) {
        this.masp = masp;
    }

    /**
     * @return the tensp
     */
    public String getTensp() {
        return tensp;
    }

    /**
     * @param tensp the tensp to set
     */
    public void setTensp(String tensp) {
        this.tensp = tensp;
    }

    /**
     * @return the gianhap
     */
    public double getGianhap() {
        return gianhap;
    }

    /**
     * @param gianhap the gianhap to set
     */
    public void setGianhap(double gianhap) {
        this.gianhap = gianhap;
    }

    /**
     * @return the giaban
     */
    public double getGiaban() {
        return giaban;
    }

    /**
     * @param giaban the giaban to set
     */
    public void setGiaban(double giaban) {
        this.giaban = giaban;
    }

    /**
     * @return the madanhmuc
     */
    public int getMadanhmuc() {
        return madanhmuc;
    }

    /**
     * @param madanhmuc the madanhmuc to set
     */
    public void setMadanhmuc(int madanhmuc) {
        this.madanhmuc = madanhmuc;
    }
}
