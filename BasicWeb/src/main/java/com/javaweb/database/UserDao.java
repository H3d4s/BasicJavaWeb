package com.javaweb.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.javaweb.model.UserModel;

public class UserDao {
	private String dbUrl = "jdbc:mysql://localhost:3306/userdb";
	private String dbUname = "root";
	private String dbPassword = "Vanhung28122003!";
	private String dbDriver = "com.mysql.cj.jdbc.Driver";

	public void loadDriver(String dbDriver) {
		try {
			Class.forName(dbDriver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public Connection getConnection() {
		Connection con = null;
		try {
			con = DriverManager.getConnection(dbUrl, dbUname, dbPassword);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}

	public boolean validate(UserModel userModel) {
		loadDriver(dbDriver);
		Connection con = getConnection();
		boolean status = false;
		String sql = "select * from login where username = ? and password = ?";
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, userModel.getUserName());
			ps.setString(2, userModel.getPassword());

			ResultSet rs = ps.executeQuery();
			status = rs.next();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return status;
	}
	
	public boolean registerUser(UserModel userModel) {
	    loadDriver(dbDriver);
	    Connection con = getConnection();
	    String sql = "INSERT INTO login (username, password, role) VALUES (?, ?, ?)";

	    try (PreparedStatement ps = con.prepareStatement(sql)) {
	        ps.setString(1, userModel.getUserName());
	        ps.setString(2, userModel.getPassword());
	        ps.setString(3, userModel.getRole());
	        int i = ps.executeUpdate();
	        return i > 0;
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return false;
	}

	
	public UserModel getUserByUsernameAndPassword(String username, String password) {
	    loadDriver(dbDriver);
	    Connection con = getConnection();
	    String sql = "SELECT * FROM login WHERE username = ? AND password = ?";
	    try (PreparedStatement ps = con.prepareStatement(sql)) {
	        ps.setString(1, username);
	        ps.setString(2, password);
	        try (ResultSet rs = ps.executeQuery()) {
	            if (rs.next()) {
	                return new UserModel(rs.getString("username"), rs.getString("password"), rs.getString("role"));
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return null;
	}


}
