package com.ipartek.formacion.mf0966ejemplo.modelos;

import java.math.BigDecimal;
import java.util.Map;
import java.util.TreeMap;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@EqualsAndHashCode
public class Pedido {
	private TreeMap<Long, Linea> lineas = new TreeMap<>();

	public Iterable<Linea> getLineas() {
		return lineas.values();
	}
	
	public Map<Long, Linea> getLineasPorId() {
		return lineas;
	}

	public void guardar(Integer cantidad, Producto producto) {
		Long id = producto.getId();

		if (lineas.containsKey(id)) {
			Linea linea = lineas.get(id);

			if (cantidad > 0) {
				linea.setCantidad(cantidad);
			} else {
				lineas.remove(id);
			}

		} else {
			lineas.put(producto.getId(), new Linea(producto, cantidad));
		}
	}

	public void guardar(Producto producto) {
		Long id = producto.getId();

		if (lineas.containsKey(id)) {
			guardar(1 + lineas.get(id).getCantidad(), producto);
		} else {
			guardar(1, producto);
		}
	}

	public void eliminar(Producto producto) {
		lineas.remove(producto.getId());
	}

	public void vaciar() {
		lineas.clear();
	}

	public BigDecimal getTotal() {
		return lineas.values().stream()
				.map(Linea::getTotal)
				.filter(total -> total.compareTo(BigDecimal.ZERO) != 0)
				.reduce(BigDecimal.ZERO, BigDecimal::add);
	}

	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class Linea {
		private Factura factura;
		private Producto producto;
		private Integer cantidad;

		public Linea(Producto producto, Integer cantidad) {
			this.producto = producto;
			this.cantidad = cantidad;
		}

		public BigDecimal getTotal() {
			return this.producto.getPrecio().multiply(new BigDecimal(cantidad));
		}
	}
}
