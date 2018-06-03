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
public class SeansDAO {
    
      Connector con = new Connector();
      Connection connection = con.connect();
       
       
       
        public Seans find(int id) {
        Seans seans = null;
        try {
            String query = "select * from seans where idseans = ?";
            PreparedStatement pst = connection.prepareStatement(query);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();           
            rs.next();
            seans = new Seans();
            
            
            seans.setIdseans(rs.getInt("idseans"));
            //seans.setSalon((rs.getInt("salon_idsalon")));
            seans.setSaat(rs.getInt("saat"));        
            //seans.setFilm((rs.getInt("filmler_idfilmler")));
            

        } catch (SQLException ex) {
            System.out.println(ex.getMessage())  ;         }
        return seans;

    }
       
       
       
       
       public List<Seans> findAll() {
         List<Seans> ListeSeans = new ArrayList();
        try {
            String query = "select * from seans order by idseans";
            PreparedStatement pst = connection.prepareStatement(query);
            ResultSet rs = pst.executeQuery();                  
            while(rs.next()){
            Seans seans =new Seans();
            
            seans.setIdseans(rs.getInt("idseans"));
            //seans.setSalon((rs.getInt("salon_idsalon")));
            seans.setSaat(rs.getInt("saat"));        
            //seans.setFilm((rs.getInt("filmler_idfilmler")));
            
            
            ListeSeans.add(seans);
            }

        } catch (SQLException ex) {
          System.out.println(ex.getMessage())  ;   
        }
        return ListeSeans;

    }
       
       
       public void delete(Seans seans) {
      
        try {
            String query = "delete from seans where idseans = ? ";
            PreparedStatement pst = connection.prepareStatement(query);
            pst.setInt(1, seans.getIdseans());
            pst.executeUpdate(); 

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            Logger.getLogger(SeansDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
       
       
       
       public void insert(Seans seans) {
        
        try {
            String query = "insert into seans values (?,?,?,?)";
            PreparedStatement pst = connection.prepareStatement(query);
            pst.setInt(1, seans.getIdseans());                        
            pst.setInt(2, seans.getSalon().getIdsalon());
            pst.setDouble(3, seans.getSaat());            
            pst.setInt(4, seans.getFilm().getIdfilmler());
            pst.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(SeansDAO.class.getName()).log(Level.SEVERE, null, ex);

        }

    }
       
       
       public void update(Seans seans) {
      
        try {
            String query = " update seans "
                    +"  set salon_idsalon   = ? "
                    +", saat = ? "        
                    +", filmler_idfilmler = ? "
                    +"where idseans     = ? ";
            PreparedStatement pst = connection.prepareStatement(query); 
            
            
            pst.setInt(1, seans.getSalon().getIdsalon());
            pst.setDouble(2, seans.getSaat());
            pst.setInt(3, seans.getFilm().getIdfilmler());
            pst.setInt(4, seans.getIdseans());
             
             
            pst.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(SeansDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
