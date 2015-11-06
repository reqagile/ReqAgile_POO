<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="s" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- <%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%> --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

	<link rel="stylesheet" href="<c:url value="/resources/bootstrap/css/bootstrap.min.css" />" >
	<link rel="stylesheet" href="<c:url value="/resources/bootstrap/css/bootstrap.css" /> ">
	<spring:url value="/resources/bootstrap/css/bootstrap-theme.min.css" var="minCss"></spring:url>
	<link href="${minCss}" rel="stylesheet"/>
	<script src="<c:url value="/resources/bootstrap/js/bootstrap.min.js" />"></script>

	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Login</title>
	
 	</head>

	<body>
	    <jsp:include page="/WEB-INF/views/fragments/row_sup.jsp" />
	 
	    <div class="container" style="padding-top: 90px;">
	        <div class="row">
	            <div class="container">
	                <div class="col-md-8">
	                    <h1>Crie sua conta no ReqAgile!</h1>
	                    <p>Criando sua conta no ReqAgile você poderá gerenciar
	                        todo o processo de negócios e desfrutar de todas as suas vantagens.
	                        Faça agora o seu cadastro e aproveite.</p>
	                    <br />

	                    <s:form class="form-horizontal" method="post" commandName="user" action="criar_conta"  >

	                        <div class="form-group">
	                            <label for="nome" class="col-sm-3 control-label">Nome</label>
	                            <div class="col-sm-8">
	                                <s:input type="text" class="form-control" id="name" path="name"
	                                    placeholder="Digite aqui seu usuário" />
	                            </div>
	                        </div>

	                        <div class="form-group">
	                            <label for="email" class="col-sm-3 control-label">Email</label>

	                            <div class="col-sm-8">
	                                <s:input type="text" class="form-control" id="email" path="email"
	                                    placeholder="Digite aqui seu email" />
	                            </div>
	                        </div>
	                        
	                        <div class="form-group">
	                            <label for="nome" class="col-sm-3 control-label">Login</label>
	                            <div class="col-sm-6">
	                                <s:input type="text" class="form-control" id="login" path="login"
	                                    placeholder="Digite aqui seu login de usuário" />
	                            </div>
	                        </div>

	                        <div class="form-group">
	                            <label for="senha" class="col-sm-3 control-label">Senha</label>
	                            <div class="col-sm-5">
	                                <s:input type="password" id="senha" class="form-control" path="password"
	                                    placeholder="Digite aqui sua senha" />
	                            </div>
	                        </div>

	                        <div class="form-group">
	                            <label for="senha2" class="col-sm-3 control-label">Confirme</label>
	                            <div class="col-sm-5">
	                                <input type="password" id="senha2" class="form-control"
	                                    placeholder="Confirme aqui sua senha" />
	                            </div>
	                        </div>

	                        <div class="form-group">
	                            <div class="col-sm-offset-3 col-sm-10">
	                                <button type="submit" class="btn btn-default" >Criar conta</button>
	                            </div>
	                        </div>
	 
	                    </s:form>
	                </div>
	            </div>
	        </div>
	    </div>
	</body>
</html>