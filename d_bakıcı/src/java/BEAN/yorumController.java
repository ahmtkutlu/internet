/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BEAN;

import DAO.yorumDAO;
import Entity.yorum;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author asus
 */
@ManagedBean(name="yrm")
@SessionScoped
public class yorumController {
      
         private  yorum y =null;
    private ArrayList<yorum> ylist =null;
    private  yorumDAO yDAO=null;
    
     public yorum getY() {
        if(this.y==null)
            this.y=new yorum();
        return y;
    }

    public void setY(yorum y) {
        this.y= y;
    }

    public ArrayList<yorum> getlist() {
        if(this.ylist==null){
            this.ylist=new ArrayList();
            ylist=this.getYDAO().list();
                    }
        return this.ylist;
    }

    public void setlist(ArrayList<yorum> list) {
        this.ylist = list;
    }

    public yorumDAO getYDAO() {
        if(this.yDAO==null)
            this.yDAO = new yorumDAO();
        return yDAO;
    }

    public void setYDAO(yorumDAO yDAO) {
        this.yDAO =yDAO;
    }
    public String delete(Long id) {
        this.getYDAO().delete(id);
        this.ylist = this.getYDAO().list();
        return "/pages/adminstation/seferler/list";
    }

    public yorum getYById(Long id) {
        return this.getYDAO().getYrm(id);
    }
    
    

    public String update(){
        this.getYDAO().update(this.y);
        this.ylist = this.getYDAO().list();
        return "/pages/adminstation/seferler/list";
    }
    
    public String create() {
        this.getYDAO().create(this.y);
        this.ylist = this.getYDAO().list();
        this.y=null;
        return "/tamam";
    }
    
}
