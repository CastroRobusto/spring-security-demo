package org.noplay.risorse.dao;

import java.util.List;

import org.noplay.risorse.model.Personale;

public interface IDaoPersonale {
	
	List<Personale> listaPersonale();
	
	List<Personale> listaDisponibili();
	
	Personale persona(int id);
	
	boolean aggiungi(Personale persona);
	
	boolean elimina(int id);
	
	boolean modifica(Personale persona);
}
