package it.scalesse.ortofrutta.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.scalesse.ortofrutta.model.Utente;
import it.scalesse.ortofrutta.repository.GestioneDataBase;

public class CreaUtente extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("messaggio", "hai provato a fare l'accesso all'aggiunta di un prodotto dalla get");
		req.getRequestDispatcher("home.jsp").forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		GestioneDataBase gest;
		try {
			gest = new GestioneDataBase();
			String nome = req.getParameter("nome");
			String pass = req.getParameter("pass");
			int eta = Integer.parseInt(req.getParameter("eta"));
			String tipo = req.getParameter("tipo");
			Utente utente = new Utente(nome, pass, tipo, eta);
			if (gest.controllaUtente(utente)) {
				if (req.getParameter("tipo").equals("cliente")) {
					req.setAttribute("messaggio", "utente già esistente");
					gest.close();
					req.getRequestDispatcher("home.jsp").forward(req, resp);
				} else {
					req.setAttribute("risultato", "utente già esistente");
					gest.close();
					req.getRequestDispatcher("risultato.jsp").forward(req, resp);
				}
			} else {
				gest.aggiungiUtente(utente);
				if (req.getParameter("tipo").equals("cliente")) {
					req.setAttribute("messaggio", "utente aggiunto");
					gest.close();
					req.getRequestDispatcher("home.jsp").forward(req, resp);
				} else {
					gest.close();
					req.setAttribute("risultato", "utente aggiunto");

					req.getRequestDispatcher("risultato.jsp").forward(req, resp);
				}
			}
		} catch (ClassNotFoundException | SQLException e) {
			req.setAttribute("messaggio", "utente Non aggiunto");
			req.getRequestDispatcher("home.jsp").forward(req, resp);
			e.printStackTrace();
		}
	}
}
