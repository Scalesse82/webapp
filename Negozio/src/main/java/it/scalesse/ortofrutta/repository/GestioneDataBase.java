package it.scalesse.ortofrutta.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import it.scalesse.ortofrutta.model.Prodotto;
import it.scalesse.ortofrutta.model.Scontrino;
import it.scalesse.ortofrutta.model.Utente;
import it.scalesse.ortofrutta.model.Vendita;

public class GestioneDataBase {

	private Connection connessione;

	public GestioneDataBase() throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/negozio?useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=UTC&createDatabaseIfNotExist=true&allowPublicKeyRetrieval=true&useSSL=false";
		this.connessione = DriverManager.getConnection(url, "root", "Giuseppe");
	}

	public void close() throws SQLException {
		this.connessione.close();

	}

	public String accessoUtente(Utente u) throws ClassNotFoundException, SQLException {

		String query = "select * from utente where idUtente=? and pass=?;";
		PreparedStatement statement = connessione.prepareStatement(query);
		statement.setInt(1, u.getIdUtente());
		statement.setString(2, u.getPass());
		ResultSet risultato = statement.executeQuery();
		while (risultato.next()) {

			return risultato.getString(5);

		}

		return null;

	}

	public boolean controlloProdotto(Prodotto p) throws ClassNotFoundException, SQLException {

		String query = "select * from prodotti where nome=?;";
		PreparedStatement statement = connessione.prepareStatement(query);
		statement.setString(1, p.getNome());
		ResultSet risultato = statement.executeQuery();
		while (risultato.next()) {
			return true;

		}

		return false;

	}

	public boolean aggiungiProdotto(Prodotto p) throws ClassNotFoundException, SQLException {
		int qtaVecchia = 0;
		if (controlloProdotto(p)) {
			String query = "select * from prodotti where nome=?;";
			PreparedStatement statement = connessione.prepareStatement(query);
			statement.setString(1, p.getNome());
			ResultSet risultato = statement.executeQuery();
			while (risultato.next()) {
				qtaVecchia = risultato.getInt(3);

			}
			String query2 = "update prodotti set qta=? where nome=?;";
			statement = connessione.prepareStatement(query2);
			statement.setInt(1, p.getQta() + qtaVecchia);
			statement.setString(2, p.getNome());
			statement.execute();
			return true;

		} else {
			String query = "INSERT INTO prodotti (nome,qta,prezzo,descrizione) VALUES (?,?,?,?);";
			PreparedStatement statement = connessione.prepareStatement(query);
			statement.setString(1, p.getNome());
			statement.setInt(2, p.getQta());
			statement.setInt(3, p.getPrezzo());
			statement.setString(4, p.getDescrizione());
			statement.execute();

			return true;
		}

	}

	public boolean rimuoviProdotto(int idProdotto) throws ClassNotFoundException, SQLException {
		String query = "delete from prodotti where idProdotto= ?;";
		PreparedStatement statement = connessione.prepareStatement(query);
		statement.setInt(1, idProdotto);
		statement.execute();

		return true;

	}

	public List<Prodotto> stampaProdotti() throws ClassNotFoundException, SQLException {
		List<Prodotto> lista = new ArrayList<>();
		String query = "select * from prodotti;";
		PreparedStatement statement = connessione.prepareStatement(query);
		ResultSet risultato = statement.executeQuery();
		while (risultato.next()) {

			lista.add(new Prodotto(risultato.getInt(1), risultato.getString(2), risultato.getInt(3),
					risultato.getInt(4), risultato.getString(5)));
		}
		return lista;
	}

	public boolean aggiornaProdotto(Prodotto p) throws SQLException, ClassNotFoundException {

		String query = "update prodotti set nome=?,qta=?, prezzo=?, descrizione=? where idProdotto=?;";
		PreparedStatement statement = connessione.prepareStatement(query);
		statement.setString(1, p.getNome());
		statement.setInt(2, p.getQta());
		statement.setInt(3, p.getPrezzo());
		statement.setString(4, p.getDescrizione());
		statement.setInt(5, p.getIdProdotto());
		statement.execute();
		return true;
	}

	public List<Vendita> stampaVendite() throws ClassNotFoundException, SQLException {
		List<Vendita> lista = new ArrayList<>();
		String query = "SELECT vendite.*,prodotti.nome FROM vendite inner join prodotti on vendite.idProdotto=prodotti.idProdotto;";
		PreparedStatement statement = connessione.prepareStatement(query);
		ResultSet risultato = statement.executeQuery();
		while (risultato.next()) {

			lista.add(
					new Vendita(risultato.getInt(1), risultato.getInt(2), risultato.getInt(3), risultato.getString(4)));

		}
		return lista;
	}

	public boolean aggiungiVendita(Vendita v) throws ClassNotFoundException, SQLException {
		String query = "INSERT INTO vendite (idScontrino,idProdotto,qtaVenduta) VALUES (?,?,?);";
		PreparedStatement statement = connessione.prepareStatement(query);
		statement.setInt(1, v.getIdScontrino());
		statement.setInt(2, v.getIdProdotti());
		statement.setInt(3, v.getQtaVenduta());
		statement.execute();
		String query3 = "update prodotti set qta=? where idProdotto=?;";
		PreparedStatement statement3 = connessione.prepareStatement(query3);
		statement3.setInt(1, controlloQta(v) - v.getQtaVenduta());
		statement3.setInt(2, v.getIdProdotti());
		statement3.execute();
		return true;

	}

	public int controlloQta(Vendita v) throws ClassNotFoundException, SQLException {
		int qtaVecchia = 0;
		String query2 = "select * from prodotti where idProdotto=?;";
		PreparedStatement statement2 = connessione.prepareStatement(query2);
		statement2.setInt(1, v.getIdProdotti());
		ResultSet risultato = statement2.executeQuery();
		while (risultato.next()) {
			qtaVecchia = risultato.getInt(3);

		}
		if (qtaVecchia > v.getQtaVenduta()) {

			return qtaVecchia;
		}
		return -1;

	}

	public int creaScontrino(int idUtente) throws ClassNotFoundException, SQLException {
		String query = "INSERT INTO scontrino (idScontrino,utente,data) VALUES (?,?,?);";
		PreparedStatement statement = connessione.prepareStatement(query);
		int idScontrino = (int) (Math.random() * 100) + idUtente;
		statement.setInt(1, idScontrino);
		statement.setInt(2, idUtente);
		java.util.Date d = new java.util.Date();
		DateFormat formatoData = DateFormat.getDateInstance(DateFormat.SHORT, Locale.ITALY);
		String s = formatoData.format(d);
		statement.setString(3, s);
		statement.execute();
		return idScontrino;

	}

	public boolean impostaCostoScontrino(int idScontrino, double costo) throws ClassNotFoundException, SQLException {
		String query = "update scontrino set costo=? where idScontrino=?;";
		PreparedStatement statement = connessione.prepareStatement(query);
		statement.setDouble(1, costo);
		statement.setInt(2, idScontrino);
		statement.execute();
		return true;

	}

	public double importoScontrino(int idScontrino) throws ClassNotFoundException, SQLException {
		double costo = 0;
		String query = "select vendite.*,prodotti.prezzo from vendite inner join prodotti on vendite.idProdotto=prodotti.idProdotto where vendite.idScontrino=?;";
		PreparedStatement statement = connessione.prepareStatement(query);
		statement.setInt(1, idScontrino);

		ResultSet risultato = statement.executeQuery();
		while (risultato.next()) {

			costo = costo + risultato.getInt(3) * risultato.getDouble(4);

		}
		return costo;

	}

	public List<Scontrino> stampaScontrini(int idUtente) throws ClassNotFoundException, SQLException {
		List<Scontrino> lista = new ArrayList<>();
		String query = "select * from scontrino where utente=? ;";
		PreparedStatement statement = connessione.prepareStatement(query);
		statement.setInt(1, idUtente);
		ResultSet risultato = statement.executeQuery();
		while (risultato.next()) {

			lista.add(new Scontrino(risultato.getInt(1), risultato.getInt(2), risultato.getDouble(4),
					risultato.getString(3)));

		}
		return lista;
	}

	public double sommaScontrini(int idUtente) throws ClassNotFoundException, SQLException {
		String query = "select sum(costo) from scontrino where utente=? ;";
		PreparedStatement statement = connessione.prepareStatement(query);
		statement.setInt(1, idUtente);
		ResultSet risultato = statement.executeQuery();
		while (risultato.next()) {

			return risultato.getDouble(1);

		}
		return 0;

	}

	public Prodotto getProdottoById(int idProdotto) throws ClassNotFoundException, SQLException {
		String query = "select * from prodotti where idProdotto = ? limit 1;";
		PreparedStatement statement = connessione.prepareStatement(query);
		statement.setInt(1, idProdotto);
		ResultSet risultato = statement.executeQuery();
		while (risultato.next()) {

			return new Prodotto(risultato.getInt(1), risultato.getString(2), risultato.getInt(3), risultato.getInt(4),
					risultato.getString(5));
		}

		return null;
	}

	public List<Vendita> stampaDettagliScontrini(int idScontrino) throws ClassNotFoundException, SQLException {
		List<Vendita> lista = new ArrayList<>();
		String query = "SELECT vendite.*,prodotti.nome FROM vendite inner join prodotti on vendite.idProdotto=prodotti.idProdotto where idScontrino=?;";
		PreparedStatement statement = connessione.prepareStatement(query);
		statement.setInt(1, idScontrino);
		ResultSet risultato = statement.executeQuery();
		while (risultato.next()) {

			lista.add(
					new Vendita(risultato.getInt(1), risultato.getInt(2), risultato.getInt(3), risultato.getString(4)));

		}
		return lista;
	}

	public boolean aggiungiUtente(Utente utente) throws ClassNotFoundException, SQLException {
		String query = "insert into utente (nome, pass, eta, tipo) values (?,?,?,?);";
		PreparedStatement statement = connessione.prepareStatement(query);
		statement.setString(1, utente.getNome());
		statement.setString(2, utente.getPass());
		statement.setInt(3, utente.getEta());
		statement.setString(4, utente.getTipo());
		statement.execute();
		return true;
	}

	public boolean controllaUtente(Utente utente) throws ClassNotFoundException, SQLException {
		String query = "select * from utente where nome=?;";
		PreparedStatement statement = connessione.prepareStatement(query);
		statement.setString(1, utente.getNome());
		ResultSet risultato = statement.executeQuery();
		while (risultato.next()) {
			return true;
		}
		return false;
	}
}
