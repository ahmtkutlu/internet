package Dao;

import Entity.Film;
import Entity.Kategori;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class KategoriDao extends AbstractDao {

    public List<Kategori> getFilmKategori(Film film) {
        List<Kategori> kategoriList = new ArrayList<>();

        try {
            Statement st = this.getConnection().createStatement(); //this.getConnection() bu abstrac daoya gonderiyor.
            ResultSet rs = st.executeQuery("select * from kategori_has_filmler where filmler_idfilmler=" + film.getIdfilmler());

            while (rs.next()) {
                kategoriList.add(this.find(rs.getLong(1) /*getInt("idkategori")*/));

//                Kategori k = new Kategori();
//                k.setKategori_id(rs.getInt("idkategori"));
//                k.setKategori_adi(rs.getString("kategori_adi"));
            }
        } catch (SQLException e) {

            System.out.println(e.getMessage());

        }

        return kategoriList;

    }

    public Kategori find(Long idkategori) {

        Kategori k = null;
        try {

            Statement st = this.getConnection().createStatement();
            ResultSet rs = st.executeQuery("select * from kategori where idkategori=" + idkategori);
            rs.next();

            k = new Kategori();
            k.setIdkategori(rs.getLong("idkategori"));
            k.setKategori_adi(rs.getString("kategori_adi"));

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return k;
    }

    public List<Kategori> findAll() {
        List<Kategori> kategoriList = new ArrayList<>();

        try {
            Statement st = this.getConnection().createStatement(); //this.getConnection() bu abstrac daoya gonderiyor.
            ResultSet rs = st.executeQuery("select * from kategori");

            while (rs.next()) {
                //kategoriList.add(this.find(rs.getInt(1) /*getInt("idkategori")*/));

                Kategori k = new Kategori();
                k.setIdkategori(rs.getLong("idkategori"));
                /*setKategori_id(rs.getInt("idkategori"));*/
                k.setKategori_adi(rs.getString("kategori_adi"));

                kategoriList.add(k);
            }
        } catch (SQLException e) {

            System.out.println(e.getMessage());

        }

        return kategoriList;

    }

    public void insert(Kategori kategori) {

        try {
            Statement st = this.getConnection().createStatement();
            st.executeUpdate("insert into kategori (kategori_adi) values ('" + kategori.getKategori_adi() + "')");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    public void sil(Kategori kat) {

        try {
            Statement st = this.getConnection().createStatement();
            st.executeUpdate("delete from kategori where idkategori=" + kat.getIdkategori());
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    public void update(Kategori kategori) {

        try {
            Statement st = this.getConnection().createStatement();
            st.executeUpdate("update kategori set kategori_adi='" + kategori.getKategori_adi() + "'where idkategori=" + kategori.getIdkategori());
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

}
