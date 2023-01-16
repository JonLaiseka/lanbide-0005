package com.ipartek.formacion.spring.mf0966spring.entidades;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Collection;

import com.ipartek.formacion.spring.mf0966spring.entidades.Pedido.Linea;

import jakarta.persistence.CascadeType;
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
@Table(name = "facturas")
public class Factura {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String codigo;
	private LocalDate fecha;
	
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "factura")
	private Collection<Linea> lineas;

	@ManyToOne
	@JoinColumn(name = "clientes_id")
	private Cliente cliente;
	
	@ManyToOne
	@JoinColumn(name = "empleados_id")
	private Empleado empleado;

	public Factura(Pedido pedido) {
		this.lineas = pedido.lineas.values();
		
		this.lineas.forEach(linea -> linea.setFactura(this));
	}
	
	public BigDecimal getTotal() {
		return lineas.stream().map(Linea::getTotal).filter(total -> total.compareTo(BigDecimal.ZERO) != 0)
				.reduce(BigDecimal.ZERO, BigDecimal::add);
	}
}
