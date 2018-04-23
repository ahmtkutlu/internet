/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BEAN;

import DAO.userDAO;
import Entity.user;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author asus
 */
@ManagedBean(name="user")
@SessionScoped
public class userController {
    
    
         private  user r =null;
    private ArrayList<user> rlist =null;
    private  userDAO rDAO=null;
    
     public user getR() {
        if(this.r==null)
            this.r=new user();
        return r;
    }

    public void setR(user r) {
        this.r= r;
    }

    public ArrayList<user> getlist() {
        if(this.rlist==null){
            this.rlist=new ArrayList();
            rlist=this.getRDAO().list();
                    }
        return this.rlist;
    }

    public void setlist(ArrayList<user> list) {
        this.rlist = list;
    }

    public userDAO getRDAO() {
        if(this.rDAO==null)
            this.rDAO = new userDAO();
        return rDAO;
    }

    public void setRDAO(userDAO rDAO) {
        this.rDAO =rDAO;
    }
    public String delete(Long id) {
        this.getRDAO().delete(id);
        this.rlist = this.getRDAO().list();
        return "/pages/adminstation/seferler/list";
    }

    public user getRById(Long id) {
        return this.getRDAO().getUser(id);
    }
    
    

    public String update(){
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
