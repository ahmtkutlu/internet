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
    private Sinema sinema;
    private String title;
    private int kapasite;

    public Salon() {
    }

    public Salon(int idsalon, Sinema sinema, String title, int kapasite) {
        this.idsalon = idsalon;
        this.sinema = sinema;
        this.title = title;
        this.kapasite = kapasite;
    }

    public int getIdsalon() {
        return idsalon;
    }

    public void setIdsalon(int idsalon) {
        this.idsalon = idsalon;
    }

    public Sinema getSinema() {
        return sinema;
    }

    public void setSinema(Sinema sinema) {
        
        this.sinema = sinema;
    }

  

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getKapasite() {
        return kapasite;
    }

    public void setKapasite(int kapasite) {
        this.kapasite = kapasite;
    }
    

    
    



    

    
    
    
}
