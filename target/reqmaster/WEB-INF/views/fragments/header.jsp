<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<title>Header</title>

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
				<a class="navbar-brand" href="./"><img class="logo"
					src="resources/images/logo.png"></a>
			</div>
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav navbar-right">
					<li class="dropdown"><a class="dropdown-toggle" role="button"
						data-toggle="dropdown" href="#"><i
							class="glyphicon glyphicon-user"></i> Admin <span class="caret"></span></a>
						<ul id="g-account-menu" class="dropdown-menu" role="menu">
							<li><a href="#"><i class="glyphicon glyphicon-user"></i>
									My Profile</a></li>
							<li><a href="#"><i class="glyphicon glyphicon-envelope"></i>
									Messages <span class="badge badge-info">3</span></a></li>
							<li><a href="../"><i class="glyphicon glyphicon-cog"></i>
									Settings</a></li>
						</ul></li>
					<li><a href="../"><i class="glyphicon glyphicon-log-out"></i>
							Logout</a></li>
				</ul>
			</div>
		</div>
		<!-- /container -->
	</div>
	<!-- /Header -->

	<!-- Main -->
	<div class="container-fluid">
		<div class="row">
			<div class="col-sm-3">
				<!-- Left column -->
				<strong><i class="glyphicon glyphicon-th"></i> Tools</strong>

				<hr>

				<ul class="nav nav-stacked">
					<li class="nav-header"><a href="#" data-toggle="collapse"
						data-target="#userMenu">Settings <i
							class="glyphicon glyphicon-chevron-right"></i></a>
						<ul class="nav nav-stacked collapse" id="userMenu">
							<li class="active"><a href="#"><i
									class="glyphicon glyphicon-home"></i> Home</a></li>
							<li><a href="#"><i class="glyphicon glyphicon-envelope"></i>
									Messages <span class="badge badge-info">3</span></a></li>
							<li><a href="#"><i class="glyphicon glyphicon-cog"></i>
									Options</a></li>
							<li><a href="#"><i class="glyphicon glyphicon-user"></i>
									Staff List</a></li>
							<li><a href="#"><i class="glyphicon glyphicon-flag"></i>
									Transactions</a></li>
							<li><a href="#"><i class="glyphicon glyphicon-off"></i>
									Logout</a></li>
						</ul></li>
					<li class="nav-header"><a href="#" data-toggle="collapse"
						data-target="#menu2"> Reports <i
							class="glyphicon glyphicon-chevron-right"></i></a>

						<ul class="nav nav-stacked collapse" id="menu2">
							<li><a href="#"><i class="glyphicon glyphicon-stats"></i>
									Information &amp; Stats</a></li>
							<li><a href="#"><i class="glyphicon glyphicon-eye-open"></i>
									Views</a></li>
							<li><a href="#"><i
									class="glyphicon glyphicon-arrow-down"></i> Requests</a></li>
							<li><a href="#"><i class="glyphicon glyphicon-hourglass"></i>
									Timetable</a></li>
							<li><a href="#"><i
									class="glyphicon glyphicon-exclamation-sign"></i> Alerts</a></li>
						</ul></li>
				</ul>

				<hr>

				<strong><i class="glyphicon glyphicon-link"></i> Resources</strong>

				<hr>

				<ul class="nav nav-pills nav-stacked">
					<li class="nav-header"></li>
					<li><a href="#"><i class="glyphicon glyphicon-list"></i>
							Layouts &amp; Templates</a></li>
					<li><a href="#"><i class="glyphicon glyphicon-link"></i>
							Widgets</a></li>
					<li><a href="#"><i class="glyphicon glyphicon-list-alt"></i>
							Reports</a></li>
					<li><a href="#"><i class="glyphicon glyphicon-book"></i>
							Pages</a></li>
					<li><a href="#"><i class="glyphicon glyphicon-star"></i>
							Social Media</a></li>
				</ul>

			</div>
			<!-- /col-3 -->
			<div class="col-sm-9">

				<!-- column 2 -->
				<strong><i class="glyphicon glyphicon-dashboard"></i>
					Dashboard</strong>
				<hr>

				<div class="row">
					<!-- center left-->
				</div>
			</div>
		</div>
	</div>
</body>
</html>
