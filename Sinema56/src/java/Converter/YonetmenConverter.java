/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Converter;

import DAO.YonetmenDAO;
import Entity.Yonetmen;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Kutlu
 */
@FacesConverter(value = "yonetmenConverter")
public class YonetmenConverter implements Converter{
    
    private YonetmenDAO YonetmenDao;
        
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        return this.getYonetmenDao().find(Long.valueOf(value));
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        Yonetmen yonetmen = (Yonetmen) value ;
        return yonetmen.getIdyonetmen().toString();
    }
            
    public YonetmenDAO getYonetmenDao() {
        if(this.YonetmenDao==null)
            this.YonetmenDao=new YonetmenDAO();
        return YonetmenDao;
    }
    
    
    
}
