<%@page import="it.scalesse.ortofrutta.model.Prodotto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Prodotti</title>
</head>
<style>
table, th, td {
  border: 1px solid black;

</style>
<body>

<%Prodotto prodotto=(Prodotto) request.getAttribute("prodottoOld"); %>


<form action="modificaProdotto" method="post">

  <label for="idProdotto">Inserisci l'id del prodotto</label>
  <input type="number" id="idProdotto" name="idProdotto" value=<%=prodotto.getIdProdotto() %> disabled><br><br>
  <input type="number" id="idProdotto" name="idProdotto" value=<%=prodotto.getIdProdotto() %> hidden="true">
  
  <label for="nomeProdotto">Inserisci il nome del prodotto:</label>
  <input type="text" id="nomeProdotto" name="nomeProdotto" value=<%=prodotto.getNome() %> ><br><br>
  <label for="qta">Inserisci la quantita del prodotto</label>
  <input type="number" id="qta" name="qta" value=<%=prodotto.getQta()%> ><br><br>
  <label for="prezzo">Inserisci il prezzo del prodotto</label>
  <input type="number" id="prezzo" name="prezzo" value=<%=prodotto.getPrezzo()%> ><br><br>
  <label for="descrizione">Inserisci la descrizione del prodotto:</label>
  <input type="text" id="descrizione" name="descrizione" value=<%=prodotto.getDescrizione()%>><br><br>
  <input type="submit" value="modifica">
  

</form>

<form action="login.jsp">
  <input type="submit" value ="pagina iniziale"><br><br>
  
  </form>
  





</body>
</html>