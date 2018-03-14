
package DAO;

import java.util.ArrayList;
import java.sql.SQLException;
import java.sql.Connection;
import Entity.resim;
import Utilitiy.ConnectionManager;
import java.sql.Statement;
import java.sql.ResultSet;

public class resimDAO {
    
    
    private resim resim=null;
    private ArrayList<resim> resimlist=null;
    
    public resim getresim(int id){
    Connection con=ConnectionManager.baglanti();
    try{
        Statement st=con.createStatement();
        ResultSet rs=st.executeQuery("select*from resim where resim_id="+id);
        while(rs.next()){
            this.resim=new resim(rs.getInt("resim_id"),rs.getString("resim_dosya"),rs.getInt("arayan_id"));
        }
    }catch(SQLException ex){
        System.out.println(ex.getMessage());
    }
    return this.resim;
    }
    
    
    public ArrayList<resim> list(){
    this.resimlist=new ArrayList();
    Connection con=ConnectionManager.baglanti();
    try{
        Statement st=con.createStatement();
        ResultSet rs=st.executeQuery("select*from cv");
        while(rs.next()){
            this.resimlist.add(new resim(rs.getInt("resim_id"),rs.getString("resim_dosya"),rs.getInt("arayan_id")));
        }
    this.resim=new resim(rs.getInt("resim_id"),rs.getString("resim_dosya"),rs.getInt("arayan_id"));
    
    }catch(SQLException ex){
        System.out.println(ex.getMessage());
    }
    return this.resimlist;
    }
    
    
    public void delete(int id){
    Connection con=ConnectionManager.baglanti();
    try{
        Statement st=con.createStatement();
        st.executeUpdate("delete from resim where resim_id="+id);
    }catch(SQLException ex){
        System.out.println(ex.getMessage());
    }
     }
    
    public void update(resim k){
    Connection con=ConnectionManager.baglanti();
    try{
        Statement st=con.createStatement();
        st.executeUpdate("update resim set resim_dosya='"+k.getResim_dosya()+"arayan_id='"+k.getArayan_id()+" where resim_id='"+k.getResim_id()+"'");
    }catch(SQLException ex){
        System.out.println(ex.getMessage());
    }
    }
    
    
    public void create(resim k){
    Connection con=ConnectionManager.baglanti();
    try{
        Statement st=con.createStatement();
        st.executeUpdate("insert into resim(cv_id,cv_dosya,arayan_id) values('"+k.getResim_id()+"','"+k.getResim_dosya()+"','"+k.getArayan_id()+"')");
    }catch(SQLException ex){
    }
   }
    
}
