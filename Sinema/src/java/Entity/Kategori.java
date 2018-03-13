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
public class Kategori {
    
    private int idkategori;
    private String kategori_adi;

    public Kategori() {
    }

    public Kategori(int idkategori, String kategori_adi) {
        this.idkategori = idkategori;
        this.kategori_adi = kategori_adi;
    }

    public int getKategori_id() {
        return idkategori;
    }

    public void setKategori_id(int idkategori) {
        this.idkategori = idkategori;
    }

    public String getKategori_adi() {
        return kategori_adi;
    }

    public void setKategori_adi(String kategori_adi) {
        this.kategori_adi = kategori_adi;
    }
    
}
