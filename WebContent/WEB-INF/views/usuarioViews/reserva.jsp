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
      <div class="container text-center center-text">
      <form:form modelAttribute="ticket" action="${pageContext.request.contextPath}/user/saveReserva" id="reservarForm">
      			<input type="hidden" name="funcionId" value=${idFuncion}>
      			<label>Asientos a reservar: </label> <input type="number" name="numAsientos">
      			<input type="submit" value="Reservar" style="background-color:green">
      </form:form>
      <div><h3>Le recordamos que la máxima cantidad de asientos que se pueden reservar son 15</h3></div>
      
      </div>
</body>
</html>