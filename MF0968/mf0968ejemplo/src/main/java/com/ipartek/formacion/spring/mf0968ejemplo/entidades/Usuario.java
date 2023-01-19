package com.ipartek.formacion.spring.mf0968ejemplo.entidades;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "usuarios")
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Size(min = 3, max = 100)
	private String nombre;
	
	@DateTimeFormat(iso = ISO.DATE)
	@Past
	private LocalDate fechaNacimiento;
	
	@NotNull
	@Min(0)
	@Builder.Default
	private Integer nivel = 0;
	
	@Column(columnDefinition = "CHAR(9)")
	@Pattern(regexp = "^[XYZ\\d]\\d{7}[A-Z]$", message = "debe tener el formato correcto")
	private String dni;
	
	@NotNull
	@NotBlank
	@Email
	@Size(min = 3, max = 100)
	@Column(unique = true)
	private String email;
	
	@NotNull
	@NotBlank
	@Column(columnDefinition = "CHAR(60)")
	private String password;
	
	@NotNull
	@ManyToOne
	private Rol rol;
}
