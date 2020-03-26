<%@page import="it.scalesse.ortofrutta.model.Scontrino"%>
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
}
</style>
<body>

<%List<Scontrino> lista=(List<Scontrino>) request.getAttribute("listaScontrini"); %>
<table>
  <tr>
    <th>Id Scontrino</th>
    <th>Id Utente</th>
    <th>Data</th>
    <th>Totale Scontrino</th>
    
  </tr>
  
  <% for(Scontrino v : lista) { %>
  <tr>
    <td>
				<%=v.getIdScontrino()%>
	</td>  
	<td>
				<%=v.getIdUtente()%>
	</td>  
	<td>
				<%=v.getData()%>
	</td> 
	<td>
				<%=v.getCosto()%>
	</td>  
	
	<% } %>
</table>




<form action="controllerAzione" method="post">
<button type="submit" class="btn btn-primary" name="azione" value = "7" >indietro</button>  
<input type="hidden" id="idUtente" name="idUtente" value=<%=(int)request.getAttribute("idUtente")%>>
<input type="hidden" id="idUtente" name="idUtente" value=<%=(double)request.getAttribute("costo")%>>

  
  </form>


</body>
</html>