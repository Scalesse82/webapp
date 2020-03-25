<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
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
		int idUtente= (int)request.getAttribute("idUtente");


%>
<h1>SCEGLI L'AZIONE DA FARE</h1>

<form action="controllerAzione" method="post">

<button type="submit" class="btn btn-primary" name="azione" value = "3" >acquista prodotti</button><br><br>
<button type="submit" class="btn btn-primary" name="azione" value = "5" >Stampa scontrini</button><br><br>
<h3>hai speso in totale : <%=(double)request.getAttribute("costo") %>euro</h3>
<input type="hidden" id="idUtente" name="idUtente" value=<%=idUtente%>>

</form>
<% } %>


</body>
</html>