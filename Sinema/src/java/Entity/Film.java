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
    private int filmler_idfilmler;
    private String film_adi;
    private int ımdb_puani;
    private int sure;
    private int butce;
    private int yil;
    private int yonetmen_idyonetmen;
    private int yapimci_idyapimci;
    private String icerik;
    private Blob fragman;

    public Film() {
    }

    public Film(int filmler_idfilmler, String film_adi, int ımdb_puani, int sure, int butce, int yil, int yonetmen_idyonetmen, int yapimci_idyapimci, String icerik, Blob fragman) {
        this.filmler_idfilmler = filmler_idfilmler;
        this.film_adi = film_adi;
        this.ımdb_puani = ımdb_puani;
        this.sure = sure;
        this.butce = butce;
        this.yil = yil;
        this.yonetmen_idyonetmen = yonetmen_idyonetmen;
        this.yapimci_idyapimci = yapimci_idyapimci;
        this.icerik = icerik;
        this.fragman = fragman;
    }

    public int getFilm_id() {
        return filmler_idfilmler;
    }

    public void setFilm_id(int filmler_idfilmler) {
        this.filmler_idfilmler = filmler_idfilmler;
    }

    public String getFilm_ad() {
        return film_adi;
    }

    public void setFilm_ad(String film_adi) {
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

    public int getYonetmen_id() {
        return yonetmen_idyonetmen;
    }

    public void setYonetmen_id(int yonetmen_idyonetmen) {
        this.yonetmen_idyonetmen = yonetmen_idyonetmen;
    }

    public int getYapimci_id() {
        return yapimci_idyapimci;
    }

    public void setYapimci_id(int yapimci_idyapimci) {
        this.yapimci_idyapimci = yapimci_idyapimci;
    }

    public String getFilm_icerik() {
        return icerik;
    }

    public void setFilm_icerik(String icerik) {
        this.icerik = icerik;
    }

    public Blob getFragman() {
        return fragman;
    }

    public void setFragman(Blob fragman) {
        this.fragman = fragman;
    }

    
            
    
}
