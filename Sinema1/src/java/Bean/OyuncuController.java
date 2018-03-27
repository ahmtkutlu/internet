/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import Dao.OyuncuDao;
import Entity.Oyuncu;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author idea
 */
@ManagedBean
@SessionScoped
public class OyuncuController implements Serializable {
    
    private Oyuncu oyuncu;
    private List<Oyuncu> oyuncuList;
    private OyuncuDao oyuncuDao;

    public Oyuncu getOyuncu() {
        if(this.oyuncu==null)
            this.oyuncu=new Oyuncu();
        return oyuncu;
    }

    public void setOyuncu(Oyuncu oyuncu) {
        this.oyuncu = oyuncu;
    }

    public List<Oyuncu> getOyuncuList() {
        this.oyuncuList=this.getOyuncuDao().findAll();
        return oyuncuList;
    }

    public void setOyuncuList(List<Oyuncu> oyuncuList) {
        this.oyuncuList = oyuncuList;
    }

    public OyuncuDao getOyuncuDao() {
        if(this.oyuncuDao==null)
            this.oyuncuDao=new OyuncuDao();
        return oyuncuDao;
    }

    public void setOyuncuDao(OyuncuDao oyuncuDao) {
        this.oyuncuDao = oyuncuDao;
    }
    
    
    
    
    
}
