<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="co.edu.unbosque.nameless.Clientes"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="shortcut icon" href="IMG/favicon.png" type="image/x-icon" />
<title>Nameless LS - Clientes</title>
<link href="https://fonts.googleapis.com/css2?family=Anton&family=Ubuntu&display=swap" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="CSS/estilo.css">
</head>
<body>
	<header>
		<img class="header" src="IMG/titulo.png" alt="Nameless Liquor Store">
	</header>
	<ul class="menu">
		<li><a href="usuarios.jsp">Usuarios</a></li>
		<li><a href="clientes.jsp" class="active">Clientes</a></li>
		<li><a href="proveedores.jsp">Proveedores</a></li>
		<li><a href="productoindividual.jsp">Producto Individual</a></li>
		<li><a href="productos.jsp">Productos</a></li>
		<li><a href="ventas.jsp">Ventas</a></li>
		<li><a href="reportes.jsp">Reportes</a></li>
		<li><a href="index.jsp">Salir</a></li>
	</ul>
	<form class="formulario" method="get" action="./ClientesServlet">
		<div>
			<br>
				<h2>
					Clientes
				</h2>
			<br>
			<center>
				<table border="0">
					<% 
		      		long txtCedula = (Long) request.getAttribute("txtCedula");
					String txtNombre = (String) request.getAttribute("txtNombre");
		      		String txtCorreo = (String) request.getAttribute("txtCorreo");
		      		String txtTelefono = (String) request.getAttribute("txtTelefono");
		      		String txtDireccion = (String) request.getAttribute("txtDireccion");
		      		int error = (int) request.getAttribute("error");

		      		if (error == 1)
					{%>
					<tr>
						<td>
							<label>Cedula</label>
						</td>
						<td>
							<input type="number" name="txtCedula" id="txtCedula" maxlength="20" size="50" value="<%=txtCedula%>" required>
						</td>
						<td>
							<label>Teléfono</label>
						</td>
						<td>
							<input type="number" name="txtTelefono" id="txtTelefono" maxlength="20" size="50" value="<%=txtTelefono%>">
						</td>
					</tr>
					<tr>
						<td>
							<label>Nombre Completo</label>
						</td>
						<td>
							<input type="text" name="txtNombre" id="txtNombre" maxlength="50" size="50" value="<%=txtNombre%>">
						</td>
						<td>
							<label>Correo Electrónico</label>
						</td>
						<td>
							<input type="email" name="txtCorreo" id="txtCorreo"	maxlength="50" size="50" value="<%=txtCorreo%>">
						</td>
					</tr>
					<tr>
						<td>
							<label>Dirección</label>
						</td>
						<td>
							<input type="text" name="txtDireccion" id="txtDireccion" maxlength="50" size="50" value="<%=txtDireccion%>">
						</td>
					</tr>
					</table>
					<h3>
						<b>Cliente encontrado.</b>
					</h3>
					<%}
		     		else
		     		{%>
					<table border="0">
					<tr>
						<td>
							<label>Cedula</label>
						</td>
						<td>
							<input type="number" name="txtCedula" id="txtCedula" maxlength="20" size="50" placeholder="Digite la cedula" required>
						</td>
						<td>
							<label>Teléfono</label>
						</td>
						<td>
							<input type="number" name="txtTelefono" id="txtTelefono" maxlength="20" size="50" placeholder="Digite el teléfono">
						</td>
						</tr>
						<tr>
						<td>
							<label>Nombre Completo</label>
						</td>
						<td>
							<input type="text" name="txtNombre" id="txtNombre" maxlength="50" size="50" placeholder="Digite el nombre completo">
						</td>
						<td>
							<label>Correo Electrónico</label>
						</td>
						<td>
							<input type="email" name="txtCorreo" id="txtCorreo" maxlength="50" size="50" placeholder="Digite el correo electrónico">
						</td>
						</tr>
						<tr>
						<td>
							<label>Dirección</label>
						</td>
						<td>
							<input type="text" name="txtDireccion" id="txtDireccion" maxlength="50" size="50" placeholder="Digite la dirección">
						</td>
					</tr>
				</table>
				<h3>
					<b>Cliente no encontrado en la base de datos.</b>
				</h3>
				<%
				}
				%>
	
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
</html>
