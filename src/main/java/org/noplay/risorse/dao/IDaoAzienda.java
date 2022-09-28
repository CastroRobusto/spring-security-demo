package org.noplay.risorse.dao;

import java.util.List;

import org.noplay.risorse.model.Azienda;
import org.noplay.risorse.model.Personale;

public interface IDaoAzienda {
	
	List<Azienda> aziende();
	
	Azienda azienda(int id);
	
	List<Personale> listaDipendenti(int idAzienda);
	
	boolean aggiungi(Azienda azienda);
	
	boolean elimina(int id);
	
	boolean modifica(Azienda azienda);
}
