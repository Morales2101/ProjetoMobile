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
<title>Alterar Reclamação</title>

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
		<h3 class="page-header">Alterar Reclamacao #${reclamacao.id}</h3>
		<!-- Formulario para alteracao de locais -->
		<form action="atualizar_reclamacao" method="post"> <!--  enctype="multipart/form-data"-->
			<!-- area de campos do form -->
			<input type="hidden" name=id value="${reclamacao.id}">
			<div class="row">
				<div class="form-group col-md-8">
					<label for="titulo">Título</label> 
					<input type="text" class="form-control" name="titulo" 
					id="titulo" required maxlength="128"  value="${reclamacao.titulo}"
					placeholder="Título da Reclamacao">
					<form:errors path="Reclamacao.nome" cssStyle="color:red" />
				</div>
				<div class="form-group col-md-4">
					<label for="Secretaria">Secretaria</label> 
					<select name="secretaria.id" class="form-control" value="${reclamacao.secretaria }">
						<c:choose>
							<c:when test="${not empty secretarias}">
							 <c:forEach var="secretaria" items="${secretarias}">
								<c:if test="${secretaria.id != reclamacao.secretaria.id}">
									<option value="${secretaria.id}">${secretaria.nome}</option>
								</c:if>
								<c:if test="${secretaria.id eq reclamacao.secretaria.id}">
									<option value="${secretaria.id}" selected>${secretaria.nome}</option>
								</c:if>
							</c:forEach>
						    </c:when>
							<c:otherwise>
								<option value="1">RH</option>
								<option value="2">Vendas</option>
								<option value="3">Comercial</option>
								<option value="4">T.I.</option>
							</c:otherwise>
						</c:choose>
					</select>
				</div>
			</div>
			
			<div class="row">
				<div class="form-group col-md-12">
					<label for="descricao">Descrição</label> 
					<textarea placeholder="descreva aqui sua sugestão" class="form-control" name="descricao" 
					id="descricao" required maxlength="128" rows="4" cols="50" value="${reclamacao.descricao}"></textarea> 
					<form:errors path="Reclamacao.descricao" cssStyle="color:red" />
				</div>
			</div>
				
			<div class="row">
				<div class="form-group col-md-4">
					<label for="cidadao">Login do reclamante</label> 
					<input type="text" class="form-control" name="cidadao.id" value="${reclamacao.cidadao}">
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
					<button type="submit" class="btn btn-primary">Salvar</button>
					<a href="listar_reclamacao" class="btn btn-default">Cancelar</a>
				</div>
			</div>
		</form>
	</div>
	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
</body>

</html>