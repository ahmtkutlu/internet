/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import DAO.DuyuruDAO;
import Entity.Duyuru;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Kutlu
 */
@ManagedBean
@SessionScoped
public class DuyuruController implements Serializable{
    private DuyuruDAO duyuruDao;
    private Duyuru duyuru;
    private List<Duyuru> ListeDuyuru;
    
    
    public void clearForm(){
        this.duyuru = new Duyuru();
    }
    public void updateForm(Duyuru duyuru) {
        this.duyuru = duyuru;       
    }
    
    public void update() {
        this.getDuyuruDao().update(this.duyuru);
        this.duyuru = new Duyuru();
    }
    public void deleteConfirm(Duyuru duyuru){
        this.duyuru = duyuru ;
    }

    public void delete() {
        this.getDuyuruDao().delete(this.duyuru);
        this.clearForm();
    }

    public void create() {
        this.getDuyuruDao().insert(this.duyuru);
        this.duyuru = new Duyuru();
    }
 
    
    
    
    
    
    
    public DuyuruDAO getDuyuruDao() {
            if (this.duyuruDao == null) {
            this.duyuruDao = new DuyuruDAO();
        }
        return duyuruDao;
    }

    public void setDuyuruDao(DuyuruDAO duyuruDao) {
        this.duyuruDao = duyuruDao;
    }

    public Duyuru getDuyuru() {
          if (this.duyuru == null) {
            this.clearForm();
        }
        return duyuru;
    }

    public void setDuyuru(Duyuru duyuru) {
        this.duyuru = duyuru;
    }

    public List<Duyuru> getListeDuyuru() {
        this.ListeDuyuru = this.getDuyuruDao().findAll();
        return ListeDuyuru;
    }

    public void setListeDuyuru(List<Duyuru> ListeDuyuru) {
        this.ListeDuyuru = ListeDuyuru;
    }
    
    
}
