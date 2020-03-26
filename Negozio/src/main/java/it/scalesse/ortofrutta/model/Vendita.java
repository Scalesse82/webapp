package it.scalesse.ortofrutta.model;

public class Vendita 
{
	
	private int idScontrino;
	private int idProdotti;
	private int qtaVenduta;
	private String nomeProdotto;
	
	
	public Vendita(int idScontrino, int idProdotti, int qtaVenduta, String nomeProdotto)
	{
		this.idScontrino = idScontrino;
		this.idProdotti = idProdotti;
		this.qtaVenduta = qtaVenduta;
		this.nomeProdotto = nomeProdotto;
	}


	public Vendita(int idScontrino, int idProdotti, int qtaVenduta) 
	{
		
		this.idScontrino = idScontrino;
		this.idProdotti = idProdotti;
		this.qtaVenduta = qtaVenduta;
	}


	public Vendita(int idProdotti, int qtaVenduta) 
	{
		this.idProdotti = idProdotti;
		this.qtaVenduta = qtaVenduta;
	}




	public String getNomeProdotto() {
		return nomeProdotto;
	}


	public void setNomeProdotto(String nomeProdotto) {
		this.nomeProdotto = nomeProdotto;
	}


	public int getIdScontrino() {
		return idScontrino;
	}


	public void setIdScontrino(int idScontrino) {
		this.idScontrino = idScontrino;
	}


	public int getIdProdotti() {
		return idProdotti;
	}


	public void setIdProdotti(int idProdotti) {
		this.idProdotti = idProdotti;
	}


	public int getQtaVenduta() {
		return qtaVenduta;
	}


	public void setQtaVenduta(int qtaVenduta) {
		this.qtaVenduta = qtaVenduta;
	}
	
	
	
	
	

}
