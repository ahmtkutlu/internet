/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BEAN;

import DAO.cvDAO;
import Entity.cv;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author asus
 */
@ManagedBean(name="cv")
@SessionScoped
public class cvController {
      private cv c =null;
    private ArrayList<cv> cvlist =null;
    private  cvDAO cDAO=null;
    
     public cv getC() {
        if(this.c==null)
            this.c =new cv();
        return c;
    }

    public void setC(cv c) {
        this.c= c;
    }

    public ArrayList<cv> getlist() {
        if(this.cvlist==null){
            this.cvlist=new ArrayList();
            cvlist=this.getCDAO().list();
                    }
        return this.cvlist;
    }

    public void setlist(ArrayList<cv> list) {
        this.cvlist = list;
    }

    public cvDAO  getCDAO() {
        if(this.cDAO==null)
            this.cDAO = new cvDAO();
        return cDAO;
    }

    public void setCDAO(cvDAO cDAO) {
        this.cDAO = cDAO;
    }
    public String delete(Long id) {
        this.getCDAO().delete(id);
        this.cvlist = this.getCDAO().list();
        return "/pages/adminstation/seferler/list";
    }

    public cv getCById(Long id) {
        return this.getCDAO().getC(id);
    }
    
    

    public String update(Long id){
        this.getCDAO().update(this.c);
        this.cvlist = this.getCDAO().list();
        return "/pages/adminstation/seferler/list";
    }
    
    public String create() {
        this.getCDAO().create(this.c);
        this.cvlist = this.getCDAO().list();
        this.c=null;
        return "/tamam";
    }
    

}
