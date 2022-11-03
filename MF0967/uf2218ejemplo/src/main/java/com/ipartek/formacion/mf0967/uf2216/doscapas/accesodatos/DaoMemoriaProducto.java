package com.ipartek.formacion.mf0967.uf2216.doscapas.accesodatos;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Random;
import java.util.TreeMap;

import com.ipartek.formacion.mf0967.uf2216.doscapas.entidades.Producto;

public class DaoMemoriaProducto implements Dao<Producto> {
	private TreeMap<Long, Producto> productos = new TreeMap<>();

	// SINGLETON
	private DaoMemoriaProducto() {
		for (Long l = 1L; l <= 10; l++) {
			productos.put(l, new Producto(l, "Nombre" + l, LocalDate.now().plusYears(l),
					new BigDecimal(new Random().nextInt(1, 100)), l.intValue()));
		}
	}

	private static final DaoMemoriaProducto INSTANCIA = new DaoMemoriaProducto();

	public static DaoMemoriaProducto getInstancia() {
		return INSTANCIA;
	}
	// FIN SINGLETON

	@Override
	public Iterable<Producto> obtenerTodos() {
		return productos.values();
	}

	@Override
	public Producto obtenerPorId(Long id) {
		return productos.get(id);
	}

	@Override
	public Producto insertar(Producto producto) {
		Long id = productos.size() == 0 ? 1L : productos.lastKey() + 1L;
		producto.setId(id);
		productos.put(id, producto);

		return producto;
	}

	@Override
	public Producto modificar(Producto producto) {
		productos.put(producto.getId(), producto);

		return producto;
	}

	@Override
	public void borrar(Long id) {
		productos.remove(id);
	}
}
