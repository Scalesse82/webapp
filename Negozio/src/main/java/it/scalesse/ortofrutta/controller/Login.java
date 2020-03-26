package it.scalesse.ortofrutta.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.scalesse.ortofrutta.model.Utente;
import it.scalesse.ortofrutta.repository.GestioneDataBase;

public class Login extends HttpServlet 
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
		
		int id=Integer.parseInt(req.getParameter("idUtente"));
		String pass=req.getParameter("Password");
		try {
			String tipo=GestioneDataBase.accessoUtente(new Utente(id, pass));

			if(tipo==null)
			{
				req.setAttribute("messaggio", "controllare id e pass ");
			    req.getRequestDispatcher("home.jsp").forward(req, resp);				
			}
			
			if(tipo.equals("cliente"))
			{
				req.setAttribute("idUtente",id);
				req.setAttribute("costo", GestioneDataBase.sommaScontrini(id));
				req.getRequestDispatcher("azioniNegozio.jsp").forward(req, resp);
			}
		    else if(tipo.equals("interno"))
		    {
			    req.getRequestDispatcher("azioniInterno.jsp").forward(req, resp);
		    	
		    }
		
		
		
		
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		
		
		
	}
	
	
	

}
