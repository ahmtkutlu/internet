/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entity.Yorum;
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
public class YorumDAO {
      Connector con = new Connector();
      Connection connection = con.connect();
       
       
       
        public Yorum find(int id) {
        Yorum yorum = null;
        try {
            String query = "select * from yorum where idyorum = ?";
            PreparedStatement pst = connection.prepareStatement(query);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();           
            rs.next();
            yorum = new Yorum();
            
            yorum.setIdyorum(rs.getInt("idyorum"));          
            //yorum.setFilm((rs.getInt("filmler_idfilmler")));        
            //yorum.setUser((rs.getInt("user_iduser")));
            yorum.setIcerik(rs.getString("icerik"));        
            yorum.setYorum_basligi(rs.getString("yorum_basligi"));
            yorum.setYorum_tarihi(rs.getDate("yorum_tarihi"));
            

        } catch (SQLException ex) {
            System.out.println(ex.getMessage())  ;
        }
        return yorum;

    }
       
       
       
       
       public List<Yorum> findAll() {
         List<Yorum> ListeYorum = new ArrayList();
        try {
            String query = "select * from yorum order by idyorum";
            PreparedStatement pst = connection.prepareStatement(query);
            ResultSet rs = pst.executeQuery();                  
            while(rs.next()){
            Yorum yorum =new Yorum();
            
            yorum.setIdyorum(rs.getInt("idyorum"));          
            //yorum.setFilm((rs.getInt("filmler_idfilmler")));        
            //yorum.setUser((rs.getInt("user_iduser")));
            yorum.setIcerik(rs.getString("icerik"));        
            yorum.setYorum_basligi(rs.getString("yorum_basligi"));
            yorum.setYorum_tarihi(rs.getDate("yorum_tarihi"));
            
            
            ListeYorum.add(yorum);
            }

        } catch (SQLException ex) {
          System.out.println(ex.getMessage())  ;   
        }
        return ListeYorum;

    }
       
       
       public void delete(Yorum yorum) {
      
        try {
            String query = "delete from yorum where idyorum = ? ";
            PreparedStatement pst = connection.prepareStatement(query);
            pst.setInt(1, yorum.getIdyorum());
            pst.executeUpdate(); 

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            Logger.getLogger(YorumDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
       
       
       
       public void insert(Yorum yorum) {
        
        try {
            String query = "insert into yorum values (?,?,?,?,?,?)";
            PreparedStatement pst = connection.prepareStatement(query);
            pst.setInt(1, yorum.getIdyorum());
            pst.setInt(2, yorum.getFilm().getIdfilmler());
            pst.setInt(3, yorum.getUser().getIduser());
            pst.setString(4, yorum.getIcerik());
             pst.setString(5, yorum.getYorum_basligi());
            pst.setDate(6, yorum.getYorum_tarihi());
            pst.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(YorumDAO.class.getName()).log(Level.SEVERE, null, ex);

        }

    }
       
       
       public void update(Yorum yorum) {
      
        try {
            String query = " update yorum "
                    +"  set filmler_idfilmler   = ? "
                    +", user_iduser = ? "        
                    +", icerik = ? "
                     +", yorum_basligi = ? "
                     +", yorum_tarihi = ? "
                    +"where idyorum  = ? ";
            PreparedStatement pst = connection.prepareStatement(query); 
            
            pst.setInt(1, yorum.getFilm().getIdfilmler());
            pst.setInt(2, yorum.getUser().getIduser());
            pst.setString(3, yorum.getIcerik());
            pst.setString(4, yorum.getYorum_basligi());
            pst.setDate(5, yorum.getYorum_tarihi());
            pst.setInt(6, yorum.getIdyorum());
            pst.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(YorumDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
