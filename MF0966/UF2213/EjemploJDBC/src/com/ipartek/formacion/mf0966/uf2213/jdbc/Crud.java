package com.ipartek.formacion.mf0966.uf2213.jdbc;

import java.sql.*;

public class Crud {
	private static final String URL = "jdbc:mysql://localhost:3306/mf0966";
	private static final String USER = "root";
	private static final String PASSWORD = "admin";

	private static final String SQL_SELECT = "SELECT * FROM usuarios";
	private static final String SQL_SELECT_ID = "SELECT * FROM usuarios WHERE id = ?";
	private static final String SQL_INSERT = "INSERT INTO usuarios (email, password) VALUES (?, ?)";
	private static final String SQL_UPDATE = "UPDATE usuarios SET email=?,password=? WHERE id=?";
	private static final String SQL_DELETE = "DELETE FROM usuarios WHERE id=?";

	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";

	public static void main(String[] args) throws SQLException {

		select();
		Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
		PreparedStatement pst = con.prepareStatement(SQL_SELECT_ID);
		ResultSet rs;

		Long id = 1L;

		pst.setLong(1, id);

		rs = pst.executeQuery();

		// rs = st.executeQuery(sqlId);

		if (rs.next()) {
			System.out.printf("%s: %s, %s\n", rs.getLong("id"), rs.getString("email"), rs.getString("password"));
		}

		pst = con.prepareStatement(SQL_INSERT);

		String email = "yepa@email.net" + Math.random();
		String pass = "lalaralalaaaa\\'); DROP TABLE usuarios; -- ";

		pst.setString(1, email);
		pst.setString(2, pass);

		int numRegMod = pst.executeUpdate();

		System.out.println(numRegMod);

		pst = con.prepareStatement(SQL_UPDATE);

		id = 8L;
		email = "prueba@email.net";
		pass = "Prueba";

		pst.setString(1, email);
		pst.setString(2, pass);
		pst.setLong(3, id);

		numRegMod = pst.executeUpdate();

		System.out.println(numRegMod);

		pst = con.prepareStatement(SQL_DELETE);

		id = 10L;

		pst.setLong(1, id);

		numRegMod = pst.executeUpdate();

		System.out.println(numRegMod);
	}

	private static void select() {
		try {
			Class.forName(DRIVER);
	
			try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
					PreparedStatement pst = con.prepareStatement(SQL_SELECT);
					ResultSet rs = pst.executeQuery()) {
				while (rs.next()) {
					System.out.printf("%s: %s, %s\n", rs.getLong("id"), rs.getString("email"), rs.getString("password"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}

