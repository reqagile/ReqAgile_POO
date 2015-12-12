<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="s" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="fragments/header.jsp"></jsp:include>

<html>
	<link rel="stylesheet" href="<c:url value="/resources/bootstrap/css/bootstrap.min.css" />" >
	<link href="resources/bootstrap/css/bootstrap.css" rel="stylesheet">
	<link href="resources/bootstrap/css/styles.css" rel="stylesheet">
	
<head>
	<meta http-equiv="content-type" content="text/html; charset=UTF-8">
	<title>New requirement</title>
</head>
<body>
<div class="modal-body">
	<s:form class="form col-md-12 center-block" method="post" commandName="user" action="create_requirement"  >
		<div class="form-group">
			<input type="text" class="form-control input-lg" id="title" path="title" 
			placeholder="Digite o título do projeto">
		</div>
		<div class="form-group">
			<input type="text" class="form-control input-lg" id="description" path="description" 
			placeholder="Digite uma descrição para o projeto">
		</div>
	</s:form>
</body>
</html>