<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

<head>
<meta charset="ISO-8859-1">
<title>login</title>
 <style>
 
      .bd-placeholder-img {
        font-size: 1.125rem;
        text-anchor: middle;
        -webkit-user-select: none;
        -moz-user-select: none;
        -ms-user-select: none;
        user-select: none;
      }

      @media (min-width: 768px) {
        .bd-placeholder-img-lg {
          font-size: 3.5rem;
        }
      }
    </style>
</head>

<body class="text-center">

<% String messaggio = (String) request.getAttribute("messaggio"); 
	if (messaggio != null ){
		%>
		<h2>		<%=messaggio%>
       </h2>
					
	<% }%>

    <form class="form-signin" action="controlloAccesso" method="post">
  <img class="mb-4" src="EPSLogo-orti-trasp.jpg" alt="" width="72" height="72">
  <h1 class="h3 mb-3 font-weight-normal">Please sign in</h1>

  
  <label for="idUtente" class="sr-only" >Id Utente</label>
  <input type="number" style="width:150px; height:50px;margin: auto" id="idUtente" name="idUtente" class="form-control" placeholder="Id Utente" required autofocus>
  <label for="Password" class="sr-only">Password</label>
  <input type="Password" style="width:150px; height:50px;margin: auto" id="Password" name ="Password" class="form-control" placeholder="Password" required>  
  <button  class="btn btn-lg btn-primary btn-block"  style="width:150px; height: 50px;margin: auto" type="submit">Sign in</button>  
</form>
  <form action="controllerAzione" method="post">
  <input type="hidden" id="tipo" name="tipo" value="cliente">
  <br>
  <button  class="btn btn-lg btn-primary btn-block"  style="width:150px; height: 50px;margin: auto" name="azione" type="submit" value="6">Registrati</button>
   <p class="mt-5 mb-3 text-muted">&copy; 2017-2020</p>
  </form>
</body>
</html>