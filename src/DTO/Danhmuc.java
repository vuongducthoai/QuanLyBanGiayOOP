/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author DELL
 */
public class Danhmuc {
    private int madanhmuc;
    private String tendanhmuc;

    public Danhmuc(int madanhmuc, String tendanhmuc) {
        this.madanhmuc = madanhmuc;
        this.tendanhmuc = tendanhmuc;
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

    /**
     * @return the tendanhmuc
     */
    public String getTendanhmuc() {
        return tendanhmuc;
    }

    /**
     * @param tendanhmuc the tendanhmuc to set
     */
    public void setTendanhmuc(String tendanhmuc) {
        this.tendanhmuc = tendanhmuc;
    }
}
