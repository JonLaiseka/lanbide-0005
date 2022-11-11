package com.ipartek.formacion.mf0967.uf2216.doscapas.entidades;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

// Vamos a utilizarlo como Modelo en lugar de Entidad 
public class Producto {
	private Long id;
	private String nombre;
	private LocalDate caducidad;
	private BigDecimal precio;
	private Integer cantidad;

	private Map<String, String> errores = new TreeMap<>();

	public Producto(String id, String nombre, String caducidad, String precio, String cantidad) {
		setId(id);
		setNombre(nombre);
		setCaducidad(caducidad);
		setPrecio(precio);
		setCantidad(cantidad);
	}

	public Producto(Long id, String nombre, LocalDate caducidad, BigDecimal precio, Integer cantidad) {
		setId(id);
		setNombre(nombre);
		setCaducidad(caducidad);
		setPrecio(precio);
		setCantidad(cantidad);
	}

	public Producto() {
	}

	public Long getId() {
		return id;
	}

	private void setId(String id) {
		if (id == null) {
			setId((Long) null);
		} else {
			if (id.trim().length() == 0) {
				setId((Long) null);
			} else {
				try {
					setId(Long.parseLong(id));
				} catch (NumberFormatException e) {
					errores.put("id", "El id debe ser numérico");
				}
			}
		}
	}

	public void setId(Long id) {
		if (id != null && id <= 0L) {
			errores.put("id", "El id debe ser mayor o igual que uno");
		}

		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		if (nombre == null || nombre.trim().length() < 5) {
			errores.put("nombre", "El producto tiene que tener un nombre de 5 caracteres o más");
		}

		this.nombre = nombre.trim();
	}

	public LocalDate getCaducidad() {
		return caducidad;
	}

	private void setCaducidad(String caducidad) {
		try {
			setCaducidad(LocalDate.parse(caducidad));
		} catch (Exception e) {
			errores.put("caducidad", "La caducidad debe ser una fecha válida");
		}
	}

	public void setCaducidad(LocalDate caducidad) {
		if (caducidad != null && caducidad.isBefore(LocalDate.now())) {
			errores.put("caducidad", "No se pueden crear productos caducados");
		}

		this.caducidad = caducidad;
	}

	public BigDecimal getPrecio() {
		return precio;
	}

	private void setPrecio(String precio) {
		try {
			setPrecio(new BigDecimal(precio));
		} catch (Exception e) {
			errores.put("precio", "El precio debe ser un número con decimales");
		}
	}

	public void setPrecio(BigDecimal precio) {
		if (precio == null || precio.compareTo(new BigDecimal("0.01")) < 0) {
			errores.put("precio", "El precio debe ser 0.01 o más");
		}

		this.precio = precio;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	private void setCantidad(String cantidad) {
		try {
			setCantidad(Integer.parseInt(cantidad));
		} catch (NumberFormatException e) {
			errores.put("cantidad", "La cantidad debe ser numérica y es obligatoria");
		}
	}

	public void setCantidad(Integer cantidad) {
		if (cantidad == null || cantidad < 0) {
			errores.put("cantidad", "La cantidad debe ser 0 o más");
		}

		this.cantidad = cantidad;
	}

	public Map<String, String> getErrores() {
		return errores;
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
