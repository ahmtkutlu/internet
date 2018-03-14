
package BEAN;

import DAO.yorumDAO;
import Entity.yorum;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name="yorum")
@SessionScoped
public class yorumController {
    
    private yorum yorum=null;
    private ArrayList<yorum> yorumlist=null;
    private yorumDAO yorumDAO=null;
    
    public yorum getYorum(){
    if(this.yorum==null)
        this.yorum=new yorum();
    return yorum;
    }
    
    public void setK(yorum yorum){
        this.yorum=yorum;
    }
   
    public ArrayList<yorum> getlist(){
    if(this.yorumlist==null)
        this.yorumlist=new ArrayList();
        yorumlist=this.yorumDAO.list();
      return this.yorumlist;
    }
    
    public void setlist(ArrayList<yorum> list){
        this.yorumlist=list;
    }
            
    public yorumDAO getYorumDAO(){
    if(this.yorumDAO==null)
        this.yorumDAO=new yorumDAO();
     return yorumDAO;
    }
    
    public void setkDAO(yorumDAO yorumDAO){
        this.yorumDAO=yorumDAO;
    }
    
      public yorum getYorumId(int id){
       return this.getYorumDAO().getYorum(id);
    }
    
    public String delete(int id){
        this.getYorumDAO().delete(id);
        this.yorumlist=this.getYorumDAO().list();
        return "/pages/adminstation/yorum/list";
    }
    
  
    public String update(int id){
       this.getYorumDAO().update(this.yorum);
       this.yorumlist=this.getYorumDAO().list();
       return "/pages/adminstation/yorum/list";
    }
    
    
    public String create(){
        this.getYorumDAO().create(this.yorum);
        this.yorumlist=this.getYorumDAO().list();
        this.yorum=null;
        return "/tamam";
    }
       
}