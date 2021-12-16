<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="mb-3">
	<label for="name" class="col-form-label">Nombre:</label> <input
		type="text" class="form-control" id="name" name="name" required
		value="${attraction.name}" style="color: black;">
</div>
<div class="mb-3">
	<label for="cost"
		class='col-form-label ${attraction.errors.get("cost") != null ? "is-invalid" : "" }'>Costo:</label>
	<input class="form-control" type="number" id="cost" name="cost" required value="${attraction.cost}"></input>
	<div class="invalid-feedback">
		<c:out value='${attraction.errors.get("cost")}'></c:out>
	</div>
</div>
<div class="mb-3">
	<label for="duration"
		class='col-form-label ${attraction.errors.get("duration") != null ? "is-invalid" : "" }'>Duración:</label>
	<input class="form-control" type="number" id="duration" name="duration" required value="${attraction.duration}"></input>
	<div class="invalid-feedback">
		<c:out value='${attraction.errors.get("duration")}'></c:out>
	</div>
</div>
<div class="mb-3">
	<label for="capacity"
		class='col-form-label ${attraction.errors.get("capacity") != null ? "is-invalid" : "" }'>Capacidad:</label>
	<input class="form-control" type="number" id="capacity" name="capacity" required value="${attraction.capacity}"></input>
	<div class="invalid-feedback">
		<c:out value='${attraction.errors.get("capacity")}'></c:out>
	</div>
</div>

<div class="mb-3">
	<label for="tipo" class='col-form-label' style="width:100%"> Tipo de atracción: <select
		class="form-select" type="number" id="tipo" name="tipo"
		value="${attraction.tipo}">
			<option>1</option>
			<option>2</option>
			<option>3</option>
			<option>4</option>

	</select>

	</label>

</div>


<div>
	<button type="submit" class="btn btn-primary">Guardar</button>
	<a onclick="window.history.back();" class="btn btn-secondary"
		role="button">Cancelar</a>
</div>