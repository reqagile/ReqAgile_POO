<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
      <div class="navbar-header">
         <!-- <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
        </button> -->
        <a class="navbar-brand" href="./"><i class="glyphicon glyphicon-home"></i>
         	<spring:message code="show.titulo"/>
         </a>
         
     </div>
     <div class="navbar-collapse collapse">
        <div class="row" style="padding-top: 10px;">
 <%--        	<button type="button" class="btn btn-sm btn-success active navbar-right" onclick="location.href='criar_conta'"> <spring:message code="show.forgot.account" /> </button> --%>
           <button type="button" class="btn btn-sm btn-success active navbar-right" onclick="location.href=''">
           <i class="glyphicon glyphicon-lock"></i> <spring:message code="show.forgot.account" /> </button>
           <button type="button" style="margin-right: 5px;" class="btn btn-sm btn-success active navbar-right offset" onclick="location.href='cadastro'" > 
           <i class="glyphicon glyphicon-user"></i> <spring:message code="show.new.account" /> </button>
        </div>
     </div>
</div>