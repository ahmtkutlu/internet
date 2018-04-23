/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entity.resim;
import Utility.ConnectionManager;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class resimDAO {
    
    private resim rsm=null;
    private ArrayList<resim> rsmlist=null;
    
    public resim getRsm(Long id){
        Connection con =ConnectionManager.baglanti();
        try{
            Statement st =con.createStatement();
            ResultSet rs =st.executeQuery("select * from resim where resim_id="+id);
            rs.next();
            this.rsm =new resim(rs.getString("resim_dosya"),rs.getLong("arayan_id"));
        }
        catch(SQLException ex){
            System.out.println(ex.getMessage());
            
        }
        return this.rsm;
    }
      public resim getArayan(Long id){
        Connection con =ConnectionManager.baglanti();
        try{
            Statement st =con.createStatement();
            ResultSet rs =st.executeQuery("select * from resim where arayan_id="+id);
            rs.next();
            this.rsm =new resim(rs.getString("resim_dosya"));
        }
        catch(SQLException ex){
            System.out.println(ex.getMessage());
            
        }
        return this.rsm;
    }
     public ArrayList<resim> list(){
         this.rsmlist=new ArrayList();
        Connection con =ConnectionManager.baglanti();
        try{
            Statement st =con.createStatement();
            ResultSet rs =st.executeQuery("select * from resim");
           while(rs.next()) {
               this.rsmlist.add(new resim(rs.getString("resim_dosya"),rs.getLong("arayan_id")));     
           }
            this.rsm =new resim(rs.getString("resim_dosya"),rs.getLong("arayan_id"));
        }
        catch(SQLException ex){
            System.out.println(ex.getMessage());
            
        }
        return this.rsmlist;
    }
      
       public void delete(Long id){
        Connection con =ConnectionManager.baglanti();
        try{
            Statement st =con.createStatement();
            st.executeUpdate("delete from resim where resim_id="+id);
        }
        catch(SQLException ex){
            System.out.println(ex.getMessage());}
    }
        public void update(resim r){
        Connection con =ConnectionManager.baglanti();
        try{
            Statement st =con.createStatement();
            st.executeUpdate("update resim set resim_dosya='"+r.getResim_dosya()+"',arayan_id='"+r.getArayan_id()+"' where resim_id="+r.getResim_id());
        }
        catch(SQLException ex){
            System.out.println(ex.getMessage());
            
        }
        }
        public void create(resim r){
              Connection con =ConnectionManager.baglanti();
        try{
            Statement st =con.createStatement();
            
            st.executeUpdate("insert into resim(resim_dosya,arayan_id) values ('"+r.getResim_dosya()+"','"+r.getArayan_id()+"')");
            System.out.println("resim eklendi");
        }
        catch(SQLException ex){
            System.out.println(ex.getMessage());
            
        }
        }
        
         public static void main(String args[]){
    resimDAO rs=new resimDAO();
  
        
    }}
    
    

