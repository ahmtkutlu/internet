
package DAO;

import Entity.kategori;
import Utilitiy.ConnectionManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class kategoriDAO {
    
    private kategori kategori=null;
    private ArrayList<kategori> kategorilist=null;
    
    public kategori getKategori(int id){
    Connection con=ConnectionManager.baglanti();
    try{
    Statement st=con.createStatement();
    ResultSet rs=st.executeQuery("select*from kategori where kategori_id = " +id);
    while(rs.next()){//bir sonraki gelene kadar
    this.kategori=new kategori(rs.getInt("kategori_id"),rs.getString("kategori_ad"));
    }
    }catch(SQLException ex){
    }
    return this.kategori;
    }
    
    
    // listeme işlemi
    public ArrayList<kategori> list(){
    this.kategorilist=new ArrayList();
    Connection con=ConnectionManager.baglanti();
        try{
        Statement st=con.createStatement();
        ResultSet rs=st.executeQuery("select*from kategori");
        while(rs.next()){
        this.kategorilist.add(new kategori(rs.getInt("kategori_id"),rs.getString("kategori_ad")));
        }
        this.kategori=new kategori(rs.getInt("kategori_id"),rs.getString("kategori_ad"));
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
    return this.kategorilist;
    }
    
    //Ekle 
    public void create(kategori k){
    Connection con=ConnectionManager.baglanti();
    try{
        Statement st=con.createStatement();
        st.executeUpdate("insert into kategori(kategori_id,kategori_ad) values ('"+k.getKategori_id()+"','"+k.getKategori_ad()+"') " );
        System.out.println("deneme");
    }catch(SQLException ex){
        System.out.println(ex.getMessage());
    }
    }
    
    
    //Sil
    public void delete(int id){
        Connection con=ConnectionManager.baglanti();
        try{
            Statement st=con.createStatement(); 
            System.out.println("dkn");
         st.executeUpdate("delete from kategori where kategori_id="+id);
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
    }
    
    
    //güncelle
    public void update(kategori k){//kategori tablosunda herhangi bir sütuna göre güncelleme yapar
    Connection con=ConnectionManager.baglanti();
    try{
        Statement st=con.createStatement();
        st.executeUpdate("update kategori set kategori_ad='"+k.getKategori_ad()+"' where idKategori="+k.getKategori_id());
    }catch(SQLException ex){
        System.out.println(ex.getMessage());
    }
    }
     
}
