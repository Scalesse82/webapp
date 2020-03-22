package azioni;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gestioneDB.GestioneDataBase;
import models.Prodotto;

public class AggiuntaProdotto extends HttpServlet
{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		try {
		
		String nome=req.getParameter("nomeProdotto");
		int qta=Integer.parseInt(req.getParameter("qta"));
		int prezzo=Integer.parseInt(req.getParameter("prezzo"));
		String descrizione=req.getParameter("descrizione");
		
		GestioneDataBase.aggiungiProdotto(new Prodotto(nome, qta, prezzo, descrizione));
		
		req.setAttribute("risultato", "prodotto aggiunto");
		
		req.getRequestDispatcher("risultato.jsp").forward(req, resp);
		
		} catch (ClassNotFoundException | SQLException  e) 
        {
			e.printStackTrace();
		} 
		
		
	}
	
	
	
	
	
	
	
}
