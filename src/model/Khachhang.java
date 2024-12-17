/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author DELL
 */
public class KhachHang extends Person {

    private int maKH;
    
    public KhachHang() {
    }

    public KhachHang(int maKH, String ten, String diaChi, String email, String soDT, boolean gioiTinh) {
        super(ten, diaChi, email, soDT, gioiTinh);
        this.maKH = maKH;
    }

    public int getMaKH() {
        return maKH;
    }

    public void setMaKH(int maKH) {
        this.maKH = maKH;
    }

}
