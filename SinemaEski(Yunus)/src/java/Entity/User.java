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
public class User {
    
    private int iduser;
    private String user_ad;
    private String user_soyad;
    private String mail;
    private int sifre;
    
    
    private int admin;

    public User() {
    }

    public User(int iduser, String user_ad, String user_soyad, String mail, int sifre, int admin) {
        this.iduser = iduser;
        this.user_ad = user_ad;
        this.user_soyad = user_soyad;
        this.mail = mail;
        this.sifre = sifre;
        this.admin = admin;
    }

    public int getIduser() {
        return iduser;
    }

    public void setIduser(int iduser) {
        this.iduser = iduser;
    }

    public String getUser_ad() {
        return user_ad;
    }

    public void setUser_ad(String user_ad) {
        this.user_ad = user_ad;
    }

    public String getUser_soyad() {
        return user_soyad;
    }

    public void setUser_soyad(String user_soyad) {
        this.user_soyad = user_soyad;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public int getSifre() {
        return sifre;
    }

    public void setSifre(int sifre) {
        this.sifre = sifre;
    }

    public int getAdmin() {
        return admin;
    }

    public void setAdmin(int admin) {
        this.admin = admin;
    }

    
}
