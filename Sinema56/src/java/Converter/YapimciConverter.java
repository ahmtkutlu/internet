/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Converter;

import DAO.YapimciDAO;
import Entity.Yapimci;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Kutlu
 */
@FacesConverter(value = "yapimciConverter")
public class YapimciConverter implements Converter{
    private YapimciDAO YapimciDao;

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        return this.getYapimciDao().find(Long.valueOf(value));
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        Yapimci yapimci = (Yapimci) value ;
        return yapimci.getIdyapimci().toString();
    }
    
    
    
    
    public YapimciDAO getYapimciDao() {
        if(this.YapimciDao==null)
            this.YapimciDao=new YapimciDAO();
        return YapimciDao;
    }
    
    
    
}
