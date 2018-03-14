

package BEAN;

import DAO.ilceDAO;
import Entity.ilce;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name="ilce")
@SessionScoped

public class ilceController {
    
    private ilce ilce=null;
    private ArrayList<ilce> ilcelist=null;
    private ilceDAO ilceDAO=null;
    
    
    public ilce getIlce(){
        if(this.ilce==null)
            this.ilce=new ilce();
            return ilce;
    }
    
    
    public void setIlce(ilce i){
        this.ilce=ilce;
    }
    
    
    public ArrayList<ilce> getlist(){
        if(this.ilcelist==null)
            this.ilcelist=new ArrayList();
            ilcelist=this.getilceDAO().list();
            return this.ilcelist;
    }

    
    public void setlist(ArrayList<ilce>list){
        this.ilcelist=list;
    }
    
    
    public ilceDAO getilceDAO(){
        if(this.ilceDAO==null)
            this.ilceDAO=new ilceDAO();
            return ilceDAO;
    }
    
    
    public void setilDAO(ilceDAO ilceDAO){
        this.ilceDAO=ilceDAO;
    }
    
    
    public ilce getIlceId(int id){
        return this.getilceDAO().getIlce(id);
    }
    
    
    public String delete(int id){
        this.getilceDAO().delete(id);
        this.ilcelist=this.getilceDAO().list();
        return "/pages/adminstation/ilce/list";
    }
    
    
    public String update(int id){
        this.getilceDAO().update(this.ilce);
        this.ilcelist=this.getilceDAO().list();
        return "/pages/adminstation/ilce/list";
    }
    
    
    public String create(){
        this.getilceDAO().create(this.ilce);
        this.ilcelist=this.getilceDAO().list();
        this.ilce=null;
        return "/tamam";
    }
}
