<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

<head>
<meta charset="ISO-8859-1">
<title>Azioni Dipendenti</title>
</head>
<body>
<% String messaggio = (String) request.getAttribute("messaggio"); 
	if (messaggio != null ){
		%>
		<h1>ERRORE</h1>
		<%=messaggio%>
					
	<% }
	else{


%>
<h2>Azioni Dipendenti </h2>
<form action="controllerAzione" method="post">
<button type="submit" class="btn btn-primary" name="azione" value = "0" >Aggiungi prodotto</button><br><br>
<button type="submit" class="btn btn-primary" name="azione" value = "1" >rimuovi prodotto</button><br><br>
<button type="submit" class="btn btn-primary" name="azione" value = "2" >modifica prodotto</button><br><br>
<button type="submit" class="btn btn-primary" name="azione" value = "4" >Stampa vendite</button><br><br>
<input type="hidden" id="tipo" name="tipo" value="interno">
<button type="submit" class="btn btn-primary" name="azione" value = "6" >Aggiungi utente</button>
</form>

<br>
<form action="home.jsp">
  <button type="submit" class="btn btn-primary" >Log Out</button>  
  </form>

<% } %>

</body>
</html>