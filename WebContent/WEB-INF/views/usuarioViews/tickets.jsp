<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<link href="https://fonts.googleapis.com/css?family=DM+Sans&display=swap" rel="stylesheet">
	<style>
      body {
        font-family: 'DM Sans', sans-serif;
      }
    </style>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	<title>Dashboard Usuario</title>
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
      
      
      <div class="container">
 
      <div class="starter-template">
      
      
 <div class="table-responsive">
         <table id="paginatedTable" class="table table-striped">
             <thead>
                 <tr>
                     <th>Pelicula</th>
                     <th>Fecha</th>
                     <th>Hora</th>
                     <th>Asientos</th>
                 </tr>
             </thead>
 
         </table>
        </div>
      
      
      </div>
 
    </div>
    
    <script>
      $( document ).ready(function() {
 $('#paginatedTable').DataTable( {
        "processing": true,
        "serverSide": true,
        "pageLength": 5,
        "ajax": {
            "url": "/user/tickets",
            "data": function ( data ) {
 //process data before sent to server.
         }},
        "columns": [
                    { "data": "Pelicula", "name" : "pelicula", "title" : "pelicula"  },
                    { "data": "fecha", "name" : "fecha" , "title" : "fecha"},
                    
                    { "data": "hora", "name" : "hora" , "title" : "hora"},
                    { "data": "asientos", "name" : "asientos" , "title" : "asientos"}
                ]    
 });
 
 $('#paginatedTable').dataTable().fnSetFilteringEnterPress();
});
    
    </script>
      
      
      
</body>
</html>
