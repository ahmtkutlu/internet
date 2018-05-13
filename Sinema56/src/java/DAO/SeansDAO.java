/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entity.Seans;
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
public class SeansDAO extends AbstractDAO implements DAO<Seans>{
    
      Connector con = new Connector();
      Connection connection = con.connect();
       
       private SalonDAO SalonDao;
       private FilmDAO FilmDao;

    public SalonDAO getSalonDao() {
        
        if(this.SalonDao==null){                
            this.SalonDao= new SalonDAO();            
            }
        return SalonDao;
    }

    public void setSalonDao(SalonDAO SalonDao) {
        this.SalonDao = SalonDao;
    }

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
        public Seans find(Long id) {
        Seans seans = null;
        try {
            String query = "select * from seans where idseans = ?";
            PreparedStatement pst = connection.prepareStatement(query);
            pst.setLong(1, id);
            ResultSet rs = pst.executeQuery();           
            rs.next();
            seans = new Seans();
            
            
            seans.setIdseans(rs.getLong("idseans"));
            seans.setSalon(this.getSalonDao().find(rs.getLong("salon_idsalon")));

            seans.setSaat(rs.getInt("saat"));        
       
          
            seans.setFilm(this.getFilmDao().find(rs.getLong("filmler_idfilmler")));

        } catch (SQLException ex) {
            System.out.println(ex.getMessage())  ;         }
        return seans;

    }
                           
       @Override
       public List<Seans> findAll() {
         List<Seans> ListeSeans = new ArrayList();
        try {
            String query = "select * from seans order by idseans";
            PreparedStatement pst = connection.prepareStatement(query);
            ResultSet rs = pst.executeQuery();                  
            while(rs.next()){
            Seans seans =new Seans();
            
            seans.setIdseans(rs.getLong("idseans"));
            seans.setSalon(this.getSalonDao().find(rs.getLong("salon_idsalon")));
  
            seans.setSaat(rs.getInt("saat"));        
       
           
            seans.setFilm(this.getFilmDao().find(rs.getLong("filmler_idfilmler")));
            
            ListeSeans.add(seans);
            }

        } catch (SQLException ex) {
          System.out.println(ex.getMessage())  ;   
        }
        return ListeSeans;

    }
       
       @Override
       public void delete(Seans seans) {
      
        try {
            String query = "delete from seans where idseans = ? ";
            PreparedStatement pst = connection.prepareStatement(query);
            pst.setLong(1, seans.getIdseans());
            pst.executeUpdate(); 

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            Logger.getLogger(SeansDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
       
       
       @Override
       public void insert(Seans seans) {
        
        try {
            String query = "insert into seans(salon_idsalon,saat,filmler_idfilmler) values (?,?,?)";
            PreparedStatement pst = connection.prepareStatement(query);
                               
            pst.setLong(1, seans.getSalon().getIdsalon());
            pst.setDouble(2, seans.getSaat());            
            pst.setLong(3, seans.getFilm().getIdfilmler());
            pst.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(SeansDAO.class.getName()).log(Level.SEVERE, null, ex);

        }

    }
       
       @Override
       public void update(Seans seans) {
      
        try {
            String query = " update seans "
                    +"  set salon_idsalon   = ? "
                    +", saat = ? "        
                    +", filmler_idfilmler = ? "
                    +"where idseans     = ? ";
            PreparedStatement pst = connection.prepareStatement(query); 
            
            
            pst.setLong(1, seans.getSalon().getIdsalon());
            pst.setDouble(2, seans.getSaat());
            pst.setLong(3, seans.getFilm().getIdfilmler());
            pst.setLong(4, seans.getIdseans());
             
             
            pst.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(SeansDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
       
       public int record() {
        
        int a = 0;
        try {
            String selectQuery = "select * from seans";
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
    public List<Seans> findAll(int page, int pageSize) {


        List<Seans> seansList = new ArrayList<>();
        
        int start = ( page -1 ) * pageSize ;
        
        try {
            String selectQuery = "select * from seans order by idseans limit "+pageSize+" offset "+start;
            PreparedStatement pst = this.getConnection().prepareStatement(selectQuery);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                
            Seans seans = new Seans();                              
            seans.setIdseans(rs.getLong("idseans"));
            seans.setSalon(this.getSalonDao().find(rs.getLong("salon_idsalon")));  
            seans.setSaat(rs.getInt("saat"));                          
            seans.setFilm(this.getFilmDao().find(rs.getLong("filmler_idfilmler")));
                
            seansList.add(seans);
            System.out.println(seans);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return seansList ;
        
    }
    
    
}
