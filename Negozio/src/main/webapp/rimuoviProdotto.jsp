<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Rimozione prodotto</title>
</head>
<body>


<form action="rimProdotto">
  
  <label for="idProdotto">Inserisci l'id del prodotto da rimuovere</label>
  <input type="number" id="idProdotto" name="idProdotto"><br><br>
  
  <input type="submit" value="rimuovi">

</form>

<form action="azioniNegozio.jsp">
  <input type="submit" value ="pagina iniziale"><br><br>
  </form>
  

</body>
</html>