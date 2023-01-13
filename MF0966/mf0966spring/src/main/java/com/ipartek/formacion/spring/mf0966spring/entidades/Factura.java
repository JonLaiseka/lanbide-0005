package com.ipartek.formacion.spring.mf0966spring.entidades;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "facturas")
public class Factura extends Pedido {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String codigo;
	private LocalDate fecha;

	@ManyToOne
	@JoinColumn(name = "clientes_id")
	private Cliente cliente;
	
	@ManyToOne
	@JoinColumn(name = "empleados_id")
	private Empleado empleado;

	public Factura(Pedido pedido) {
		this.lineas = pedido.lineas;
		
		this.lineas.values().forEach(linea -> {
			linea.setFactura(this);
		});
	}
}
