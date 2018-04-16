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
public class Salon {
    
    private int idsalon;
    private int sinema_idsinema;
    private String title;
    private String kapasite;

    public Salon() {
    }

    public Salon(int idsalon, int sinema_idsinema, String title, String kapasite) {
        this.idsalon = idsalon;
        this.sinema_idsinema = sinema_idsinema;
        this.title = title;
        this.kapasite = kapasite;
    }

    public int getSalon_id() {
        return idsalon;
    }

    public void setSalon_id(int idsalon) {
        this.idsalon = idsalon;
    }

    public int getSinema_id() {
        return sinema_idsinema;
    }

    public void setSinema_id(int sinema_idsinema) {
        this.sinema_idsinema = sinema_idsinema;
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
