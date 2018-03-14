
package DAO;

import java.util.ArrayList;
import Entity.il;
import Utilitiy.ConnectionManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

public class ilDAO {
    
    private il il=null;
    private ArrayList<il> illist=null;
    
    public il getIl(int id) {
        Connection con=ConnectionManager.baglanti();
        try{
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery("select*from il where il_id= "+id);
            while(rs.next()){
                this.il=new il(rs.getInt("il_id"),rs.getString("il_ad"));
           }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
     return this.il;
}
        
    
        public ArrayList<il> list(){
            this.illist=new ArrayList();
            Connection con=ConnectionManager.baglanti();
            try{
                Statement st=con.createStatement();
                ResultSet rs=st.executeQuery("select*from il");
                while(rs.next()){
                    this.illist.add(new il(rs.getInt("il_id"),rs.getString("il_ad")));
                }
                this.il=new il(rs.getInt("il_id"),rs.getString("il_ad"));
            }catch(SQLException ex){
                System.out.println(ex.getMessage());
            }
            return this.illist;
        }
        
        
        public void delete(int id){
            Connection con=ConnectionManager.baglanti();
            try{
                Statement st=con.createStatement();
                st.executeUpdate("delete from il where il_id="+id);
            }catch(SQLException ex){
                System.out.println(ex.getMessage());
            }
        }
        
        
        public void update(il k){
            Connection con=ConnectionManager.baglanti();
            try{
                Statement st=con.createStatement();
                st.executeUpdate("update il set il_ad='"+k.getIl_ad()+"' where il_id="+k.getIl_id());
            }catch(SQLException ex){
                System.out.println(ex.getMessage());
            }
        }
        
        public void create(il k){
            Connection con=ConnectionManager.baglanti();
            try{
                Statement st=con.createStatement();
                st.executeUpdate("insert into il(il_id,il_ad) values('"+k.getIl_id()+"','"+k.getIl_ad()+"')");
            }catch(SQLException ex){
                System.out.println(ex.getMessage());
            }
        }
        
        
        
}

        
 

