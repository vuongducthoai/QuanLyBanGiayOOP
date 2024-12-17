/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ADMIN
 */
public class NhanVien extends Person {

    private int maNV;
    
    public NhanVien() {
        super();
    }

    public NhanVien(int maNV, TaiKhoan taiKhoan, String ten, String diaChi, String email, String soDT, String gioiTinh) {
        super(ten, diaChi, email, soDT, gioiTinh);
        this.maNV = maNV;
    }

    public int getMaNV() {
        return maNV;
    }

    public void setMaNV(int maNV) {
        this.maNV = maNV;
    }

}
