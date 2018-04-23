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
public class is_arayan {
    private Long arayan_id;
    private String arayan_ad;
    private String arayan_soyad;
    private Long yas;
    private String uyruk;
    private String mail;
    private String iletisim;
    private String aciklama;
    private Long ilce_id;
    private cv v;
    private yorum yrm;
    private resim rsm ;
    private referans ref;  
    private String password;
    private grup grup;

    private ArrayList<kategori> kategorisi;

    public ArrayList<kategori> getKategorisi() {
        return kategorisi;
    }

    public void setKategorisi(ArrayList<kategori> kategorisi) {
        this.kategorisi = kategorisi;
    }
    
    
    
    public grup getGrup() {
        return grup;
    }

    public void setGrup(grup grup) {
        this.grup = grup;
    }
    
    

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    


    public is_arayan() {
        this.arayan_id = null;
        this.arayan_ad = null;
        this.arayan_soyad = null;
        this.yas = null;
        this.uyruk = null;
        this.mail = null;
        this.iletisim = null;
        this.aciklama = null;
        this.ilce_id = null;
        this.password =null;
    }

    public is_arayan(Long arayan_id, String arayan_ad, String arayan_soyad, Long yas, String uyruk, String mail, String iletisim, String aciklama, Long ilce_id, ArrayList<kategori> kategorisi) {
        this.arayan_id = arayan_id;
        this.arayan_ad = arayan_ad;
        this.arayan_soyad = arayan_soyad;
        this.yas = yas;
        this.uyruk = uyruk;
        this.mail = mail;
        this.iletisim = iletisim;
        this.aciklama = aciklama;
        this.ilce_id = ilce_id;
        this.kategorisi = kategorisi;
    }


    

    public is_arayan(String arayan_ad, String arayan_soyad, Long yas, String uyruk, String mail, String iletisim, String aciklama, Long ilce_id) {
        
        this.arayan_ad = arayan_ad;
        this.arayan_soyad = arayan_soyad;
        this.yas = yas;
        this.uyruk = uyruk;
        this.mail = mail;
        this.iletisim = iletisim;
        this.aciklama = aciklama;
        this.ilce_id = ilce_id;
    }

    public is_arayan(Long arayan_id, String arayan_ad, String arayan_soyad, Long yas, String uyruk, String mail, String iletisim, String aciklama, Long ilce_id) {
        this.arayan_id = arayan_id;
        this.arayan_ad = arayan_ad;
        this.arayan_soyad = arayan_soyad;
        this.yas = yas;
        this.uyruk = uyruk;
        this.mail = mail;
        this.iletisim = iletisim;
        this.aciklama = aciklama;
        this.ilce_id = ilce_id;
    }

    public Long getArayan_id() {
        return arayan_id;
    }

    public void setArayan_id(Long arayan_id) {
        this.arayan_id = arayan_id;
    }

    public String getArayan_ad() {
        return arayan_ad;
    }

    public cv getV() {
        return v;
    }

    public void setV(cv v) {
        this.v = v;
    }

    public yorum getYrm() {
        return yrm;
    }

    public void setYrm(yorum yrm) {
        this.yrm = yrm;
    }

    public resim getRsm() {
        return rsm;
    }

    public void setRsm(resim rsm) {
        this.rsm = rsm;
    }

    public referans getRef() {
        return ref;
    }

    public void setRef(referans ref) {
        this.ref = ref;
    }



    public void setArayan_ad(String arayan_ad) {
        this.arayan_ad = arayan_ad;
    }

    public String getArayan_soyad() {
        return arayan_soyad;
    }

    public void setArayan_soyad(String arayan_soyad) {
        this.arayan_soyad = arayan_soyad;
    }

    public Long getYas() {
        return yas;
    }

    public void setYas(Long yas) {
        this.yas = yas;
    }

    public String getUyruk() {
        return uyruk;
    }

    public void setUyruk(String uyruk) {
        this.uyruk = uyruk;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getIletisim() {
        return iletisim;
    }

    public void setIletisim(String iletisim) {
        this.iletisim = iletisim;
    }

    public String getAciklama() {
        return aciklama;
    }

    public void setAciklama(String aciklama) {
        this.aciklama = aciklama;
    }

    public Long getIlce_id() {
        return ilce_id;
    }

    public void setIlce_id(Long ilce_id) {
        this.ilce_id = ilce_id;
    }

 
    
    
    
}
