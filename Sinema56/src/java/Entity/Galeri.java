/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.sql.Blob;
import java.util.Objects;

/**
 *
 * @author idea
 */
public class Galeri {
    
    private Long idgaleri;
    private Film film;
    private String resim;
    
    private String name ;     
    private String type ;

  
    
    public String getResim() {
        return resim;
    }

    public void setResim(String resim) {
        this.resim = resim;
    }

    public Long getIdgaleri() {
        return idgaleri;
    }

    public void setIdgaleri(Long idgaleri) {
        this.idgaleri = idgaleri;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film= film;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
    
    
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.idgaleri);
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
        final Galeri other = (Galeri) obj;
        if (!Objects.equals(this.idgaleri, other.idgaleri)) {
            return false;
        }
        return true;
    }
    
    
}
