/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entity.User;
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
public class UserDAO {
      Connector con = new Connector();
      Connection connection = con.connect();
       
       
       
        public User find(int id) {
        User user = null;
        try {
            String query = "select * from user where iduser = ?";
            PreparedStatement pst = connection.prepareStatement(query);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();           
            rs.next();
            user.setIduser(rs.getInt("iduser"));
            user.setUser_ad(rs.getString("user_ad"));
            user.setUser_soyad(rs.getString("user_soyad"));             
            user.setMail(rs.getString("mail"));            
            user.setSifre(rs.getInt("sifre"));

        } catch (SQLException ex) {
            System.out.println(ex.getMessage())  ;         }
        return user;

    }
       
       
       
       
       public List<User> findAll() {
         List<User> ListeUser = new ArrayList();
        try {
            String query = "select * from user order by iduser";
            PreparedStatement pst = connection.prepareStatement(query);
            ResultSet rs = pst.executeQuery();                  
            while(rs.next()){
            User user =new User();
            
            user.setIduser(rs.getInt("iduser"));
            user.setUser_ad(rs.getString("user_ad"));
            user.setUser_soyad(rs.getString("user_soyad"));        
            user.setMail(rs.getString("mail"));
            user.setSifre(rs.getInt("sifre"));

            
            
            ListeUser.add(user);
            }

        } catch (SQLException ex) {
          System.out.println(ex.getMessage())  ;   
        }
        return ListeUser;

    }
       
       
       public void delete(User user) {
      
        try {
            String query = "delete from user where iduser = ? ";
            PreparedStatement pst = connection.prepareStatement(query);
            pst.setInt(1, user.getIduser());
            pst.executeUpdate(); 

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
       
       
       
       public void insert(User user) {
        
        try {
            String query = "insert into user values (?,?,?,?,?)";
            PreparedStatement pst = connection.prepareStatement(query);
            pst.setInt(1, user.getIduser());
            pst.setString(2, user.getUser_ad());
            pst.setString(3, user.getUser_soyad());
            pst.setString(4, user.getMail());
            pst.setInt(5, user.getSifre());
            pst.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);

        }

    }
       
       
       public void update(User user) {
      
        try {
            String query = " update user "
                    +"  set user_ad   = ? "
                    +", user_soyad = ? "        
                    +", mail = ? "
                    +", sifre = ? "
                    +"where iduser     = ? ";
            PreparedStatement pst = connection.prepareStatement(query); 
            
            pst.setString(1, user.getUser_ad());
            pst.setString(2, user.getUser_soyad());
            pst.setString(3, user.getMail());
            pst.setInt(4, user.getSifre());
            pst.setInt(5, user.getIduser());
            
            pst.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
