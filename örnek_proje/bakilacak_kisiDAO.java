
package DAO;

import Entity.bakilacak_kisi;
import Utilitiy.ConnectionManager;
import java.util.ArrayList;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.Connection;

public class bakilacak_kisiDAO {
    
    private bakilacak_kisi bakilacak_kisi=null;
    private ArrayList<bakilacak_kisi> bakilacak_kisilist=null;
    
    public bakilacak_kisi getBakilacak_kisi(int id){
        Connection con=ConnectionManager.baglanti();
    try{
        Statement st=con.createStatement();
        ResultSet rs=st.executeQuery("select*from bakilacak_kisi where kisi_id="+id);
        while(rs.next()){
            this.bakilacak_kisi=new bakilacak_kisi(rs.getInt("kisi_id"),rs.getString("kisi_ad"),rs.getString("kisi_soyad"),rs.getInt("kisi_yas"),rs.getString("kisi_aciklama"),rs.getInt("isveren_id"));
        }
    }catch(SQLException ex){
        System.out.println(ex.getMessage());
    }
        return this.bakilacak_kisi;
    }
    
    
    public ArrayList<bakilacak_kisi> list(){
        this.bakilacak_kisilist=new ArrayList();
        Connection con=ConnectionManager.baglanti();
    try{
        Statement st=con.createStatement();
        ResultSet rs=st.executeQuery("select*from bakilacak_kisi");
        while(rs.next()){
            this.bakilacak_kisilist.add(new bakilacak_kisi(rs.getInt("kisi_id"),rs.getString("kisi_ad"),rs.getString("kisi_soyad"),rs.getInt("kisi_yas"),rs.getString("kisi_aciklama"),rs.getInt("isveren_id")));
        }
        this.bakilacak_kisi=new bakilacak_kisi(rs.getInt("kisi_id"),rs.getString("kisi_ad"),rs.getString("kisi_soyad"),rs.getInt("kisi_yas"),rs.getString("kisi_aciklama"),rs.getInt("isveren_id"));
        }catch(SQLException ex){
        System.out.println(ex.getMessage());
    }
        return this.bakilacak_kisilist;
    }
    
    
    public void delete(int id){
    Connection con=ConnectionManager.baglanti();
    try{
        Statement st=con.createStatement();
        st.executeUpdate("delete from bakilacak_kisi where kisi_id="+id);
    }catch(SQLException ex){
        System.out.println(ex.getMessage());
    }
    }
    
    
    public void update(bakilacak_kisi k){
    Connection con=ConnectionManager.baglanti();
    try{
        Statement st=con.createStatement();
        st.executeUpdate("update bakilacak_kisi set kisi_ad='"+k.getKisi_ad()+"',kisi_soyad='"+k.getKisi_soyad()+"',aciklama'"+k.getAciklama()+"' where kisi_id='"+k.getKisi_id()+"'");
    }catch(SQLException ex){
        System.out.println(ex.getMessage());
    }
    }
    
    
    public void create(bakilacak_kisi k){
    Connection con=ConnectionManager.baglanti();
    try{
        Statement st=con.createStatement();
        st.executeUpdate("insert into bakilacak_kisi(kisi_id,kisi_ad,kisi_soyad,kisi_yas,aciklama,isveren_id) values('"+k.getKisi_id()+"','"+k.getKisi_ad()+"','"+k.getKisi_soyad()+"','"+k.getKisi_yas()+"','"+k.getAciklama()+"','"+k.getIsveren_id()+"'");
    }catch(SQLException ex){
        System.out.println(ex.getMessage());
    }
   }
    
}
