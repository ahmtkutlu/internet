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
public class yorum {
    private Long y_id;
    private String y_ad;
    private String y_yorum;
    private Long arayan_id;

    public yorum() {
        this.y_id = null;
        this.y_ad = null;
        this.y_yorum = null;
        this.arayan_id = null;
    }

    public yorum(String y_ad, String y_yorum) {
        this.y_ad = y_ad;
        this.y_yorum = y_yorum;
    }

    public yorum(Long y_id, String y_ad, String y_yorum, Long arayan_id) {
        this.y_id = y_id;
        this.y_ad = y_ad;
        this.y_yorum = y_yorum;
        this.arayan_id = arayan_id;
    }
    

    
    public yorum( String y_ad, String y_yorum, Long arayan_id) {
       
        this.y_ad = y_ad;
        this.y_yorum = y_yorum;
        this.arayan_id = arayan_id;
    }

    public Long getY_id() {
        return y_id;
    }

    public void setY_id(Long y_id) {
        this.y_id = y_id;
    }

    public String getY_ad() {
        return y_ad;
    }

    public void setY_ad(String y_ad) {
        this.y_ad = y_ad;
    }

    public String getY_yorum() {
        return y_yorum;
    }

    public void setY_yorum(String y_yorum) {
        this.y_yorum = y_yorum;
    }

    public Long getArayan_id() {
        return arayan_id;
    }

    public void setArayan_id(Long arayan_id) {
        this.arayan_id = arayan_id;
    }

    @Override
    public String toString() {
        return "yorum{" + "y_id=" + y_id + ", y_ad=" + y_ad + ", y_yorum=" + y_yorum + ", arayan_id=" + arayan_id + '}';
    }
    
     
   
}
