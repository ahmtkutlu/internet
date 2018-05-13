/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Converter;

import DAO.GaleriDAO;
import Entity.Galeri;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Kutlu
 */
@FacesConverter(value = "galeriConverter")
public class GaleriConverter implements Converter{
    
      private GaleriDAO galeriDao;
      
      @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        return this.getGaleriDao().find(Long.valueOf(value));
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        Galeri galeri = (Galeri) value ;
        return galeri.getIdgaleri().toString();
    }                  
      
      public GaleriDAO getGaleriDao() {
        if(this.galeriDao == null)
            this.galeriDao = new GaleriDAO();
        return galeriDao;
    }
    
}
