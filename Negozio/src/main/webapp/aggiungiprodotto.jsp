<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="aggProdotto" method="post">
  <label for="nomeProdotto">Inserisci il nome del prodotto:</label>
  <input type="text" id="nomeProdotto" name="nomeProdotto"><br><br>
  <label for="qta">Inserisci la quantita del prodotto</label>
  <input type="number" id="qta" name="qta"><br><br>
  <label for="prezzo">Inserisci il prezzo del prodotto</label>
  <input type="number" id="prezzo" name="prezzo"><br><br>
  <label for="descrizione">Inserisci la descrizione del prodotto:</label>
  <input type="text" id="descrizione" name="descrizione"><br><br>
  <input type="submit" value="aggiungi">

</form>

<form action="azioniNegozio.jsp">
  <input type="submit" value ="pagina iniziale"><br><br>
  </form>
  





</body>
</html>