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
    <title>Registro y Login</title>
</head>
<body>
    <div class="container">
        <nav class="navbar">
            <div>
                <h1 class="registro-h1 navbar-brand">Frases</h1>
                <h2>Registro</h2>
            </div>
            <div class="d-flex">
                <a href="/login" class="nav-link me-5">Login</a>
                <a href="/" class="nav-link">Registro</a>
            </div>
        </nav>
        
        <form:form class="form" action="/usuarios/procesa/login" method="POST" modelAttribute="loginUsuario">
            <div>
                <form:label path="correoLogin" class="form-label">Correo:</form:label>
                <form:input path="correoLogin" class="form-control w-75"/>
                <form:errors path="correoLogin" class="form-text"/>
            </div>
            
            <div class="mb-3">
                <form:label path="contrasenaLogin" class="form-label">Contrasena:</form:label>
                <form:input path="contrasenaLogin" type="password" class="form-control w-75"/>
                <form:errors path="contrasenaLogin"/>
            </div>

            <button class="btn btn-primary btn-lg">
                Login
            </button>
        </form:form>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js" integrity="sha384-FKyoEForCGlyvwx9Hj09JcYn3nv7wiPVlz7YYwJrWVcXK/BmnVDxM+D2scQbITxI" crossorigin="anonymous"></script>
</body>
</html>