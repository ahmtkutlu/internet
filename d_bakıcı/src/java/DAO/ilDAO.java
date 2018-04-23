/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entity.il;
import Entity.ilce;

import Utility.ConnectionManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author asus
 */
public class ilDAO {

    private il il_ = null;
    private ArrayList<il> il_list = null;
    private ilceDAO ilceDAO = null;

    public ilceDAO getIlceDAO() {
        if (this.ilceDAO == null) {
            this.ilceDAO = new ilceDAO();
        }
        return ilceDAO;
    }

    public il getIl(Long il_id) {
        Connection con = ConnectionManager.baglanti();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from il where il_id=" + il_id);
            rs.next();
            this.il_ = new il(rs.getLong("il_id"), rs.getString("il_ad"));
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }
        return this.il_;
    }

    public ArrayList<il> list() {
        this.il_list = new ArrayList<>();
        Connection con = ConnectionManager.baglanti();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from il");
            while (rs.next()) {
                il i = new il();
                i.setIl_id(rs.getLong("il_id"));
                i.setIl_ad(rs.getString("il_ad"));
                i.setIlcesi(ilceGetir(rs.getLong("il_id")));

                this.il_list.add(i);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }
        return il_list;
    }

    public ArrayList<ilce> ilceGetir(Long il_id) {
        ArrayList<ilce> clist = new ArrayList<>();
        Connection con = ConnectionManager.baglanti();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from ilce where il_id=" + il_id);
            while (rs.next()) {
                ilce i = new ilce();
                i.setIl_id(rs.getLong("il_id"));
                i.setIlce_ad(rs.getString("ilce_ad"));
                i.setIlce_id(rs.getLong("il_id"));

                clist.add(i);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }
        return clist;
    }

    public void delete(il il) {
        Connection con = ConnectionManager.baglanti();

        try {
            Statement st = con.createStatement();
            st.executeUpdate("delete from il where il_id=" + il.getIl_id());
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void update(il i) {
        Connection con = ConnectionManager.baglanti();
        try {
            Statement st = con.createStatement();
            st.executeUpdate("update il set il_ad='" + i.getIl_ad() + "' where il_id=" + i.getIl_id());
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }
    }

    public void create(il i) {
        Connection con = ConnectionManager.baglanti();
        try {
            Statement st = con.createStatement();

            st.executeUpdate("insert into il(il_id,il_ad) values ('" + i.getIl_id() + "','" + i.getIl_ad() + "')");
            System.out.println("il ekledi");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }
    }

    public static void main(String args[]) {
        ilDAO il = new ilDAO();
        il i = new il(47L, "j6kjj");
        il.create(i);

    }
}
