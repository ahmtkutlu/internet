/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin.controller;

import admin.dao.UserDAO;
import admin.entity.User;
import java.io.Serializable;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author cypher
 */
@ManagedBean(name="userController")
@SessionScoped
public class UserBean implements Serializable{
	private User user;
	private UserDAO userDao;
	private ArrayList<User> userList;
	
	public String create() {
		this.getUserDao().create(this.user);
		return "/admin/user/list?faces-redirect=true";
	}
	
	public String createForm() {
		return "/admin/user/create?faces-redirect=true";
	}
	public String updateForm() {
		return "/admin/user/update?faces-redirect=true";
	}
	
	public String delete(User u) {
		this.getUserDao().delete(u);
		return "/admin/user/list?faces-redirect=true";
	}

	public User getUser() {
		if ( this.user == null )
			this.user = new User();
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public UserDAO getUserDao() {
		if ( this.userDao == null )
			this.userDao = new UserDAO();
		return userDao;
	}

	public void setUserDao(UserDAO userDao) {
		this.userDao = userDao;
	}

	public ArrayList<User> getUserList() {
		this.userList = new ArrayList();
		this.userList = this.getUserDao().list();
		return userList;
	}

	public void setUserList(ArrayList<User> userList) {
		this.userList = userList;
	}
}
