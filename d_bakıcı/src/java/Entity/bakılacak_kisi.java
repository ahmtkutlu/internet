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
public class bakılacak_kisi {
    private Long kisi_id;
    private String kisi_ad;
    private String kisi_soyad;
    private Long  kisi_yas;
    private String aciklama;
    private Long isveren_id;

    public bakılacak_kisi() {
        this.kisi_id = null;
        this.kisi_ad = null;
        this.kisi_soyad = null;
        this.kisi_yas = null;
        this.aciklama =null;
        this.isveren_id =null;
    }

    public bakılacak_kisi(Long kisi_id, String kisi_ad, String kisi_soyad, Long kisi_yas, String aciklama, Long isveren_id) {
        this.kisi_id = kisi_id;
        this.kisi_ad = kisi_ad;
        this.kisi_soyad = kisi_soyad;
        this.kisi_yas = kisi_yas;
        this.aciklama = aciklama;
        this.isveren_id = isveren_id;
    }

    public bakılacak_kisi(String kisi_ad, String kisi_soyad, Long kisi_yas, String aciklama, Long isveren_id) {
        this.kisi_ad = kisi_ad;
        this.kisi_soyad = kisi_soyad;
        this.kisi_yas = kisi_yas;
        this.aciklama = aciklama;
        this.isveren_id = isveren_id;
    }

    public bakılacak_kisi(String kisi_ad, String kisi_soyad, Long kisi_yas, String aciklama) {
        this.kisi_ad = kisi_ad;
        this.kisi_soyad = kisi_soyad;
        this.kisi_yas = kisi_yas;
        this.aciklama = aciklama;
    }

    public Long getKisi_id() {
        return kisi_id;
    }

    public void setKisi_id(Long kisi_id) {
        this.kisi_id = kisi_id;
    }

    public String getKisi_ad() {
        return kisi_ad;
    }

    public void setKisi_ad(String kisi_ad) {
        this.kisi_ad = kisi_ad;
    }

    public String getKisi_soyad() {
        return kisi_soyad;
    }

    public void setKisi_soyad(String kisi_soyad) {
        this.kisi_soyad = kisi_soyad;
    }

    public Long getKisi_yas() {
        return kisi_yas;
    }

    public void setKisi_yas(Long kisi_yas) {
        this.kisi_yas = kisi_yas;
    }

    public String getAciklama() {
        return aciklama;
    }

    public void setAciklama(String aciklama) {
        this.aciklama = aciklama;
    }

    public Long getIsveren_id() {
        return isveren_id;
    }

    public void setIsveren_id(Long isveren_id) {
        this.isveren_id = isveren_id;
    }

    @Override
    public String toString() {
        return "bak\u0131lacak_kisi{" + "kisi_id=" + kisi_id + ", kisi_ad=" + kisi_ad + ", kisi_soyad=" + kisi_soyad + ", kisi_yas=" + kisi_yas + ", aciklama=" + aciklama + ", isveren_id=" + isveren_id + '}';
    }
    
    
     
}
