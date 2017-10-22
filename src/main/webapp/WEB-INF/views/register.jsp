<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
${ error }
	<h2>Register Here...</h2>
	<form:form method="post" action="${ pageContext.request.contextPath }/register" enctype="multipart/form-data">
		<div>
			<label>Full Name:</label>
			<input type="text" name="fullName" value="${ p.fullName }" autofocus/>
		</div>
		<div>
			<label>Country</label>
			<input type="text" name="country" value="${a.country}" />
		</div>
		<div>
			<label>State</label>
			<input type="text" name="state" value="${a.state}" />
		</div>
		<div>
			<label>City</label>
			<input type="text" name="city" value="${a.city}" />
		</div>
		<div>
			<label>Street</label>
			<input type="text" name="street" value="${a.street}"/>
		</div>
		<div>
			<label>Zip</label>
			<input type="text" name="zip" value="${a.zip}"/>
		</div>
		<div>
			<label>Mobile</label>
			<input type="text" name="mobile" value="${ p.mobile }"/>
		</div>
		<div>
			<label>Username</label>
			<input type="text" name="username" value="${ u.username }" required/>
		</div>
		<div>
			<label>Password</label>
			<input type="password" name="password" required/>
		</div>
		<div>
			<label>Confirm Password</label>
			<input type="password" name="cpassword" required/>
		</div>
		<div>
			<label>Photo</label>
			<input type="file" id="photo" name="myphoto"/>
		</div>
		<input type="submit" value="Register"/>
	</form:form>
	
</body>
</html>