/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entity.yorum;
import Utility.ConnectionManager;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class yorumDAO {
    
    private yorum yrm=null;
    private ArrayList<yorum> yrmlist=null;
    
    public yorum getYrm(Long id){
        Connection con =ConnectionManager.baglanti();
        try{
            Statement st =con.createStatement();
            ResultSet rs =st.executeQuery("select * from yorum where y_id="+id);
            rs.next();
            this.yrm =new yorum(rs.getString("y_ad"),rs.getString("y_yorum"),rs.getLong("arayan_id"));
        }
        catch(SQLException ex){
            System.out.println(ex.getMessage());
            
        }
        return this.yrm;
    }
     public yorum getArayan(Long id){
        Connection con =ConnectionManager.baglanti();
        try{
            Statement st =con.createStatement();
            ResultSet rs =st.executeQuery("select * from yorum where arayan_id="+id);
            rs.next();
            this.yrm =new yorum(rs.getString("y_ad"),rs.getString("y_yorum"));
        }
        catch(SQLException ex){
            System.out.println(ex.getMessage());
            
        }
        return this.yrm;
    }
     public ArrayList<yorum> list(){
         this.yrmlist=new ArrayList();
        Connection con =ConnectionManager.baglanti();
        try{
            Statement st =con.createStatement();
            ResultSet rs =st.executeQuery("select * from yorum");
           while(rs.next()) {
               this.yrmlist.add(new yorum(rs.getLong("y_id"),rs.getString("y_ad"),rs.getString("y_yorum"),rs.getLong("arayan_id")));     
           }
            this.yrm =new yorum(rs.getString("y_ad"),rs.getString("y_yorum"),rs.getLong("arayan_id"));
        }
        catch(SQLException ex){
            System.out.println(ex.getMessage());
            
        }
        return this.yrmlist;
    }
      
       public void delete(Long id){
        Connection con =ConnectionManager.baglanti();
        try{
            Statement st =con.createStatement();
            st.executeUpdate("delete from yorum where y_id="+id);
        }
        catch(SQLException ex){
            System.out.println(ex.getMessage());}
    }
        public void update(yorum y){
        Connection con =ConnectionManager.baglanti();
        try{
            Statement st =con.createStatement();
            st.executeUpdate("update yorum set y_ad='"+y.getY_ad()+"',y_yorum='"+y.getY_yorum()+"',arayan_id='"+y.getArayan_id()+"' where y_id="+y.getY_id());
       System.out.print("güncelledi");
        }
        catch(SQLException ex){
            System.out.println(ex.getMessage());
            
        }
        }
        public void create(yorum y){
              Connection con =ConnectionManager.baglanti();
        try{
            Statement st =con.createStatement();
            
            st.executeUpdate("insert into yorum(y_ad,y_yorum,arayan_id) values ('"+y.getY_ad()+"','"+y.getY_yorum()+"','"+y.getArayan_id()+"')");
            System.out.println("yorum eklendi");
        }
        catch(SQLException ex){
            System.out.println(ex.getMessage());
            
        }
        }
        
         public static void main(String args[]){
    yorumDAO yr=new yorumDAO();
   
    }
        
    }
    
    

