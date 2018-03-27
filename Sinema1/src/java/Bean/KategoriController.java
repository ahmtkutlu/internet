/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import Dao.KategoriDao;
import Entity.Kategori;
import java.util.List;

/**
 *
 * @author idea
 */
public class KategoriController {
    
    private Kategori kategori;
    private List<Kategori> kategoriList;
    private KategoriDao kategoriDao;

    public Kategori getKategori() {
        if(this.kategori==null)
            this.kategori=new Kategori();
        return kategori;
    }

    public void setKategori(Kategori kategori) {
        this.kategori = kategori;
    }

//    public List<Kategori> getKategoriList() {
//        this.
//        return kategoriList;
//    }
    
    
//    public List<Kategori> getKategoriList() {
//        this.kategoriList=this.getKategoriDao().find("idkategori");
//        return kategoriList;
//    }
    
   
    
    
    

    public void setKategoriList(List<Kategori> kategoriList) {
        this.kategoriList = kategoriList;
    }

    public KategoriDao getKategoriDao() {
        if(this.kategoriDao==null)
            this.kategoriDao=new KategoriDao();
        return kategoriDao;
    }

    public void setKategoriDao(KategoriDao kategoriDao) {
        this.kategoriDao = kategoriDao;
    }
            
    
    
}
