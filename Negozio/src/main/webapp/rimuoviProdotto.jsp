<%@page import="it.scalesse.ortofrutta.model.Prodotto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

<head>
<meta charset="ISO-8859-1">
<title>Rimozione prodotto</title>
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
	<td>
	<form action="rimProdotto" method="post">
	<input type="number" hidden="true" name="idProdotto" value=<%=p.getIdProdotto() %>>
       <button type="submit" class="btn btn-danger" >Rimuovi</button>
	</form>
	</td>
  </tr>
	<% } %>
</table>



 <form action="azioniInterno.jsp">
 <button type="submit" class="btn btn-primary" >Pagina Iniziale</button>
 </form>
  

</body>
</html>