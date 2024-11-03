<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>    
<%@taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Employee</title>
</head>
<body>
<fmt:setBundle basename="labels"/>
<h1>Update Employee</h1>
<form:form modelAttribute="employee" action="updateEmployee" method="POST" >
<form:hidden path="id"/>
<table border="1">
	<tr>
		<td><fmt:message key="employee.add-employee.name.label" /></td>
		<td><form:input path="name"/></td>
	</tr>
	<tr>
		<td><fmt:message key="employee.add-employee.address.label" /></td>
		<td><form:input path="address"/></td>
	</tr>
	<tr>
		<td><fmt:message key="employee.add-employee.salary.label" /></td>
		<td><form:input path="salary"/></td>
	</tr>
	<tr>
		<td align="center" colspan="2"><input type="submit" value="Update Employee"/>&nbsp;&nbsp;&nbsp; <a href="getAllEmployees">Cancel</a></td>
	</tr>
</table>
</form:form>
</body>
</html>