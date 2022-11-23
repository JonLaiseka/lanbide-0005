package com.ipartek.formacion.mf0966ejemplo.accesodatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import com.ipartek.formacion.mf0966ejemplo.modelos.Categoria;
import com.ipartek.formacion.mf0966ejemplo.modelos.Producto;

public class DaoMySqlProducto implements Dao<Producto> {

	//private static final String SQL_SELECT = "SELECT p.id,p.nombre,p.precio,p.descripcion,p.categorias_id FROM productos p";
	private static final String SQL_SELECT = "SELECT p.id,p.nombre,p.precio,p.descripcion,c.id,c.nombre,c.descripcion FROM productos p JOIN categorias c ON p.categorias_id = c.id";
	private static final String SQL_SELECT_ID = "SELECT p.id,p.nombre,p.precio,p.descripcion,c.id,c.nombre,c.descripcion FROM productos p JOIN categorias c ON p.categorias_id = c.id WHERE p.id = ?";
	private static final String SQL_INSERT = "INSERT INTO productos (nombre,precio,descripcion,categorias_id) VALUES (?,?,?,?)";
	private static final String SQL_UPDATE = "UPDATE productos SET nombre=?,precio=?,descripcion=?,categorias_id=? WHERE id = ?";
	private static final String SQL_DELETE = "DELETE FROM productos WHERE id = ?";

	// SINGLETON
	private DaoMySqlProducto() {
	}

	private static final DaoMySqlProducto INSTANCIA = new DaoMySqlProducto();

	public static DaoMySqlProducto getInstancia() {
		return INSTANCIA;
	}
	// FIN SINGLETON

	@Override
	public Iterable<Producto> obtenerTodos() {
		try (Connection con = getConexion();
				PreparedStatement pst = con.prepareStatement(SQL_SELECT);
				ResultSet rs = pst.executeQuery()) {
			Producto producto = null;
			Categoria categoria;
			List<Producto> productos = new ArrayList<>();

			while (rs.next()) {
				categoria = new Categoria(rs.getLong("c.id"), rs.getString("c.nombre"), rs.getString("c.descripcion"));
				producto = new Producto(rs.getLong("p.id"), rs.getString("p.nombre"), rs.getBigDecimal("p.precio"),
						rs.getString("p.descripcion"), categoria);

				productos.add(producto);
			}

			return productos;
		} catch (SQLException e) {
			throw new AccesoDatosException("No se han podido obtener los productos", e);
		}
	}

	@Override
	public Producto obtenerPorId(Long id) {
		try (Connection con = getConexion(); PreparedStatement pst = con.prepareStatement(SQL_SELECT_ID)) {
			pst.setLong(1, id);

			ResultSet rs = pst.executeQuery();

			Producto producto = null;
			Categoria categoria;

			if (rs.next()) {
				categoria = new Categoria(rs.getLong("c.id"), rs.getString("c.nombre"), rs.getString("c.descripcion"));
				producto = new Producto(rs.getLong("p.id"), rs.getString("p.nombre"), rs.getBigDecimal("p.precio"),
						rs.getString("p.descripcion"), categoria);
			}

			return producto;
		} catch (SQLException e) {
			throw new AccesoDatosException("No se ha podido obtener el producto", e);
		}
	}

	@Override
	public Producto insertar(Producto producto) {
		try (Connection con = getConexion(); PreparedStatement pst = con.prepareStatement(SQL_INSERT)) {
			pst.setString(1, producto.getNombre());
			pst.setBigDecimal(2, producto.getPrecio());
			pst.setString(3, producto.getDescripcion());
			pst.setLong(4, producto.getCategoria().getId());

			int numRegMod = pst.executeUpdate();

			if (numRegMod != 1) {
				throw new AccesoDatosException(
						"No se ha insertado nada, o se ha insertado más de un registro: " + numRegMod);
			}

			return producto;
		} catch (SQLException e) {
			throw new AccesoDatosException("No se ha podido obtener el producto", e);
		}

	}

	@Override
	public Producto modificar(Producto producto) {
		try (Connection con = getConexion(); PreparedStatement pst = con.prepareStatement(SQL_UPDATE)) {
			pst.setString(1, producto.getNombre());
			pst.setBigDecimal(2, producto.getPrecio());
			pst.setString(3, producto.getDescripcion());
			pst.setLong(4, producto.getCategoria().getId());
			pst.setLong(5, producto.getId());

			int numRegMod = pst.executeUpdate();

			if (numRegMod != 1) {
				throw new AccesoDatosException(
						"No se ha modificado nada, o se ha modificado más de un registro: " + numRegMod);
			}

			return producto;
		} catch (SQLException e) {
			throw new AccesoDatosException("No se ha podido obtener el producto", e);
		}
	}

	@Override
	public void borrar(Long id) {
		try (Connection con = getConexion(); PreparedStatement pst = con.prepareStatement(SQL_DELETE)) {
			pst.setLong(1, id);

			int numRegMod = pst.executeUpdate();

			if (numRegMod != 1) {
				throw new AccesoDatosException(
						"No se ha borrado nada, o se ha borrado más de un registro: " + numRegMod);
			}
		} catch (SQLException e) {
			throw new AccesoDatosException("No se ha podido obtener el producto", e);
		}
	}

}
