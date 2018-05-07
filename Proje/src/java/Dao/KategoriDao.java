/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Entity.film;
import Entity.kategori;
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
public class KategoriDao {

    private kategori kat = null;
    private ArrayList<kategori> katlist = null;

    private filmDAO fDAO;

    public List<kategori> getKat() {
        List<kategori> katlist = new ArrayList<>();

        Connection con = ConnectionManager.getConnection();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from kategori");
            while (rs.next()) {
                kategori k = new kategori();
                k.setKategori_id(rs.getLong("idkategori"));
                k.setKategori_ad(rs.getString("kategori_adi"));
                k.setFilmi(filmGetir(rs.getLong("idkategori")));

                this.katlist.add(k);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }
        return katlist;
    }

    public filmDAO getfDAO() {
        if(this.fDAO==null)
            this.fDAO=new filmDAO();
        return fDAO;
    }

    public void setfDAO(filmDAO fDAO) {
        this.fDAO = fDAO;
    }

    

    

    

   

    public kategori getKat(Long id) {
        Connection con = ConnectionManager.getConnection();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from kategori where idkategori=" + id);
            rs.next();
            this.kat = new kategori(rs.getLong("idkategori"), rs.getString("kategori_adi"));
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }
        return this.kat;
    }

    public ArrayList<kategori> list() {
        this.katlist = new ArrayList<>();
        Connection con = ConnectionManager.getConnection();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from kategori");
            while (rs.next()) {
                kategori k = new kategori();
                k.setKategori_id(rs.getLong("idkategori"));
                k.setKategori_ad(rs.getString("kategori_adi"));
                k.setFilmi(filmGetir(rs.getLong("idkategori")));

                this.katlist.add(k);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }
        return katlist;
    }

    public ArrayList<film> filmGetir(Long id) {
        ArrayList<film> is = new ArrayList();
        Connection con = ConnectionManager.getConnection();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from filmler where idfilmler in (select filmler_idfilmler from kategori_has_filmler where kategori_idkategori=" + id + ")");
            while (rs.next()) {
                film i = new film();
                i.setFilm_id(rs.getLong("idfilmler"));
                i.setFilm_adi(rs.getString("film_adi"));
                i.setIcerik(rs.getString("icerik"));
                i.setImdb_puani(rs.getDouble("ımdb_puani"));
                i.setSure(rs.getInt("sure"));
                is.add(i);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return is;
    }

    public void delete(kategori id) {
        Connection con = ConnectionManager.getConnection();

        try {
            Statement st = con.createStatement();
            st.executeUpdate("delete from kategori where idkategori=" + id.getKategori_id());
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void update(kategori k) {
        Connection con = ConnectionManager.getConnection();
        try {
            Statement st = con.createStatement();
            st.executeUpdate("update kategori set kategori_adi='" + k.getKategori_ad() + "' where idkategori=" + k.getKategori_id());
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }
    }

    public void create(kategori k) {
        Connection con = ConnectionManager.getConnection();
        try {
            Statement st = con.createStatement();

            st.executeUpdate("insert into kategori(idkategori,kategori_adi) values ('" + k.getKategori_id() + "','" + k.getKategori_ad() + "')");
            System.out.println("kategori eklendi");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }
    }

    
}
