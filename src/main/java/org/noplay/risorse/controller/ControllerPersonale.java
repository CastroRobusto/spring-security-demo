package org.noplay.risorse.controller;

import org.noplay.risorse.dao.IDaoPersonale;
import org.noplay.risorse.model.Personale;
import org.noplay.risorse.model.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/personale")
public class ControllerPersonale {

	@Autowired
	private IDaoPersonale dao;

	@GetMapping
	public Response personale() {
		return new Response("200", dao.listaPersonale());
	}
	

	@GetMapping("/{stringID}")
	public Response persona(@PathVariable String stringID) {
		try {
			int id = Integer.parseInt(stringID);

			Personale p = dao.persona(id);

			if (p == null) {
				return new Response("1501", "Persona non trovata");
			}else {
				return new Response ("200", p);
			}
		} catch (Exception e) {
			return new Response("1500", "Controllare il path");
		}
	}
	
	@GetMapping("/disponibili")
	public Response personaleDisponibile() {
		return new Response("200", dao.listaDisponibili());
	}

	@PostMapping
	public boolean aggiungi(@RequestBody Personale persona) {
		return dao.aggiungi(persona);
	}

	@DeleteMapping("/{id}")
	public boolean cancella(@PathVariable int id) {
		return dao.elimina(id);
	}

	@PutMapping
	public boolean modifica(@RequestBody Personale persona) {
		return dao.modifica(persona);
	}

}

