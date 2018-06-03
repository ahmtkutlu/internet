/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import DAO.YorumDAO;
import Entity.Yorum;
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
public class YorumController implements Serializable{
    
    private Yorum yorum;
    private YorumDAO YorumDao;
    private List<Yorum> ListeYorum;

    
    
     public void clearForm(){
        this.yorum = new Yorum();
    }
    public void updateForm(Yorum yorum) {
        this.yorum = yorum;       
    }
    
    public void update() {
        this.getYorumDao().update(this.yorum);
        this.yorum = new Yorum();
    }
    public void deleteConfirm(Yorum yorum){
        this.yorum = yorum ;
    }

    public void delete() {
        this.getYorumDao().delete(this.yorum);
        this.clearForm();
    }

    public void create() {
        this.getYorumDao().insert(this.yorum);
        this.yorum = new Yorum();
    }
    
    public Yorum getYorum() {
        if (this.yorum == null) {
            this.clearForm();
        }
        return yorum;
    }

    public void setYorum(Yorum yorum) {
        this.yorum = yorum;
    }

    public YorumDAO getYorumDao() {
        if (this.YorumDao == null) {
            this.YorumDao = new YorumDAO();
        }
        return YorumDao;
    }

    public void setYorumDao(YorumDAO YorumDao) {
        this.YorumDao = YorumDao;
    }

    public List<Yorum> getListeYorum() {
        this.ListeYorum = this.getYorumDao().findAll();
        return ListeYorum;
    }

    public void setListeYorum(List<Yorum> ListeYorum) {
        this.ListeYorum = ListeYorum;
    }
    
    
    
    
    
    
}
