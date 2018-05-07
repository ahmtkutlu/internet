package Bean;

import Dao.KategoriDao;
import Dao.filmDAO;

import Entity.film;
import Entity.kategori;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
//import javax.inject.Inject;
//import javax.inject.Named;

@ManagedBean(name = "film")
@SessionScoped
public class filmController implements Serializable {

    private film fe = null;
    private ArrayList<film> filmlist = null;
    private filmDAO filmDAO = null;
    private Long selectedKategori;
    private KategoriDao KDAO;
    private List<kategori> klist;

    public film getFe() {
        if (this.fe == null) {
            this.fe = new film();
        }
        return fe;

    }

    public void setFe(film fe) {
        this.fe = fe;
    }

    public ArrayList<film> getFilmlist() {
        if (this.filmlist == null) {
            this.filmlist = new ArrayList();
            filmlist = this.getFilmDAO().list();
        }
        return this.filmlist;

    }

    public void setFilmlist(ArrayList<film> filmlist) {
        this.filmlist = filmlist;
    }

    public filmDAO getFilmDAO() {
        if (this.filmDAO == null) {
            this.filmDAO = new filmDAO();
        }
        return filmDAO;

    }

    public void setFilmDAO(filmDAO filmDAO) {
        this.filmDAO = filmDAO;
    }

    public Long getSelectedKategori() {
        return selectedKategori;
    }

    public void setSelectedKategori(Long selectedKategori) {
        this.selectedKategori = selectedKategori;
    }

    public KategoriDao getKDAO() {
        if (this.KDAO == null) {
            this.KDAO = new KategoriDao();
        }
        return KDAO;

    }

    public void setKDAO(KategoriDao KDAO) {
        this.KDAO = KDAO;
    }

    public List<kategori> getKlist() {
        this.klist=this.getKDAO().getKat();
        return klist;
    }

    public void setKlist(List<kategori> klist) {
        this.klist = klist;
    }

    
    
    
    
    public String delete( film fe) {
        this.getFilmDAO().delete(fe);
        this.filmlist = this.getFilmDAO().list();
        return "/pages/adminstation/seferler/list";
    }

    public film getAraById(Long id) {
        return this.getFilmDAO().getAra(id);
    }
//    
    

    public String update(){
        this.getFilmDAO().update(this.fe);
        this.filmlist = this.getFilmDAO().list();
        return "/pages/adminstation/seferler/list";
    }
    
    public String create() {
        this.getFilmDAO().create(this.fe);
        this.filmlist = this.getFilmDAO().list();
        this.fe=null;
        return "/tamam";
    }
}
