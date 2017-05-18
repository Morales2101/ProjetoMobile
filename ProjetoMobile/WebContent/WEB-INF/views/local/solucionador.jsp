<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="pt-br">

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Solucionador</title>

<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Roboto+Slab"
	rel="stylesheet">
<link
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
	rel="stylesheet">
<script src="js/bootstrap.min.js"></script>
</head>

<body style="background: #f7f7f7;">
	<!-- Barra superior com os menus de navegação -->
	<jsp:include page="menuSolucionador.jsp"/>
	

	<!-- Modal -->
	<div class="modal fade" id="delete-modal" tabindex="-1" role="dialog"
		aria-labelledby="modalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Fechar">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="modalLabel">Excluir Reclamação</h4>
				</div>
				<div class="modal-body">Deseja realmente excluir esta
					reclamação?</div>
				<div class="modal-footer">
					<form action="remover_reclamacao" method="post">
						<input type="hidden" name="id" id="id_excluir" />
						<button type="submit" class="btn btn-primary">Sim</button>
						<button type="button" class="btn btn-default" data-dismiss="modal">N&atilde;o</button>
					</form>
				</div>
			</div>
		</div>
	</div>
	<!-- /.modal -->
	<!-- Container Principal -->
	<div id="main" class="container-fluid">
		<form action="listar_solucionador" method="post">
			<div id="top" class="row">
				<!--  <div class="col-md-3 title">
					<h2><i class="fa fa-home" aria-hidden="true"></i>Home</h2>
				</div> -->

				<div class="col-md-6">
					<div class="input-group h2" style="width: 100%;">
						<div class="col-md-9" style="padding: 0;">
							<input name="chave" class="form-control input_project"
								id="search" type="text"
								placeholder="Pesquisar Chamados (deixe vazio para trazer todos)"
								style="border-radius: 7px 0 0 7px;">
						</div>
						<div class="col-md-3" style="padding: 0;">
							<span class="">
								<button class="tn btn-primary" type="submit"
									style="font-size: 0.98em; border-radius: 0 7px 7px 0;">
									<span class="glyphicon glyphicon-search"
										style="font-size: 0.6em; border-radius: 0 4px 4px 0; padding: 0.1em; top: 0;"></span>
								</button>
							</span>
						</div>
					</div>
				</div>

				<!-- <div class="col-md-3">
					<a href="nova_reclamacao" class="btn btn-primary pull-right h2"><i class="fa fa-pencil" aria-hidden="true"></i>
					Faça uma sugestão</a>
				</div>-->
			</div>
			<!-- /#top -->
		</form>
		<hr />
		<c:if test="${not empty reclamacao}">
			<div id="list" class="row">

				<div class="table-responsive col-md-12">
					<table class="table table-striped">
						<thead>
							<tr>
								<th>Solicitante</th>
								<th>Titulo</th>
								<th>Data / Hora</th>
								<th>Descrição</th>
								<th>Resposta</th>
								<th>Avaliador</th>
								<th>Aprovado</th>
								<th class="actions">A&ccedil;&otilde;es</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="reclamacao" items="${reclamacao}">
								<tr>
									<td>${reclamacao.cidadao}</td>
									<td>${reclamacao.titulo}</td>
									<td>${reclamacao.dataHora}</td>
									<td>${reclamacao.descricao}</td>
									<td>${reclamacao.resposta}</td>
									<td>${reclamacao.avaliador}</td>
									<td>${reclamacao.aprovado}</td>									
									<td class="actions"><a class="btn btn-success btn-xs"
										href="#?id=${reclamacao.id}">Solucionar</a> <a
										class="btn btn-warning btn-xs"
										href="#?id=${reclamacao.id}">Responder</a>
									</td>
								</tr>
							</c:forEach>

						</tbody>
					</table>

				</div>
			</div>
			<!-- /#list -->

		</c:if>
		<!-- /#bottom -->
	</div>
	<!-- /#main -->
	<script src="js/jquery.min.js"></script>

	<script type="text/javascript">
		$("#delete-modal").on('show.bs.modal', function(event) {
			var button = $(event.relatedTarget); //botao que disparou a modal
			var recipient = button.data('local');
			$("#id_excluir").val(recipient);
		});
	</script>
</body>

</html>