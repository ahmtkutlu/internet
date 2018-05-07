
package Entity;

import java.util.ArrayList;


public class yapimci {

    private Long yapimci_id;
    private String yapimci_adi;
    private int kurulus_yili;
    private String mail;
    
    private ArrayList<film> filmi;

    public int getKurulus_yili() {
        return kurulus_yili;
    }

    public void setKurulus_yili(int kurulus_yili) {
        this.kurulus_yili = kurulus_yili;
    }

    public ArrayList<film> getFilmi() {
        return filmi;
    }

    public void setFilmi(ArrayList<film> filmi) {
        this.filmi = filmi;
    }

    public Long getYapimci_id() {
        return yapimci_id;
    }

    public void setYapimci_id(Long yapimci_id) {
        this.yapimci_id = yapimci_id;
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
        return "yapimci{" + "yapimci_id=" + yapimci_id + ", yapimci_adi=" + yapimci_adi + ", kurulus_yili=" + kurulus_yili + ", mail=" + mail + ", filmi=" + filmi + '}';
    }

  

}
