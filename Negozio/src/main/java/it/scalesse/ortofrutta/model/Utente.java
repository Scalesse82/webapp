package it.scalesse.ortofrutta.model;

public class Utente {
	private int idUtente;
	private String nome;
	private String pass;
	private String tipo;
	private int eta;

	public Utente(int idUtente, String nome, String pass, String tipo, int eta) {
		this.idUtente = idUtente;
		this.nome = nome;
		this.pass = pass;
		this.tipo = tipo;
		this.eta = eta;
	}

	public Utente(int idUtente, String pass) {
		this.idUtente = idUtente;
		this.pass = pass;
	}

	public Utente(String nome, String pass, String tipo, int eta) {
		this.nome = nome;
		this.pass = pass;
		this.tipo = tipo;
		this.eta = eta;
	}

	public int getIdUtente() {
		return idUtente;
	}

	public void setIdUtente(int idUtente) {
		this.idUtente = idUtente;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getEta() {
		return eta;
	}

	public void setEta(int eta) {
		this.eta = eta;
	}

}
