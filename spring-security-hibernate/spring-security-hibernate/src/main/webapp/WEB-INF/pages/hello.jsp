<%@page import="com.yogi.master.model.Vehicles"%>
<%@page import="java.util.List"%>
<%@page import="com.yogi.master.*"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<html lang="en" ng-app="AngularSpringApp">

<head>
    <meta charset="utf-8"/>
    <title>Service App</title>
    <link rel="stylesheet" href="resources/css/app.css"/>
    <link rel="stylesheet" href="resources/bootstrap/css/bootstrap.min.css" />
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" />
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css" />
    <link rel="stylesheet" type="text/css" href="resources/css/ngDatepicker.css">
    
    
    
    
</head>
<body >
	<h1>Title : ${title}</h1>
	<c:url value="/j_spring_security_logout" var="logoutUrl" />
	<form action="${logoutUrl}" method="post" id="logoutForm">
		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />
	</form>
<script>
		function formSubmit() {
			document.getElementById("logoutForm").submit();
		}
	</script>

	<c:if test="${pageContext.request.userPrincipal.name != null}">
		<h2>
			Welcome : ${pageContext.request.userPrincipal.name} | <a href="javascript:formSubmit()"> Logout</a>
		</h2>
	</c:if>
<div id="wrapper">
    <ul class="menu">
        <li><a href="#/master">Masters</a></li>
        <li><a href="#/railwaystations">Daily Update</a></li>
        <li><a href="#/trains">Reports</a></li>
        <li><a href="#/railwaystations">Analysis</a></li>
         
    </ul>
    <hr class="" />
    <div ng-view=""></div>
</div>

 <!-- <script src="resources/js/lib/angular/angular.js"></script> -->
 <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.5/angular.js"></script>
 <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.5/angular-route.js"></script>
 <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.10.3/moment-with-locales.min.js"></script>
<!--  <script type="text/javascript" src="resources/js/lib/angular/angular-route.js"></script> -->
 <script type="text/javascript" src="resources/js/lib/angular/ngDatepicker.js"></script>

<script src="resources/js/app.js"></script>
<script src="resources/js/services.js"></script>
<script src="resources/js/controllers/RailwayStationController.js"></script>
<script src="resources/js/controllers/MasterController.js"></script>
<script src="resources/js/controllers/TrainController.js"></script>
<script src="resources/js/filters.js"></script>
<script src="resources/js/directives.js"></script>

</body>
</html>
