
package DAO;

import java.util.ArrayList;
import Entity.ilce;
import Utilitiy.ConnectionManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ilceDAO {
    
    private ilce ilce=null;
    private ArrayList<ilce> ilcelist=null;
    
    public ilce getIlce(int id){
    Connection con=ConnectionManager.baglanti();
    try{
        Statement st=con.createStatement();
        ResultSet rs=st.executeQuery("select*from ilce where ilce_id="+id);
        while(rs.next()){
            this.ilce=new ilce(rs.getInt("ilce_id"),rs.getString("ilce_ad"));
        }
    }catch(SQLException ex){
        System.out.println(ex.getMessage());
    }
    return this.ilce;
    }

public ArrayList<ilce> list(){
    this.ilcelist=new ArrayList();
    Connection con=ConnectionManager.baglanti();
    try{
        Statement st=con.createStatement();
        ResultSet rs=st.executeQuery("select*from ilce");
        while(rs.next()){
            this.ilcelist.add(new ilce(rs.getInt("ilce_id"),rs.getString("ilce_ad")));
        }
        this.ilce=new ilce(rs.getInt("il_id"),rs.getString("il_ad"));
    }catch(SQLException ex){
        System.out.println(ex.getMessage());
    }
     return this.ilcelist;
}


    public void delete(int id){
        Connection con=ConnectionManager.baglanti();
        try{
            Statement st=con.createStatement();
            st.executeUpdate("delete from ilce where ilce_id="+id);
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
    }

    public void update(ilce k){
        Connection con=ConnectionManager.baglanti();
        try{
            Statement st=con.createStatement();
            st.executeUpdate("update ilce set il_ad='"+k.getIlce_ad()+"' where '"+k.getIlce_ad()+"'");
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
    }
    
    public void create(ilce k){
        Connection con=ConnectionManager.baglanti();
        try{
            Statement st=con.createStatement();
            st.executeUpdate("insert into ilce(ilce_id,il_ad) values('"+k.getIlce_id()+"','"+k.getIlce_ad()+"')");
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
    }

}
