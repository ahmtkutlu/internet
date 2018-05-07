/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.util.ArrayList;

/**
 *
 * @author idea
 */
public class yonetmen {

    private Long yonetmen_id;
    private String yonetmen_adi;
    private String yonetmen_soyadi;
    private String yonetmen_cinsiyet;
    
    private ArrayList<film> filmi;

    public Long getYonetmen_id() {
        return yonetmen_id;
    }

    public void setYonetmen_id(Long yonetmen_id) {
        this.yonetmen_id = yonetmen_id;
    }

    

    public String getYonetmen_adi() {
        return yonetmen_adi;
    }

    public void setYonetmen_adi(String yonetmen_adi) {
        this.yonetmen_adi = yonetmen_adi;
    }

    public String getYonetmen_soyadi() {
        return yonetmen_soyadi;
    }

    public void setYonetmen_soyadi(String yonetmen_soyadi) {
        this.yonetmen_soyadi = yonetmen_soyadi;
    }

    public String getYonetmen_cinsiyet() {
        return yonetmen_cinsiyet;
    }

    public void setYonetmen_cinsiyet(String yonetmen_cinsiyet) {
        this.yonetmen_cinsiyet = yonetmen_cinsiyet;
    }

    public ArrayList<film> getFilmi() {
        return filmi;
    }

    public void setFilmi(ArrayList<film> filmi) {
        this.filmi = filmi;
    }
    
    
    @Override
    public String toString() {
        return "yonetmen{" + "yonetmen_id=" + yonetmen_id + ", yonetmen_adi=" + yonetmen_adi + ", yonetmen_soyadi=" + yonetmen_soyadi + ", yonetmen_cinsiyet=" + yonetmen_cinsiyet + '}';
    }

    

    

}
