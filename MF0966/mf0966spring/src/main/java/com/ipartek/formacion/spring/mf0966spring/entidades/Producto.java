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
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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
	@Min(value = 0)
	private Long id;

	@NotNull
	@NotBlank
	@Size(min = 3, max = 45)
	private String nombre;

	@NotNull
	@Min(value = 0)
	private BigDecimal precio;

	@Size(max = 5000)
	private String descripcion;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "categorias_id")
	private Categoria categoria;

	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "producto")
	private final Set<Linea> lineas = new HashSet<>();
}
