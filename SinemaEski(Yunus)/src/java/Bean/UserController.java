/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import DAO.UserDAO;
import Entity.User;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Kutlu
 */
@SessionScoped
@ManagedBean
public class UserController implements Serializable{
    
    private User user;
    private UserDAO UserDao;
    private List<User> ListeUser;
    
    
    
      public void clearForm(){
        this.user = new User();
    }
    public void updateForm(User user) {
        this.user = user;       
    }
    
    public void update() {
        this.getUserDao().update(this.user);
        this.user = new User();
    }
    public void deleteConfirm(User user){
        this.user = user ;
    }

    public void delete() {
        this.getUserDao().delete(this.user);
        this.clearForm();
    }

    public void create() {
        this.getUserDao().insert(this.user);
        this.user = new User();
    }
    

    public User getUser() {
          if (this.user == null) {
            this.clearForm();
        }
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public UserDAO getUserDao() {
          if (this.UserDao == null) {
            this.UserDao = new UserDAO();
        }
        return UserDao;
    }

    public void setUserDao(UserDAO UserDao) {
        this.UserDao = UserDao;
    }

    public List<User> getListeUser() {
        this.ListeUser = this.getUserDao().findAll();
        return ListeUser;
    }

    public void setListeUser(List<User> ListeUser) {
        this.ListeUser = ListeUser;
    }
    
    
    
}
