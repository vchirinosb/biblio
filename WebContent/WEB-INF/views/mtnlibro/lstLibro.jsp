<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="tag" uri="/WEB-INF/taglibs/customTaglib.tld"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Biblioteca</title>

<jsp:include page="/WEB-INF/views/menu.jsp" />

</head>
<body>

	<div class="container">
		
		<div class="form-group" style="color: blue"> <c:out value="${resultado}" /> </div>
		
		<fieldset>
			
			<fieldset>
				<legend>Listado de Libros</legend>
			
			<sf:form action="${pageContext.request.contextPath}/libro/buscar" 
			    class="form-horizontal" method="post" commandName="libroDTO">
			    
			    <div class="form-group">
				    <label class="col-sm-2 control-label">Autor:</label>
					<div class="col-sm-3">
					    <sf:input class="form-control" path="autor" id="autor" type="text" />
					</div>
					<label class="col-sm-2 control-label">T&iacute;tulo:</label>
					<div class="col-sm-3">
					    <sf:input class="form-control" path="titulo" id="titulo" type="text" />
					</div>
				</div>
				
				<div class="form-group">
                    <br />
					<div class="col-md-12  col-md-offset-5">
						<button type="submit" class="btn btn-default">Buscar</button>
					</div>
				</div>
			    
			</sf:form>
			
			</fieldset>
			
			<br />

			<table class="table table-bordered">
				<tr>
					<td><b>#</b></td>
					<td><b>T&iacute;tulo</b></td>
					<td><b>Autor</b></td>
					<td><b>Editorial</b></td>
					<td><b>A&ntilde;o de Publicai&oacute;n</b></td>
					<td><b>Edici&oacute;n</b></td>
					<td><b>Cantidad de Ejemplares</b></td>
					<td colspan="2"></td>
				</tr>
				<c:forEach items="${librosDTO}" var="libro" varStatus="itr">
					<tr>
						<td><b> <c:out value="${offset + itr.index + 1}" /></b></td>
						<td><c:out value="${libro.titulo}" /></td>
						<td><c:out value="${libro.autor}" /></td>
						<td><c:out value="${libro.editorial}" /></td>
						<td><c:out value="${libro.anhoPublicacion}" /></td>
						<td><c:out value="${libro.edicion}" /></td>
						<td><c:out value="${libro.cantidadEjemplares}" /></td>
						<td>
						    <a href='<c:url value="/libro/${libro.idLibro}/update" />'
							   title='Actualizar'> <i class="glyphicon glyphicon-pencil"></i></a>
						</td>
						<td>
						    <a class="confirm" href='<c:url value="/libro/${libro.idLibro}/delete" />'
							   title='Eliminar'> <i class="glyphicon glyphicon-remove"></i>
							</a>
						</td>
					</tr>
				</c:forEach>
			</table>
			<div align="center">
				<tag:paginate max="15" offset="${offset}" count="${count}"
					uri="buscar" next="&raquo;" previous="&laquo;" />
			</div>

		</fieldset>
		
		<br /> <br />

	</div>

</body>
</html>