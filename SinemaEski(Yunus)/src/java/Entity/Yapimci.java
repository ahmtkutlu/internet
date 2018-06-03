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

    public int getKurulus_yili() {
        return kurulus_yili;
    }

    public void setKurulus_yili(int kurulus_yili) {
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
