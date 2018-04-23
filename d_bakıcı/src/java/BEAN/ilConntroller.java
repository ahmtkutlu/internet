/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BEAN;

import DAO.ilDAO;
import Entity.il;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author asus
 */
@ManagedBean(name="il")
@SessionScoped
public class ilConntroller {
     private il i =null;
    private ArrayList<il> illist =null;
    private  ilDAO ilDAO=null;
    
     public il getI() {
        if(this.i==null)
            this.i =new il();
        return i;
    }

    public void setI(il i) {
        this.i= i;
    }

    public ArrayList<il> getlist() {
        if(this.illist==null){
            this.illist=new ArrayList();
            illist=this.getilDAO().list();
                    }
        return this.illist;
    }

    public void setlist(ArrayList<il> list) {
        this.illist = list;
    }

    public ilDAO getilDAO() {
        if(this.ilDAO==null)
            this.ilDAO = new ilDAO();
        return ilDAO;
    }

    public void setilDAO(ilDAO ilDAO) {
        this.ilDAO = ilDAO;
    }
    
    
    
    
    public String delete(il ill) {
        this.getilDAO().delete(ill);
        this.illist = this.getilDAO().list();
        return "/pages/adminstation/seferler/list";
    }

    public il getilById(Long id) {
        return this.getilDAO().getIl(id);
    }
    
     public String updateForm(il il){
        this.i=il;
      
        return "/bakici/il/update";
    }
    

    public String update(){
        
        this.getilDAO().update(this.i);
        this.illist = this.getilDAO().list();
        return "/bakici/il/update";
    }
    
    public String create() {
        
        this.getilDAO().create(this.i);
        this.illist = this.getilDAO().list();
        this.i=null;
        return "/tamam";
    }
    
    
    
    
}
