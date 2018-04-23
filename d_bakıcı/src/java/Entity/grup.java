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
public class grup {

    private String password;
    private String kullanici_adi;
    private String grubu;
    private is_arayan is_arayan;
    private is_veren is_veren;

    public is_arayan getIs_arayan() {
        return is_arayan;
    }

    public void setIs_arayan(is_arayan is_arayan) {
        this.is_arayan = is_arayan;
    }

    public is_veren getIs_veren() {
        return is_veren;
    }

    public void setIs_veren(is_veren is_veren) {
        this.is_veren = is_veren;
    }
    
    

    public grup() {
        this.password=null;
        this.kullanici_adi=null;
        this.grubu=null;
        this.is_arayan=null;
        this.is_veren=null;
    }

    public grup(String password, String kullanici_adi, String grubu, is_arayan is_arayan, is_veren is_veren) {
        this.password = password;
        this.kullanici_adi = kullanici_adi;
        this.grubu = grubu;
        this.is_arayan = is_arayan;
        this.is_veren = is_veren;
    }

        
    public grup(String password, String kullanici_adi, String grubu) {
        this.password = password;
        this.kullanici_adi = kullanici_adi;
        this.grubu = grubu;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getKullanici_adi() {
        return kullanici_adi;
    }

    public void setKullanici_adi(String kullanici_adi) {
        this.kullanici_adi = kullanici_adi;
    }

    public String getGrubu() {
        return grubu;
    }

    public void setGrubu(String grubu) {
        this.grubu = grubu;
    }

    @Override
    public String toString() {
        return "grup{" + "password=" + password + ", kullanici_adi=" + kullanici_adi + ", grubu=" + grubu + ", is_arayan=" + is_arayan + ", is_veren=" + is_veren + '}';
    }



}
