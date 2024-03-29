<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Biblioteca</title>

<jsp:include page="/WEB-INF/views/menu.jsp" />

</head>
<body>

	<table width="777" border="0" align="center" cellpadding="5" cellspacing="0">
		<tr>
			<td>

				<div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
					<!-- Indicators -->
					<ol class="carousel-indicators">
						<li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
						<li data-target="#carousel-example-generic" data-slide-to="1"></li>
						<li data-target="#carousel-example-generic" data-slide-to="2"></li>
						<li data-target="#carousel-example-generic" data-slide-to="3"></li>
						<li data-target="#carousel-example-generic" data-slide-to="4"></li>
						<li data-target="#carousel-example-generic" data-slide-to="5"></li>
						<li data-target="#carousel-example-generic" data-slide-to="6"></li>
						<li data-target="#carousel-example-generic" data-slide-to="7"></li>
						<li data-target="#carousel-example-generic" data-slide-to="8"></li>
						<li data-target="#carousel-example-generic" data-slide-to="9"></li>
						<li data-target="#carousel-example-generic" data-slide-to="10"></li>
					</ol>

					<!-- Wrapper for slides -->
					<div class="carousel-inner" role="listbox" align="center">
						<div class="item active">
							<img src='<c:url value="/imgs/carousel/1.jpg" />' height="400" width="360" />
							<div class="carousel-caption">
								<h3>CARLOS RUIZ ZAF&Oacute;N</h3>
								<p>La Sombra del Viento</p>
							</div>
						</div>
						<div class="item">
							<img src='<c:url value="/imgs/carousel/2.jpg" />' height="400" width="360" />
							<div class="carousel-caption">
								<h3>J.K. ROWLING</h3>
								<p>Harry Potter y el Legado Maldito</p>
							</div>
						</div>
						<div class="item">
							<img src='<c:url value="/imgs/carousel/3.jpg" />' height="400" width="360" />
							<div class="carousel-caption">
								<h3>MARIO VARGAS LLOSA</h3>
								<p>Cinco Esquinas</p>
							</div>
						</div>
						<div class="item">
							<img src='<c:url value="/imgs/carousel/4.jpg" />' height="400" width="360" />
							<div class="carousel-caption">
								<h3>MARIO BENEDETTI</h3>
								<p>Vivir adrede</p>
							</div>
						</div>
						<div class="item">
							<img src='<c:url value="/imgs/carousel/5.jpg" />' height="400" width="360" />
							<div class="carousel-caption">
								<h3>JOS&Eacute; SARAMAGO</h3>
								<p>Ensayo sobre la ceguera</p>
							</div>
						</div>
						<div class="item">
							<img src='<c:url value="/imgs/carousel/6.jpg" />' height="400" width="360" />
							<div class="carousel-caption">
								<h3>SERGIO BAMBAR&Eacute;N</h3>
								<p>Iris</p>
							</div>
						</div>
						<div class="item">
							<img src='<c:url value="/imgs/carousel/7.jpg" />' height="400" width="360" />
							<div class="carousel-caption">
								<h3>GABRIEL GARC&Iacute;A M&Aacute;RQUEZ</h3>
								<p>Cien a&nacute;os de soledad</p>
							</div>
						</div>
						<div class="item">
							<img src='<c:url value="/imgs/carousel/8.jpg" />' height="400" width="360" />
							<div class="carousel-caption">
								<h3>PABLO NERUDA</h3>
								<p>Confieso que he vivido</p>
							</div>
						</div>
					</div>

					<!-- Controls -->
					<a class="left carousel-control" href="#carousel-example-generic"
						role="button" data-slide="prev"> <span
						class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
						<span class="sr-only">Previous</span>
					</a> <a class="right carousel-control" href="#carousel-example-generic"
						role="button" data-slide="next"> <span
						class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
						<span class="sr-only">Next</span>
					</a>
				</div>

			</td>
		</tr>
		<tr>
			<td align="right"><br />Copyright � 2016. All Rights Reserved.</td>
		</tr>
	</table>

	<br />
	<br />

</body>
</html>