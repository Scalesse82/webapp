package it.scalesse.ortofrutta.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.scalesse.ortofrutta.model.Vendita;
import it.scalesse.ortofrutta.repository.GestioneDataBase;

public class ControlloAzione extends HttpServlet
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
		

		int azione = Integer.parseInt(req.getParameter("azione"));
		try {
		if (0==azione) {
			req.getRequestDispatcher("aggiungiprodotto.jsp").forward(req, resp);
		}
		else if(1==azione)
		{
			
		    List<it.scalesse.ortofrutta.model.Prodotto>lista = GestioneDataBase.stampaProdotti();			
			req.setAttribute("listaProdotti", lista);
			req.getRequestDispatcher("rimuoviProdotto.jsp").forward(req, resp);

		}		
		else if (2==azione) 
		{
			List<it.scalesse.ortofrutta.model.Prodotto>lista = GestioneDataBase.stampaProdotti();
			req.setAttribute("listaProdotti", lista);
			req.getRequestDispatcher("modProdotto.jsp").forward(req, resp);
		
		} 
		else if (3==azione) 
		{
			int id = Integer.parseInt(req.getParameter("idUtente"));

			List<it.scalesse.ortofrutta.model.Prodotto>lista = GestioneDataBase.stampaProdotti();
			req.setAttribute("listaProdotti", lista);
			req.setAttribute("idUtente",id);
			req.setAttribute("costo", GestioneDataBase.sommaScontrini(Integer.parseInt(req.getParameter("idUtente"))));
            req.getRequestDispatcher("vendita.jsp").forward(req, resp);
			
		}
		else if(4==azione)
		{
             List<Vendita> lista=GestioneDataBase.stampaVendite();
			 req.setAttribute("listaVendite", lista);

			 req.getRequestDispatcher("stmVendite.jsp").forward(req, resp);

		}else if(5==azione)
		{
			
			req.setAttribute("listaScontrini", GestioneDataBase.stampaScontrini());
			req.setAttribute("idUtente",Integer.parseInt(req.getParameter("idUtente")));
			req.setAttribute("costo", GestioneDataBase.sommaScontrini(Integer.parseInt(req.getParameter("idUtente"))));

			req.getRequestDispatcher("stmScontrini.jsp").forward(req, resp);

            

		}
		else if(7==azione)
		{
			req.setAttribute("idUtente",Integer.parseInt(req.getParameter("idUtente")));
			req.setAttribute("costo", GestioneDataBase.sommaScontrini(Integer.parseInt(req.getParameter("idUtente"))));
           	req.getRequestDispatcher("azioniNegozio.jsp").forward(req, resp);

            

		}
		
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
	}
	
}
