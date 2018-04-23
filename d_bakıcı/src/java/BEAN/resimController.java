/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BEAN;

import DAO.resimDAO;
import Entity.resim;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author asus
 */

@ManagedBean(name="rsm")
@SessionScoped
public class resimController {
     
         private  resim r =null;
    private ArrayList<resim> rlist =null;
    private  resimDAO rDAO=null;
    
     public resim getR() {
        if(this.r==null)
            this.r=new resim();
        return r;
    }

    public void setR(resim r) {
        this.r= r;
    }

    public ArrayList<resim> getlist() {
        if(this.rlist==null){
            this.rlist=new ArrayList();
            rlist=this.getRDAO().list();
                    }
        return this.rlist;
    }

    public void setlist(ArrayList<resim> list) {
        this.rlist = list;
    }

    public resimDAO getRDAO() {
        if(this.rDAO==null)
            this.rDAO = new resimDAO();
        return rDAO;
    }

    public void setRDAO(resimDAO rDAO) {
        this.rDAO =rDAO;
    }
    public String delete(Long id) {
        this.getRDAO().delete(id);
        this.rlist = this.getRDAO().list();
        return "/pages/adminstation/seferler/list";
    }

    public resim getRById(Long id) {
        return this.getRDAO().getRsm(id);
    }
    
    

    public String update(Long id){
        this.getRDAO().update(this.r);
        this.rlist = this.getRDAO().list();
        return "/pages/adminstation/seferler/list";
    }
    
    public String create() {
        this.getRDAO().create(this.r);
        this.rlist = this.getRDAO().list();
        this.r=null;
        return "/tamam";
    }
    
}
