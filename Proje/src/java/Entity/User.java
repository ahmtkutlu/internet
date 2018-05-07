
package Entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.Map;


public class User {

    private int id;
    private String email;
    private String password;
    private String name_surname;
    private Date created;
    private Date updated;
    private int yetki_id;
    //private Grup grup;
    //private ArrayList<Grup> grupList;

    public User() {
    }

    public User(int id, String email, String password) {
        this.id = id;
        this.email = email;
        this.password = password;
    }

    public User(int id, String email, String password, String name_surname) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.name_surname = name_surname;
    }

    public User(int id, String email, String password, String name_surname, Date created, Date updated/*, Grup grup*/) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.name_surname = name_surname;
        this.created = created;
        this.updated = updated;
        //this.grup = grup;
        //this.yetki_id = grup.getYetki_id();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName_surname() {
        return name_surname;
    }

    public void setName_surname(String name_surname) {
        this.name_surname = name_surname;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public User(int id, String email, String password, String name_surname, Date created, Date updated, int yetki_id) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.name_surname = name_surname;
        this.created = created;
        this.updated = updated;
        this.yetki_id = yetki_id;
    }

    public int getYetki_id() {
        return yetki_id;
    }

    public void setYetki_id(int yetki_id) {
        this.yetki_id = yetki_id;
    }

    

    
    
}
