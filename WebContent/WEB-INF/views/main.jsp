<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<table>
		<tr>
			<th>Name</th>
			<th>Last Name</th>
			<th>Age</th>
			<th>Status</th>
		</tr>
			<c:forEach items="${students}" var="students">
				<tr>
					<td>${students.sName}</td>
					<td>${students.lName}</td>
					<td>${students.sAge}</td>
					<td>${students.activoDelegate}</td>
				</tr>	
			</c:forEach>
	</table>

</body>
</html>