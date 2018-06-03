/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import DAO.SalonDAO;
import Entity.Salon;
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
public class SalonController implements Serializable{
    
    private Salon salon;
    private SalonDAO SalonDao;
    private List<Salon> ListeSalon;
    
    
    public void clearForm(){
        this.salon = new Salon();
    }
    public void updateForm(Salon salon) {
        this.salon = salon;       
    }
    
    public void update() {
        this.getSalonDao().update(this.salon);
        this.salon = new Salon();
    }
    public void deleteConfirm(Salon salon){
        this.salon = salon ;
    }

    public void delete() {
        this.getSalonDao().delete(this.salon);
        this.clearForm();
    }

    public void create() {
        this.getSalonDao().insert(this.salon);
        this.salon = new Salon();
    }  
    
    
    public Salon getSalon() {
       if (this.salon == null) {
            this.clearForm();
        }
        return salon;
    }

    public void setSalon(Salon salon) {
        this.salon = salon;
    }

    public SalonDAO getSalonDao() {
         if (this.SalonDao == null) {
            this.SalonDao = new SalonDAO();
        }
        return SalonDao;
    }

    public void setSalonDao(SalonDAO SalonDao) {
        this.SalonDao = SalonDao;
    }

    public List<Salon> getListeSalon() {
        this.ListeSalon = this.getSalonDao().findAll();
        return ListeSalon;
    }

    public void setListeSalon(List<Salon> ListeSalon) {
        this.ListeSalon = ListeSalon;
    }
    
}
