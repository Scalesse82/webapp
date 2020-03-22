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
		try {
		
		int idProdotto=Integer.parseInt(req.getParameter("idProdotto"));
		int qtaVenduta=Integer.parseInt(req.getParameter("qtaVenduta"));

		
		GestioneDataBase.aggiungiVendita(new Vendita(idProdotto, qtaVenduta));
		
        req.setAttribute("risultato", "prodotto venduto");
		
		req.getRequestDispatcher("risultato.jsp").forward(req, resp);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		
	}
	
	
	
	
	
	
	

}
