<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="co.edu.unbosque.nameless.Proveedores"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="shortcut icon" href="IMG/favicon.png" type="image/x-icon" />
<title>Nameless LS - Proveedores</title>
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
		<li><a href="proveedores.jsp" class="active">Proveedores</a></li>
		<li><a href="productoindividual.jsp">Producto Individual</a></li>
		<li><a href="productos.jsp">Productos</a></li>	
		<li><a href="ventas.jsp">Ventas</a></li>
		<li><a href="reportes.jsp">Reportes</a></li>
		<li><a href="index.jsp">Salir</a></li>
	</ul>
	<form class="formulario" method="get" action="./ProveedoresServlet">
		<div>
			<br>
			<h2>
				Proveedores
			</h2>
			<br>
			<center>
				<table border="0">
					<% 
					long txtNit = (Long) request.getAttribute("txtNit");
					String txtNombre = (String) request.getAttribute("txtNombre");
	      			String txtCiudad = (String) request.getAttribute("txtCiudad");
	      			String txtTelefono = (String) request.getAttribute("txtTelefono");
	      			String txtDireccion = (String) request.getAttribute("txtDireccion");
	      			int error = (int) request.getAttribute("error");

		      		if (error == 1)
					{%>
					<tr>
						<td>
							<label>NIT</label>
						</td>
						<td>
							<input type="number" name="txtNit" id="txtNit" maxlength="20" size="50"	value="<%=txtNit%>" required>
						</td>
						<td>
							<label>Teléfono </label>
						</td>
						<td>
							<input type="number" name="txtTelefono" id="txtTelefono" maxlength="20" size="50" value="<%=txtTelefono%>">
						</td>
					</tr>
					<tr>
						<td>
							<label>Nombre del Proveedor </label>
						</td>
						<td>
							<input type="text" name="txtNombre" id="txtNombre" maxlength="50" size="50" value="<%=txtNombre%>">
						</td>
						<td>
							<label>Ciudad</label>
						</td>
						<td>
							<input type="text" name="txtCiudad" id="txtCiudad" maxlength="50" size="50" value="<%=txtCiudad%>">
						</td>
					</tr>
					<tr>
						<td>
							<label>Dirección </label>
						</td>
						<td>
							<input type="text" name="txtDireccion" id="txtDireccion" maxlength="50" size="50" value="<%=txtDireccion%>">
						</td>
					</tr>
					</table>
					<h3>
						<b>Proveedor encontrado.</b>
					</h3>
					<%}
		     		else
		     		{%>
					<table border="0">
					<tr>
						<td>
							<label>NIT</label>
						</td>
						<td>
							<input type="number" name="txtNit" id="txtNit" maxlength="20" size="50" placeholder="Digite el NIT" required>
						</td>
						<td>
							<label>Teléfono</label>
						</td>
						<td>
							<input type="text" name="txtTelefono" id="txtTelefono" maxlength="50" size="50" placeholder="Digite el teléfono">
						</td>
					</tr>
					<tr>
						<td>
							<label>Nombre del Proveedor </label>
						</td>
						<td>
							<input type="text" name="txtNombre" id="txtNombre" maxlength="50" size="50" placeholder="Digite el nombre del proveedor">
						</td>
						<td>
							<label>Ciudad</label>
						</td>
						<td>
							<input type="text" name="txtCiudad" id="txtCiudad" maxlength="50" size="50" placeholder="Digite la ciudad">
						</td>
					</tr>
					<tr>
						<td>
							<label>Dirección </label>
						</td>
						<td>
							<input type="text" name="txtDireccion" id="txtDireccion" maxlength="50" size="50" placeholder="Digite la dirección">
						</td>
					</tr>
				</table>
				<h3>
					<b>Proveedor no encontrado en la base de datos.</b>
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
