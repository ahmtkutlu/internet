
package DAO;

import java.util.ArrayList;
import java.sql.SQLException;
import java.sql.Connection;
import Entity.cv;
import Utilitiy.ConnectionManager;
import java.sql.Statement;
import java.sql.ResultSet;

public class cvDAO {
        
    private cv cv=null;
    private ArrayList<cv> cvlist=null;
    
    public cv getCv(int id){
    Connection con=ConnectionManager.baglanti();
    try{
        Statement st=con.createStatement();
        ResultSet rs=st.executeQuery("select*from cv where cv_id="+id);
        while(rs.next()){
            this.cv=new cv(rs.getInt("cv_id"),rs.getString("cv_dosya"),rs.getInt("arayan_id"));
        }
    }catch(SQLException ex){
        System.out.println(ex.getMessage());
    }
    return this.cv;
    }
    
    
    public ArrayList<cv> list(){
    this.cvlist=new ArrayList();
    Connection con=ConnectionManager.baglanti();
    try{
        Statement st=con.createStatement();
        ResultSet rs=st.executeQuery("select*from cv");
        while(rs.next()){
            this.cvlist.add(new cv(rs.getInt("cv_id"),rs.getString("cv_dosya"),rs.getInt("arayan_id")));
        }
    this.cv=new cv(rs.getInt("cv_id"),rs.getString("cv_dosya"),rs.getInt("arayan_id"));
    
    }catch(SQLException ex){
        System.out.println(ex.getMessage());
    }
    return this.cvlist;
    }
    
    
    public void delete(int id){
    Connection con=ConnectionManager.baglanti();
    try{
        Statement st=con.createStatement();
        st.executeUpdate("delete from cv where cv_id="+id);
    }catch(SQLException ex){
        System.out.println(ex.getMessage());
    }
     }
    
    public void update(cv k){
    Connection con=ConnectionManager.baglanti();
    try{
        Statement st=con.createStatement();
        st.executeUpdate("update cv set cv_dosya='"+k.getCv_dosya()+"arayan_id='"+k.getArayan_id()+" where cv_id='"+k.getCv_id()+"'");
    }catch(SQLException ex){
        System.out.println(ex.getMessage());
    }
    }
    
    
    public void create(cv k){
    Connection con=ConnectionManager.baglanti();
    try{
        Statement st=con.createStatement();
        st.executeUpdate("insert into cv(cv_id,cv_dosya,arayan_id) values('"+k.getCv_id()+"','"+k.getCv_dosya()+"','"+k.getArayan_id()+"')");
    }catch(SQLException ex){
    }
   }
    
}
