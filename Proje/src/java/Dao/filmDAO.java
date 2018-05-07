package Dao;

import Entity.film;
import Entity.kategori;
import Entity.oyuncu;
import utility.ConnectionManager;
import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
//import java.sql.SQLException;
import java.util.ArrayList;

public class filmDAO {

    private film film_ = null;
    private ArrayList<film> film_list = null;
    private KategoriDao kDao;
    private yorumDAO yDAO;
    private seansDAO sDAO;

//
//    public ArrayList<film> list() {
//        this.film_list = new ArrayList<>();
//        Connection con = ConnectionManager.baglanti();
//        try {
//            Statement st = con.createStatement();
//            ResultSet rs = st.executeQuery("select * from filmler");
//            while (rs.next()) {
//                film f = new film();
//                f.setFilm_id(rs.getLong("idfilmler"));
//                f.setFilm_adi(rs.getString("film_adi"));
//                f.setYapimci_id((rs.getLong("yapimci_idyapimci")));
//                film_list.add(f);
//
//            }
//
//        } catch (SQLException ex) {
//            System.out.println(ex.getMessage());
//
//        }
//        return this.film_list;
//    }
    public KategoriDao getkDAO() {
        if (this.kDao == null) {
            this.kDao = new KategoriDao();
        }
        return kDao;
    }

    public void setkDAO(KategoriDao kDAO) {
        this.kDao = kDAO;
    }

    public yorumDAO getyDAO() {
        if (this.yDAO == null) {
            this.yDAO = new yorumDAO();
        }
        return yDAO;
    }

    public void setyDAO(yorumDAO yDAO) {
        this.yDAO = yDAO;
    }

    public seansDAO getsDAO() {
        if (this.sDAO == null) {
            this.sDAO = new seansDAO();
        }
        return sDAO;
    }

    public void setsDAO(seansDAO sDAO) {
        this.sDAO = sDAO;
    }

    public film getAra(Long id) {
        Connection con = ConnectionManager.getConnection();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from filmler where idfilmler=" + id);
            rs.next();
            this.film_ = new film(rs.getLong("idfilmler"), rs.getString("film_adi"), rs.getDouble("ımdb_puani"), rs.getInt("sure"), rs.getString("icerik"), rs.getLong("yapimci_idyapimci"), rs.getLong("yonetmen_idyonetmen"));

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }
        return this.film_;
    }

    public ArrayList<film> list() {
        this.film_list = new ArrayList<>();
        Connection con = ConnectionManager.getConnection();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from filmler");
            while (rs.next()) {
                film is = new film();
                is.setFilm_id(rs.getLong("idfilmler"));
                is.setFilm_adi(rs.getString("film_adi"));
                is.setSure(rs.getInt("sure"));
                is.setImdb_puani(rs.getDouble("ımdb_puani"));
                is.setIcerik(rs.getString("icerik"));

                is.setYapimci_id(rs.getLong("yapimci_idyapimci"));
                is.setYonetmen_id(rs.getLong("yonetmen_idyonetmen"));

                is.setKategorisi(kategoriGetir(rs.getLong("idfilmler")));
                is.setOyuncusu(oyuncuGetir(rs.getLong("idfilmler")));

                this.film_list.add(is);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }
        return film_list;
    }

    public ArrayList<kategori> kategoriGetir(Long id) {
        ArrayList<kategori> kalist = new ArrayList<>();
        Connection con = ConnectionManager.getConnection();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from kategori where idkategori in(select idkategori from kategori_has_filmler where filmler_idfilmler=" + id + ")");
            while (rs.next()) {
                kategori k = new kategori();
                k.setKategori_id(rs.getLong("idkategori"));
                k.setKategori_ad(rs.getString("kategori_adi"));
                kalist.add(k);

            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }
        return kalist;
    }
    
      public ArrayList<oyuncu> oyuncuGetir(Long id) {
        ArrayList<oyuncu> oylist = new ArrayList<>();
        Connection con = ConnectionManager.getConnection();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from oyuncu where idoyuncu in(select idoyuncu from oyuncu_has_filmler where filmler_idfilmler=" + id + ")");
            while (rs.next()) {
                oyuncu k = new oyuncu();
                k.setOyuncu_id(rs.getLong("idoyuncu"));
                k.setAd(rs.getString("ad"));
                k.setSoyad(rs.getString("soyad"));
                oylist.add(k);

            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }
        return oylist;
    }

    public void delete(film is) {
        Connection con = ConnectionManager.getConnection();

        try {
            Statement st = con.createStatement();
            st.executeUpdate("delete from filmler where idfilmler=" + is.getFilm_id());
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void update(film is) {
        Connection con = ConnectionManager.getConnection();
        try {
            Statement st = con.createStatement();
            st.executeUpdate("update filmler set film_adi='" + is.getFilm_adi() + "',sure='" + is.getSure()
                    + "',ımdb_puani='" + is.getImdb_puani() + "',icerik='" + is.getIcerik() + "',yapimci_idyapimci='" + is.getYapimci_id()
                    + "',yonetmen_idyonetmen='" + is.getYonetmen_id() + "' where idfilmler=" + is.getFilm_id());
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }
    }

    public void create(film is) {
        Connection con = ConnectionManager.getConnection();
        try {
            Statement st = con.createStatement();

            st.executeUpdate("insert into filmler(idfilmler,film_adi,sure,ımdb_puani,icerik,yapimci_idyapimci,yonetmen_idyonetmen) values ('" + is.getFilm_id()
                    + "','" + is.getFilm_adi() + "','" + is.getSure() + "','" + is.getImdb_puani() + "','" + is.getIcerik() + "','" + is.getYapimci_id() + "','" + is.getYonetmen_id() + "')");
            System.out.println("is arayan eklendi");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }
    }

}
