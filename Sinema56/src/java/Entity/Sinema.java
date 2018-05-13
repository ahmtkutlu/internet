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
public class Sinema {
    
    private Long idsinema;
    
    private int kurulus_yili;
    
    private String sinemaAd;
   
    public Long getIdsinema() {
        return idsinema;
    }

    public void setIdsinema(Long idsinema) {
        this.idsinema = idsinema;
    }

    public int getKurulus_yili() {
        return kurulus_yili;
    }

    public void setKurulus_yili(int kurulus_yili) {
        this.kurulus_yili = kurulus_yili;
    }

    public String getSinemaAd() {
        return sinemaAd;
    }

    public void setSinemaAd(String sinemaAd) {
        this.sinemaAd = sinemaAd;
    }

@Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.idsinema);
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
        final Sinema other = (Sinema) obj;
        if (!Objects.equals(this.idsinema, other.idsinema)) {
            return false;
        }
        return true;
    }
    
    
}
