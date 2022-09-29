package com.ipartek.formacion.mf0967.uf2216.doscapas.presentacion;

import static com.ipartek.formacion.mf0967.uf2216.bibliotecas.Consola.*;

import com.ipartek.formacion.mf0967.uf2216.doscapas.accesodatos.Dao;
import com.ipartek.formacion.mf0967.uf2216.doscapas.accesodatos.DaoMemoriaProducto;
import com.ipartek.formacion.mf0967.uf2216.doscapas.entidades.EntidadesException;
import com.ipartek.formacion.mf0967.uf2216.doscapas.entidades.Producto;

public class DosCapasConsola {
	private static final boolean PEDIR_DATOS_INSERTAR = false;
	private static final boolean PEDIR_DATOS_MODIFICAR = true;
	private static final int OBTENER_TODOS = 1;
	private static final int OBTENER_POR_ID = 2;
	private static final int INSERTAR = 3;
	private static final int MODIFICAR = 4;
	private static final int BORRAR = 5;
	private static final int SALIR = 0;

	private static final Dao<Producto> dao = DaoMemoriaProducto.getInstancia();
	
	public static void main(String[] args) {
		int opcion;
		
		do {
			mostrarMenu();
			opcion = pedirOpcion();
			procesarOpcion(opcion);
		} while (opcion != SALIR);
	}

	private static void mostrarMenu() {
		pl(OBTENER_TODOS + ". Ver todos los productos");
		pl(OBTENER_POR_ID + ". Ver un producto por su id");
		pl(INSERTAR + ". Añadir nuevo producto");
		pl(MODIFICAR + ". Modificar producto existente");
		pl(BORRAR + ". Borrar producto existente");
		pl();
		pl(SALIR + ". Salir");
		pl();
	}

	private static int pedirOpcion() {
		return gInt("Selecciona la opción");
	}

	private static void procesarOpcion(int opcion) {
		switch(opcion) {
		case OBTENER_TODOS:
			obtenerTodos();
			break;
		case OBTENER_POR_ID:
			obtenerPorId();
			break;
		case INSERTAR:
			insertar();
			break;
		case MODIFICAR:
			modificar();
			break;
		case BORRAR:
			borrar();
			break;
		case SALIR:
			pl("Gracias por usar la aplicación");
			break;
		default:
			ple("Opción no reconocida");
		}
	}

	private static void obtenerTodos() {
		pl();
		
		for(Producto p: dao.obtenerTodos()) {
			mostrarProducto(p);
		}
		
		pl();
	}

	private static void obtenerPorId() {
		long id = gLong("Introduce el id a buscar");
		Producto producto = dao.obtenerPorId(id);
		
		pl();
		mostrarProducto(producto);
		pl();
	}

	private static void insertar() {
		Producto p = pedirDatosProducto(PEDIR_DATOS_INSERTAR);
		
		dao.insertar(p);
		
		pl(p);
		pl("Producto insertado");
	}

	private static void modificar() {
		Producto p = pedirDatosProducto(PEDIR_DATOS_MODIFICAR);
		
		dao.modificar(p);
		
		pl(p);
		pl("Producto modificado");
	}

	private static void borrar() {
		long id = gLong("Introduce el id a borrar");
		dao.borrar(id);
		
		pl();
		pl("Producto borrado");
		pl();
	}

	private static void mostrarProducto(Producto p) {
		pl(p);
	}

	private static Producto pedirDatosProducto(boolean modificar) {
		Producto p = new Producto();
		
		boolean correcto;
		
		if (modificar) {
			correcto = false;
			do {
				try {
					p.setId(gLong("Id"));
					correcto = true;
				} catch (EntidadesException e) {
					ple(e.getMessage());
				}
			} while (!correcto);
		}
		correcto = false;
		
		do {
			try {
				p.setNombre(gString("Nombre"));
				correcto = true;
			} catch (EntidadesException e) {
				ple(e.getMessage());
			} 
		} while (!correcto);
		
		correcto = false;
		
		do {
			try {
				p.setCaducidad(gLocalDate("Caducidad"));
				correcto = true;
			} catch (EntidadesException e) {
				ple(e.getMessage());
			} 
		} while (!correcto);
		
		correcto = false;
		
		do {
			try {
				p.setPrecio(gBigDecimal("Precio"));
				correcto = true;
			} catch (EntidadesException e) {
				ple(e.getMessage());
			} 
		} while (!correcto);
		
		correcto = false;
		
		do {
			try {
				p.setCantidad(gInt("Cantidad"));
				correcto = true;
			} catch (EntidadesException e) {
				ple(e.getMessage());
			} 
		} while (!correcto);
		return p;
	}
}
