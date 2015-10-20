<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- <%@taglib prefix="f" uri="http://java.sun.com/jsf/core" %>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html" %> --%>

<html>
	<head>
		<title> <spring:message code="show.titulo" /> </title>
	 
		<link rel="stylesheet" href="<c:url value="/resources/bootstrap/css/bootstrap.min.css" />" >
 		<spring:url value="/resources/bootstrap/css/bootstrap-theme.min.css" var="minCss"></spring:url>
 		<link href="${minCss}" rel="stylesheet"/>
		<script src="<c:url value="/resources/bootstrap/js/bootstrap.min.js" />"></script>
		
		<link rel="stylesheet" href="<c:url value="/resources/bootstrap/css/signin.css" />" >
	 
	</head>
	
	<body>

		<jsp:include page="WEB-INF/views/fragments/row_sup.jsp"/>

<%-- 		<jsp:include page="WEB-INF/views/fragments/row_search.jsp"/> --%>
 
		<jsp:include page="/WEB-INF/views/home.jsp"></jsp:include>
		<div class="container">
 
		</div>
		 <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
		 <script src="<c:url value="resources/bootstrap/js/bootstrap.min.js" />"></script>

		
	</body>
</html>
