<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table border="1px solid black" width="100%">
<tr>
	<th>EID</th>
	<th>ENAME</th>
	<th>ESALARY</th>
	
</tr>
<c:forEach items="${list}" var="emp">
		<tr>
			<td>${emp.id}</td>
			<td>${emp.name}</td>
			<td>${emp.salary}</td>
			
		</tr>
</c:forEach>
</table>
</body>
</html>