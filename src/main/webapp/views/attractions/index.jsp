<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<jsp:include page="/partials/head.jsp"></jsp:include>
<link href="../css/style.css" rel="stylesheet" />
<script type="text/javascript" src="../js/javascript.js" defer></script>
</head>
<body class="atracciones">
	<main>
		<jsp:include page="/partials/header.jsp"></jsp:include>
		<div class="bienvenido">
			<h1>
				¡Bienvenido,
				<c:out value="${user.username}" />
				!
			</h1>
		</div>
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
				<button type="button" data-bs-target="#carouselExampleCaptions"
					data-bs-slide-to="4" aria-label="Slide 5"></button>
				<button type="button" data-bs-target="#carouselExampleCaptions"
					data-bs-slide-to="5" aria-label="Slide 6"></button>
				<button type="button" data-bs-target="#carouselExampleCaptions"
					data-bs-slide-to="6" aria-label="Slide 7"></button>
				<button type="button" data-bs-target="#carouselExampleCaptions"
					data-bs-slide-to="7" aria-label="Slide 8"></button>
				<button type="button" data-bs-target="#carouselExampleCaptions"
					data-bs-slide-to="8" aria-label="Slide 9"></button>
				<button type="button" data-bs-target="#carouselExampleCaptions"
					data-bs-slide-to="9" aria-label="Slide 10"></button>
				<button type="button" data-bs-target="#carouselExampleCaptions"
					data-bs-slide-to="10" aria-label="Slide 11"></button>
				<button type="button" data-bs-target="#carouselExampleCaptions"
					data-bs-slide-to="11" aria-label="Slide 12"></button>

			</div>
			<div class="carousel-inner">
				<div class="carousel-item active">
					<img src="../css/img/Bosque_encantado.jpg"
						class="d-block w-40  carousel-img" alt="...">
					<div class="carousel-caption d-none d-md-block">
						<h5>Bosque encantado</h5>
						<p>Adentrate al bosque magico, lleno de misterio y aventura.</p>
					</div>
				</div>
				<div class="carousel-item">
					<img src="../css/img/Canibalismo_Y_Cervezas.jpg"
						class="d-block w-40  carousel-img" alt="centre">
					<div class="carousel-caption d-none d-md-block">
						<h5>Canibalismo Y Cervezas</h5>
						<p>Prapara tu garganta para las bebidas mas fuertes y los
							platos mas putrefactos del bosque.</p>
					</div>
				</div>
				<div class="carousel-item">
					<img src="../css/img/Castillo_de_Dracula.jpg"
						class="d-block w-40  carousel-img" alt="...">
					<div class="carousel-caption d-none d-md-block">
						<h5>Castillo de Dracula</h5>
						<p>Descubre el gran secreto del conde! y sobrevive para
							contarlo.</p>
					</div>
				</div>
				<div class="carousel-item">
					<img src="../css/img/DarKastleMA.jpg"
						class="d-block w-40  carousel-img" alt="...">
					<div class="carousel-caption d-none d-md-block">
						<h5>DarKastle</h5>
						<p>Disfruta de la tecnologia de punta y adentrate en el gran
							castillo con lo ultimo en RV.</p>
					</div>
				</div>
				<div class="carousel-item">
					<img src="../css/img/InvisiblesMA.jpg"
						class="d-block w-40 carousel-img" alt="...">
					<div class="carousel-caption d-none d-md-block">
						<h5>Invisibles</h5>
						<p>Invisibles, una experiencia unica audiovisual, con lo
							ultimo en RV.</p>
					</div>
				</div>
				<div class="carousel-item">
					<img src="../css/img/Laberinto.jpg"
						class="d-block w-40 carousel-img" alt="...">
					<div class="carousel-caption d-none d-md-block">
						<h5>Laberinto</h5>
						<p>Pon a prueba tu orientacion y resistencia en este increible
							reto.</p>
					</div>
				</div>
				<div class="carousel-item">
					<img src="../css/img/Lago_del_Terror.jpg"
						class="d-block w-40 carousel-img" alt="...">
					<div class="carousel-caption d-none d-md-block">
						<h5>Lago del Terror</h5>
						<p>Mira bien donde caminas y vigila bien tu espalda, en el
							lago mas traicionero en kilometros.</p>
					</div>
				</div>
				<div class="carousel-item">
					<img src="../css/img/Mansion_EmbrujadaMA.jpg"
						class="d-block w-40  carousel-img" alt="...">
					<div class="carousel-caption d-none d-md-block">
						<h5>Mansion Embrujada</h5>
						<p>Resistira tu corazon? aguanta todo lo que puedas demtro de
							la mansion y difrutala con lo ultimo en RV.</p>
					</div>
				</div>
				<div class="carousel-item">
					<img src="../css/img/Nido_dragon.jpg"
						class="d-block w-40  carousel-img" alt="...">
					<div class="carousel-caption d-none d-md-block">
						<h5>Nido Dragon</h5>
						<p>Confias en tu sigilo? adentrate en la cueva en busca de los
							mas grandes tesoros, pero sin hacer ruido...</p>
					</div>
				</div>
				<div class="carousel-item">
					<img src="../css/img/Posada_de_Hades.jpg"
						class="d-block w-40  carousel-img" alt="...">
					<div class="carousel-caption d-none d-md-block">
						<h5>Posada de Hades</h5>
						<p>Tomate un descanso, bebe y come como los dioses!</p>
					</div>
				</div>
				<div class="carousel-item">
					<img src="../css/img/Sangre_y_Dolor.jpg"
						class="d-block w-40  carousel-img" alt="...">
					<div class="carousel-caption d-none d-md-block">
						<h5>Sangre y Dolor</h5>
						<p>De los tragos mas mortales del bosque, Aguantaras?.</p>
					</div>
				</div>
				<div class="carousel-item">
					<img src="../css/img/Tren_Fantasma.jpg"
						class="d-block w-40  carousel-img" alt="...">
					<div class="carousel-caption d-none d-md-block">
						<h5>Tren Fantasma</h5>
						<p>Emprende un viaje que tal vez... no puedas terminar.</p>
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
		<div>


			<div class=" p-4 mb-3 rounded titulo_atracciones">
				<h1>Estas son las atracciones del "Parque del Terror"</h1>
			</div>
			<c:if test="${flash != null}">
				<div class="alert alert-danger" style="width:80%; margin:20px auto;">
					<p>
						<c:out value="${flash}" />
						<c:if test="${errors != null}">
							<ul>
								<c:forEach items="${errors}" var="entry">
									<li><c:out value="${entry.getValue()}"></c:out></li>
								</c:forEach>
							</ul>
						</c:if>
					</p>
				</div>
			</c:if>

			<c:if test="${user.isAdmin()}">
				<div class="mb-3 nueva_atraccion">
					<a href="/parque_de_terror/attractions/create.do"
						class="btn btn-primary" role="button"> <i
						class="bi bi-plus-lg"></i> Nueva Atracción
					</a>
				</div>
			</c:if>

			<table class=" table table-dark opacity-75">
				<thead>
					<tr>
						<th scope="row" class="table-active column-uno">Nombre y
							Descripcion</th>
						<th scope="row" class="column-dos">Costo</th>
						<th scope="row" class="table-active column-tres">Duracion</th>
						<th scope="row" class="column-cuatro">Cupo</th>
						<th scope="row" class="table-active column-cinco">Acciones</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${attractions}" var="attraction">
						<tr>
							<td scope="row" class="table-active">
								<!-- Button trigger modal -->
								<button type="button" class="btn btn-primary"
									onClick="modal(<c:out value="${attraction.id}"></c:out>)">
									<strong> <c:out value="${attraction.name}"></c:out>
									</strong>
								</button>
							</td>
							<td scope="row"class""><c:out value="${attraction.cost}"></c:out>
							</td>
							<td scope="row" class="table-active"><c:out
									value="${attraction.duration}"></c:out></td>
							<td scope="row" class=""><c:out
									value="${attraction.capacity}">
								</c:out></td>
							<td><c:if test="${user.admin}">
									<a
										href="/parque_de_terror/attractions/edit.do?id=${attraction.id}"
										class="btn btn-light rounded-0" role="button">
										<i class="fas fa-edit"></i></a>
									<a
										href="/parque_de_terror/attractions/delete.do?id=${attraction.id}"
										class="btn btn-danger rounded" role="button">
										<i class="fas fa-trash-alt"></i></a>
								</c:if> <c:choose>
									<c:when
										test="${user.canAfford(attraction) && user.canAttend(attraction) && attraction.canHost(1)}">
										<a
											href="/parque_de_terror/attractions/buy.do?id=${attraction.id}"
											class="btn btn-success rounded" role="button">Comprar</a>
									</c:when>
									<c:otherwise>
										<a href="#" class="btn btn-secondary rounded disabled"
											role="button">No se puede comprar</a>
									</c:otherwise>
								</c:choose></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>

		</div>
	</main>

	<jsp:include page="/partials/footer.jsp"></jsp:include>

	<div class="modal fade" id="modalAtraccion" data-bs-backdrop="static"
		data-bs-keyboard="false" tabindex="-1"
		aria-labelledby="staticBackdropLabel" aria-hidden="true">
		<div class="modal-dialog modal-dialog-centered">

			<div class="modal-content">
				<div class="modal-header">
					<strong><h5 class="modal-title" id="modalAtraccionTitulo"></h5></strong>
					<button type="button" class="btn-close  btn-light active" data-bs-dismiss="modal"
						aria-label="Close"></button>
				</div>
				<div class="modal-body" id="modalAtraccionCuerpo"></div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-bs-dismiss="modal">Cerrar</button>
					<button type="button" class="btn btn-success rounded">Comprar</button>
				</div>
			</div>

		</div>
	</div>
	

</body>
</html>