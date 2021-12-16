<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="mb-3">
	<label for="name" class="col-form-label">Username:</label> <input
		type="text" class="form-control" id="name" name="username" required
		value="${tmp_user.username}" style="color:black;">
</div>
<div class="mb-3">
	<label for="coins"
		class='col-form-label ${tmp_user.errors.get("coins") != null ? "is-invalid" : "" }'>Monedas:</label>
	<input class="form-control" type="number" min="1" id="coins" name="coins"
		required value="${tmp_user.coins}"></input>
	<div class="invalid-feedback">
		<c:out value='${tmp_user.errors.get("coins")}'></c:out>
	</div>
</div>

<div class="mb-3">
	<label for="time"
		class='col-form-label ${tmp_user.errors.get("time") != null ? "is-invalid" : "" }'>Tiempo:</label>
	<input class="form-control" type="number" min="1" id="time" name="time"
		required value="${tmp_user.time}"></input>
	<div class="invalid-feedback">
		<c:out value='${tmp_user.errors.get("time")}'></c:out>
	</div>
</div>

<div class="mb-3">
	<label for="atraccionFavorita" class='col-form-label' style="width:100%">
		Atracción favorita: <select class="form-select" type="number"
		id="atraccionFavorita" name="atraccionFavorita"
		value="${tmp_user.atraccionPreferida}">
			<option>1</option>
			<option>2</option>
			<option>3</option>
			<option>4</option>

	</select>

	</label>

</div>


<div class="mb-3">
	<label for="password"
		class='col-form-label ${tmp_user.errors.get("password") != null ? "is-invalid" : "" }'>Contraseña:</label>
	<input class="form-control" id="password" name="password" required
		value="${tmp_user.password}"></input>
	<div class="invalid-feedback">
		<c:out value='${tmp_user.errors.get("password")}'></c:out>
	</div>
</div>

<div>
	<button type="submit" class="btn btn-primary">Guardar</button>
	<a onclick="window.history.back();" class="btn btn-secondary"
		role="button">Cancelar</a>
</div>