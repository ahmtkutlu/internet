/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;


import Entity.cv;
import Utility.ConnectionManager;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 *
 * @author asus
 */
public class cvDAO {

    
    private cv c=null;
    private ArrayList<cv> cvlist=null;
    
    public cv getC(Long id){
        Connection con =ConnectionManager.baglanti();
        try{
            Statement st =con.createStatement();
            ResultSet rs =st.executeQuery("select * from cv where cv_id="+id);
            rs.next();
            this.c =new cv(rs.getString("cv_dosya"),rs.getLong("arayan_id"));
        }
        catch(SQLException ex){
            System.out.println(ex.getMessage());
            
        }
        return this.c;
    }
     public cv getArayan(Long arayan_id){
        Connection con =ConnectionManager.baglanti();
        try{
            Statement st =con.createStatement();
            ResultSet rs =st.executeQuery("select * from cv where arayan_id="+arayan_id);
            rs.next();
            this.c =new cv(rs.getString("cv_dosya"));
        }
        catch(SQLException ex){
            System.out.println(ex.getMessage());
            
        }
        return this.c;
    }
     public ArrayList<cv> list(){
         this.cvlist=new ArrayList();
        Connection con =ConnectionManager.baglanti();
        try{
            Statement st =con.createStatement();
            ResultSet rs =st.executeQuery("select * from cv");
           while(rs.next()) {
               this.cvlist.add(new cv(rs.getString("cv_dosya"),rs.getLong("arayan_id")));     
           }
            this.c =new cv(rs.getString("cv_dosya"),rs.getLong("arayan_id"));
        }
        catch(SQLException ex){
            System.out.println(ex.getMessage());
            
        }
        return this.cvlist;
    }
      
       public void delete(Long id){
        Connection con =ConnectionManager.baglanti();
        try{
            Statement st =con.createStatement();
            st.executeUpdate("delete from yorum where cv_id="+id);
        }
        catch(SQLException ex){
            System.out.println(ex.getMessage());}
    }
        public void update(cv v){
        Connection con =ConnectionManager.baglanti();
        try{
            Statement st =con.createStatement();
            st.executeUpdate("update cv set cv_dosya='"+v.getCv_dosya()+"',arayan_id='"+v.getArayan_id()+"' where cv_id="+v.getCv_id());
       System.out.print("güncelledi");
        }
        catch(SQLException ex){
            System.out.println(ex.getMessage());
            
        }
        }
        public void create(cv v){
              Connection con =ConnectionManager.baglanti();
        try{
            Statement st =con.createStatement();
            
            st.executeUpdate("insert into cv(cv_dosya,arayan_id) values ('"+v.getCv_dosya()+"','"+v.getArayan_id()+"')");
            System.out.println("cv eklendi");
        }
        catch(SQLException ex){
            System.out.println(ex.getMessage());
            
        }
        }
        
         public static void main(String args[]){
    cvDAO cv=new cvDAO();
    
    
    }
        
    }
    
    

