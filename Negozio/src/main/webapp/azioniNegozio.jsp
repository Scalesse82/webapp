<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1>SCEGLI L'AZIONE DA FARE</h1>

<form action="aggiungiprodotto.jsp">
<input type="submit" value = "Aggiungi prodotto">
</form>
<form action="rimuoviProdotto.jsp">
<input type="submit" value = "rimuovi prodotto">
</form>
<form action="stmProdotto">
<input type="submit" value = "modifica prodotto">
</form>
<form action="vendita.jsp">
<input type="submit" value = "vendita prodotto">
</form>
<form action="stampaProdottiVenduti">
<input type="submit" value = "Stampa vendite">
</form>

</body>
</html>