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
</head>
<body>


<h2><spring:message code="label.titleCustomers"/></h2>

<div id="div_one_customer" style="display=none;">


<c:url var="addAction" value="/customer/add" ></c:url> 
<form:form action="${addAction}" commandName="customer">
	<table>
	<tr>
        <td>
            <form:label path="id">
                <spring:message text="id"/>
            </form:label>
        </td>
        <td>
            <form:input path="id" readonly="true" size="8"  disabled="true" />
            <form:hidden path="id" />
        </td>
    </tr>
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
		<td>
			<c:if test="${!empty customer.name}">
                <input type="submit"
                    value="<spring:message text="Editar Cliente"/>" />
            </c:if>
            <c:if test="${empty customer.name}">
                <input type="submit"
                    value="<spring:message text="Agregar Cliente"/>" />
            </c:if>			
		</td>
		<td>
			<button type="button" onclick="view_div_customers()">Volver</button>
		</td>
	</tr>
</table>	
</form:form>

</div>

<div id="div_customers">

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
		<td><a href="customer/delete/${customer.id}">Eliminar</a></td>
		<td><a href="<c:url value='/edit/${customer.id}'/>" >Edit</a></td>
	</tr>
</c:forEach>
</table>
</c:if>
<button type="button" onclick="view_div_one_customer()">Agregar Cliente</button>
</div>


</body>
<script>
function view_div_customers() {
    document.getElementById("div_one_customer").style.display = "none";
    document.getElementById("div_customers").style.display = "block";
}
function view_div_one_customer() {
    document.getElementById("div_customers").style.display = "none";
    document.getElementById("div_one_customer").style.display = "block";
}
</script>
</html>
