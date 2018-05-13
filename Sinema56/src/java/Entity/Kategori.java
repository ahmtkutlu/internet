
package Entity;

import java.util.Objects;


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

   @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.idkategori);
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
        final Kategori other = (Kategori) obj;
        if (!Objects.equals(this.idkategori, other.idkategori)) {
            return false;
        }
        return true;
    }
    
    
    
}
