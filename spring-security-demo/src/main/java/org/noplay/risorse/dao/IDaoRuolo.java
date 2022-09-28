package org.noplay.risorse.dao;

import java.util.List;

import org.noplay.risorse.model.Ruolo;

public interface IDaoRuolo {
	
	List<Ruolo> ruoli();
	
	Ruolo ruolo(int id);
	
	boolean aggiungi(String ruolo);
	
	boolean elimina(int id);
	
	boolean modifica(Ruolo ruolo);
}
