package com.ipartek.formacion.spring.mf0966spring.repositorios;

import java.math.BigInteger;
import java.sql.PreparedStatement;
import java.sql.Statement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
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
		return jdbc.queryForObject("SELECT * FROM empleados WHERE id = ?",
				new BeanPropertyRowMapper<Empleado>(Empleado.class), id);
	}

	public Empleado insertar(Empleado empleado) {
		// jdbc.update("INSERT INTO empleados (nombre, nif) VALUES (?,?)",
		// empleado.getNombre(), empleado.getNif());
		KeyHolder keyHolder = new GeneratedKeyHolder();

		jdbc.update(con -> {
			PreparedStatement ps = con.prepareStatement("INSERT INTO empleados (nombre, nif) VALUES (?,?)", Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, empleado.getNombre());
			ps.setString(2, empleado.getNif());
			return ps;
		}, keyHolder);

		empleado.setId(((BigInteger) keyHolder.getKey()).longValue());

		return empleado;

	}

	public Empleado modificar(Empleado empleado) {
		jdbc.update("UPDATE empleados SET nombre=?, nif=? WHERE id = ?", empleado.getNombre(), empleado.getNif(),
				empleado.getId());
		return empleado;
	}

	public void borrar(Long id) {
		jdbc.update("DELETE FROM empleados WHERE id = ?", id);
	}
}
