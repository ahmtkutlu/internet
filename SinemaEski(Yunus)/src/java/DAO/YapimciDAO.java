/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entity.Yapimci;
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
public class YapimciDAO {
      Connector con = new Connector();
      Connection connection = con.connect();
       
       
       
        public Yapimci find(int id) {
        Yapimci yapimci = null;
        try {
            String query = "select * from yapimci where idyapimci = ?";
            PreparedStatement pst = connection.prepareStatement(query);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();           
            rs.next();
            yapimci = new Yapimci();          
            
            yapimci.setIdyapimci(rs.getInt("idyapimci"));
            yapimci.setYapimci_adi(rs.getString("yapimci_adi"));
            yapimci.setKurulus_yili(rs.getInt("kurulus_yili"));        
            yapimci.setMail(rs.getString("mail"));

        } catch (SQLException ex) {
            System.out.println(ex.getMessage())  ;         }
        return yapimci;

    }
       
       
       
       
       public List<Yapimci> findAll() {
         List<Yapimci> ListeYapimci = new ArrayList();
        try {
            String query = "select * from yapimci order by idyapimci";
            PreparedStatement pst = connection.prepareStatement(query);
            ResultSet rs = pst.executeQuery();                  
            while(rs.next()){
            Yapimci yapimci =new Yapimci();
            
            yapimci.setIdyapimci(rs.getInt("idyapimci"));
            yapimci.setYapimci_adi(rs.getString("yapimci_adi"));
            yapimci.setKurulus_yili(rs.getInt("kurulus_yili"));        
            yapimci.setMail(rs.getString("mail"));
            
            
            ListeYapimci.add(yapimci);
            }

        } catch (SQLException ex) {
          System.out.println(ex.getMessage())  ;   
        }
        return ListeYapimci;

    }
       
       
       public void delete(Yapimci yapimci) {
      
        try {
            String query = "delete from yapimci where idyapimci = ? ";
            PreparedStatement pst = connection.prepareStatement(query);
            pst.setInt(1, yapimci.getIdyapimci());
            pst.executeUpdate(); 

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            Logger.getLogger(YapimciDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
       
       
       
       public void insert(Yapimci yapimci) {
        
        try {
            String query = "insert into yapimci values (?,?,?,?)";
            PreparedStatement pst = connection.prepareStatement(query);
            pst.setInt(1, yapimci.getIdyapimci());
            pst.setString(2, yapimci.getYapimci_adi());
            pst.setInt(3, yapimci.getKurulus_yili());
            pst.setString(4, yapimci.getMail());
            pst.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(YapimciDAO.class.getName()).log(Level.SEVERE, null, ex);

        }

    }
       
       
       public void update(Yapimci yapimci) {
      
        try {
            String query = " update yapimci "
                    +"  set yapimci_adi   = ? "
                    +", kurulus_yili = ? "        
                    +", mail = ? "
                    +"where idyapimci     = ? ";
            PreparedStatement pst = connection.prepareStatement(query);          
            pst.setString(1, yapimci.getYapimci_adi());
            pst.setInt(2, yapimci.getKurulus_yili());
            pst.setString(3, yapimci.getMail());
             pst.setInt(4, yapimci.getIdyapimci());
            pst.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(YapimciDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
