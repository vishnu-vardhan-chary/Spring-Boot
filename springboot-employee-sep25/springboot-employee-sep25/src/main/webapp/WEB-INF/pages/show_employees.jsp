<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="jakarta.tags.core"%>
<%@taglib prefix="fmt" uri="jakarta.tags.fmt"%>
<%@taglib prefix="fn" uri="jakarta.tags.functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Employee List</title>
<script type="text/javascript" src="employee.js"></script>
</head>
<body>
	<fmt:setBundle basename="labels" />
	<h1>
		<fmt:message key="employee.show-employee.header" />
	</h1>
	<a href="addEmployee"><fmt:message
			key="employee.show-employee.add-employee.label" /></a>
	<form name="frm">
		<input type="hidden" name="emp_id" />
		<table border="1" width="100%">
			<tr>
				<td align="left" colspan="6">Name : <input name="emp_name"/><button>Search</button></td>
			</tr>
			<tr>
				<td align="right" colspan="6"><b><fmt:message
							key="employee.show-employee.date.header" /></b> <fmt:formatDate
						value="<%=new Date()%>" dateStyle="long" /></td>
			</tr>
			<tr>
				<td><fmt:message key="employee.show-employee.id.label" /></td>
				<td><fmt:message key="employee.show-employee.name.label" /></td>
				<td><fmt:message key="employee.show-employee.address.label" /></td>
				<td><fmt:message key="employee.show-employee.salary.label" /></td>
				<td align="center"><fmt:message
						key="employee.show-employee.edit.label" /></td>
				<td align="center"><fmt:message
						key="employee.show-employee.delete.label" /></td>
			</tr>
			<c:if test="${fn:length(emps) == 0 }">
				<tr>
					<td colspan="6">No Employees found!!!</td>
				</tr>
			</c:if>
			<c:if test="${fn:length(emps) > 0 }">
				<c:forEach items="${emps}" var="emp">
					<tr>
						<td>${emp.id}</td>
						<td>${emp.name}</td>
						<td>${emp.address}</td>
						<td>${emp.salary}</td>
						<td align="center"><button onclick="editEmployee(${emp.id})">Edit</button></td>
						<td align="center"><button
								onclick="deleteEmployee(${emp.id})">Delete</button></td>
					</tr>
				</c:forEach>
			</c:if>
		</table>
	</form>
</body>
</html>