/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entity.Duyuru;
import Utility.Connector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Kutlu
 */
public class DuyuruDAO {
    Connector con = new Connector();
    Connection connection = con.connect();
    
    
        public Duyuru find(int id) {
        Duyuru duyuru = null;
        try {
            String query = "select * from duyuru where idduyuru = ?";
            PreparedStatement pst = connection.prepareStatement(query);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();           
            rs.next();
            duyuru = new Duyuru();
            duyuru.setDuyuru_id(rs.getInt("idduyuru"));
            duyuru.setTitle(rs.getString("baslik"));
            duyuru.setIcerik(rs.getString("icerik"));
            duyuru.setBaslangicTarihi(rs.getDate("baslangicTarihi"));
            duyuru.setBitisTarihi(rs.getDate("bitisTarihi"));

        } catch (SQLException ex) {
            System.out.println(ex.getMessage())  ;         }
        return duyuru;

    }
    
    public List<Duyuru> findAll() {
         List<Duyuru> ListeDuyuru = new ArrayList();
        try {
            String query = "select * from duyuru order by idduyuru";
            PreparedStatement pst = connection.prepareStatement(query);
            ResultSet rs = pst.executeQuery();                  
            while(rs.next()){
            Duyuru duyuru=new Duyuru();
            duyuru = new Duyuru();
            duyuru.setDuyuru_id(rs.getInt("idduyuru"));
            duyuru.setTitle(rs.getString("baslik"));
            duyuru.setIcerik(rs.getString("icerik"));
            duyuru.setBaslangicTarihi(rs.getDate("baslangicTarihi"));
            duyuru.setBitisTarihi(rs.getDate("bitisTarihi"));
            ListeDuyuru.add(duyuru);
            }

        } catch (SQLException ex) {
          System.out.println(ex.getMessage())  ;   
        }
        return ListeDuyuru;

    }
    
     public void insert(Duyuru duyuru) {
        
        try {
            String query = "insert into duyuru values (?,?,?,?,?)";
            PreparedStatement pst = connection.prepareStatement(query);
            pst.setInt(1, duyuru.getDuyuru_id());
            pst.setString(2, duyuru.getTitle());
            pst.setString(3, duyuru.getIcerik());
            pst.setDate(4, (Date) duyuru.getBaslangicTarihi());
            pst.setDate(5, (Date) duyuru.getBitisTarihi());
            pst.executeUpdate();
            
        } catch (SQLException ex) {
            // System.out.println(ex.getMessage());
            Logger.getLogger(DuyuruDAO.class.getName()).log(Level.SEVERE, null, ex);

        }

    }
     
      public void delete(Duyuru duyuru) {
      
        try {
            String query = "delete from duyuru where idduyuru = ? ";
            PreparedStatement pst = connection.prepareStatement(query);
            pst.setInt(1, duyuru.getDuyuru_id());
            pst.executeUpdate(); 

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            Logger.getLogger(DuyuruDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
      
       public void update(Duyuru duyuru) {
      
        try {
            String query = " update duyuru "
                    +"  set baslik   = ? "
                    +", icerik = ? "
                    +", baslangicTarihi = ? "
                    +", bitisTarihi = ? "
                    +"where idduyuru     = ? ";
            PreparedStatement pst = connection.prepareStatement(query);          
            pst.setString(1, duyuru.getTitle());
            pst.setString(2, duyuru.getIcerik());
            pst.setDate(3,  (Date) duyuru.getBaslangicTarihi());
            pst.setDate(4,  (Date) duyuru.getBitisTarihi());
             pst.setInt(5, duyuru.getDuyuru_id());
            pst.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(DuyuruDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
