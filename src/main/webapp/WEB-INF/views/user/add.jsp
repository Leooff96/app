<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cadastro de Usuário</title>
<spring:url var="css" value="/static/bootstrap/css/bootstrap.css" />
<spring:url var="js" value="/static/bootstrap/js/bootstrap.js" />
<spring:url var="jquery" value="/static/jquery/jquery-3.3.1.min.js" />

<link type="text/css" rel="stylesheet" href="${css}">





</head>
<body>
	<div class="container">
		<h1>Cadastro de Usuários</h1>
		<hr>
		<div>

			<spring:url value="/usuario/todos" var="home" />
			<a class="btn btn-light" href="${home }">Home</a>
		</div>
		<hr>
		<div>
			<spring:url
				value="${usuario.id == null ? '/usuario/save' : '/usuario/update'}"
				var="save" />
			<form:form modelAttribute="usuario" action="${save }" method="post">
				<form:hidden path="id" />
				<div class="form-group">
					<label for="nome">Nome: </label>
					<form:input path="nome" class="form-control" />
					<form:errors path="nome" cssClass="text-danger" />
				</div>
				<div class="form-group">
					<label for="sobrenome">Sobrenome: </label>
					<form:input path="sobrenome" class="form-control"/>
					<form:errors path="sobrenome" cssClass="text-danger" />
				</div>

				<div class="form-group">
					<label for="data">Data: </label>
					<form:input path="data" class="form-control" type="date" />
					<form:errors path="data" cssClass="text-danger" />
				</div>

				<div class="form-group">
					<label for="sexo">Sexo: </label>
					<form:select path="sexo" class="form-control" type="date">
						<form:options items="${sexos }" itemLabel="desc" />
					</form:select>
				</div>

				<div class="form-group">
					<button type="submit" class="btn btn-primary" >Confirmar</button>
				</div>
			</form:form>
		</div>
		<hr>
		<footer class="footer">
			<p>&copy; 2017 Stefanini</p>
		</footer>
	</div>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
	<script type="text/javascript">
		$(document).ready(function() {
			$('[data-toggle="popover"]').popover()
		});
	</script>
</body>
</html>