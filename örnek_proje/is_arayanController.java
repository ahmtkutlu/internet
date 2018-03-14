
package BEAN;

import DAO.is_arayanDAO;
import Entity.is_arayan;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name="is_arayan")
@SessionScoped
public class is_arayanController {
    
    private is_arayan is_arayan=null;
    private ArrayList<is_arayan> is_arayanlist=null;
    private is_arayanDAO is_arayanDAO=null;
       
    public is_arayan getIs_arayan(){
    if(this.is_arayan==null)
        this.is_arayan=new is_arayan();
    return is_arayan;
    }
    
    public void setK(is_arayan k){
        this.is_arayan=is_arayan;
    }
   
    public ArrayList<is_arayan> getlist(){
    if(this.is_arayanlist==null)
        this.is_arayanlist=new ArrayList();
        is_arayanlist=this.getIs_arayanDAO().list();
      return this.is_arayanlist;
    }
    
    public void setlist(ArrayList<is_arayan> list){
        this.is_arayanlist=list;
    }
            
    public is_arayanDAO getIs_arayanDAO(){
    if(this.is_arayanDAO==null)
        this.is_arayanDAO=new is_arayanDAO();
     return is_arayanDAO;
    }
    
    public void setIs_arayanDAO(is_arayanDAO is_arayanDAO){
        this.is_arayanDAO=is_arayanDAO;
    }
    
      public is_arayan getIs_arayanId(int id){
       return this.getIs_arayanDAO().getIsArayan(id);
    }
    
    public String delete(int id){
        this.getIs_arayanDAO().delete(id);
        this.is_arayanlist=this.getIs_arayanDAO().list();
        return "/pages/adminstation/is_arayan/list";
    }
    
  
    public String update(int id){
       this.getIs_arayanDAO().update(this.is_arayan);
       this.is_arayanlist=this.getIs_arayanDAO().list();
       return "/pages/adminstation/is_arayan/list";
    }
    
    public String create(){
        this.getIs_arayanDAO().create(this.is_arayan);
        this.is_arayanlist=this.getIs_arayanDAO().list();
        this.is_arayan=null;
        return "/tamam";
    }
       
}