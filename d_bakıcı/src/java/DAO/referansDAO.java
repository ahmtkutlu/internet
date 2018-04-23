/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entity.referans;
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
public class referansDAO {


    private  referans ref=null;
    private ArrayList<referans> reflist=null;
    
    public referans getRef(Long id){
        Connection con =ConnectionManager.baglanti();
        
        try{
            Statement st =con.createStatement();
            ResultSet rs =st.executeQuery("select * from referans where ref_id="+id);
            rs.next();
            this.ref =new referans(rs.getString("ref_ad"), rs.getString("ref_soyad"),rs.getLong("arayan_id"));
        }
        catch(SQLException ex){
            System.out.println(ex.getMessage());
            
        }
        return this.ref;
    }
    
    public referans getArayan(Long id){
        Connection con =ConnectionManager.baglanti();
        
        try{
            Statement st =con.createStatement();
            ResultSet rs =st.executeQuery("select * from referans where arayan_id="+id);
            rs.next();
            this.ref =new referans(rs.getString("ref_ad"), rs.getString("ref_soyad"));
        }
        catch(SQLException ex){
            System.out.println(ex.getMessage());
            
        }
        return this.ref;
    }
     public ArrayList<referans> list(){
         this.reflist=new ArrayList();
        Connection con =ConnectionManager.baglanti();
        try{
            Statement st =con.createStatement();
            ResultSet rs =st.executeQuery("select * from referans");
           while(rs.next()) {
               this.reflist.add(new referans(rs.getLong("ref_id"),rs.getString("ref_ad"),
                    rs.getString("ref_soyad"),rs.getLong("arayan_id")));     
           }
            this.ref =new referans(rs.getString("ref_ad"),
                    rs.getString("ref_soyad"), rs.getLong("arayan_id"));
        }
        catch(SQLException ex){
            System.out.println(ex.getMessage());
            
        }
        return this.reflist;
    }
      
       public void delete(Long id){
        Connection con =ConnectionManager.baglanti();
        try{
            Statement st =con.createStatement();
            st.executeUpdate("delete from referans where ref_id="+id);
        }
        catch(SQLException ex){
            System.out.println(ex.getMessage());}
    }
        public void update(referans r){
        Connection con =ConnectionManager.baglanti();
        try{
            Statement st =con.createStatement();
            st.executeUpdate("update referans set ref_ad='"+r.getRef_ad()
                    +"',ref_soyad='"+r.getRef_soyad()
                    +"',arayan_id='"
                    +r.getArayan_id()+"' where ref_id="+r.getRef_id());
                    
        }
        catch(SQLException ex){
            System.out.println(ex.getMessage());
            
        }
        }
        public void create(referans r){
              Connection con =ConnectionManager.baglanti();
        try{
            Statement st =con.createStatement();
            System.out.println("deneme");
            st.executeUpdate("insert into referans"
                    + "(ref_ad,ref_soyad,arayan_id) values ('"+r.getRef_ad()+"','"+r.getRef_soyad()+"','"+r.getArayan_id()+"')");
            System.out.println("deneme");
        }
        catch(SQLException ex){
            System.out.println(ex.getMessage());
            
        }
        }
          public static void main(String args[]){
   
    
    }
    
       
        
    }
    
    

