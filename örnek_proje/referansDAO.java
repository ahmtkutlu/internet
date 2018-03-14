
package DAO;

import Entity.referans;
import Utilitiy.ConnectionManager;
import java.util.ArrayList;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.Connection;

public class referansDAO {
    
    private referans referans=null;
    private ArrayList<referans> referanslist=null;
    
    public referans getReferans(int id){
        Connection con=ConnectionManager.baglanti();
    try{
        Statement st=con.createStatement();
        ResultSet rs=st.executeQuery("select*from referans where ref_id="+id);
        while(rs.next()){
            this.referans=new referans(rs.getInt("ref_id"),rs.getString("ref_ad"),rs.getString("ref_soyad"));
        }
    }catch(SQLException ex){
        System.out.println(ex.getMessage());
    }
        return this.referans;
    }
    
    
    public ArrayList<referans> list(){
        this.referanslist=new ArrayList();
        Connection con=ConnectionManager.baglanti();
    try{
        Statement st=con.createStatement();
        ResultSet rs=st.executeQuery("select*from referans");
        while(rs.next()){
            this.referanslist.add(new referans(rs.getInt("ref_id"),rs.getString("ref_ad"),rs.getString("ref_soyad")));
        }
        this.referans=new referans(rs.getInt("ref_id"),rs.getString("ref_ad"),rs.getString("ref_soyad"));
    }catch(SQLException ex){
        System.out.println(ex.getMessage());
    }
        return this.referanslist;
    }
    
    
    public void delete(int id){
    Connection con=ConnectionManager.baglanti();
    try{
        Statement st=con.createStatement();
        st.executeUpdate("delete from referans where ref_id="+id);
    }catch(SQLException ex){
        System.out.println(ex.getMessage());
    }
    }
    
    
    public void update(referans k){
    Connection con=ConnectionManager.baglanti();
    try{
        Statement st=con.createStatement();
        st.executeUpdate("update referans set ref_ad='"+k.getRef_ad()+"',ref_soyad='"+k.getRef_soyad()+"'"+k.getRef_soyad()+"' where ref_id='"+k.getRef_id()+"'");
    }catch(SQLException ex){
        System.out.println(ex.getMessage());
    }
    }
    
    
    public void create(referans k){
    Connection con=ConnectionManager.baglanti();
    try{
        Statement st=con.createStatement();
        st.executeUpdate("insert into referans(ref_id,ref_ad,ref_soyad) values('"+k.getRef_id()+"','"+k.getRef_ad()+"','"+k.getRef_soyad()+"')");
    }catch(SQLException ex){
        System.out.println(ex.getMessage());
    }
   }
    
}