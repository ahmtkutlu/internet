/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utility;


import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Kutlu
 */
public class Connector {
      public Connection connect(){
         Connection c=null;
          try {
              Class.forName("com.mysql.jdbc.Driver");
              c=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb?user=root&password=3306");
          } catch (Exception e) {
              System.out.println(e.getMessage());
          }
         
      return c;
    }
}
