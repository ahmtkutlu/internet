/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entity.Salon;
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
public class SalonDAO extends AbstractDAO implements DAO<Salon>{
    
      Connector con = new Connector();
      Connection connection = con.connect();
       
     private SinemaDAO SinemaDao;
       
        public SinemaDAO getSinemaDao() {
            
            if(this.SinemaDao==null){
                
            this.SinemaDao= new SinemaDAO();
            
            }
        return SinemaDao;
       }

       public void setSinemaDao(SinemaDAO SinemaDao) {
        this.SinemaDao = SinemaDao;
    }
          @Override              
        public Salon find(Long id) {
        Salon salon = null;
        try {
            String query = "select * from salon where idsalon = ?";
            PreparedStatement pst = connection.prepareStatement(query);
            pst.setLong(1, id);
            ResultSet rs = pst.executeQuery();           
            rs.next();
            salon = new Salon();
            salon.setIdsalon(rs.getLong("idsalon"));
            salon.setSinema(this.getSinemaDao().find(rs.getLong("sinema_idsinema")));
            salon.setTitle(rs.getString("title"));        
            salon.setKapasite(rs.getInt("kapasite"));

        } catch (SQLException ex) {
            System.out.println(ex.getMessage())  ;
        }
        return salon;

    }
                     
        @Override
       public List<Salon> findAll() {
         List<Salon> ListeSalon = new ArrayList();     
        try {
            String query = "select * from salon order by idsalon";
            PreparedStatement pst = connection.prepareStatement(query);
            ResultSet rs = pst.executeQuery();  
            
         
                         
            while(rs.next()){
            Salon salon =new Salon();                       
            salon.setIdsalon(rs.getLong("idsalon"));                      
            
            salon.setSinema(this.getSinemaDao().find(rs.getLong("sinema_idsinema")));
            
            
            
            
            salon.setTitle(rs.getString("title"));        
            salon.setKapasite(rs.getInt("kapasite"));
            
            
            ListeSalon.add(salon);
            }

        } catch (SQLException ex) {
          System.out.println(ex.getMessage())  ;   
        }
        
     
        return ListeSalon;

    }
       
        @Override
       public void delete(Salon salon) {
      
        try {
            String query = "delete from salon where idsalon = ? ";
            PreparedStatement pst = connection.prepareStatement(query);
            pst.setLong(1, salon.getIdsalon());
            pst.executeUpdate(); 

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            Logger.getLogger(SalonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
       
       
        @Override
       public void insert(Salon salon) {
        
        try {
            String query = "insert into salon(sinema_idsinema,title,kapasite) values (?,?,?)";
            PreparedStatement pst = connection.prepareStatement(query);
           
            pst.setLong(1, salon.getSinema().getIdsinema());
            pst.setString(2, salon.getTitle());
            pst.setInt(3, salon.getKapasite());
            pst.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(SalonDAO.class.getName()).log(Level.SEVERE, null, ex);

        }

    }
       
        @Override
       public void update(Salon salon) {
      
        try {
            String query = " update salon "
                    +"  set sinema_idsinema   = ? "
                    +", title = ? "        
                    +", kapasite = ? "
                    +"where idsalon     = ? ";
            PreparedStatement pst = connection.prepareStatement(query); 
            
            pst.setLong(1, salon.getSinema().getIdsinema());
            pst.setString(2, salon.getTitle());
            pst.setInt(3, salon.getKapasite());
            pst.setLong(4, salon.getIdsalon());
             
            pst.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(SalonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

   
     public int record() {
        
        int a = 0;
        try {
            String selectQuery = "select * from salon";
            PreparedStatement pst = this.getConnection().prepareStatement(selectQuery);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                a++;
            }
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return a;
    }

    @Override
    public List<Salon> findAll(int page, int pageSize) {


        List<Salon> salonList = new ArrayList<>();
        
        int start = ( page -1 ) * pageSize ;
        
        try {
            String selectQuery = "select * from salon order by idsalon limit "+pageSize+" offset "+start;
            PreparedStatement pst = this.getConnection().prepareStatement(selectQuery);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
            Salon salon = new Salon();                
            salon.setIdsalon(rs.getLong("idsalon"));                                  
            salon.setSinema(this.getSinemaDao().find(rs.getLong("sinema_idsinema")));            
            salon.setTitle(rs.getString("title"));        
            salon.setKapasite(rs.getInt("kapasite"));
                
                salonList.add(salon);

                System.out.println(salon);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }

        return salonList ;
        
    }
       
       
}
