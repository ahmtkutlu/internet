/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.util.Calendar;

/**
 *
 * @author idea
 */
public class Duyuru {
    
    private int idduyuru;
    private String baslik;
    private String icerik; 
    private Calendar baslangicTarihi;   
    private Calendar bitisTarihi;

    public Duyuru() {
    }

    public Duyuru(int idduyuru, String baslik, String icerik, Calendar baslangicTarihi, Calendar bitisTarihi) {
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

    public Calendar getBaslangicTarihi() {
        return baslangicTarihi;
    }

    public void setBaslangicTarihi(Calendar baslangicTarihi) {
        this.baslangicTarihi = baslangicTarihi;
    }

    public Calendar getBitisTarihi() {
        return bitisTarihi;
    }

    public void setBitisTarihi(String Calendar) {
        this.bitisTarihi = bitisTarihi;
    }
    
}
