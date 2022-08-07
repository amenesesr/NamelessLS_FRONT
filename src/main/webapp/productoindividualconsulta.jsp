<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
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
		<li><a href="productoindividual.jsp" class="active">Producto Individual</a></li>
		<li><a href="productos.jsp">Productos</a></li>	
		<li><a href="ventas.jsp">Ventas</a></li>
		<li><a href="reportes.jsp">Reportes</a></li>
		<li><a href="index.jsp">Salir</a></li>
	</ul>
	<form class="formulario" method="get"
		action="./ProductoIndividualServlet">
		<div>
			<br>
			<h2>Producto Individual</h2>
			<br>
			<center>
				<table border="0">
					<%
					long txtCodigo = (Long) request.getAttribute("txtCodigo");
					long txtNIT = (Long) request.getAttribute("txtNIT");
					String txtNombre = (String) request.getAttribute("txtNombre");
					double txtValorCompra = (Double) request.getAttribute("txtValorCompra");
					double txtValorVenta = (Double) request.getAttribute("txtValorVenta");
					double txtIVA = (Double) request.getAttribute("txtIVA");
					int error = (int) request.getAttribute("error");
		
					if (error == 1)
					{%>
					<tr>
						<td>
							<label>Codigo del Producto </label>
						</td>
						<td>
							<input type="number" name="txtCodigo" id="txtCodigo" maxlength="20" size="50" value="<%=txtCodigo%>" required>
						</td>
						<td>
							<label>IVA</label>
						</td>
						<td>
							<input type="number" name="txtIVA" id="txtIVA" maxlength="50" size="50" value="<%=txtIVA%>" min="0" pattern="[0-9]+">
						</td>
					</tr>
					<tr>
						<td>
							<label>Nombre del Producto </label>
						</td>
						<td>
							<input type="text" name="txtNombre" id="txtNombre" maxlength="50" size="50" placeholder="Digite el nombre" value="<%=txtNombre%>">
						</td>
						<td>
							<label>Valor Compra </label>
						</td>
						<td>
							<input type="number" name="txtValorCompra" id="txtValorCompra" maxlength="50" size="50"	value="<%=txtValorCompra%>" min="0" pattern="[0-9]+">
						</td>
					</tr>
					<tr>
						<td>
							<label>NIT Proveedor </label>
						</td>
						<td>
							<input type="number" name="txtNIT" id="txtNIT" maxlength="50" size="50" placeholder="NIT Proveedor" value="<%=txtNIT%>">
						</td>
						<td>
							<label>Valor Venta </label>
						</td>
						<td>
							<input type="number" name="txtValorVenta" id="txtValorVenta" maxlength="50" size="50" value="<%=txtValorVenta%>" min="0" pattern="[0-9]+">
						</td>
					</tr>
				</table>
				<h3>
					<b>Producto encontrado.</b>
				</h3>
				<%}
		     	else
		     	{%>
					<table border="0">
						<tr>
							<td>
								<label>Codigo del Producto </label>
							</td>
							<td>
								<input type="number" name="txtCodigo" id="txtCodigo" maxlength="20" size="50" placeholder="Digite el Codigo">
							</td>
							<td>
								<label>IVA</label>
							</td>
							<td>
								<input type="number" name="txtIVA" id="txtIVA" maxlength="50" size="50" placeholder="Digite el IVA" min="0" pattern="[0-9]+">
							</td>
						</tr>
						<tr>
							<td>
								<label>Nombre del Producto </label>
							</td>
							<td>
								<input type="text" name="txtNombre" id="txtNombre" maxlength="50" size="50" placeholder="Digite el nombre">
							</td>
							<td>
							<label>Valor Compra </label>
							</td>
							<td>
								<input type="number" name="txtValorCompra" id="txtValorCompra" maxlength="50" size="50"	placeholder="Digite el valor" min="0" pattern="[0-9]+">
							</td>
						</tr>
						<tr>
							<td>
								<label>NIT Proveedor </label>
							</td>
							<td>
								<input type="number" name="txtNIT" id="txtNIT" maxlength="50" size="50" placeholder="NIT Proveedor">
							</td>
							<td>
								<label>Valor Venta </label>
							</td>
							<td>
								<input type="number" name="txtValorVenta" id="txtValorVenta" maxlength="50" size="50" placeholder="Digite el valor" min="0" pattern="[0-9]+">
							</td>
						</tr>
					</table>
					<h3>
						<b>Producto no encontrado en la base de datos.</b>
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
