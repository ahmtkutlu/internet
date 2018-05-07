/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Entity.seans;
import Entity.yorum;
import utility.ConnectionManager;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class seansDAO {

    private seans s = null;
    private ArrayList<seans> slist = null;

//    public yorum getYrm(Long id){
//        Connection con =ConnectionManager.baglanti();
//        try{
//            Statement st =con.createStatement();
//            ResultSet rs =st.executeQuery("select * from yorum where y_id="+id);
//            rs.next();
//            this.yrm =new yorum(rs.getString("y_ad"),rs.getString("y_yorum"),rs.getLong("arayan_id"));
//        }
//        catch(SQLException ex){
//            System.out.println(ex.getMessage());
//            
//        }
//        return this.yrm;
//    }
//     public yorum getArayan(Long id){
//        Connection con =ConnectionManager.baglanti();
//        try{
//            Statement st =con.createStatement();
//            ResultSet rs =st.executeQuery("select * from yorum where arayan_id="+id);
//            rs.next();
//            this.yrm =new yorum(rs.getString("y_ad"),rs.getString("y_yorum"));
//        }
//        catch(SQLException ex){
//            System.out.println(ex.getMessage());
//            
//        }
//        return this.yrm;
//    }
    public ArrayList<seans> list() {
        this.slist = new ArrayList();
        Connection con = ConnectionManager.getConnection();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from seans");
            while (rs.next()) {
                this.slist.add(new seans(rs.getLong("idseans"), rs.getLong("salon_idsalon"), rs.getInt("saat"), rs.getLong("filmler_idfilmler")));
            }
            this.s = new seans(rs.getLong("salon_idsalon"), rs.getInt("saat"), rs.getLong("filmler_idfilmler"));
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }
        return this.slist;
    }

    public void delete(Long id) {
        Connection con = ConnectionManager.getConnection();
        try {
            Statement st = con.createStatement();
            st.executeUpdate("delete from seans where idseans=" + id);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void update(seans y) {
        Connection con = ConnectionManager.getConnection();
        try {
            Statement st = con.createStatement();
            st.executeUpdate("update seans set salon_idsalon='" + y.getSalon_id() + "',saat='" + y.getSaat() + "',filmler_idfilmler='" + y.getFilm_id() + "'where idseans=" + y.getSeans_id());
            System.out.print("güncelledi");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }
    }

    public void create(seans y) {
        Connection con = ConnectionManager.getConnection();
        try {
            Statement st = con.createStatement();

            st.executeUpdate("insert into seans(salon_idsalon,saat,filmler_idfilmler) values ('" + y.getSalon_id() + "','" + y.getSaat() + "','" + y.getFilm_id() + "')");
            System.out.println("yorum eklendi");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }
    }

}
