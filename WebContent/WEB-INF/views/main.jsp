<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<link href="https://fonts.googleapis.com/css?family=DM+Sans&display=swap" rel="stylesheet">
	<style>
      body {
        font-family: 'DM Sans', sans-serif;
      }
    </style>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@8"></script>
<meta charset="ISO-8859-1">
<title>Inicio</title>
</head>
<body>
<script type="text/javascript">
           
</script>
        <div class="container">
        <c:if test = "${fallido}">
        	<div class="alert alert-danger" role="alert">
  			<strong>Fallo de Sesión!</strong> Vuelva a intentarlo con las credenciales correctas.
				</div>
        </c:if>
        <c:if test = "${loggedIn}">
        	<div class="alert alert-danger" role="alert">
  			<strong>Fallo de Sesión!</strong> Su cuenta ya tiene una sesion activa.
				</div>
        </c:if>
            <div class="row text-center">
                <div class="">
                    <form:form action="${pageContext.request.contextPath}/login" method="POST" modelAttribute="usuario" id="loginForm">

                        <label>Usuario:</label>
                        <form:input type="text" name="usuario" path="username"/><br>

                        <label>Constraseña:</label>
                        <form:input type="password" name="password" path="password"/><br>
                        <input type="submit" value="Acceder">
                    </form:form>
                </div>

            </div>
        </div>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>

</body>
</html>