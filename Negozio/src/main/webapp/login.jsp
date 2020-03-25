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


%>



<form action="controlloAccesso" method="post">
  <div class="form-group">
    <label for="idUtente">Id Utente</label>
    <input type="number" class="form-control" name="idUtente" id="idUtente" >
    <small id="idUtente" class="form-text text-muted">inserire l'id identificativo.</small>
  </div>
  <div class="form-group">
    <label for="Password">Password</label>
    <input type="password" class="form-control" name ="Password" id="Password">
  </div>
  <div class="form-group form-check">
    <input type="checkbox" class="form-check-input" id="exampleCheck1">
    <label class="form-check-label" for="exampleCheck1">Check me out</label>
  </div>
  <button type="submit" class="btn btn-primary">LogIn</button><br><br>
</form>

<form action="controllerAzione" method="post">
<button type="submit" class="btn btn-primary" name="azione" value = "0" >Aggiungi prodotto</button>
<button type="submit" class="btn btn-primary" name="azione" value = "1" >rimuovi prodotto</button>
<button type="submit" class="btn btn-primary" name="azione" value = "2" >modifica prodotto</button>
<button type="submit" class="btn btn-primary" name="azione" value = "4" >Stampa vendite</button>
</form>


<% } %>

</body>
</html>