/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import DAO.OyuncuDAO;
import Entity.Oyuncu;
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

public class OyuncuController implements Serializable{
  
    private Oyuncu oyuncu;
    private OyuncuDAO OyuncuDao;
    private List<Oyuncu> ListeOyuncu;

    
    
    
     public void clearForm(){
        this.oyuncu = new Oyuncu();
    }
    public void updateForm(Oyuncu oyuncu) {
        this.oyuncu = oyuncu;       
    }
    
    public void update() {
        this.getOyuncuDao().update(this.oyuncu);
        this.oyuncu = new Oyuncu();
    }
    public void deleteConfirm(Oyuncu oyuncu){
        this.oyuncu = oyuncu ;
    }

    public void delete() {
        this.getOyuncuDao().delete(this.oyuncu);
        this.clearForm();
    }

    public void create() {
        this.getOyuncuDao().insert(this.oyuncu);
        this.oyuncu = new Oyuncu();
    }   
    
    public Oyuncu getOyuncu() {
          if (this.oyuncu == null) {
            this.clearForm();
        }
        return oyuncu;
    }

    public void setOyuncu(Oyuncu oyuncu) {
        this.oyuncu = oyuncu;
    }

    public OyuncuDAO getOyuncuDao() {
          if (this.OyuncuDao == null) {
            this.OyuncuDao = new OyuncuDAO();
        }
        return OyuncuDao;
    }

    public void setOyuncuDao(OyuncuDAO OyuncuDao) {
        this.OyuncuDao = OyuncuDao;
    }

    public List<Oyuncu> getListeOyuncu() {
        this.ListeOyuncu = this.getOyuncuDao().findAll();
        return ListeOyuncu;
    }

    public void setListeOyuncu(List<Oyuncu> ListeOyuncu) {
        this.ListeOyuncu = ListeOyuncu;
    }
    
    
    
}
