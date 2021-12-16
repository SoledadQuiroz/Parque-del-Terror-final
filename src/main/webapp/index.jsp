<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<jsp:include page="partials/head.jsp"></jsp:include>

</head>
<body class="index">

	<jsp:include page="partials/header.jsp"></jsp:include>

	<main>


		<div id="carouselExampleCaptions" class="carousel slide"
			data-bs-ride="carousel">

			<div class="carousel-indicators">
				<button type="button" data-bs-target="#carouselExampleCaptions"
					data-bs-slide-to="0" class="active" aria-current="true"
					aria-label="Slide 1"></button>
				<button type="button" data-bs-target="#carouselExampleCaptions"
					data-bs-slide-to="1" aria-label="Slide 2"></button>
				<button type="button" data-bs-target="#carouselExampleCaptions"
					data-bs-slide-to="2" aria-label="Slide 3"></button>
				<button type="button" data-bs-target="#carouselExampleCaptions"
					data-bs-slide-to="3" aria-label="Slide 4"></button>
			</div>
			<div class="carousel-inner">
				<div class="carousel-item active">

					<img src="css/img/WhatsApp Image 2021-12-08 at 3.15.06 PM.jpeg"
						class="d-block w-40 carousel-img" alt="...">

				</div>
				<div class="carousel-item">
					<img src="css/img/paseo1.jpg" class="d-block w-40 carousel-img"
						alt="...">
					<div class="carousel-caption d-none d-md-block">
						<h5>Pack Adrenalina</h5>

						<p>Descubre las atracciones que te llevaran las emociones al

							extremo.</p>
					</div>
				</div>
				<div class="carousel-item">
					<img src="css/img/paseo.jpg" class="d-block w-40 carousel-img"
						alt="...">
					<div class="carousel-caption d-none d-md-block">
						<h5>Pack Paseo</h5>
						<p>Recorre estos lugares tenebrosos que te haran sentir en una
							pelicula de terror.</p>
					</div>
				</div>
				<div class="carousel-item">
					<img src="css/img/adrenalina.jpg" class="d-block w-40 carousel-img"
						alt="...">
					<div class="carousel-caption d-none d-md-block">
						<h5>Pack simulación</h5>
						<p>En estas atracciones animate a luchar con tus personajes de
							terror favoritos.</p>
					</div>
				</div>
			</div>
			<button class="carousel-control-prev" type="button"
				data-bs-target="#carouselExampleCaptions" data-bs-slide="prev">
				<span class="carousel-control-prev-icon" aria-hidden="true"></span>
				<span class="visually-hidden">Previous</span>
			</button>
			<button class="carousel-control-next" type="button"
				data-bs-target="#carouselExampleCaptions" data-bs-slide="next">
				<span class="carousel-control-next-icon" aria-hidden="true"></span>
				<span class="visually-hidden">Next</span>
			</button>
		</div>
		<div class="contenedor">
			<div class="contenedor-atraccion">
				<h2 class="titulo-atracciones">Atracciones</h2>

				<div class="btn-margin">
					<!-- Button trigger modal -->
					<button type="button" class="btn btn-outline-danger"
						data-bs-toggle="modal" data-bs-target="#mansion" id="myModal">Mansion
						Embrujada</button>

					<!-- Modal -->
					<div class="modal fade" id="mansion" tabindex="-1"
						aria-labelledby="exampleModalLabel" aria-hidden="true">
						<div class="modal-dialog modal-dialog-centered">

							<div class="modal-content modal-content1">
								<div class="modal-header">
									<h5 class="modal-title" id="exampleModalLabel">Mansion
										Embrujada</h5>
									<button type="button" class="btn-close  btn-light active"
										data-bs-dismiss="modal" aria-label="Close"></button>
								</div>
								<div class="modal-body">
									<img src="css/img/paseo1.jpg"
										class="d-block w-40 carousel-img1" alt="...">
								</div>
							</div>
						</div>
					</div>
					<!-- Button trigger modal -->
					<button type="button" class="btn btn-outline-danger"
						data-bs-toggle="modal" data-bs-target="#canibalismo" id="myModal">Canibalismo
						y Cervezas</button>


					<!-- Modal -->
					<div class="modal fade" id="canibalismo" tabindex="-1"
						aria-labelledby="exampleModalLabel" aria-hidden="true">
						<div class="modal-dialog modal-dialog-centered">

							<div class="modal-content modal-content1">
								<div class="modal-header">
									<h5 class="modal-title" id="exampleModalLabel">Canibalismo
										y Cervezas</h5>
									<button type="button" class="btn-close  btn-light active"
										data-bs-dismiss="modal" aria-label="Close"></button>
								</div>
								<div class="modal-body">
									<img src="css/img/Canibalismo_Y_Cervezas.jpg"
										class="d-block w-40 carousel-img1" alt="...">
								</div>
							</div>
						</div>
					</div>
					<!-- Button trigger modal -->
					<button type="button" class="btn btn-outline-danger"
						data-bs-toggle="modal" data-bs-target="#castillo" id="myModal">
						Castillo de Drácula</button>

					<!-- Modal -->
					<div class="modal fade" id="castillo" tabindex="-1"
						aria-labelledby="exampleModalLabel" aria-hidden="true">
						<div class="modal-dialog modal-dialog-centered">
							<div class="modal-content modal-content1">
								<div class="modal-header">
									<h5 class="modal-title" id="exampleModalLabel">Castillo de
										Drácula</h5>
									<button type="button" class="btn-close  btn-light active"
										data-bs-dismiss="modal" aria-label="Close"></button>
								</div>
								<div class="modal-body">
									<img src="css/img/Castillo_de_Dracula.jpg"
										class="d-block w-40 carousel-img1" alt="...">
								</div>
							</div>
						</div>
					</div>

				</div>
				<div class="btn-margin">
					<!-- Button trigger modal -->
					<button type="button" class="btn btn-outline-danger"
						data-bs-toggle="modal" data-bs-target="#posada" id="myModal">Posada
						de Hades</button>

					<!-- Modal -->
					<div class="modal fade" id="posada" tabindex="-1"
						aria-labelledby="exampleModalLabel" aria-hidden="true">
						<div class="modal-dialog modal-dialog-centered">
							<div class="modal-content modal-content1">
								<div class="modal-header">
									<h5 class="modal-title" id="exampleModalLabel">Posada de
										Hades</h5>
									<button type="button" class="btn-close  btn-light active"
										data-bs-dismiss="modal" aria-label="Close"></button>
								</div>
								<div class="modal-body">
									<img src="css/img/Posada_de_Hades.jpg"
										class="d-block w-40 carousel-img1" alt="...">
								</div>
							</div>
						</div>
					</div>
					<!-- Button trigger modal -->
					<button type="button" class="btn btn-outline-danger"
						data-bs-toggle="modal" data-bs-target="#bosque" id="myModal">Bosque
						Encantado</button>

					<!-- Modal -->
					<div class="modal fade" id="bosque" tabindex="-1"
						aria-labelledby="exampleModalLabel" aria-hidden="true">
						<div class="modal-dialog modal-dialog-centered">
							<div class="modal-content modal-content1">
								<div class="modal-header">
									<h5 class="modal-title" id="exampleModalLabel">Bosque
										Encantado</h5>
									<button type="button" class="btn-close  btn-light active"
										data-bs-dismiss="modal" aria-label="Close"></button>
								</div>
								<div class="modal-body">
									<img src="css/img/Bosque_encantado.jpg"
										class="d-block w-40 carousel-img1" alt="...">
								</div>
							</div>
						</div>
					</div>
					<!-- Button trigger modal -->
					<button type="button" class="btn btn-outline-danger"
						data-bs-toggle="modal" data-bs-target="#tren" id="myModal">Tren
						Fantasma</button>

					<!-- Modal -->
					<div class="modal fade" id="tren" tabindex="-1"
						aria-labelledby="exampleModalLabel" aria-hidden="true">
						<div class="modal-dialog modal-dialog-centered">
							<div class="modal-content modal-content1">
								<div class="modal-header">
									<h5 class="modal-title" id="exampleModalLabel">Tren
										Fantasma</h5>
									<button type="button" class="btn-close  btn-light active"
										data-bs-dismiss="modal" aria-label="Close"></button>
								</div>
								<div class="modal-body">
									<img src="css/img/Tren_Fantasma.jpg"
										class="d-block w-40 carousel-img1" alt="...">
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="btn-margin">
					<!-- Button trigger modal -->
					<button type="button" class="btn btn-outline-danger"
						data-bs-toggle="modal" data-bs-target="#lago" id="myModal">Lago
						del Terror</button>

					<!-- Modal -->
					<div class="modal fade" id="lago" tabindex="-1"
						aria-labelledby="exampleModalLabel" aria-hidden="true">
						<div class="modal-dialog modal-dialog-centered">
							<div class="modal-content modal-content1">
								<div class="modal-header">
									<h5 class="modal-title" id="exampleModalLabel">Lago del
										Terror</h5>
									<button type="button" class="btn-close  btn-light active"
										data-bs-dismiss="modal" aria-label="Close"></button>
								</div>
								<div class="modal-body">
									<img src="css/img/Lago_del_Terror.jpg"
										class="d-block w-40 carousel-img1" alt="...">
								</div>
							</div>
						</div>
					</div>
					<!-- Button trigger modal -->
					<button type="button" class="btn btn-outline-danger"
						data-bs-toggle="modal" data-bs-target="#sangre" id="myModal">Sangre
						y Dolor</button>

					<!-- Modal -->
					<div class="modal fade" id="sangre" tabindex="-1"
						aria-labelledby="exampleModalLabel" aria-hidden="true">
						<div class="modal-dialog modal-dialog-centered">
							<div class="modal-content modal-content1">
								<div class="modal-header">
									<h5 class="modal-title" id="exampleModalLabel">Sangre y
										Dolor</h5>
									<button type="button" class="btn-close  btn-light active"
										data-bs-dismiss="modal" aria-label="Close"></button>
								</div>
								<div class="modal-body">
									<img src="css/img/Sangre_y_Dolor.jpg"
										class="d-block w-40 carousel-img1" alt="...">
								</div>
							</div>
						</div>
					</div>
					<!-- Button trigger modal -->
					<button type="button" class="btn btn-outline-danger"
						data-bs-toggle="modal" data-bs-target="#nido" id="myModal">Nido
						Dragon</button>

					<!-- Modal -->
					<div class="modal fade" id="nido" tabindex="-1"
						aria-labelledby="exampleModalLabel" aria-hidden="true">
						<div class="modal-dialog modal-dialog-centered">
							<div class="modal-content modal-content1">
								<div class="modal-header">
									<h5 class="modal-title" id="exampleModalLabel">Nido Dragon</h5>
									<button type="button" class="btn-close  btn-light active"
										data-bs-dismiss="modal" aria-label="Close"></button>
								</div>
								<div class="modal-body">
									<img src="css/img/Nido_dragon.jpg"
										class="d-block w-40 carousel-img1" alt="...">
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="btn-margin">
					<!-- Button trigger modal -->
					<button type="button" class="btn btn-outline-danger"
						data-bs-toggle="modal" data-bs-target="#dark" id="myModal">Dark
						Castle</button>

					<!-- Modal -->
					<div class="modal fade" id="dark" tabindex="-1"
						aria-labelledby="exampleModalLabel" aria-hidden="true">
						<div class="modal-dialog modal-dialog-centered">
							<div class="modal-content modal-content1">
								<div class="modal-header">
									<h5 class="modal-title" id="exampleModalLabel">Dark Castle</h5>
									<button type="button" class="btn-close  btn-light active"
										data-bs-dismiss="modal" aria-label="Close"></button>
								</div>
								<div class="modal-body">
									<img src="css/img/DarKastleMA.jpg"
										class="d-block w-40 carousel-img1" alt="...">
								</div>
							</div>
						</div>
					</div>
					<!-- Button trigger modal -->
					<button type="button" class="btn btn-outline-danger"
						data-bs-toggle="modal" data-bs-target="#invisibles" id="myModal">Invisibles</button>

					<!-- Modal -->
					<div class="modal fade" id="invisibles" tabindex="-1"
						aria-labelledby="exampleModalLabel" aria-hidden="true">
						<div class="modal-dialog modal-dialog-centered">
							<div class="modal-content modal-content1">
								<div class="modal-header">
									<h5 class="modal-title" id="exampleModalLabel">Invisibles</h5>
									<button type="button" class="btn-close  btn-light active"
										data-bs-dismiss="modal" aria-label="Close"></button>
								</div>
								<div class="modal-body">
									<img src="css/img/InvisiblesMA.jpg"
										class="d-block w-40 carousel-img1" alt="...">
								</div>
							</div>
						</div>
					</div>
					<!-- Button trigger modal -->
					<button type="button" class="btn btn-outline-danger"
						data-bs-toggle="modal" data-bs-target="#laberinto" id="myModal">Laberinto</button>

					<!-- Modal -->
					<div class="modal fade" id="laberinto" tabindex="-1"
						aria-labelledby="exampleModalLabel" aria-hidden="true">
						<div class="modal-dialog modal-dialog-centered">
							<div class="modal-content modal-content1">
								<div class="modal-header">
									<h5 class="modal-title" id="exampleModalLabel">Laberinto</h5>
									<button type="button" class="btn-close  btn-light active"
										data-bs-dismiss="modal" aria-label="Close"></button>
								</div>
								<div class="modal-body">
									<img src="css/img/Laberinto.jpg"
										class="d-block w-40 carousel-img1" alt="...">
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="contenedor-promocion">
				<h2 class="titulo-atracciones">Promociones</h2>
				<div class="btn-margin">


					<!-- Button trigger modal -->
					<button type="button" class="btn btn-outline-danger"
						data-bs-toggle="modal" data-bs-target="#degustacion" id="myModal">Pack
						Degustación</button>

					<!-- Modal -->
					<div class="modal fade" id="degustacion" tabindex="-1"
						aria-labelledby="exampleModalLabel" aria-hidden="true">
						<div class="modal-dialog modal-dialog-centered">
							<div class="modal-content modal-content1">
								<div class="modal-header">
									<h5 class="modal-title" id="exampleModalLabel">Pack
										Degustación</h5>
									<button type="button" class="btn-close  btn-light active"
										data-bs-dismiss="modal" aria-label="Close"></button>
								</div>
								<div class="modal-body">
									<img src="css/img/degustacion.jpg"
										class="d-block w-40 carousel-img1" alt="...">
								</div>
							</div>
						</div>
					</div>
					<!-- Button trigger modal -->
					<button type="button" class="btn btn-outline-danger"
						data-bs-toggle="modal" data-bs-target="#adrenalina" id="myModal">Pack

						Adrenalina</button>

					<!-- Modal -->
					<div class="modal fade" id="adrenalina" tabindex="-1"
						aria-labelledby="exampleModalLabel" aria-hidden="true">
						<div class="modal-dialog modal-dialog-centered">
							<div class="modal-content modal-content1">
								<div class="modal-header">
									<h5 class="modal-title" id="exampleModalLabel">Pack
										Adrenalina</h5>
									<button type="button" class="btn-close  btn-light active"
										data-bs-dismiss="modal" aria-label="Close"></button>
								</div>
								<div class="modal-body">
									<img src="css/img/adrenalina.jpg"
										class="d-block w-40 carousel-img1" alt="...">
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="btn-margin">

					<!-- Button trigger modal -->
					<button type="button" class="btn btn-outline-danger"
						data-bs-toggle="modal" data-bs-target="#simulacion" id="myModal">Pack
						Simulación</button>

					<!-- Modal -->
					<div class="modal fade" id="simulacion" tabindex="-1"
						aria-labelledby="exampleModalLabel" aria-hidden="true">
						<div class="modal-dialog modal-dialog-centered">
							<div class="modal-content modal-content1">
								<div class="modal-header">
									<h5 class="modal-title" id="exampleModalLabel">Pack
										Simulación</h5>
									<button type="button" class="btn-close  btn-light active"
										data-bs-dismiss="modal" aria-label="Close"></button>
								</div>
								<div class="modal-body">
									<img src="css/img/navy_blue.png"
										class="d-block w-40 carousel-img1" alt="...">
								</div>
							</div>
						</div>
					</div>
					<!-- Button trigger modal -->
					<button type="button" class="btn btn-outline-danger"
						data-bs-toggle="modal" data-bs-target="#paseo1" id="myModal">Pack Paseo</button>

					<!-- Modal -->
					<div class="modal fade" id="paseo1" tabindex="-1"
						aria-labelledby="exampleModalLabel" aria-hidden="true">
						<div class="modal-dialog modal-dialog-centered">
							<div class="modal-content modal-content1">
								<div class="modal-header">
									<h5 class="modal-title" id="exampleModalLabel">Pack Paseo</h5>
									<button type="button" class="btn-close  btn-light active"
										data-bs-dismiss="modal" aria-label="Close"></button>
								</div>
								<div class="modal-body">
									<img src="css/img/paseo1.jpg" class="d-block w-40 carousel-img1"
										alt="...">
								</div>
							</div>
						</div>
					</div>


				</div>
			</div>
		</div>
	</main>
	<!-- Footer -->
	<jsp:include page="partials/footer.jsp"></jsp:include>

</body>
</html>