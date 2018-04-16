/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import Dao.KategoriDao;
import Entity.Kategori;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
//import javax.inject.Named;

/**
 *
 * @author idea
 */
@ManagedBean
@SessionScoped
public class KategoriController implements Serializable {

    private Kategori kategori;
    private List<Kategori> kategoriList;
    private KategoriDao kategoriDao;

    public String updateForm(Kategori kat) {
        this.kategori = kat;
        return "kategori";
    }

    public String update() {
        this.kategoriDao.update(this.kategori);
        this.clearForm();
        return "kategori";
    }

    public String sil(Kategori kat) {
        this.getKategoriDao().sil(kat);
        return "kategori";
    }

    public String create() {
        this.getKategoriDao().insert(this.kategori);
        this.clearForm();
        return "kategori";
    }

    public void clearForm() {
        this.kategori = new Kategori();

    }

    public Kategori getKategori() {
        if (this.kategori == null) {
            this.kategori = new Kategori();
        }

        return kategori;
    }

    public void setKategori(Kategori kategori) {
        this.kategori = kategori;
    }

    public List<Kategori> getKategoriList() {
        this.kategoriList = this.getKategoriDao().findAll();
        return kategoriList;
    }

    public void setKategoriList(List<Kategori> kategoriList) {
        this.kategoriList = kategoriList;
    }

    public KategoriDao getKategoriDao() {
        if (this.kategoriDao == null) {
            this.kategoriDao = new KategoriDao();
        }

        return kategoriDao;
    }

    public void setKategoriDao(KategoriDao kategoriDao) {
        this.kategoriDao = kategoriDao;
    }

}
