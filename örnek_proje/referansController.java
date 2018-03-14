
package BEAN;

import DAO.referansDAO;
import Entity.referans;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name="referans")
@SessionScoped
public class referansController {
    
    private referans referans=null;
    private ArrayList<referans> referanslist=null;
    private referansDAO referansDAO=null;
    
    public referans getReferans(){
    if(this.referans==null)
        this.referans=new referans();
    return referans;
    }
    
    public void setK(referans referans){
        this.referans=referans;
    }
   
    public ArrayList<referans> getlist(){
    if(this.referanslist==null)
        this.referanslist=new ArrayList();
        referanslist=this.referansDAO.list();
      return this.referanslist;
    }
    
    public void setlist(ArrayList<referans> list){
        this.referanslist=list;
    }
            
    public referansDAO getReferansDAO(){
    if(this.referansDAO==null)
        this.referansDAO=new referansDAO();
     return referansDAO;
    }
    
    public void setkDAO(referansDAO referansDAO){
        this.referansDAO=referansDAO;
    }
    
      public referans getReferansId(int id){
       return this.getReferansDAO().getReferans(id);
    }
    
    public String delete(int id){
        this.getReferansDAO().delete(id);
        this.referanslist=this.getReferansDAO().list();
        return "/pages/adminstation/referans/list";
    }
    
  
    public String update(int id){
       this.getReferansDAO().update(this.referans);
       this.referanslist=this.getReferansDAO().list();
       return "/pages/adminstation/referans/list";
    }
    
    
    public String create(){
        this.getReferansDAO().create(this.referans);
        this.referanslist=this.getReferansDAO().list();
        this.referans=null;
        return "/tamam";
    }
       
}