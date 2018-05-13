/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import DAO.FilmDAO;
import DAO.SalonDAO;
import DAO.SeansDAO;
import Entity.Film;
import Entity.Salon;
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
    

//yeni  
    private List<Salon> ListSalon ;
    private SalonDAO salonDAO ;
  
    private List<Film> ListFilm ;
    private FilmDAO filmDAO ;
    
    
     private int page = 1;
    private int listItemCount = 3;
    
    
    public int count (){
        return this.getSeansDao().record();
    }
    
    public boolean hasPrev() {
        return page > 1;
    }

    public boolean hasNext() {
        int sum ;
        sum = this.getSeansDao().record();
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
        this.seans = new Seans() ;
        return "/admin/index?faces-redirect=true";
    }
    
     public String back() {
        this.seans = new Seans();
        return "/admin/seans/list?faces-redirect=true ";
    }
    
    
    
    public void clearForm(){
        this.seans = new Seans();
    }
    public String updateForm(Seans seans) {
        this.seans = seans;     
        return "/admin/seans/update?faces-redirect=true ";
    }
       public String createForm() {
        this.seans = new Seans() ;
        return "/admin/seans/create?faces-redirect=true ";
    }
    
    public String update() {
        this.getSeansDao().update(this.seans);
        this.seans = new Seans();
        return "/admin/seans/list?faces-redirect=true ";
    }
    public void deleteConfirm(Seans seans){
        this.seans = seans ;
    }

    public String delete(Seans seans) {
        this.getSeansDao().delete(seans);
        this.clearForm();
        return "/admin/seans/list?faces-redirect=true ";
    }

    public String create() {
        this.getSeansDao().insert(this.seans);
        this.seans = new Seans();
         return "/admin/seans/list?faces-redirect=true ";
    }
    
//     public String create(Seans seans) {
//        if(seans==null){
//        return "/admin/index?faces-redirect=true ";
//        }else{
//         this.getSeansDao().insert(seans);
//        this.seans = new Seans();
//        return "/admin/seans/list?faces-redirect=true ";
//        }       
//    }
    
    
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

    
    //yeni
    public List<Seans> getListeSeans() {
         this.ListeSeans = this.getSeansDao().findAll(page,listItemCount);
        return ListeSeans;
    }

    public void setListeSeans(List<Seans> ListeSeans) {
        this.ListeSeans = ListeSeans;
    }

    public List<Salon> getListSalon() {
        this.ListSalon=this.getSalonDAO().findAll();
        return ListSalon;
    }

    public void setListSalon(List<Salon> ListSalon) {
        this.ListSalon = ListSalon;
    }

    public SalonDAO getSalonDAO() {
        if(this.salonDAO==null)
            this.salonDAO=new SalonDAO();
        return salonDAO;
    }

    public void setSalonDAO(SalonDAO salonDAO) {
        this.salonDAO = salonDAO;
    }

    public List<Film> getListFilm() {
        this.ListFilm=this.getFilmDAO().findAll();
        return ListFilm;
    }

    public void setListFilm(List<Film> ListFilm) {
        this.ListFilm = ListFilm;
    }

    public FilmDAO getFilmDAO() {
        if(this.filmDAO == null)
            this.filmDAO=new FilmDAO();            
        return filmDAO;
    }

    public void setFilmDAO(FilmDAO filmDAO) {
        this.filmDAO = filmDAO;
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
