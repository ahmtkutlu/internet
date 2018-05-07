/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin.controller;

import admin.dao.UserDAO;
import admin.entity.User;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import utility.SessionUtility;

/**
 *
 * @author cypher
 */
@ManagedBean(name = "login")
@SessionScoped
public class LoginBean implements Serializable {

	private User user;
	private UserDAO userDao;
	private boolean loggedIn = false;

	public String login() {
		User a = this.getUserDao().login(this.user);
		if (a != null) {
			this.loggedIn = true;
			HttpSession session = SessionUtility.getSession();
			session.setAttribute("user", a);
			return "/admin/index?faces-redirect=true";
		} else {
			return "/admin/login?faces-redirect=true";
		}
	}

	public String doLogout() {

		this.setLoggedIn(false);

		FacesMessage msg = new FacesMessage("Logout success!", "INFO MSG");
		msg.setSeverity(FacesMessage.SEVERITY_INFO);
		FacesContext.getCurrentInstance().addMessage(null, msg);
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "/admin/login?faces-redirect=true";
	}

	public User getUser() {
		if (this.user == null) {
			this.user = new User();
		}
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public UserDAO getUserDao() {
		if (this.userDao == null) {
			this.userDao = new UserDAO();
		}
		return userDao;
	}

	public void setUserDao(UserDAO userDao) {
		this.userDao = userDao;
	}

	public boolean isLoggedIn() {
		return loggedIn;
	}

	public void setLoggedIn(boolean isLoggedIn) {
		this.loggedIn = isLoggedIn;
	}
}
