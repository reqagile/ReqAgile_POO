<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
	<meta http-equiv="content-type" content="text/html; charset=UTF-8">
	<title>Manager</title>
	
	<link rel="stylesheet" href="<c:url value="/resources/bootstrap/css/bootstrap.css" /> ">
	<!--[if lt IE 9]>
	<script src="//html5shim.googlecode.com/svn/trunk/html5.js"></script>
	<![endif]-->
	<link rel="stylesheet" href="<c:url value="/resources/bootstrap/css/styles.css" /> ">
	
	</head>
	<body>
		<!-- header -->
		<div id="top-nav" class="navbar navbar-inverse navbar-static-top">
			<div class="container-fluid">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle" data-toggle="collapse"
						data-target=".navbar-collapse">
						<span class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
					<a class="navbar-brand" ><img class="logo"
						src="resources/images/logo.png"></a>
				</div>
				<div class="navbar-collapse collapse">
					<ul class="nav navbar-nav navbar-right">
						<li class="dropdown"><a class="dropdown-toggle" role="button"
							data-toggle="dropdown" ><i
								class="glyphicon glyphicon-user"></i> Admin <span class="caret"></span></a>
							<ul id="g-account-menu" class="dropdown-menu" role="menu">
								<li><a href="#"><i class="glyphicon glyphicon-user"></i>
										My Profile</a></li>
								<li><a href="#"><i class="glyphicon glyphicon-envelope"></i>
										Messages <span class="badge badge-info">3</span></a></li>
								<li><a href="../"><i class="glyphicon glyphicon-cog"></i>
										Settings</a></li>
							</ul>
						</li>
						<li><a href="logout"><i class="glyphicon glyphicon-log-out"></i>
								Logout</a></li>
					</ul>
				</div>
			</div>
			<!-- /container -->
		</div>
		<!-- /Header -->
	
	
	</body>
</html>
