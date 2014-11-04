<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
	<title>Spring 3 MVC Series - Clientes</title>
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
</head>
<body>

<h2>Nueva Transacción</h2>

<%
HttpSession sessionsa = request.getSession(false);
String msgError = (String) sessionsa.getAttribute("msgError");
%>

<div style="background-color:#CD5D5D">
	<% if (msgError!= null && msgError.length()>0){
		out.println("<h4>"+msgError+"</h4>");		  
	}
	%>	
</div>

<form:form method="post" action="/bankaccount/transaction/add.html" commandName="transaction">

	<table>
	<tr>
		<td><form:label path="type"><spring:message text="Tipo"/></form:label></td>
		<td><form:input path="type" readonly="true" /></td> 
	</tr>
	<tr>
		<td><form:label path="value"><spring:message text="Valor"/></form:label></td>
		<td><form:input path="value" /></td>
	</tr>
	<tr>
		<td colspan="2">
			<input type="submit" value="<spring:message text="Realizar Transacción"/>"/>
		</td>
	</tr>
</table>	
</form:form>
</body>
</html>