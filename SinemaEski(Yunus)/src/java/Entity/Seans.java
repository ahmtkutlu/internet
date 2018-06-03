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
public class Seans {
    
    private int idseans;
    private Salon salon;
    private Film film;
    private int saat;
    

    public Seans() {
    }

    public Seans(int idseans, Salon salon, Film film, int saat) {
        this.idseans = idseans;
        this.salon = salon;
        this.film = film;
        this.saat = saat;
        
    }

    public int getIdseans() {
        return idseans;
    }

    public void setIdseans(int idseans) {
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

 

   
    
}
