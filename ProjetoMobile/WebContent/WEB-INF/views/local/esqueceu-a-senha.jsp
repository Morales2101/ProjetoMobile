<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %><!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Cadastros</title>

    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">
</head>

<body>
    <!-- Barra superior com os menus de navegaÃ§Ã£o
	<c:import url="menu.jsp"/> -->
    <!-- Container Principal -->
    <div id="main" class="container img_fundo" >
    <div class="formulario_login" style="height:200px;">
       <h3 class="page-header" style="    margin: 5% 0;">Esqueceu a senha?</h3>
       <!-- Formulario de Login -->
        <form action="fazer_login" method="post">
				<div class="row col-md-12">				
				<div class="form-group">
					<div class="input-group ">
					   <div class="input-group-addon"><span class="glyphicon glyphicon-option-horizontal" aria-hidden="true"></span></div> 
					   <input type="text" name=	"email" id="email" class="form-control" placeholder="Digi o seu e-mail cadastrado" required/>
					</div>
				</div>
				</div>
				<div class="esquerda">
					<button type="submit" class="btn btn-primary" name="command" value="FazerLogin"> Voltar</button>
				</div>
				<div class="direita">
					<button type="submit" class="btn btn-primary" name="command" value="#"> Enviar Nova Senha</button>
				</div>				
			</form>    
			</div>
			</div>
    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
</body>

</html>