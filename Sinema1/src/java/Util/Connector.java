/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Connector {
    
    private Connection connection;
    
    public Connection connect(){
        
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            this.connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/sinema_proje?user=root&password=123456");
            System.out.println("---------------baglantı başarılı--------------");
            
            
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException ex) {
            System.out.println(ex.getMessage());
        }
    return this.connection;
    }
    
}
