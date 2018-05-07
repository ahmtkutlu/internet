/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.util.ArrayList;

/**
 *
 * @author asus
 */
public class kategori {

    private Long kategori_id;
    private String kategori_ad;
    private ArrayList<film>filmi;

    public ArrayList<film> getFilmi() {
        return filmi;
    }

    public void setFilmi(ArrayList<film> filmi) {
        this.filmi = filmi;
    }
    
    

    public kategori() {
        this.kategori_id = null;
        this.kategori_ad = null;
    }

    public kategori(Long kategori_id, String kategori_ad) {
        this.kategori_id = kategori_id;
        this.kategori_ad = kategori_ad;
    }

    public kategori(String kategori_ad) {
        this.kategori_ad = kategori_ad;
    }

    public Long getKategori_id() {
        return kategori_id;
    }

    public void setKategori_id(Long kategori_id) {
        this.kategori_id = kategori_id;
    }

    public String getKategori_ad() {
        return kategori_ad;
    }

    public void setKategori_ad(String kategori_ad) {
        this.kategori_ad = kategori_ad;
    }

    

}
