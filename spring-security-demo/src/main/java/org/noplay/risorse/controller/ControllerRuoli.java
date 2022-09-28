package org.noplay.risorse.controller;

import org.noplay.risorse.dao.IDaoRuolo;
import org.noplay.risorse.model.Ruolo;
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
@RequestMapping("/ruoli")
public class ControllerRuoli {

	@Autowired
	private IDaoRuolo dao;

	@GetMapping
	public Response ruolo() {
		return new Response("200", dao.ruoli());
	}

	@GetMapping("/{stringID}")
	public Response ruolo(@PathVariable String stringID) {
		try {
			int id = Integer.parseInt(stringID);

			Ruolo r = dao.ruolo(id);

			if (r == null) {
				return new Response("1501", "Ruolo non trovato");
			}else {
				return new Response ("200", r);
			}
		} catch (Exception e) {
			return new Response("1500", "Controllare il path");
		}
	}

	@PostMapping
	public boolean aggiungi(@RequestBody String ruolo) {
		return dao.aggiungi(ruolo);
	}

	@DeleteMapping("/{id}")
	public boolean cancella(@PathVariable int id) {
		return dao.elimina(id);
	}

	@PutMapping
	public boolean modifica(@RequestBody Ruolo ruolo) {
		return dao.modifica(ruolo);
	}

}

