package com.ipartek.formacion.mf0966ejemplo.accesodatos;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ipartek.formacion.mf0966ejemplo.modelos.Empleado;

public class DaoMySqlEmpleado implements Dao<Empleado> {
	private static final String SQL_SELECT = "call mf0966ejemplo.empleados_obtener_todos()";
	private static final String SQL_SELECT_ID = "call mf0966ejemplo.empleados_obtener_por_id(?)";
	private static final String SQL_INSERT = "call mf0966ejemplo.empleados_insertar(?,?,?)";
	private static final String SQL_UPDATE = "call mf0966ejemplo.empleados_modificar(?,?,?,?)";
	private static final String SQL_DELETE = "call mf0966ejemplo.empleados_borrar(?)";

	// SINGLETON
	private DaoMySqlEmpleado() {
	}

	private static final DaoMySqlEmpleado INSTANCIA = new DaoMySqlEmpleado();

	public static DaoMySqlEmpleado getInstancia() {
		return INSTANCIA;
	}
	// FIN SINGLETON

	@Override
	public Iterable<Empleado> obtenerTodos() {
		try (Connection con = getConexion();
				CallableStatement cst = con.prepareCall(SQL_SELECT);
				ResultSet rs = cst.executeQuery()) {

			ArrayList<Empleado> empleados = new ArrayList<>();
			
			Empleado e;
			Empleado j;

			while (rs.next()) {
				j = new Empleado(rs.getLong("j.id"), rs.getString("j.nombre"), rs.getString("j.nif"), null);
				e = new Empleado(rs.getLong("e.id"), rs.getString("e.nombre"), rs.getString("e.nif"), j);
				
				empleados.add(e);
			}
			
			return empleados;
		} catch (SQLException e) {
			throw new AccesoDatosException("No se han podido obtener todos los registros", e);
		}
	}

	@Override
	public Empleado obtenerPorId(Long id) {
		try (Connection con = getConexion(); CallableStatement cst = con.prepareCall(SQL_SELECT_ID);) {
			cst.setLong(1, id);
			ResultSet rs = cst.executeQuery();

			return obtenerEmpleado(cst, rs);
		} catch (SQLException e) {
			throw new AccesoDatosException("No se ha podido obtener el empleado " + id, e);
		}
	}

	private Empleado obtenerEmpleado(CallableStatement cst, ResultSet rs) throws SQLException {
		boolean tieneJefe;

		if (!rs.next()) {
			return null;
		}
		
		Empleado empleado = new Empleado(rs.getLong("e_id"), rs.getString("e_nombre"), rs.getString("e_nif"), null);
		
		rs.close();

		tieneJefe = cst.getMoreResults();
		
		if(!tieneJefe) {
			return empleado;
		}
		
		rs = cst.getResultSet();

		empleado.setJefe(obtenerEmpleado(cst, rs));
		
		return empleado; 
	}

	@Override
	public Empleado insertar(Empleado empleado) {
		try (Connection con = getConexion(); CallableStatement cst = con.prepareCall(SQL_INSERT);) {
			cst.setString(1, empleado.getNombre());
			cst.setString(2, empleado.getNif());
			cst.setLong(3, empleado.getJefe().getId());
			
			ResultSet rs = cst.executeQuery();
			
			if(rs.next()) {
				empleado.setId(rs.getLong(1));
			}
				
			return empleado;
		} catch (SQLException e) {
			throw new AccesoDatosException("No se ha podido insertar el empleado", e);
		}
	}

	@Override
	public Empleado modificar(Empleado empleado) {
		try (Connection con = getConexion(); CallableStatement cst = con.prepareCall(SQL_UPDATE);) {
			cst.setString(1, empleado.getNombre());
			cst.setString(2, empleado.getNif());
			cst.setLong(3, empleado.getJefe().getId());
			cst.setLong(4,  empleado.getId());
			
			cst.executeUpdate();
			
			return empleado;
		} catch (SQLException e) {
			throw new AccesoDatosException("No se ha podido modificar el empleado", e);
		}	
	}

	@Override
	public void borrar(Long id) {
		try (Connection con = getConexion(); CallableStatement cst = con.prepareCall(SQL_DELETE);) {
			cst.setLong(1, id);
			
			cst.executeUpdate();
		} catch (SQLException e) {
			throw new AccesoDatosException("No se ha podido borrar el empleado", e);
		}
	}
}
