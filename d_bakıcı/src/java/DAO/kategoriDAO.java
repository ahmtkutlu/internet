/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entity.is_arayan;
import Entity.kategori;
import Utility.ConnectionManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author asus
 */
public class kategoriDAO {
     private kategori kat=null;
    private ArrayList<kategori> katlist=null;
    private is_verenDAO verDAO;
    private is_arayanDAO  araDAO;
public List<kategori> getKat(){
    List<kategori> katlist= new ArrayList<>();
    
     Connection con =ConnectionManager.baglanti();
        try{
            Statement st =con.createStatement();
            ResultSet rs =st.executeQuery("select * from kategori");
           while(rs.next()) {
               kategori k=new kategori();
               k.setKategori_id(rs.getLong("kategori_id"));
               k.setKategori_ad(rs.getString("kategori_ad"));
               k.setIsarayan(isarayanGetir(rs.getLong("kategori_id")));
              
               this.katlist.add(k);     
           }
        }
        catch(SQLException ex){
            System.out.println(ex.getMessage());
            
        }
return katlist;
}
    public is_verenDAO getVerDAO() {
          if(this.verDAO==null)
            this.verDAO=new is_verenDAO();
        return verDAO;
    }

    public void setVerDAO(is_verenDAO verDAO) {
        this.verDAO = verDAO;
    }

    public is_arayanDAO getAraDAO() {
          if(this.araDAO==null)
            this.araDAO=new is_arayanDAO();
        return araDAO;
    }

    public void setAraDAO(is_arayanDAO araDAO) {
        this.araDAO = araDAO;
    }
    
    
    
    
    public kategori getKat(Long id){
        Connection con =ConnectionManager.baglanti();
        try{
            Statement st =con.createStatement();
            ResultSet rs =st.executeQuery("select * from kategori where kategori_id="+id);
            rs.next();
            this.kat=new kategori(rs.getLong("kategori_id"),rs.getString("kategori_ad"));
        }
        catch(SQLException ex){
            System.out.println(ex.getMessage());
            
        }
        return this.kat;
    }
    
      
     
     public ArrayList<kategori> list(){
         this.katlist=new ArrayList<>();
        Connection con =ConnectionManager.baglanti();
        try{
            Statement st =con.createStatement();
            ResultSet rs =st.executeQuery("select * from kategori");
           while(rs.next()) {
               kategori k=new kategori();
               k.setKategori_id(rs.getLong("kategori_id"));
               k.setKategori_ad(rs.getString("kategori_ad"));
               k.setIsarayan(isarayanGetir(rs.getLong("kategori_id")));
              
               this.katlist.add(k);     
           }
        }
        catch(SQLException ex){
            System.out.println(ex.getMessage());
            
        }
        return katlist;
    }
      
      public ArrayList<is_arayan> isarayanGetir(Long id){
         ArrayList <is_arayan> is=new ArrayList();
        Connection con =ConnectionManager.baglanti();
        try{
            Statement st =con.createStatement();
            ResultSet rs =st.executeQuery("select * from is_arayan where arayan_id in (select arayan_id from calisir where kategori_id="+id+")");
           while(rs.next()) {
               is_arayan i=new is_arayan();
        i.setAciklama(rs.getString("aciklama"));
        i.setArayan_ad(rs.getString("arayan_ad"));
        i.setArayan_soyad(rs.getString("arayan_soyad"));
        i.setMail(rs.getString("arayan_email"));
        i.setArayan_id(rs.getLong("arayan_id"));
         is.add(i);
           }
           }catch(SQLException ex){
            System.out.println(ex.getMessage());
         }
        return is;
       }
     
     
       public void delete(kategori id){
        Connection con =ConnectionManager.baglanti();
        
        try{
            Statement st =con.createStatement();
            st.executeUpdate("delete from kategori where kategori_id="+id.getKategori_id());
        }
        catch(SQLException ex){
            System.out.println(ex.getMessage());}
    }
        public void update(kategori k){
        Connection con =ConnectionManager.baglanti();
        try{
            Statement st =con.createStatement();
            st.executeUpdate("update kategori set kategori_ad='"+k.getKategori_ad()+"' where kategori_id="+k.getKategori_id());
        }
        catch(SQLException ex){
            System.out.println(ex.getMessage());
            
        }
        }
        public void create(kategori k){
              Connection con =ConnectionManager.baglanti();
        try{
            Statement st =con.createStatement();
            
            st.executeUpdate("insert into kategori(kategori_id,kategori_ad) values ('"+k.getKategori_id()+"','"+k.getKategori_ad()+"')");
            System.out.println("kategori eklendi");
        }
        catch(SQLException ex){
            System.out.println(ex.getMessage());
            
        }
        }
        
        public static void main(String args[]){
   
    
    }
}

