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
public class Salon {
    
    private Long idsalon;
    private Sinema sinema;
    private String title;
    private int kapasite;

    public Salon() {
    }

    public Salon(Long idsalon, Sinema sinema, String title, int kapasite) {
        this.idsalon = idsalon;
        this.sinema = sinema;
        this.title = title;
        this.kapasite = kapasite;
    }

    public Long getIdsalon() {
        return idsalon;
    }

    public void setIdsalon(Long idsalon) {
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
    

    //converter icin
    
    
     @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.idsalon);
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
        final Salon other = (Salon) obj;
        if (!Objects.equals(this.idsalon, other.idsalon)) {
            return false;
        }
        return true;
    }
    



    

    
    
    
}
