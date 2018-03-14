
package BEAN;

import DAO.userDAO;
import Entity.user;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name="user")
@SessionScoped
public class userController {
    
    private user user=null;
    private ArrayList<user> userlist=null;
    private userDAO userDAO=null;
    
    public user getUser(){
    if(this.user==null)
        this.user=new user();
    return user;
    }
    
    public void setUser(user k){
        this.user=user;
    }
   
    public ArrayList<user> getlist(){
    if(this.userlist==null)
        this.userlist=new ArrayList();
        userlist=this.getUserDAO().list();
      return this.userlist;
    }
    
    public void setlist(ArrayList<user> list){
        this.userlist=list;
    }
            
    public userDAO getUserDAO(){
    if(this.userDAO==null)
        this.userDAO=new userDAO();
     return userDAO;
    }
    
    public void setUserDAO(userDAO kDAO){
        this.userDAO=kDAO;
    }
    
      public user getUserId(int id){
       return this.getUserDAO().getUser(id);
    }
    
    public String delete(int id){
        this.getUserDAO().delete(id);
        this.userlist=this.getUserDAO().list();
        return "/pages/adminstation/user/list";
    }
    
  
    public String update(int id){
       this.getUserDAO().update(this.user);
       this.userlist=this.getUserDAO().list();
       return "/pages/adminstation/user/list";
    }
    
    
    public String create(){
        this.getUserDAO().create(this.user);
        this.userlist=this.getUserDAO().list();
        this.user=null;
        return "/tamam";
    }
       
}