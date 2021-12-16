<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="partials/head.jsp"></jsp:include>
<link href="../css/style.css" rel="stylesheet" />
</head>
<body class="login">
	<main>
		<section class="form-login">
			<form class=""
				<c:if test="${flash != null }">
				action="../login"
			</c:if>
				action="login" method="post">
				<div>
					<h1>Parque del Terror</h1>
				</div>
				<c:if test="${flash != null}">
					<div class="alert alert-danger">
						<p>
							<c:out value="${flash}" />
						</p>
					</div>
				</c:if>
				<c:if test="${success != null}">
					<div class="alert alert-success">
						<p>
							<c:out value="${success}" />
						</p>
					</div>
				</c:if>
				<div>
					<label class="label" for="username"> <input
						class="controls" type="text" name="username" placeholder="Usuario"
						required>
					</label>

				</div>
				<div>
					<label class="label" for="password"> <input
						class="controls" type="password" name="password"
						placeholder="Contraseña" required>
					</label>

				</div>
				<div>
					<input class="botons btn btn-outline-danger" type="submit"
						value="Iniciar Sesión">
				</div>
				<div>
					<h6>
						<a style="color: white"
							<c:choose>
								<c:when test="${flash != null }">
									href="../index.jsp"
								</c:when>
								<c:otherwise>
									href="index.jsp"
								</c:otherwise>
								</c:choose>
							>Volver
						</a>
					</h6>
				</div>
			</form>
		</section>
	</main>
</body>
</html>