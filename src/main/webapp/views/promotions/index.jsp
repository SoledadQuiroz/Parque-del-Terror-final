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
<body class="promociones">
	<main>
		<jsp:include page="/partials/header.jsp"></jsp:include>
		<div>
			<div class=" p-4 mb-3 rounded titulo_promociones">
				<h1>Estas son las Promociones del "Parque del Terror"</h1>
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
				<div class="mb-3 nueva_promocion">

					<a href="/parque_de_terror/promotions/create.do"

						class="btn btn-primary" role="button"> <i
						class="bi bi-plus-lg"></i> Nueva Promoción
					</a>
				</div>
			</c:if>

			<table class=" table table-dark opacity-75">
				<thead>
					<tr>

						<th scope="row" class="table-active column-uno">Nombre</th>
						<th scope="row" class="column-dos">Costo</th>
						<th scope="row" class="table-active column-tres">Duracion</th>
						<th scope="row" class="column-cuatro">Tipo de atracción</th>
						<th scope="row" class="table-active column-cinco">Acciones</th>
						
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${promotions}" var="promotion">

						<tr>
							<td scope="row" class="table-active">
								<!-- Button trigger modal -->
								<button type="button" class="btn btn-primary"

									onClick="modal(<c:out value="${promotion.id}"></c:out>)">
									<strong> <c:out value="${promotion.nombre}"></c:out>
									</strong>
								</button>
							</td>
							<td scope="row" class=" "><c:out value="${promotion.calculoPromocion()}"></c:out>
							</td>
							<td scope="row" class="table-active"><c:out
									value="${promotion.getTiempoPromedio()}"></c:out></td>
									<td scope="row" class=""><c:out value="${promotion.tipoAtraccion}"></c:out>
							</td>
							
							<td><c:if test="${user.admin}">
									<a
										href="/parque_de_terror/promotions/edit.do?id=${promotion.id}"
										class="btn btn-light rounded-0" role="button"><i
										class="fas fa-edit"></i></a>
									<a
										href="/parque_de_terror/promotions/delete.do?id=${promotion.id}"
										class="btn btn-danger rounded" role="button"><i
										class="fas fa-trash-alt"></i></a>
								</c:if> <c:choose>
									<c:when
										test="${user.canAffordPromocion(promotion) && user.canAttendPromocion(promotion)}">
										<a
											href="/parque_de_terror/promotions/buy.do?id=${promotion.id}"

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
					<h5 class="modal-title" id="modalAtraccionTitulo"></h5>

					<button type="button" class="btn-close  btn-light active"
						data-bs-dismiss="modal" aria-label="Close"></button>

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