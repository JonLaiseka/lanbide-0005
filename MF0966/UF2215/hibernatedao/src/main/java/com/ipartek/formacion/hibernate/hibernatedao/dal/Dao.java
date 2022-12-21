package com.ipartek.formacion.hibernate.hibernatedao.dal;

import com.ipartek.formacion.hibernate.hibernatedao.entidades.Persona;

public interface Dao<T> {

	Iterable<Persona> obtenerTodos();

	Persona obtenerPorId(Long id);

	T insertar(T objeto);

	T modificar(T objeto);

	void borrar(Long l);

}
