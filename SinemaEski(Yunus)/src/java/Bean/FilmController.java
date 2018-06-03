/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import DAO.FilmDAO;
import Entity.Film;
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
    
    
    
    
    
    
    public void clearForm(){
        this.film = new Film();
    }
    public void updateForm(Film film) {
        this.film = film;       
    }
    
    public void update() {
        this.getFilmDao().update(this.film);
        this.film = new Film();
    }
    public void deleteConfirm(Film film){
        this.film = film ;
    }

    public void delete() {
        this.getFilmDao().delete(this.film);
        this.clearForm();
    }

    public void create() {
        this.getFilmDao().insert(this.film);
        this.film = new Film();
    }
    
    
    

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
        this.ListeFilm = this.getFilmDao().findAll();
        return ListeFilm;
    }

    public void setListeFilm(List<Film> ListeFilm) {
        this.ListeFilm = ListeFilm;
    }
    
    
}
