/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

/**
 *
 * @author idea
 */
public class Yonetmen {
    
    private int idyonetmen;
    private String yonetmen_adi;
    private String yonetmen_soyadi;
    private String yonetmen_cinsiyet;

    public Yonetmen() {
    }

    public Yonetmen(int idyonetmen, String yonetmen_adi, String yonetmen_soyadi, String yonetmen_cinsiyet) {
        this.idyonetmen = idyonetmen;
        this.yonetmen_adi = yonetmen_adi;
        this.yonetmen_soyadi = yonetmen_soyadi;
        this.yonetmen_cinsiyet = yonetmen_cinsiyet;
    }

    public int getYonetmen_id() {
        return idyonetmen;
    }

    public void setYonetmen_id(int idyonetmen) {
        this.idyonetmen = idyonetmen;
    }

    public String getYonetmen_ad() {
        return yonetmen_adi;
    }

    public void setYonetmen_ad(String yonetmen_adi) {
        this.yonetmen_adi = yonetmen_adi;
    }

    public String getYonetmen_soyad() {
        return yonetmen_soyadi;
    }

    public void setYonetmen_soyad(String yonetmen_soyadi) {
        this.yonetmen_soyadi = yonetmen_soyadi;
    }

    public String getYonetmen_cinsiyet() {
        return yonetmen_cinsiyet;
    }

    public void setYonetmen_cinsiyet(String yonetmen_cinsiyet) {
        this.yonetmen_cinsiyet = yonetmen_cinsiyet;
    }
    
    
    
}
