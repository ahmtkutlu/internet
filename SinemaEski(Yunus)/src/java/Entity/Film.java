package Entity;
import java.sql.Blob;
import java.util.List;

public class Film {

    private int idfilmler;
    private String film_adi;
    private double ımdb_puani;
    private int sure;
    private int butce;
    private int yil;
    private String icerik;
    private String fragman;

    private Yapimci yapimci;

    private Yonetmen yonetmen;

    private List<Kategori> kategoriList;

    private List<Oyuncu> oyuncuList;

    public int getIdfilmler() {
        return idfilmler;
    }

    public void setIdfilmler(int idfilmler) {
        this.idfilmler = idfilmler;
    }

    public String getFilm_adi() {
        return film_adi;
    }

    public void setFilm_adi(String film_adi) {
        this.film_adi = film_adi;
    }

    public double getImdb_puani() {
        return ımdb_puani;
    }

    public void setImdb_puani(double ımdb_puani) {
        this.ımdb_puani = ımdb_puani;
    }

    public int getSure() {
        return sure;
    }

    public void setSure(int sure) {
        this.sure = sure;
    }

    public int getButce() {
        return butce;
    }

    public void setButce(int butce) {
        this.butce = butce;
    }

    public int getYil() {
        return yil;
    }

    public void setYil(int yil) {
        this.yil = yil;
    }

    public String getIcerik() {
        return icerik;
    }

    public void setIcerik(String icerik) {
        this.icerik = icerik;
    }

    public String getFragman() {
        return fragman;
    }

    public void setFragman(String fragman) {
        this.fragman = fragman;
    }  


    
    public List<Kategori> getKategoriList() {
        return kategoriList;
    }

    public void setKategoriList(List<Kategori> kategoriList) {
        this.kategoriList = kategoriList;
    }

    public List<Oyuncu> getOyuncuList() {
        return oyuncuList;
    }

    public void setOyuncuList(List<Oyuncu> oyuncuList) {
        this.oyuncuList = oyuncuList;
    }



    @Override
    public String toString() {
        return "Film{" + "idfilmler=" + idfilmler + ", film_adi=" + film_adi + ", icerik=" + icerik + ", yapimci=" + yapimci + ", yonetmen=" + yonetmen + ", kategoriList=" + kategoriList + ", oyuncuList=" + oyuncuList + '}';
    }

}
