<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

<head>
<meta charset="ISO-8859-1">
<title></title>
</head>
<body class="text-center">

<%String risultato= (String)request.getAttribute("risultato"); %>

<main role="main" class="inner cover">
    <h1 class="cover-heading">Risultato</h1>
    <p class="lead"><%=risultato%></p>
    <p class="lead">
      <form action="azioniInterno.jsp">
       <button type="submit" class="btn btn-primary" >Pagina Iniziale</button>
       </form>
    </p>
  </main>




</body>
</html>