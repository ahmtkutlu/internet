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
public class cv {
    private Long cv_id;
    private String cv_dosya;
    private Long arayan_id;

    public cv() {
          this.cv_id = null;
        this.cv_dosya = null;
        this.arayan_id = null;
    }

    public cv(String cv_dosya) {
        this.cv_dosya = cv_dosya;
    }

    public cv(String cv_dosya, Long arayan_id) {
        this.cv_dosya = cv_dosya;
        this.arayan_id = arayan_id;
    }

    public cv(Long cv_id, String cv_dosya, Long arayan_id) {
        this.cv_id = cv_id;
        this.cv_dosya = cv_dosya;
        this.arayan_id = arayan_id;
    }

    public Long getCv_id() {
        return cv_id;
    }

    public void setCv_id(Long cv_id) {
        this.cv_id = cv_id;
    }

    public String getCv_dosya() {
        return cv_dosya;
    }

    public void setCv_dosya(String cv_dosya) {
        this.cv_dosya = cv_dosya;
    }

    public Long getArayan_id() {
        return arayan_id;
    }

    public void setArayan_id(Long arayan_id) {
        this.arayan_id = arayan_id;
    }

    @Override
    public String toString() {
        return "cv{" + "cv_id=" + cv_id + ", cv_dosya=" + cv_dosya + ", arayan_id=" + arayan_id + '}';
    }
    
}
