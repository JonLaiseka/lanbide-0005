package com.ipartek.formacion.mf0966.uf2213.jdbc;

import java.sql.*;

public class Crud {
	private static final String url = "jdbc:mysql://localhost:3306/mf0966";
	private static final String user = "root";
	private static final String password = "admin";

	private static final String sql = "SELECT * FROM usuarios";
	private static final String sqlId = "SELECT * FROM usuarios WHERE id = ?";
	private static final String sqlInsert = "INSERT INTO usuarios (email, password) VALUES (?, ?)";
	private static final String sqlUpdate = "UPDATE usuarios SET email=?,password=? WHERE id=?";
	private static final String sqlDelete = "DELETE FROM usuarios WHERE id=?";

	private static final String driver = "com.mysql.cj.jdbc.Driver";

	public static void main(String[] args) throws SQLException {

		select();
		Connection con = DriverManager.getConnection(url, user, password);
		PreparedStatement pst = con.prepareStatement(sqlId);
		ResultSet rs;

		Long id = 1L;

		pst.setLong(1, id);

		rs = pst.executeQuery();

		// rs = st.executeQuery(sqlId);

		if (rs.next()) {
			System.out.printf("%s: %s, %s\n", rs.getLong("id"), rs.getString("email"), rs.getString("password"));
		}

		pst = con.prepareStatement(sqlInsert);

		String email = "yepa@email.net" + Math.random();
		String pass = "lalaralalaaaa\\'); DROP TABLE usuarios; -- ";

		pst.setString(1, email);
		pst.setString(2, pass);

		int numRegMod = pst.executeUpdate();

		System.out.println(numRegMod);

		pst = con.prepareStatement(sqlUpdate);

		id = 8L;
		email = "prueba@email.net";
		pass = "Prueba";

		pst.setString(1, email);
		pst.setString(2, pass);
		pst.setLong(3, id);

		numRegMod = pst.executeUpdate();

		System.out.println(numRegMod);

		pst = con.prepareStatement(sqlDelete);

		id = 10L;

		pst.setLong(1, id);

		numRegMod = pst.executeUpdate();

		System.out.println(numRegMod);
	}

	private static void select() {
		try {
			Class.forName(driver);
	
			try (Connection con = DriverManager.getConnection(url, user, password);
					PreparedStatement pst = con.prepareStatement(sql);
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

