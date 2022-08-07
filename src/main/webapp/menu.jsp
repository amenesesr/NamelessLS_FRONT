<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import='co.edu.unbosque.nameless.Usuarios'%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="shortcut icon" href="IMG/favicon.png" type="image/x-icon" />
<title>Nameless LS - Menu Principal</title>
<link href="https://fonts.googleapis.com/css2?family=Anton&family=Ubuntu&display=swap" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="CSS/estilo.css">
</head>
<body>
	<header>
		<img class="header" src="IMG/titulo.png" alt="Nameless Liquor Store">
	</header>
	<% 
	Usuarios usuario = (Usuarios) request.getAttribute("usuario");
	%>
	<input type="hidden" value=<%=usuario%> name="usuario" >
	<ul class="menu">
		<li><a href="usuarios.jsp">Usuarios</a></li>
		<li><a href="clientes.jsp">Clientes</a></li>
		<li><a href="proveedores.jsp">Proveedores</a></li>
		<li><a href="productoindividual.jsp">Producto Individual</a></li>
		<li><a href="productos.jsp">Productos</a></li>
		<li><a href="ventas.jsp">Ventas</a></li>
		<li><a href="reportes.jsp">Reportes</a></li>
		<li><a href="index.jsp">Salir</a></li>
		<li><label>Usuario: <%=usuario.getUsuario_usuarios()%></label></li>
	</ul>
	<form class="formulario">
		<br>
		<div>
			<h2>
				Bienvenido <%=usuario.getNombre_usuarios()%> al Sistema de Facturación de Nameless Liquor Store
				</h3>
				<center>
					<label>En el sistema usted podrá realizar las siguientes
						tareas.</label> <br>
					<br>
					<table class="tablaMenu">
						<tr>
							<td><label>Usuarios</label></td>
							<td><label>Permite ingresar, eliminar, modificar y
									consultar los usuarios que tienen acceso al sistema.</label></td>
						</tr>
						<tr>
							<td><label>clientes</label></td>
							<td><label>Permite ingresar, eliminar, modificar y
									consultar los clientes de la Distribuidora.</label></td>
						</tr>
						<tr>
							<td><label>Proveedores</label></td>
							<td><label>Permite ingresar, eliminar, modificar y
									consultar los proveedores que tiene la Distribuidora.</label></td>
						</tr>
						<tr>
							<td><label>Producto Individual</label></td>
							<td><label>Permite ingresar, eliminar, modificar y
									consultar productos que se tienen en la Distribuidora. </label></td>
						</tr>
						<tr>
							<td><label>Productos</label></td>
							<td><label>Permite cargar archivos con la
									información de los productos que se tienen en la Distribuidora.</label></td>
						</tr>
						<tr>
							<td><label>Ventas</label></td>
							<td><label>Permite realizar la venta de productos a
									los clientes de la Distribuidora.</label></td>
						</tr>
						<tr>
							<td><label>Reportes</label></td>
							<td><label>Permite ver diferentes reportes
									relacionados con las actividades de la Distribuidora.</label></td>
						</tr>
						<tr>
							<td><label>Salir</label></td>
							<td><label>Permite salir del sistema de facturación
									de la Distribuidora.</label></td>
						</tr>
					</table>
		</div>
	</form>
	<footer>
		<img class="footer" src="IMG/footer.png" alt="Nameless Liquor Store">
	</footer>
</body>
</html>
