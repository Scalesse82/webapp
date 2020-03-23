package azioni;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gestioneDB.GestioneDataBase;
import models.Vendita;

public class ControlloAzione extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String azione = req.getParameter("azione");
		try {
		if ("Aggiungi prodotto".equalsIgnoreCase(azione)) {
			req.getRequestDispatcher("aggiungiprodotto.jsp").forward(req, resp);
		}
		else if("rimuovi prodotto".equalsIgnoreCase(azione))
		{
			
		    List<models.Prodotto>lista = GestioneDataBase.stampaProdotti();			
			req.setAttribute("listaProdotti", lista);
			req.getRequestDispatcher("rimuoviProdotto.jsp").forward(req, resp);

		}		
		else if ("modifica prodotto".equalsIgnoreCase(azione)) 
		{
			List<models.Prodotto>lista = GestioneDataBase.stampaProdotti();
			req.setAttribute("listaProdotti", lista);
			req.getRequestDispatcher("modProdotto.jsp").forward(req, resp);
		
		} 
		else if ("vendita prodotto".equalsIgnoreCase(azione)) 
		{
			List<models.Prodotto>lista = GestioneDataBase.stampaProdotti();
			req.setAttribute("listaProdotti", lista);
			req.getRequestDispatcher("vendita.jsp").forward(req, resp);
			
		}
		else if("Stampa vendite".equalsIgnoreCase(azione))
		{
             List<Vendita> lista=GestioneDataBase.stampaVendite();
			 req.setAttribute("listaVendite", lista);
			 req.getRequestDispatcher("stmVendite.jsp").forward(req, resp);

		}
		
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}
	
}
