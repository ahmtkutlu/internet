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
public class Seans {
    
    private Long idseans;
    private Salon salon;
    private Film film;
    private int saat;
    

    public Seans() {
    }

    public Seans(Long idseans, Salon salon, Film film, int saat) {
        this.idseans = idseans;
        this.salon = salon;
        this.film = film;
        this.saat = saat;
        
    }

    public Long getIdseans() {
        return idseans;
    }

    public void setIdseans(Long idseans) {
        this.idseans = idseans;
    }

    public Salon getSalon() {
        return salon;
    }

    public void setSalon(Salon salon) {
        this.salon = salon;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }



 

    public int getSaat() {
        return saat;
    }

    public void setSaat(int saat) {
        this.saat = saat;
    }

    
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.idseans);
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
        final Seans other = (Seans) obj;
        if (!Objects.equals(this.idseans, other.idseans)) {
            return false;
        }
        return true;
    }
 

   
    
}
