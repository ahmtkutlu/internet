/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.util.List;
import java.util.Objects;

/**
 *
 * @author idea
 */
public class Oyuncu {
    
    private Long idoyuncu;
    private String ad;
    private String soyad;
    private int yas;
    private String cinsiyet;

    private List<Film> filmList;

    public Long getIdoyuncu() {
        return idoyuncu;
    }

    public void setIdoyuncu(Long idoyuncu) {
        this.idoyuncu = idoyuncu;
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

    public List<Film> getFilmList() {
        return filmList;
    }

    public void setFilmList(List<Film> filmList) {
        this.filmList = filmList;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.idoyuncu);
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
        final Oyuncu other = (Oyuncu) obj;
        if (!Objects.equals(this.idoyuncu, other.idoyuncu)) {
            return false;
        }
        return true;
    }
    
    
    @Override
    public String toString() {
        return "Oyuncu{" + "ad=" + ad + ", soyad=" + soyad + '}';
    }

}
