<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Inicio</title>
</head>
<body>
<script type="text/javascript">
            $(function () {
                /*  Submit form using Ajax */
                $('button[type=submit]').click(function (e) {

                    //Prevent default submission of form
                    e.preventDefault();

                    //Remove all errors
                    $('input').next().remove();

                    $.post({
                        url: 'saveEmployee',
                        data: $('form[name=loginForm]').serialize(),
                        success: function (res) {

                            if (res.validated) {
                                //Set response


                            } else {
                                Swal.fire({
                                    type: 'error',
                                    title: 'Credenciales incorrectas',
                                    text: 'Usuario o contraseña incorrecto'
                                })
                                };
                            }
                       error: function(){
                           Swal.fire({
                                    type: 'error',
                                    title: 'Ha sucedido un error',
                                    text: 'Contactese con su administrador'
                                })
                        }
                    })
                });
            });
        </script>
        <div class="container">
            <div class="row justify-content-center">
                <div class="col col-lg-6">
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
        <script src="https://cdn.jsdelivr.net/npm/sweetalert2@8"></script>

</body>
</html>