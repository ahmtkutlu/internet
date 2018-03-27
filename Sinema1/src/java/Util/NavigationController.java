/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author idea
 */

@ManagedBean
@SessionScoped
public class NavigationController implements Serializable{
    public String goToPage(String page){
    return "/"+page+"?faces-redirect=true";
    }
}
