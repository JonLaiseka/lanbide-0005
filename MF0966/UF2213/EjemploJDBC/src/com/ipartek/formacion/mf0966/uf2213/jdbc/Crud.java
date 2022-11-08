package com.ipartek.formacion.mf0966.uf2213.jdbc;

import java.sql.*;

public class Crud {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		String url = "jdbc:mysql://localhost:3306/mf0966";
		String user = "root";
		String password = "admin";
		
		String sql = "SELECT * FROM usuarios";
		
		String driver = "com.mysql.cj.jdbc.Driver";
		
		Class.forName(driver);
		
		Connection con = DriverManager.getConnection(url, user, password);
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		
		while(rs.next()) {
			System.out.printf("%s: %s, %s\n", rs.getLong("id"), rs.getString("email"), rs.getString("password"));
		}
		
	}

}
