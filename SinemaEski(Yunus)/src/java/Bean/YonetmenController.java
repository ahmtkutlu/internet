/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import DAO.YonetmenDAO;
import Entity.Yonetmen;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Kutlu
 */
@SessionScoped
@ManagedBean
public class YonetmenController implements Serializable{

    private Yonetmen yonetmen;
    private YonetmenDAO YonetmenDao;
    private List<Yonetmen> ListeYonetmen;

    public void clearForm(){
        this.yonetmen = new Yonetmen();
    }
    public void updateForm(Yonetmen yonetmen) {
        this.yonetmen = yonetmen;       
    }
    
    public void update() {
        this.getYonetmenDao().update(this.yonetmen);
        this.yonetmen = new Yonetmen();
    }
    public void deleteConfirm(Yonetmen yonetmen){
        this.yonetmen = yonetmen ;
    }

    public void delete() {
        this.getYonetmenDao().delete(this.yonetmen);
        this.clearForm();
    }

    public void create() {
        this.getYonetmenDao().insert(this.yonetmen);
        this.yonetmen = new Yonetmen();
    }
      
    
    
    
    
    public Yonetmen getYonetmen() {
        if (this.yonetmen == null) {
            this.clearForm();
        }
        return yonetmen;
    }

    public void setYonetmen(Yonetmen yonetmen) {
        this.yonetmen = yonetmen;
    }

    public YonetmenDAO getYonetmenDao() {
        if (this.YonetmenDao == null) {
            this.YonetmenDao = new YonetmenDAO();
        }
        return YonetmenDao;
    }

    public void setYonetmenDao(YonetmenDAO YonetmenDao) {
        this.YonetmenDao = YonetmenDao;
    }

    public List<Yonetmen> getListeYonetmen() {
        this.ListeYonetmen = this.getYonetmenDao().findAll();
        return ListeYonetmen;
    }

    public void setListeYonetmen(List<Yonetmen> ListeYonetmen) {
        this.ListeYonetmen = ListeYonetmen;
    }
    
    
}
