/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.util.Calendar;

/**
 *
 * @author idea
 */
public class yorum {
    
    private Long yorum_id;
    private Long film_id;
    private Long user_id;
    private String icerik;
    private String yorum_basligi;
    private Calendar yorum_tarihi;

    public yorum() {
    }

    public yorum(Long yorum_id, Long film_id, String icerik, String yorum_basligi, Calendar yorum_tarihi) {
        this.yorum_id = yorum_id;
        this.film_id = film_id;
        this.icerik = icerik;
        this.yorum_basligi = yorum_basligi;
        this.yorum_tarihi = yorum_tarihi;
    }

    public yorum(Long yorum_id, Long film_id, String icerik) {
        this.yorum_id = yorum_id;
        this.film_id = film_id;
        this.icerik = icerik;
    }

    public yorum(Long film_id, String icerik) {
        this.film_id = film_id;
        this.icerik = icerik;
    }

    public yorum(Long yorum_id, Long film_id, Long user_id, String icerik) {
        this.yorum_id = yorum_id;
        this.film_id = film_id;
        this.user_id = user_id;
        this.icerik = icerik;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }


    public Long getYorum_id() {
        return yorum_id;
    }

    public void setYorum_id(Long yorum_id) {
        this.yorum_id = yorum_id;
    }

    public Long getFilm_id() {
        return film_id;
    }

    public void setFilm_id(Long film_id) {
        this.film_id = film_id;
    }

    public String getIcerik() {
        return icerik;
    }

    public void setIcerik(String icerik) {
        this.icerik = icerik;
    }

    public String getYorum_basligi() {
        return yorum_basligi;
    }

    public void setYorum_basligi(String yorum_basligi) {
        this.yorum_basligi = yorum_basligi;
    }

    public Calendar getYorum_tarihi() {
        return yorum_tarihi;
    }

    public void setYorum_tarihi(Calendar yorum_tarihi) {
        this.yorum_tarihi = yorum_tarihi;
    }

    
      
      
    
}
