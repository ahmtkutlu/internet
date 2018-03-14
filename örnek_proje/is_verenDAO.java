
package DAO;

import Entity.is_veren;
import Utilitiy.ConnectionManager;
import java.util.ArrayList;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.Connection;

public class is_verenDAO {
    
     private is_veren is_veren=null;
    private ArrayList<is_veren> is_verenlist=null;
    
    public is_veren getIsVeren(int id){
        Connection con=ConnectionManager.baglanti();
    try{
        Statement st=con.createStatement();
        ResultSet rs=st.executeQuery("select*from is_veren where isveren_id="+id);
        while(rs.next()){
            this.is_veren=new is_veren(rs.getInt("isveren_id"),rs.getString("isveren_ad"),rs.getString("isveren_soyad"),rs.getString("isveren_iletisim"),rs.getString("isveren_sigorta"),rs.getString("isveren_servis"),rs.getString("aciklama"),rs.getInt("ilce_id"));
        }
    }catch(SQLException ex){
        System.out.println(ex.getMessage());
    }
        return this.is_veren;
    }
    
    
    public ArrayList<is_veren> list(){
        this.is_verenlist=new ArrayList();
        Connection con=ConnectionManager.baglanti();
    try{
        Statement st=con.createStatement();
        ResultSet rs=st.executeQuery("select*from is_veren");
        while(rs.next()){
            this.is_verenlist.add(new is_veren(rs.getInt("isveren_id"),rs.getString("isveren_ad"),rs.getString("isveren_soyad"),rs.getString("isveren_iletisim"),rs.getString("isveren_sigorta"),rs.getString("isveren_servis"),rs.getString("aciklama"),rs.getInt("ilce_id")));
        }
        this.is_veren=new is_veren(rs.getInt("isveren_id"),rs.getString("isveren_ad"),rs.getString("isveren_soyad"),rs.getString("isveren_iletisim"),rs.getString("isveren_sigorta"),rs.getString("isveren_servis"),rs.getString("aciklama"),rs.getInt("ilce_id"));
        }catch(SQLException ex){
        System.out.println(ex.getMessage());
    }
        return this.is_verenlist;
    }
    
    
    public void delete(int id){
    Connection con=ConnectionManager.baglanti();
    try{
        Statement st=con.createStatement();
        st.executeUpdate("delete from is_veren where isveren_id="+id);
    }catch(SQLException ex){
        System.out.println(ex.getMessage());
    }
    }
    
    
    public void update(is_veren k){
    Connection con=ConnectionManager.baglanti();
    try{
        Statement st=con.createStatement();
        st.executeUpdate("update is_veren set isveren_ad='"+k.getIsveren_ad()+"',arayan_soyad='"+k.getIsveren_soyad()+"','"+k.getAciklama()+"' where arayan_id='"+k.getIsveren_id()+"'");
    }catch(SQLException ex){
        System.out.println(ex.getMessage());
    }
    }
    
    
    public void create(is_veren k){
    Connection con=ConnectionManager.baglanti();
    try{
        Statement st=con.createStatement();
        st.executeUpdate("insert into is_veren(isveren_id,isveren_ad,isveren_soyad,isveren_iletisim,isveren_sigorta,isveren_servis,aciklama,ilce_id) values('"+k.getIsveren_id()+"','"+k.getIsveren_ad()+"','"+k.getIsveren_soyad()+"','"+k.getIsveren_iletisim()+"','"+k.getIsveren_sigorta()+"','"+k.getIsveren_servis()+"','"+k.getAciklama()+"','"+k.getIlce_id()+"')");
    }catch(SQLException ex){
        System.out.println(ex.getMessage());
    }
   }

}
