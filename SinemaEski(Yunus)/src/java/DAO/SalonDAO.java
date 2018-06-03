/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entity.Salon;
import Entity.Sinema;
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
public class SalonDAO {
    
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
       
       
       
       
       public List<Salon> findAll() {
         List<Salon> ListeSalon = new ArrayList();
     
    
            
    
        try {
            String query = "select * from salon order by idsalon";
            PreparedStatement pst = connection.prepareStatement(query);
            ResultSet rs = pst.executeQuery();  
            
           // String query2="select sinema_ad from sinema where idsinema="+rs.getInt("sinema_idsinema");                  
            //PreparedStatement pst2 = connection.prepareStatement(query2);                              
            //ResultSet rs2 = pst2.executeQuery();
                         
            while(rs.next()){
            Salon salon =new Salon();                       
            salon.setIdsalon(rs.getInt("idsalon"));                      
            //salon.setSinemaAdıSalon(rs2.getString("sinema_ad"));
                      
            salon.setTitle(rs.getString("title"));        
            salon.setKapasite(rs.getInt("kapasite"));
            
            
            ListeSalon.add(salon);
            }

        } catch (SQLException ex) {
          System.out.println(ex.getMessage())  ;   
        }
        
     
        return ListeSalon;

    }
       
       
       public void delete(Salon salon) {
      
        try {
            String query = "delete from salon where idsalon = ? ";
            PreparedStatement pst = connection.prepareStatement(query);
            pst.setInt(1, salon.getIdsalon());
            pst.executeUpdate(); 

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            Logger.getLogger(SalonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
       
       
       
       public void insert(Salon salon) {
        
        try {
            String query = "insert into salon(title,kapasite) values (?,?)";
            PreparedStatement pst = connection.prepareStatement(query);
            //pst.setInt(1, salon.getIdsalon());
            //pst.setInt(2, salon.getSinema().getIdsinema());
            pst.setString(1, salon.getTitle());
            pst.setInt(2, salon.getKapasite());
            pst.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(SalonDAO.class.getName()).log(Level.SEVERE, null, ex);

        }

    }
       
       
       public void update(Salon salon) {
      
        try {
            String query = " update salon "
                    +"  set  "
                    +" title = ? "        
                    +", kapasite = ? "
                    +"where idsalon     = ? ";
            PreparedStatement pst = connection.prepareStatement(query); 
            
            pst.setString(1, salon.getTitle());
            pst.setInt(2, salon.getKapasite());
            pst.setInt(3, salon.getIdsalon());
             
            pst.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(SalonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
