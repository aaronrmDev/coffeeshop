<%@page import="sysco.coffeeshop.appManager.App"%>
<%@page import="sysco.coffeeshop.session.Session"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>

<!-- STYLE BACKGROUND -->
<style type="text/css">
html {
	background: url('../img/Background.png') no-repeat center fixed;
	background-size: cover;
	overflow: hidden;
	background-position: center center;
}
</style>
<meta charset="ISO-8859-1">
<title>CoffeeShop Session</title>
<link href="../wSession/CSSSession.css" rel="stylesheet" type="text/css">
</head>
<body>

	<div id="DivContainer">
		<div id="divSubcontainer">
			<img id="imgCoffee" src="../img/Coffee.png"> <img id="imgShop"
				src="../img/Shop.png">
		</div>
		<form class="login" method="post" action="Session">
			<div id="divSubcontainer">
				<input name="username" id="username" type="text"
					placeholder="Username">
			</div>
			<div id="divSubcontainer">
				<input name="password" id="password" type="password"
					placeholder="Password">
			</div>

			<div id="divSubcontainer">
				<input class="register" type="submit" name="sessionBut"
					value="register" /> <input class="login" type="submit"
					name="sessionBut" value="login" />
			</div>
		</form>

		<div id="divSubcontainer">
			<img alt="" src="../img/SyscoLogo.png" />
		</div>
	</div>

</body>
</html>

