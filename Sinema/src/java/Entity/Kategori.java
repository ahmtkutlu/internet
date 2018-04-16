
package Entity;


public class Kategori {
    
    private Long idkategori;
    private String kategori_adi;

    public Long getIdkategori() {
        return idkategori;
    }

    public void setIdkategori(Long idkategori) {
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
