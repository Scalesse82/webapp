package it.scalesse.ortofrutta.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.scalesse.ortofrutta.model.Prodotto;
import it.scalesse.ortofrutta.model.Vendita;
import it.scalesse.ortofrutta.repository.GestioneDataBase;

public class Venduto extends HttpServlet
{  
	

	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		req.setAttribute("messaggio", "hai provato a fare un accesso diretto non consentito");
		req.getRequestDispatcher("login.jsp").forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		List<Vendita> carrello = ((List<Vendita>)req.getAttribute("carrello"));
		
		int idUtente=Integer.parseInt(req.getParameter("idUtente"));

		int azione = Integer.parseInt(req.getParameter("azione"));
		try {
			GestioneDataBase gest = new GestioneDataBase();

			if(1==azione)
			{ 

			   int idProdotto=Integer.parseInt(req.getParameter("idProdotto"));
			   int qtaVenduta=Integer.parseInt(req.getParameter("qtaVenduta"));
			   if(gest.controlloQta(new Vendita(idProdotto, qtaVenduta))>0)
			   {   
			   carrello.add(new Vendita(idProdotto, qtaVenduta));
			   req.setAttribute("messaggio", "aggiunto al carrello");
	           req.setAttribute("idUtente",idUtente);
			   req.setAttribute("listaProdotti", aggiornaLista(gest.stampaProdotti(),carrello));
			   req.setAttribute("costo", gest.sommaScontrini(idUtente));
			   req.setAttribute("carrello", carrello);
			   gest.close();
			   req.getRequestDispatcher("vendita.jsp").forward(req, resp);
			   }
			   else
			   {
				   req.setAttribute("messaggio", "quantità insufficente");
				   req.setAttribute("idUtente",idUtente);
				   req.setAttribute("listaProdotti", aggiornaLista(gest.stampaProdotti(),carrello));
				   req.setAttribute("costo", gest.sommaScontrini(idUtente));
				   req.setAttribute("carrello", carrello);
				   gest.close();
				   req.getRequestDispatcher("vendita.jsp").forward(req, resp);

				   
			   }
				
			}
			else if(2==azione)
			{
				 if(req.getParameter("idProdotto")!=null)
				   {  int idProdotto=Integer.parseInt(req.getParameter("idProdotto"));
				   int qtaVenduta=Integer.parseInt(req.getParameter("qtaVenduta"));
				   if(gest.controlloQta(new Vendita(idProdotto, qtaVenduta))>0)
				     
				   carrello.add(new Vendita(idProdotto, qtaVenduta));
				   }
			
			int idScontrino=gest.creaScontrino(idUtente);
            for (Vendita v : carrello) 
            {
            	gest.aggiungiVendita(new Vendita(idScontrino, v.getIdProdotti(), v.getQtaVenduta()));
            	
			}
            
            gest.impostaCostoScontrino(idScontrino, gest.importoScontrino(idScontrino));
            carrello.clear();	
            req.setAttribute("idUtente",idUtente);
			req.setAttribute("costo", gest.sommaScontrini(idUtente));
			gest.close();
			req.getRequestDispatcher("azioniNegozio.jsp").forward(req, resp);
				
				
			}
			
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		}
	
	 public List<Prodotto> aggiornaLista(List<Prodotto> lista,List<Vendita> carrello)
	 { 
		 for (Vendita v : carrello) 
		 {
			 for (int i=0;i<lista.size();i++) 
			 {
				if(v.getIdProdotti()==lista.get(i).getIdProdotto())
				{
			         lista.get(i).setQta(lista.get(i).getQta()-v.getQtaVenduta());
					
				}
			 }
			
		 }
		 return lista;		 
		 
	 }
	
	
	}
