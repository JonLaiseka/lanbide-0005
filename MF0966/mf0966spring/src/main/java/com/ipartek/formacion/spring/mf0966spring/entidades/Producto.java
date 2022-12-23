package com.ipartek.formacion.spring.mf0966spring.entidades;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import com.ipartek.formacion.spring.mf0966spring.entidades.Pedido.Linea;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Producto {

	private Long id;
	private String nombre;
	private BigDecimal precio;
	private String descripcion;
	
	private Categoria categoria;
	
	private final Set<Linea> lineas = new HashSet<>();
	
	public Producto(String id, String nombre, String precio, String descripcion, String categoria) {
		setId(id);
		setNombre(nombre);
		setPrecio(precio);
		setDescripcion(descripcion);
		
		setCategoria(categoria);
	}

	private void setId(String id) {
		if(id == null) return;
		
		if(id.trim().length() != 0) {
			setId(Long.parseLong(id));	
		}
	}
	
	private void setId(Long id) {
		this.id = id;
	}

	private void setPrecio(String precio) {
		setPrecio(new BigDecimal(precio));
	}

	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}

	private void setCategoria(String categoria) {
		setCategoria(new Categoria(Long.parseLong(categoria), null, null));
	}


	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
}
