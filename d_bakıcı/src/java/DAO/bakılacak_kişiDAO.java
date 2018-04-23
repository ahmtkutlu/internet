/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entity.bakılacak_kisi;
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
public class bakılacak_kişiDAO {
       private bakılacak_kisi kisi=null;
      
    private ArrayList<bakılacak_kisi> kisilist=null;
    
    public bakılacak_kisi getVeren(Long id){
        Connection con =ConnectionManager.baglanti();
        
        try{
            Statement st =con.createStatement();
            ResultSet rs =st.executeQuery("select * from bakilacak_kisi where isveren_id="+id);
            rs.next();
            this.kisi=new bakılacak_kisi(rs.getString("kisi_ad"),rs.getString("kisi_soyad")
                    ,rs.getLong("kisi_yas"),rs.getString("aciklama"));
        }
        catch(SQLException ex){
            System.out.println(ex.getMessage());
            
        }
        return this.kisi;
    }
     
    
    
    
    public bakılacak_kisi getKisi(Long kisi_id){
        Connection con =ConnectionManager.baglanti();
        
        try{
            Statement st =con.createStatement();
            ResultSet rs =st.executeQuery("select * from bakilacak_kisi where kisi_id="+kisi_id);
            rs.next();
            this.kisi =new bakılacak_kisi(rs.getString("kisi_ad"),rs.getString("kisi_soyad")
                    ,rs.getLong("kisi_yas"),rs.getString("aciklama"),rs.getLong("isveren_id"));
        }
        catch(SQLException ex){
            System.out.println(ex.getMessage());
            
        }
        return this.kisi;
    }
     public ArrayList<bakılacak_kisi> list(){
         this.kisilist=new ArrayList();
        Connection con =ConnectionManager.baglanti();
        try{
            Statement st =con.createStatement();
            ResultSet rs =st.executeQuery("select * from bakilacak_kisi");
           while(rs.next()) {
               this.kisilist.add(new bakılacak_kisi(rs.getLong("kisi_id"),rs.getString("kisi_ad"),rs.getString("kisi_soyad")
                    ,rs.getLong("kisi_yas"),rs.getString("aciklama"),rs.getLong("isveren_id")));     
           }
            
        }
        catch(SQLException ex){
            System.out.println(ex.getMessage());
            
        }
        return this.kisilist;
    }
      
       public void delete(Long id){
        Connection con =ConnectionManager.baglanti();
        try{
            Statement st =con.createStatement();
            st.executeUpdate("delete from bakilacak_kisi where kisi_id="+id);
        }
        catch(SQLException ex){
            System.out.println(ex.getMessage());}
    }
        public void update(bakılacak_kisi i){
        Connection con =ConnectionManager.baglanti();
        try{
            Statement st =con.createStatement();
            st.executeUpdate("update bakilacak_kisi set kisi_ad='"+i.getKisi_ad()
                    +"',kisi_soyad='"+i.getKisi_soyad()
                    +"',kisi_yas='"+i.getKisi_yas()+"'"
                            + ",aciklama='"+i.getAciklama()+"'"
                                    + ",isveren_id='"+i.getIsveren_id()+"' where kisi_id="+i.getKisi_id());
        }
        catch(SQLException ex){
            System.out.println(ex.getMessage());
            
        }
        }
        public void create(bakılacak_kisi b){
              Connection con =ConnectionManager.baglanti();
        try{
            
            
            
            
            
            
            Statement st =con.createStatement();
                        System.out.println(" eklendi");

            st.executeUpdate("insert into bakilacak_kisi(kisi_ad,kisi_soyad,kisi_yas,aciklama,isveren_id) values ('"
                    +b.getKisi_ad()+"','"+b.getKisi_soyad()+"','"+b.getKisi_yas()+"','"+b.getAciklama()+"','"+b.getIsveren_id()+"')");
            System.out.println("ilce eklendi");
        }
        catch(SQLException ex){
            System.out.println(ex.getMessage());
            
        }
        }
        
         public static void main(String args[]){

    
    }
    
}
