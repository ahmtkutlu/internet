/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;


import Entity.film;
import Entity.yapimci;
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
public class yapimciDAO  {
    
      private yapimci yapimci_ = null;
    private ArrayList<yapimci> yapimci_list = null;
    private filmDAO filmDAO = null;
    
    public ArrayList<yapimci> list() {
        this.yapimci_list = new ArrayList<>();
        Connection con = ConnectionManager.getConnection();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from yapimci");
            while (rs.next()) {
                yapimci y = new yapimci();
                y.setYapimci_id(rs.getLong("idyapimci"));
                y.setYapimci_adi(rs.getString("yapimci_adi"));
               y.setFilmi(filmGetir(rs.getLong("idyapimci")));

                this.yapimci_list.add(y);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }
        return yapimci_list;
    }
    
    public ArrayList<film> filmGetir(Long yapimci_id) {
        ArrayList<film> flist = new ArrayList<>();
        Connection con = ConnectionManager.getConnection();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from filmler where yapimci_idyapimci=" + yapimci_id);
            while (rs.next()) {
                film f = new film();
                f.setYapimci_id(rs.getLong("yapimci_idyapimci"));
                f.setFilm_adi(rs.getString("film_adi"));
                f.setFilm_id(rs.getLong("idfilmler"));

                flist.add(f);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }
        return flist;
    }
    
    
    public void delete(yapimci yapimci) {
        Connection con = ConnectionManager.getConnection();

        try {
            Statement st = con.createStatement();
            st.executeUpdate("delete from yapimci where idyapimci=" + yapimci.getYapimci_id());
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
     public void create(yapimci y) {
        Connection con = ConnectionManager.getConnection();
        try {
            Statement st = con.createStatement();

            st.executeUpdate("insert into yapimci(idyapimci,yapimci_adi) values ('" + y.getYapimci_id() + "','" + y.getYapimci_adi() + "')");
            System.out.println("il ekledi");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }
    }
     
     public void update(yapimci y) {
        Connection con = ConnectionManager.getConnection();
        try {
            Statement st = con.createStatement();
            st.executeUpdate("update yapimci set yapimci_adi='" + y.getYapimci_adi() + "' where idyapimci=" + y.getYapimci_id());
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }
    }

    

}
