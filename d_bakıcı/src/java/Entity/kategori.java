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
    private is_arayan ara;
    private is_veren ver;

    
    
       private ArrayList<is_arayan>isarayan;

    public ArrayList<is_arayan> getIsarayan() {
        return isarayan;
    }

    public void setIsarayan(ArrayList<is_arayan> isarayan) {
        this.isarayan = isarayan;
    }
    
    
    
    public is_arayan getAra() {
        return ara;
    }

    public void setAra(is_arayan ara) {
        this.ara = ara;
    }

    public is_veren getVer() {
        return ver;
    }

    public void setVer(is_veren ver) {
        this.ver = ver;
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

    @Override
    public String toString() {
        return "kategori{" + "kategori_id=" + kategori_id + ", kategori_ad=" + kategori_ad + ", ara=" + ara + ", ver=" + ver + '}';
    }
    
    
}
