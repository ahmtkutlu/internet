/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.sql.Blob;

/**
 *
 * @author idea
 */
public class Film {
    private int idfilmler;
    private String film_adi;
    private int ımdb_puani;
    private int sure;
    private int butce;
    private int yil;
    private String icerik;
    private Blob fragman;
    
    private Yapimci yapimci;
    
    private Yonetmen yonetmen;
    



    public int getIdfilmler() {
        return idfilmler;
    }

    public void setIdfilmler(int idfilmler) {
        this.idfilmler = idfilmler;
    }
    
    

    public String getFilm_adi() {
        return film_adi;
    }

    public void setFilm_adi(String film_adi) {
        this.film_adi = film_adi;
    }
    
    


    public int getImdb_puani() {
        return ımdb_puani;
    }

    public void setImdb_puani(int ımdb_puani) {
        this.ımdb_puani = ımdb_puani;
    }

    public int getSure() {
        return sure;
    }

    public void setSure(int sure) {
        this.sure = sure;
    }

    public int getButce() {
        return butce;
    }

    public void setButce(int butce) {
        this.butce = butce;
    }

    public int getYil() {
        return yil;
    }

    public void setYil(int yil) {
        this.yil = yil;
    }

    

//    public String getFilm_icerik() {
//        return icerik;
//    }
//
//    public void setFilm_icerik(String icerik) {
//        this.icerik = icerik;
//    }

    public String getIcerik() {
        return icerik;
    }

    public void setIcerik(String icerik) {
        this.icerik = icerik;
    }
    
    


    public Yapimci getYapimci() {
        return yapimci;
    }

    public void setYapimci(Yapimci yapimci) {
        this.yapimci = yapimci;
    }

    public Yonetmen getYonetmen() {
        return yonetmen;
    }

    public void setYonetmen(Yonetmen yonetmen) {
        this.yonetmen = yonetmen;
    }

    @Override
    public String toString() {
        return "Film{" + "idfilmler=" + idfilmler + ", film_adi=" + film_adi + ", icerik=" + icerik + ", yapimci=" + yapimci + ", yonetmen=" + yonetmen + '}';
    }


    
    

    

   

    


    

    
            
    
}
