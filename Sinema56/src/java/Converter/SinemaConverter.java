/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Converter;

import DAO.SinemaDAO;
import Entity.Sinema;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Kutlu
 */
@FacesConverter(value = "sinemaConverter")
public class SinemaConverter implements Converter{
   
    
    private SinemaDAO sinemaDao;

      @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        return this.getSinemaDao().find(Long.valueOf(value));
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        Sinema sinema = (Sinema) value ;
        return sinema.getIdsinema().toString();
    }
    
    
    
    public SinemaDAO getSinemaDao() {        
        if(this.sinemaDao == null)
            this.sinemaDao = new SinemaDAO();
        return sinemaDao;
    }
    
    
    
}
