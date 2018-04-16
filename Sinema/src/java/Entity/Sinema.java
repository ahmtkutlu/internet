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

    public Sinema() {
    }

    public Sinema(int idsinema,  int kurulus_yili) {
        this.idsinema = idsinema;
        
        this.kurulus_yili = kurulus_yili;
    }

    public int getSinema_id() {
        return idsinema;
    }

    public void setSinema_id(int idsinema) {
        this.idsinema = idsinema;
    }

    

    public int getKurulus_tarihi() {
        return kurulus_yili;
    }

    public void setKurulus_tarihi(int kurulus_yili) {
        this.kurulus_yili = kurulus_yili;
    }
    
    
}
