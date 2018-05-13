/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import DAO.DuyuruDAO;
import Entity.Duyuru;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Kutlu
 */
@ManagedBean
@SessionScoped
public class DuyuruController implements Serializable{
    private DuyuruDAO duyuruDao;
    private Duyuru duyuru;
    private List<Duyuru> ListeDuyuru;
    
    private int page = 1;
    private int listItemCount = 3;
    
    
    public int count (){
        return this.getDuyuruDao().record();
    }
    
    public boolean hasPrev() {
        return page > 1;
    }

    public boolean hasNext() {
        int sum ;
        sum = this.getDuyuruDao().record();
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
        this.duyuru = new Duyuru() ;
        return "/admin/index?faces-redirect=true";
    }
    
     public String back() {
        this.duyuru = new Duyuru();
        return "/admin/duyuru/list?faces-redirect=true ";
    }
    
    
    
    public void clearForm(){
        this.duyuru = new Duyuru();
    }
    public String updateForm(Duyuru duyuru) {
        this.duyuru = duyuru;  
        return "/admin/duyuru/update?faces-redirect=true ";
    }
    public String createForm() {
        this.duyuru = new Duyuru() ;
        return "/admin/duyuru/create?faces-redirect=true ";
    }
    
    public String update() {
        this.getDuyuruDao().update(this.duyuru);
        this.duyuru = new Duyuru();
        return "/admin/duyuru/list?faces-redirect=true ";
    }
    public void deleteConfirm(Duyuru duyuru){
        this.duyuru = duyuru ;
    }

    public String delete(Duyuru duyuru) {
        this.getDuyuruDao().delete(duyuru);
        this.clearForm();
        return "/admin/duyuru/list?faces-redirect=true ";
    }


//     public String create(Duyuru duyuru) {
//        if(duyuru==null){
//        return "/admin/index?faces-redirect=true ";
//        }else{
//        this.getDuyuruDao().insert(duyuru);
//        this.duyuru = new Duyuru();
//        return "/admin/duyuru/list?faces-redirect=true ";
//        }       
//    }
    
    
    public String create() {
        this.getDuyuruDao().insert(this.duyuru);
        this.duyuru = new Duyuru();
        return "/admin/duyuru/list?faces-redirect=true ";
    }
 
    
    
    
    
    
    
    public DuyuruDAO getDuyuruDao() {
            if (this.duyuruDao == null) {
            this.duyuruDao = new DuyuruDAO();
        }
        return duyuruDao;
    }

    public void setDuyuruDao(DuyuruDAO duyuruDao) {
        this.duyuruDao = duyuruDao;
    }

    public Duyuru getDuyuru() {
          if (this.duyuru == null) {
            this.clearForm();
        }
        return duyuru;
    }

    public void setDuyuru(Duyuru duyuru) {
        this.duyuru = duyuru;
    }

    public List<Duyuru> getListeDuyuru() {
        this.ListeDuyuru = this.getDuyuruDao().findAll(page,listItemCount);
        return ListeDuyuru;
    }

    public void setListeDuyuru(List<Duyuru> ListeDuyuru) {
        this.ListeDuyuru = ListeDuyuru;
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
