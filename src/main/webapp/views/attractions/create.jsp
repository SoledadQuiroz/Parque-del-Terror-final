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


	<main >

		<c:if test="${attraction != null && !attraction.isValid()}">
			<div class="alert alert-danger" style="margin: 60px auto; width: 70%;">
				<p>Se encontraron errores al crear la atracción.</p>
			</div>
		</c:if>
		<section class="form-login">
			<form action="/parque_de_terror/attractions/create.do" method="post">
				<jsp:include page="/views/attractions/form.jsp"></jsp:include>
			</form>
		</section>

	</main>
	<jsp:include page="/partials/footer.jsp"></jsp:include>
</body>
</html>