<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="s" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
	<!--[if lt IE 9]>
       <script src="//html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->

	<link rel="stylesheet" href="<c:url value="/resources/bootstrap/css/bootstrap.min.css" />" >
	<link href="resources/bootstrap/css/bootstrap.css" rel="stylesheet">
	<link href="resources/bootstrap/css/styles.css" rel="stylesheet">	
	
<head>
	<meta http-equiv="content-type" content="text/html; charset=UTF-8">
	<title>Login</title>
</head>

<body class="login">

	<div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
		<div class="navbar-header">
			<a class="navbar-brand" href="./"> <spring:message code="show.titulo" /></a>
		</div>
	</div>

	<!--login modal-->
	<div id="loginModal" class="modal show" tabindex="-1"
		role="dialog" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h1 class="text-center">
						<img class="logo" src="resources/images/logo3.png">
					</h1>
				</div>
				<div class="modal-body">
					<s:form class="form col-md-12 center-block" method="post" commandName="user" action="criar_conta"  >

						<div class="form-group">
							<input type="text" class="form-control input-lg" id="name" path="name" 
							placeholder="Digite seu nome">
						</div>
						<div class="form-group">
							<input type="text" class="form-control input-lg" id="email" path="email" 
							placeholder="Digite seu Email">
						</div>
						<div class="form-group">
							<input type="text" class="form-control input-lg" id="login" path="login" 
							placeholder="Informe seu login de usuário">
						</div>
						<div class="form-group">
							<input type="password" class="form-control input-lg" id="senha" path="password"
							placeholder="Digite sua senha">
						</div>
						<div class="form-group">
							<input type="password" class="form-control input-lg" id="senha2"
							placeholder="Confirme sua senha">
						</div>
						<div class="form-group">
							<button class="btn btn-primary btn-lg btn-block">Registrar</button>
							<span><a href="./" style="font-size: 15px;">INÍCIO</a></span>
						</div>
					</s:form>
				</div>
				<div class="modal-footer"></div>
			</div>
		</div>
	</div>

	<!-- script references -->
	<script	src="//ajax.googleapis.com/ajax/libs/jquery/2.0.2/jquery.min.js"></script>
	<script src="<c:url value="/resources/bootstrap/js/bootstrap.min.js" />"></script>

</body>
</html>