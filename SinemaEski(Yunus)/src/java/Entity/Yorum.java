/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.util.Calendar;
import java.sql.Date;

/**
 *
 * @author idea
 */
public class Yorum {
    
    private int idyorum;
    private Film film;
    private User user;
    private String icerik;
    private String yorum_basligi;
    private Date yorum_tarihi;
    

    public Yorum() {
    }

    public Yorum(int idyorum, Film film, User user, String icerik, String yorum_basligi, Date yorum_tarihi) {
        this.idyorum = idyorum;
        this.film = film;
        this.user = user;
        this.icerik = icerik;
        this.yorum_basligi = yorum_basligi;
        this.yorum_tarihi = yorum_tarihi;
        
    }

    public int getIdyorum() {
        return idyorum;
    }

    public void setIdyorum(int idyorum) {
        this.idyorum = idyorum;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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

    public Date getYorum_tarihi() {
        return yorum_tarihi;
    }

    public void setYorum_tarihi(Date yorum_tarihi) {
        this.yorum_tarihi = yorum_tarihi;
    }
  
}
