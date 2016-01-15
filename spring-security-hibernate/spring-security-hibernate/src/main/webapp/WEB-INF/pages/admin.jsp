<%@page import="com.yogi.vehicle.model.Vehicles"%>
<%@page import="java.util.List"%>
<%@page import="com.yogi.vehicle.*"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<html>
<body>
	<h1>Title : ${title}</h1>
	
	<%
		List<Vehicles> vehicles = (List) request.getAttribute("vehicleList");
	
		for(Vehicles vehicle:vehicles){
			System.out.println(vehicle.getVehicle_name());
		}
	%>
	 
 	
 	
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

</body>
</html>