<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="pt-br">

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Novo Departamento</title>

<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Roboto+Slab"
	rel="stylesheet">
<link
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
	rel="stylesheet">

</head>

<body style="background: transparent;">
	<!-- Barra superior com os menus de navegação -->
	<c:import url="menuadm.jsp" />
	<!-- Container Principal -->
	<div id="main" class="container">
		<div class="col-md-3 title">
			<h2 style="background: #d60606;">
				<i class="fa fa-commenting-o" aria-hidden="true"></i>Departamento
			</h2>
		</div>
		<h3 class="col-md-12"></h3>
		<!-- Formulario para inclusao de locais -->
		<form action="incluir_departamento" method="post"
			enctype="multipart/form-data">

			<!-- area de campos do form -->
			<div class="row">
				<div class="form-group col-md-8">
					<label for="titulo">Digita o departamento</label> <input
						type="text" class="form-control" name="departamento"
						id="departamento" required maxlength="128"
						placeholder="escreva um departamento">
				</div>
			</div>


			<label for="titulo">Digita o nivel do SLA</label>
			<div class="row">
				<div class="form-group col-md-2">
					<select name="sla" id="sla" class="form-control">
						<option value="1">1</option>
						<option value="2">2</option>
						<option value="3">3</option>
						<option value="4">4</option>
						<option value="5">5</option>
						<option value="6">6</option>
						<option value="7">7</option>
					</select>
				</div>
			</div>


			<hr />
			<div id="actions" class="row">
				<div class="col-md-12">
					<button type="submit" class="btn btn-primary title">
						<i class="fa fa-pencil" aria-hidden="true"></i>Enviar departamento
					</button>
					<a href="listar_reclamacao" class="btn btn-default">Cancelar</a>
				</div>
			</div>
		</form>
	</div>
	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
</body>

</html>