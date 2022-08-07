<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="co.edu.unbosque.nameless.Usuarios"%>
<%@page import="java.util.ArrayList"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="shortcut icon" href="IMG/favicon.png" type="image/x-icon" />
<title>Nameless LS - Usuarios</title>
<link href="https://fonts.googleapis.com/css2?family=Anton&family=Ubuntu&display=swap" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="CSS/estilo.css">
</head>
<body>
	<header>
		<img class="header" src="IMG/titulo.png" alt="Nameless Liquor Store">
	</header>
	<ul class="menu">
		<li><a href="usuarios.jsp" class="active">Usuarios</a></li>
		<li><a href="clientes.jsp">Clientes</a></li>
		<li><a href="proveedores.jsp">Proveedores</a></li>
		<li><a href="productoindividual.jsp">Producto Individual</a></li>
		<li><a href="productos.jsp">Productos</a></li>
		<li><a href="ventas.jsp">Ventas</a></li>
		<li><a href="reportes.jsp">Reportes</a></li>
		<li><a href="index.jsp">Salir</a></li>
	</ul>
	<form class="formulario" method="post" action="./UsuariosServlet">
		<div>
			<br>
			<h2>Usuarios</h2>
			<br>
			<center>
				<table border="0">
					<tr>
						<td>
							<label>Cedula</label>
						</td>
						<td>
							<input type="number" maxlength="20" id="txtCedula" name="txtCedula" size="50" placeholder="Digite la cedula" required>
						</td>
						<td>
							<label>Usuario </label>
						</td>
						<td>
							<input type="text" id="txtUsuario" name="txtUsuario" maxlength="50" size="50" placeholder="Digite el usuario">
						</td>
					</tr>
					<tr>
						<td>
							<label>Nombre Completo </label>
						</td>
						<td>
							<input type="text" id="txtNombre" name="txtNombre" maxlength="50" size="50" placeholder="Digite el nombre">
						</td>
						<td>
							<label>Contraseña </label>
						</td>
						<td>
							<input type="password" id="txtPassword" name="txtPassword" maxlength="50" size="50" placeholder="Digite la contraseña">
						</td>
					</tr>
					<tr>
						<td>
							<label>Correo Electrónico </label>
						</td>
						<td>
							<input type="email" maxlength="50" id="txtCorreo" name="txtCorreo" size="50" placeholder="Digite el correo electrónico">
						</td>
						<td>
						</td>
						<td>
							<input type="checkbox" onclick="verPassword()" class="checkbox"><label>Mostrar Contraseña</label>
						</td>
					</tr>
				</table>
				<h3>
					<b>No se ha creado/modificado el usuario, todos los campos deben estar llenos.</b>
				</h3>
			</center>
			<center>
				<td>
					<input type="submit" name="btnConsultar" id="btnConsultar" value="Consultar" class="button">
				</td>
				<td>
					<input type="submit" name="btnCrear" id="btnCrear" value="Crear" class="button">
				</td>
				<td>
					<input type="submit" name="btnActualizar" id="btnActualizar" value="Actualizar" class="button">
				</td>
				<td>
					<input type="submit" name="btnBorrar" id="btnBorrar" value="Borrar" class="button">
				</td>
			</center>
		</div>
	</form>
	<footer>
		<img class="footer" src="IMG/footer.png" alt="Nameless Liquor Store">
	</footer>
</body>
<script type="text/javascript" src="JS/funciones.js"></script>
</html>