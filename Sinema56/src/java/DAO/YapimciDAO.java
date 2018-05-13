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
public class YapimciDAO extends AbstractDAO implements DAO<Yapimci>{
    
      Connector con = new Connector();
      Connection connection = con.connect();
       
       
       @Override
        public Yapimci find(Long id) {
        Yapimci yapimci = null;
        try {
            String query = "select * from yapimci where idyapimci = ?";
            PreparedStatement pst = connection.prepareStatement(query);
            pst.setLong(1, id);
            ResultSet rs = pst.executeQuery();           
            rs.next();
            yapimci = new Yapimci();          
            
            yapimci.setIdyapimci(rs.getLong("idyapimci"));
            yapimci.setYapimci_adi(rs.getString("yapimci_adi"));
            yapimci.setKurulus_yili(rs.getInt("kurulus_yili"));        
            yapimci.setMail(rs.getString("mail"));

        } catch (SQLException ex) {
            System.out.println(ex.getMessage())  ;         }
        return yapimci;

    }
       
       
       
       @Override
       public List<Yapimci> findAll() {
         List<Yapimci> ListeYapimci = new ArrayList();
        try {
            String query = "select * from yapimci order by idyapimci";
            PreparedStatement pst = connection.prepareStatement(query);
            ResultSet rs = pst.executeQuery();                  
            while(rs.next()){
            Yapimci yapimci =new Yapimci();
            
            yapimci.setIdyapimci(rs.getLong("idyapimci"));
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
       
       @Override
       public void delete(Yapimci yapimci) {
      
        try {
            String query = "delete from yapimci where idyapimci = ? ";
            PreparedStatement pst = connection.prepareStatement(query);
            pst.setLong(1, yapimci.getIdyapimci());
            pst.executeUpdate(); 

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            Logger.getLogger(YapimciDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
         
       
      @Override
       public void insert(Yapimci yapimci) {
        
        try {
            String query = "insert into yapimci(yapimci_adi,kurulus_yili,mail) values (?,?,?)";
            PreparedStatement pst = connection.prepareStatement(query);  
            pst.setString(1, yapimci.getYapimci_adi());
            pst.setInt(2, yapimci.getKurulus_yili());
            pst.setString(3, yapimci.getMail());
            pst.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(YapimciDAO.class.getName()).log(Level.SEVERE, null, ex);

        }

    }
       
        @Override
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
            pst.setLong(4, yapimci.getIdyapimci());
            pst.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(YapimciDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
       
       
       
       @Override
        public List<Yapimci> findAll(int page, int pageSize) {


        List<Yapimci> yapimciList = new ArrayList<>();
        
        int start = ( page -1 ) * pageSize ;
        
        try {
            String query = "select * from yapimci order by idyapimci limit "+pageSize+" offset "+start;
            PreparedStatement pst = this.getConnection().prepareStatement(query);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Yapimci yapimci = new Yapimci();
                yapimci.setIdyapimci(rs.getLong("idyapimci"));
                yapimci.setYapimci_adi(rs.getString("yapimci_adi"));
                yapimci.setKurulus_yili(rs.getInt("kurulus_yili"));        
                yapimci.setMail(rs.getString("mail"));
                yapimciList.add(yapimci);

                System.out.println(yapimci);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }

        return yapimciList ;
        
    }
        
         public int record() {
        
        int a = 0;
        try {
            String query = "select * from yapimci";
            PreparedStatement pst = this.getConnection().prepareStatement(query);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                a++;
            }
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return a;
    }
       
    
}
