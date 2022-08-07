<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="shortcut icon" href="IMG/favicon.png" type="image/x-icon" />
<title>Nameless LS - Ventas</title>
<link href="https://fonts.googleapis.com/css2?family=Anton&family=Ubuntu&display=swap" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="CSS/estiloventas.css">
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
		<li><a href="ventas.jsp" class="active">Ventas</a></li>
		<li><a href="reportes.jsp">Reportes</a></li>
		<li><a href="index.jsp">Salir</a></li>
	</ul>
	<form class=formulario method="get" action="./VentasServlet">
		<div>
			<br>
			<% 
		      	long txtCedula = (Long) request.getAttribute("txtCedula");
				String txtCliente = (String) request.getAttribute("txtCliente");
				Long txtConsecutivo = (Long) request.getAttribute("txtConsecutivo");
				
				long txtCodProd1 = (Long) request.getAttribute("txtCodProd1");
				String txtNomProd1 = (String) request.getAttribute("txtNomProd1");
				double txtValProd1 = (Double) request.getAttribute("txtValProd1");
		    	int txtCantidad1 = (Integer) request.getAttribute("txtCantidad1");
		    	double txtValorTotal1 = (Double) request.getAttribute("txtValorTotal1");
		    	
		    	long txtCodProd2 = (Long) request.getAttribute("txtCodProd2");
		    	String txtNomProd2 = (String) request.getAttribute("txtNomProd2");
				double txtValProd2 = (Double) request.getAttribute("txtValProd2");
		    	int txtCantidad2 = (Integer) request.getAttribute("txtCantidad2");
		    	double txtValorTotal2 = (Double) request.getAttribute("txtValorTotal2");
		    	
		    	long txtCodProd3 = (Long) request.getAttribute("txtCodProd3");
		    	String txtNomProd3 = (String) request.getAttribute("txtNomProd3");
				double txtValProd3 = (Double) request.getAttribute("txtValProd3");
		    	int txtCantidad3 = (Integer) request.getAttribute("txtCantidad3");
		    	double txtValorTotal3 = (Double) request.getAttribute("txtValorTotal3");
		    	
		    	double txtTotalIva = (Double) request.getAttribute("txtTotalIva");
		    	double txtTotalVenta = (Double) request.getAttribute("txtTotalVenta");
		    	double txtTotalConIva = (Double) request.getAttribute("txtTotalConIva");
		    	
			%>
			<center>
			<table>
				<tr>
					<td>
						<label>Cedula</label>
					</td>
					<td>
						<input type="number" maxlength="20" name="txtCedula" id="txtCedula" size="10" value=<%=txtCedula%> >
					</td>
					<td>
						<label>Cliente</label>
					</td>
					<td>
						<input type="text" name="txtCliente" id="txtCliente" maxlength="200" size="25" value="<%=txtCliente%>" disabled>
					</td>
					<td>
						<label>Consec.</label>
					</td>
					<td>
						<input type="number" name="txtConsecutivo" id="txtConsecutivo" maxlength="20" size="20" disabled value="<%=txtConsecutivo%>">
					</td>
				</tr>
			</table>
			<br>

			<table>
				<tr>
					<td>
						<label>Cod. Producto</label>
					</td>
					<td>
						<label>Cant.</label>
					</td>
					<td>
						<label></label>
					</td>
					<td>
						<label>Nombre Producto</label>
					</td>
					<td>
						<label>Valor Producto</label>
					</td>
					<td>
						<label>Vlr. Total</label>
					</td>
				</tr>

				<tr>
					<td>
						<input type="number" name="txtCodProd1" id="txtCodProd1" maxlength="20" size="20" placeholder="Codigo del Producto" value="<%=txtCodProd1%>">
					</td>
					<td>
						<input type="number" name="txtCantidad1" id="txtCantidad1" maxlength="8" size="6" value="<%=txtCantidad1%>" placeholder="Cantidad" min="0" pattern="[0-9]+">
					</td>
					<td rowspan="3">
						<input type="submit" name="btnConsultarProducto" id="btnConsultarProducto" value="Consultar" class="button1">
					</td>
					<td>
						<input type="text" name="txtNomProd1" id="txtNomProd1" maxlength="50" size="30" disabled placeholder="Nombre del Producto" value="<%=txtNomProd1%>">
					</td>
					<td>
						<input type="number" name="txtValProd1" id="txtValProd1" maxlength="50" size="6" disabled value="<%=txtValProd1%>">
					</td>
					<td>
						<input type="number" name="txtValorTotal1" id="txtValorTotal1" maxlength="50" size="10" disabled value="<%=txtValorTotal1%>">
					</td>
				</tr>

				<tr>
					<td>
						<input type="number" name="txtCodProd2" id="txtCodProd2" maxlength="20" size="20" placeholder="Codigo del Producto" value="<%=txtCodProd2%>">
					</td>
					<td>
						<input type="number" name="txtCantidad2" id="txtCantidad2" maxlength="8" size="6"  value="<%=txtCantidad2%>" placeholder="Cantidad"  min="0" pattern="[0-9]+">
					</td>		
					<td>
						<input type="text" name="txtNomProd2" id="txtNomProd2" maxlength="50" size="30" disabled placeholder="Nombre del Producto" value="<%=txtNomProd2%>">
					</td>
					<td>
						<input type="number" name="txtValProd2" id="txtValProd2" maxlength="50" size="6" disabled value="<%=txtValProd2%>">
					</td>
					<td>
						<input type="number" name="txtValorTotal2" id="txtValorTotal2" maxlength="50" size="10" disabled value="<%=txtValorTotal2%>">
					</td>
				</tr>

				<tr>
					<td>
						<input type="number" name="txtCodProd3" id="txtCodProd3" maxlength="20" size="20" placeholder="Codigo del Producto" value="<%=txtCodProd3%>">
					</td>
					<td>
						<input type="number" name="txtCantidad3" id="txtCantidad3" maxlength="8" size="6" value="<%=txtCantidad3%>" placeholder="Cantidad"  min="0" pattern="[0-9]+">
					</td>
					<td>
						<input type="text" name="txtNomProd3" id="txtNomProd3" maxlength="50" size="30" disabled placeholder="Nombre del Producto" value="<%=txtNomProd3%>">
					</td>
					<td>
						<input type="number" name="txtValProd3" id="txtValProd3" maxlength="50" size="6" disabled value="<%=txtValProd3%>">
					</td>
					<td>
						<input type="number" name="txtValorTotal3" id="txtValorTotal3" maxlength="50" size="10" disabled value="<%=txtValorTotal3%>">
					</td>
				</tr>
			</table>
			<br>
			</center>
			<table class="tablaventas3">
				<tr>
					<td rowspan="3">
						<input type="submit" name="btnConfirmar" value="Confirmar" class="button1">
					</td>
					<td>
						<label>Total Venta </label>
					</td>
					<td>
						<input type="number" name="txtTotalVenta" id="txtTotalVenta" maxlength="20" size="10" disabled value="<%=txtTotalVenta%>">
					</td>
				</tr>
				<tr>
					<td>
						<label>Total IVA </label>
					</td>
					<td>
						<input type="number" name="txtTotalIva" id="txtTotalIva" maxlength="20" size="10" disabled value="<%=txtTotalIva%>">
					</td>
				</tr>
				<tr>
					<td>
						<label>Total con IVA </label>
					</td>
					<td>
						<input type="number" name="txtTotalConIva" id="txtTotalConIva" maxlength="20" size="10" disabled value="<%=txtTotalConIva%>">
					</td>
				</tr>
			</table>
			<br>
		</div>
	</form>
	<footer>
		<img class="footer" src="IMG/footer.png" alt="Nameless Liquor Store">
	</footer>
</body>
</html>
