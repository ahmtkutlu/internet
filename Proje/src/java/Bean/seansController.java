/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;


import Dao.seansDAO;
import Entity.seans;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author idea
 */


@ManagedBean(name="seans")
@SessionScoped
public class seansController {

    private seans s;
    private List<seans> seanslist;
    private seansDAO seansDAO;

    public seans getS() {
        if(this.s==null)
            this.s=new seans();
        return s;
    }

    
    public void setS(seans s) {
        this.s = s;
    }

    public List<seans> getSeanslist() {
        if(this.seanslist==null){
            this.seanslist=new ArrayList();
            seanslist=this.getSeansDAO().list();
                    }
        return this.seanslist;
        
    }

    public void setSeanslist(List<seans> seanslist) {
        this.seanslist = seanslist;
    }

    
    public seansDAO getSeansDAO() {
        if(this.seansDAO==null)
            this.seansDAO=new seansDAO();
        return seansDAO;
    }

    public void setSeansDAO(seansDAO seansDAO) {
        this.seansDAO = seansDAO;
    }
    
     public String delete(Long id) {
        this.getSeansDAO().delete(id);
        this.seanslist = this.getSeansDAO().list();
        return "/pages/adminstation/seferler/list";
    }
////
////    public yorum getYById(Long id) {
////        return this.getYDAO().getYrm(id);
////    }
////
    public String update() {
        this.getSeansDAO().update(this.s);
        this.seanslist = this.getSeansDAO().list();
        return "/pages/adminstation/seferler/list";
    }
//
    public String create() {
        this.getSeansDAO().create(this.s);
        this.seanslist = this.getSeansDAO().list();
        this.s = null;
        return "/tamam";
    }


}
