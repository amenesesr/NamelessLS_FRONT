<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="shortcut icon" href="IMG/favicon.png" type="image/x-icon" />
<title>Nameless LS - Login</title>
<link href="https://fonts.googleapis.com/css2?family=Anton&family=Ubuntu&display=swap" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="CSS/estilo.css">
</head>
<body>
	<header>
		<img class="header" src="IMG/titulo.png" alt="Nameless Liquor Store">
	</header>
	<div>
		<form class="formulario" method="get" action="./IndexServlet">
			<br>
			<br>
			<center>
				<h2>Bienvenido a Nameless Liquor Store</h2>
				<table border="0">
					<tr>
						<td><label>Usuario </label></td>
						<td><input type="text" maxlength="50" name="txtUsuario"
							id="txtUsuario" size="50" placeholder="Digite el usuario"
							required></td>
					</tr>
					<tr>
						<td><label>Contraseña </label></td>
						<td><input type="password" maxlength="50" name="txtPassword"
							id="txtPassword" placeholder="Contraseña" required></td>
					</tr>
					<tr>
						<td></td>
						<td><input type="checkbox" onclick=verPassword()><label>Mostrar
								Contraseña</label></td>
					</tr>
				</table>
				<p class="indexError">.</p>
				<td><input type="submit" name="btnAceptar" id="btnAceptar"
					value="Aceptar" class="button"></td>
				<td><input type="reset" name="btnCancelar" id="btnCancelar"
					value="Cancelar" class="button"></td>
			</center>
			<br>
			<br>
		</form>
	</div>
	<footer>
		<img class="footer" src="IMG/footer.png" alt="Nameless Liquor Store">
	</footer>
</body>

<script type="text/javascript" src="JS/funciones.js"></script>
</html>
