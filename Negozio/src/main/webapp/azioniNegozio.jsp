<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<head>
<meta charset="ISO-8859-1">
<title>Azioni Clienti</title>
</head>
<body>

<% String messaggio = (String) request.getAttribute("messaggio"); 
	if (messaggio != null ){
		%>
		<h1>ERRORE</h1>
		<%=messaggio%>
					
	<% }
	else{
		int idUtente= (int)request.getAttribute("idUtente");


%>
<h2>SCEGLI L'AZIONE DA FARE</h2>

<form action="controllerAzione" method="post">

<button type="submit" class="btn btn-primary" name="azione" value = "3" >acquista prodotti</button><br><br>
<button type="submit" class="btn btn-primary" name="azione" value = "5" >Stampa scontrini</button><br><br>
 hai speso in totale : <h3><%=(double)request.getAttribute("costo") %> euro</h3>
<input type="hidden" id="idUtente" name="idUtente" value=<%=idUtente%>>

</form>
<br>
<form action="home.jsp">
  <button type="submit" class="btn btn-primary" >Log Out</button>  
  </form>
<% } %>


</body>
</html>