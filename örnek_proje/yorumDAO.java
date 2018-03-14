
package DAO;

import Entity.yorum;
import Utilitiy.ConnectionManager;
import java.util.ArrayList;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.Connection;

public class yorumDAO {
    
     private yorum yorum=null;
    private ArrayList<yorum> yorumlist=null;
    
    public yorum getYorum(int id){
        Connection con=ConnectionManager.baglanti();
    try{
        Statement st=con.createStatement();
        ResultSet rs=st.executeQuery("select*from yorum where y_id="+id);
        while(rs.next()){
            this.yorum=new yorum(rs.getInt("y_id"),rs.getString("y_ad"),rs.getString("y_yorum"),rs.getInt("arayan_id"));
        }
    }catch(SQLException ex){
        System.out.println(ex.getMessage());
    }
        return this.yorum;
    }
    
    
    public ArrayList<yorum> list(){
        this.yorumlist=new ArrayList();
        Connection con=ConnectionManager.baglanti();
    try{
        Statement st=con.createStatement();
        ResultSet rs=st.executeQuery("select*from yorum");
        while(rs.next()){
            this.yorumlist.add(new yorum(rs.getInt("y_id"),rs.getString("y_ad"),rs.getString("y_yorum"),rs.getInt("arayan_id")));
        }
        this.yorum=new yorum(rs.getInt("y_id"),rs.getString("y_ad"),rs.getString("y_yorum"),rs.getInt("arayan_id"));
        }catch(SQLException ex){
        System.out.println(ex.getMessage());
    }
        return this.yorumlist;
    }
    
    
    public void delete(int id){
    Connection con=ConnectionManager.baglanti();
    try{
        Statement st=con.createStatement();
        st.executeUpdate("delete from yorum where y_id="+id);
    }catch(SQLException ex){
        System.out.println(ex.getMessage());
    }
    }
    
    
    public void update(yorum k){
    Connection con=ConnectionManager.baglanti();
    try{
        Statement st=con.createStatement();
        st.executeUpdate("update yorum set y_yorum='"+k.getY_yorum()+"' where y_id='"+k.getY_id()+"'");
    }catch(SQLException ex){
        System.out.println(ex.getMessage());
    }
    }
    
    
    public void create(yorum k){
    Connection con=ConnectionManager.baglanti();
    try{
        Statement st=con.createStatement();
        st.executeUpdate("insert into yorum(y_id,y_ad,y_yorum,arayan_id) values('"+k.getY_id()+"','"+k.getY_ad()+"','"+k.getY_yorum()+"','"+k.getArayan_id()+"'");
    }catch(SQLException ex){
        System.out.println(ex.getMessage());
    }
   }
    
}
