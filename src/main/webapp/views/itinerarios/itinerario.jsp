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
<body class="atraccion">
	<main>
		<jsp:include page="/partials/header.jsp"></jsp:include>

		<div>
			<div class=" p-4 mb-3 rounded titulo_promociones">
				<h1>Este es su itinerario</h1>
			</div>
			<c:if test="${flash != null}">
				<div class="alert alert-danger"
					style="width: 80%; margin: 20px auto;">
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

			<table class=" table table-dark opacity-75">
				<thead>
					<tr>
						<th scope="row" class="table-active column-uno">Atracciones compradas</th>
						<th scope="row" class="column-dos">Promociones
							compradas</th>

					</tr>
				</thead>
				<tbody>
					<c:forEach items="${itinerarios}" var="itinerario">
						<tr>
							<td scope="row" class="table-active"><c:out
									value="${itinerario.atracciones}"></c:out></td>
							<td scope="row" class="table-active"><c:out
									value="${itinerario.promociones}"></c:out></td>

						</tr>
					</c:forEach>
				</tbody>
			</table>

		</div>
	</main>

	<jsp:include page="/partials/footer.jsp"></jsp:include>




</body>
</html>