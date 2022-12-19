package com.ipartek.formacion.spring.springrest.rest;

import java.time.LocalDate;
import java.util.TreeMap;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.ipartek.formacion.spring.springrest.pojo.Persona;

@RestController
@RequestMapping("/api/personas")
public class PersonaRest {
	private TreeMap<Long, Persona> personas = new TreeMap<>();

	public PersonaRest() {
		personas.put(1L, new Persona(1L, "Javier", LocalDate.now()));
		personas.put(2L, new Persona(2L, "Pepe", LocalDate.now()));
	}

	@GetMapping
	public Iterable<Persona> obtenerPersonas() {
		return personas.values();
	}

	@GetMapping("/{id}")
	public Persona obtenerPorId(@PathVariable Long id) {
		Persona persona = personas.get(id);
		
		if(persona == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		return persona;
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Persona insertar(@RequestBody Persona persona) {
		Long id = personas.lastKey() + 1;
		persona.setId(id);
		personas.put(id, persona);
		
		return persona;
	}

	@PutMapping("/{id}")
	public Persona modificar(@PathVariable Long id, @RequestBody Persona persona) {
		personas.put(persona.getId(), persona);
		
		return persona;
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void borrar(@PathVariable Long id) {
		personas.remove(id);
	}
}
