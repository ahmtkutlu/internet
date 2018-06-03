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
    private String resim;
    private Film film;

    public Galeri() {
    }

    public Galeri(int idgaleri, String resim, Film film) {
        this.idgaleri = idgaleri;
        this.resim = resim;
        this.film = film;
    }
    
    public String getResim() {
        return resim;
    }

    public void setResim(String resim) {
        this.resim = resim;
    }

    public int getIdgaleri() {
        return idgaleri;
    }

    public void setIdgaleri(int idgaleri) {
        this.idgaleri = idgaleri;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film= film;
    }
    
}
