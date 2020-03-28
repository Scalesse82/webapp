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

<form action="CreaUtente" method="post">
  <label for="nome">Inserisci l'user dell'utente:</label>
  <input type="text" id="nome" name="nome"><br><br>
  <label for="pass">Inserisci la password</label>
  <input type="text" id="pass" name="pass"><br><br>
  <label for="eta">Inserisci l'età</label>
  <input type="number" id="eta" name="eta"><br><br>
  <input type="hidden" id="tipo" name="tipo" value=<%=request.getAttribute("tipo")%>>
  <button type="submit" class="btn btn-primary" >Aggiungi</button><br><br>

</form>
<%if(request.getAttribute("tipo").equals("cliente")) {%>
<form action="home.jsp">
  <button type="submit" class="btn btn-primary" >Indietro</button>  
  </form>
 <%}else{ %>
 <form action="azioniInterno.jsp">
  <button type="submit" class="btn btn-primary" >Indietro</button>  
  </form>
  <%} %>
</body>
</html>