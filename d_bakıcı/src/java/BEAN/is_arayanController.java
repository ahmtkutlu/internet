/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BEAN;

import DAO.is_arayanDAO;
import DAO.kategoriDAO;
import Entity.is_arayan;
import Entity.kategori;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


@ManagedBean(name="ara")
@SessionScoped
public class is_arayanController {
    
      private is_arayan ara =null;
    private ArrayList<is_arayan> aralist =null;
    private  is_arayanDAO araDAO=null;
    private Long selectedKategori;
   private kategoriDAO KDAO;

    public kategoriDAO getKDAO() {
        if(this.KDAO==null)
            this.KDAO=new kategoriDAO();
        return KDAO;
    }
    private List<kategori> klist;

    public List<kategori> getKlist() {
        this.klist=this.getKDAO().getKat();
        return klist;
    }

    public void setKlist(List<kategori> klist) {
        this.klist = klist;
    }

    public Long getSelectedKategori() {
        return selectedKategori;
    }

    public void setSelectedKategori(Long selectedKategori) {
        this.selectedKategori = selectedKategori;
    }
    
     public is_arayan getAra() {
        if(this.ara==null)
            this.ara =new is_arayan();
        return ara;
    }

    public void setAra(is_arayan ara) {
        this.ara= ara;
    }

    public ArrayList<is_arayan> getlist() {
        if(this.aralist==null){
            this.aralist=new ArrayList();
            aralist=this.getAraDAO().list();
                    }
        return this.aralist;
    }

    public void setlist(ArrayList<is_arayan> list) {
        this.aralist = list;
    }

    public is_arayanDAO  getAraDAO() {
        if(this.araDAO==null)
            this.araDAO = new is_arayanDAO();
        return araDAO;
    }

    public void setAraDAO(is_arayanDAO araDAO) {
        this.araDAO = araDAO;
    }
    public String delete( is_arayan ara) {
        this.getAraDAO().delete(ara);
        this.aralist = this.getAraDAO().list();
        return "/pages/adminstation/seferler/list";
    }

    public is_arayan getAraById(Long id) {
        return this.getAraDAO().getAra(id);
    }
    
    

    public String update(){
        this.getAraDAO().update(this.ara);
        this.aralist = this.getAraDAO().list();
        return "/pages/adminstation/seferler/list";
    }
    
    public String create() {
        this.getAraDAO().create(this.ara);
        this.aralist = this.getAraDAO().list();
        this.ara=null;
        return "/tamam";
    }
    

}
