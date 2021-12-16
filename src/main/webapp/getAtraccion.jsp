<%@page import="services.AttractionService"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:useBean id="uService" class="services.AttractionService" />
<%int id = Integer.parseInt(request.getParameter("id"));
pageContext.setAttribute("atraccion", uService.find(id));%>

{ "nombre": 
	"<c:out value="${atraccion.name}"></c:out>",
 "descripcion": 
 	"<c:out value="${'Emprende un viaje que tal vez... no puedas terminar.'}"></c:out>" 
 }
