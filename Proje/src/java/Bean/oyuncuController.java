/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;


import Dao.oyuncuDAO;
import Entity.oyuncu;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author idea
*/
@ManagedBean (name="oyuncu")
@SessionScoped
public class oyuncuController implements Serializable {
    
    private oyuncu oy;
    private List<oyuncu> oyunculist;
    private oyuncuDAO oyuncuDAO;

    public oyuncu getOy() {
        if(this.oy==null)
            this.oy=new oyuncu();
        return oy;
    }

    public void setOy(oyuncu oy) {
        this.oy = oy;
    }

    public List<oyuncu> getOyunculist() {
        if(this.oyunculist==null)
            this.oyunculist=new ArrayList();
        oyunculist=this.getOyuncuDAO().list();
        return oyunculist;
    }

    public void setOyunculist(List<oyuncu> oyunculist) {
        this.oyunculist = oyunculist;
    }

    public oyuncuDAO getOyuncuDAO() {
        if(this.oyuncuDAO==null)
            this.oyuncuDAO=new oyuncuDAO();
        return oyuncuDAO;
    }

    public void setOyuncuDAO(oyuncuDAO oyuncuDAO) {
        this.oyuncuDAO = oyuncuDAO;
    }

    
      
    public String delete(oyuncu k) {
        this.getOyuncuDAO().delete(k);
        this.oyunculist = this.getOyuncuDAO().list();
        return "/pages/adminstation/seferler/list";
    }

    public oyuncu getKById(Long id) {
        return this.getOyuncuDAO().getKat(id);
    }
    
    

    public String update(){
        this.getOyuncuDAO().update(this.oy);
        this.oyunculist = this.getOyuncuDAO().list();
        return "/pages/adminstation/seferler/list";
    }
    
    public String create() {
        this.getOyuncuDAO().create(this.oy);
        this.oyunculist = this.getOyuncuDAO().list();
        this.oy=null;
        return "/tamam";
    }
    
    
    
    
}
