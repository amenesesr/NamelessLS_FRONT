<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ page import='java.util.Date'%>
<%@ page import='co.edu.unbosque.nameless.Clientes'%>
<%@ page import='java.util.ArrayList'%>
<html>
<head>
<meta charset="UTF-8">
<link rel="shortcut icon" href="IMG/favicon.png" type="image/x-icon" />
<title>Nameless LS - Listado Clientes</title>
<link href="https://fonts.googleapis.com/css2?family=Anton&family=Ubuntu&display=swap" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="CSS/estiloreportes.css">
</head>
<body>
	<header>
		<img class="header" src="IMG/titulo.png" alt="Nameless Liquor Store">
	</header>
	<ul class="menu">
		<li><a href="usuarios.jsp">Usuarios</a></li>
		<li><a href="clientes.jsp">Clientes</a></li>
		<li><a href="proveedores.jsp">Proveedores</a></li>
		<li><a href="productoindividual.jsp">Producto Individual</a></li>
		<li><a href="productos.jsp">Productos</a></li>	
		<li><a href="ventas.jsp">Ventas</a></li>
		<li><a href="reportes.jsp" class="active">Reportes</a></li>
		<li><a href="index.jsp">Salir</a></li>
	</ul>
	<form class="formulario">
		<br>
		<center>
			<h1>Listado de Clientes</h1>
			<h4>
				Hora servidor:
				<%= new Date() %></h4>
			<table border="5">
				<tr>
					<td>Cedula</td>
					<td>Nombre</td>
					<td>Correo Electronico</td>
					<td>Direccion</td>
					<td>Telefono</td>
				</tr>
				<% ArrayList<Clientes> lista= (ArrayList<Clientes>) request.getAttribute("lista");
					for (Clientes cliente:lista){
					%>
				<tr>
					<td><%=cliente.getCedula_clientes()%></td>
					<td><%=cliente.getNombre_clientes()%></td>
					<td><%=cliente.getEmail_clientes()%></td>
					<td><%=cliente.getDireccion_clientes()%></td>
					<td><%=cliente.getTelefono_clientes()%></td>
				</tr>
				<%}%>
			</table>
		</center>
		<br>
		<br>
	</form>
	<footer>
		<img class="footer" src="IMG/footer.png" alt="Nameless Liquor Store">
	</footer>
</body>
</html>
