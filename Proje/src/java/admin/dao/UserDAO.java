/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin.dao;

import admin.entity.User;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import utility.ConnectionManager;

/**
 *
 * @author cypher
 */
public class UserDAO implements DAO<User> {

	@Override
	public void create(User o) {
		try {
			Connection c = ConnectionManager.getConnection();
			Statement s = c.createStatement();
			String sql = "";
			sql = "insert into user (email, password, name_surname ) values ('" + ((User) o).getEmail() + "', '" + ((User) o).getPassword() + "','" + ((User) o).getName_surname() + "')";
			s.executeUpdate(sql);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public void update(User o) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public ArrayList<User> list() {
		ArrayList<User> cList = new ArrayList();
		try {
			Connection c = ConnectionManager.getConnection();
			Statement s = c.createStatement();
			String sql = "select * from user";
			ResultSet rs = s.executeQuery(sql);
			while (rs.next()) {
				cList.add(new User(rs.getInt("id"), rs.getString("email"), rs.getString("password"), rs.getString("name_surname"), rs.getDate("created"), rs.getDate("updated")));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return cList;
	}

	@Override
	public ArrayList<User> pagedList(int page) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public void delete(User o) {
		try {
			Connection c = ConnectionManager.getConnection();
			Statement s = c.createStatement();
			String sql = "delete from user where id=" + o.getId();
			s.executeUpdate(sql);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public User detail(int id) {
		User user = null;
		try {
			Connection c = ConnectionManager.getConnection();
			Statement s = c.createStatement();
			String sql = "select * from user where id=" + id;
			ResultSet rs = s.executeQuery(sql);
			rs.next();
			user = new User(rs.getInt("id"), rs.getString("email"), rs.getString("password"), rs.getString("name_surname"), rs.getDate("created"), rs.getDate("updated"));
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return user;
	}

	public User login(User u) {
		User tmp = null;
		try {

			String np = UserDAO.encryptPassword(u.getPassword());

			Connection c = ConnectionManager.getConnection();
			Statement s = c.createStatement();
			String sql = "select * from user where email='" + u.getEmail() + "' and password='" + u.getPassword()+ "'";
			ResultSet rs = s.executeQuery(sql);
			if (rs.next()) {
				tmp = new User(rs.getInt("id"), rs.getString("email"), rs.getString("password"), rs.getString("name_surname"), rs.getDate("created"), rs.getDate("updated"));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} catch (NoSuchAlgorithmException ex) {
			Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
		} catch (UnsupportedEncodingException ex) {
			Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
		}
		return tmp;
	}

	private static String encryptPassword(String password) throws NoSuchAlgorithmException, UnsupportedEncodingException {

		MessageDigest crypt = MessageDigest.getInstance("SHA-1");
		crypt.reset();
		crypt.update(password.getBytes("UTF-8"));

		return new BigInteger(1, crypt.digest()).toString(16);
	}
}
