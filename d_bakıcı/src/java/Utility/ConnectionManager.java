package Utility;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ConnectionManager {
    
    private static String sglurl="jdbc:mysql://localhost:3306/bakıcı?zeroDateTimeBehavior=convertToNull";
    private static String driverName="com.mysql.jdbc.Driver";
    private static String username="sara";
    private static String password="sara123";
    private static Connection con;
   
    public static Connection baglanti(){
    
        try{
            
            Class.forName(driverName).newInstance();
            System.out.println("baglanti basarili");
            con=DriverManager.getConnection(sglurl,username,password);
        }
        catch(SQLException e){
            
            System.out.println("Veritabanına bağlantı kurulamadı");
          }
        
        catch(ClassNotFoundException | InstantiationException |  IllegalAccessException ex){
            
            System.out.println("Sunucu bulunamadı"); 
        }
        
    return con;
    }   
    
 public void listele(){
       
       try{
           Statement st=con.createStatement();
           ResultSet rs=st.executeQuery("select*from il");
           while(rs.next()){
              
               System.out.println("il_id =  " +  rs.getInt(1));
           }
       }catch(SQLException e){
           
           System.out.println("Utilitiy.ConnectionManager.listele()");
       }
    
    }
    
    
    public static void main(String args[]){
    ConnectionManager cm=new ConnectionManager();
    cm.baglanti();
    cm.listele();
    
    }
}