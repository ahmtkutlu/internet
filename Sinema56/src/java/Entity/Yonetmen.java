/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.util.Objects;

/**
 *
 * @author idea
 */
public class Yonetmen {

    private Long idyonetmen;
    private String yonetmen_adi;
    private String yonetmen_soyadi;
    private String yonetmen_cinsiyet;

    public Long getIdyonetmen() {
        return idyonetmen;
    }

    public void setIdyonetmen(Long idyonetmen) {
        this.idyonetmen = idyonetmen;
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

    
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.idyonetmen);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Yonetmen other = (Yonetmen) obj;
        if (!Objects.equals(this.idyonetmen, other.idyonetmen)) {
            return false;
        }
        return true;
    }
    

    @Override
    public String toString() {
        return "Yonetmen{" + "idyonetmen=" + idyonetmen + ", yonetmen_adi=" + yonetmen_adi + '}';
    }

}
