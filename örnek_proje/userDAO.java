
package DAO;

import Entity.user;
import Utilitiy.ConnectionManager;
import java.sql.Array;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Connection;

public class userDAO {
    
        private user user=null;
        private ArrayList<user> userlist=null;
    
    public user getUser(int id){
        Connection con=ConnectionManager.baglanti();
    try{
        Statement st=con.createStatement();
        ResultSet rs=st.executeQuery("select*from user where user_id="+id);
        while(rs.next()){
            this.user=new user(rs.getInt("user_id"),rs.getString("user_ad"),rs.getString("user_soyad"),rs.getString("user_email"));
        }
      }catch(SQLException ex){
        System.out.println(ex.getMessage());
    }
    return this.user;
    }
    
    
    public ArrayList<user> list(){
        this.userlist=new ArrayList();
        Connection con=ConnectionManager.baglanti();
    try{
        Statement st=con.createStatement();
        ResultSet rs=st.executeQuery("select*from user");
        while(rs.next()){
            this.userlist.add(new user(rs.getInt("user_id"),rs.getString("user_parola"),rs.getString("user_ad_soyad"),rs.getString("user_mail")));
        }
       this.user=new user(rs.getInt("user_id"),rs.getString("user_parola"),rs.getString("user_ad_soyad"),rs.getString("user_mail")); 
    }catch(SQLException ex){
        System.out.println(ex.getMessage());
    }
    return this.userlist;
    } 
    
    
    public void delete(int id){
    Connection con=ConnectionManager.baglanti();
    try{
        Statement st=con.createStatement();
        st.executeUpdate("delete from user where user_id="+id);
    }catch(SQLException ex){
        System.out.println(ex.getMessage());
    }
    }
    
    
    public void update(user k){
    Connection con=ConnectionManager.baglanti();
    try{
        Statement st=con.createStatement();
        st.executeUpdate("update user set user_parola= '"+k.getUser_parola()+ "user_ad_soyad='"+k.getUser_ad_soyad()+"' where user_id='"+k.getUser_id()+"'");
    }catch(SQLException ex){
        System.out.println(ex.getMessage());
    }
    }
    
    public void create(user k){
    Connection con=ConnectionManager.baglanti();
    try{
        Statement st=con.createStatement();
        st.executeUpdate("insert into user (user_id,user_parola,user_ad_soyad,user_email) values('"+k.getUser_id()+"','"+k.getUser_parola()+"','"+k.getUser_ad_soyad()+"','"+k.getUser_email()+"')");
    }catch(SQLException ex){
        System.out.println(ex.getMessage());
    }
    }
}
