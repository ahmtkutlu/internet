/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import DAO.OyuncuDAO;
import Entity.Oyuncu;
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

public class OyuncuController implements Serializable{
  
    private Oyuncu oyuncu;
    private OyuncuDAO OyuncuDao;
    private List<Oyuncu> ListeOyuncu;

    
    
    private int page = 1;
    private int listItemCount = 3;
    
    
    public int count (){
        return this.getOyuncuDao().record();
    }
    
    public boolean hasPrev() {
        return page > 1;
    }

    public boolean hasNext() {
        int sum ;
        sum = this.getOyuncuDao().record();
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
        this.oyuncu = new Oyuncu() ;
        return "/admin/index?faces-redirect=true";
    }
    
     public String back() {
        this.oyuncu = new Oyuncu();
        return "/admin/oyuncu/list?faces-redirect=true ";
    }
    
    
     public void clearForm(){
        this.oyuncu = new Oyuncu();
    }
    public String updateForm(Oyuncu oyuncu) {
        this.oyuncu = oyuncu;  
       return "/admin/oyuncu/update?faces-redirect=true ";
    }
     public String createForm() {
        this.oyuncu = new Oyuncu() ;
        return "/admin/oyuncu/create?faces-redirect=true ";
    }
    
    public String update() {
        this.getOyuncuDao().update(this.oyuncu);
        this.oyuncu = new Oyuncu();
        return "/admin/oyuncu/list?faces-redirect=true ";
    }
    public void deleteConfirm(Oyuncu oyuncu){
        this.oyuncu = oyuncu ;
    }

    public String delete(Oyuncu oyuncu) {
        this.getOyuncuDao().delete(oyuncu);
        this.clearForm();
        return "/admin/oyuncu/list?faces-redirect=true ";
    }

    public String create() {
        this.getOyuncuDao().insert(this.oyuncu);
        this.oyuncu = new Oyuncu();
        return "/admin/oyuncu/list?faces-redirect=true ";
    }   
//     public String create(Oyuncu oyuncu) {
//        if(oyuncu==null){
//        return "/admin/index?faces-redirect=true ";
//        }else{
//         this.getOyuncuDao().insert(oyuncu);
//        this.oyuncu = new Oyuncu();
//        return "/admin/oyuncu/list?faces-redirect=true ";
//        }       
//    }
    
    public Oyuncu getOyuncu() {
          if (this.oyuncu == null) {
            this.clearForm();
        }
        return oyuncu;
    }

    public void setOyuncu(Oyuncu oyuncu) {
        this.oyuncu = oyuncu;
    }

    public OyuncuDAO getOyuncuDao() {
          if (this.OyuncuDao == null) {
            this.OyuncuDao = new OyuncuDAO();
        }
        return OyuncuDao;
    }

    public void setOyuncuDao(OyuncuDAO OyuncuDao) {
        this.OyuncuDao = OyuncuDao;
    }

    public List<Oyuncu> getListeOyuncu() {
        this.ListeOyuncu = this.getOyuncuDao().findAll(page,listItemCount);
        return ListeOyuncu;
    }

    public void setListeOyuncu(List<Oyuncu> ListeOyuncu) {
        this.ListeOyuncu = ListeOyuncu;
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
