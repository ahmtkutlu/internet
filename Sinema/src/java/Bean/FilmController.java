package Bean;

import Dao.FilmDao;
import Entity.Film;
import Entity.Kategori;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
//import javax.inject.Inject;
//import javax.inject.Named;

@ManagedBean
@SessionScoped
public class FilmController implements Serializable {

    private Film film;
    private List<Film> filmList;
    private FilmDao filmDao;

    @Inject
    private KategoriController kategoriController;

    private List<Long> selectedKategoriList;

    public void delete() {
        this.getFilmDao().remove(this.film);
        this.clearForm();
        this.selectedKategoriList = null;
    }

    public void updateForm(Film f) {
        this.film = f;
        this.selectedKategoriList = new ArrayList<>();

        for (Kategori k : this.film.getKategoriList()) {
            this.selectedKategoriList.add(k.getIdkategori());
        }
    }

    public void update() {
        this.getFilmDao().edit(this.film, selectedKategoriList);
        this.clearForm();

    }

    public void clearForm() {
        this.film = new Film();
        this.selectedKategoriList = null;
    }

    public String create() {
        this.getFilmDao().insert(this.film, selectedKategoriList);
        this.clearForm();
        return "film";
    }

    public Film getFilm() {
        if (this.film == null) {
            this.film = new Film();
        }

        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public List<Film> getFilmList() {
        this.filmList = this.getFilmDao().findAllPrepared()/*findAll()*/;
        return filmList;
    }

    public void setFilmList(List<Film> filmList) {
        this.filmList = filmList;
    }

    public FilmDao getFilmDao() {
        if (this.filmDao == null) {
            this.filmDao = new FilmDao();
        }
        return filmDao;
    }

    public void setFilmDao(FilmDao filmDao) {
        this.filmDao = filmDao;
    }

    public List<Long> getSelectedKategoriList() {
        return selectedKategoriList;
    }

    public void setSelectedKategoriList(List<Long> selectedKategoriList) {
        this.selectedKategoriList = selectedKategoriList;
    }

    public KategoriController getKategoriController() {
        return kategoriController;
    }

    public void setKategoriController(KategoriController kategoriController) {
        this.kategoriController = kategoriController;
    }

}
