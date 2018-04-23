/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BEAN;

import DAO.referansDAO;
import Entity.referans;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author asus
 */
@ManagedBean(name="ref")
@SessionScoped
public class referansController {
 
    
         private  referans r =null;
    private ArrayList<referans> reflist =null;
    private  referansDAO refDAO=null;
    
     public referans getR() {
        if(this.r==null)
            this.r=new referans();
        return r;
    }

    public void setR(referans r) {
        this.r= r;
    }

    public ArrayList<referans> getlist() {
        if(this.reflist==null){
            this.reflist=new ArrayList();
            reflist=this.getRefDAO().list();
                    }
        return this.reflist;
    }

    public void setlist(ArrayList<referans> list) {
        this.reflist = list;
    }

    public referansDAO getRefDAO() {
        if(this.refDAO==null)
            this.refDAO = new referansDAO();
        return refDAO;
    }

    public void setRefDAO(referansDAO refDAO) {
        this.refDAO =refDAO;
    }
    public String delete(Long id) {
        this.getRefDAO().delete(id);
        this.reflist = this.getRefDAO().list();
        return "/pages/adminstation/seferler/list";
    }

    public referans getRefById(Long id) {
        return this.getRefDAO().getRef(id);
    }
    
    

    public String update(){
        this.getRefDAO().update(this.r);
        this.reflist = this.getRefDAO().list();
        return "/pages/adminstation/seferler/list";
    }
    
    public String create() {
        this.getRefDAO().create(this.r);
        this.reflist = this.getRefDAO().list();
        this.r=null;
        return "/tamam";
    }
    
    
    
    
}
