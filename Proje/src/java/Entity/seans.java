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
public class seans {

    private Long seans_id;
    private Long salon_id;
    private int saat;
    private Long film_id;
    

    public seans() {
    }

    public seans(Long seans_id, Long salon_id, int saat, Long film_id) {
        this.seans_id = seans_id;
        this.salon_id = salon_id;
        this.saat = saat;
        this.film_id = film_id;
    }

    public seans(Long salon_id, int saat, Long film_id) {
        this.salon_id = salon_id;
        this.saat = saat;
        this.film_id = film_id;
    }

   
    

    


    public Long getSeans_id() {
        return seans_id;
    }

    public void setSeans_id(Long seans_id) {
        this.seans_id = seans_id;
    }

    public Long getSalon_id() {
        return salon_id;
    }

    public void setSalon_id(Long salon_id) {
        this.salon_id = salon_id;
    }
    
    

   

    public int getSaat() {
        return saat;
    }

    public void setSaat(int saat) {
        this.saat = saat;
    }

    public Long getFilm_id() {
        return film_id;
    }

    public void setFilm_id(Long film_id) {
        this.film_id = film_id;
    }

    
}
