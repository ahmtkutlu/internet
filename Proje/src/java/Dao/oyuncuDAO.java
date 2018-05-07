/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Entity.film;
import Entity.kategori;
import Entity.oyuncu;
import utility.ConnectionManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author asus
 */
public class oyuncuDAO {

    private oyuncu oyu = null;
    private ArrayList<oyuncu> oyulist = null;

    public List<oyuncu> getKat() {
        List<oyuncu> oyulist = new ArrayList<>();

        Connection con = ConnectionManager.getConnection();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from oyuncu");
            while (rs.next()) {
                oyuncu k = new oyuncu();
                k.setOyuncu_id(rs.getLong("idoyuncu"));
                k.setAd(rs.getString("ad"));
                k.setSoyad(rs.getString("soyad"));
                k.setFilmi(filmGetir(rs.getLong("idoyuncu")));

                this.oyulist.add(k);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }
        return oyulist;
    }

    public oyuncu getKat(Long id) {
        Connection con = ConnectionManager.getConnection();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from oyuncu where idoyuncu=" + id);
            rs.next();
            this.oyu = new oyuncu(rs.getLong("idoyuncu"), rs.getString("ad"), rs.getString("soyad"));
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }
        return this.oyu;
    }

    public ArrayList<oyuncu> list() {
        this.oyulist = new ArrayList<>();
        Connection con = ConnectionManager.getConnection();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from oyuncu");
            while (rs.next()) {
                oyuncu k = new oyuncu();
                k.setOyuncu_id(rs.getLong("idoyuncu"));
                k.setAd(rs.getString("ad"));
                k.setSoyad(rs.getString("soyad"));
                k.setFilmi(filmGetir(rs.getLong("idoyuncu")));

                this.oyulist.add(k);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }
        return oyulist;
    }

    public ArrayList<film> filmGetir(Long id) {
        ArrayList<film> is = new ArrayList();
        Connection con = ConnectionManager.getConnection();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from filmler where idfilmler in (select idfilmler from oyuncu_has_filmler where oyuncu_idoyuncu=" + id + ")");
            while (rs.next()) {
                film i = new film();
                i.setFilm_adi(rs.getString("film_adi"));
                i.setFilm_id(rs.getLong("idfilmler"));

                is.add(i);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return is;
    }

    public void delete(oyuncu id) {
        Connection con = ConnectionManager.getConnection();

        try {
            Statement st = con.createStatement();
            st.executeUpdate("delete from oyuncu where idoyuncu=" + id.getOyuncu_id());
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void update(oyuncu k) {
        Connection con = ConnectionManager.getConnection();
        try {
            Statement st = con.createStatement();
            st.executeUpdate("update oyuncu set ad='" + k.getAd() + "',soyad='" + k.getSoyad() + "' where idoyuncu=" + k.getOyuncu_id());
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }
    }

    public void create(oyuncu k) {
        Connection con = ConnectionManager.getConnection();
        try {
            Statement st = con.createStatement();

            st.executeUpdate("insert into oyuncu(idoyuncu,ad,soyad) values ('" + k.getOyuncu_id() + "','" + k.getAd() + "','" + k.getSoyad() + "')");
            System.out.println("oyuncu eklendi");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }
    }

    public static void main(String args[]) {

    }
}
