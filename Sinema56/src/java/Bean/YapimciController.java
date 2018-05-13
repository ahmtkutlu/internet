/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import DAO.YapimciDAO;
import Entity.Yapimci;
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
public class YapimciController implements Serializable{
 
    private Yapimci yapimci;
    private YapimciDAO YapimciDao;
    private List<Yapimci> ListeYapimci;       
    
    
    
    private int page = 1;
    private int listItemCount = 3;
    
    
    
    
     public int count (){
        return this.getYapimciDao().record();
    }
    
    public boolean hasPrev() {
        return page > 1;
    }

    public boolean hasNext() {
        int sum ;
        sum = this.getYapimciDao().record();
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
        this.yapimci = new Yapimci() ;
        return "/admin/index?faces-redirect=true";
    }
    
     public String back() {
        this.yapimci = new Yapimci();
        return "/admin/yapimci/list?faces-redirect=true ";
    }
    
    
    
    
    
    
    public void clearForm(){
        this.yapimci = new Yapimci();
    }
    
    public String updateForm(Yapimci yapimci) {
        this.yapimci = yapimci; 
        return "/admin/yapimci/update?faces-redirect=true ";
    }
    public String createForm() {
        this.yapimci = new Yapimci() ;
        return "/admin/yapimci/create?faces-redirect=true ";
    }
    
    
    public String update() {
        this.getYapimciDao().update(this.yapimci);
        this.yapimci = new Yapimci();
         return "/admin/yapimci/list?faces-redirect=true ";
    }
    public void deleteConfirm(Yapimci yapimci){
        this.yapimci = yapimci ;
    }

    public String delete(Yapimci yapimci) {
        this.getYapimciDao().delete(yapimci);
        this.clearForm();
         return "/admin/yapimci/list?faces-redirect=true ";
    }

    public String create() {
        this.getYapimciDao().insert(this.yapimci);
        this.yapimci = new Yapimci();
         return "/admin/yapimci/list?faces-redirect=true ";
    }
    
//     public String create(Yapimci yapimci) {
//        if(yapimci==null){
//        return "/admin/index?faces-redirect=true ";
//        }else{
//         this.getYapimciDao().insert(yapimci);
//        this.yapimci = new Yapimci();
//        return "/admin/yapimci/list?faces-redirect=true ";
//        }       
//    }

    public Yapimci getYapimci() {
            if (this.yapimci == null) {
            this.clearForm();
        }
        return yapimci;
    }

    public void setYapimci(Yapimci yapimci) {
        this.yapimci = yapimci;
    }

    public YapimciDAO getYapimciDao() {
        if (this.YapimciDao == null) {
          this.YapimciDao = new YapimciDAO();
        }
        return YapimciDao;
    }

    public void setYapimciDao(YapimciDAO YapimciDao) {
        this.YapimciDao = YapimciDao;
    }

    public List<Yapimci> getListeYapimci() {
        this.ListeYapimci = this.getYapimciDao().findAll(page,listItemCount);
        return ListeYapimci;
    }

    public void setListeYapimci(List<Yapimci> ListeYapimci) {
        this.ListeYapimci = ListeYapimci;
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
