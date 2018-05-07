/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import Dao.salonDAO;
import Dao.yapimciDAO;
import Entity.salon;
import Entity.yapimci;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author idea
 */
@ManagedBean(name = "salon")
@SessionScoped
public class salonController {

    private salon s = null;
    private ArrayList<salon> salonlist = null;
    private salonDAO salonDAO = null;

     public String delete(salon salon) {
        this.getSalonDAO().delete(salon);
        this.salonlist = this.getSalonDAO().list();
        return "/tamamm";
    }
     
     public String create() {
        
        this.getSalonDAO().create(this.s);
        this.salonlist = this.getSalonDAO().list();
        this.s=null;
        return "/tamam";
    }
     
      public String update(){
        
        this.getSalonDAO().update(this.s);
        this.salonlist = this.getSalonDAO().list();
        return "/sinema/yapimci/update";
    }
    public salon getS() {
        if (this.s == null) {
            this.s = new salon();
        }

        return s;
    }

    public void setS(salon s) {
        this.s = s;
    }

    public ArrayList<salon> getSalonlist() {
        if (this.salonlist == null) {
            this.salonlist = new ArrayList();
            salonlist = this.getSalonDAO().list();
        }

        return this.salonlist;
    }

    public void setSalonlist(ArrayList<salon> salonlist) {
        this.salonlist = salonlist;
    }

    public salonDAO getSalonDAO() {
        if (this.salonDAO == null) {
            this.salonDAO = new salonDAO();
        }
        return salonDAO;
    }

    public void setSalonDAO(salonDAO salonDAO) {
        this.salonDAO = salonDAO;
    }

}
