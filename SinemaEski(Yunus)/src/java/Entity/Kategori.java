
package Entity;


public class Kategori {
    
    private int idkategori;
    private String kategori_adi;

    public int getIdkategori() {
        return idkategori;
    }

    public void setIdkategori(int idkategori) {
        this.idkategori = idkategori;
    }
    
    

    public String getKategori_adi() {
        return kategori_adi;
    }

    public void setKategori_adi(String kategori_adi) {
        this.kategori_adi = kategori_adi;
    }

    @Override
    public String toString() {
        return kategori_adi;
    }

   
    
    
    
}
