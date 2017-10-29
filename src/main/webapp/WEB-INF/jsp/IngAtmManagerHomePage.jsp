<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
<head>

<link rel="stylesheet" type="text/css"
	href="webjars/bootstrap/3.3.6/css/bootstrap.min.css" />
	<link rel="stylesheet" type="text/css"
	href="webjars/datatables/1.10.9/css/jquery.dataTables.css" />
	<link rel="stylesheet" type="text/css"
	href="webjars/datatables/1.10.9/css/jquery.dataTables.min.css" />

<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/styles/IgnAtmManagerHomePage.css" />
<title>ING ATM Manager</title>
</head>
<body>

	<nav class="navbar navbar-inverse">
		<div class="container">
			<div class="navbar-header">
				<a class="navbar-brand ing_mainpage_nav_firsttab" href="#">IGN
					ATM Manager</a>
			</div>
			<div id="navbar" class="collapse navbar-collapse">
				<ul class="nav navbar-nav">
					<li class="ing_mainpage_nav_secondtab"><a href="#">create
							ING Atm</a></li>
				</ul>
			</div>
		</div>
	</nav>

	<div class="ing_mainpage_content ingmanager_content">
	
	<div class="ing_welcome_content ingmanager_content">
		<img class="ing_welcome_cover"
			src="${pageContext.request.contextPath}/resources/images/INGCoverPic.jpg" />
		<div class="ing_welcome_message text-center">
			<h1>${message}</h1>
		</div>
		<button type="button" class="btn btn-primary"
			id="ing_welcome_viewatms_button">Click to see our ATM
			Locations</button>
	</div>
	

	<div class="ing_createingatm_content ingmanager_content hidden">
		<jsp:include
			page="/WEB-INF/jsp/createAndViewIngAtms.jsp" />
	</div>
	
	<div class="ing_atmsList_content ingmanager_content well hidden">
		<jsp:include
			page="/WEB-INF/jsp/ingAtmsDisplay.jsp" />
	</div>
	
	</div>
	
	<script type="text/javascript" src="webjars/jquery/2.1.4/jquery.js"></script>
	<script type="text/javascript" src="webjars/jquery/2.1.4/jquery.min.js"></script>
	<script type="text/javascript" src="webjars/datatables/1.10.9/js/jquery.dataTables.js"></script>
	<script type="text/javascript"
		src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/resources/script/IngAtmManagerHomePage.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/resources/script/createIngAtms.js"></script>
		<script type="text/javascript"
		src="${pageContext.request.contextPath}/resources/script/navigaton.js"></script>
</body>

</html>
