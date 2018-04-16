/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Entity.Film;
import Entity.Oyuncu;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author idea
 */
public class OyuncuDao extends AbstractDao {
    
    private FilmDao filmDao;
    

    public List<Oyuncu> findFilmOyuncular(Film f) {
        List<Oyuncu> oyuncuList = new ArrayList<>();

        try {
            Statement st = this.getConnection().createStatement();
            ResultSet rs = st.executeQuery("select * from oyuncu_has_filmler where filmler_idfilmler= " + f.getIdfilmler());

            while (rs.next()) {

                Statement st2 = this.getConnection().createStatement();
                ResultSet rs2 = st2.executeQuery("select * from oyuncu where idoyuncu=" + rs.getLong(1) /*getInt("idoyuncu")*/);
                rs2.next();

                Oyuncu o = new Oyuncu();
                o.setIdoyuncu(rs2.getLong("idoyuncu"));
                o.setAd(rs2.getString("ad"));
                o.setSoyad(rs2.getString("soyad"));
                
               // o.setFilmList(this.getFilmDao().getOyuncuFilm(o));

                oyuncuList.add(o);

            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());

        }

        return oyuncuList;

    }

    public List<Oyuncu> findAll() {
        List<Oyuncu> oyuncuList = new ArrayList<>();

        try {
            Statement st = this.getConnection().createStatement();
            ResultSet rs = st.executeQuery("select * from oyuncu");

            while (rs.next()) {
                Oyuncu o = new Oyuncu();
                o.setIdoyuncu(rs.getLong("idoyuncu"));
                o.setAd(rs.getString("ad"));
                o.setSoyad(rs.getString("soyad"));
                
                o.setFilmList(this.getFilmDao().getOyuncuFilm(o));

                oyuncuList.add(o);

            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());

        }

        return oyuncuList;

    }

    public FilmDao getFilmDao() {
        if(this.filmDao==null)
            this.filmDao=new FilmDao();
        return filmDao;
    }

    public void setFilmDao(FilmDao filmDao) {
        this.filmDao = filmDao;
    }
    
    

}
