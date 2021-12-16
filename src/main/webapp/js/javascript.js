(function () {
  "use strict";
  var forms = document.querySelectorAll(".needs-validation");

  Array.prototype.slice.call(forms).forEach(function (form) {
    form.addEventListener(
      "submit",
      function (event) {
        if (!form.checkValidity()) {
          event.preventDefault();
          event.stopPropagation();
        }
        form.classList.add("was-validated");
      },
      false
    );
  });
})();
//Ver clase 37b 36:26



function modal(id){
	const xhr = new XMLHttpRequest();
	const fd = new FormData();

	const funcion_error = function(event) {
		alert("ERROR");
	}

	// Definiciones de nuestro objeto de XHR
	xhr.timeout = 3000; // ms
	xhr.addEventListener("timeout", funcion_error);
	xhr.addEventListener("error", funcion_error);
	xhr.addEventListener("load", function(evento) {
		cargarModal(
			JSON.parse(evento.target.responseText.trim())
		);
	});

	xhr.open('GET', '../getAtraccion.jsp?id=' + id);

	// Realizamos el pedido
	xhr.send(fd);
}
function cargarModal(atraccion){
	const modalAtraccionTitulo = document.querySelector('#modalAtraccionTitulo');
	const modalAtraccionCuerpo = document.querySelector('#modalAtraccionCuerpo');
	const modalAtraccion = document.querySelector('#modalAtraccion');
	modalAtraccionTitulo.innerHTML= atraccion.nombre;
	modalAtraccionCuerpo.innerHTML= atraccion.descripcion;
	let modal = new bootstrap.Modal(modalAtraccion);
	modal.show();
}



//Modal para el index Principal
var myModal = document.getElementById('myModal').focus();
var myInput = document.getElementById('myInput');

myModal.addEventListener('shown.bs.modal', function () {
  myInput.focus()
})









