package it.scalesse.ortofrutta.model;

import java.util.ArrayList;
import java.util.List;

public class Scontrino 
{
	
	private int idScontrino;
	private int idUtente;
	private double costo;
	private String data;
	private List<Prodotto> listaAcquisti;
	
	public Scontrino(int idScontrino, int idUtente, double costo, String data) 
	{
		this.idScontrino = idScontrino;
		this.idUtente = idUtente;
		this.costo = costo;
		this.data = data;
		this.listaAcquisti=new ArrayList<Prodotto>();
		
	}

	public int getIdScontrino() {
		return idScontrino;
	}

	public void setIdScontrino(int idScontrino) {
		this.idScontrino = idScontrino;
	}

	public int getIdUtente() {
		return idUtente;
	}

	public void setIdUtente(int idUtente) {
		this.idUtente = idUtente;
	}

	public double getCosto() {
		return costo;
	}

	public void setCosto(double costo) {
		this.costo = costo;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public List<Prodotto> getListaAcquisti() {
		return listaAcquisti;
	}

	public void setListaAcquisti(List<Prodotto> listaAcquisti) {
		this.listaAcquisti = listaAcquisti;
	}
	
	
	
	
	

}
