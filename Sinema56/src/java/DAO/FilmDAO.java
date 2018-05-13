/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entity.Film;
import Utility.Connector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Kutlu
 */
public class FilmDAO extends AbstractDAO implements DAO<Film>{
    
      Connector con = new Connector();
      Connection connection = con.connect();
       
       private YonetmenDAO YonetmenDao;
       private YapimciDAO YapimciDao;
       
       
    public YonetmenDAO getYonetmenDao() {
        if(this.YonetmenDao==null){
                
            this.YonetmenDao= new YonetmenDAO();
            
            }
        
        return YonetmenDao;
    }

    public void setYonetmenDao(YonetmenDAO YonetmenDao) {
        this.YonetmenDao = YonetmenDao;
    }

    public YapimciDAO getYapimciDao() {
        
        if(this.YapimciDao==null){
                
            this.YapimciDao= new YapimciDAO();
            
            }
        return YapimciDao;
    }

    public void setYapimciDao(YapimciDAO YapimciDao) {
        this.YapimciDao = YapimciDao;
    }
       
       
       
       
       @Override
        public Film find(Long id) {
        Film film = null;
        try {
            String query = "select * from filmler where idfilmler = ?";
            PreparedStatement pst = connection.prepareStatement(query);
            pst.setLong(1, id);
            ResultSet rs = pst.executeQuery();           
            rs.next();     
            film =new Film();
            film.setIdfilmler(rs.getLong("idfilmler"));                        
            film.setYonetmen(this.getYonetmenDao().find(rs.getLong("yonetmen_idyonetmen")));
            film.setYapimci(this.getYapimciDao().find(rs.getLong("yapimci_idyapimci")));            
            film.setFilm_adi(rs.getString("film_adi"));
            film.setSure(rs.getInt("sure"));
            film.setYil(rs.getInt("yil"));
            film.setImdb_puani(rs.getDouble("ımdb_puani"));
            film.setButce(rs.getInt("butce"));
            film.setIcerik(rs.getString("icerik"));
                        

        } catch (SQLException ex) {
            System.out.println(ex.getMessage())  ;
        }
        return film;

    }
       
       
       
      @Override
       public List<Film> findAll() {
         List<Film> ListeFilm = new ArrayList();
        try {
            String query = "select * from filmler order by idfilmler";
            PreparedStatement pst = connection.prepareStatement(query);
            ResultSet rs = pst.executeQuery();                  
            while(rs.next()){
            Film film =new Film();
            film.setIdfilmler(rs.getLong("idfilmler"));                        
            film.setYonetmen(this.getYonetmenDao().find(rs.getLong("yonetmen_idyonetmen")));
            film.setYapimci(this.getYapimciDao().find(rs.getLong("yapimci_idyapimci")));            
            film.setFilm_adi(rs.getString("film_adi"));
            film.setSure(rs.getInt("sure"));
            film.setYil(rs.getInt("yil"));
            film.setImdb_puani(rs.getDouble("ımdb_puani"));
            film.setButce(rs.getInt("butce"));
            film.setIcerik(rs.getString("icerik"));
                       
            
            ListeFilm.add(film);
            }

        } catch (SQLException ex) {
          System.out.println(ex.getMessage())  ;   
        }
        return ListeFilm;

    }
       
       @Override
       public void delete(Film film) {
      
        try {
            String query = "delete from filmler where idfilmler = ? ";
            PreparedStatement pst = connection.prepareStatement(query);
            pst.setLong(1, film.getIdfilmler());
            pst.executeUpdate(); 

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            Logger.getLogger(FilmDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
       
       
       @Override
       public void insert(Film film) {
        
        try {
            System.out.println("12");
            String query = "insert into filmler(yonetmen_idyonetmen,yapimci_idyapimci,film_adi,sure,yil,ımdb_puani,butce,icerik) values (?,?,?,?,?,?,?,?)";
            PreparedStatement pst = connection.prepareStatement(query);
         
            pst.setLong(1, film.getYonetmen().getIdyonetmen());
            pst.setLong(2, film.getYapimci().getIdyapimci());
            

            pst.setString(3, film.getFilm_adi());
            pst.setInt(4, film.getSure());
            
            pst.setInt(5, film.getYil());
            
            pst.setDouble(6, film.getImdb_puani());
            
            pst.setInt(7, film.getButce());
            pst.setString(8, film.getIcerik());
            
            System.out.println("13");
            pst.executeUpdate();
            System.out.println("14");
            
        } catch (SQLException ex) {
            Logger.getLogger(FilmDAO.class.getName()).log(Level.SEVERE, null, ex);

        }

    }
       
       @Override
       public void update(Film film) {
      
        try {
            String query = " update filmler "
                    +"  set yonetmen_idyonetmen   = ? "
                    +", yapimci_idyapimci = ? "        
                    +", film_adi = ? "
                    +", sure = ? "        
                    +", yil = ? "
                    +", ımdb_puani = ? "        
                    +", butce = ? "
                    +", icerik = ? "                     
                    +"where idfilmler  = ? ";
            PreparedStatement pst = connection.prepareStatement(query); 
            
            pst.setLong(1, film.getYonetmen().getIdyonetmen());
            pst.setLong(2, film.getYapimci().getIdyapimci()); 
            pst.setString(3, film.getFilm_adi());
            pst.setInt(4, film.getSure());
            pst.setInt(5, film.getYil());
            pst.setDouble(6, film.getImdb_puani());
            pst.setInt(7, film.getButce());
            pst.setString(8, film.getIcerik());           
            pst.setLong(9, film.getIdfilmler());
             
            pst.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(FilmDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
       
       
       public int record() {
        
        int a = 0;
        try {
            String selectQuery = "select * from filmler";
            PreparedStatement pst = this.getConnection().prepareStatement(selectQuery);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                a++;
            }
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return a;
    }

    @Override
    public List<Film> findAll(int page, int pageSize) {


        List<Film> filmList = new ArrayList<>();
        
        int start = ( page -1 ) * pageSize ;
        
        try {
            String selectQuery = "select * from filmler order by idfilmler limit "+pageSize+" offset "+start;
            PreparedStatement pst = this.getConnection().prepareStatement(selectQuery);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Film film = new Film();
                
                
            film.setIdfilmler(rs.getLong("idfilmler"));                        
            film.setYonetmen(this.getYonetmenDao().find(rs.getLong("yonetmen_idyonetmen")));
            film.setYapimci(this.getYapimciDao().find(rs.getLong("yapimci_idyapimci")));            
            film.setFilm_adi(rs.getString("film_adi"));
            film.setSure(rs.getInt("sure"));
            film.setYil(rs.getInt("yil"));
            film.setImdb_puani(rs.getDouble("ımdb_puani"));
            film.setButce(rs.getInt("butce"));
            film.setIcerik(rs.getString("icerik"));         
                                
                
                filmList.add(film);

                System.out.println(film);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }

        return filmList ;
        
    }
    
}
