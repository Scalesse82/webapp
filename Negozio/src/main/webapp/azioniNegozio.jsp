<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
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
<h1>SCEGLI L'AZIONE DA FARE</h1>

<form action="controllerAzione">
<input type="submit" name="azione" value = "Aggiungi prodotto"><br><br>
<input type="submit" name="azione" value = "rimuovi prodotto"><br><br>
<input type="submit" name="azione" value = "modifica prodotto"><br><br>
<input type="submit" name="azione" value = "vendita prodotto"><br><br>
<input type="submit" name="azione" value = "Stampa vendite">
</form>
<% } %>


</body>
</html>