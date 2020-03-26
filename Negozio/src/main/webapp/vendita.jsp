<%@page import="it.scalesse.ortofrutta.model.Prodotto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

<head>
<meta charset="ISO-8859-1">
<title>Vendita Prodotti</title>
</head>
<style>
table, th, td {
  border: 1px solid black;

</style>
<body>


<% String messaggio = (String) request.getAttribute("messaggio"); 
	if (messaggio != null ){
		%>
		
		<%=messaggio%>
					
	<% }%>



<% List<Prodotto> lista=(List<Prodotto>) request.getAttribute("listaProdotti"); %>
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
  <button type="submit" class="btn btn-primary" name="azione" value = "1" >aggiungi</button>
  <button type="submit" class="btn btn-primary" name="azione" value = "2" >paga</button>
    <input type="hidden" id="idUtente" name="idUtente" value=<%=(int)request.getAttribute("idUtente")%>>
  

</form>

<form action="controllerAzione" method="post">
<button type="submit" class="btn btn-primary" name="azione" value = "7" >indietro</button>  
<input type="hidden" id="idUtente" name="idUtente" value=<%=(int)request.getAttribute("idUtente")%>>
<input type="hidden" id="costo" name="costo" value=<%=(double)request.getAttribute("costo")%>>

  
  </form>





</body>
</html>