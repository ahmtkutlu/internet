/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import Dao.yapimciDAO;
import Dao.yonetmenDAO;
import Entity.yapimci;
import Entity.yonetmen;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author idea
 */
@ManagedBean(name = "yonetmen")
@SessionScoped
public class yonetmenController {

    private yonetmen y = null;
    private ArrayList<yonetmen> yonetmenlist = null;
    private yonetmenDAO yonetmenDAO = null;

    public yonetmen getY() {
        if (this.y == null) {
            this.y = new yonetmen();
        }
        return y;
    }

    public void setY(yonetmen y) {
        this.y = y;
    }

    public ArrayList<yonetmen> getYonetmenlist() {

        if (this.yonetmenlist == null) {
            this.yonetmenlist = new ArrayList();
            yonetmenlist = this.getYonetmenDAO().list();
        }
        return this.yonetmenlist;

    }

    public void setYonetmenlist(ArrayList<yonetmen> yonetmenlist) {
        this.yonetmenlist = yonetmenlist;
    }

    public yonetmenDAO getYonetmenDAO() {
        if (this.yonetmenDAO == null) {
            this.yonetmenDAO = new yonetmenDAO();
        }
        return yonetmenDAO;
    }

    public void setYonetmenDAO(yonetmenDAO yonetmenDAO) {
        this.yonetmenDAO = yonetmenDAO;
    }

    public String delete(yonetmen yonetmen) {
        this.getYonetmenDAO().delete(yonetmen);
        this.yonetmenlist = this.getYonetmenDAO().list();
        return "/tamamm";
    }

    public String create() {

        this.getYonetmenDAO().create(this.y);
        this.yonetmenlist = this.getYonetmenDAO().list();
        this.y = null;
        return "/tamam";
    }

    public String update() {

        this.getYonetmenDAO().update(this.y);
        this.yonetmenlist = this.getYonetmenDAO().list();
        return "/sinema/yonetmen/update";
    }

}
