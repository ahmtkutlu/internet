/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BEAN;

import DAO.bakılacak_kişiDAO;
import Entity.bakılacak_kisi;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author asus
 */
@ManagedBean(name="kisi")
@SessionScoped
public class bakılacak_kisiController {
       private bakılacak_kisi k =null;
    private ArrayList<bakılacak_kisi> kisilist =null;
    private  bakılacak_kişiDAO kisiDAO=null;
    
     public bakılacak_kisi getK() {
        if(this.k==null)
            this.k =new bakılacak_kisi();
        return k;
    }

    public void setK(bakılacak_kisi kisi) {
        this.k= kisi;
    }

    public ArrayList<bakılacak_kisi> getlist() {
        if(this.kisilist==null){
            this.kisilist=new ArrayList();
            kisilist=this.getKisiDAO().list();
                    }
        return this.kisilist;
    }

    public void setlist(ArrayList<bakılacak_kisi> list) {
        this.kisilist = list;
    }

    public bakılacak_kişiDAO  getKisiDAO() {
        if(this.kisiDAO==null)
            this.kisiDAO = new bakılacak_kişiDAO();
        return kisiDAO;
    }

    public void setKisiDAO(bakılacak_kişiDAO kisiDAO) {
        this.kisiDAO = kisiDAO;
    }
    public String delete(Long id) {
        this.getKisiDAO().delete(id);
        this.kisilist = this.getKisiDAO().list();
        return "/pages/adminstation/seferler/list";
    }

    public bakılacak_kisi getKisiById(Long id) {
        return this.getKisiDAO().getKisi(id);
    }
    
    

    public String update(){
        this.getKisiDAO().update(this.k);
        this.kisilist = this.getKisiDAO().list();
        return "/pages/adminstation/seferler/list";
    }
    
    public String create() {
        this.getKisiDAO().create(this.k);
        this.kisilist = this.getKisiDAO().list();
        this.k=null;
        return "/tamam";
    }
    
    
    
    
}
