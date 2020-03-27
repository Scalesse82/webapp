<%@page import="it.scalesse.ortofrutta.model.Scontrino"%>
<%@page import="it.scalesse.ortofrutta.model.Vendita"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<style>
table, th, td {
  border: 1px solid black;

</style>
<body>
<%List<Vendita> lista=(List<Vendita>) request.getAttribute("lista"); %>
<%List<Scontrino> listaScontrini=(List<Scontrino>) request.getAttribute("listaScontrini"); %>

<table>
  <tr>
    <th>Id Scontrino</th>
    <th>Nome Prodotto</th>
    <th>Quantita Venduta</th>
    
  </tr>
  
  <% for(Vendita v : lista) { %>
  <tr>
    <td>
				<%=v.getIdScontrino()%>
	</td>  
	<td>
				<%=v.getNomeProdotto()%>
	</td>  
	<td>
				<%=v.getQtaVenduta()%>
	</td>  
	
	<% } %>
</table>


<br>
<form action="controllerAzione" method="post">
<input type="hidden" id="idUtente" name="idUtente" value=<%=(int)request.getAttribute("idUtente")%>>

<button type="submit" class="btn btn-primary" name="azione" value = "5" >torna indietro</button>
 </form>



</body>
</html>