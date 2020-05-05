package com.login.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDao
{
	String url = "jdbc:mysql://localhost:3306/jdbc";
	String username = "root";
	String pass = "******";
	String query = "Select * from logininfo where username= ? and password = ?";
	
	public boolean check(String uname, String password) throws SQLException, ClassNotFoundException
	{
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url,username,pass);
		
		PreparedStatement pst = con.prepareStatement(query);
		pst.setString(1, uname);
		pst.setString(2, password);
		
		ResultSet rs = pst.executeQuery();
		

		if( rs.next() )
		{
			return true;
		}
		
		return false;
	}
}
