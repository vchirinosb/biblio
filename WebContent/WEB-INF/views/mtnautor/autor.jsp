<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tag" uri="/WEB-INF/taglibs/customTaglib.tld"%>
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
        
        if( document.getElementById("nombre").value.trim().length == 0 ) {
            document.getElementById("nombreError").innerHTML="**El campo no puede ser vacio**";
            valid = false;
        } else {
            document.getElementById("nombreError").innerHTML="";
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
				<c:when test="${autor.idAutor ne 0}">
					<legend>Actualizar Autor</legend>
				</c:when>
				<c:otherwise>
					<legend>Ingresar Autor</legend>
				</c:otherwise>
			</c:choose>

			<sf:form class="form-horizontal"
				action="${pageContext.request.contextPath}/autor/save"
				method="post" commandName="autor" onsubmit="return validate();">
				
				<c:if test="${autor.idAutor ne 0}">
					<sf:input path="idAutor" type="hidden" />
				</c:if>
				
				<div class="form-group">
					<label class="col-sm-2 control-label">Autor(*):</label>
					<div class="col-sm-4">
						<sf:input class="form-control" id="nombre" path="nombre" type="text" />
						<sf:errors path="nombre" cssStyle="color:red" />
						<span id="nombreError" style="color:red"></span>
					</div>
				</div>
				
				<div class="form-group">
					<label class="col-sm-2 control-label">Descripci&oacute;n:</label>
					<div class="col-sm-4">
					    <sf:textarea class="form-control" path="descripcion" cols="100" rows="5" />
						<sf:errors path="descripcion" cssStyle="color:red" />
					</div>
				</div>
				
				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						<button type="submit" class="btn btn-default">Guardar cambios</button>
					</div>
				</div>
			</sf:form>

		</fieldset>

		<br />

		<c:if test="${autor.idAutor eq 0}">

			<table class="table table-bordered">
				<tr>
					<td><b>#</b></td>
					<td><b>Nombre</b></td>
					<td><b>Descripci&oacute;n</b></td>
					<td colspan="2"></td>
				</tr>
				<c:forEach items="${autores}" var="autor" varStatus="itr">
					<tr>
						<td><b> <c:out value="${offset + itr.index + 1}" /> </b>
						    <%-- <c:out value="${autor.idAutor}" /> --%>
						</td>
						<td><c:out value="${autor.nombre}" /></td>
						<td><c:out value="${autor.descripcion}" /></td>
						<td><a href='<c:url value="/autor/${autor.idAutor}/update" />'
							title='Actualizar'>
							<i class="glyphicon glyphicon-pencil"></i>
							</a>
						</td>
						<td><a class="confirm"
							href='<c:url value="/autor/${autor.idAutor}/delete" />'
							title='Eliminar'>
							<i class="glyphicon glyphicon-remove"></i>
							</a>
						</td>
					</tr>
				</c:forEach>
			</table>
			<div align="center">
				<tag:paginate max="15" offset="${offset}" count="${count}"
					uri="autor" next="&raquo;" previous="&laquo;" />
			</div>

		</c:if>
		
		<br /> <br />

	</div>

</body>
</html>