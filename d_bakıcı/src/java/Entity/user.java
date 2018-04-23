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
public class user {
    private Long user_id;
    private String user_parola;
    private String user_ad_soyad;
    private String user_email;

    public user() {
        this.user_id = null;
        this.user_parola = null;
        this.user_ad_soyad = null;
        this.user_email = null;
    }

    public user(Long user_id, String user_parola, String user_ad_soyad, String user_email) {
        this.user_id = user_id;
        this.user_parola = user_parola;
        this.user_ad_soyad = user_ad_soyad;
        this.user_email = user_email;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public String getUser_parola() {
        return user_parola;
    }

    public void setUser_parola(String user_parola) {
        this.user_parola = user_parola;
    }

    public String getUser_ad_soyad() {
        return user_ad_soyad;
    }

    public void setUser_ad_soyad(String user_ad_soyad) {
        this.user_ad_soyad = user_ad_soyad;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }
    
     @Override
    public String toString() {
        return "User{" + "user_id=" + user_id + ", user_ad_soyad=" + user_ad_soyad + ", user_email=" + user_email +'}';
    }
}
