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
    
    
    private int page = 1;
    private int listItemCount = 3;
    
    
    public int count (){
        return this.getYonetmenDao().record();
    }
    
    public boolean hasPrev() {
        return page > 1;
    }

    public boolean hasNext() {
        int sum ;
        sum = this.getYonetmenDao().record();
        if ((this.page * this.listItemCount) >= sum) {
            return false;
        } else {
            return true;
        }
    }
    
      public void previous() {
        this.setPage(this.page - 1);
    }

    public void next() {
        this.setPage(this.page + 1);
    }
    
    
    //back start ve diğer fonksiyonların redirecti eklenecek    
    
     public String start() {
        this.yonetmen = new Yonetmen() ;
        return "/admin/index?faces-redirect=true";
    }
    
     public String back() {
        this.yonetmen = new Yonetmen();
        return "/admin/yonetmen/list?faces-redirect=true ";
    }
    
    
    
    
    
    

    public void clearForm(){
        this.yonetmen = new Yonetmen();
    }
    public String updateForm(Yonetmen yonetmen) {
        this.yonetmen = yonetmen;       
        return "/admin/yonetmen/update?faces-redirect=true ";
    }
     public String createForm() {
        this.yonetmen = new Yonetmen() ;
        return "/admin/yonetmen/create?faces-redirect=true ";
    }
    
    public String update() {
        this.getYonetmenDao().update(this.yonetmen);
        this.yonetmen = new Yonetmen();
        return "/admin/yonetmen/list?faces-redirect=true ";
    }
    public void deleteConfirm(Yonetmen yonetmen){
        this.yonetmen = yonetmen ;
    }

    public String delete(Yonetmen yonetmen) {
        this.getYonetmenDao().delete(yonetmen);
        this.clearForm();
        return "/admin/yonetmen/list?faces-redirect=true ";
    }

    public String create() {
        this.getYonetmenDao().insert(this.yonetmen);
        this.yonetmen = new Yonetmen();
        return "/admin/yonetmen/list?faces-redirect=true ";
    }
      
 
//     public String create(Yonetmen yonetmen) {
//        if(yonetmen==null){
//        return "/admin/index?faces-redirect=true ";
//        }else{
//         this.getYonetmenDao().insert(yonetmen);
//        this.yonetmen = new Yonetmen();
//        return "/admin/yonetmen/list?faces-redirect=true ";
//        }       
//    }
//    
    
    
    
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
        this.ListeYonetmen = this.getYonetmenDao().findAll(page,listItemCount);
        return ListeYonetmen;
    }

    public void setListeYonetmen(List<Yonetmen> ListeYonetmen) {
        this.ListeYonetmen = ListeYonetmen;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getListItemCount() {
        return listItemCount;
    }

    public void setListItemCount(int listItemCount) {
        this.listItemCount = listItemCount;
    }
    
    
    
    
}
