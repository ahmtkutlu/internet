/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import DAO.FilmDAO;
import DAO.YapimciDAO;
import DAO.YonetmenDAO;
import Entity.Film;
import Entity.Yapimci;
import Entity.Yonetmen;
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
public class FilmController implements Serializable{
    private Film film;
    private FilmDAO FilmDao;
    private List<Film> ListeFilm;
    
    private List<Yonetmen> ListYonetmen ;
    private YonetmenDAO yonetmenDAO;
    
    private List<Yapimci> ListYapimci ;
    private YapimciDAO yapimciDAO;
    
    
    
    
    private int page = 1;
    private int listItemCount = 3;
    
    
    public int count (){
        return this.getFilmDao().record();
    }
    
    public boolean hasPrev() {
        return page > 1;
    }

    public boolean hasNext() {
        int sum ;
        sum = this.getFilmDao().record();
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
        this.film = new Film() ;
        return "/admin/index?faces-redirect=true";
    }
    
     public String back() {
        this.film = new Film();
        return "/admin/film/list?faces-redirect=true ";
    }
    
        
            
    public void clearForm(){
        this.film = new Film();
    }
    public String updateForm(Film film) {
        this.film = film;  
        return "/admin/film/update?faces-redirect=true ";
    }
    public String createForm() {
        this.film = new Film() ;
        return "/admin/film/create?faces-redirect=true ";
    }        
    
    public String update() {
        this.getFilmDao().update(this.film);
        this.film = new Film();
        return "/admin/film/list?faces-redirect=true ";
    }
    public void deleteConfirm(Film film){
        this.film = film ;
    }

    public String delete(Film film) {
        this.getFilmDao().delete(film);
        this.clearForm();
        return "/admin/film/list?faces-redirect=true ";
    }

    public String create() {
        this.getFilmDao().insert(this.film);
        this.film = new Film();
         return "/admin/film/list?faces-redirect=true ";
    }
    
    
//     public String create(Film fim) {
//        if(film==null){
//        return "/admin/index?faces-redirect=true ";
//        }else{
//        this.getFilmDao().insert(film);
//        this.film = new Film();
//        return "/admin/film/list?faces-redirect=true ";
//        }       
//    }
    
            

    public Film getFilm() {
        if (this.film == null) {
            this.clearForm();
        }
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public FilmDAO getFilmDao() {
        if (this.FilmDao == null) {
            this.FilmDao = new FilmDAO();
        }
        return FilmDao;
    }

    public void setFilmDao(FilmDAO FilmDao) {
        this.FilmDao = FilmDao;
    }

    public List<Film> getListeFilm() {
        this.ListeFilm = this.getFilmDao().findAll(page,listItemCount);
        return ListeFilm;
    }

    public void setListeFilm(List<Film> ListeFilm) {
        this.ListeFilm = ListeFilm;
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

    public List<Yonetmen> getListYonetmen() {
        this.ListYonetmen=this.getYonetmenDAO().findAll();
        return ListYonetmen;
    }

    public void setListYonetmen(List<Yonetmen> ListYonetmen) {
        this.ListYonetmen = ListYonetmen;
    }

    public YonetmenDAO getYonetmenDAO() {
        if(this.yonetmenDAO==null)
            this.yonetmenDAO=new YonetmenDAO();
        return yonetmenDAO;
    }

    public void setYonetmenDAO(YonetmenDAO yonetmenDAO) {
        this.yonetmenDAO = yonetmenDAO;
    }

    public List<Yapimci> getListYapimci() {
        this.ListYapimci=this.getYapimciDAO().findAll();
        return ListYapimci;
    }

    public void setListYapimci(List<Yapimci> ListYapimci) {
        this.ListYapimci = ListYapimci;
    }

    public YapimciDAO getYapimciDAO() {
        if(this.yapimciDAO==null)
            this.yapimciDAO=new YapimciDAO();
        return yapimciDAO;
    }

    public void setYapimciDAO(YapimciDAO yapimciDAO) {
        this.yapimciDAO = yapimciDAO;
    }
    
    
    
    
    
    
    
}
