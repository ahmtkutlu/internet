/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entity.user;
import Utility.ConnectionManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author asus
 */
public class userDAO {
      private user user=null;
    private ArrayList<user> userlist=null;
    
    public user getUser(Long id){
        Connection con =ConnectionManager.baglanti();
        try{
            Statement st =con.createStatement();
            ResultSet rs =st.executeQuery("select * from user where user_id="+id);
            rs.next();
            this.user =new user(rs.getLong("user_id"),rs.getString("user_parola"),rs.getString("user_ad_soyad"),rs.getString("user_email"));
        }
        catch(SQLException ex){
            System.out.println(ex.getMessage());
            
        }
        return this.user;
    }
     public ArrayList<user> list(){
         this.userlist=new ArrayList();
        Connection con =ConnectionManager.baglanti();
        try{
            Statement st =con.createStatement();
            ResultSet rs =st.executeQuery("select * from user");
           while(rs.next()) {
               this.userlist.add(new user(rs.getLong("user_id"),rs.getString("user_parola"),rs.getString("user_ad_soyad"),rs.getString("user_email")));     
           }
            this.user =new user(rs.getLong("user_id"),rs.getString("user_parola"),rs.getString("user_ad_soyad"),rs.getString("user_email"));
        }
        catch(SQLException ex){
            System.out.println(ex.getMessage());
            
        }
        return this.userlist;
    }
      
       public void delete(Long id){
        Connection con =ConnectionManager.baglanti();
        try{
            Statement st =con.createStatement();
            st.executeUpdate("delete from user where user_id="+id);
        }
        catch(SQLException ex){
            System.out.println(ex.getMessage());}
    }
        public void update(user a){
        Connection con =ConnectionManager.baglanti();
        try{
            Statement st =con.createStatement();
            st.executeUpdate("update user set user_parola='"+a.getUser_parola()+"' ,user_ad_soyad='"+a.getUser_ad_soyad()+"',user_email='"+a.getUser_email()+"', where user_id="+a.getUser_id());
        }
        catch(SQLException ex){
            System.out.println(ex.getMessage());
            
        }
        }
        public void create(user a){
              Connection con =ConnectionManager.baglanti();
        try{
            Statement st =con.createStatement();
            
            st.executeUpdate("insert into user(user_parola,user_ad_soyad,user_email) values ('"+a.getUser_parola()+"','"+a.getUser_ad_soyad()+"','"+a.getUser_email()+"')");
            System.out.println("deneme");
        }
        catch(SQLException ex){
            System.out.println(ex.getMessage());
            
        }
        }
}
