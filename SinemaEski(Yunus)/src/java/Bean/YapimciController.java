/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import DAO.YapimciDAO;
import Entity.Yapimci;
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
public class YapimciController implements Serializable{
 
    private Yapimci yapimci;
    private YapimciDAO YapimciDao;
    private List<Yapimci> ListeYapimci;        
    
    public void clearForm(){
        this.yapimci = new Yapimci();
    }
    public void updateForm(Yapimci yapimci) {
        this.yapimci = yapimci;       
    }
    
    public void update() {
        this.getYapimciDao().update(this.yapimci);
        this.yapimci = new Yapimci();
    }
    public void deleteConfirm(Yapimci yapimci){
        this.yapimci = yapimci ;
    }

    public void delete() {
        this.getYapimciDao().delete(this.yapimci);
        this.clearForm();
    }

    public void create() {
        this.getYapimciDao().insert(this.yapimci);
        this.yapimci = new Yapimci();
    }

    public Yapimci getYapimci() {
            if (this.yapimci == null) {
            this.clearForm();
        }
        return yapimci;
    }

    public void setYapimci(Yapimci yapimci) {
        this.yapimci = yapimci;
    }

    public YapimciDAO getYapimciDao() {
        if (this.YapimciDao == null) {
          this.YapimciDao = new YapimciDAO();
        }
        return YapimciDao;
    }

    public void setYapimciDao(YapimciDAO YapimciDao) {
        this.YapimciDao = YapimciDao;
    }

    public List<Yapimci> getListeYapimci() {
        this.ListeYapimci = this.getYapimciDao().findAll();
        return ListeYapimci;
    }

    public void setListeYapimci(List<Yapimci> ListeYapimci) {
        this.ListeYapimci = ListeYapimci;
    }
    
    
    
    
    
}
