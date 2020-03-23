package azioni;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gestioneDB.GestioneDataBase;
import models.Vendita;

public class Venduto extends HttpServlet
{ 
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		req.setAttribute("messaggio", "hai provato a fare una vendita di un prodotto dalla get");
		req.getRequestDispatcher("azioniNegozio.jsp").forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		try {
			
			int idProdotto=Integer.parseInt(req.getParameter("idProdotto"));
			int qtaVenduta=Integer.parseInt(req.getParameter("qtaVenduta"));

			
			if(GestioneDataBase.aggiungiVendita(new Vendita(idProdotto, qtaVenduta)))
			{ req.setAttribute("risultato", "prodotto venduto");
			  req.getRequestDispatcher("risultato.jsp").forward(req, resp);
			}
			else
			{
				req.setAttribute("risultato", "prodotto non venduto");
				req.getRequestDispatcher("risultato.jsp").forward(req, resp);
				
				
			}
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		
		
		
		
	}
	
	
	
	
	
	
	

}
