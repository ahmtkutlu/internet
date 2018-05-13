/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Converter;

import DAO.SalonDAO;
import Entity.Salon;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Kutlu
 */
@FacesConverter(value = "salonConverter")
public class SalonConverter implements Converter{
    
    private SalonDAO SalonDao;
    
    
     @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        return this.getSalonDao().find(Long.valueOf(value));
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        Salon salon = (Salon) value ;
        return salon.getIdsalon().toString();
    }
    
    
    public SalonDAO getSalonDao() {
        if(this.SalonDao == null)
            this.SalonDao = new SalonDAO();
        return SalonDao;
    }
    
    
    
}
