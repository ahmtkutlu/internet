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
public class Sinema {
    
    private int idsinema;
    
    private int kurulus_yili;
    
    private String sinemaAd;
    

    public Sinema() {
    }

    public Sinema(int idsinema,  int kurulus_yili,String sinemaAd) {
        this.idsinema = idsinema;
        
        this.kurulus_yili = kurulus_yili;
        this.sinemaAd=sinemaAd;
    }

    public int getIdsinema() {
        return idsinema;
    }

    public void setIdsinema(int idsinema) {
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


    
    
}
