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

<h2><spring:message code="label.title"/></h2>

<form:form method="post" action="add.html" commandName="customer">

	<table>
	<tr>
		<td><form:label path="name"><spring:message code="label.nameCustomer"/></form:label></td>
		<td><form:input path="name" /></td> 
	</tr>
	<tr>
		<td><form:label path="address"><spring:message code="label.addressCustomer"/></form:label></td>
		<td><form:input path="address" /></td>
	</tr>
	<tr>
		<td><form:label path="phone"><spring:message code="label.phoneCustomer"/></form:label></td>
		<td><form:input path="phone" /></td>
	</tr>	
	<tr>
		<td colspan="2">
			<input type="submit" value="<spring:message code="label.addCustomer"/>"/>
		</td>
	</tr>
</table>	
</form:form>

	
<h3>Clientes</h3>
<c:if  test="${!empty customerList}">
<table class="data">
<tr>
	<th><spring:message code="label.nameCustomer"/></th>
	<th><spring:message code="label.addressCustomer"/></th>
	<th><spring:message code="label.phoneCustomer"/></th>
	<th>&nbsp;</th>
</tr>
<c:forEach items="${customerList}" var="customer">
	<tr>
		<td>${customer.name} </td>
		<td>${customer.address}</td>
		<td>${customer.phone}</td>
		<td><a href="delete/${customer.id}">Eliminar</a></td>
	</tr>
</c:forEach>
</table>
</c:if>


</body>
</html>
