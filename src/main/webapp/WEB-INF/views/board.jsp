<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
	<body>
	
	<jsp:include page="fragments/header.jsp"></jsp:include>
		<!-- Main -->
		<div class="container-fluid">
			<div class="row">
				<div class="col-sm-3">
					<!-- Left column -->
					<strong><i class="glyphicon glyphicon-th"></i> Tools</strong>
					<hr>
					<ul class="nav nav-stacked">
						<li class="active"><a href="#"><i class="glyphicon glyphicon-home"></i>
								Home</a></li>
						<li><a href="#"><i class="glyphicon glyphicon-user"></i>
								User List</a></li>
						<li><a href="#"><i class="glyphicon glyphicon-cog"></i>
								Settings</a></li>
						<li><a href="#"><i class="glyphicon glyphicon-envelope"></i>
								Messages <span class="badge badge-info">3</span></a></li>
						<li><a href="#"><i class="glyphicon glyphicon-flag"></i>
								Transactions</a></li>
					</ul>
	<!--				<ul class="nav nav-stacked collapse" id="menu2">
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
					</ul>
	-->
					<hr>
	
					<strong><i class="glyphicon glyphicon-link"></i> Resources</strong>
	
					<hr>
	
					<ul class="nav nav-pills nav-stacked">
						<li class="nav-header"></li>
						<li><a href="#"><i class="glyphicon glyphicon-list"></i>
								Requirements</a></li>
						<li><a href="#"><i class="glyphicon glyphicon-book"></i>
								Requirement Types</a></li>
						<li><a href="#"><i class="glyphicon glyphicon-list-alt"></i>
								Properties<i class="glyphicon glyphicon-chevron-right"></i></a></li>
						<li><a href="#"><i class="glyphicon glyphicon-star"></i>
								Favorites</a></li>
					</ul>
	
				</div>
				<!-- /col-3 -->
				<div class="col-sm-9">
					<div>
						<!-- column 2 -->
						<strong><i class="glyphicon glyphicon-dashboard"></i>Dashboard</strong>
		                <strong style="float: right;"><i class="glyphicon glyphicon-question-sign"></i>Help</strong>
						
					</div>
							
					<hr>
					
					<div class="col-md-6">
				    	<div class="btn-group btn-group-justified">
				        	<a href="newProject" class="btn btn-primary col-sm-3">
				            	<i class="glyphicon glyphicon-plus"></i>
				            	<br> New Project
				       		</a>
<<<<<<< HEAD
					        <a href="newRequirement" class="btn btn-primary col-sm-4" title="New Requirement">
=======
					        <a href="#" class="btn btn-primary col-sm-4" title="New Requirement">
>>>>>>> 53a9df6a7cd638638a6b4ad7dd28cfb18719735e
					            <i class="glyphicon glyphicon-plus"></i>
					            <i class="glyphicon glyphicon-list"></i>
				    	        <br> Requirement
				        	</a>
				        	<a href="typeRequirement" class="btn btn-primary col-sm-3" title="New Requirement Type">
					            <i class="glyphicon glyphicon-plus"></i>
				            	<i class="glyphicon glyphicon-book"></i>
				            	<br> Type
				        	</a>
				        	<a href="newProperty" class="btn btn-primary col-sm-3" title="New Property">
					        	<i class="glyphicon glyphicon-plus"></i>
				            	<i class="glyphicon glyphicon-list-alt"></i>
				            	<br> Property
				        	</a>
				    	</div>
				
				    	<hr>
				
						<div class="panel panel-default">
					        <div class="panel-heading">
					            <h4>Projects</h4>
					        </div>
				            <div class="panel-body">
				
								<a href="#"><small>ReqAgile</small></a>
				                <div class="progress">
				                    <div class="progress-bar progress-bar-success" role="progressbar" aria-valuenow="72" aria-valuemin="0" aria-valuemax="100" style="width: 72%">
				                        <span class="sr-only">72% Complete</span>
				                    </div>
				                </div>
				                <a href="#"><small>Midas</small></a>
				                <div class="progress">
				                    <div class="progress-bar progress-bar-info" role="progressbar" aria-valuenow="20" aria-valuemin="0" aria-valuemax="100" style="width: 20%">
				                        <span class="sr-only">20% Complete</span>
				                    </div>
				                </div>
				                <a href="#"><small>Game</small></a>
				                <div class="progress">
				                    <div class="progress-bar progress-bar-warning" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" style="width: 60%">
				                        <span class="sr-only">60% Complete (warning)</span>
				                    </div>
				                </div>
				                <a href="#"><small>Funai</small></a>
				                <div class="progress">
				                    <div class="progress-bar progress-bar-danger" role="progressbar" aria-valuenow="80" aria-valuemin="0" aria-valuemax="100" style="width: 80%">
				                        <span class="sr-only">80% Complete</span>
				                    </div>
				                </div>
				            </div>
					            <!--/panel-body-->
						</div>
				        <!--/panel-->
					</div>
	    <!--/col-->
					<div class="col-md-6">
						<div class="panel panel-default">
				            <div class="panel-heading">
				                <h4>Notices</h4>               				    
				            </div>
				            <div class="panel-body">
				                <p>This is a dashboard-style layout that uses Bootstrap 3. You can use this template as a starting point to create something more unique.</p>
				                <p>Visit the Bootstrap Playground at <a href="http://bootply.com">Bootply</a> to tweak this layout or discover more useful code snippets.</p>
				            </div>
				        </div>
						<hr>
	
						<div class="table-responsive">
	            			<table class="table table-striped">
				                <thead>
				                    <tr>
				                        <th>Visits</th>
				                        <th>ROI</th>
				                        <th>Source</th>
				                    </tr>
				                </thead>
		                		<tbody>
									<tr>
									    <td>45</td>
									    <td>2.45%</td>
									    <td>Direct</td>
									</tr>
									<tr>
									    <td>289</td>
									    <td>56.2%</td>
									    <td>Referral</td>
									</tr>
									<tr>
									    <td>98</td>
									    <td>25%</td>
									    <td>Type</td>
									</tr>
									<tr>
									    <td>05</td>
									    <td>47%</td>
									    <td>All</td>
									</tr>
								</tbody>
							</table>
						</div>
					</div>
					
					<div class="row">
					<!-- center left-->
					</div>
				</div>
			</div>
		</div>
	
	<script src="<c:url value="/resources/bootstrap/js/bootstrap.min.js" />"></script>
	<%-- <jsp:include page="fragments/footer.jsp"></jsp:include>
	 #{include '_include/footer.html' /} --%>
	 
	</body>
</html>