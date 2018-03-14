
package BEAN;

import Entity.cv;
import DAO.cvDAO;
import java.util.ArrayList;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ManagedBean;

@ManagedBean(name="cv")
@SessionScoped
public class cvController {
    
    private cv cv=null;
    private ArrayList<cv> cvlist=null;
    private cvDAO cvDAO=null;
    
    public cv getcv(){
        if(this.cv==null)
            this.cv=new cv();
        return cv;
    }
    
    public void setcv(cv k){
        this.cv=cv;
    }
    
    public ArrayList<cv> getlist(){
        if(this.cvlist==null)
            this.cvlist=new ArrayList();
        return this.cvlist;
    }
    
    
    public void setlist(ArrayList<cv> list){
        this.cvlist=list;
    }
    
    public cvDAO getcvDAO(){
        if(this.cvDAO==null)
            this.cvDAO=new cvDAO();
        return this.cvDAO;
    }
    
    public void setcvDAO(cvDAO cvDAO){
        this.cvDAO=cvDAO;
    }
    
    public cv getcvId(int id){
        return this.getcvDAO().getCv(id);
    }
    
    
    public String delete(int id){
        this.getcvDAO().delete(id);
        this.cvlist=this.getcvDAO().list();
        return "/pages/adminstation/cv/list";
    }
    
    public String update(int id){
       this.getcvDAO().update(this.cv);
       this.cvlist=this.getcvDAO().list();
       return "/pages/adminstation/cv/list";
    }
    
    public String create(){
        this.getcvDAO().create(this.cv);
        this.cvlist=this.getcvDAO().list();
        this.cv=null;
        return "/tamam";
    }   
 
}
