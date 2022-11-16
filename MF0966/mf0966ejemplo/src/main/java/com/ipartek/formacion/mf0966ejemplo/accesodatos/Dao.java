package com.ipartek.formacion.mf0966ejemplo.accesodatos;

// Data Access Object
public interface Dao<T> {
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
