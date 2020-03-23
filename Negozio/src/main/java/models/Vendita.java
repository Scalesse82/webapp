package models;

public class Vendita 
{
	
	private int idVendita;
	private int idProdotti;
	private int qtaVenduta;
	
	
	public Vendita(int idVendita, int idProdotti, int qtaVenduta) 
	{
		
		this.idVendita = idVendita;
		this.idProdotti = idProdotti;
		this.qtaVenduta = qtaVenduta;
	}


	public Vendita(int idProdotti, int qtaVenduta) 
	{
		this.idProdotti = idProdotti;
		this.qtaVenduta = qtaVenduta;
	}


	public int getIdVendita() {
		return idVendita;
	}


	public void setIdVendita(int idVendita) {
		this.idVendita = idVendita;
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
