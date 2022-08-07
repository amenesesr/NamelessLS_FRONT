<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ page import='java.util.Date'%>
<%@ page import='co.edu.unbosque.nameless.Ventas'%>
<%@ page import='co.edu.unbosque.nameless.Clientes'%>
<%@ page import='java.util.ArrayList'%>
<html>
<head>
<meta charset="UTF-8">
<link rel="shortcut icon" href="IMG/favicon.png" type="image/x-icon" />
<title>Nameless LS - Ventas por Cliente</title>
<link href="https://fonts.googleapis.com/css2?family=Anton&family=Ubuntu&display=swap"rel="stylesheet">
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
			<h1>
				Total de Ventas por Cliente
			</h1>
			<h4>
				Hora servidor: <%= new Date() %>
			</h4>
			<table border="5">
					<td>
						Cedula
					</td>
					<td>
						Nombre
					</td>
					<td>
						Valor Total Ventas
					</td>
				</tr>
				
					<tr><% ArrayList<Ventas> listaVentas = (ArrayList<Ventas>) request.getAttribute("listaVentas");
						double txtTotalVentas = 0;	
						for (Ventas venta : listaVentas)
						{%>
							<tr>
								<td><%=venta.getCedula_clientes()%></td>
								<%ArrayList<Clientes> listaClientes = (ArrayList<Clientes>) request.getAttribute("listaClientes");
									for (Clientes cliente : listaClientes)
									{
										if (cliente.getCedula_clientes() == venta.getCedula_clientes())
										{%>
								<td><%=cliente.getNombre_clientes()%></td>
										<%break;
										}
									}%>
								<td><%=venta.getTotal_venta_ventas()%></td>
							</tr>
						<%
						txtTotalVentas = txtTotalVentas + venta.getTotal_venta_ventas();
						}%>
				</table>
		</center>
		<table class="tablaventas">
			<tr>
				<td class="tdventas">
					Total Ventas $
				</td>
				<td>
					<input type="text" name="txtTotalVentas" id="txtTotalVentas" value="<%=txtTotalVentas%>" maxlength="40" size="40" disabled>
				</td>
			</tr>
		</table>
		<br>
		<br>
	</form>
	<footer>
		<img class="footer" src="IMG/footer.png" alt="Nameless Liquor Store">
	</footer>
</body>
</html>
