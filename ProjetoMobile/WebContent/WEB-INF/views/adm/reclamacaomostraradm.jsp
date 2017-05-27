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
<title>Exibir Reclamação</title>

<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">
</head>

<body style="background: transparent;">
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
					<h4 class="modal-title" id="modalLabel">Excluir Local</h4>
				</div>
				<div class="modal-body">Deseja realmente excluir esta
					reclamação?</div>
				<div class="modal-footer">
					<form action="remover_reclamacao" method="post">
						<input type="hidden" name="id" value="${reclamacao.id}" />
						<button type="submit" class="btn btn-primary">Sim</button>
						<button type="button" class="btn btn-default" data-dismiss="modal">N&atilde;o</button>
					</form>
				</div>
			</div>
		</div>
	</div>
	<!-- /.modal -->
	<!-- Barra superior com os menus de navegação -->
	<c:import url="menuadm.jsp" />
	<!-- Container Principal -->
	<div id="main" class="container">
		<h3 class="page-header">Exibir Reclamação #${reclamacao.id }</h3>
		<div class="row">
			<div class="col-md-8">
				<div class="row">
					<div class="col-md-8">
						<p>
							<strong>Email</strong>
						</p>
						<p>${reclamacao.cidadao.email}</p>
					</div>
					<div class="col-md-8">
						<p>
							<strong>Titulo</strong>
						</p>
						<p>${reclamacao.titulo}</p>
					</div>

					<div class="col-md-12">
						<p>
							<strong>Descrição</strong>
						</p>
						<p>${reclamacao.descricao}</p>
					</div>

					<div class="col-md-8">
						<p>
							<strong>Data / Hora</strong>
						</p>
						<p>${reclamacao.dataHora}</p>
					</div>
				</div>
				<div class="row">
					<div class="col-md-8">
						<p>
							<strong>Resposta</strong>
						</p>
						<p>${reclamacao.resposta}</p>
					</div>
					<div class="col-md-8">
						<p>
							<strong>Status</strong>
						</p>
						<c:choose>
							<c:when test="${reclamacao.aprovado eq true}">
								<p>Resolvido.</p>
							</c:when>
							<c:when test="${reclamacao.cidadao.cargo eq false}">
								<p>Pedente.</p>
							</c:when>
						</c:choose>
					</div>


				</div>
			</div>
		</div>
		<hr />
		<div id="actions" class="row">
			<div class="col-md-12">
				<a href="alterar_reclamacaoadm?id=${reclamacao.id }"
					class="btn btn-primary">Alterar</a> <a href="#"
					class="btn btn-danger" data-toggle="modal"
					data-target="#delete-modal"
					style="margin: 0 7px; background-color: #000; border-color: #000;">Excluir</a>
				<a href="listar_sla" class="btn btn-default">Voltar</a>
			</div>
		</div>
	</div>
	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
</body>

</html>