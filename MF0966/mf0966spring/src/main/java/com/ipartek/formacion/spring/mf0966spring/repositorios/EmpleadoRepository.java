package com.ipartek.formacion.spring.mf0966spring.repositorios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ipartek.formacion.spring.mf0966spring.entidades.Empleado;

@Repository
public class EmpleadoRepository {
	@Autowired
	private JdbcTemplate jdbc;

	public Iterable<Empleado> obtenerTodos() {
		return jdbc.query("SELECT * FROM empleados", new BeanPropertyRowMapper<Empleado>(Empleado.class));
	}

	public Empleado obtenerPorId(Long id) {
		return jdbc.queryForObject("SELECT * FROM empleados WHERE id = ?", new BeanPropertyRowMapper<Empleado>(Empleado.class), id);
	}

	public Empleado insertar(Empleado empleado) {
		jdbc.update("INSERT INTO empleados (nombre, nif) VALUES (?,?)", empleado.getNombre(), empleado.getNif());
		return empleado;
	}
	
	public Empleado modificar(Empleado empleado) {
		jdbc.update("UPDATE empleados SET nombre=?, nif=? WHERE id = ?", empleado.getNombre(), empleado.getNif(), empleado.getId());
		return empleado;
	}
	
	public void borrar(Long id) {
		jdbc.update("DELETE FROM empleados WHERE id = ?", id);
	}
}
