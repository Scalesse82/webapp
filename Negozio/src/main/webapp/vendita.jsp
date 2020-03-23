<%@page import="models.Prodotto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Vendita Prodotti</title>
</head>
<style>
table, th, td {
  border: 1px solid black;

</style>
<body>
<%List<Prodotto> lista=(List<Prodotto>) request.getAttribute("listaProdotti"); %>
<table>
  <tr>
    <th>Id Prodotto</th>
    <th>Nome</th>
    <th>Quantita</th>
    <th>Prezzo</th>
    <th>Descrizione</th>
  </tr>
  
  <% for(Prodotto p : lista) { %>
  <tr>
    <td>
				<%=p.getIdProdotto()%>
	</td>  
	<td>
				<%=p.getNome()%>
	</td>  
	<td>
				<%=p.getQta()%>
	</td>  
	<td>
				<%=p.getPrezzo()%>
	</td>  
	<td>
				<%=p.getDescrizione()%>
	</td>  
  </tr>
	<% } %>
</table>



<form action="vendiProdotto" method="post">
  
  <label for="idProdotto">Inserisci l'id del prodotto</label>
  <input type="number" id="idProdotto" name="idProdotto"><br><br>
  <label for="qtaVenduta">inserisci la quantita da vendere</label>
  <input type="number" id="qtaVenduta" name="qtaVenduta"><br><br>
  <input type="submit" value="vendi">

</form>

<form action="azioniNegozio.jsp">
  <input type="submit" value ="pagina iniziale"><br><br>
  </form>





</body>
</html>