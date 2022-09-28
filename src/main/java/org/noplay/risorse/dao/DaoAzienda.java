package org.noplay.risorse.dao;

import java.util.List;

import org.noplay.risorse.model.Azienda;
import org.noplay.risorse.model.Personale;
import org.noplay.risorse.util.BasicDao;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

@Repository
public class DaoAzienda extends BasicDao implements IDaoAzienda{
	
	private static final String PERSONALE_BY_IDAZIENDA = "SELECT * FROM personale where idazienda = ?";
	private static final String UPDATE_AZIENDE_BY_ID = "UPDATE aziende SET ragionesociale= ?, partitaiva = ?, indirizzo = ?, email = ?, ntel = ? WHERE id = ?";
	private static final String DELETE_FROM_AZIENDE_BY_ID = "DELETE FROM aziende WHERE id = ?";
	private static final String UPDATE_PERSONALE_IDRUOLO_NULL = "UPDATE personale SET idruolo=null where idazienda = ?";
	private static final String INSERT_INTO_AZIENDE = "INSERT INTO aziende (ragionesociale, partitaiva, indirizzo, email, ntel) VALUES (?, ?, ?, ?, ?)";
	private static final String AZIENDE_BY_ID = "SELECT * FROM aziende WHERE id = ?";
	private static final String AZIENDE = "SELECT * FROM aziende";

	public DaoAzienda(@Value("${spring.datasource.url}") String dbAddress, 
			   @Value("${spring.datasource.username}") String user, 
			   @Value("${spring.datasource.password}") String password) {
		super(dbAddress, user, password);
	}
	
	@Override
	public List<Azienda> aziende() {
		return listFromQuery(AZIENDE, Azienda.class);
	}

	@Override
	public Azienda azienda(int id) {
		return objectFromQuery(AZIENDE_BY_ID, Azienda.class, id);
	}

	@Override
	public boolean aggiungi(Azienda azienda) {
		return isExecute(INSERT_INTO_AZIENDE, azienda.getRagioneSociale(), 
											  azienda.getPartitaIva(),
											  azienda.getIndirizzo(), 
											  azienda.getEmail(), 
											  azienda.getnTel());
	}

	@Override
	public boolean elimina(int id) {
		execute(UPDATE_PERSONALE_IDRUOLO_NULL, id);
		return isExecute(DELETE_FROM_AZIENDE_BY_ID, id);
	}

	@Override
	public boolean modifica(Azienda azienda) {
		return isExecute(UPDATE_AZIENDE_BY_ID, azienda.getRagioneSociale(), 
											   azienda.getPartitaIva(),
											   azienda.getIndirizzo(), 
											   azienda.getEmail(), 
											   azienda.getnTel(), 
											   azienda.getId());
	}
	
	@Override
	public List<Personale> listaDipendenti(int idAzienda) {
		return listFromQuery(PERSONALE_BY_IDAZIENDA, Personale.class, idAzienda);
	}
	

}
