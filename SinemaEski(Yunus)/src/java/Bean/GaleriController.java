/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import DAO.GaleriDAO;
import Entity.Galeri;
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
public class GaleriController implements Serializable{
    
    private Galeri galeri;
    private GaleriDAO GaleriDao;
    private List<Galeri> ListeGaleri;


    public void clearForm(){
        this.galeri = new Galeri();
    }
    public void updateForm(Galeri galeri) {
        this.galeri = galeri;       
    }
    
    public void update() {
        this.getGaleriDao().update(this.galeri);
        this.galeri = new Galeri();
    }
    public void deleteConfirm(Galeri galeri){
        this.galeri = galeri ;
    }

    public void delete() {
        this.getGaleriDao().delete(this.galeri);
        this.clearForm();
    }

    public void create() {
        this.getGaleriDao().insert(this.galeri);
        this.galeri = new Galeri();
    }
    
    public Galeri getGaleri() {
        if (this.galeri == null) {
            this.clearForm();
        }
        return galeri;
    }

    public void setGaleri(Galeri galeri) {
        this.galeri = galeri;
    }

    public GaleriDAO getGaleriDao() {
        if (this.GaleriDao == null) {
            this.GaleriDao = new GaleriDAO();
        }
        return GaleriDao;
    }

    public void setGaleriDao(GaleriDAO GaleriDao) {
        this.GaleriDao = GaleriDao;
    }

    public List<Galeri> getListeGaleri() {
        this.ListeGaleri = this.getGaleriDao().findAll();
        return ListeGaleri;
    }

    public void setListeGaleri(List<Galeri> ListeGaleri) {
        this.ListeGaleri = ListeGaleri;
    }

   

  
    
    
    
}
