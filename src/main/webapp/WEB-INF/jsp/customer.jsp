<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1" session="false"%>
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

<%
HttpSession sessionsa = request.getSession(false);
String msgError="";
if ((String) sessionsa.getAttribute("msgError")!=null){
	msgError = (String) sessionsa.getAttribute("msgError");
}
%>

<div id="div_one_customer">
<div style="background-color:#CD5D5D">
	<% if (msgError!= null && msgError.length()>0){
		out.println("<h4>"+msgError+"</h4>");		  
	}
	%>	  
</div>

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
		<td><form:input id="name" path="name" /></td> 
	</tr>
	<tr>
		<td><form:label path="address"><spring:message code="label.addressCustomer"/></form:label></td>
		<td><form:input id="address" path="address" /></td>
	</tr>
	<tr>
		<td><form:label path="phone"><spring:message code="label.phoneCustomer"/></form:label></td>
		<td><form:input id="phone" path="phone" /></td>
	</tr>	
	<tr>
		<td>
			<c:if test="${!empty customer.name}">
                <input type="submit" value="<spring:message text="Editar Cliente"/>" />
            </c:if>
            <c:if test="${empty customer.name}">
                <input type="submit"   onsubmit="validate()"
                    value="<spring:message text="Agregar Cliente"/>" />
            </c:if>			
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
	<th><spring:message text="Eliminar"/></th>
	<th><spring:message text="Editar"/></th>
	<th><spring:message text="Cuentas"/></th>	
	<th>&nbsp;</th>
</tr>
<c:forEach items="${customerList}" var="customer">
	<tr>
		<td>${customer.name} </td>
		<td>${customer.address}</td>
		<td>${customer.phone}</td>
		<td><a href="<c:url value='/customer/delete/${customer.id}'/>">Eliminar</a></td>
		<td><a href="<c:url value='/customer/edit/${customer.id}'/>" >Edit</a></td>
		<td><a href="<c:url value='/customer/${customer.id}/bankaccount/'/>" >Ver Cuentas</a></td>
	</tr>
</c:forEach>
</table>
</c:if>
</div>


</body>

<script>
function validate() {
var name=document.getElementById("name")
var address=document.getElementById("address")
var phone=document.getElementById("phone")
if (name.length ==0) {
	alert("Debe ingresar su nombre");
    return false;
} else if (address.length ==0) {
	alert("Debe ingresar su dirección");
    return false;
} else if (phone.length ==0) {
	alert("Debe ingresar su número telefónico");
    return false;
} else {
	return true;
} 

}

</script>

</html>
