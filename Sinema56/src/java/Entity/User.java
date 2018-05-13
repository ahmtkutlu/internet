/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.util.Objects;

/**
 *
 * @author idea
 */
public class User {
    
    private Long iduser;
    private String user_ad;
    private String user_soyad;
    private String mail;
    private int sifre;        
    private int admin;

    public User() {
    }

    public User(Long iduser, String user_ad, String user_soyad, String mail, int sifre, int admin) {
        this.iduser = iduser;
        this.user_ad = user_ad;
        this.user_soyad = user_soyad;
        this.mail = mail;
        this.sifre = sifre;
        this.admin = admin;
    }

    public Long getIduser() {
        return iduser;
    }

    public void setIduser(Long iduser) {
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

    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.iduser);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final User other = (User) obj;
        if (!Objects.equals(this.iduser, other.iduser)) {
            return false;
        }
        return true;
    }
    
}
