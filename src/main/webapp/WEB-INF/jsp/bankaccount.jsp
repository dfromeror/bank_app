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
<h3>Cliente: ${customer.name}</h3>

<%
HttpSession sessionsa = request.getSession(false);
String msgError = (String) sessionsa.getAttribute("msgError");
%>

<div id="div_one_customer" style="display=none;">
<div style="background-color:#CD5D5D">
	<% if (msgError!= null && msgError.length()>0){
		out.println("<h4>"+msgError+"</h4>");		  
	}
	%>	  
</div>



<div id="div_one_customer" style="display=none;">


<c:url var="addAction" value="/bankaccount/add" ></c:url> 
<form:form action="${addAction}" commandName="bankAccount">
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
		<td><form:label path="number"><spring:message code="label.numberBankAccount"/></form:label></td>
		<td><form:input path="number" /></td> 
	</tr>	
	<tr>
		<td>
			<c:if test="${!empty bankAccount.number}">
                <input type="submit"
                    value="<spring:message text="Editar Cuenta"/>" />
            </c:if>
            <c:if test="${empty bankAccount.number}">
                <input type="submit"
                    value="<spring:message text="Agregar Cuenta"/>" />
            </c:if>			
		</td>
		
	</tr>
</table>	
</form:form>

</div>

<div id="div_customers">

<h3>Cuentas</h3>
<c:if  test="${!empty bankAccountList}">
<table class="data">
<tr>
	<th><spring:message code="label.numberBankAccount"/></th>
	<th><spring:message code="label.balanceBankAccount"/></th>	
	<th colspan="2"><spring:message text="Acciones"/></th>
	<th colspan="2"><spring:message text="Transacciones"/></th>
	
	<th>&nbsp;</th>
</tr>
<c:forEach items="${bankAccountList}" var="bankAccount">
	<tr>
		<td>${bankAccount.number} </td>
		<td>${bankAccount.balance}</td>		
		<td><a href="<c:url value='/bankaccount/delete/${bankAccount.id}'/>">Eliminar</a></td>
		<td><a href="<c:url value='/bankaccount/edit/${bankAccount.id}'/>" >Edit</a></td>		
		<td><a href="<c:url value='/bankaccount/${bankAccount.id}/transaction'/>" >Ver Transaciones</a></td>
	</tr>
</c:forEach>
</table>
</c:if>
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
