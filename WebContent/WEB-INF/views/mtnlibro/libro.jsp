<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Biblioteca</title>

<jsp:include page="/WEB-INF/views/menu.jsp" />

<script type="text/javascript">
    
    function validate() {
    
        var valid = true;
        
        if( document.getElementById("tautor").value == -1 ) {
            document.getElementById("autorError").innerHTML="**Seleccione un Autor**";
            valid = false;
        } else {
            document.getElementById("autorError").innerHTML="";
        }
        
        if( document.getElementById("tEditorial").value == -1 ) {
            document.getElementById("editorialError").innerHTML="**Seleccione una Editorial**";
            valid = false;
        } else {
            document.getElementById("editorialError").innerHTML="";
        }
        
        if( document.getElementById("ttitulo").value.trim().length == 0 ) {
            document.getElementById("tituloError").innerHTML="**El campo no puede ser vacio**";
            valid = false;
        } else {
            document.getElementById("tituloError").innerHTML="";
        }
        
        if( document.getElementById("tanhoPublicacion").value.trim().length == 0 ) {
            document.getElementById("anhoPublicacionError").innerHTML="**El campo no puede ser vacio**";
            valid = false;
        } else {
            document.getElementById("anhoPublicacionError").innerHTML="";
        }
        
        if( document.getElementById("tedicion").value.trim().length == 0 ) {
            document.getElementById("edicionError").innerHTML="**El campo no puede ser vacio**";
            valid = false;
        } else {
            document.getElementById("edicionError").innerHTML="";
        }
        
        return valid;
    };
    
</script>

</head>

<body>

	<div class="container">
		
		<div class="form-group" style="color: blue"> <c:out value="${resultado}" /> </div>
		
		<fieldset>
			
			<c:choose>
				<c:when test="${libro.idLibro ne 0}">
					<legend>Actualizar Datos de Libro</legend>
				</c:when>
				<c:otherwise>
					<legend>Ingresar Datos de Libro</legend>
				</c:otherwise>
			</c:choose>
			
			<sf:form action="${pageContext.request.contextPath}/libro/save" 
			    class="form-horizontal" method="post" commandName="libro" onsubmit="return validate();">
				
				<c:if test="${libro.idLibro ne 0}">
					<sf:input path="idLibro" type="hidden" />
				</c:if>
				
				<div class="form-group">
					<label class="col-sm-2 control-label">Autor:</label>
					<div class="col-sm-3">
 						<select class="form-control" id="tautor" name="tautor">
 						    <option value="-1">Seleccionar Autor</option>
                            <c:forEach items="${autores}" var="autor">
                              <c:choose>
                                <c:when test="${autor.idAutor eq AutorSel}">
                                  <option value="${autor.idAutor}" selected="selected">${autor.nombre}</option>
                                </c:when>
                                <c:otherwise>
                                  <option value="${autor.idAutor}">${autor.nombre}</option>
                                </c:otherwise>
                              </c:choose>
                            </c:forEach>
                        </select>
                        <span id="autorError" style="color:red"></span>
					</div>
					<div class="col-md-2">
					  <a href='<c:url value="/autor" />' class="btn btn-default">Nuevo Autor</a>
					</div>
				</div>
				
				<div class="form-group">
					<label class="col-sm-2 control-label">Editorial:</label>
					<div class="col-sm-3">
 						<select class="form-control" id="teditorial" name="teditorial">
 						    <option value="-1">Seleccionar Editorial</option>
                            <c:forEach items="${editoriales}" var="editorial">
                              <c:choose>
                                <c:when test="${editorial.idEditorial eq EditorialSel}">
                                  <option value="${editorial.idEditorial}" selected="selected">${editorial.editorial}</option>
                                </c:when>
                                <c:otherwise>
                                  <option value="${editorial.idEditorial}">${editorial.editorial}</option>
                                </c:otherwise>
                              </c:choose>
                            </c:forEach>
                        </select>
                        <span id="editorialError" style="color:red"></span>
					</div>
					<div class="col-md-2">
					  <a href='<c:url value="/editorial" />' class="btn btn-default">Nueva Editorial</a>
					</div>
				</div>
				
				<div class="form-group">
					<label class="col-sm-2 control-label">T&iacute;tulo(*):</label>
					<div class="col-sm-4">
					    <sf:input class="form-control" path="titulo" id="ttitulo" type="text" />
						<sf:errors path="titulo" cssStyle="color:red" />
						<span id="tituloError" style="color:red"></span>
					</div>
				</div>
				
				<div class="form-group">
					<label class="col-sm-2 control-label">A&ntilde;o de Publicaci&oacute;n(*):</label>
					<div class="col-sm-4">
					    <sf:input class="form-control" path="anhoPublicacion" type="number" min="1900" max="2100" />
						<sf:errors path="anhoPublicacion" cssStyle="color:red" />
					</div>
					<label class="col-sm-2 control-label">Edici&oacute;n(*):</label>
					<div class="col-sm-4">
					    <sf:input class="form-control" path="edicion" type="text" />
						<sf:errors path="edicion" cssStyle="color:red" />
					</div>
				</div>
				
				<div class="form-group">
					<label class="col-sm-2 control-label">Cantidad de Ejemplares(*):</label>
					<div class="col-sm-4">
					    <sf:input class="form-control" path="cantidadEjemplares" type="number" min="0" max="9999" />
						<sf:errors path="cantidadEjemplares" cssStyle="color:red" />
					</div>
				</div>
				
				<div class="form-group">
                    <br />
					<div class="col-md-12  col-md-offset-5">
						<button type="submit" class="btn btn-default">Guardar cambios</button>
					</div>
				</div>
			</sf:form>

		</fieldset>

		<br /> <br />

	</div>

</body>
</html>