package com.ipartek.formacion.spring.mf0966spring.entidades;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import com.ipartek.formacion.spring.mf0966spring.entidades.Pedido.Linea;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "productos")
public class Producto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nombre;
	private BigDecimal precio;
	private String descripcion;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "categorias_id")
	private Categoria categoria;
	
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "producto")
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
