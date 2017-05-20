<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<nav class="navbar">
	<div class="container-fluid" style="background: #dcdcdc;">
		<div class="navbar-header" style="width: 100%;">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#navbar" aria-expanded="false"
				aria-controls="navbar">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<div class="col-md-12">
				<ul class="menu_projeto">
					<li><a class="navbar-brand" href="listar_adm">Home</a></li>
					<li><a class="navbar-brand" href="listar_sla">SLAs</a></li>
					<li><a class="navbar-brand" href="cadastroSolucionador">Cadastro de Solucionador</a></li>
					<li class="menu_dropdown"><a class="navbar-brand">Departamentos</a>
                		<ul class="lista_dropdown">
                			<li><a class="navbar-brand" href="cadastroSecretaria">Cadastro de Departamento</a></li>
                			<li><a href="">Departamentos Cadastrados</a></li>
                		</ul>
					</li>
				
					<li style="float: right;"><a class="navbar-brand"
						href="logout">Logout</a></li>
				</ul>
			</div>
		</div>
		<!--             <c:if test="${usuarioLogado != null}">
				<div id="navbar" class="navbar-collapse collapse">
					<ul class="nav navbar-nav navbar-right">
						<li><a href="logout">Sair do sistema</a></li>
					</ul>
				</div>
			</c:if>
-->
	</div>
</nav>