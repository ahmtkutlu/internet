/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import DAO.SinemaDAO;
import Entity.Sinema;
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
public class SinemaController implements Serializable{
    private Sinema sinema;
    private SinemaDAO SinemaDao;
    private List<Sinema> ListeSinema;

    private int page = 1;
    private int listItemCount = 3;
    
    
    public int count (){
        return this.getSinemaDao().record();
    }
    
    public boolean hasPrev() {
        return page > 1;
    }

    public boolean hasNext() {
        int sum ;
        sum = this.getSinemaDao().record();
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
        this.sinema = new Sinema() ;
        return "/admin/index?faces-redirect=true";
    }
    
     public String back() {
        this.sinema = new Sinema();
        return "/admin/sinema/list?faces-redirect=true ";
    }
    
    
    
    
    
      public void clearForm(){
        this.sinema = new Sinema();
    }
    public String updateForm(Sinema sinema) {
        this.sinema = sinema;       
        return "/admin/sinema/update?faces-redirect=true ";
    }
      public String createForm() {
        this.sinema = new Sinema() ;
        return "/admin/sinema/create?faces-redirect=true ";
    }
    
    public String update() {
        this.getSinemaDao().update(this.sinema);
        this.sinema = new Sinema();
        return "/admin/sinema/list?faces-redirect=true ";
    }
    public void deleteConfirm(Sinema sinema){
        this.sinema = sinema ;
    }

    public String delete(Sinema sinema) {
        this.getSinemaDao().delete(sinema);
        this.clearForm();
        return "/admin/sinema/list?faces-redirect=true ";
    }

    public String create() {
        this.getSinemaDao().insert(this.sinema);
        this.sinema = new Sinema();
        return "/admin/sinema/list?faces-redirect=true ";
    }  
    
//     public String create(Sinema sinema) {
//        if(sinema==null){
//        return "/admin/index?faces-redirect=true ";
//        }else{
//         this.getSinemaDao().insert(sinema);
//        this.sinema = new Sinema();
//        return "/admin/sinema/list?faces-redirect=true ";
//        }       
//    }
    
    

    
    
    public Sinema getSinema() {
          if (this.sinema == null) {
            this.clearForm();
        }
        return sinema;
    }

    public void setSinema(Sinema sinema) {
        this.sinema = sinema;
    }

    public SinemaDAO getSinemaDao() {
        if (this.SinemaDao == null) {
            this.SinemaDao = new SinemaDAO();
        }
        return SinemaDao;
    }

    public void setSinemaDao(SinemaDAO SinemaDao) {
        this.SinemaDao = SinemaDao;
    }

    public List<Sinema> getListeSinema() {
        this.ListeSinema = this.getSinemaDao().findAll(page,listItemCount);
        return ListeSinema;
    }

    public void setListeSinema(List<Sinema> ListeSinema) {
        this.ListeSinema = ListeSinema;
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

