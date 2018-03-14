
package BEAN;

import DAO.is_verenDAO;
import Entity.is_veren;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name="is_veren")
@SessionScoped
public class is_verenController {
    
    private is_veren is_veren=null;
    private ArrayList<is_veren> is_verenlist=null;
    private is_verenDAO is_verenDAO=null;
    
    
    public is_veren getIs_veren(){
    if(this.is_veren==null)
        this.is_veren=new is_veren();
    return is_veren;
    }
    
    public void setK(is_veren k){
        this.is_veren=is_veren;
    }
   
    public ArrayList<is_veren> getlist(){
    if(this.is_verenlist==null)
        this.is_verenlist=new ArrayList();
        is_verenlist=this.getIs_verenDAO().list();
      return this.is_verenlist;
    }
    
    public void setlist(ArrayList<is_veren> list){
        this.is_verenlist=list;
    }
            
    public is_verenDAO getIs_verenDAO(){
    if(this.is_verenDAO==null)
        this.is_verenDAO=new is_verenDAO();
     return is_verenDAO;
    }
    
    public void setIs_verenDAO(is_verenDAO is_verenDAO){
        this.is_verenDAO=is_verenDAO;
    }
    
      public is_veren getIs_verenId(int id){
       return this.getIs_verenDAO().getIsVeren(id);
    }
    
    public String delete(int id){
        this.getIs_verenDAO().delete(id);
        this.is_verenlist=this.getIs_verenDAO().list();
        return "/pages/adminstation/is_veren/list";
    }
    
  
    public String update(int id){
       this.getIs_verenDAO().update(this.is_veren);
       this.is_verenlist=this.getIs_verenDAO().list();
       return "/pages/adminstation/is_veren/list";
    }
    
    
    public String create(){
        this.getIs_verenDAO().create(this.is_veren);
        this.is_verenlist=this.getIs_verenDAO().list();
        this.is_veren=null;
        return "/tamam";
    }
       
}