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
public class is_arayanDAO {
    
    private is_arayan ara=null;
    private ArrayList<is_arayan> aralist=null;
    private cvDAO cDAO;
    private grupDAO gDAO;
    private yorumDAO yDAO;
    private resimDAO rDAO;
    private referansDAO refDAO;
    private kategoriDAO kDAO;
   

    public grupDAO getgDAO() {
        if(this.gDAO==null)
            this.gDAO=new grupDAO();
        return gDAO;
    }

    
    
    public cvDAO getcDAO() {
        if(this.cDAO==null)
            this.cDAO=new cvDAO();
        return cDAO;
    }

    public void setcDAO(cvDAO cDAO) {
        this.cDAO = cDAO;
    }

    public yorumDAO getyDAO() {
        if(this.yDAO==null)
            this.yDAO=new yorumDAO();
        return yDAO;
    }

    public void setyDAO(yorumDAO yDAO) {
        this.yDAO = yDAO;
    }

    public resimDAO getrDAO() {
        if(this.rDAO==null)
            this.rDAO=new resimDAO();
        return rDAO;
    }

    public void setrDAO(resimDAO rDAO) {
        this.rDAO = rDAO;
    }

    public referansDAO getRefDAO() {
        if(this.refDAO==null)
            this.refDAO=new referansDAO();
        return refDAO;
    }

    public void setRefDAO(referansDAO refDAO) {
        this.refDAO = refDAO;
    }

    public kategoriDAO getkDAO() {
        if(this.kDAO==null)
            this.kDAO=new kategoriDAO();
        return kDAO;
    }

    public void setkDAO(kategoriDAO kDAO) {
        this.kDAO = kDAO;
    }
    
    
    
    
    
    
    public is_arayan getAra(Long id){
        Connection con =ConnectionManager.baglanti();
        try{
            Statement st =con.createStatement();
            ResultSet rs =st.executeQuery("select * from is_arayan where arayan_id="+id);
            rs.next();
            this.ara=new is_arayan(rs.getLong("arayan_id"),rs.getString("arayan_ad"),
                    rs.getString("arayan_soyad"),rs.getLong("arayan_yas"),rs.getString("arayan_uyruk"),
                    rs.getString("arayan_email"),rs.getString("arayan_iletisim"),rs.getString("aciklama"),rs.getLong("ilce_id"));
        }
        catch(SQLException ex){
            System.out.println(ex.getMessage());
            
        }
        return this.ara;
    }
 

     public ArrayList<is_arayan> list(){
         this.aralist=new ArrayList<>();        
        Connection con =ConnectionManager.baglanti();
        try{
            Statement st =con.createStatement();
            ResultSet rs =st.executeQuery("select * from is_arayan");
           while(rs.next()) {
               is_arayan is=new is_arayan();
               is.setArayan_id(rs.getLong("arayan_id"));
               is.setArayan_ad(rs.getString("arayan_ad"));
               is.setArayan_soyad(rs.getString("arayan_soyad"));
              is.setYas(rs.getLong("arayan_yas"));
              is.setUyruk(rs.getString("arayan_uyruk"));
              is.setMail(rs.getString("arayan_email"));
              is.setIletisim(rs.getString("arayan_iletisim"));
              is.setAciklama(rs.getString("aciklama"));
              is.setIlce_id(rs.getLong("ilce_id"));
              
              is.setKategorisi(kategoriGetir(rs.getLong("arayan_id")));
              
               this.aralist.add(is);     
           }
        }
        catch(SQLException ex){
            System.out.println(ex.getMessage());
            
        }
        return aralist;
    }
      
     
     
       public ArrayList<kategori> kategoriGetir(Long id){
        ArrayList <kategori> kalist=new ArrayList<>();
        Connection con =ConnectionManager.baglanti();
        try{
            Statement st =con.createStatement();
            ResultSet rs =st.executeQuery("select * from kategori where kategori_id in(select kategori_id from calisir where arayan_id="+ id +")");
           while(rs.next()) {
               kategori k=new kategori();
               k.setKategori_id(rs.getLong("kategori_id"));
            k.setKategori_ad(rs.getString("kategori_ad"));
              kalist.add(k); 

           }
        }
        catch(SQLException ex){
            System.out.println(ex.getMessage());
            
        }
        return kalist;
    }
      
     
     
     
       public void delete( is_arayan is){
        Connection con =ConnectionManager.baglanti();
        
        try{
            Statement st =con.createStatement();
            st.executeUpdate("delete from is_arayan where arayan_id="+is.getArayan_id());
        }
        catch(SQLException ex){
            System.out.println(ex.getMessage());}
    }
        public void update(is_arayan is){
        Connection con =ConnectionManager.baglanti();
        try{
            Statement st =con.createStatement();
            st.executeUpdate("update is_arayan set arayan_ad='"+is.getArayan_ad()+"',arayan_soyad='"+is.getArayan_soyad()
                    +"',arayan_yas='"+is.getYas()+"',arayan_uyruk='"+is.getUyruk()+"',arayan_email='"+is.getMail()
                    +"',arayan_iletisim='"+is.getIletisim()+"',aciklama='"+is.getAciklama()+"',ilce_id='"+is.getIlce_id()
                    +"' where arayan_id="+is.getArayan_id());
        }
        catch(SQLException ex){
            System.out.println(ex.getMessage());
            
        }
        }
        public void create(is_arayan is){
              Connection con =ConnectionManager.baglanti();
        try{
            Statement st =con.createStatement();
            
            st.executeUpdate("insert into is_arayan(arayan_id,arayan_ad,arayan_soyad,arayan_yas,arayan_uyruk,arayan_email,arayan_iletisim,aciklama,ilce_id) values ('"+is.getArayan_id()
                    +"','"+is.getArayan_ad()+"','"+is.getArayan_soyad()+"','"+is.getYas()+"','"+is.getUyruk()+"','"+is.getMail()+"','"+is.getIletisim()+"','"+is.getAciklama()+"','"+is.getIlce_id()+"')");
            System.out.println("is arayan eklendi");
        }
        catch(SQLException ex){
            System.out.println(ex.getMessage());
            
        }
        }
        
        public static void main(String args[]){
   
    
    }
}
