<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
	<link href="https://fonts.googleapis.com/css?family=DM+Sans&display=swap" rel="stylesheet">
	<style>
      body {
        font-family: 'DM Sans', sans-serif;
      }
    </style>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	<title>Funciones</title>
</head>
<body>
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <a class="navbar-brand" >Movies-App</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
      
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
          <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
              <a class="nav-link" href="${pageContext.request.contextPath}/user/">Home<span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="#">Tickets</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="${pageContext.request.contextPath}/user/logout">Logout</a>
            </li>          
        </div>
      </nav>
      <div class="container" style="background-color: light blue;">
      <div class="text-center center-text"><h1>Funciones para: ${pelicula}</h1></div>
      <div class= "row" style="margin-top:20px; margin-bottom:10px; border:1px solid black">
      <div class="col-4 text-center center-text"><h3>Hora</h3></div>
      <div class="col-4 text-center center-text"><h3>Fecha</h3></div>
      <div class="col-4 text-center center-text"><h3>Sala</h3></div>
      </div>
		<c:forEach items="${funciones}" var="funcion">
		<a href="${pageContext.request.contextPath}/user/reserva?funcion=${funcion.idFuncion}">
		<div class = "row" style="margin-top:20px; border:1px solid blue;">
		<div class="col-4 text-center center-text">${funcion.hora}</div>
		<div class="col-4 text-center center-text"><fmt:formatDate value="${funcion.fecha.time}" type="date" dateStyle="short" /></div>
		<div class="col-4 text-center center-text">${funcion.sala}</div>
		</div></a>
		</c:forEach>
      
      
      </div>
</body>
</html>