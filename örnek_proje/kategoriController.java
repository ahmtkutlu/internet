
package BEAN;

import DAO.kategoriDAO;
import Entity.kategori;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name="kategori")
@SessionScoped
public class kategoriController {
    
    private kategori k=null;
    private ArrayList<kategori> klist=null;
    private kategoriDAO kDAO=null;
    
    public kategori getK(){
    if(this.k==null)
        this.k=new kategori();
    return k;
    }
    
    public void setK(kategori k){
        this.k=k;
    }
   
    public ArrayList<kategori> getlist(){
    if(this.klist==null)
        this.klist=new ArrayList();
        klist=this.getkDAO().list();
      return this.klist;
    }
    
    public void setlist(ArrayList<kategori> list){
        this.klist=list;
    }
            
    public kategoriDAO getkDAO(){
    if(this.kDAO==null)
        this.kDAO=new kategoriDAO();
     return kDAO;
    }
    
    public void setkDAO(kategoriDAO kDAO){
        this.kDAO=kDAO;
    }
    
      public kategori getKategoriId(int id){
       return this.getkDAO().getKategori(id);
    }
    
    public String delete(int id){
        this.getkDAO().delete(id);
        this.klist=this.getkDAO().list();
        return "/pages/adminstation/kategori/list";
    }
    
  
    public String update(int id){
       this.getkDAO().update(this.k);
       this.klist=this.getkDAO().list();
       return "/pages/adminstation/kategori/list";
    }
    
    
    public String create(){
        this.getkDAO().create(this.k);
        this.klist=this.getkDAO().list();
        this.k=null;
        return "/tamam";
    }
       
}