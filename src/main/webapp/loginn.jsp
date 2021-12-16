<!DOCTYPE html>
<html lang="en" dir="ltr">
<head>

<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.8.1/css/all.css"
	integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf"
	crossorigin="anonymous">
<link href="css/style.css" rel="stylesheet" />
<title>Formulario Login</title>

</head>

<body class="logueo">

	<header>
		<nav class="navbar navbar-expand-lg navbar-dark opacity-75 bg-dark">
			<div class="container-fluid">
				<a class="navbar-brand" href="#">Parque del Terror</a>
				<button class="navbar-toggler" type="button"
					data-bs-toggle="collapse" data-bs-target="#navbarNavAltMarkup"
					aria-controls="navbarNavAltMarkup" aria-expanded="false"
					aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>
				<div class="collapse navbar-collapse" id="navbarNavAltMarkup">
					<div class="navbar-nav">
						<a class="nav-link" aria-current="page" href="index.jsp">Inicio</a>
						<a class="nav-link" href="atracciones.jsp">Atracciones</a> <a
							class="nav-link" href="promociones.jsp">Promociones</a> <a
							class="nav-link" href="#" tabindex="-1" aria-disabled="true">Mi
							Cuenta</a> <a class="nav-link active" href="login.jsp">Ingresar</a>
						</h2>
						<a class="nav-link" href="registro.jsp">Registrar</a>
						</h2>
					</div>
				</div>
			</div>
		</nav>
	</header>

	<main>
		<section class="form-login">
			<form class="" action="index.jsp" method="post">
				<h4>Bienvenido al "Parque del Terror"</h4>
				<input class="controls" type="text" name="usuario" value=""
					placeholder="Usuario" required> <input class="controls"
					type="password" name="contrasena" value="" placeholder="Contraseña"
					required> <input class="botons btn btn-outline-danger"
					type="submit" value="Iniciar Sesión">
				<p>
					<a href="recu_pass.jsp">¿Olvidaste tu Contraseña?</a>
				</p>
				<h6>
					<a style="color: white" href="index.jsp">Volver</a>
				</h6>
			</form>
		</section>
	</main>

	<footer class=" opacity-75">
		<div class="footer">
			<ul class="main">
				<li class="boton-fb"><a href="http://www.facebook.com/"><i
						class="fab fa-facebook-f"></i>Facebook</a></li>
				<li class="boton-tw"><a href="#"><i class="fab fa-twitter"></i>Twitter</a>
				</li>
				<li class="boton-ig"><a href="#"><i
						class="fab fa-instagram"></i>Instagram</a></li>
				<li class="boton-wsp"><a href="#"><i
						class="fab fa-whatsapp"></i>WhatsApp</a></li>
			</ul>
		</div>
		<div class="footer-copyright text-center py-3">
			<p>
				<small>© 2021 Copyright: Todos los Derechos Reservados</small>
			</p>
		</div>
	</footer>

	<script src="./js/javascript.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
		crossorigin="anonymous"></script>

</body>
</html>