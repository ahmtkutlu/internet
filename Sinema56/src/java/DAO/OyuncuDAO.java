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
public class OyuncuDAO extends AbstractDAO implements DAO<Oyuncu>{
       Connector con = new Connector();
       Connection connection = con.connect();
       
       
         @Override
        public Oyuncu find(Long id) {
        Oyuncu oyuncu = null;
        try {
            String query = "select * from oyuncu where idoyuncu = ?";
            PreparedStatement pst = connection.prepareStatement(query);
            pst.setLong(1, id);
            ResultSet rs = pst.executeQuery();           
            rs.next();
            oyuncu = new Oyuncu();
            oyuncu.setIdoyuncu(rs.getLong("idoyuncu"));
            oyuncu.setAd(rs.getString("ad"));
            oyuncu.setSoyad(rs.getString("soyad"));
            oyuncu.setYas(rs.getInt("yas"));
            oyuncu.setCinsiyet(rs.getString("cinsiyet"));

        } catch (SQLException ex) {
            System.out.println(ex.getMessage())  ;         }
        return oyuncu;

    }
         @Override
        public List<Oyuncu> findAll() {
         List<Oyuncu> ListeOyuncu = new ArrayList();
        try {
            String query = "select * from oyuncu order by idoyuncu";
            PreparedStatement pst = connection.prepareStatement(query);
            ResultSet rs = pst.executeQuery();                  
            while(rs.next()){
            Oyuncu oyuncu=new Oyuncu();
            
            oyuncu.setIdoyuncu(rs.getLong("idoyuncu"));
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
       
         @Override
        public void delete(Oyuncu oyuncu) {
      
        try {
            String query = "delete from oyuncu where idoyuncu = ? ";
            PreparedStatement pst = connection.prepareStatement(query);
            pst.setLong(1, oyuncu.getIdoyuncu());
            pst.executeUpdate(); 

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            Logger.getLogger(OyuncuDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
        
        
          @Override
       public void insert(Oyuncu oyuncu) {
        
        try {
            String query = "insert into oyuncu(ad,soyad,yas,cinsiyet) values (?,?,?,?)";
            PreparedStatement pst = connection.prepareStatement(query);
          
            pst.setString(1, oyuncu.getAd());
            pst.setString(2, oyuncu.getSoyad());
            pst.setInt(3, oyuncu.getYas());
            pst.setString(4, oyuncu.getCinsiyet());
            pst.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(DuyuruDAO.class.getName()).log(Level.SEVERE, null, ex);

        }

    }
        
        
        
          @Override
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
             pst.setLong(5, oyuncu.getIdoyuncu());
            pst.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(OyuncuDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        
        public int record() {
        
        int a = 0;
        try {
            String selectQuery = "select * from oyuncu";
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
    public List<Oyuncu> findAll(int page, int pageSize) {


        List<Oyuncu> oyuncuList = new ArrayList<>();
        
        int start = ( page -1 ) * pageSize ;
        
        try {
            String selectQuery = "select * from oyuncu order by idoyuncu limit "+pageSize+" offset "+start;
            PreparedStatement pst = this.getConnection().prepareStatement(selectQuery);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Oyuncu oyuncu = new Oyuncu();
               
                oyuncu.setIdoyuncu(rs.getLong("idoyuncu"));
                oyuncu.setAd(rs.getString("ad"));
                oyuncu.setSoyad(rs.getString("soyad"));
                oyuncu.setYas(rs.getInt("yas"));
                oyuncu.setCinsiyet(rs.getString("cinsiyet"));
                
                
                oyuncuList.add(oyuncu);

                System.out.println(oyuncu);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }

        return oyuncuList ;
        
    }
       
}
