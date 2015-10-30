<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
 
        <title> <spring:message code="show.titulo" /> </title>

		<link rel="stylesheet" href="<c:url value="/resources/bootstrap/css/bootstrap.min.css" />" >
		
		<spring:url value="/resources/bootstrap/css/bootstrap-theme.min.css" var="minCss"></spring:url>
 		<link href="${minCss}" rel="stylesheet"/>
		
        <link rel="stylesheet" href="<c:url value="/resources/bootstrap/css/bootstrap.css" /> ">
        <!--[if lt IE 9]>
            <script src="//html5shim.googlecode.com/svn/trunk/html5.js"></script>
        <![endif]-->
        <link rel="stylesheet" href="<c:url value="/resources/bootstrap/css/styles.css" /> ">
    </head>
    <body class="login">

 	<jsp:include page="fragments/row_sup.jsp"/>
 

    <!--login modal-->
    <div id="loginModal" class="modal show" tabindex="-1" role="dialog" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h1 class="text-center"><img class="logo" src="resources/images/logo3.png"></h1>
                </div>
                <div class="modal-body">
                    <form class="form col-md-12 center-block">
                        <div class="form-group">
                            <input type="text" class="form-control input-lg" placeholder="Email">
                        </div>
                        <div class="form-group">
                            <input type="password" class="form-control input-lg" placeholder="Password">
                        </div>
                        <div class="form-group">
                            <button class="btn btn-primary btn-lg btn-block">Sign In</button>
                            <span class="pull-right"><a href="../register">Register</a></span><span><a href="../home">Need help?</a></span>
                        </div>
                    </form>
              </div>
              <div class="modal-footer">   
              </div>
            </div>
        </div>
    </div>

         <!-- script references -->
        <script src="//ajax.googleapis.com/ajax/libs/jquery/2.0.2/jquery.min.js"></script>
        <script src="resources/bootstrap/js/bootstrap.min.js"></script>
    </body>
</html>