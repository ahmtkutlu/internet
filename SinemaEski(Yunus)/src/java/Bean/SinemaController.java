/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import DAO.SinemaDAO;
import Entity.Sinema;
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
public class SinemaController implements Serializable{
    private Sinema sinema;
    private SinemaDAO SinemaDao;
    private List<Sinema> ListeSinema;

    
      public void clearForm(){
        this.sinema = new Sinema();
    }
    public void updateForm(Sinema sinema) {
        this.sinema = sinema;       
    }
    
    public void update() {
        this.getSinemaDao().update(this.sinema);
        this.sinema = new Sinema();
    }
    public void deleteConfirm(Sinema sinema){
        this.sinema = sinema ;
    }

    public void delete() {
        this.getSinemaDao().delete(this.sinema);
        this.clearForm();
    }

    public void create() {
        this.getSinemaDao().insert(this.sinema);
        this.sinema = new Sinema();
    }  
    
    
    

    
    
    public Sinema getSinema() {
          if (this.sinema == null) {
            this.clearForm();
        }
        return sinema;
    }

    public void setSinema(Sinema sinema) {
        this.sinema = sinema;
    }

    public SinemaDAO getSinemaDao() {
        if (this.SinemaDao == null) {
            this.SinemaDao = new SinemaDAO();
        }
        return SinemaDao;
    }

    public void setSinemaDao(SinemaDAO SinemaDao) {
        this.SinemaDao = SinemaDao;
    }

    public List<Sinema> getListeSinema() {
        this.ListeSinema = this.getSinemaDao().findAll();
        return ListeSinema;
    }

    public void setListeSinema(List<Sinema> ListeSinema) {
        this.ListeSinema = ListeSinema;
    }


    
    
    
}

