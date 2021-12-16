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
			<c:if test="${flash != null}">
				<div class="alert alert-danger">
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


			<div class=" p-4 mb-3 rounded titulo_promociones">
				<h1>Usuarios</h1>
			</div>

			<c:if test="${user.isAdmin()}">
				<div class="mb-3 nueva_promocion">
					<a href="/parque_de_terror/users/create.do"
						class="btn btn-primary" role="button"> <i
						class="bi bi-plus-lg"></i> Nuevo Usuario
					</a>
				</div>
			</c:if>
			
			<table class=" table table-dark opacity-75">
				<thead>
					<tr>
						<th scope="row" class="table-active column-uno">Nombre</th>
						<th scope="row" class="column-dos">Monedas</th>
						<th scope="row" class="table-active column-tres">Tiempo</th>
						<th scope="row" class="column-cuatro">Rol</th>
						<th scope="row" class="table-active column-cinco">Acciones</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${users}" var="tmp_user">
						<tr>
							<td scope="row" class="table-active"><strong><c:out value="${tmp_user.username}"></c:out></strong></td>
							<td scope="row" class=""><c:out value="${tmp_user.coins}"></c:out></td>
							<td scope="row" class="table-active"><c:out value="${tmp_user.time}"></c:out></td>
							<td scope="row" class=""><c:choose>
									<c:when test="${tmp_user.admin}">
									Admin
								</c:when>
									<c:otherwise>
									Normal
								</c:otherwise>
								</c:choose></td>
							<td scope="row" class="table-active"><c:if
									test="${user.admin && (!tmp_user.admin || tmp_user.id == user.id)}">
									<a href="/parque_de_terror/users/edit.do?id=${tmp_user.id}"
										class="btn btn-light rounded-0" role="button"><i class="fas fa-edit"></i></a>
									<a href="/parque_de_terror/users/delete.do?id=${tmp_user.id}"
										class="btn btn-danger rounded" role="button"><i class="fas fa-trash-alt"></i></a>
								</c:if></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</main>
	<jsp:include page="/partials/footer.jsp"></jsp:include>

</body>
</html>
