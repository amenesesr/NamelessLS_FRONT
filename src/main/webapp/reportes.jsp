<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="shortcut icon" href="IMG/favicon.png" type="image/x-icon" />
<title>Nameless LS - Reportes</title>
<link href="https://fonts.googleapis.com/css2?family=Anton&family=Ubuntu&display=swap" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="CSS/estilo.css">
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
	<form class=formulario method="get" action="./ReportesServlet">
		<br>
		<h2>Reportes</h2>
		<br>
		<br>
		<center>
		<table>
			<tr>
				<input type="submit" name="btnListadoUsuarios" id="btnListadoUsuarios" value="Listado Usuarios" class="button">
			</tr>
			<tr>
				<input type="submit" name="btnListadoClientes" id="btnListadoClientes" value="Listado Clientes" class="button">
			</tr> 
			<tr>
				<input type="submit" name="btnlistadoProveedores" id="btnlistadoProveedores" value="Listado Proveedores" class="button"> 
			</tr>
		</table>
		<br><br>
		<table>
			<tr>
				<input type="submit" name="btnlistadoProductos" id="btnlistadoProductos" value="Listado Productos" class="button">
			</tr>
			<tr>
				<input type="submit" name="btnVentasCliente" id="btnVentasCliente" value="Ventas por Cliente" class="button">
			</tr>
			<tr>
				<input type="submit" name="btnVentas" id="btnVentas" value="Listado Ventas" class="button">
			</tr>
		</table>
		</center>
		<br>
		<br> <br>
	</form>
	<footer>
		<img class="footer" src="IMG/footer.png" alt="Nameless Liquor Store">
	</footer>
</body>
</html>
