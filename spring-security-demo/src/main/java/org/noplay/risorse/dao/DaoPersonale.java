package org.noplay.risorse.dao;

import java.util.List;

import org.noplay.risorse.model.Personale;
import org.noplay.risorse.util.BasicDao;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

@Repository
public class DaoPersonale extends BasicDao implements IDaoPersonale{
	
	private static final String UPDATE_PERSONALE_BY_ID = "UPDATE personale SET nome = ?, cognome = ?, ddn = ?, stipendio = ?, dataassunzione = ?, idazienda = ?, idruolo = ? WHERE id = ?";
	private static final String DELETE_FROM_PERSONALE_BY_ID = "DELETE FROM personale WHERE id = ?";
	private static final String INSERT_INTO_PERSONALE = "INSERT INTO personale (nome, cognome, ddn, stipendio, dataassunzione, idazienda, idruolo) VALUES (?, ?, ?, ?, ?, ?, ?)";
	private static final String PERSONALE_BY_ID = "SELECT * FROM personale WHERE id = ?";
	private static final String PERSONALE_DISPONIBILE = "SELECT * FROM personale where idazienda is null";
	private static final String DIPENDENTI = "SELECT * FROM personale where idazienda is not null";

	public DaoPersonale(@Value("${spring.datasource.url}") String dbAddress, 
			@Value("${spring.datasource.username}") String user, 
			@Value("${spring.datasource.password}") String password) {
		super(dbAddress, user, password);
	}

	@Override
	public List<Personale> listaPersonale() {
		return listFromQuery(DIPENDENTI, Personale.class);
	}
	
	@Override
	public List<Personale> listaDisponibili() {
		return listFromQuery(PERSONALE_DISPONIBILE, Personale.class);
	}

	@Override
	public Personale persona(int id) {
		return objectFromQuery(PERSONALE_BY_ID, Personale.class, id);
	}

	@Override
	public boolean aggiungi(Personale persona) {
		Object idAzienda = persona.getIdAzienda();
		Object idRuolo = persona.getIdRuolo();
		if(persona.getIdAzienda() == 0) {
			idAzienda = null;
		}
		if(persona.getIdRuolo() == 0) {
			idRuolo = null;
		}
		
		return isExecute(INSERT_INTO_PERSONALE, persona.getNome(), 
												persona.getCognome(), 
												persona.getDdn(),
												persona.getStipendio(), 
												persona.getDataAssunzione(), 
												idAzienda, 
												idRuolo);
	}

	@Override
	public boolean elimina(int id) {
		return isExecute(DELETE_FROM_PERSONALE_BY_ID, id);
	}

	@Override
	public boolean modifica(Personale persona) {
		Object idAzienda = persona.getIdAzienda();
		Object idRuolo = persona.getIdRuolo();
		if(persona.getIdAzienda() == 0) {
			idAzienda = null;
		}
		if(persona.getIdRuolo() == 0) {
			idRuolo = null;
		}
		
		return isExecute(UPDATE_PERSONALE_BY_ID, persona.getNome(), 
												 persona.getCognome(), 
												 persona.getDdn(),
												 persona.getStipendio(), 
												 persona.getDataAssunzione(), 
												 idAzienda, 
												 idRuolo, 
												 persona.getId());
	}

	
	
	

}
