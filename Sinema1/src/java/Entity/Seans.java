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
    private int salon_idsalon;
    private int filmler_idfilmler;
    private int saat;
    

    public Seans() {
    }

    public Seans(int idseans, int salon_idsalon, int filmler_idfilmler, int saat) {
        this.idseans = idseans;
        this.salon_idsalon = salon_idsalon;
        this.filmler_idfilmler = filmler_idfilmler;
        this.saat = saat;
        
    }

    public int getSeans_id() {
        return idseans;
    }

    public void setSeans_id(int idseans) {
        this.idseans = idseans;
    }

    public int getSalon_id() {
        return salon_idsalon;
    }

    public void setSalon_id(int salon_idsalon) {
        this.salon_idsalon = salon_idsalon;
    }

    public int getFilm_id() {
        return filmler_idfilmler;
    }

    public void setFilm_id(int filmler_idfilmler) {
        this.filmler_idfilmler = filmler_idfilmler;
    }

    public int getSaat() {
        return saat;
    }

    public void setSaat(int saat) {
        this.saat = saat;
    }

   
    
}
