/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import DAO.KategoriDAO;
import Entity.Kategori;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Kutlu
 */
@SessionScoped
@ManagedBean
public class KategoriController implements Serializable{    
    
    private Kategori kategori;
    private KategoriDAO KategoriDao;
    private List<Kategori> ListeKategori;

    
    
    public void clearForm(){
        this.kategori = new Kategori();
    }
    public void updateForm(Kategori kategori) {
        this.kategori = kategori;       
    }
    
    public void update() {
        this.getKategoriDao().update(this.kategori);
        this.kategori = new Kategori();
    }
    public void deleteConfirm(Kategori kategori){
        this.kategori = kategori ;
    }

    public void delete() {
        this.getKategoriDao().delete(this.kategori);
        this.clearForm();
    }

    public void create() {
        this.getKategoriDao().insert(this.kategori);
        this.kategori = new Kategori();
    }  
       
    public Kategori getKategori() {
          if (this.kategori == null) {
            this.clearForm();
        }
        return kategori;
    }

    public void setKategori(Kategori kategori) {
        this.kategori = kategori;
    }

    public KategoriDAO getKategoriDao() {
        if (this.KategoriDao == null) {
            this.KategoriDao = new KategoriDAO();
        }
        return KategoriDao;
    }

    public void setKategoriDao(KategoriDAO KategoriDao) {
        this.KategoriDao = KategoriDao;
    }

    public List<Kategori> getListeKategori() {
        this.ListeKategori = this.getKategoriDao().findAll();
        return ListeKategori;
    }

    public void setListeKategori(List<Kategori> ListeKategori) {
        this.ListeKategori = ListeKategori;
    }
    
    
    
}
