package azioni;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gestioneDB.GestioneDataBase;
import models.Prodotto;
import models.Vendita;


public class StampaVendite extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		
		try {
			List<Vendita> lista=GestioneDataBase.stampaVendite();
			
			req.setAttribute("listaVendite", lista);

			
			
			
			
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		
		req.getRequestDispatcher("stmVendite.jsp").forward(req, resp);
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
}
