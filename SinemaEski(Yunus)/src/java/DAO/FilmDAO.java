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
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Kutlu
 */
public class FilmDAO {
    
      Connector con = new Connector();
      Connection connection = con.connect();
       
       
       
        public Salon find(int id) {
        Salon salon = null;
        try {
            String query = "select * from salon where idsalon = ?";
            PreparedStatement pst = connection.prepareStatement(query);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();           
            rs.next();
            salon = new Salon();
            salon.setIdsalon(rs.getInt("idsalon"));
            //salon.setSinema((rs.getInt("sinema_idsinema")));           
            salon.setTitle(rs.getString("title"));        
            salon.setKapasite(rs.getInt("kapasite"));

        } catch (SQLException ex) {
            System.out.println(ex.getMessage())  ;
        }
        return salon;

    }
       
       
       
       
       public List<Film> findAll() {
         List<Film> ListeSalon = new ArrayList();
        try {
            String query = "select * from salon order by idsalon";
            PreparedStatement pst = connection.prepareStatement(query);
            ResultSet rs = pst.executeQuery();                  
            while(rs.next()){
            Salon salon =new Salon();
            
            salon.setIdsalon(rs.getInt("idsalon"));
            //salon.setSinema((rs.getInt("sinema_idsinema")));           
            salon.setTitle(rs.getString("title"));        
            salon.setKapasite(rs.getInt("kapasite"));
            
            
            ListeSalon.add(salon);
            }

        } catch (SQLException ex) {
          System.out.println(ex.getMessage())  ;   
        }
        return ListeSalon;

    }
       
       
       public void delete(Film film) {
      
        try {
            String query = "delete from filmler where idfilmler = ? ";
            PreparedStatement pst = connection.prepareStatement(query);
            pst.setInt(1, film.getIdfilmler());
            pst.executeUpdate(); 

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            Logger.getLogger(SalonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
       
       
       
       public void insert(Film film) {
        
        try {
            String query = "insert into filmler values (?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement pst = connection.prepareStatement(query);
            pst.setInt(1, film.getIdsalon());
            pst.setInt(2, film.getSinema().getIdsinema());
            pst.setInt(3, film.getTitle());
            
            pst.setString(4, film.getKapasite());
            pst.setInt(5, film.getIdsalon());
            
            pst.setInt(6, film.getSinema().getIdsinema());
            
            pst.setDouble(7, film.getTitle());
            
            pst.setInt(8, film.getKapasite());
            pst.setString(9, film.getIdsalon());
            
            pst.setString(10, film.getSinema().getIdsinema());
         
            
            
            
            pst.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(FilmDAO.class.getName()).log(Level.SEVERE, null, ex);

        }

    }
       
       
       public void update(Film film) {
      
        try {
            String query = " update salon "
                    +"  set sinema_idsinema   = ? "
                    +", title = ? "        
                    +", kapasite = ? "
                    +"where idsalon     = ? ";
            PreparedStatement pst = connection.prepareStatement(query); 
            
            pst.setInt(1, salon.getSinema().getIdsinema());
            pst.setString(2, salon.getTitle());
            pst.setInt(3, salon.getKapasite());
            pst.setInt(4, salon.getIdsalon());
             
            pst.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(SalonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
