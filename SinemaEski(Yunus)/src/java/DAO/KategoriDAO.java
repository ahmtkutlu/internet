/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entity.Kategori;
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
public class KategoriDAO {
      Connector con = new Connector();
      Connection connection = con.connect();
       
       
       
        public Kategori find(int id) {
        Kategori kategori = null;
        try {
            String query = "select * from kategori where idkategori = ?";
            PreparedStatement pst = connection.prepareStatement(query);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();           
            rs.next();
            kategori = new Kategori();
            kategori.setIdkategori(rs.getInt("idkategori"));
            kategori.setKategori_adi(rs.getString("kategori_adi")); 
     

        } catch (SQLException ex) {
            System.out.println(ex.getMessage())  ;         }
        return kategori;

    }
       
       
       
       
       public List<Kategori> findAll() {
         List<Kategori> ListeKategori = new ArrayList();
        try {
            String query = "select * from kategori order by idkategori";
            PreparedStatement pst = connection.prepareStatement(query);
            ResultSet rs = pst.executeQuery();                  
            while(rs.next()){
            Kategori kategori =new Kategori();            
            kategori.setIdkategori(rs.getInt("idkategori"));
            kategori.setKategori_adi(rs.getString("kategori_adi"));     
            ListeKategori.add(kategori);
            }

        } catch (SQLException ex) {
          System.out.println(ex.getMessage())  ;   
        }
        return ListeKategori;

    }
       
       
       public void delete(Kategori kategori) {
      
        try {
            String query = "delete from kategori where idkategori = ? ";
            PreparedStatement pst = connection.prepareStatement(query);
            pst.setInt(1, kategori.getIdkategori());
            pst.executeUpdate(); 

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            Logger.getLogger(KategoriDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
       

       public void insert(Kategori kategori) {
        
        try {
            String query = "insert into kategori values (?,?)";
            PreparedStatement pst = connection.prepareStatement(query);
            pst.setInt(1, kategori.getIdkategori());
            pst.setString(2, kategori.getKategori_adi());
            
            pst.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(KategoriDAO.class.getName()).log(Level.SEVERE, null, ex);

        }

    }
       
       
       public void update(Kategori kategori) {
      
        try {
            String query = " update kategori "
                    +"  set kategori_adi   = ? "                 
                    +"where idkategori   = ? ";
            PreparedStatement pst = connection.prepareStatement(query);          
            pst.setString(1, kategori.getKategori_adi());
            pst.setInt(2, kategori.getIdkategori());
  
            pst.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(KategoriDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
