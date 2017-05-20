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

<body >
    <!-- Container Principal -->
    <div >
    <div id="main" class="container" >
    <div class="formulario_login">
       <h3 class="page-header" style="    margin: 5% 0;">Login</h3>
       <!-- Formulario de Login -->
        <form action="fazer_login" method="post">
				<div class="row col-md-12">
				<div class="form-group">
					<div class="input-group ">
					   <div class="input-group-addon"><span class="glyphicon glyphicon-edit" aria-hidden="true"></span></div> 
					   <input type="email" name="email" id="email" class="form-control" maxlength="60" placeholder="E-mail" required/>
					</div>
				</div>
				<div class="form-group">
					<div class="input-group ">
					   <div class="input-group-addon"><span class="glyphicon glyphicon-option-horizontal" aria-hidden="true"></span></div> 
					   <input type="password" name="senha" id="senha" class="form-control" placeholder="Senha" required/>
					</div>
				</div>
				</div>
				<div class="esquerda">
					<button type="submit" class="btn btn-primary" name="command" value="FazerLogin"> Logar</button>
				</div>
				<div class="direita">
					<a type="submit" class="btn btn-primary"   href="cadastro"> Cadastar</a>
				</div>
			</form>    
			</div>
			</div>
			</div>	
    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
</body>

</html>