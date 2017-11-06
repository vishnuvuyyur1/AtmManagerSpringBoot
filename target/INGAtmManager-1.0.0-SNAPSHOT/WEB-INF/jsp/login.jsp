<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
<head>
<link rel="stylesheet" type="text/css"
	href="webjars/bootstrap/3.3.6/css/bootstrap.min.css" />
		
	<title>ING Secure Login</title>
</head>
<body>
<div id="ing_login_form_content" style="margin-top: 60px;">

<c:if test="${param.error!=null}">
Invalid credentials
</c:if>

<form  action="/ingatmmanager/login" method="post" class="form-horizontal ing_login_form" id="ing_city_form">
   <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" /> 
  <div class="form-group">
    <label class="control-label col-sm-2" for="user">User Name:</label>
    <div class="col-sm-4">
      <input type="text" class="form-control" id="ing_login_form_user" placeholder="Enter user name" name="username">
    </div>
  </div>
  <div class="form-group">
    <label class="control-label col-sm-2" for="pwd">Password:</label>
    <div class="col-sm-4"> 
      <input type="password" class="form-control" id="ing_login_form_pwd" placeholder="Enter password" name="password">
    </div>
  </div>
 
  <div class="form-group"> 
    <div class="col-sm-offset-2 col-sm-4">
      <button type="submit" class="btn btn-default" id="ing_login_form_submit">Submit</button>
    </div>
  </div>
  
  <div>
  <p>User     : user</p>
  <p>Password : temp</p>
  </div>
</form>
</div>
</body>
</html>