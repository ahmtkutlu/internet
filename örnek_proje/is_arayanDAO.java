
package DAO;

import Entity.is_arayan;
import Utilitiy.ConnectionManager;
import java.util.ArrayList;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.Connection;

public class is_arayanDAO {
    
     private is_arayan is_arayan=null;
    private ArrayList<is_arayan> is_arayanlist=null;
    
    public is_arayan getIsArayan(int id){
        Connection con=ConnectionManager.baglanti();
    try{
        Statement st=con.createStatement();
        ResultSet rs=st.executeQuery("select*from is_arayan where arayan_id="+id);
        while(rs.next()){
            this.is_arayan=new is_arayan(rs.getInt("arayan_id"),rs.getString("arayan_ad"),rs.getString("arayan_soyad"),rs.getInt("arayan_yas"),rs.getString("arayan_uyruk"),rs.getString("arayan_email"),rs.getString("arayan_iletisim"),rs.getString("aciklama"),rs.getInt("ilce_id"));
        }
    }catch(SQLException ex){
        System.out.println(ex.getMessage());
    }
        return this.is_arayan;
    }
    
    
    public ArrayList<is_arayan> list(){
        this.is_arayanlist=new ArrayList();
        Connection con=ConnectionManager.baglanti();
    try{
        Statement st=con.createStatement();
        ResultSet rs=st.executeQuery("select*from is_arayan");
        while(rs.next()){
            this.is_arayanlist.add(new is_arayan(rs.getInt("arayan_id"),rs.getString("arayan_ad"),rs.getString("arayan_soyad"),rs.getInt("arayan_yas"),rs.getString("arayan_uyruk"),rs.getString("arayan_email"),rs.getString("arayan_iletisim"),rs.getString("aciklama"),rs.getInt("ilce_id")));
        }
        this.is_arayan=new is_arayan(rs.getInt("arayan_id"),rs.getString("arayan_ad"),rs.getString("arayan_soyad"),rs.getInt("arayan_yas"),rs.getString("arayan_uyruk"),rs.getString("arayan_email"),rs.getString("arayan_iletisim"),rs.getString("aciklama"),rs.getInt("ilce_id"));
        }catch(SQLException ex){
        System.out.println(ex.getMessage());
    }
        return this.is_arayanlist;
    }
    
    
    public void delete(int id){
    Connection con=ConnectionManager.baglanti();
    try{
        Statement st=con.createStatement();
        st.executeUpdate("delete from is_arayan where arayan_id="+id);
    }catch(SQLException ex){
        System.out.println(ex.getMessage());
    }
    }
    
    
    public void update(is_arayan k){
    Connection con=ConnectionManager.baglanti();
    try{
        Statement st=con.createStatement();
        st.executeUpdate("update is_arayan set arayan_ad='"+k.getArayan_ad()+"',arayan_soyad='"+k.getArayan_soyad()+"' where arayan_id='"+k.getArayan_id()+"'");
    }catch(SQLException ex){
        System.out.println(ex.getMessage());
    }
    }
    
    
    public void create(is_arayan k){
    Connection con=ConnectionManager.baglanti();
    try{
        Statement st=con.createStatement();
        st.executeUpdate("insert into is_arayan(arayan_id,arayan_ad,arayan_soyad,arayan_yas,arayan_uyruk,arayan_email,arayan_iletisim,aciklama,ilce_id) values('"+k.getArayan_id()+"','"+k.getArayan_ad()+"','"+k.getArayan_soyad()+"','"+k.getArayan_yas()+"','"+k.getArayan_uyruk()+"','"+k.getArayan_email()+"','"+k.getArayan_iletisim()+"','"+k.getAciklama()+"','"+k.getIlce_id()+"')");
    }catch(SQLException ex){
        System.out.println(ex.getMessage());
    }
   }
    
}
