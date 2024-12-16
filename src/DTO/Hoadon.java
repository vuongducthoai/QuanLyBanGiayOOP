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

public class Hoadon {
    private int mahd;
    private int makh;
    private Date ngaymua;
    private String trangthai;
    private String pttt;

    public Hoadon(int mahd, int makh, Date ngaymua, String trangthai, String pttt) {
        this.mahd = mahd;
        this.makh = makh;
        this.ngaymua = ngaymua;
        this.trangthai = trangthai;
        this.pttt = pttt;
    }

    /**
     * @return the mahd
     */
    public int getMahd() {
        return mahd;
    }

    /**
     * @param mahd the mahd to set
     */
    public void setMahd(int mahd) {
        this.mahd = mahd;
    }

    /**
     * @return the makh
     */
    public int getMakh() {
        return makh;
    }

    /**
     * @param makh the makh to set
     */
    public void setMakh(int makh) {
        this.makh = makh;
    }

    /**
     * @return the ngaymua
     */
    public Date getNgaymua() {
        return ngaymua;
    }

    /**
     * @param ngaymua the ngaymua to set
     */
    public void setNgaymua(Date ngaymua) {
        this.ngaymua = ngaymua;
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

    /**
     * @return the pttt
     */
    public String getPttt() {
        return pttt;
    }

    /**
     * @param pttt the pttt to set
     */
    public void setPttt(String pttt) {
        this.pttt = pttt;
    }
}
