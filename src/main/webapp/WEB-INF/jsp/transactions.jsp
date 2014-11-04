<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
	<title>Spring 3 MVC Series - Banco</title>
	<style type="text/css">
		body {
			font-family: sans-serif;
		}
		.data, .data td {
			border-collapse: collapse;
			width: 80%;
			border: 1px solid #aaa;
			margin: 2px;
			padding: 2px;
		}
		.data th {
			font-weight: bold;
			background-color: #5C82FF;
			color: white;
		}
	</style>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Transacciones</title>
  
</div>
</head>

<h2>Transacciones</h2>
<h4>Cuentas Nro: ${bankAccount.number}</h4>
<h4>Saldo: ${bankAccount.balance}</h4>

<body>
<c:if  test="${!empty transactionList}">
<table class="data">
<tr>
	<th>Tipo</th>
	<th>Valor</th>
	<th>fecha</th>
	<th>&nbsp;</th>
</tr>
<c:forEach items="${transactionList}" var="onetransaction">
	<tr>
		<td>${onetransaction.type} </td>
		<td>${onetransaction.value}</td>
		<td>${onetransaction.dateTime}</td>				
	</tr>
</c:forEach>
</table>
</c:if>
<td><a href="<c:url value='/bankaccount/transaction/credit/'/>" >Retirar</a></td>
<td><a href="<c:url value='/bankaccount/transaction/debit/'/>" >Ingresar Dinero</a></td>


</body>
</html>