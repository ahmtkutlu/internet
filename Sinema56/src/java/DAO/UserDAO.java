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
public class UserDAO extends AbstractDAO implements DAO<User>{
      Connector con = new Connector();
      Connection connection = con.connect();
      
      
      
      public User login(User user) {
        User coun = null;
        try {
            String selectQuery = "select * from user where mail = ? and sifre = ?";
            PreparedStatement pst = this.getConnection().prepareStatement(selectQuery);
            pst.setString(1, user.getMail());
            pst.setInt(2, user.getSifre());
            ResultSet rs = pst.executeQuery();                     
            if(rs.next()){
            coun = new User();
            coun.setIduser(rs.getLong("iduser"));
            coun.setMail(rs.getString("mail"));
            coun.setSifre(rs.getInt("sifre"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return coun;

    }
       
       
       @Override
        public User find(Long id) {
        User user = null;
        try {
            String query = "select * from user where iduser = ?";
            PreparedStatement pst = connection.prepareStatement(query);
            pst.setLong(1, id);
            ResultSet rs = pst.executeQuery();           
            rs.next();
            user=new User();
            user.setIduser(rs.getLong("iduser"));
            user.setUser_ad(rs.getString("user_ad"));
            user.setUser_soyad(rs.getString("user_soyad"));             
            user.setMail(rs.getString("mail"));            
            user.setSifre(rs.getInt("sifre"));

        } catch (SQLException ex) {
            System.out.println(ex.getMessage())  ;         }
        return user;

    }
       
       
       
       @Override
       public List<User> findAll() {
         List<User> ListeUser = new ArrayList();
        try {
            String query = "select * from user order by iduser";
            PreparedStatement pst = connection.prepareStatement(query);
            ResultSet rs = pst.executeQuery();                  
            while(rs.next()){
            User user =new User();
            
            user.setIduser(rs.getLong("iduser"));
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
       
       @Override
       public void delete(User user) {
      
        try {
            String query = "delete from user where iduser = ? ";
            PreparedStatement pst = connection.prepareStatement(query);
            pst.setLong(1, user.getIduser());
            pst.executeUpdate(); 

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
       
       
       @Override
       public void insert(User user) {
        
        try {
            String query = "insert into user(user_ad,user_soyad,mail,sifre) values (?,?,?,?)";
            PreparedStatement pst = connection.prepareStatement(query);
         
            pst.setString(1, user.getUser_ad());
            pst.setString(2, user.getUser_soyad());
            pst.setString(3, user.getMail());
            pst.setInt(4, user.getSifre());
            pst.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);

        }

    }
       
       @Override
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
            pst.setLong(5, user.getIduser());
            
            pst.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
       public int record() {
        
        int a = 0;
        try {
            String selectQuery = "select * from user";
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
    public List<User> findAll(int page, int pageSize) {


        List<User> userList = new ArrayList<>();
        
        int start = ( page -1 ) * pageSize ;
        
        try {
            String selectQuery = "select * from user order by iduser limit "+pageSize+" offset "+start;
            PreparedStatement pst = this.getConnection().prepareStatement(selectQuery);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                User user = new User();
                 
                user.setIduser(rs.getLong("iduser"));
                user.setUser_ad(rs.getString("user_ad"));
                user.setUser_soyad(rs.getString("user_soyad"));        
                user.setMail(rs.getString("mail"));
                user.setSifre(rs.getInt("sifre"));
            
                userList.add(user);

                System.out.println(user);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }

        return userList ;
        
    }
}
