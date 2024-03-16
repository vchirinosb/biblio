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
        
        if( document.getElementById("usuario").value.trim().length == 0 ) {
            document.getElementById("usuarioError").innerHTML="**El campo no puede ser vacio**";
            valid = false;
        } else {
            document.getElementById("usuarioError").innerHTML="";
        }
        
        if( document.getElementById("nombres").value.trim().length == 0 ) {
            document.getElementById("nombresError").innerHTML="**El campo no puede ser vacio**";
            valid = false;
        } else {
            document.getElementById("nombresError").innerHTML="";
        }
        
        if( document.getElementById("apellidos").value.trim().length == 0 ) {
            document.getElementById("apellidosError").innerHTML="**El campo no puede ser vacio**";
            valid = false;
        } else {
            document.getElementById("apellidosError").innerHTML="";
        }
        
        if( document.getElementById("password").value.trim().length == 0 ) {
            document.getElementById("passwordError").innerHTML="**El campo no puede ser vacio**";
            valid = false;
        } else {
            document.getElementById("passwordError").innerHTML="";
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
				<c:when test="${usuario.idUsuario ne 0}">
					<legend>Actualizar Usuario</legend>
				</c:when>
				<c:otherwise>
					<legend>Ingresar Usuario</legend>
				</c:otherwise>
			</c:choose>

			<sf:form class="form-horizontal"
				action="${pageContext.request.contextPath}/usuario/save"
				method="post" commandName="usuario" onsubmit="return validate();">
				
				<c:if test="${usuario.idUsuario ne 0}">
					<sf:input path="idUsuario" type="hidden" />
				</c:if>
				
				<div class="form-group">
					<label class="col-sm-2 control-label">Usuario(*):</label>
					<div class="col-sm-4">
						<sf:input class="form-control" id="usuario" path="usuario" type="text" />
						<sf:errors path="usuario" cssStyle="color:red" />
						<span id="usuarioError" style="color:red"></span>
					</div>
				</div>
				
				<div class="form-group">
					<label class="col-sm-2 control-label">Nombres(*):</label>
					<div class="col-sm-4">
					    <sf:input class="form-control" id="nombres" path="nombres" type="text" />
						<sf:errors path="nombres" cssStyle="color:red" />
						<span id="nombresError" style="color:red"></span>
					</div>
				</div>
				
				<div class="form-group">
					<label class="col-sm-2 control-label">Apellidos(*):</label>
					<div class="col-sm-4">
					    <sf:input class="form-control" id="apellidos" path="apellidos" type="text" />
						<sf:errors path="apellidos" cssStyle="color:red" />
						<span id="apellidosError" style="color:red"></span>
					</div>
				</div>
				
				<div class="form-group">
					<label class="col-sm-2 control-label">Password(*):</label>
					<div class="col-sm-4">
					    <sf:input class="form-control" id="password" path="password" type="password" />
						<sf:errors path="password" cssStyle="color:red" />
						<span id="passwordError" style="color:red"></span>
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

		<c:if test="${usuario.idUsuario eq 0}">

			<table class="table table-bordered">
				<tr>
					<td><b>#</b></td>
					<td><b>Usuario</b></td>
					<td><b>Nombre</b></td>
					<td colspan="2"></td>
				</tr>
				<c:forEach items="${usuarios}" var="usuario" varStatus="itr">
					<tr>
						<td><b> <c:out value="${offset + itr.index + 1}" /> </b>
						    <%-- <c:out value="${usuario.idUsuario}" /> --%>
						</td>
						<td><c:out value="${usuario.usuario}" /></td>
						<td><c:out value="${usuario.nombres}" /> <c:out value="${usuario.apellidos}" /></td>
						<td><a href='<c:url value="/usuario/${usuario.idUsuario}/update" />'
							title='Actualizar'>
							<i class="glyphicon glyphicon-pencil"></i>
							</a>
						</td>
						<td><a class="confirm"
							href='<c:url value="/usuario/${usuario.idUsuario}/delete" />'
							title='Eliminar'>
							<i class="glyphicon glyphicon-remove"></i>
							</a>
						</td>
					</tr>
				</c:forEach>
			</table>
			<div align="center">
				<tag:paginate max="15" offset="${offset}" count="${count}"
					uri="usuario" next="&raquo;" previous="&laquo;" />
			</div>

		</c:if>
		
		<br /> <br />

	</div>

</body>
</html>