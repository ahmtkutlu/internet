/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entity.bakılacak_kisi;
import Entity.is_veren;
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
public class is_verenDAO {
      
    private is_veren ver=null;
    private ArrayList<is_veren> verlist=null;
    private kategoriDAO katDAO;
    private bakılacak_kişiDAO kisiDAO;

    public kategoriDAO getKatDAO() {
        if(this.katDAO==null)
            this.katDAO=new kategoriDAO();
        return katDAO;
    }

    public void setKatDAO(kategoriDAO katDAO) {
        this.katDAO = katDAO;
    }

    public bakılacak_kişiDAO getKisiDAO() {
        if(this.kisiDAO==null)
            this.kisiDAO=new bakılacak_kişiDAO();
        return kisiDAO;
    }

    public void setKisiDAO(bakılacak_kişiDAO kisiDAO) {
        this.kisiDAO = kisiDAO;
    }
    
    
    
    
    public is_veren getVer(Long id){
        Connection con =ConnectionManager.baglanti();
        try{
            Statement st =con.createStatement();
            ResultSet rs =st.executeQuery("select * from is_veren where isveren_id="+id);
            rs.next();
            this.ver=new is_veren(rs.getLong("isveren_id"),rs.getString("isveren_ad"),
                    rs.getString("isveren_soyad"),rs.getString("isveren_iletisim"),
                    rs.getString("isveren_sigorta"),rs.getString("isveren_servis"),rs.getString("aciklama"),rs.getLong("ilce_id"));
        }
        catch(SQLException ex){
            System.out.println(ex.getMessage());
            
        }
        return this.ver;
    }
    
  
   
    
    
     public ArrayList<is_veren> list(){
         this.verlist=new ArrayList();
        Connection con =ConnectionManager.baglanti();
        try{
            Statement st =con.createStatement();
            ResultSet rs =st.executeQuery("select * from is_veren");
           while(rs.next()) {
               is_veren is=new is_veren();
               is.setIsveren_id(rs.getLong("isveren_id"));
               is.setIsveren_ad(rs.getString("isveren_ad"));
               is.setIsveren_soyad(rs.getString("isveren_soyad"));
               is.setIsveren_iletisim(rs.getString("isveren_iletisim"));
               is.setIsveren_sigorta(rs.getString("isveren_sigorta"));
               is.setIsveren_servis(rs.getString("isveren_servis"));
               is.setAciklama(rs.getString("aciklama"));
               is.setIlce_id(rs.getLong("ilce_id"));
               is.setKisi(kisiGetir(rs.getLong("isveren_id")));

               
               this.verlist.add(is);     
           }
        }
        catch(SQLException ex){
            System.out.println(ex.getMessage());
            
        }
        
        
        return verlist;
    }
      
     
         public ArrayList<bakılacak_kisi> kisiGetir(Long id){
    ArrayList<bakılacak_kisi> kisi=new ArrayList();
    Connection con=ConnectionManager.baglanti();
    try{
        Statement st=con.createStatement();
        ResultSet rs=st.executeQuery("select*from bakilacak_kisi where isveren_id="+id);
        while(rs.next()){
        bakılacak_kisi i=new bakılacak_kisi();
        i.setKisi_id(rs.getLong("kisi_id"));
        i.setKisi_ad(rs.getString("kisi_ad"));
        i.setKisi_soyad(rs.getString("kisi_soyad"));
        i.setKisi_yas(rs.getLong("kisi_yas"));
        i.setAciklama(rs.getString("aciklama"));
        i.setIsveren_id(rs.getLong("isveren_id"));
        kisi.add(i);
    }
    }catch(SQLException ex){
        System.out.println(ex.getMessage());
    }
    return kisi;
    }
     
       public void delete(is_veren is){
        Connection con =ConnectionManager.baglanti();
        
        try{
            Statement st =con.createStatement();
            st.executeUpdate("delete from is_veren where isveren_id="+is.getIsveren_id());
        }
        catch(SQLException ex){
            System.out.println(ex.getMessage());}
    }
        public void update(is_veren is){
        Connection con =ConnectionManager.baglanti();
        try{
            Statement st =con.createStatement();
            st.executeUpdate("update is_veren set isveren_ad='"+is.getIsveren_ad()+"',isveren_soyad='"+is.getIsveren_soyad()
                    +"',isveren_iletisim='"+is.getIsveren_iletisim()+"',isveren_sigorta='"+is.getIsveren_sigorta()+"',isveren_servis='"+is.getIsveren_servis()
                    +"',aciklama='"+is.getAciklama()+"',ilce_id='"+is.getIlce_id()
                    +"' where isveren_id="+is.getIsveren_id());
        }
        catch(SQLException ex){
            System.out.println(ex.getMessage());
            
        }
        }
        public void create(is_veren is){
              Connection con =ConnectionManager.baglanti();
        try{
            Statement st =con.createStatement();
            
            st.executeUpdate("insert into is_veren(isveren_id,isveren_ad,isveren_soyad,isveren_iletisim,isveren_sigorta,isveren_servis,aciklama,ilce_id) values ('"+is.getIsveren_id()
                    +"','"+is.getIsveren_ad()+"','"+is.getIsveren_soyad()+"','"+is.getIsveren_iletisim()+"','"+is.getIsveren_sigorta()+"','"+is.getIsveren_servis()+"','"+is.getAciklama()+"','"+is.getIlce_id()+"')");
            System.out.println("is veren eklendi");
        }
        catch(SQLException ex){
            System.out.println(ex.getMessage());
            
        }
        }
        
       
    
}
