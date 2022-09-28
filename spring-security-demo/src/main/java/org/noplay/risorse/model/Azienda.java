package org.noplay.risorse.model;

import org.noplay.risorse.util.IMappablePro;

public class Azienda  implements IMappablePro{
	
	private int id;
	private String ragioneSociale;
	private String partitaIva;
	private String indirizzo;
	private String email;
	private String nTel;
	public Azienda(int id, String ragioneSociale, String partitaIva, String indirizzo, String email, String nTel) {
		super();
		this.id = id;
		this.ragioneSociale = ragioneSociale;
		this.partitaIva = partitaIva;
		this.indirizzo = indirizzo;
		this.email = email;
		this.nTel = nTel;
	}
	public Azienda() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRagioneSociale() {
		return ragioneSociale;
	}
	public void setRagioneSociale(String ragioneSociale) {
		this.ragioneSociale = ragioneSociale;
	}
	public String getPartitaIva() {
		return partitaIva;
	}
	public void setPartitaIva(String partitaIva) {
		this.partitaIva = partitaIva;
	}
	public String getIndirizzo() {
		return indirizzo;
	}
	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getnTel() {
		return nTel;
	}
	public void setnTel(String nTel) {
		this.nTel = nTel;
	}
}
