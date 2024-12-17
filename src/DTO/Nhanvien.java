/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author DELL
 */
public class Nhanvien extends Person{
    private String gioitinh;

    public Nhanvien(String gioitinh) {
        this.gioitinh = gioitinh;
    }

    public Nhanvien(String gioitinh, int code, String ten, String diachi, String email, String sdt) {
        super(code, ten, diachi, email, sdt);
        this.gioitinh = gioitinh;
    }

    /**
     * @return the gioitinh
     */
    public String getGioitinh() {
        return gioitinh;
    }

    /**
     * @param gioitinh the gioitinh to set
     */
    public void setGioitinh(String gioitinh) {
        this.gioitinh = gioitinh;
    }
}
