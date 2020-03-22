package gestioneDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import models.Prodotto;
import models.Vendita;

public class GestioneDataBase 
{
	
	
	public static Connection connessioneDatabase() throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url = "jdbc:mysql://remotemysql.com:3306/xgouH99Q5G?useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=UTC&createDatabaseIfNotExist=true&allowPublicKeyRetrieval=true&useSSL=false";
		Connection connessione = DriverManager.getConnection(url, "xgouH99Q5G", "sKoY2hSBYL");
		return connessione;
	}
	
	
	
	public static boolean aggiungiProdotto(Prodotto p) throws ClassNotFoundException, SQLException
    {
		Connection connessione = connessioneDatabase();
		String query = "INSERT INTO prodotti (nome,qta,prezzo,descrizione) VALUES (?,?,?,?);";
		PreparedStatement statement = connessione.prepareStatement(query);
		statement.setString(1, p.getNome());
		statement.setInt(2, p.getQta());
		statement.setInt(3, p.getPrezzo());
		statement.setString(4, p.getDescrizione());
		statement.execute();
		connessione.close();

		return true;		
		
	}
	
	public static boolean rimuoviProdotto(int idProdotto) throws ClassNotFoundException, SQLException
    {
		Connection connessione = connessioneDatabase();
		String query = "delete from prodotti where idProdotto= ?;";
		PreparedStatement statement = connessione.prepareStatement(query);
		statement.setInt(1, idProdotto);
		statement.execute();
		connessione.close();

		return true;		
		
	}
	
	public static List<Prodotto> stampaProdotti() throws ClassNotFoundException, SQLException {
		List<Prodotto>lista=new ArrayList<>();
		Connection connessione = connessioneDatabase();
		String query = "select * from prodotti;";
		PreparedStatement statement = connessione.prepareStatement(query);
		ResultSet risultato = statement.executeQuery();
		while (risultato.next()) 
		{
		
			lista.add(new Prodotto(risultato.getInt(1), risultato.getString(2), risultato.getInt(3), risultato.getInt(4), risultato.getString(5)));
		}
		connessione.close();
		return lista;
	}
	
	public static boolean aggiornaProdotto(Prodotto p)throws SQLException, ClassNotFoundException 
	{

		Connection connessione = connessioneDatabase();

		String query = "update prodotti set nome=?,qta=?, prezzo=?, descrizione=? where idProdotto=?;";
		PreparedStatement statement = connessione.prepareStatement(query);
		statement.setString(1, p.getNome());
		statement.setInt(2, p.getQta());
		statement.setInt(3, p.getPrezzo());
		statement.setString(4, p.getDescrizione());
        statement.setInt(5, p.getIdProdotto());
        statement.execute();
		connessione.close();
		return true;
     }
	
	
	public static List<Vendita> stampaVendite() throws ClassNotFoundException, SQLException {
		List<Vendita> lista=new ArrayList<>();
		Connection connessione = connessioneDatabase();
		String query = "select * from vendite ;";
		PreparedStatement statement = connessione.prepareStatement(query);
		ResultSet risultato = statement.executeQuery();
		while (risultato.next()) 
		{
			
		lista.add(new Vendita(risultato.getInt(1), risultato.getInt(2), risultato.getInt(3)));
		
		}
		connessione.close();
		return lista;
	}
	
	public static boolean aggiungiVendita(Vendita v) throws ClassNotFoundException, SQLException
    {
		Connection connessione = connessioneDatabase();
		String query = "INSERT INTO vendite (idProdotto,qtaVenduta) VALUES (?,?);";
		PreparedStatement statement = connessione.prepareStatement(query);
		statement.setInt(1, v.getIdProdotti());
		statement.setInt(2, v.getQtaVenduta());
		
		statement.execute();
		connessione.close();

		return true;		
		
	}
	
	
	

}
