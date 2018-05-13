/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import DAO.FilmDAO;
import DAO.GaleriDAO;
import Entity.Film;
import Entity.Galeri;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.nio.file.Files;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.servlet.http.Part;

/**
 *
 * @author Kutlu
 */
@SessionScoped
@ManagedBean
public class GaleriController implements Serializable{
    
    private Galeri galeri;
    private GaleriDAO GaleriDao;
    private List<Galeri> ListeGaleri;
    
      private Part part;      
      private FilmController FilmController;
    //yeni
      private List<Film> ListFilm ;
      private FilmDAO filmDAO ;

      private final String uploadPath = "C:\\Server\\";
      
      
      
      public String upload() {
        try {
            InputStream input = part.getInputStream();
            File f = new File(this.uploadPath + part.getSubmittedFileName());
            Files.copy(input, f.toPath(), REPLACE_EXISTING);

            String format = "dd-MM-yyyy-hhmmss";
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            String extension = f.getName().substring(f.getName().lastIndexOf("."));
            String fileName = sdf.format(new Date()) + extension;
            File newFile = new File(this.uploadPath + fileName);
            f.renameTo(newFile);

            
            this.galeri.setResim(newFile.getParent());
            this.galeri.setName(newFile.getName());
            this.galeri.setType(part.getContentType());
           
            this.getGaleriDao().insert(this.galeri);

        } catch (IOException ex) {
            System.out.println(ex.getLocalizedMessage());
        }
        
         return "/admin/galeri/galeri?faces-redirect=true";
      
      }
      
       public int count (){
        return this.getGaleriDao().record();
    }
      

    public void clearForm(){
        this.galeri = new Galeri();
    }
    public String close() {
        return "/admin/index?faces-redirect=true";
               
    }
    public void updateForm(Galeri galeri) {
        this.galeri = galeri;       
    }
    
    public void update() {
        this.getGaleriDao().update(this.galeri);
        this.galeri = new Galeri();
    }
    public void deleteConfirm(Galeri galeri){
        this.galeri = galeri ;
    }

    public String delete() {
        this.getGaleriDao().delete(this.galeri);
         return "/admin/galeri/galeri?faces-redirect=true";
    }

    public void create() {
        this.getGaleriDao().insert(this.galeri);
        this.galeri = new Galeri();
    }
    
    public Galeri getGaleri() {
        if (this.galeri == null) {
            this.galeri=new Galeri();
        }
        return galeri;
    }

    public void setGaleri(Galeri galeri) {
        this.galeri = galeri;
    }

    public GaleriDAO getGaleriDao() {
        if (this.GaleriDao == null) {
            this.GaleriDao = new GaleriDAO();
        }
        return GaleriDao;
    }

    public void setGaleriDao(GaleriDAO GaleriDao) {
        this.GaleriDao = GaleriDao;
    }

    public List<Galeri> getListeGaleri() {
        this.ListeGaleri = this.getGaleriDao().findAll();
        return ListeGaleri;
    }

    public void setListeGaleri(List<Galeri> ListeGaleri) {
        this.ListeGaleri = ListeGaleri;
    }

   
     //yeni

    public List<Film> getListFilm() {
         this.ListFilm = this.getFilmDAO().findAll();
        return ListFilm;
    }

    public void setListFilm(List<Film> ListFilm) {
        this.ListFilm = ListFilm;
    }

    public FilmDAO getFilmDAO() {
         if (this.filmDAO == null)
            this.filmDAO = new FilmDAO();
        return filmDAO;
    }

    public void setFilmDAO(FilmDAO filmDAO) {
        this.filmDAO = filmDAO;
    }

    public Part getPart() {
        return part;
    }

    public void setPart(Part part) {
        this.part = part;
    }

    public FilmController getFilmController() {
        if (this.FilmController == null) {
            this.FilmController = new FilmController();
        }
        return FilmController;
    }

    public void setFilmController(FilmController FilmController) {
        this.FilmController = FilmController;
    }

    
    
     
  
    
    
    
}
