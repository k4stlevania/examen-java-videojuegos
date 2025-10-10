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
    <title>Inicio</title>
</head>
<body>
    <div class="container">
        <div class="container">
        <nav class="navbar">
            <div>
                <h1 class="registro-h1 navbar-brand">Videojuegos</h1>
                <h2 class="h2-inicio">Bienvenido de vuelta ${user.nombre} ${user.apellido}</h2>
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
    <div class="container my-4">
  <div class="row justify-content-center gap-3">
    <c:forEach var="juego" items="${juegos}">
        <div class="card text-center" style="width: 14rem;">
          <img src="${juego.imagen}" class="card-img-top img-juego" alt="${juego.titulo}">
          <div class="card-body">
            <h5 class="card-title fw-bold">${juego.titulo}</h5>
            <div class="d-flex justify-content-around mt-3">
              <a href="/juego/detalles/${juego.id}" class="btn btn-success">Detalle</a>

              <form action="/juego/procesa/eliminar/${juego.id}" method="POST">
                <input type="hidden" name="_method" value="DELETE">
                <button class="btn btn-danger">Eliminar</button>
              </form>

            </div>
          </div>
        </div>
    </c:forEach>
  </div>
</div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js" integrity="sha384-FKyoEForCGlyvwx9Hj09JcYn3nv7wiPVlz7YYwJrWVcXK/BmnVDxM+D2scQbITxI" crossorigin="anonymous"></script>
</body>
</html>