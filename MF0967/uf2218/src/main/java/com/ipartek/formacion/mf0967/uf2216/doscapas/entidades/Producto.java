package com.ipartek.formacion.mf0967.uf2216.doscapas.entidades;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

public class Producto {
	private Long id;
	private String nombre;
	private LocalDate caducidad;
	private BigDecimal precio;
	private Integer cantidad;

	public Producto(Long id, String nombre, LocalDate caducidad, BigDecimal precio, Integer cantidad) {
		setId(id);
		setNombre(nombre);
		setCaducidad(caducidad);
		setPrecio(precio);
		setCantidad(cantidad);
	}
	
	public Producto() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		if (id != null && id <= 0L) {
			throw new EntidadesException("El id debe ser mayor o igual que uno");
		}

		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		if (nombre == null || nombre.trim().length() < 5) {
			throw new EntidadesException("El producto tiene que tener un nombre de 5 caracteres o más");
		}
		
		this.nombre = nombre.trim();
	}

	public LocalDate getCaducidad() {
		return caducidad;
	}

	public void setCaducidad(LocalDate caducidad) {
		if(caducidad != null && caducidad.isBefore(LocalDate.now())) {
			throw new EntidadesException("No se pueden crear productos caducados");
		}
		
		this.caducidad = caducidad;
	}

	public BigDecimal getPrecio() {
		return precio;
	}

	public void setPrecio(BigDecimal precio) {
		if(precio == null || precio.compareTo(new BigDecimal("0.01")) < 0) {
			throw new EntidadesException("El precio debe ser 0.01 o más");
		}
		
		this.precio = precio;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		if(cantidad == null || cantidad < 0) {
			throw new EntidadesException("La cantidad debe ser 0 o más");
		}
		
		this.cantidad = cantidad;
	}

	@Override
	public int hashCode() {
		return Objects.hash(caducidad, cantidad, id, nombre, precio);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Producto other = (Producto) obj;
		return Objects.equals(caducidad, other.caducidad) && Objects.equals(cantidad, other.cantidad)
				&& Objects.equals(id, other.id) && Objects.equals(nombre, other.nombre)
				&& Objects.equals(precio, other.precio);
	}

	@Override
	public String toString() {
		return "Producto [id=" + id + ", nombre=" + nombre + ", caducidad=" + caducidad + ", precio=" + precio
				+ ", cantidad=" + cantidad + "]";
	}
}
