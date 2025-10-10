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
    <title>Agregar juego</title>
</head>
<body>
    <div class="container">
        <nav class="navbar">
            <div>
                <h1 class="registro-h1 navbar-brand">Videojuegos</h1>
                <h2 class="h2-inicio">Agregar nuevo juego</h2>
            </div>
            <div class="d-flex">
                <a href="/inicio" class="nav-link me-5">Todos los juegos</a>
                <a href="/formulario/frase" class="nav-link me-5">Agregar juego</a>
                <form action="/logout" method="post" style="display: inline;">
                    <button type="submit" class="nav-link btn btn-link" style="padding: 0; border: none; background: none;">
                        Logout
                    </button>
                </form>
            </div>
        </nav>
        <form:form class="form" action="/procesa/formulario/juego" method="POST" modelAttribute="nuevoJuego">
            <div>
                <form:label path="titulo" class="form-label">Titulo:</form:label>
                <form:input path="titulo" class="form-control w-75"/>
                <form:errors path="titulo" class="form-text"/>
            </div>
            <div >
                <form:label path="genero" class="form-label">Genero:</form:label>
                <form:input path="genero" class="form-control w-75"/>
                <form:errors path="genero"/>
            </div>
            <div>
                <form:label path="plataforma" class="form-label">Plataforma:</form:label>
                <form:input path="plataforma" class="form-control w-75"/>
                <form:errors path="plataforma" class="form-text"/>
            </div>
            <div>
                <form:label path="desarrollador" class="form-label">Desarrollador:</form:label>
                <form:input path="desarrollador" class="form-control w-75"/>
                <form:errors path="desarrollador" class="form-text"/>
            </div>
            <div>
                <form:label path="imagen" class="form-label">URL de imagen:</form:label>
                <form:input path="imagen" class="form-control w-75"/>
                <form:errors path="imagen" class="form-text"/>
            </div>
            <div class="mb-3">
                <form:label path="fechaLanzamiento" class="form-label">Fecha de lanzamiento:</form:label>
                <form:input path="fechaLanzamiento" class="form-control w-75" type="date"/>
                <form:errors path="fechaLanzamiento" class="form-text"/>
            </div>

            <button class="btn btn-primary btn-lg">
                Agregar
            </button>
        </form:form>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js" integrity="sha384-FKyoEForCGlyvwx9Hj09JcYn3nv7wiPVlz7YYwJrWVcXK/BmnVDxM+D2scQbITxI" crossorigin="anonymous"></script>
</body>
</html>