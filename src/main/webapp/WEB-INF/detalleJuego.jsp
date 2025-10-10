<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Formato (fechas) -->
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- Para errores de renderizado en rutas PUT -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">
    <link rel="stylesheet" href="/css/styles.css">
    <title>Detalle</title>
</head>
<body>
    <div class="container">
        <div class="container">
        <nav class="navbar">
            <div>
                <h1 class="registro-h1 navbar-brand">Videojuegos</h1>
                <h2 class="h2-inicio">${juegoPorId.titulo}</h2>
            </div>
            <div class="d-flex">
                <a href="/inicio" class="nav-link me-5">Todos los juegos</a>
                <a href="/formulario/crear/juego" class="nav-link me-5">Agregar juego</a>
                <form action="/logout" method="post" style="display: inline;">
                    <button type="submit" class="nav-link btn btn-link" style="padding: 0; border: none; background: none;">
                        Logout
                    </button>
                </form>
            </div>
        </nav>
    </div>
    <div class="container">
        <div class="card mb-3 p-3" style="max-width: 600px;">
  <div class="row g-0 align-items-center">
    <div class="col-md-7">
      <div class="card-body">
        <p class="mb-1 text-muted small">Agregado por</p>
        <p class="fw-bold mb-2">${juegoPorId.usuario.nombre} ${juegoPorId.usuario.apellido}</p>

        <p class="mb-1 text-muted small">Género</p>
        <p class="fw-bold mb-2">${juegoPorId.genero}</p>

        <p class="mb-1 text-muted small">Plataforma</p>
        <p class="fw-bold mb-2">${juegoPorId.plataforma}</p>

        <p class="mb-1 text-muted small">Desarrollador</p>
        <p class="fw-bold mb-2">${juegoPorId.desarrollador}</p>

        <p class="mb-1 text-muted small">Fecha de lanzamiento</p>
        <p class="fw-bold mb-0">${juegoPorId.fechaLanzamiento}</p>
      </div>
    </div>

    <div class="col-md-5 text-center">
      <img
        src="${juegoPorId.imagen}"
        class="img-fluid rounded"
        alt="${juegoPorId.titulo}"
        style="max-height: 250px; object-fit: cover;"
      />
    </div>

</div>
</div>

<form action="/juego/formulario/editar/${juegoPorId.id}" method="GET">
    <button class="btn btn-info btn-lg">
        Editar
    </button>
</form>

  </div>
</div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js" integrity="sha384-FKyoEForCGlyvwx9Hj09JcYn3nv7wiPVlz7YYwJrWVcXK/BmnVDxM+D2scQbITxI" crossorigin="anonymous"></script>
</body>
</html>