/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BEAN;

import DAO.kategoriDAO;
import Entity.kategori;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author asus
 */

@ManagedBean(name="kategori")
@SessionScoped
public class kategoriController {
    
         private kategori k =null;
    private ArrayList<kategori> klist =null;
    private  kategoriDAO kDAO=null;
    
     public kategori getK() {
        if(this.k==null)
            this.k =new kategori();
        return k;
    }

    public void setK(kategori k) {
        this.k= k;
    }

    public ArrayList<kategori> getlist() {
        if(this.klist==null){
            this.klist=new ArrayList();
            klist=this.getKDAO().list();
                    }
        return this.klist;
    }

    public void setlist(ArrayList<kategori> list) {
        this.klist = list;
    }

    public kategoriDAO  getKDAO() {
        if(this.kDAO==null)
            this.kDAO = new kategoriDAO();
        return kDAO;
    }

    public void setKisiDAO(kategoriDAO kDAO) {
        this.kDAO = kDAO;
    }
    public String delete(kategori k) {
        this.getKDAO().delete(k);
        this.klist = this.getKDAO().list();
        return "/pages/adminstation/seferler/list";
    }

    public kategori getKById(Long id) {
        return this.getKDAO().getKat(id);
    }
    
    

    public String update(){
        this.getKDAO().update(this.k);
        this.klist = this.getKDAO().list();
        return "/pages/adminstation/seferler/list";
    }
    
    public String create() {
        this.getKDAO().create(this.k);
        this.klist = this.getKDAO().list();
        this.k=null;
        return "/tamam";
    }
    
    
    
    
}
