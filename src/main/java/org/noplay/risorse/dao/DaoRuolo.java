package org.noplay.risorse.dao;

import java.util.List;

import org.noplay.risorse.model.Ruolo;
import org.noplay.risorse.util.BasicDao;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

@Repository
public class DaoRuolo extends BasicDao implements IDaoRuolo{
	
	private static final String UPDATE_RUOLI_BY_ID = "UPDATE ruoli SET ruolo = ? WHERE id = ?";
	private static final String DELETE_FROM_RUOLI_BY_ID = "DELETE FROM ruoli WHERE id = ?";
	private static final String INSERT_INTO_RUOLI = "INSERT INTO ruoli (ruolo) VALUES (?)";
	private static final String RUOLI_BY_ID = "SELECT * FROM ruoli WHERE id = ?";
	private static final String RUOLI = "SELECT * FROM ruoli";

	public DaoRuolo(@Value("${spring.datasource.url}") String dbAddress, 
				   @Value("${spring.datasource.username}") String user, 
				   @Value("${spring.datasource.password}") String password) {
		super(dbAddress, user, password);
	}

	@Override
	public List<Ruolo> ruoli() {
		return listFromQuery(RUOLI, Ruolo.class);
	}

	@Override
	public Ruolo ruolo(int id) {
		return objectFromQuery(RUOLI_BY_ID, Ruolo.class, id);
	}

	@Override
	public boolean aggiungi(String ruolo) {
		return isExecute(INSERT_INTO_RUOLI, ruolo.substring(1, ruolo.length()-1));
	}

	@Override
	public boolean elimina(int id) {
		return isExecute(DELETE_FROM_RUOLI_BY_ID, id);
	}

	@Override
	public boolean modifica(Ruolo ruolo) {
		return isExecute(UPDATE_RUOLI_BY_ID, ruolo.getRuolo(), 
											 ruolo.getId());
	}
}
