/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;


import Entity.film;
import Entity.yapimci;
import Entity.yonetmen;
import utility.ConnectionManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author idea
 */
public class yonetmenDAO  {
    
      private yonetmen yonetmen = null;
    private ArrayList<yonetmen> yonetmen_list = null;
    private filmDAO filmDAO = null;
    
    public ArrayList<yonetmen> list() {
        this.yonetmen_list = new ArrayList<>();
        Connection con = ConnectionManager.getConnection();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from yonetmen");
            while (rs.next()) {
                yonetmen y = new yonetmen();
                y.setYonetmen_id(rs.getLong("idyonetmen"));
                y.setYonetmen_adi(rs.getString("yonetmen_adi"));
               y.setFilmi(filmGetir(rs.getLong("idyonetmen")));

                this.yonetmen_list.add(y);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }
        return yonetmen_list;
    }
    
    public ArrayList<film> filmGetir(Long yonetmen_id) {
        ArrayList<film> flist = new ArrayList<>();
        Connection con = ConnectionManager.getConnection();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from filmler where yonetmen_idyonetmen=" + yonetmen_id);
            while (rs.next()) {
                film f = new film();
                f.setYonetmen_id(rs.getLong("yonetmen_idyonetmen"));
                f.setFilm_adi(rs.getString("film_adi"));
                f.setFilm_id(rs.getLong("idfilmler"));

                flist.add(f);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }
        return flist;
    }
    
    
    
    
    public void delete(yonetmen yonetmen) {
        Connection con = ConnectionManager.getConnection();

        try {
            Statement st = con.createStatement();
            st.executeUpdate("delete from yonetmen where idyonetmen=" + yonetmen.getYonetmen_id());
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
     public void create(yonetmen y) {
        Connection con = ConnectionManager.getConnection();
        try {
            Statement st = con.createStatement();

            st.executeUpdate("insert into yonetmen(idyonetmen,yonetmen_adi) values ('" + y.getYonetmen_id() + "','" + y.getYonetmen_adi() + "')");
            System.out.println(" ekledi");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }
    }
     
     public void update(yonetmen y) {
        Connection con = ConnectionManager.getConnection();
        try {
            Statement st = con.createStatement();
            st.executeUpdate("update yonetmen set yonetmen_adi='" + y.getYonetmen_adi() + "' where idyonetmen=" + y.getYonetmen_id());
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }
    }

    

}
