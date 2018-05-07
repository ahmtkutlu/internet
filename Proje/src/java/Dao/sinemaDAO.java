/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Entity.film;
import Entity.salon;
import Entity.sinema;
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
public class sinemaDAO {

    private sinema sinema = null;
    private ArrayList<sinema> sinema_list = null;
    private salonDAO salonDAO = null;

    public ArrayList<sinema> list() {
        this.sinema_list = new ArrayList<>();
        Connection con = ConnectionManager.getConnection();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from sinema");
            while (rs.next()) {
                sinema y = new sinema();
                y.setSinema_id(rs.getLong("idsinema"));
                y.setKurulus_yili(rs.getInt("kurulus_yili"));
                y.setSalonu(salonGetir(rs.getLong("idsinema")));

                this.sinema_list.add(y);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }
        return sinema_list;
    }

    public ArrayList<salon> salonGetir(Long sinema_id) {
        ArrayList<salon> flist = new ArrayList<>();
        Connection con = ConnectionManager.getConnection();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from salon where sinema_idsinema=" + sinema_id);
            while (rs.next()) {
                salon f = new salon();
                f.setSalon_id(rs.getLong("sinema_idsinema"));
                f.setTitle(rs.getString("title"));
                f.setSalon_id(rs.getLong("idsalon"));

                flist.add(f);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }
        return flist;
    }

    public void delete(sinema sinema) {
        Connection con = ConnectionManager.getConnection();

        try {
            Statement st = con.createStatement();
            st.executeUpdate("delete from sinema where idsinema=" + sinema.getSinema_id());
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void create(sinema y) {
        Connection con = ConnectionManager.getConnection();
        try {
            Statement st = con.createStatement();

            st.executeUpdate("insert into sinema(idsinema,kurulus_yili) values ('" + y.getSinema_id() + "','" + y.getKurulus_yili() + "')");
            System.out.println("il ekledi");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }
    }

    public void update(sinema y) {
        Connection con = ConnectionManager.getConnection();
        try {
            Statement st = con.createStatement();
            st.executeUpdate("update sinema set kurulus_yili='" + y.getKurulus_yili() + "' where idsinema=" + y.getSinema_id());
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }
    }

}
