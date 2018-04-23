/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BEAN;

import DAO.ilceDAO;
import Entity.ilce;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
/**
 *
 * @author asus
 */

@ManagedBean(name="ilce")
@SessionScoped
public class ilceController {
    
     private ilce ce =null;
    private ArrayList<ilce> ilcelist =null;
    private  ilceDAO ilceDAO=null;
    
     public ilce getCe() {
        if(this.ce==null)
            this.ce =new ilce();
        return ce;
    }

    public void setCe(ilce ce) {
        this.ce= ce;
    }

    public ArrayList<ilce> getlist() {
        if(this.ilcelist==null){
            this.ilcelist=new ArrayList();
            ilcelist=this.getIlceDAO().list();
                    }
        return this.ilcelist;
    }

    public void setlist(ArrayList<ilce> list) {
        this.ilcelist = list;
    }

    public ilceDAO getIlceDAO() {
        if(this.ilceDAO==null)
            this.ilceDAO = new ilceDAO();
        return ilceDAO;
    }

    public void setilDAO(ilceDAO ilceDAO) {
        this.ilceDAO = ilceDAO;
    }
    public String delete(Long id) {
        this.getIlceDAO().delete(id);
        this.ilcelist = this.getIlceDAO().list();
        return "/pages/adminstation/seferler/list";
    }

    public ilce getilById(Long id) {
        return this.getIlceDAO().getIlce(id);
    }
    
    

    public String update(){
        this.getIlceDAO().update(this.ce);
        this.ilcelist = this.getIlceDAO().list();
        return "/pages/adminstation/seferler/list";
    }
    
    public String create() {
        this.getIlceDAO().create(this.ce);
        this.ilcelist = this.getIlceDAO().list();
        this.ce=null;
        return "/tamam";
    }
    
    
}
