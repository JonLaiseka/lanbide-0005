package com.ipartek.formacion.spring.mf0966spring.entidades;

import java.math.BigDecimal;
import java.util.Map;
import java.util.TreeMap;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@EqualsAndHashCode
public class Pedido {
	protected TreeMap<Long, Linea> lineas = new TreeMap<>();

	public Iterable<Linea> getLineas() {
		return lineas.values();
	}

	public Map<Long, Linea> getLineasPorId() {
		return lineas;
	}

	public void guardar(Integer cantidad, Producto producto) {
		Long id = producto.getId();
		boolean estaProductoEnCarrito = lineas.containsKey(id);

		if (cantidad <= 0 && !estaProductoEnCarrito) {
			return;
		}

		if (!estaProductoEnCarrito) {
			lineas.put(producto.getId(), new Linea(producto, cantidad));
			return;
		}

		Linea linea = lineas.get(id);

		if (cantidad > 0) {
			linea.setCantidad(cantidad);
		} else {
			lineas.remove(id);
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
		return lineas.values().stream().map(Linea::getTotal).filter(total -> total.compareTo(BigDecimal.ZERO) != 0)
				.reduce(BigDecimal.ZERO, BigDecimal::add);
	}

	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	@Entity
	@Table(name = "facturas_has_productos")
	public static class Linea {
		@Id
		@ManyToOne
		private Factura factura;
		@Id
		@ManyToOne
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
