/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;


import DAO.UserDAO;
import Entity.User;

import Utility.SessionUtility;
import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import javax.servlet.http.HttpSession;

/**
 *
 * @author ms
 */
@ManagedBean
@SessionScoped
public class LoginController implements Serializable {

    private User user;
    private UserDAO userDao;

    public String Login() {

        User user2 = this.getUserDao().login(this.user);
        if (user2 != null) {
            HttpSession session = SessionUtility.getSession();
            session.setAttribute("user", user2);
            return "/admin/index?faces-redirect=true";

        } else {
            return "/index?faces-redirect=true";

        }

    }

    public String Logout() {

        FacesMessage msg = new FacesMessage("Logout success!", "INFO MSG");
        msg.setSeverity(FacesMessage.SEVERITY_INFO);
        FacesContext.getCurrentInstance().addMessage(null, msg);
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "/index?faces-redirect=true";
    }
    
    
    
    
    
    public String startPage() {
        return "/frontend/index.xhtml";
    }

    
    
    
    public User getUser() {
        if (this.user == null) {
            this.user = new User();
        }
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public UserDAO getUserDao() {
         if (this.userDao == null) {
            this.userDao = new UserDAO();
        }     
        return userDao;
    }

    public void setUserDao(UserDAO userDao) {
        this.userDao = userDao;
    }

    
    
    
    

}
