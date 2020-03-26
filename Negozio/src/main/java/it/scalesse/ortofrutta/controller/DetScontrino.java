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

public class DetScontrino extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		
		try {
			
			int idUtente=Integer.parseInt(req.getParameter("idUtente"));

			int idScontrino=Integer.parseInt(req.getParameter("id"));
			List<Vendita> lista = GestioneDataBase.stampaDettagliScontrini(idScontrino);
			req.setAttribute("Lista", lista);
			req.setAttribute("idUtente",idUtente);  
			req.setAttribute("costo", GestioneDataBase.sommaScontrini(idUtente));
			req.getRequestDispatcher("stampaDettagliScontrino.jsp").forward(req, resp);
		
		
		
		
		
		
		} catch (NumberFormatException | ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
	}

}