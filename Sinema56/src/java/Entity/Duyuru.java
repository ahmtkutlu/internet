/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.util.Calendar;
import java.sql.Date;
import java.util.Objects;

/**
 *
 * @author idea
 */
public class Duyuru {
    
    private Long idduyuru;
    private String baslik;
    private String icerik; 
    private Date baslangicTarihi;   
    private Date bitisTarihi;

    public Duyuru() {
    }

    public Duyuru(Long idduyuru, String baslik, String icerik, Date baslangicTarihi, Date bitisTarihi) {
        this.idduyuru = idduyuru;
        this.baslik = baslik;
        this.icerik = icerik;
        this.baslangicTarihi = baslangicTarihi;
        this.bitisTarihi = bitisTarihi;
    }

    public Long getDuyuru_id() {
        return idduyuru;
    }

    public void setDuyuru_id(Long idduyuru) {
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
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.idduyuru);
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
        final Duyuru other = (Duyuru) obj;
        if (!Objects.equals(this.idduyuru, other.idduyuru)) {
            return false;
        }
        return true;
    }
    
    
    
    
}
