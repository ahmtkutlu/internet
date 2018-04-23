
package DAO;

import Entity.grup;
import Entity.il;
import Utility.ConnectionManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class grupDAO {
  private grup g_=null;
    private ArrayList<grup> g_list=null;
    
    public grup getGrup(String password){
        Connection con =ConnectionManager.baglanti();
        try{
            Statement st =con.createStatement();
            ResultSet rs =st.executeQuery("select * from grup where password="+password);
            rs.next();
            this.g_=new grup(rs.getString("password"), rs.getString("kullanici_adi"), rs.getString("grubu"));
        }
        catch(SQLException ex){
            System.out.println(ex.getMessage());
            
        }
        return this.g_;
    }
     public ArrayList<grup> list(){
         this.g_list=new ArrayList();
        Connection con =ConnectionManager.baglanti();
        try{
            Statement st =con.createStatement();
            ResultSet rs =st.executeQuery("select * from grup");
           while(rs.next()) {
               grup g=new grup();
               g.setPassword(rs.getString("password"));
               g.setKullanici_adi(rs.getString("kullanici_adi"));
               g.setGrubu(rs.getString("grubu"));
                            
               this.g_list.add(g);     
           }
        }
        catch(SQLException ex){
            System.out.println(ex.getMessage());
            
        }
        return g_list;
    }
      
       public void delete(String password){
        Connection con =ConnectionManager.baglanti();
        
        try{
            Statement st =con.createStatement();
            st.executeUpdate("delete from grup where password="+password);
        }
        catch(SQLException ex){
            System.out.println(ex.getMessage());}
    }
        public void update(grup g){
        Connection con =ConnectionManager.baglanti();
        try{
            Statement st =con.createStatement();
            st.executeUpdate("update grup set kullanici_adi='"+g.getKullanici_adi()+"' where password="+g.getPassword());
        }
        catch(SQLException ex){
            System.out.println(ex.getMessage());
            
        }
        }
        public void create(grup g){
              Connection con =ConnectionManager.baglanti();
        try{
            Statement st =con.createStatement();
            
            st.executeUpdate("insert into grup(password,kullanici_adi,grubu) values ('"+g.getPassword()+"','"+g.getKullanici_adi()+"','"+g.getGrubu()+"')");
            System.out.println("grup eklendi");
        }
        catch(SQLException ex){
            System.out.println(ex.getMessage());
            
        }
        }
        
  
}
