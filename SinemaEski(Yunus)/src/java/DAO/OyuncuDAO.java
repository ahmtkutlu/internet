/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;


import Entity.Oyuncu;
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
public class OyuncuDAO {
       Connector con = new Connector();
       Connection connection = con.connect();
       
       
       
        public Oyuncu find(int id) {
        Oyuncu oyuncu = null;
        try {
            String query = "select * from oyuncu where idoyuncu = ?";
            PreparedStatement pst = connection.prepareStatement(query);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();           
            rs.next();
            oyuncu = new Oyuncu();
            oyuncu.setIdoyuncu(rs.getInt("idoyuncu"));
            oyuncu.setAd(rs.getString("ad"));
            oyuncu.setSoyad(rs.getString("soyad"));
            oyuncu.setYas(rs.getInt("yas"));
            oyuncu.setCinsiyet(rs.getString("cinsiyet"));

        } catch (SQLException ex) {
            System.out.println(ex.getMessage())  ;         }
        return oyuncu;

    }
       
        public List<Oyuncu> findAll() {
         List<Oyuncu> ListeOyuncu = new ArrayList();
        try {
            String query = "select * from oyuncu order by idoyuncu";
            PreparedStatement pst = connection.prepareStatement(query);
            ResultSet rs = pst.executeQuery();                  
            while(rs.next()){
            Oyuncu oyuncu=new Oyuncu();
            
            oyuncu.setIdoyuncu(rs.getInt("idoyuncu"));
            oyuncu.setAd(rs.getString("ad"));
            oyuncu.setSoyad(rs.getString("soyad"));
            oyuncu.setYas(rs.getInt("yas"));
            oyuncu.setCinsiyet(rs.getString("cinsiyet"));
            
            
            ListeOyuncu.add(oyuncu);
            }

        } catch (SQLException ex) {
          System.out.println(ex.getMessage())  ;   
        }
        return ListeOyuncu;

    }
       
       
        public void delete(Oyuncu oyuncu) {
      
        try {
            String query = "delete from oyuncu where idoyuncu = ? ";
            PreparedStatement pst = connection.prepareStatement(query);
            pst.setInt(1, oyuncu.getIdoyuncu());
            pst.executeUpdate(); 

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            Logger.getLogger(OyuncuDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
        
        
        
       public void insert(Oyuncu oyuncu) {
        
        try {
            String query = "insert into oyuncu values (?,?,?,?,?)";
            PreparedStatement pst = connection.prepareStatement(query);
            pst.setInt(1, oyuncu.getIdoyuncu());
            pst.setString(2, oyuncu.getAd());
            pst.setString(3, oyuncu.getSoyad());
            pst.setInt(4, oyuncu.getYas());
            pst.setString(5, oyuncu.getCinsiyet());
            pst.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(DuyuruDAO.class.getName()).log(Level.SEVERE, null, ex);

        }

    }
        
        
        
        
        public void update(Oyuncu oyuncu) {
      
        try {
            String query = " update oyuncu "
                    +"  set ad   = ? "
                    +", soyad = ? "
                    +", yas = ? "
                    +", cinsiyet = ? "
                    +"where idoyuncu     = ? ";
            PreparedStatement pst = connection.prepareStatement(query);          
            pst.setString(1, oyuncu.getAd());
            pst.setString(2, oyuncu.getSoyad());
            pst.setInt(3, oyuncu.getYas());
            pst.setString(4, oyuncu.getCinsiyet());
             pst.setInt(5, oyuncu.getIdoyuncu());
            pst.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(OyuncuDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
       
}
