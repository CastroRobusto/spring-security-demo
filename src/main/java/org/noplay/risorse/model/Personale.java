package org.noplay.risorse.model;

import org.noplay.risorse.util.IMappablePro;

public class Personale implements IMappablePro{
	
	private int id;
	private String nome;
	private String cognome;
	private String ddn;
	private double stipendio;
	private String dataAssunzione;
	private int idAzienda;
	private int idRuolo;
	
	public Personale(int id, String nome, String cognome, String ddn, double stipendio, String dataAssunzione,
			int idAzienda, int idRuolo) {
		super();
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
		this.ddn = ddn;
		this.stipendio = stipendio;
		this.dataAssunzione = dataAssunzione;
		this.idAzienda = idAzienda;
		this.idRuolo = idRuolo;
	}
	public Personale() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public String getDdn() {
		return ddn;
	}
	public void setDdn(String ddn) {
		this.ddn = ddn;
	}
	public double getStipendio() {
		return stipendio;
	}
	public void setStipendio(double stipendio) {
		this.stipendio = stipendio;
	}
	public String getDataAssunzione() {
		return dataAssunzione;
	}
	public void setDataAssunzione(String dataAssunzione) {
		this.dataAssunzione = dataAssunzione;
	}
	public int getIdAzienda() {
		return idAzienda;
	}
	public void setIdAzienda(int idAzienda) {
		this.idAzienda = idAzienda;
	}
	public int getIdRuolo() {
		return idRuolo;
	}
	public void setIdRuolo(int idRuolo) {
		this.idRuolo = idRuolo;
	}
	@Override
	public String toString() {
		return "{ id : " + id + ", nome : " + nome + ", cognome : " + cognome + ", ddn : " + ddn + ", stipendio : "
				+ stipendio + ", dataAssunzione : " + dataAssunzione + ", idAzienda : " + idAzienda + ", idRuolo : "
				+ idRuolo + " }";
	}
}