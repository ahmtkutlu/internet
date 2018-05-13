/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import DAO.KategoriDAO;
import Entity.Kategori;
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
public class KategoriController implements Serializable{    
    
    private Kategori kategori;
    private KategoriDAO KategoriDao;
    private List<Kategori> ListeKategori;
    
    
    
    private int page = 1;
    private int listItemCount = 3;
    
    
    public int count (){
        return this.getKategoriDao().record();
    }
    
    public boolean hasPrev() {
        return page > 1;
    }

    public boolean hasNext() {
        int sum ;
        sum = this.getKategoriDao().record();
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
        this.kategori = new Kategori() ;
        return "/admin/index?faces-redirect=true";
    }
    
     public String back() {
        this.kategori = new Kategori();
        return "/admin/kategori/list?faces-redirect=true ";
        
    }
    
    
    
    

    
    
    public void clearForm(){
        this.kategori = new Kategori();
    }
    public String updateForm(Kategori kategori) {
        this.kategori = kategori;       
          return "/admin/kategori/update?faces-redirect=true ";
    }
      public String createForm() {
        this.kategori = new Kategori() ;
        return "/admin/kategori/create?faces-redirect=true ";
    }
    
    public String update() {
        this.getKategoriDao().update(this.kategori);
        this.kategori = new Kategori();
        return "/admin/kategori/list?faces-redirect=true ";

    }
    public void deleteConfirm(Kategori kategori){
        this.kategori = kategori ;
    }

    public String delete(Kategori kategori) {
        this.getKategoriDao().delete(kategori);
        this.clearForm();
        return "/admin/kategori/list?faces-redirect=true ";
    }
    
    
   

    public String create() {
     
        this.getKategoriDao().insert(this.kategori);
        this.kategori = new Kategori();
        return "/admin/kategori/list?faces-redirect=true ";
       
    }  
       
    public Kategori getKategori() {
          if (this.kategori == null) {
            this.clearForm();
        }
        return kategori;
    }

    public void setKategori(Kategori kategori) {
        this.kategori = kategori;
    }

    public KategoriDAO getKategoriDao() {
        if (this.KategoriDao == null) {
            this.KategoriDao = new KategoriDAO();
        }
        return KategoriDao;
    }

    public void setKategoriDao(KategoriDAO KategoriDao) {
        this.KategoriDao = KategoriDao;
    }

    public List<Kategori> getListeKategori() {
        this.ListeKategori = this.getKategoriDao().findAll(page,listItemCount);
        return ListeKategori;
    }

    public void setListeKategori(List<Kategori> ListeKategori) {
        this.ListeKategori = ListeKategori;
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
