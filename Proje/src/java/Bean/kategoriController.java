/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;


import Dao.KategoriDao;
import Entity.kategori;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
//import javax.inject.Named;

/**
 *
 * @author idea
 */
@ManagedBean(name="kategori")
@SessionScoped
public class kategoriController implements Serializable {

       private kategori k =null;
    private ArrayList<kategori> klist =null;
    private  KategoriDao kDAO=null;

    public kategori getK() {
        if(this.k==null)
            this.k=new kategori();
        return k;
    }

    public void setK(kategori k) {
        this.k = k;
    }

    public ArrayList<kategori> getKlist() {
        if(this.klist==null)
            this.klist=new ArrayList();
        klist=this.getkDAO().list();
        return this.klist;
    }

    public void setKlist(ArrayList<kategori> klist) {
        this.klist = klist;
    }

    public KategoriDao getkDAO() {
        if(this.kDAO==null)
            this.kDAO=new KategoriDao();
        return kDAO;
    }

    public void setkDAO(KategoriDao kDAO) {
        this.kDAO = kDAO;
    }

    
    public String delete(kategori k) {
        this.getkDAO().delete(k);
        this.klist = this.getkDAO().list();
        return "/pages/adminstation/seferler/list";
    }

    public kategori getKById(Long id) {
        return this.getkDAO().getKat(id);
    }
    
    

    public String update(){
        this.getkDAO().update(this.k);
        this.klist = this.getkDAO().list();
        return "/pages/adminstation/seferler/list";
    }
    
    public String create() {
        this.getkDAO().create(this.k);
        this.klist = this.getkDAO().list();
        this.k=null;
        return "/tamam";
    }
    

}