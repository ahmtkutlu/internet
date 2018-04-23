/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BEAN;

import DAO.grupDAO;
import Entity.grup;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author asus
 */
@ManagedBean(name="grup")
@SessionScoped
public class grupController {
      private grup g =null;
    private ArrayList<grup> glist =null;
    private  grupDAO gDAO=null;
    private grup password;
    
     public grup getG() {
        if(this.g==null)
            this.g =new grup();
        return g;
    }

    public void setG(grup g) {
        this.g= g;
    }

    public ArrayList<grup> getlist() {
        if(this.glist==null){
            this.glist=new ArrayList();
            glist=this.getGDAO().list();
                    }
        return this.glist;
    }

    public void setlist(ArrayList<grup> list) {
        this.glist = list;
    }

    public grupDAO  getGDAO() {
        if(this.gDAO==null)
            this.gDAO = new grupDAO();
        return gDAO;
    }

    public void setCDAO(grupDAO gDAO) {
        this.gDAO = gDAO;
    }
    public String delete(String password) {
        this.getGDAO().delete(password);
        this.glist = this.getGDAO().list();
        return "/pages/adminstation/grup/list";
    }

    public grup getGById(String password) {
        return this.getGDAO().getGrup(password);
    }
    
    

    public String update(String password){
        this.getGDAO().update(this.password);
        this.glist = this.getGDAO().list();
        return "/pages/adminstation/grup/list";
    }
    
    public String create() {
        this.getGDAO().create(this.password);
        this.glist = this.getGDAO().list();
        this.g=null;
        return "/tamam";
    }
    

}
