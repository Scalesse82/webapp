package it.scalesse.ortofrutta.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.scalesse.ortofrutta.model.Prodotto;
import it.scalesse.ortofrutta.repository.GestioneDataBase;

public class AggiuntaProdotto extends HttpServlet
{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		req.setAttribute("messaggio", "hai provato a fare l'accesso all'aggiunta di un prodotto dalla get");
		req.getRequestDispatcher("azioniNegozio.jsp").forward(req, resp);
		
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
	
		try {
			GestioneDataBase gest=new GestioneDataBase();
			
			String nome=req.getParameter("nomeProdotto");
			int qta=Integer.parseInt(req.getParameter("qta"));
			int prezzo=Integer.parseInt(req.getParameter("prezzo"));
			String descrizione=req.getParameter("descrizione");
			
			gest.aggiungiProdotto(new Prodotto(nome, qta, prezzo, descrizione));
			
			req.setAttribute("risultato", "prodotto aggiunto");
			gest.close();
			
			req.getRequestDispatcher("risultato.jsp").forward(req, resp);
			
			} catch (ClassNotFoundException | SQLException  e) 
	        {
				e.printStackTrace();
			} 
	
	
	}
	
	
	
	
	
	
	
}
