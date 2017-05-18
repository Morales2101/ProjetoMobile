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
<title>Nova Reclamação</title>

<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Roboto+Slab" rel="stylesheet"> 
<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">

</head>

<body style="background: transparent;">
	<!-- Barra superior com os menus de navegação -->
	<c:import url="../menu.jsp" />
	<!-- Container Principal -->
	<div id="main" class="container">
		<div class="col-md-3 title">
			<h2 style="background: #d60606;"><i class="fa fa-commenting-o" aria-hidden="true"></i>Sugestões</h2>
		</div>
		<h3 class="col-md-12"></h3>
		<!-- Formulario para inclusao de locais -->
		<form action="incluir_reclamacao" method="post" enctype="multipart/form-data">
		
			<!-- area de campos do form -->
			<div class="row">
				<div class="form-group col-md-8">
					<label for="titulo">Titulo da Sugestão</label> 
					<input type="text" class="form-control" name="titulo" 
					id="nome" required maxlength="128" 
					placeholder="escreva um título">
					<form:errors path="Reclamacao.titulo" cssStyle="color:red" />
				</div>
				
				<div class="form-group col-md-4">
					<label for="tipo">Secretaria</label> 
					<select name="Secretaria" class="form-control">
						<!-- <c:forEach var="Secretaria" items="${Secretaria}">
							<option value="${Secretaria.id}">${Secretaria.nome}</option>
						</c:forEach> -->
						<option value="1">RH</option>
						<option value="2">Vendas</option>
						<option value="3">Comercial</option>
						<option value="4">T.I.</option>
					</select>
				</div>
			</div>
			
			<div class="row">
				<div class="form-group col-md-12">
					<label for="descricao">Descreva sua sugestão</label> 
					<textarea placeholder="descreva aqui sua sugestão" class="form-control" name="descricao" 
					id="descricao" required maxlength="128" rows="4" cols="50"></textarea> 
					<form:errors path="Reclamacao.descricao" cssStyle="color:red" />
				</div>
			</div>			
			<div class="row">
				<div class="form-group col-md-4">
					<label for="cidadao">Login do reclamante</label> 
					<input type="hidden" class="form-control" name="cidadao.id" value="${usuarioLogado.id}">
					<form:errors path="Reclamacao.cidadao" cssStyle="color:red" placeholder="endereço referente à solicitação"/>
				</div>
			</div>
			
			<div class="row">
				<div class="form-group col-md-8">
					<label for="arquivo">Por favor, selecione um arquivo de imagem do tipo jpg para carregar:</label> 
    	    	   <input type="file" name="file"  id="arquivo" class="file"/>
    	       </div>
    	    </div>
    	    
			<hr />
			<div id="actions" class="row">
				<div class="col-md-12">
					<button type="submit" class="btn btn-primary title"><i class="fa fa-pencil" aria-hidden="true"></i>Enviar sugestão</button>
					<a href="index" class="btn btn-default">Cancelar</a>
				</div>
			</div>
		</form>
	</div>
	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
</body>

</html>