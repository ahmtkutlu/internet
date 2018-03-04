/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.io.Serializable;
import javax.annotation.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Kutlu
 */
@ManagedBean
@SessionScoped
public class Shape implements Serializable {
    private int w;
    private int h;

    public Shape() {
        this.w = 5;
        this.h = 6;
    }

    public int getW() {
        return w;
    }

    public void setW(int w) {
        this.w = w;
    }

    public int getH() {
        return h;
    }

    public void setH(int h) {
        this.h = h;
    }
    
    
}
