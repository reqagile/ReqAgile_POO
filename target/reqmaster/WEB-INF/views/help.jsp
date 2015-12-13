<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<jsp:include page="fragments/header.jsp"></jsp:include>
<div class="col-md-6">
    <div class="btn-group btn-group-justified">
        <a href="newProject" class="btn btn-primary col-sm-3">
            <i class="glyphicon glyphicon-plus"></i>
            <br> New Project
        </a>
        <a href="#" class="btn btn-primary col-sm-3">
            <i class="glyphicon glyphicon-cloud"></i>
            <br> Cloud
        </a>
        <a href="#" class="btn btn-primary col-sm-3">
            <i class="glyphicon glyphicon-cog"></i>
            <br> Tools
        </a>
        <a href="#" class="btn btn-primary col-sm-3">
            <i class="glyphicon glyphicon-question-sign"></i>
            <br> Help
        </a>
    </div>

    <hr>

    <div class="panel panel-default">
        <div class="panel-heading">
            <h4>Projects</h4></div>
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
                <h4>Notices</h4></div>
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

<jsp:include page="fragments/footer.jsp"></jsp:include>
<%-- #{include '_include/footer.html' /} --%>