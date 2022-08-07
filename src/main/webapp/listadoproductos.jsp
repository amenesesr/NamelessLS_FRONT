<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<%@ page import='java.util.Date'%>
<%@ page import='co.edu.unbosque.nameless.Productos'%>
<%@ page import='java.util.ArrayList'%>
<html>
<head>
<meta charset="utf-8">
<link rel="shortcut icon" href="IMG/favicon.png" type="image/x-icon" />
<title>Nameless LS - Listado Productos</title>
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
			<h1>Listado de Productos</h1>
			<h4>
				Hora servidor:
				<%= new Date() %></h4>
			<table border="5">
				<tr>
					<td>Codigo</td>
					<td>Nombre</td>
					<td>Precio Venta</td>
				</tr>
				<% ArrayList<Productos> lista= (ArrayList<Productos>) request.getAttribute("lista");
					for (Productos producto:lista){
					%>
				<tr>
					<td><%=producto.getCodigo_productos()%></td>
					<td><%=producto.getNombre_productos()%></td>
					<td><%=producto.getPrecio_venta_productos()%></td>
				</tr>
				<%}%>
			</table>
		</center>
		<br>
		<br>
		<footer>
			<img class="footer" src="IMG/footer.png" alt="Nameless Liquor Store">
		</footer>
	</form>
</body>
</html>
