/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;


import Entity.ilce;
import Utility.ConnectionManager;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 *
 * @author asus
 */
public class ilceDAO {
      private ilce ilce_=null;
      
    private ArrayList<ilce> ilce_list=null;
    private is_verenDAO verDAO;
    private is_arayanDAO araDao;

    public is_verenDAO getVerDAO() {
        if(this.verDAO==null)
            this.verDAO=new is_verenDAO();
        return verDAO;
    }

    public void setVerDAO(is_verenDAO verDAO) {
        this.verDAO = verDAO;
    }

    public is_arayanDAO getAraDao() {
        if(this.araDao==null)
            this.araDao=new is_arayanDAO();
        return araDao;
    }

    public void setAraDao(is_arayanDAO araDao) {
        this.araDao = araDao;
    }
    
    
    
   
    public ilce getIlce(Long ilce_id){
        Connection con =ConnectionManager.baglanti();
        
        try{
            Statement st =con.createStatement();
            ResultSet rs =st.executeQuery("select * from ilce where ilce_id="+ilce_id);
            rs.next();
            this.ilce_ =new ilce(rs.getString("ilce_ad"),rs.getLong("il_id"));
        }
        catch(SQLException ex){
            System.out.println(ex.getMessage());
            
        }
        return this.ilce_;
    }
     public ArrayList<ilce> list(){
         this.ilce_list=new ArrayList<>();
        Connection con =ConnectionManager.baglanti();
        try{
            Statement st =con.createStatement();
            ResultSet rs =st.executeQuery("select * from ilce");
           while(rs.next()) {
        ilce i=new ilce();
        i.setIlce_id(rs.getLong("ilce_id"));
        i.setIlce_ad(rs.getString("ilce_ad"));
        i.setIl_id(rs.getLong("il_id"));
           ilce_list.add(i);

           }
            
        }
        catch(SQLException ex){
            System.out.println(ex.getMessage());
            
        }
        return this.ilce_list;
    }
      
       public void delete(Long id){
        Connection con =ConnectionManager.baglanti();
        try{
            Statement st =con.createStatement();
            st.executeUpdate("delete from ilce where ilce_id="+id);
        }
        catch(SQLException ex){
            System.out.println(ex.getMessage());}
    }
        public void update(ilce i){
        Connection con =ConnectionManager.baglanti();
        try{
            Statement st =con.createStatement();
            st.executeUpdate("update ilce set ilce_ad='"+i.getIlce_ad()+"',il_id='"+i.getIl_id()+"' where ilce_id="+i.getIlce_id());
        }
        catch(SQLException ex){
            System.out.println(ex.getMessage());
            
        }
        }
        public void create(ilce i){
              Connection con =ConnectionManager.baglanti();
        try{
            
            
            
            
            
            
            Statement st =con.createStatement();
                        System.out.println(" eklendi");

            st.executeUpdate("insert into ilce(ilce_ad,il_id) values ('"+i.getIlce_ad()+"','"+i.getIl_id()+"')");
            System.out.println("ilce eklendi");
        }
        catch(SQLException ex){
            System.out.println(ex.getMessage());
            
        }
        }
        
         public static void main(String args[]){
    ilceDAO ilce=new ilceDAO();
    ilce i=new ilce(26l,"ahha",4l);
    ilce.create(i);
    
    }
    
}
