<%@page import="models.Vendita"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>VENDITE</title>
</head>
<style>
table, th, td {
  border: 1px solid black;
}
</style>
<body>

<%List<Vendita> lista=(List<Vendita>) request.getAttribute("listaVendite"); %>
<table>
  <tr>
    <th>Id Scontrino</th>
    <th>Id Prodotto</th>
    <th>Quantita Venduta</th>
    
  </tr>
  
  <% for(Vendita v : lista) { %>
  <tr>
    <td>
				<%=v.getIdScontrino()%>
	</td>  
	<td>
				<%=v.getIdProdotti()%>
	</td>  
	<td>
				<%=v.getQtaVenduta()%>
	</td>  
	
	<% } %>
</table>



<form action="login.jsp">
  <input type="submit" value ="pagina iniziale"><br><br>
  </form>

</body>
</html>