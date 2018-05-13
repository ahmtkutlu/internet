/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entity.Yonetmen;
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
public class YonetmenDAO extends AbstractDAO implements DAO<Yonetmen>{
      Connector con = new Connector();
      Connection connection = con.connect();
       
       
        @Override
        public Yonetmen find(Long id) {
        Yonetmen yonetmen = null;
        try {
            String query = "select * from yonetmen where idyonetmen = ?";
            PreparedStatement pst = connection.prepareStatement(query);
            pst.setLong(1, id);
            ResultSet rs = pst.executeQuery();           
            rs.next();
            yonetmen = new Yonetmen();
            yonetmen.setIdyonetmen(rs.getLong("idyonetmen"));
            yonetmen.setYonetmen_adi(rs.getString("yonetmen_adi"));
            yonetmen.setYonetmen_soyadi(rs.getString("yonetmen_soyadi"));        
            yonetmen.setYonetmen_cinsiyet(rs.getString("yonetmen_cinsiyet"));

        } catch (SQLException ex) {
            System.out.println(ex.getMessage())  ;         }
        return yonetmen;

    }
       
       
       
        @Override
       public List<Yonetmen> findAll() {
         List<Yonetmen> ListeYonetmen = new ArrayList();
        try {
            String query = "select * from yonetmen order by idyonetmen";
            PreparedStatement pst = connection.prepareStatement(query);
            ResultSet rs = pst.executeQuery();                  
            while(rs.next()){
            Yonetmen yonetmen =new Yonetmen();
            
            yonetmen.setIdyonetmen(rs.getLong("idyonetmen"));
            yonetmen.setYonetmen_adi(rs.getString("yonetmen_adi"));
            yonetmen.setYonetmen_soyadi(rs.getString("yonetmen_soyadi"));        
            yonetmen.setYonetmen_cinsiyet(rs.getString("yonetmen_cinsiyet"));
            
            
            ListeYonetmen.add(yonetmen);
            }

        } catch (SQLException ex) {
          System.out.println(ex.getMessage())  ;   
        }
        return ListeYonetmen;

    }
       
        @Override
       public void delete(Yonetmen yonetmen) {
      
        try {
            String query = "delete from yonetmen where idyonetmen = ? ";
            PreparedStatement pst = connection.prepareStatement(query);
            pst.setLong(1, yonetmen.getIdyonetmen());
            pst.executeUpdate(); 

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            Logger.getLogger(YonetmenDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
       
       
        @Override
       public void insert(Yonetmen yonetmen) {
        
        try {
            String query = "insert into yonetmen(yonetmen_adi,yonetmen_soyadi,yonetmen_cinsiyet) values (?,?,?)";
            PreparedStatement pst = connection.prepareStatement(query);

            pst.setString(1, yonetmen.getYonetmen_adi());
            pst.setString(2, yonetmen.getYonetmen_soyadi());
            pst.setString(3, yonetmen.getYonetmen_cinsiyet());
            pst.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(YonetmenDAO.class.getName()).log(Level.SEVERE, null, ex);

        }

    }
       
        @Override
       public void update(Yonetmen yonetmen) {
      
        try {
            String query = " update yonetmen "
                    +"  set yonetmen_adi   = ? "
                    +", yonetmen_soyadi = ? "        
                    +", yonetmen_cinsiyet = ? "
                    +"where idyonetmen     = ? ";
            PreparedStatement pst = connection.prepareStatement(query);          
            pst.setString(1, yonetmen.getYonetmen_adi());
            pst.setString(2, yonetmen.getYonetmen_soyadi());
            pst.setString(3, yonetmen.getYonetmen_cinsiyet());
             pst.setLong(4, yonetmen.getIdyonetmen());
            pst.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(YonetmenDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
       
       public int record() {
        
        int a = 0;
        try {
            String selectQuery = "select * from yonetmen";
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
    public List<Yonetmen> findAll(int page, int pageSize) {
        List<Yonetmen> yonetmenList = new ArrayList<>();
        
        int start = ( page -1 ) * pageSize ;
        
        try {
            String query = "select * from yonetmen order by idyonetmen limit "+pageSize+" offset "+start;
            PreparedStatement pst = this.getConnection().prepareStatement(query);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Yonetmen yonetmen = new Yonetmen();
                yonetmen.setIdyonetmen(rs.getLong("idyonetmen"));
                yonetmen.setYonetmen_adi(rs.getString("yonetmen_adi"));
                yonetmen.setYonetmen_soyadi(rs.getString("yonetmen_soyadi"));        
                yonetmen.setYonetmen_cinsiyet(rs.getString("yonetmen_cinsiyet"));
                
                yonetmenList.add(yonetmen);
                System.out.println(yonetmen);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return yonetmenList ;
        
    }
    
}
