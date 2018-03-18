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
public class Galeri {
    
    private int idgaleri;
    private Blob resim;
    private int filmler_idfilmler;

    public Galeri() {
    }

    public Galeri(int idgaleri, Blob resim, int filmler_idfilmler) {
        this.idgaleri = idgaleri;
        this.resim = resim;
        this.filmler_idfilmler = filmler_idfilmler;
    }

    public int getId() {
        return idgaleri;
    }

    public void setId(int idgaleri) {
        this.idgaleri = idgaleri;
    }

    public Blob getResim() {
        return resim;
    }

    public void setResim(Blob resim) {
        this.resim = resim;
    }

    public int getFilm_id() {
        return filmler_idfilmler;
    }

    public void setFilm_id(int filmler_idfilmler) {
        this.filmler_idfilmler = filmler_idfilmler;
    }
    
}
