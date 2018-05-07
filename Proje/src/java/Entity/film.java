package Entity;

import java.sql.Blob;
import java.util.ArrayList;
import java.util.List;

public class film {

    private Long film_id;
    private String film_adi;
    private double ımdb_puani;
    private int sure;
    private int butce;
    private int yil;
    private String icerik;
    private Blob fragman;

    private Long yapimci_id;
    private Long yonetmen_id;

    private yorum yorum;
    private seans seans;

    private ArrayList<kategori> kategorisi;
    private ArrayList<oyuncu> oyuncusu;

    public film(Long film_id, String film_adi, double ımdb_puani, int sure, String icerik, Long yapimci_id, Long yonetmen_id) {
        this.film_id = film_id;
        this.film_adi = film_adi;
        this.ımdb_puani = ımdb_puani;
        this.sure = sure;
        this.icerik = icerik;
        this.yapimci_id = yapimci_id;
        this.yonetmen_id = yonetmen_id;
    }

    public film() {
    }

    public ArrayList<oyuncu> getOyuncusu() {
        return oyuncusu;
    }

    public void setOyuncusu(ArrayList<oyuncu> oyuncusu) {
        this.oyuncusu = oyuncusu;
    }
    
    

    public yorum getYorum() {
        return yorum;
    }

    public void setYorum(yorum yorum) {
        this.yorum = yorum;
    }

    public seans getSeans() {
        return seans;
    }

    public void setSeans(seans seans) {
        this.seans = seans;
    }

    public ArrayList<kategori> getKategorisi() {
        return kategorisi;
    }

    public void setKategorisi(ArrayList<kategori> kategorisi) {
        this.kategorisi = kategorisi;
    }

    public Long getYapimci_id() {
        return yapimci_id;
    }

    public Blob getFragman() {
        return fragman;
    }

    public void setFragman(Blob fragman) {
        this.fragman = fragman;
    }

    public Long getYonetmen_id() {
        return yonetmen_id;
    }

    public void setYonetmen_id(Long yonetmen_id) {
        this.yonetmen_id = yonetmen_id;
    }

    public void setYapimci_id(Long yapimci_id) {
        this.yapimci_id = yapimci_id;
    }

    public Long getFilm_id() {
        return film_id;
    }

    public void setFilm_id(Long film_id) {
        this.film_id = film_id;
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

    @Override
    public String toString() {
        return "film{" + "film_id=" + film_id + ", film_adi=" + film_adi + ", \u0131mdb_puani=" + ımdb_puani + ", sure=" + sure + ", butce=" + butce + ", yil=" + yil + ", icerik=" + icerik + ", fragman=" + fragman + '}';
    }

}
