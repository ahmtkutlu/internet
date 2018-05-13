/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entity.Yorum;
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
public class YorumDAO extends AbstractDAO implements DAO<Yorum>{
      Connector con = new Connector();
      Connection connection = con.connect();
       
       private FilmDAO FilmDao;
       private UserDAO UserDaO;

    public FilmDAO getFilmDao() {
        if(this.FilmDao==null){
                
            this.FilmDao= new FilmDAO();
            
            }
        return FilmDao;
    }

    public void setFilmDao(FilmDAO FilmDao) {
        this.FilmDao = FilmDao;
    }

    public UserDAO getUserDaO() {
        if(this.UserDaO==null){
                
            this.UserDaO= new UserDAO();
            
            }
        return UserDaO;
    }

    public void setUserDaO(UserDAO UserDaO) {
        this.UserDaO = UserDaO;
    }
       
       
       
       
       
       
        @Override
        public Yorum find(Long id) {
        Yorum yorum = null;
        try {
            String query = "select * from yorum where idyorum = ?";
            PreparedStatement pst = connection.prepareStatement(query);
            pst.setLong(1, id);
            ResultSet rs = pst.executeQuery();           
            rs.next();
            yorum = new Yorum();
            
            yorum.setIdyorum(rs.getLong("idyorum"));          
            yorum.setFilm(this.getFilmDao().find(rs.getLong("filmler_idfilmler")));                                       
            yorum.setUser(this.getUserDaO().find(rs.getLong("user_iduser")));
            yorum.setIcerik(rs.getString("icerik"));        
            yorum.setYorum_basligi(rs.getString("yorum_basligi"));
            yorum.setYorum_tarihi(rs.getDate("yorum_tarihi"));
            

        } catch (SQLException ex) {
            System.out.println(ex.getMessage())  ;
        }
        return yorum;

    }                  
        @Override
       public List<Yorum> findAll() {
         List<Yorum> ListeYorum = new ArrayList();
        try {
            String query = "select * from yorum order by idyorum";
            PreparedStatement pst = connection.prepareStatement(query);
            ResultSet rs = pst.executeQuery();                  
            while(rs.next()){
            Yorum yorum =new Yorum();
            
            yorum.setIdyorum(rs.getLong("idyorum"));     
            yorum.setFilm(this.getFilmDao().find(rs.getLong("filmler_idfilmler")));                             
            yorum.setUser(this.getUserDaO().find(rs.getLong("user_iduser")));                        
            yorum.setIcerik(rs.getString("icerik"));        
            yorum.setYorum_basligi(rs.getString("yorum_basligi"));
            yorum.setYorum_tarihi(rs.getDate("yorum_tarihi"));
            
            
            ListeYorum.add(yorum);
            }

        } catch (SQLException ex) {
          System.out.println(ex.getMessage())  ;   
        }
        return ListeYorum;

    }
       
        @Override
       public void delete(Yorum yorum) {
      
        try {
            String query = "delete from yorum where idyorum = ? ";
            PreparedStatement pst = connection.prepareStatement(query);
            pst.setLong(1, yorum.getIdyorum());
            pst.executeUpdate(); 

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            Logger.getLogger(YorumDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
       
       
        @Override
       public void insert(Yorum yorum) {
        
        try {
            String query = "insert into yorum(filmler_idfilmler,user_iduser,icerik,yorum_basligi,yorum_tarihi) values (?,?,?,?,?)";
            PreparedStatement pst = connection.prepareStatement(query);
    
            pst.setLong(1, yorum.getFilm().getIdfilmler());
            pst.setLong(2, yorum.getUser().getIduser());
            pst.setString(3, yorum.getIcerik());
             pst.setString(4, yorum.getYorum_basligi());
            pst.setDate(5, yorum.getYorum_tarihi());
            pst.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(YorumDAO.class.getName()).log(Level.SEVERE, null, ex);

        }

    }
       
        @Override
       public void update(Yorum yorum) {
      
        try {
            String query = " update yorum "
                    +"  set filmler_idfilmler   = ? "
                    +", user_iduser = ? "        
                    +", icerik = ? "
                     +", yorum_basligi = ? "
                     +", yorum_tarihi = ? "
                    +"where idyorum  = ? ";
            PreparedStatement pst = connection.prepareStatement(query); 
            
            pst.setLong(1, yorum.getFilm().getIdfilmler());
            pst.setLong(2, yorum.getUser().getIduser());
            pst.setString(3, yorum.getIcerik());
            pst.setString(4, yorum.getYorum_basligi());
            pst.setDate(5, yorum.getYorum_tarihi());
            pst.setLong(6, yorum.getIdyorum());
            pst.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(YorumDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
       
       public int record() {
        
        int a = 0;
        try {
            String selectQuery = "select * from yorum";
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
    public List<Yorum> findAll(int page, int pageSize) {


        List<Yorum> yorumList = new ArrayList<>();
        
        int start = ( page -1 ) * pageSize ;
        
        try {
            String selectQuery = "select * from yorum order by idyorum limit "+pageSize+" offset "+start;
            PreparedStatement pst = this.getConnection().prepareStatement(selectQuery);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Yorum yorum = new Yorum();
               
                
                yorum.setIdyorum(rs.getLong("idyorum"));     
                yorum.setFilm(this.getFilmDao().find(rs.getLong("filmler_idfilmler")));                             
                yorum.setUser(this.getUserDaO().find(rs.getLong("user_iduser")));                        
                yorum.setIcerik(rs.getString("icerik"));        
                yorum.setYorum_basligi(rs.getString("yorum_basligi"));
                yorum.setYorum_tarihi(rs.getDate("yorum_tarihi"));
                
                
                yorumList.add(yorum);
                System.out.println(yorum);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }

        return yorumList ;
        
    }
}
