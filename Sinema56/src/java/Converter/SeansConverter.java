/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Converter;

import DAO.SeansDAO;
import Entity.Seans;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Kutlu
 */
@FacesConverter(value = "seansConverter")
public class SeansConverter implements Converter{
    private SeansDAO seansDao; 

    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        return this.getSeansDao().find(Long.valueOf(value));
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        Seans seans = (Seans) value ;
        return seans.getIdseans().toString();
    }
    
    public SeansDAO getSeansDao() {
        if(this.seansDao == null)
            this.seansDao = new SeansDAO();
        return seansDao;
    }
    
    
    
    
    
    
}
