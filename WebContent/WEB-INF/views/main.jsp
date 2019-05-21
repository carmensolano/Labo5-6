<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Spring JPA</title>
</head>
<body>

	<form action="${pageContext.request.contextPath}/form" method="post">
			<label>Buscar por ID</label> <input type="number" name="ID"><br>
			<input type= "submit" value= "Enviar">
	</form>
	
	<form action="${pageContext.request.contextPath}/delete" method="post">
			<label>Nombre a Borrar</label> <input type="number" name="ID2"><br>
			<input type= "submit" value= "Enviar">
	</form>

	<h1>Usuario Encontrado</h1>
	
	<table border="1">
		<tr>
			<th>Nombre</th>
			<th>Apellido</th>
			<th>Edad</th>
			<th>Status</th>
			<th>Editar</th>
		</tr>
		
		<tr>
			<th>${student2.sName}</th>
			<th>${student2.1Name}</th>
			<th>${student2.sAge}</th>
			<th>${student2.activoDelegate}</th>	
		</tr>	
	
	</table>
	
	<form action= "${pageContext.request.contextPath}/save" method= "post">
		<br>
		<input type = "submit" value= "Agregar Usuario">
	
	</form>

<h1>Lista de Usuarios</h1>
	<table border= "1">
	
		<tr>
			<th>Nombre</th>
			<th>Apellido</th>
			<th>Edad</th>
			<th>Status</th>
			<th>Editar</th>
		</tr>
	
	<c:forEach items="${student}" var="student">
	
	<tr>
	
		<th>${student.sName}</th>
			<th>${student.1Name}</th>
			<th>${student.sAge}</th>
			<th>${student.activoDelegate}</th>	
			<th> <form action= "${pageContext.request.contextPath}/update" method="post">
				<input type="hidden" name="ID3" value=${student.cStudent }><br>
				<input type= "submit" value= "editar">
	</form></th>
	</tr>
	
	</c:forEach>
	
	
	
	</table>
	
	
</body>
</html>