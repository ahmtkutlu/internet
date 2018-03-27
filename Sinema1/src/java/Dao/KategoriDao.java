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
            ResultSet rs = st.executeQuery("select * from kategori_has_filmler where idfilmler=" + film.getIdfilmler());

            while (rs.next()) {
                kategoriList.add(this.find(rs.getInt(1) /*getInt("idkategori")*/));

//                Kategori k = new Kategori();
//                k.setKategori_id(rs.getInt("idkategori"));
//                k.setKategori_adi(rs.getString("kategori_adi"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());

        }

        return kategoriList;

    }

    public Kategori find(int idkategori) {

        Kategori k = null;
        try {

            Statement st = this.getConnection().createStatement();
            ResultSet rs = st.executeQuery("select * from kategori where idkategori=" + idkategori);
            rs.next();

            k = new Kategori();
            k.setKategori_id(rs.getInt(1) /*getInt("idkategori")*/);
            k.setKategori_adi(rs.getString(2)/*getString("kategori_adi")*/);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return k;
    }

}
