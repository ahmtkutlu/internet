
package Entity;
import java.util.ArrayList;
import java.util.List;

public class il {
      private Long il_id;
    private String il_ad;
   
private ArrayList<ilce> ilcesi;

    public ArrayList<ilce> getIlcesi() {
        
        return ilcesi;
    }

    public void setIlcesi(ArrayList<ilce> ilcesi) {
        this.ilcesi = ilcesi;
    }
  

   
    public il() {
        this.il_id = null;
        this.il_ad = null;
    }

    
    public il(Long il_id, String il_ad) {
        this.il_id = il_id;
        this.il_ad = il_ad;
    }

    public Long getIl_id() {
        return il_id;
    }

    public void setIl_id(Long il_id) {
        this.il_id = il_id;
    }

    public String getIl_ad() {
        return il_ad;
    }

    public void setIl_ad(String il_ad) {
        this.il_ad = il_ad;
    }

    
}
