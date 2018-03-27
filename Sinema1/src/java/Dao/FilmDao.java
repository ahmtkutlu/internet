package Dao;

import Entity.Film;
import Entity.Oyuncu;
import Entity.Yapimci;
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
            ResultSet rs = st.executeQuery("select * from oyuncu_has_filmler where idoyuncu=" + o.getOyuncu_id());

            while (rs.next()) {

                Statement st2 = this.getConnection().createStatement();
                ResultSet rs2 = st2.executeQuery("select * from filmler where idfilmler=" + rs.getInt("idfilmler"));
                rs2.next();
                Film f = new Film();
                f.setIdfilmler(rs.getInt("idfilmler"));
                f.setFilm_adi(rs.getString("film_adi"));
                f.setIcerik(rs.getString("icerik"));

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
                f.setIdfilmler(rs.getInt("idfilmler"));
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
