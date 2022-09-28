package org.noplay.risorse.model;

import org.noplay.risorse.util.IMappablePro;

public class Ruolo implements IMappablePro{
	
	private int id;
	private String ruolo;
	
	public Ruolo(int id, String ruolo) {
		super();
		this.id = id;
		this.ruolo = ruolo;
	}

	public Ruolo() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRuolo() {
		return ruolo;
	}

	public void setRuolo(String ruolo) {
		this.ruolo = ruolo;
	}

	@Override
	public String toString() {
		return "{ id : " + id + ", ruolo : " + ruolo + " }";
	}
	
	
	

}
