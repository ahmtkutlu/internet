
package BEAN;

import DAO.ilDAO;
import Entity.il;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name="il")
@SessionScoped
public class ilController {
    
    private il il=null;
    private ArrayList<il> ilist=null;
    private ilDAO ilDAO=null;
    
    
    public il getIl(){
        if(this.il==null)
            this.il=new il();
            return il;
    }
    
    
    public void setIl(il il){
        this.il=il;
    }
    
    
    public ArrayList<il> getlist(){
        if(this.ilist==null)
            this.ilist=new ArrayList();
            ilist=this.getilDAO().list();
            return this.ilist;
    }

    
    public void setlist(ArrayList<il>list){
        this.ilist=list;
    }
    
    
    public ilDAO getilDAO(){
        if(this.ilDAO==null)
            this.ilDAO=new ilDAO();
            return ilDAO;
    }
    
    
    public void setilDAO(ilDAO ilDAO){
        this.ilDAO=ilDAO;
    }
    
    
    public il getIlId(int id){
        return this.getilDAO().getIl(id);
    }
    
    
    public String delete(int id){
        this.getilDAO().delete(id);
        this.ilist=this.getilDAO().list();
        return "/pages/adminstation/il/list";
    }
    
    
    public String update(int id){
        this.getilDAO().update(this.il);
        this.ilist=this.getilDAO().list();
        return "/pages/adminstation/il/list";
    }
    
    
    public String create(){
        this.getilDAO().create(this.il);
        this.ilist=this.getilDAO().list();
        this.il=null;
        return "/tamam";
    }
}
