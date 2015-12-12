<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
	<head>
		
		<link rel="stylesheet" href="<c:url value="/resources/bootstrap/css/bootstrap.min.css" />
		<spring:url value="/resources/bootstrap/css/bootstrap-theme.min.css" var="minCss"></spring:url>
		<link href="${minCss}" rel="stylesheet"/>
		<script src="<c:url value="/resources/bootstrap/js/bootstrap.min.js" /></script>
		
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
		<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

	
	</head>
	<body>
		<jsp:include page="fragments/header.jsp"></jsp:include>
		<div class="container"  style="padding-top: 90px;">
	      <form class="form-horizontal" method="post" action="newProject" role="form" modelAttribute = "user"
	                    method = "post">

	                        <div class="form-group">
	                            <label for="projectName" class="col-sm-3 control-label">Requirement: </label>
	                            <div class="col-sm-8">
	                                <input type="text" class="form-control" id="requeriment" name="requirement"
	                                    placeholder="Requerements" />
	                            </div>
	                        </div>
	                         <div class="form-group">
      							<label for="comment">Comment:</label>
      							<textarea class="form-control" rows="5" id="comment"></textarea>
    						</div>
  		
							<div class="form-group">
							   <button class="btn btn-primary btn-lg btn-block" href="board">Add</button>
		       				</div>
	                   	</form>
	  	</div>
	<script src="<c:url value="/resources/bootstrap/js/bootstrap.min.js" />"></script>
	<%-- <jsp:include page="fragments/footer.jsp"></jsp:include>
	 #{include '_include/footer.html' /} --%>
	</body>
</html>