package Dao;

import Entity.Film;
import Entity.Oyuncu;
import Entity.Yapimci;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
//import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FilmDao extends AbstractDao {

    private YapimciDao yapimciDao;
    private KategoriDao kategoriDao;
    private YonetmenDao yonetmenDao;
    private OyuncuDao oyuncuDao;

    public List<Film> getOyuncuFilm(Oyuncu o) {

        List<Film> filmList = new ArrayList<>();

        try {
            Statement st = this.getConnection().createStatement(); //this.getConnection() bu abstrac daoya gonderiyor.
            ResultSet rs = st.executeQuery("select * from oyuncu_has_filmler where oyuncu_idoyuncu=" + o.getIdoyuncu());

            while (rs.next()) {

                Statement st2 = this.getConnection().createStatement();
                ResultSet rs2 = st2.executeQuery("select * from filmler where idfilmler=" + rs.getLong(2)/*getInt("idfilmler")*/);
                rs2.next();
                Film f = new Film();
                f.setIdfilmler(rs2.getLong("idfilmler"));
                f.setFilm_adi(rs2.getString("film_adi"));
                f.setIcerik(rs2.getString("icerik"));

                filmList.add(f);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());

        }

        return filmList;
    }

    public List<Film> findAll() {

        List<Film> filmList = new ArrayList<>();

        try {
            Statement st = this.getConnection().createStatement(); //this.getConnection() bu abstrac daoya gonderiyor.
            ResultSet rs = st.executeQuery("select * from filmler");

            while (rs.next()) {
                Film f = new Film();
                f.setIdfilmler(rs.getLong("idfilmler"));
                f.setFilm_adi(rs.getString("film_adi"));
                f.setIcerik(rs.getString("icerik"));
//        Statement st2=this.getConnection().createStatement();
//        ResultSet rs2=st2.executeQuery("select * from yapimci where idyapimci="+rs.getInt(1) /*getInt("idyapimci")*/);
//        rs2.next();
//        
//        Yapimci y=new Yapimci();
//        y.setIdyapimci(rs2.getInt(1)/*getInt("idyapimci")*/);
//        y.setYapimci_adi(rs2.getString(2)/*getString("yapimci_adi")*/);

                f.setYonetmen(this.getYonetmenDao().find(rs.getInt(1)));

                f.setYapimci(this.getYapimciDao().find(rs.getInt(1)));

                f.setKategoriList(this.getKategoriDao().getFilmKategori(f));

                f.setOyuncuList(this.getOyuncuDao().findFilmOyuncular(f));

                filmList.add(f);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());

        }

        return filmList;
    }

    public List<Film> findAllPrepared() {

        List<Film> filmList = new ArrayList<>();

        try {
            PreparedStatement pst = this.getConnection().prepareStatement("select * from filmler order by idfilmler"); //this.getConnection() bu abstrac daoya gonderiyor.
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                Film f = new Film();
                f.setIdfilmler(rs.getLong("idfilmler"));
                f.setFilm_adi(rs.getString("film_adi"));
                f.setIcerik(rs.getString("icerik"));
//        Statement st2=this.getConnection().createStatement();
//        ResultSet rs2=st2.executeQuery("select * from yapimci where idyapimci="+rs.getInt(1) /*getInt("idyapimci")*/);
//        rs2.next();
//        
//        Yapimci y=new Yapimci();
//        y.setIdyapimci(rs2.getInt(1)/*getInt("idyapimci")*/);
//        y.setYapimci_adi(rs2.getString(2)/*getString("yapimci_adi")*/);

                f.setYonetmen(this.getYonetmenDao().find(rs.getInt(1)));

                f.setYapimci(this.getYapimciDao().find(rs.getInt(1)));

                f.setKategoriList(this.getKategoriDao().getFilmKategori(f));

                f.setOyuncuList(this.getOyuncuDao().findFilmOyuncular(f));

                filmList.add(f);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());

        }

        return filmList;
    }

    public void insert(Film film, List<Long> selectedKategoriList) {
        try {
            PreparedStatement pst = this.getConnection().prepareStatement("insert into filmler (film_adi,icerik) values(?,?)", Statement.RETURN_GENERATED_KEYS);
            pst.setString(1, film.getFilm_adi());
            pst.setString(2, film.getIcerik());

            pst.executeUpdate();

            Long idfilmler = 0L;

            ResultSet rs = pst.getGeneratedKeys();
            if (rs.next()) {
                idfilmler = rs.getLong(1);
            }

            for (Long idkategori : selectedKategoriList) {
                pst = this.getConnection().prepareStatement("insert into kategori_has_filmler (kategori_idkategori,filmler_idfilmler) values (?,?)");
                pst.setLong(1, idkategori);
                pst.setLong(2, idfilmler);

                pst.executeUpdate();
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());

        }
    }

    public void edit(Film film, List<Long> selectedKategoriList) {

        try {
            PreparedStatement pst = this.getConnection().prepareStatement("update filmler set film_adi=?, icerik=? where idfilmler=?");
            pst.setString(1, film.getFilm_adi());
            pst.setString(2, film.getIcerik());
            pst.setLong(3, film.getIdfilmler());

            pst.executeUpdate();

            pst = this.getConnection().prepareStatement("delete from kategori_has_filmler where idfilmler=?");
            pst.setLong(1, film.getIdfilmler());
            pst.executeUpdate();

            for (Long idkategori : selectedKategoriList) {
                pst = this.getConnection().prepareStatement("insert into kategori_has_filmler (kategori_idkategori,filmler_idfilmler) values (?,?)");
                pst.setLong(1, idkategori);
                pst.setLong(2, film.getIdfilmler());

                pst.executeUpdate();
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());

        }

    }

    public void remove(Film film) {

        try {
            PreparedStatement pst = this.getConnection().prepareStatement("delete from kategori_has_filmler where filmler_idfilmler=?");
            pst.setLong(1, film.getIdfilmler());
            
            pst.executeUpdate();

            pst = this.getConnection().prepareStatement("delete from filmler where idfilmler=?");
            pst.setLong(1, film.getIdfilmler());

            pst.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    public YapimciDao getYapimciDao() {
        if (this.yapimciDao == null) {
            this.yapimciDao = new YapimciDao();
        }
        return yapimciDao;
    }

    public void setYapimciDao(YapimciDao yapimciDao) {
        this.yapimciDao = yapimciDao;
    }

    public YonetmenDao getYonetmenDao() {
        if (this.yonetmenDao == null) {
            this.yonetmenDao = new YonetmenDao();
        }
        return yonetmenDao;
    }

    public void setYonetmenDao(YonetmenDao yonetmenDao) {
        this.yonetmenDao = yonetmenDao;
    }

    public KategoriDao getKategoriDao() {
        if (this.kategoriDao == null) {
            this.kategoriDao = new KategoriDao();
        }
        return kategoriDao;
    }

    public void setKategoriDao(KategoriDao kategoriDao) {
        this.kategoriDao = kategoriDao;
    }

    public OyuncuDao getOyuncuDao() {
        if (this.oyuncuDao == null) {
            this.oyuncuDao = new OyuncuDao();
        }
        return oyuncuDao;
    }

    public void setOyuncuDao(OyuncuDao oyuncuDao) {
        this.oyuncuDao = oyuncuDao;
    }

}
