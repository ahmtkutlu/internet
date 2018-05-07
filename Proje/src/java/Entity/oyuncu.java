/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author idea
 */
public class oyuncu {

    private Long oyuncu_id;
    private String ad;
    private String soyad;
    private int yas;
    private String cinsiyet;

    private ArrayList<film> filmi;

    public oyuncu() {
    }
    
    

    public oyuncu(Long oyuncu_id, String ad, String soyad) {
        this.oyuncu_id = oyuncu_id;
        this.ad = ad;
        this.soyad = soyad;
    }
    
    

    public ArrayList<film> getFilmi() {
        return filmi;
    }

    public void setFilmi(ArrayList<film> filmi) {
        this.filmi = filmi;
    }
    
    

    public Long getOyuncu_id() {
        return oyuncu_id;
    }

    public void setOyuncu_id(Long oyuncu_id) {
        this.oyuncu_id = oyuncu_id;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getSoyad() {
        return soyad;
    }

    public void setSoyad(String soyad) {
        this.soyad = soyad;
    }

    public int getYas() {
        return yas;
    }

    public void setYas(int yas) {
        this.yas = yas;
    }

    public String getCinsiyet() {
        return cinsiyet;
    }

    public void setCinsiyet(String cinsiyet) {
        this.cinsiyet = cinsiyet;
    }

    @Override
    public String toString() {
        return "Oyuncu{" + "ad=" + ad + ", soyad=" + soyad + '}';
    }

}
