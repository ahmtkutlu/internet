/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BEAN;

import DAO.is_verenDAO;
import Entity.is_veren;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author asus
 */
@ManagedBean(name="ver")
@SessionScoped
public class is_verenController {
    
         private  is_veren v =null;
    private ArrayList< is_veren> verlist =null;
    private   is_verenDAO verDAO=null;
    
     public  is_veren getV() {
        if(this.v==null)
            this.v =new  is_veren();
        return v;
    }

    public void setV( is_veren ver) {
        this.v= ver;
    }

    public ArrayList< is_veren> getlist() {
        if(this.verlist==null){
            this.verlist=new ArrayList();
            verlist=this.getVerDAO().list();
                    }
        return this.verlist;
    }

    public void setlist(ArrayList< is_veren> list) {
        this.verlist = list;
    }

    public  is_verenDAO  getVerDAO() {
        if(this.verDAO==null)
            this.verDAO = new  is_verenDAO();
        return verDAO;
    }

    public void setVerDAO( is_verenDAO verDAO) {
        this.verDAO = verDAO;
    }
    public String delete(is_veren i) {
        this.getVerDAO().delete(i);
        this.verlist = this.getVerDAO().list();
        return "/pages/adminstation/seferler/list";
    }

    public  is_veren getVerById(Long id) {
        return this.getVerDAO().getVer(id);
    }
    
    

    public String update(){
        this.getVerDAO().update(this.v);
        this.verlist = this.getVerDAO().list();
        return "/pages/adminstation/seferler/list";
    }
    
    public String create() {
        this.getVerDAO().create(this.v);
        this.verlist = this.getVerDAO().list();
        this.v=null;
        return "/tamam";
    }
    
    
    
    
}
