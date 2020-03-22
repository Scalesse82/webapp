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

public class StampaProdotti extends HttpServlet
{


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		
			List<Prodotto> lista;
			try {
				lista = GestioneDataBase.stampaProdotti();
				req.setAttribute("listaProdotti", lista);

			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
			

			
			
			
			
			
		
		
		req.getRequestDispatcher("modProdotto.jsp").forward(req, resp);

		
	}
	
	
	
	
}
