/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

/**
 *
 * @author asus
 */
public class referans {
    private Long ref_id;
    private String ref_ad;
    private String ref_soyad;
    private Long arayan_id;

    public referans() {
         this.ref_id = null;
        this.ref_ad = null;
         this.ref_soyad = null;
        this.arayan_id = null;
    }

    public referans(String ref_ad, String ref_soyad) {
        this.ref_ad = ref_ad;
        this.ref_soyad = ref_soyad;
    }

    public referans(String ref_ad, String ref_soyad, Long arayan_id) {
        this.ref_ad = ref_ad;
        this.ref_soyad = ref_soyad;
        this.arayan_id = arayan_id;
    }

    public referans(Long ref_id, String ref_ad,String ref_soyad, Long arayan_id) {
        this.ref_id = ref_id;
        this.ref_ad = ref_ad;
        this.ref_soyad = ref_soyad;
        this.arayan_id = arayan_id;
    }

    public String getRef_soyad() {
        return ref_soyad;
    }

    public void setRef_soyad(String ref_soyad) {
        this.ref_soyad = ref_soyad;
    }

    public Long getRef_id() {
        return ref_id;
    }

    public void setRef_id(Long ref_id) {
        this.ref_id = ref_id;
    }

    public String getRef_ad() {
        return ref_ad;
    }

    public void setRef_ad(String ref_ad) {
        this.ref_ad = ref_ad;
    }

    public Long getArayan_id() {
        return arayan_id;
    }

    public void setArayan_id(Long arayan_id) {
        this.arayan_id = arayan_id;
    }

    @Override
    public String toString() {
        return "referans{" + "ref_id=" + ref_id + ", ref_ad=" + ref_ad + ", ref_soyad=" + ref_soyad + ", arayan_id=" + arayan_id + '}';
    }
    
    
   
}
