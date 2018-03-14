
package BEAN;

import DAO.bakilacak_kisiDAO;
import Entity.bakilacak_kisi;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name="bakilacak_kisi")
@SessionScoped
public class bakilacak_kisiController {
    
    private bakilacak_kisi bakilacak_kisi=null;
    private ArrayList<bakilacak_kisi> bakilacak_kisilist=null;
    private bakilacak_kisiDAO bakilacak_kisiDAO=null;
    
    public bakilacak_kisi getBakilacak_kisi(){
    if(this.bakilacak_kisi==null)
        this.bakilacak_kisi=new bakilacak_kisi();
    return bakilacak_kisi;
    }
    
    public void setBakilacak_kisi(bakilacak_kisi bakilacak_kisi){
        this.bakilacak_kisi=bakilacak_kisi;
    }
   
    public ArrayList<bakilacak_kisi> getlist(){
    if(this.bakilacak_kisilist==null)
        this.bakilacak_kisilist=new ArrayList();
        bakilacak_kisilist=this.bakilacak_kisiDAO.list();
      return this.bakilacak_kisilist;
    }
    
    public void setlist(ArrayList<bakilacak_kisi> list){
        this.bakilacak_kisilist=list;
    }
            
    public bakilacak_kisiDAO getBakilacak_kisiDAO(){
    if(this.bakilacak_kisiDAO==null)
        this.bakilacak_kisiDAO=new bakilacak_kisiDAO();
     return bakilacak_kisiDAO;
    }
    
    public void setBakilacak_kisiDAO(bakilacak_kisiDAO bakilacak_kisiDAO){
        this.bakilacak_kisiDAO=bakilacak_kisiDAO;
    }
    
      public bakilacak_kisi getBakilacak_kisiId(int id){
       return this.getBakilacak_kisiDAO().getBakilacak_kisi(id);
    }
    
    public String delete(int id){
        this.getBakilacak_kisiDAO().delete(id);
        this.bakilacak_kisilist=this.getBakilacak_kisiDAO().list();
        return "/pages/adminstation/bakilacak_kisi/list";
    }
    
  
    public String update(int id){
       this.getBakilacak_kisiDAO().update(this.bakilacak_kisi);
       this.bakilacak_kisilist=this.getBakilacak_kisiDAO().list();
       return "/pages/adminstation/bakilacak_kisi/list";
    }
    
    public String create(){
        this.getBakilacak_kisiDAO().create(this.bakilacak_kisi);
        this.bakilacak_kisilist=this.getBakilacak_kisiDAO().list();
        this.bakilacak_kisi=null;
        return "/tamam";
    }
       
}