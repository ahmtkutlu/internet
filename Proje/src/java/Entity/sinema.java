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
public class sinema {
    
    private Long sinema_id;
    private int kurulus_yili;
    private ArrayList<salon> salonu;

    public Long getSinema_id() {
        return sinema_id;
    }

    public void setSinema_id(Long sinema_id) {
        this.sinema_id = sinema_id;
    }

    public int getKurulus_yili() {
        return kurulus_yili;
    }

    public void setKurulus_yili(int kurulus_yili) {
        this.kurulus_yili = kurulus_yili;
    }

    public ArrayList<salon> getSalonu() {
        return salonu;
    }

    public void setSalonu(ArrayList<salon> salonu) {
        this.salonu = salonu;
    }
    
    

   
}
