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
</head>

<body>
	<!-- Barra superior com os menus de navegação -->
<%-- 	<c:import url="../menu.jsp" /> --%>
	<!-- Container Principal -->
	<div id="main" class="container">
		
		<!-- Formulario para inclusao de locais -->
		<form action="criar_secretaria" method="post" enctype="multipart/form-data">
			<!-- area de campos do form -->
			<div class="row">
				<div class="formulario_login">
		<h3 class="page-header">Incluir Departamento</h3>	
					<div class="input-group ">
					   <div class="input-group-addon"><span class="glyphicon glyphicon-edit" aria-hidden="true"></span></div>
					   <input type="text" class="form-control" name="nome" id="nome" required maxlength="128" placeholder="nome da departamento"> 
					   
					</div>
					<div class="input-group">
					
					</div>
					<form:errors path="secretaria.id" cssStyle="color:red" />
					<div class="clearfix"></div>
					<br>
					<button type="submit" class="btn btn-primary">Salvar</button>
					<a href="listar_adm" class="btn btn-default" 	style="float:right;">Cancelar</a>
				</div>
				
			</div>
			
			
		</form>
	</div>
	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
</body>

</html>