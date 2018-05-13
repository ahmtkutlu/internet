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
    
     private int page = 1;
    private int listItemCount = 3;
    
    public int count (){
        return this.getUserDao().record();
    }
    
    public boolean hasPrev() {
        return page > 1;
    }

    public boolean hasNext() {
        int sum ;
        sum = this.getUserDao().record();
        if ((this.page * this.listItemCount) >= sum) {
            return false;
        } else {
            return true;
        }
    }
    
      public void previous() {
        this.setPage(this.page - 1);
    }

    public void next() {
        this.setPage(this.page + 1);
    }
    
    
    //back start ve diğer fonksiyonların redirecti eklenecek  
    
       public String start() {
        this.user = new User() ;
        return "/admin/index?faces-redirect=true";
    }
    
     public String back() {
        this.user = new User();
        return "/admin/user/list?faces-redirect=true ";
    }
    
    
    
    
    
      public void clearForm(){
        this.user = new User();
    }
    public String updateForm(User user) {
        this.user = user; 
        return "/admin/user/update?faces-redirect=true ";
    }
     public String createForm() {
        this.user = new User() ;
        return "/admin/user/create?faces-redirect=true ";
    }
    
    public String update() {
        this.getUserDao().update(this.user);
        this.user = new User();
        return "/admin/user/list?faces-redirect=true ";
    }
    public void deleteConfirm(User user){
        this.user = user ;
    }

    public String delete(User user) {
        this.getUserDao().delete(user);
        this.clearForm();
        return "/admin/user/list?faces-redirect=true ";
    }

    public String create() {
        this.getUserDao().insert(this.user);
        this.user = new User();
        return "/admin/user/list?faces-redirect=true ";
    }
    
//     public String create(User user) {
//        if(user==null){
//        return "/admin/index?faces-redirect=true ";
//        }else{
//         this.getUserDao().insert(user);
//        this.user = new User();
//        return "/admin/user/list?faces-redirect=true ";
//        }       
//    }
    

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
        this.ListeUser = this.getUserDao().findAll(page,listItemCount);
        return ListeUser;
    }

    public void setListeUser(List<User> ListeUser) {
        this.ListeUser = ListeUser;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getListItemCount() {
        return listItemCount;
    }

    public void setListItemCount(int listItemCount) {
        this.listItemCount = listItemCount;
    }
    
    
    
    
    
    
    
}
