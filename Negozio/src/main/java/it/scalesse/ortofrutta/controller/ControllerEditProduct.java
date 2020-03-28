package it.scalesse.ortofrutta.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.scalesse.ortofrutta.model.Prodotto;
import it.scalesse.ortofrutta.repository.GestioneDataBase;

public class ControllerEditProduct extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int idProdotto = Integer.parseInt(req.getParameter("id"));
		try {
			GestioneDataBase gest=new GestioneDataBase();
			Prodotto p = gest.getProdottoById(idProdotto);
			req.setAttribute("prodottoOld", p);
			gest.close();
			req.getRequestDispatcher("modificaSingoloProdotto.jsp").forward(req, resp);
			
			
		} catch (SQLException |ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		
	}
}
