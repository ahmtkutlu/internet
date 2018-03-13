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
public class Yorum {
    
    private int idyorum;
    private int filmler_idfilmler;
    private int user_iduser;
    private String icerik;
    private String yorum_basligi;
    private Calendar yorum_tarihi;

    public Yorum() {
    }

    public Yorum(int idyorum, int filmler_idfilmler, int user_iduser, String icerik, String yorum_basligi, Calendar yorum_tarihi) {
        this.idyorum = idyorum;
        this.filmler_idfilmler = filmler_idfilmler;
        this.user_iduser = user_iduser;
        this.icerik = icerik;
        this.yorum_basligi = yorum_basligi;
        this.yorum_tarihi = yorum_tarihi;
    }

    public int getYorum_id() {
        return idyorum;
    }

    public void setYorum_id(int idyorum) {
        this.idyorum = idyorum;
    }

    public int getFilm_id() {
        return filmler_idfilmler;
    }

    public void setFilm_id(int filmler_idfilmler) {
        this.filmler_idfilmler = filmler_idfilmler;
    }

    public int getUser_id() {
        return user_iduser;
    }

    public void setUser_id(int user_iduser) {
        this.user_iduser = user_iduser;
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

    public Calendar getYorumolusturma_tarihi() {
        return yorum_tarihi;
    }

    public void setYorumolusturma_tarihi(Calendar yorum_tarihi) {
        this.yorum_tarihi = yorum_tarihi;
    }
      
      
    
}
