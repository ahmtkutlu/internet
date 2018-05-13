package Entity;
import java.util.List;
import java.util.Objects;

public class Film {

    private Long idfilmler;
    private String film_adi;
    private double ımdb_puani;
    private int sure;
    private int butce;
    private int yil;
    private String icerik;
    
    private Yapimci yapimci;
    private Yonetmen yonetmen;

    
    private List<Kategori> kategoriList;

    private List<Oyuncu> oyuncuList;

    public Long getIdfilmler() {
        return idfilmler;
    }

    public void setIdfilmler(Long idfilmler) {
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
   
    public Yapimci getYapimci() {
        return yapimci;
    }

    public void setYapimci(Yapimci yapimci) {
        this.yapimci = yapimci;
    }

    public Yonetmen getYonetmen() {
        return yonetmen;
    }

    public void setYonetmen(Yonetmen yonetmen) {
        this.yonetmen = yonetmen;
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
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.idfilmler);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Film other = (Film) obj;
        if (!Objects.equals(this.idfilmler, other.idfilmler)) {
            return false;
        }
        return true;
    }
    
    
    
    
    
    
    
    
    
    

    @Override
    public String toString() {
        return "Film{" + "idfilmler=" + idfilmler + ", film_adi=" + film_adi + ", icerik=" + icerik + ", yapimci=" + yapimci + ", yonetmen=" + yonetmen + ", kategoriList=" + kategoriList + ", oyuncuList=" + oyuncuList + '}';
    }
    
    

}
