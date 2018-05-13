/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

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
public class SinemaDAO extends AbstractDAO implements DAO <Sinema>{
    
   
       
        @Override
        public Sinema find(Long id) {
        Sinema sinema = null;
        try {
            String query = "select * from sinema where idsinema = ?";
            PreparedStatement pst = this.getConnection().prepareStatement(query);
            pst.setLong(1, id);
            ResultSet rs = pst.executeQuery();           
            rs.next();
            sinema = new Sinema();
            sinema.setIdsinema(rs.getLong("idsinema"));
            sinema.setKurulus_yili(rs.getInt("kurulus_yili"));
            sinema.setSinemaAd(rs.getString("sinema_ad"));
            

        } catch (SQLException ex) {
            System.out.println(ex.getMessage())  ;         }
        return sinema;

    }
       
       
       
        @Override
       public List<Sinema> findAll() {
         List<Sinema> ListeSinema = new ArrayList();
        try {
            String query = "select * from sinema order by idsinema";
            PreparedStatement pst = this.getConnection().prepareStatement(query);
            ResultSet rs = pst.executeQuery();                  
            while(rs.next()){
            Sinema sinema =new Sinema();            
            sinema.setIdsinema(rs.getLong("idsinema"));
            sinema.setKurulus_yili(rs.getInt("kurulus_yili"));
            sinema.setSinemaAd(rs.getString("sinema_ad"));
                                  
            ListeSinema.add(sinema);
            }

        } catch (SQLException ex) {
          System.out.println(ex.getMessage())  ;   
        }
        return ListeSinema;

    }
       
        @Override
       public void delete(Sinema sinema) {
      
        try {
            String query = "delete from sinema where idsinema = ? ";
            PreparedStatement pst = this.getConnection().prepareStatement(query);
            pst.setLong(1, sinema.getIdsinema());
            pst.executeUpdate(); 

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            Logger.getLogger(SinemaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
       
       
        @Override
       public void insert(Sinema sinema) {
        
        try {
            String query = "insert into sinema(kurulus_yili,sinema_ad) values (?,?)";
            PreparedStatement pst = this.getConnection().prepareStatement(query);    
            pst.setInt(1, sinema.getKurulus_yili());
            pst.setString(2, sinema.getSinemaAd());
            
            pst.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(SinemaDAO.class.getName()).log(Level.SEVERE, null, ex);

        }

    }
       //kayıt sayısı
       public int record() {
        
        int a = 0;
        try {
            String query = "select * from sinema";
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
       
       
        @Override
       public void update(Sinema sinema) {
      
        try {
            String query = " update sinema "
                    +"  set kurulus_yili   = ? "
                    +", sinema_ad = ? "
                    +"where idsinema     = ? ";
            PreparedStatement pst = this.getConnection().prepareStatement(query);          
            pst.setInt(1, sinema.getKurulus_yili());
            pst.setString(2, sinema.getSinemaAd());
            pst.setLong(3, sinema.getIdsinema());
            
            
            pst.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(SinemaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
       
       @Override
    public List<Sinema> findAll(int page, int pageSize) {


        List<Sinema> sinemaList = new ArrayList<>();
        
        int start = ( page -1 ) * pageSize ;
        
        try {
            String query = "select * from sinema order by idsinema limit "+pageSize+" offset "+start;
            PreparedStatement pst = this.getConnection().prepareStatement(query);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Sinema sinema = new Sinema();
               
                 sinema.setIdsinema(rs.getLong("idsinema"));
                 sinema.setKurulus_yili(rs.getInt("kurulus_yili"));
                 sinema.setSinemaAd(rs.getString("sinema_ad"));
                
                sinemaList.add(sinema);

                System.out.println(sinema);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }

        return sinemaList ;
        
    }
       
    
}
