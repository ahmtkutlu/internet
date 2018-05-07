/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import Dao.yapimciDAO;
import Entity.yapimci;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author idea
 */
@ManagedBean(name="yapimci")
@SessionScoped
public class yapimciController {

    private yapimci y = null;
    private ArrayList<yapimci> yapimcilist = null;
    private yapimciDAO yapimciDAO = null;

    public yapimci getY() {
        if (this.y == null) {
            this.y = new yapimci();
        }
        return y;
    }

    public void setY(yapimci y) {
        this.y = y;
    }

    public ArrayList<yapimci> getYapimcilist() {
        if(this.yapimcilist==null){
            this.yapimcilist=new ArrayList();
            yapimcilist=this.getYapimciDAO().list();
                    }
        return this.yapimcilist;
    }

    public void setYapimcilist(ArrayList<yapimci> yapimcilist) {
        this.yapimcilist = yapimcilist;
    }

    public yapimciDAO getYapimciDAO() {
        if(this.yapimciDAO==null)
            this.yapimciDAO=new yapimciDAO();
        return yapimciDAO;
    }

    public void setYapimciDAO(yapimciDAO yapimciDAO) {
        this.yapimciDAO = yapimciDAO;
    }
    
    
     public String delete(yapimci yapimcii) {
        this.getYapimciDAO().delete(yapimcii);
        this.yapimcilist = this.getYapimciDAO().list();
        return "/tamamm";
    }
     
     public String create() {
        
        this.getYapimciDAO().create(this.y);
        this.yapimcilist = this.getYapimciDAO().list();
        this.y=null;
        return "/tamam";
    }
     
      public String update(){
        
        this.getYapimciDAO().update(this.y);
        this.yapimcilist = this.getYapimciDAO().list();
        return "/sinema/yapimci/update";
    }

}
