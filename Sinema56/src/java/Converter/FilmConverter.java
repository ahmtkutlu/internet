/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Converter;

import DAO.FilmDAO;
import Entity.Film;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Kutlu
 */
@FacesConverter(value = "filmConverter")
public class FilmConverter implements Converter{
 
    private FilmDAO filmDao;        
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        return this.getFilmDao().find(Long.valueOf(value));
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        Film film = (Film) value ;
        return film.getIdfilmler().toString();
    }
    
    
    

    public FilmDAO getFilmDao() {
        if(this.filmDao == null)
            this.filmDao = new FilmDAO();
        return filmDao;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
