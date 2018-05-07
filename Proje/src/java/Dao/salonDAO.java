package Dao;

import Entity.film;
import Entity.salon;
import Entity.seans;
import Entity.yapimci;
import utility.ConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
//import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class salonDAO {

    private salon salon_ = null;
    private ArrayList<salon> salon_list = null;
    private seansDAO seansDAO = null;

    public ArrayList<salon> list() {

        this.salon_list = new ArrayList<>();
        Connection con = ConnectionManager.getConnection();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from salon");
            while (rs.next()) {
                salon y = new salon();
                y.setSalon_id(rs.getLong("idsalon"));
                y.setTitle(rs.getString("title"));
                y.setSeansi(seansGetir(rs.getLong("idsalon")));

                this.salon_list.add(y);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }
        return salon_list;
    }

    public ArrayList<seans> seansGetir(Long salon_id) {
        ArrayList<seans> flist = new ArrayList<>();
        Connection con = ConnectionManager.getConnection();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from seans where salon_idsalon=" + salon_id);
            while (rs.next()) {
                seans f = new seans();
                f.setSalon_id(rs.getLong("salon_idsalon"));
                f.setSaat(rs.getInt("saat"));
                f.setSeans_id(rs.getLong("idseans"));

                flist.add(f);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }
        return flist;
    }

    public void delete(salon salon) {
        Connection con = ConnectionManager.getConnection();

        try {
            Statement st = con.createStatement();
            st.executeUpdate("delete from salon where idyapimci=" + salon.getSalon_id());
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void create(salon y) {
        Connection con = ConnectionManager.getConnection();
        try {
            Statement st = con.createStatement();

            st.executeUpdate("insert into salon(idsalon,title) values ('" + y.getSalon_id() + "','" + y.getTitle() + "')");
            System.out.println("il ekledi");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }
    }

    public void update(salon y) {
        Connection con = ConnectionManager.getConnection();
        try {
            Statement st = con.createStatement();
            st.executeUpdate("update salon set title='" + y.getTitle() + "' where idsalon=" + y.getSalon_id());
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }
    }
}

//    public ArrayList<salon> list() {
//        this.salon_list = new ArrayList<>();
//        Connection con = ConnectionManager.baglanti();
//        try {
//            Statement st = con.createStatement();
//            ResultSet rs = st.executeQuery("select * from filmler");
//            while (rs.next()) {
//                salon f = new salon();
//                f.setFilm_id(rs.getLong("idfilmler"));
//                f.setFilm_adi(rs.getString("film_adi"));
//                f.setYapimci_id((rs.getLong("yapimci_idyapimci")));
//                salon_list.add(f);
//
//            }
//
//        } catch (SQLException ex) {
//            System.out.println(ex.getMessage());
//
//        }
//        return this.salon_list;
//    }

