/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import DAO.SeansDAO;
import Entity.Seans;
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
public class SeansController implements Serializable{
    
    private Seans seans;
    private SeansDAO SeansDao;
    private List<Seans> ListeSeans;

    
    public void clearForm(){
        this.seans = new Seans();
    }
    public void updateForm(Seans seans) {
        this.seans = seans;       
    }
    
    public void update() {
        this.getSeansDao().update(this.seans);
        this.seans = new Seans();
    }
    public void deleteConfirm(Seans seans){
        this.seans = seans ;
    }

    public void delete() {
        this.getSeansDao().delete(this.seans);
        this.clearForm();
    }

    public void create() {
        this.getSeansDao().insert(this.seans);
        this.seans = new Seans();
    }
    
    public Seans getSeans() {
        if (this.seans == null) {
            this.clearForm();
        }
        return seans;
    }

    public void setSeans(Seans seans) {
        this.seans = seans;
    }

    public SeansDAO getSeansDao() {
        if (this.SeansDao == null) {
            this.SeansDao = new SeansDAO();
        }
        return SeansDao;
    }

    public void setSeansDao(SeansDAO SeansDao) {
        this.SeansDao = SeansDao;
    }

    public List<Seans> getListeSeans() {
         this.ListeSeans = this.getSeansDao().findAll();
        return ListeSeans;
    }

    public void setListeSeans(List<Seans> ListeSeans) {
        this.ListeSeans = ListeSeans;
    }
    
    
    
    
}
