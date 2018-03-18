/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import Dao.FilmDao;
import Entity.Film;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class FilmController implements Serializable{
    
    private Film film;
    private List<Film> filmList;
    private FilmDao filmDao;
     

    public Film getFlim() {
        if(this.film==null)
            this.film=new Film();
        return film;
    }

    public void setFlim(Film film) {
        this.film = film;
    }

    

    public List<Film> getFilmList() {
          this.filmList=this.getFilmDao().findAll();
        return filmList;
    }

    public void setFilmList(List<Film> filmList) {
        this.filmList = filmList;
    }
    
    



    public FilmDao getFilmDao() {
        if(this.filmDao==null)
            this.filmDao=new FilmDao();
        return filmDao;
    }

    public void setFilmDao(FilmDao filmDao) {
        this.filmDao = filmDao;
    }
    
}
