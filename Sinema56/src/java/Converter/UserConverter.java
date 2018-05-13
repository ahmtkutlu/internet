/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Converter;

import DAO.UserDAO;
import Entity.User;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Kutlu
 */
@FacesConverter(value = "userConverter")
public class UserConverter implements Converter{
  
    private UserDAO UserDao;

    
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        return this.getUserDao().find(Long.valueOf(value));
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        User user = (User) value ;
        return user.getIduser().toString();
    }
    
    
    
    public UserDAO getUserDao() {
        if(this.UserDao==null)
            this.UserDao=new UserDAO();
        return UserDao;
    }
    
    
}
