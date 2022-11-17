package com.ipartek.formacion.mf0966ejemplo.accesodatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// Data Access Object
public interface Dao<T> {

	default Connection getConexion() {
		try {
			Class.forName(Globales.DRIVER);
			return DriverManager.getConnection(Globales.URL, Globales.USER, Globales.PASSWORD);
		} catch (SQLException e) {
			throw new AccesoDatosException("Ha habido un error al cargar el driver", e);
		} catch (ClassNotFoundException e) {
			throw new AccesoDatosException("No se ha podido encontrar el driver");
		}

	}

	// CRUD
	// Create Retrieve Update Delete
	default Iterable<T> obtenerTodos() {
		throw new UnsupportedOperationException("No está implementada esta operación");
	}

	default T obtenerPorId(Long id) {
		throw new UnsupportedOperationException("No está implementada esta operación");
	}

	default T insertar(T objeto) {
		throw new UnsupportedOperationException("No está implementada esta operación");
	}

	default T modificar(T objeto) {
		throw new UnsupportedOperationException("No está implementada esta operación");
	}

	default void borrar(Long id) {
		throw new UnsupportedOperationException("No está implementada esta operación");
	}
}
