/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import DAO.FilmDAO;
import DAO.UserDAO;
import DAO.YorumDAO;
import Entity.Film;
import Entity.User;
import Entity.Yorum;
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
public class YorumController implements Serializable{
    
    private Yorum yorum;
    private YorumDAO YorumDao;
    private List<Yorum> ListeYorum;
 
    
    //yeni
     private List<User> ListUser ;
     private UserDAO userDAO ;
    
     private List<Film> ListFilm ;
     private FilmDAO filmDAO ;
     
     
     
      private int page = 1;
    private int listItemCount = 3;
    
    
    public int count (){
        return this.getYorumDao().record();
    }
    
    public boolean hasPrev() {
        return page > 1;
    }

    public boolean hasNext() {
        int sum ;
        sum = this.getYorumDao().record();
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
        this.yorum = new Yorum() ;
        return "/admin/index?faces-redirect=true";
    }
    
     public String back() {
        this.yorum = new Yorum();
        return "/admin/yorum/list?faces-redirect=true ";
    }
     
    
    
     public void clearForm(){
        this.yorum = new Yorum();
    }
    public String updateForm(Yorum yorum) {
        this.yorum = yorum; 
        return "/admin/yorum/update?faces-redirect=true ";
    }
     public String createForm() {
        this.yorum = new Yorum() ;
        return "/admin/yorum/create?faces-redirect=true ";
    }
    
    public String update() {
        this.getYorumDao().update(this.yorum);
        this.yorum = new Yorum();
        return "/admin/yorum/list?faces-redirect=true ";
    }
    public void deleteConfirm(Yorum yorum){
        this.yorum = yorum ;
    }

    public String delete(Yorum yorum) {
        this.getYorumDao().delete(yorum);
        this.clearForm();
        return "/admin/yorum/list?faces-redirect=true ";
    }

    public String create() {
        this.getYorumDao().insert(this.yorum);
        this.yorum = new Yorum();
        return "/admin/yorum/list?faces-redirect=true ";
    }
    
     
    
    public Yorum getYorum() {
        if (this.yorum == null) {
            this.clearForm();
        }
        return yorum;
    }

    public void setYorum(Yorum yorum) {
        this.yorum = yorum;
    }

    public YorumDAO getYorumDao() {
        if (this.YorumDao == null) {
            this.YorumDao = new YorumDAO();
        }
        return YorumDao;
    }

    public void setYorumDao(YorumDAO YorumDao) {
        this.YorumDao = YorumDao;
    }

    public List<Yorum> getListeYorum() {
        this.ListeYorum = this.getYorumDao().findAll();
        return ListeYorum;
    }

    public void setListeYorum(List<Yorum> ListeYorum) {
        this.ListeYorum = ListeYorum;
    }
    
    
    
    //yeni

    public List<User> getListUser() {
         this.ListUser=this.getUserDAO().findAll();
        return ListUser;
    }

    public void setListUser(List<User> ListUser) {
        this.ListUser = ListUser;
    }

    public UserDAO getUserDAO() {
        if (this.userDAO == null)
            this.userDAO = new UserDAO();
        return userDAO;
    }

    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public List<Film> getListFilm() {
         this.ListFilm=this.getFilmDAO().findAll();
        return ListFilm;
    }

    public void setListFilm(List<Film> ListFilm) {
        this.ListFilm = ListFilm;
    }

    public FilmDAO getFilmDAO() {
        if (this.filmDAO == null)
            this.filmDAO = new FilmDAO();
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
