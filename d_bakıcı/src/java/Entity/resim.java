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
public class resim {
    private Long resim_id;
    private String resim_dosya;
    private Long arayan_id;

    public resim() {
        
        this.resim_id = null;
        this.resim_dosya = null;
        this.arayan_id = null;
    }

    public resim(String resim_dosya) {
        this.resim_dosya = resim_dosya;
    }

    public resim( String resim_dosya, Long arayan_id) {
        
        this.resim_dosya = resim_dosya;
        this.arayan_id = arayan_id;
    }

    public resim(Long resim_id, String resim_dosya, Long arayan_id) {
        this.resim_id = resim_id;
        this.resim_dosya = resim_dosya;
        this.arayan_id = arayan_id;
    }

    public Long getResim_id() {
        return resim_id;
    }

    public void setResim_id(Long resim_id) {
        this.resim_id = resim_id;
    }

    public String getResim_dosya() {
        return resim_dosya;
    }

    public void setResim_dosya(String resim_dosya) {
        this.resim_dosya = resim_dosya;
    }

    public Long getArayan_id() {
        return arayan_id;
    }

    public void setArayan_id(Long arayan_id) {
        this.arayan_id = arayan_id;
    }

    @Override
    public String toString() {
        return "resim{" + "resim_id=" + resim_id + ", resim_dosya=" + resim_dosya + ", arayan_id=" + arayan_id + '}';
    }
    
   
}
