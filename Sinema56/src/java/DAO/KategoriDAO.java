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
public class KategoriDAO extends AbstractDAO implements DAO<Kategori>{
      Connector con = new Connector();
      Connection connection = con.connect();
       
       
           @Override
        public Kategori find(Long id) {
        Kategori kategori = null;
        try {
            String query = "select * from kategori where idkategori = ?";
            PreparedStatement pst = connection.prepareStatement(query);
            pst.setLong(1, id);
            ResultSet rs = pst.executeQuery();           
            rs.next();
            kategori = new Kategori();
            kategori.setIdkategori(rs.getLong("idkategori"));
            kategori.setKategori_adi(rs.getString("kategori_adi")); 
     

        } catch (SQLException ex) {
            System.out.println(ex.getMessage())  ;         }
        return kategori;

    }
       
       
       
           @Override
       public List<Kategori> findAll() {
         List<Kategori> ListeKategori = new ArrayList();
        try {
            String query = "select * from kategori order by idkategori";
            PreparedStatement pst = connection.prepareStatement(query);
            ResultSet rs = pst.executeQuery();                  
            while(rs.next()){
            Kategori kategori =new Kategori();            
            kategori.setIdkategori(rs.getLong("idkategori"));
            kategori.setKategori_adi(rs.getString("kategori_adi"));     
            ListeKategori.add(kategori);
            }

        } catch (SQLException ex) {
          System.out.println(ex.getMessage())  ;   
        }
        return ListeKategori;

    }
       
           @Override
       public void delete(Kategori kategori) {
      
        try {
            String query = "delete from kategori where idkategori = ? ";
            PreparedStatement pst = connection.prepareStatement(query);
            pst.setLong(1, kategori.getIdkategori());
            pst.executeUpdate(); 

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            Logger.getLogger(KategoriDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
       
    @Override
       public void insert(Kategori kategori) {
        
        try {
            
            System.out.println("deneme1");
            String query = "insert into kategori(kategori_adi) values (?)";
            System.out.println("deneme2");
            PreparedStatement pst = connection.prepareStatement(query);
          System.out.println("deneme3");
            pst.setString(1,kategori.getKategori_adi());
            System.out.println("deneme4");
            pst.executeUpdate();
            System.out.println("deneme5");
        } catch (SQLException ex) {
            Logger.getLogger(KategoriDAO.class.getName()).log(Level.SEVERE, null, ex);

        }

    }
       
           @Override
       public void update(Kategori kategori) {
      
        try {
            String query = " update kategori "
                    +"  set kategori_adi   = ? "                 
                    +"where idkategori   = ? ";
            PreparedStatement pst = connection.prepareStatement(query);          
            pst.setString(1, kategori.getKategori_adi());
            pst.setLong(2, kategori.getIdkategori());
  
            pst.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(KategoriDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
       
       public int record() {
        
        int a = 0;
        try {
            String selectQuery = "select * from kategori";
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
    public List<Kategori> findAll(int page, int pageSize) {


        List<Kategori> kategoriList = new ArrayList<>();
        
        int start = ( page -1 ) * pageSize ;
        
        try {
            String selectQuery = "select * from kategori order by idkategori limit "+pageSize+" offset "+start;
            PreparedStatement pst = this.getConnection().prepareStatement(selectQuery);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Kategori kategori = new Kategori();
                
                 kategori.setIdkategori(rs.getLong("idkategori"));
                 kategori.setKategori_adi(rs.getString("kategori_adi")); 
                
                kategoriList.add(kategori);

                System.out.println(kategori);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }

        return kategoriList ;
        
    }
    
}
