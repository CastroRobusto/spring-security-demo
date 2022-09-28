package org.noplay.risorse.controller;

import org.noplay.risorse.dao.IDaoAzienda;
import org.noplay.risorse.model.Azienda;
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
@RequestMapping("/aziende")
public class ControllerAziende {
	
	@Autowired
	private IDaoAzienda dao;
	
	@GetMapping
	public Response aziende() {
		return new Response("200", dao.aziende());
	}
	
	@GetMapping("/{stringID}")
	public Response azienda(@PathVariable String stringID) {
		try {
			int id = Integer.parseInt(stringID);
			
			Azienda a = dao.azienda(id);
			
			if (a == null) {
				return new Response("1501", "Azienda non trovata");
			}else {
				return new Response ("200", a);
			}
		} catch (Exception e) {
			return new Response("1500", "Controllare il path");
		}
	}
	
	@GetMapping("/dipendenti/{id}")
	public Response listaDipendenti(@PathVariable int id) {
		return new Response("200", dao.listaDipendenti(id));
	}
	
	@PostMapping
	public boolean aggiungi(@RequestBody Azienda azienda) {
		return dao.aggiungi(azienda);
	}
	
	@DeleteMapping("/{id}")
	public boolean cancella(@PathVariable int id) {
		return dao.elimina(id);
	}
	
	@PutMapping
	public boolean modifica(@RequestBody Azienda azienda) {
		return dao.modifica(azienda);
	}
	
}
