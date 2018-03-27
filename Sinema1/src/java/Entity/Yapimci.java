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
public class Yapimci {
    
    private int idyapimci;
    private String yapimci_adi;
    private int kurulus_yili;
    private String mail;

//    public Yapimci() {
//    }
//
//    public Yapimci(int idyapimci, String yapimci_adi, int kurulus_yili, String mail) {
//        this.idyapimci = idyapimci;
//        this.yapimci_adi = yapimci_adi;
//        this.kurulus_yili = kurulus_yili;
//        this.mail = mail;
//    }

//    public int getYapimci_id() {
//        return idyapimci;
//    }
//
//    public void setYapimci_id(int idyapimci) {
//        this.idyapimci = idyapimci;
//    }

    public int getIdyapimci() {
        return idyapimci;
    }

    public void setIdyapimci(int idyapimci) {
        this.idyapimci = idyapimci;
    }
    
    

    public String getYapimci_adi() {
        return yapimci_adi;
    }

    public void setYapimci_adi(String yapimci_adi) {
        this.yapimci_adi = yapimci_adi;
    }

    public int getKurulus_tarihi() {
        return kurulus_yili;
    }

    public void setKurulus_tarihi(int kurulus_yili) {
        this.kurulus_yili = kurulus_yili;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    @Override
    public String toString() {
        return "Yapimci{" + "idyapimci=" + idyapimci + ", yapimci_adi=" + yapimci_adi + '}';
    }
    
    
    
}
