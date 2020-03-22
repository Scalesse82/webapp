<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Vendita Prodotti</title>
</head>
<body>

<form action="vendiProdotto">
  
  <label for="idProdotto">Inserisci l'id del prodotto</label>
  <input type="number" id="idProdotto" name="idProdotto"><br><br>
  <label for="qtaVenduta">inserisci la quantita da vendere</label>
  <input type="number" id="qtaVenduta" name="qtaVenduta"><br><br>
  <input type="submit" value="vendi">

</form>

<form action="azioniNegozio.jsp">
  <input type="submit" value ="pagina iniziale"><br><br>
  </form>





</body>
</html>