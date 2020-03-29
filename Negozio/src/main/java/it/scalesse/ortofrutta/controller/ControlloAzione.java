package it.scalesse.ortofrutta.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.scalesse.ortofrutta.model.Prodotto;
import it.scalesse.ortofrutta.model.Vendita;
import it.scalesse.ortofrutta.repository.GestioneDataBase;

public class ControlloAzione extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("messaggio", "hai provato a fare un accesso diretto non consentito");
		req.getRequestDispatcher("home.jsp").forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int azione = Integer.parseInt(req.getParameter("azione"));
		try {
			GestioneDataBase gest = new GestioneDataBase();

			List<Prodotto> lista = gest.stampaProdotti();
			switch (azione) {
			case 0:
				gest.close();
				req.getRequestDispatcher("aggiungiprodotto.jsp").forward(req, resp);
				break;
			case 1:
				req.setAttribute("listaProdotti", lista);
				gest.close();
				req.getRequestDispatcher("rimuoviProdotto.jsp").forward(req, resp);
				break;
			case 2:
				req.setAttribute("listaProdotti", lista);
				gest.close();
				req.getRequestDispatcher("modProdotto.jsp").forward(req, resp);
				break;
			case 3:
				int id = Integer.parseInt(req.getParameter("idUtente"));
				req.setAttribute("listaProdotti", lista);
				req.setAttribute("idUtente", id);
				req.setAttribute("costo", gest.sommaScontrini(Integer.parseInt(req.getParameter("idUtente"))));
				gest.close();
				List<Vendita> carrello =new ArrayList<>();
				req.setAttribute("carrello", carrello);

				req.getRequestDispatcher("vendita.jsp").forward(req, resp);
				break;
			case 4:
				List<Vendita> listaVendite = gest.stampaVendite();
				req.setAttribute("listaVendite", listaVendite);
				gest.close();
				req.getRequestDispatcher("stmVendite.jsp").forward(req, resp);
				break;
			case 5:
				req.setAttribute("listaScontrini",
						gest.stampaScontrini(Integer.parseInt(req.getParameter("idUtente"))));
				req.setAttribute("idUtente", Integer.parseInt(req.getParameter("idUtente")));
				req.setAttribute("costo", gest.sommaScontrini(Integer.parseInt(req.getParameter("idUtente"))));
				gest.close();
				req.getRequestDispatcher("stmScontrini.jsp").forward(req, resp);
				break;
			case 6:
				gest.close();
				req.setAttribute("tipo", req.getParameter("tipo"));
				req.getRequestDispatcher("creaUtente.jsp").forward(req, resp);
				break;
			case 7:
				req.setAttribute("idUtente", Integer.parseInt(req.getParameter("idUtente")));
				req.setAttribute("costo", gest.sommaScontrini(Integer.parseInt(req.getParameter("idUtente"))));
				gest.close();
				req.getRequestDispatcher("azioniNegozio.jsp").forward(req, resp);
				break;
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}

}
