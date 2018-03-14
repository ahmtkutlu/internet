
package BEAN;

import Entity.resim;
import DAO.resimDAO;
import java.util.ArrayList;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ManagedBean;

@ManagedBean(name="resim")
@SessionScoped
public class resimController {
    
    private resim resim=null;
    private ArrayList<resim> resimlist=null;
    private resimDAO resimDAO=null;
    
    public resim getresim(){
        if(this.resim==null)
            this.resim=new resim();
        return resim;
    }
    
    public void setresim(resim k){
        this.resim=resim;
    }
    
    public ArrayList<resim> getlist(){
        if(this.resimlist==null)
            this.resimlist=new ArrayList();
        return this.resimlist;
    }
    
    
    public void setlist(ArrayList<resim> list){
        this.resimlist=list;
    }
    
    public resimDAO getresimDAO(){
        if(this.resimDAO==null)
            this.resimDAO=new resimDAO();
        return this.resimDAO;
    }
    
    public void setcvDAO(resimDAO resimDAO){
        this.resimDAO=resimDAO;
    }
    
    public resim getresimId(int id){
        return this.getresimDAO().getresim(id);
    }
    
    
    public String delete(int id){
        this.getresimDAO().delete(id);
        this.resimlist=this.getresimDAO().list();
        return "/pages/adminstation/resim/list";
    }
    
    public String update(int id){
       this.getresimDAO().update(this.resim);
       this.resimlist=this.getresimDAO().list();
       return "/pages/adminstation/resim/list";
    }
    
    public String create(){
        this.getresimDAO().create(this.resim);
        this.resimlist=this.getresimDAO().list();
        this.resim=null;
        return "/tamam";
    }   
 
}
