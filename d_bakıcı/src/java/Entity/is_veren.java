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
public class is_veren {
    private Long isveren_id;
    private String isveren_ad;
    private String isveren_soyad;
    private String isveren_iletisim;
    private String isveren_sigorta;
    private String isveren_servis;
    private String aciklama;
    private Long ilce_id;
    private kategori ktgr;
   
    private String password;
    
 private ArrayList<bakılacak_kisi> kisi;

    public ArrayList<bakılacak_kisi> getKisi() {
        return kisi;
    }

    public void setKisi(ArrayList<bakılacak_kisi> kisi) {
        this.kisi = kisi;
    }
    
    
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    

    public String getParola() {
        return parola;
    }

    public void setParola(String parola) {
        this.parola = parola;
    }
    private String parola;
    

    public is_veren() {
        
        this.isveren_id = null;
        this.isveren_ad = null;
        this.isveren_soyad = null;
        this.isveren_iletisim = null;
        this.isveren_sigorta = null;
        this.isveren_servis = null;
        this.aciklama = null;
        this.ilce_id = null;
        this.password =null;
    }

    public is_veren(String isveren_ad, String isveren_soyad, String isveren_iletisim, String isveren_sigorta, String isveren_servis, String aciklama, Long ilce_id, kategori ktgr, String password, String parola) {
        this.isveren_ad = isveren_ad;
        this.isveren_soyad = isveren_soyad;
        this.isveren_iletisim = isveren_iletisim;
        this.isveren_sigorta = isveren_sigorta;
        this.isveren_servis = isveren_servis;
        this.aciklama = aciklama;
        this.ilce_id = ilce_id;
        this.ktgr = ktgr;
        
        this.password = password;
        this.parola = parola;
    }
    
    
    public is_veren(Long isveren_id, String isveren_ad, String isveren_soyad, String isveren_iletisim, String isveren_sigorta, String isveren_servis, String aciklama, Long ilce_id) {
        this.isveren_id = isveren_id;
        this.isveren_ad = isveren_ad;
        this.isveren_soyad = isveren_soyad;
        this.isveren_iletisim = isveren_iletisim;
        this.isveren_sigorta = isveren_sigorta;
        this.isveren_servis = isveren_servis;
        this.aciklama = aciklama;
        this.ilce_id = ilce_id;
    }

    public is_veren(String isveren_ad, String isveren_soyad, String isveren_iletisim, String isveren_sigorta, String isveren_servis, String aciklama, Long ilce_id) {
        this.isveren_ad = isveren_ad;
        this.isveren_soyad = isveren_soyad;
        this.isveren_iletisim = isveren_iletisim;
        this.isveren_sigorta = isveren_sigorta;
        this.isveren_servis = isveren_servis;
        this.aciklama = aciklama;
        this.ilce_id = ilce_id;
    }

    public Long getIsveren_id() {
        return isveren_id;
    }

    public void setIsveren_id(Long isveren_id) {
        this.isveren_id = isveren_id;
    }

    public String getIsveren_ad() {
        return isveren_ad;
    }

    public void setIsveren_ad(String isveren_ad) {
        this.isveren_ad = isveren_ad;
    }

    public String getIsveren_soyad() {
        return isveren_soyad;
    }

    public void setIsveren_soyad(String isveren_soyad) {
        this.isveren_soyad = isveren_soyad;
    }

    public String getIsveren_iletisim() {
        return isveren_iletisim;
    }

    public void setIsveren_iletisim(String isveren_iletisim) {
        this.isveren_iletisim = isveren_iletisim;
    }

    public String getIsveren_sigorta() {
        return isveren_sigorta;
    }

    public void setIsveren_sigorta(String isveren_sigorta) {
        this.isveren_sigorta = isveren_sigorta;
    }

    public String getIsveren_servis() {
        return isveren_servis;
    }

    public void setIsveren_servis(String isveren_servis) {
        this.isveren_servis = isveren_servis;
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

    public kategori getKtgr() {
        return ktgr;
    }

    public void setKtgr(kategori ktgr) {
        this.ktgr = ktgr;
    }

    

    @Override
    public String toString() {
        return "is_veren{" + "isveren_id=" + isveren_id + ", isveren_ad=" + isveren_ad + ", isveren_soyad=" + isveren_soyad + ", isveren_iletisim=" + isveren_iletisim + ", isveren_sigorta=" + isveren_sigorta + ", isveren_servis=" + isveren_servis + ", aciklama=" + aciklama + ", ilce_id=" + ilce_id + ", ktgr=" + ktgr + ", kisi=" + kisi + ", password=" + password + ", parola=" + parola + '}';
    }

 
    
  
    
}
