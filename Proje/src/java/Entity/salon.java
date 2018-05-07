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
public class salon {

    private Long salon_id;
    private String title;
    private String kapasite;
    private ArrayList<seans> seansi;
    private Long sinema_id;

    public Long getSinema_id() {
        return sinema_id;
    }

    public void setSinema_id(Long sinema_id) {
        this.sinema_id = sinema_id;
    }

   
    
    

    public ArrayList<seans> getSeansi() {
        return seansi;
    }

    public void setSeansi(ArrayList<seans> seansi) {
        this.seansi = seansi;
    }

    public Long getSalon_id() {
        return salon_id;
    }

    public void setSalon_id(Long salon_id) {
        this.salon_id = salon_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getKapasite() {
        return kapasite;
    }

    public void setKapasite(String kapasite) {
        this.kapasite = kapasite;
    }

}
