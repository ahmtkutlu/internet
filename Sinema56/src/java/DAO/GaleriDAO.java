/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entity.Galeri;

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
public class GaleriDAO extends AbstractDAO implements DAO<Galeri>{
       Connector con = new Connector();
       Connection connection = con.connect();
       
       private FilmDAO FilmDao;

       
       
    public FilmDAO getFilmDao() {
         if(this.FilmDao==null){                
            this.FilmDao= new FilmDAO();            
            }        
        return FilmDao;
    }

    public void setFilmDao(FilmDAO FilmDao) {
        this.FilmDao = FilmDao;
    }
    
       
       @Override
        public Galeri find(Long id) {
        Galeri galeri = null;
        try {
            String query = "select * from galeri where idgaleri = ?";
            PreparedStatement pst = connection.prepareStatement(query);
            pst.setLong(1, id);
            ResultSet rs = pst.executeQuery();           
            rs.next();
            galeri = new Galeri();
            
            galeri.setIdgaleri(rs.getLong("idgaleri"));
            galeri.setFilm(this.getFilmDao().find(rs.getLong("idfilmler")));
            galeri.setResim(rs.getString("resim"));                 
                  


        } catch (SQLException ex) {
            System.out.println(ex.getMessage())  ;         }
        return galeri;

    }
       
       
       
       @Override
       public ArrayList<Galeri> findAll() {
         ArrayList<Galeri> ListeGaleri = new ArrayList();
        try {
            String query = "select * from galeri order by idgaleri";
            PreparedStatement pst = connection.prepareStatement(query);
            ResultSet rs = pst.executeQuery();                  
            while(rs.next()){
            Galeri galeri =new Galeri();
            
            galeri.setIdgaleri(rs.getLong("idgaleri"));
            galeri.setFilm(this.getFilmDao().find(rs.getLong("filmler_idfilmler")));
            galeri.setResim(rs.getString("resim"));                 
            galeri.setName(rs.getString("name"));
            galeri.setType(rs.getString("type"));
                    
            ListeGaleri.add(galeri);
            }

        } catch (SQLException ex) {
          System.out.println(ex.getMessage())  ;   
        }
        return ListeGaleri;

    }
       
       @Override
       public void delete(Galeri galeri) {
      
        try {
            String query = "delete from galeri where idgaleri = ? ";
            PreparedStatement pst = connection.prepareStatement(query);
            pst.setLong(1, galeri.getIdgaleri());
            pst.executeUpdate(); 

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            Logger.getLogger(GaleriDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
       
       
       @Override
       public void insert(Galeri galeri) {
        
        try {
            String query = "insert into galeri(filmler_idfilmler,resim,name,type) values (?,?,?,?)";
            PreparedStatement pst = connection.prepareStatement(query);
          
            pst.setLong(1, galeri.getFilm().getIdfilmler());
            pst.setString(2, galeri.getResim()); 
            pst.setString(3,galeri.getName());
            pst.setString(4,galeri.getType());
            pst.executeUpdate();
            
            Long id = null;
            ResultSet gk = pst.getGeneratedKeys();
            if (gk.next()) {
                id = gk.getLong(1);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(GaleriDAO.class.getName()).log(Level.SEVERE, null, ex);

        }

    }
       
       @Override
       public void update(Galeri galeri) {
      
        try {
            String query = " update galeri "
                    +"  set filmler_idfilmler  = ? "
                    +", resim = ? "                        
                    +"where idgaleri     = ? ";
            PreparedStatement pst = connection.prepareStatement(query);          
            pst.setLong(1, galeri.getFilm().getIdfilmler());
            pst.setString(2, galeri.getResim());    
            pst.setLong(3, galeri.getIdgaleri());
             
            pst.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(GaleriDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
       
       public int record() {
        
        int a = 0;
        try {
            String selectQuery = "select * from galeri";
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
    public List<Galeri> findAll(int page, int pageSize) {


        List<Galeri> galeriList = new ArrayList<>();
        
        int start = ( page -1 ) * pageSize ;
        
        try {
            String selectQuery = "select * from galeri order by idgaleri limit "+pageSize+" offset "+start;
            PreparedStatement pst = this.getConnection().prepareStatement(selectQuery);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Galeri galeri = new Galeri();
                
                
                galeri.setIdgaleri(rs.getLong("idgaleri"));
                galeri.setFilm(this.getFilmDao().find(rs.getLong("filmler_idfilmler")));
                galeri.setResim(rs.getString("resim")); 
                
                
                galeriList.add(galeri);

                System.out.println(galeri);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }

        return galeriList ;
        
    }
    
    
}
