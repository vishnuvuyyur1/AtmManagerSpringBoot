<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page session="false" %>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/styles/IgnAtmManagerHomePage.css" />
<table id="ing_cityatms_tabel" class="table table-bordered display">
<thead>
<tr>
<th>Street</th>
<th>House Number</th>
<th>Postal Code</th>
<th>City</th>
<th>Latitude</th>
<th>Longitude</th>
</tr>
</thead>
 <tbody id="ing_cityatms_tabel_body"></tbody>
</table>