/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entity.Galeri;
import Utility.Connector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Kutlu
 */
public class GaleriDAO {
       Connector con = new Connector();
       Connection connection = con.connect();
       
       
       
        public Galeri find(int id) {
        Galeri galeri = null;
        try {
            String query = "select * from galeri where idgaleri = ?";
            PreparedStatement pst = connection.prepareStatement(query);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();           
            rs.next();
            galeri = new Galeri();
            
            galeri.setIdgaleri(rs.getInt("idgaleri"));
           // galeri.setFilm((rs.getInt("filmler_idfilmler")));
            galeri.setResim(rs.getString("resim"));       


        } catch (SQLException ex) {
            System.out.println(ex.getMessage())  ;         }
        return galeri;

    }
       
       
       
       
       public List<Galeri> findAll() {
         List<Galeri> ListeGaleri = new ArrayList();
        try {
            String query = "select * from galeri order by idgaleri";
            PreparedStatement pst = connection.prepareStatement(query);
            ResultSet rs = pst.executeQuery();                  
            while(rs.next()){
            Galeri galeri =new Galeri();
            
            galeri.setIdgaleri(rs.getInt("idgaleri"));
            //galeri.setFilm((rs.getInt("filmler_idfilmler")));
            galeri.setResim(rs.getString("resim"));                 
            
        
            
            ListeGaleri.add(galeri);
            }

        } catch (SQLException ex) {
          System.out.println(ex.getMessage())  ;   
        }
        return ListeGaleri;

    }
       
       
       public void delete(Galeri galeri) {
      
        try {
            String query = "delete from galeri where idgaleri = ? ";
            PreparedStatement pst = connection.prepareStatement(query);
            pst.setInt(1, galeri.getIdgaleri());
            pst.executeUpdate(); 

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            Logger.getLogger(GaleriDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
       
       
       
       public void insert(Galeri galeri) {
        
        try {
            String query = "insert into galeri values (?,?,?)";
            PreparedStatement pst = connection.prepareStatement(query);
            pst.setInt(1, galeri.getIdgaleri());
            pst.setInt(2, galeri.getFilm().getIdfilmler());
            pst.setString(3, galeri.getResim());
      ;
            pst.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(GaleriDAO.class.getName()).log(Level.SEVERE, null, ex);

        }

    }
       
       
       public void update(Galeri galeri) {
      
        try {
            String query = " update galeri "
                    +"  set filmler_idfilmler  = ? "
                    +", resim = ? "                        
                    +"where idgaleri     = ? ";
            PreparedStatement pst = connection.prepareStatement(query);          
            pst.setInt(1, galeri.getFilm().getIdfilmler());
            pst.setString(2, galeri.getResim());    
             pst.setInt(3, galeri.getIdgaleri());
             
            pst.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(GaleriDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
