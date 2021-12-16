<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="/partials/head.jsp"></jsp:include>
<link href="../css/style.css" rel="stylesheet" />
</head>
<body class="login">
	<jsp:include page="/partials/header.jsp"></jsp:include>

	<main class="container">

		<c:if test="${attraction != null && !attraction.isValid()}">
			<div class="alert alert-danger" style="margin-top:60px;">
				<p>Se encontraron errores al actualizar la atracción.</p>
			</div>
		</c:if>
		<section class="form-login">
			<form action="/parque_de_terror/attractions/edit.do" method="post">
				<input type="hidden" name="id" value="${attraction.id}">
				<jsp:include page="/views/attractions/form.jsp"></jsp:include>
			</form>
		</section>
	</main>
	<!-- Footer -->
	<jsp:include page="/partials/footer.jsp"></jsp:include>
</body>
</html>