/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.util.Calendar;
import java.sql.Date;

/**
 *
 * @author idea
 */
public class Duyuru {
    
    private int idduyuru;
    private String baslik;
    private String icerik; 
    private Date baslangicTarihi;   
    private Date bitisTarihi;

    public Duyuru() {
    }

    public Duyuru(int idduyuru, String baslik, String icerik, Date baslangicTarihi, Date bitisTarihi) {
        this.idduyuru = idduyuru;
        this.baslik = baslik;
        this.icerik = icerik;
        this.baslangicTarihi = baslangicTarihi;
        this.bitisTarihi = bitisTarihi;
    }

    public int getDuyuru_id() {
        return idduyuru;
    }

    public void setDuyuru_id(int idduyuru) {
        this.idduyuru = idduyuru;
    }

    public String getTitle() {
        return baslik;
    }

    public void setTitle(String baslik) {
        this.baslik = baslik;
    }

    public String getIcerik() {
        return icerik;
    }

    public void setIcerik(String icerik) {
        this.icerik = icerik;
    }

    public Date getBaslangicTarihi() {
        return baslangicTarihi;
    }

    public void setBaslangicTarihi(Date baslangicTarihi) {
        this.baslangicTarihi = baslangicTarihi;
    }

    public Date getBitisTarihi() {
        return bitisTarihi;
    }

    public void setBitisTarihi(Date bitisTarihi) {
        this.bitisTarihi = bitisTarihi;
    }
    
}
