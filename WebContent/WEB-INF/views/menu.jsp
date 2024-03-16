<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Biblioteca</title>

<script type="text/javascript" src='<c:url value="/res/jquery/jquery-2.2.4.min.js" />'></script>
<script type="text/javascript" src='<c:url value="/res/jquery/jquery-ui-1.11.4/jquery-ui.js" />'></script>
<script type="text/javascript" src='<c:url value="/res/jquery/jquery-ui-1.11.4/jquery-ui.min.js" />'></script>
<script type="text/javascript" src='<c:url value="/res/bootstrap/bootstrap-3.3.6/js/bootstrap.js" />'></script>
<script type="text/javascript" src='<c:url value="/res/bootstrap/bootstrap-datepicker/js/bootstrap-datepicker.min.js" />'></script>
<script type="text/javascript" src='<c:url value="/res/bootstrap/bootstrap-datepicker/js/bootstrap-datepicker.es.min.js" />'></script>

<link href='<c:url value="/res/bootstrap/bootstrap-3.3.6/css/bootstrap.css" />' rel="stylesheet">
<link href='<c:url value="/res/bootstrap/bootstrap-3.3.6/css/bootstrap-theme.css" />' rel="stylesheet">
<link href='<c:url value="/res/bootstrap/bootstrap-datepicker/css/bootstrap-datepicker3.min.css" />' rel="stylesheet">

<script type="text/javascript"> -->
 	jQuery(document).ready(function() {
 		jQuery(".confirm").on("click",function() {
 			return confirm("Si eliminas este elemento no se podra recuperar. Continuar?");
 		});
 	});
</script>

</head>
<body>

	<table>
	    <tr>
 	        <td><br />&nbsp;&nbsp;&nbsp;&nbsp;<img src='<c:url value="/imgs/logo.jpg" />' /></td>
	        <td><h1>&nbsp;&nbsp;&nbsp;&nbsp;DEMO Biblioteca</h1></td>
	    </tr>
	</table>
	<br />

	<nav class="navbar navbar-default">
	<div class="container-fluid">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
				aria-expanded="false">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href='<c:url value="/" />'>Home</a>
		</div>

		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">
				<li class="dropdown"><a href='<c:url value="#" />' class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false">Gestionar Autores <span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href='<c:url value="/autor" />'>Autores</a></li>
					</ul>
				</li>
				<li class="dropdown"><a href='<c:url value="#" />' class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false">Gestionar Editoriales <span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href='<c:url value="/editorial" />'>Editoriales</a></li>
					</ul>
				</li>
				<li class="dropdown"><a href='<c:url value="#" />' class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false">Gestionar Libros <span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href='<c:url value="/libro" />'>Ingresar Libros</a></li>
						<li><a href='<c:url value="/libro/listar" />'>Listado de Libros</a></li>
					</ul>
				</li>
			</ul>
			
			<ul class="nav navbar-nav navbar-right">
			
				<sec:authorize access="!isAuthenticated()">
				   <li>
				      <a href='<c:url value="/login" />'>Iniciar Sesi&oacute;n</a>
				   </li>
				</sec:authorize>
				
				<sec:authorize access="isRememberMe()">
				   <li class="dropdown"><a href='<c:url value="#" />' class="dropdown-toggle"
					   data-toggle="dropdown" role="button" aria-haspopup="true"
					   aria-expanded="false">Gestionar Usuarios <span class="caret"></span></a>
					   <ul class="dropdown-menu">
						   <li><a href='<c:url value="/usuario" />'>Usuarios</a></li>
					   </ul>
				   </li>
				   <li>
				       <a href='<c:url value="/logout" />'>Cerrar Sesi&oacute;n</a>
				   </li>
				</sec:authorize>
				
				<sec:authorize access="isFullyAuthenticated()">
				   <li class="dropdown"><a href='<c:url value="#" />' class="dropdown-toggle"
					   data-toggle="dropdown" role="button" aria-haspopup="true"
					   aria-expanded="false">Gestionar Usuarios <span class="caret"></span></a>
					   <ul class="dropdown-menu">
						   <li><a href='<c:url value="/usuario" />'>Usuarios</a></li>
					   </ul>
				   </li>
				   <li>
				       <a href='<c:url value="/logout" />'>Cerrar Sesi&oacute;n</a>
				   </li>
				</sec:authorize>
				
			    <li>
			      <a class="navbar-brand" data-toggle="modal" data-target="#myModal" href='<c:url value="#" />' />About</a>
			    </li>
			</ul>
		</div>
		<!-- /.navbar-collapse -->
	</div>
	<!-- /.container-fluid --> </nav>
	
	<!-- Modal -->
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	        <h4 class="modal-title" id="myModalLabel">DEMO Biblioteca</h4>
	      </div>
	      <div class="modal-body">
	        Equipo de Desarrollo:<br /><br />
	        <ul style="list-style-type:circle">
	          <li>
	            Victor Chirinos<br />
	            <a href="mailto:vchirinosb@gmail.com?Subject=SERMED%20Calibraciones">vchirinosb@gmail.com</a>
	          </li>
	        </ul>
	        <br /><br />
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
	      </div>
	    </div>
	  </div>
	</div>

</body>
</html>