<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="shortcut icon" href="IMG/favicon.png" type="image/x-icon" />
<title>Nameless LS - Productos</title>
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
		<li><a href="productos.jsp" class="active">Productos</a></li>
		<li><a href="ventas.jsp">Ventas</a></li>
		<li><a href="reportes.jsp">Reportes</a></li>
		<li><a href="index.jsp">Salir</a></li>
	</ul>
	<form class="formulario" method="get" action="./ProductosServlet" enctype="multipart/form-data">
		<div>	
			<img class="const" src="IMG/const.jpg" alt="En Construccion">
		</div>
	</form>
	<footer>
		<img class="footer" src="IMG/footer.png" alt="Nameless Liquor Store">
	</footer>
</body>
<script type="text/javascript" src="JS/funciones.js"></script>
</html>
