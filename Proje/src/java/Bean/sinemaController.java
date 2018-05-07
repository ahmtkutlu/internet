/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import Dao.sinemaDAO;
import Dao.yapimciDAO;
import Entity.sinema;
import Entity.yapimci;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author idea
 */
@ManagedBean(name = "sinema")
@SessionScoped
public class sinemaController {

    private sinema s = null;
    private ArrayList<sinema> sinemalist = null;
    private sinemaDAO sinemaDAO = null;

    public sinema getS() {
        if (this.s == null) {
            this.s = new sinema();
        }
        return s;
    }

    public void setS(sinema s) {
        this.s = s;
    }

    public ArrayList<sinema> getSinemalist() {
        if(this.sinemalist==null){
            this.sinemalist=new ArrayList();
            sinemalist=this.getSinemaDAO().list();
                    }
        return this.sinemalist;
    }

    public void setSinemalist(ArrayList<sinema> sinemalist) {
        this.sinemalist = sinemalist;
    }

    public sinemaDAO getSinemaDAO() {
        if (this.sinemaDAO == null) {
            this.sinemaDAO = new sinemaDAO();
        }
        return sinemaDAO;
    }

    public void setSinemaDAO(sinemaDAO sinemaDAO) {
        this.sinemaDAO = sinemaDAO;
    }

    public String delete(sinema sinema) {
        this.getSinemaDAO().delete(sinema);
        this.sinemalist = this.getSinemaDAO().list();
        return "/tamamm";
    }
//
    public String create() {

        this.getSinemaDAO().create(this.s);
        this.sinemalist = this.getSinemaDAO().list();
        this.s = null;
        return "/tamam";
    }

    public String update() {

        this.getSinemaDAO().update(this.s);
        this.sinemalist = this.getSinemaDAO().list();
        return "/sinema/yapimci/update";
    }

}
