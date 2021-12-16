<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="es">
  <head>

    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css" integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous">
    <link href="css/style.css" rel="stylesheet"/>
    <title>Parque del Terror</title>

  </head>

  <body class="index">

    <header>
      <nav class="navbar navbar-expand-lg navbar-dark opacity-75 bg-dark">
        <div class="container-fluid">
          <a class="navbar-brand" href="#">Parque del Terror</a>
          <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
          </button>
          <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
            <div class="navbar-nav">
              <a class="nav-link active" aria-current="page" href="index.jsp">Inicio</a>
              <a class="nav-link" href="atracciones.jsp">Atracciones</a>
              <a class="nav-link" href="promociones.jsp">Promociones</a>
              <a class="nav-link" href="#" tabindex="-1" aria-disabled="true">Mi Cuenta</a>
              <a class="nav-link" href="login.jsp">Ingresar</a></h2>
            <a class="nav-link" href="registro.jsp">Registrar</a></h2>
            </div>
          </div>
        </div>
      </nav>
    </header>
    
    <main>
      <div id="carouselExampleCaptions" class="carousel slide" data-bs-ride="carousel">
        <div class="carousel-indicators">
          <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
          <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="1" aria-label="Slide 2"></button>
          <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="2" aria-label="Slide 3"></button>
          <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="3" aria-label="Slide 4"></button>
        </div>
        <div class="carousel-inner">
          <div class="carousel-item active">
            <img src="css/img/WhatsApp Image 2021-12-08 at 3.15.06 PM.jpeg" class="d-block w-40 carousel-img" alt="...">
            <div class="carousel-caption d-none d-md-block">
            </div>
          </div>
          <div class="carousel-item">
            <img src="css/img/paseo1.jpg" class="d-block w-40 carousel-img" alt="...">
            <div class="carousel-caption d-none d-md-block">
              <h5>Pack Adrenalina</h5>
              <p>Descubrí las atracciones que te llevaran las emociones al extremo.</p>
            </div>
          </div>
          <div class="carousel-item">
            <img src="css/img/paseo.jpg" class="d-block w-40 carousel-img" alt="...">
            <div class="carousel-caption d-none d-md-block">
              <h5>Pack Paseo</h5>
              <p>Recorre estos lugares tenebrosos que te haran sentir en una película de terror.</p>
            </div>
          </div>
          <div class="carousel-item">
            <img src="css/img/adrenalina.jpg" class="d-block w-40 carousel-img" alt="...">
            <div class="carousel-caption d-none d-md-block">
              <h5>Pack simulación</h5>
              <p>En estas atracciones animate a luchar con tus personajes de terror favoritos.</p>
            </div>
          </div>
        </div>
        <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide="prev">
          <span class="carousel-control-prev-icon" aria-hidden="true"></span>
          <span class="visually-hidden">Previous</span>
        </button>
        <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide="next">
          <span class="carousel-control-next-icon" aria-hidden="true"></span>
          <span class="visually-hidden">Next</span>
        </button>
      </div>
      <div class="contenedor">
        <div class="contenedor-atraccion">
          <h2 class="titulo-atracciones"> Atracciones </h2>
          <div class="btn-margin">
            <button type="button" class="btn btn-outline-danger">Mansion Embrujada</button>
            <button type="button" class="btn btn-outline-danger">Canibalismo y Cervezas</button>
            <button type="button" class="btn btn-outline-danger">Castillo de Drácula</button>
          </div>
          <div class="btn-margin">
            <button type="button" class="btn btn-outline-danger">Posada de Hades</button>
            <button type="button" class="btn btn btn-outline-danger">Bosque Encantado</button>
            <button type="button" class="btn btn-outline-danger">Tren Fantasma</button>
          </div>
          <div class="btn-margin">
            <button type="button" class="btn btn-outline-danger">Lago del Terror</button>
            <button type="button" class="btn btn-outline-danger">Sangre y Dolor</button>
            <button type="button" class="btn btn-outline-danger">Nido Dragon</button>
          </div>
          <div class="btn-margin">
            <button type="button" class="btn btn-outline-danger">Dark Castle</button>
            <button type="button" class="btn btn-outline-danger">Invisibles</button>
            <button type="button" class="btn btn-outline-danger">Laberinto</button>
          </div>
        </div>
        <div class="contenedor-promocion">
          <h2 class="titulo-atracciones"> Promociones </h3>
          <div class="btn-margin">
            <button type="button" class="btn btn-outline-danger">Pack Degustación</button>
            <button type="button" class="btn btn-outline-danger">Pack Adrenalina</button>
          </div>
          <div class="btn-margin">
            <button type="button" class="btn btn-outline-danger">Pack Simulación</button>
            <button type="button" class="btn btn-outline-danger">Pack Paseo</button>
          </div>
        </div>
      </div>
    </main>

    <footer class=" opacity-75">
      <div class="footer">
        <ul class="main">
          <li class="boton-fb">
            <a href="http://www.facebook.com/"><i class="fab fa-facebook-f"></i>Facebook</a>
          </li>
          <li class="boton-tw">
            <a href="#"><i class="fab fa-twitter"></i>Twitter</a>
          </li>
          <li class="boton-ig">
            <a href="#"><i class="fab fa-instagram"></i>Instagram</a>
          </li>
          <li class="boton-wsp">
            <a href="#"><i class="fab fa-whatsapp"></i>WhatsApp</a>
          </li>
        </ul>
      </div>
      <div class="footer-copyright text-center py-3">
        <p><small>© 2021 Copyright: Todos los Derechos Reservados</small></p>
      </div>
    </footer>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>

  </body>
</html>
