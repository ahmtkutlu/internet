/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import DAO.SalonDAO;
import DAO.SinemaDAO;
import Entity.Salon;
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
public class SalonController implements Serializable{
    
    private Salon salon;
    private SalonDAO SalonDao;
    private List<Salon> ListeSalon;
    
    
    
    //yeni
    private List<Sinema> ListSinama ;
    private SinemaDAO sinamaDAO ;
    
    
    
    
    
     private int page = 1;
    private int listItemCount = 3;
    
    
    public int count (){
        return this.getSalonDao().record();
    }
    
    public boolean hasPrev() {
        return page > 1;
    }

    public boolean hasNext() {
        int sum ;
        sum = this.getSalonDao().record();
        if ((this.page * this.listItemCount) >= sum) {
            return false;
        } else {
            return true;
        }
    }
    
      public void previous() {
        this.setPage(this.page - 1);
    }

    public void next() {
        this.setPage(this.page + 1);
    }
    
    
    //back start ve diğer fonksiyonların redirecti eklenecek    

    
       public String start() {
        this.salon = new Salon() ;
        return "/admin/index?faces-redirect=true";
    }
    
     public String back() {
        this.salon = new Salon();
        return "/admin/salon/list?faces-redirect=true ";
    }
    
    
    public void clearForm(){
        this.salon = new Salon();
    }
    public String updateForm(Salon salon) {
        this.salon = salon;   
        return "/admin/salon/update?faces-redirect=true ";
    }
     public String createForm() {
        this.salon = new Salon() ;
        return "/admin/salon/create?faces-redirect=true ";
    }
    
    public String update() {
        this.getSalonDao().update(this.salon);
        this.salon = new Salon();
         return "/admin/salon/list?faces-redirect=true ";
    }
    public void deleteConfirm(Salon salon){
        this.salon = salon ;
    }

    public String delete(Salon salon) {
        this.getSalonDao().delete(salon);
        this.clearForm();
        return "/admin/salon/list?faces-redirect=true ";
    }

    public String create() {
        this.getSalonDao().insert(this.salon);
        this.salon = new Salon();
        return "/admin/salon/list?faces-redirect=true ";
    }  
    
//     public String create(Salon salon) {
//        if(salon==null){
//        return "/admin/index?faces-redirect=true ";
//        }else{
//         this.getSalonDao().insert(salon);
//        this.salon = new Salon();
//        return "/admin/salon/list?faces-redirect=true ";
//        }       
//    }
    
    
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
        this.ListeSalon = this.getSalonDao().findAll(page,listItemCount);
        return ListeSalon;
    }

    public void setListeSalon(List<Salon> ListeSalon) {
        this.ListeSalon = ListeSalon;
    }

    
    //yeni
    public List<Sinema> getListSinama() {
        this.ListSinama = this.getSinamaDAO().findAll();
        return ListSinama;
    }

    public void setListSinama(List<Sinema> ListSinama) {
        this.ListSinama = ListSinama;
    }

    public SinemaDAO getSinamaDAO() {
        if (this.sinamaDAO == null)
            this.sinamaDAO = new SinemaDAO();
        return sinamaDAO;
    }

    public void setSinamaDAO(SinemaDAO sinamaDAO) {
        this.sinamaDAO = sinamaDAO;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getListItemCount() {
        return listItemCount;
    }

    public void setListItemCount(int listItemCount) {
        this.listItemCount = listItemCount;
    }
    
    
    
    
    
}
