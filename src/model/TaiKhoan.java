/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ADMIN
 */
public class TaiKhoan {

    private String tenTK;
    private String matKhau;
    private String chucVu;
    private int maNV;

    public TaiKhoan() {
    }

    public TaiKhoan(String tenTK, String chucVu) {
        this.tenTK = tenTK;
        this.chucVu = chucVu;
    }

    public TaiKhoan(String tenTK, String chucVu, int maNV) {
        this.tenTK = tenTK;
        this.chucVu = chucVu;
        this.maNV = maNV;
    }

    public TaiKhoan(String tenTK, String matKhau, String chucVu, int maNV) {
        this.tenTK = tenTK;
        this.matKhau = matKhau;
        this.chucVu = chucVu;
        this.maNV = maNV;
    }

    public String getTenTK() {
        return tenTK;
    }

    public void setTenTK(String tenTK) {
        this.tenTK = tenTK;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public String getChucVu() {
        return chucVu;
    }

    public void setChucVu(String chucVu) {
        this.chucVu = chucVu;
    }

    public int getMaNV() {
        return maNV;
    }

    public void setMaNV(int maNV) {
        this.maNV = maNV;
    }

}
