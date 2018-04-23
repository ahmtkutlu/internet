/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;


public class ilce {
     private Long ilce_id;
    private String ilce_ad;
    private Long il_id;
    private is_arayan ara;
    private is_veren ver;

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
    

    public ilce() {
        this.ilce_id = null;
        this.ilce_ad = null;
        this.il_id = null;
        
    }

    public ilce(String ilce_ad) {
        this.ilce_ad = ilce_ad;
    }

    public ilce(Long ilce_id, String ilce_ad, Long il_id) {
        this.ilce_id = ilce_id;
        this.ilce_ad = ilce_ad;
        this.il_id = il_id;
    }

    public ilce( String ilce_ad, Long il_id) {
        
        this.ilce_ad = ilce_ad;
        this.il_id = il_id;
    }

    public Long getIlce_id() {
        return ilce_id;
    }

    public void setIlce_id(Long ilce_id) {
        this.ilce_id = ilce_id;
    }

    public String getIlce_ad() {
        return ilce_ad;
    }

    public void setIlce_ad(String ilce_ad) {
        this.ilce_ad = ilce_ad;
    }

    public Long getIl_id() {
        return il_id;
    }

    public void setIl_id(Long il_id) {
        this.il_id = il_id;
    }

    @Override
    public String toString() {
        return "ilce{" + "ilce_id=" + ilce_id + ", ilce_ad=" + ilce_ad + ", il_id=" + il_id + ", ara=" + ara + ", ver=" + ver + '}';
    }

   
}
