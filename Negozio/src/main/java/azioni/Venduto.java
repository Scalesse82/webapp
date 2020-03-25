package azioni;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gestioneDB.GestioneDataBase;
import models.Prodotto;
import models.Vendita;

public class Venduto extends HttpServlet
{  
	List<Vendita> carrello;

	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		req.setAttribute("messaggio", "hai provato a fare un accesso diretto non consentito");
		req.getRequestDispatcher("login.jsp").forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		if(carrello==null)
		{
			carrello=new ArrayList<>();
		}
		int idUtente=Integer.parseInt(req.getParameter("idUtente"));

		int azione = Integer.parseInt(req.getParameter("azione"));
		try {
			if(1==azione)
			{ 
			   
			   int idProdotto=Integer.parseInt(req.getParameter("idProdotto"));
			   int qtaVenduta=Integer.parseInt(req.getParameter("qtaVenduta"));
			   if(GestioneDataBase.controlloQta(new Vendita(idProdotto, qtaVenduta))>0)
			   {   
			   carrello.add(new Vendita(idProdotto, qtaVenduta));
			   req.setAttribute("messaggio", "aggiunto al carrello");
	           req.setAttribute("idUtente",idUtente);
			   req.setAttribute("listaProdotti", GestioneDataBase.stampaProdotti());


			   req.getRequestDispatcher("vendita.jsp").forward(req, resp);
			   }
				
			}
			else if(2==azione)
			{
			
			int idScontrino=GestioneDataBase.creaScontrino(idUtente);
            for (Vendita v : carrello) 
            {
            	GestioneDataBase.aggiungiVendita(new Vendita(idScontrino, v.getIdProdotti(), v.getQtaVenduta()));
            	
			}
            
            GestioneDataBase.impostaCostoScontrino(idScontrino, GestioneDataBase.importoScontrino(idScontrino));
            	
            req.setAttribute("idUtente",idUtente);

			req.getRequestDispatcher("azioniNegozio.jsp").forward(req, resp);
				
				
			}
			
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		}
	
	}
