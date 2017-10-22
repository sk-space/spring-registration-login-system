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
	<h2>Login Here...</h2>
	<form:form method="post" action="${ pageContext.request.contextPath }/login">
		<div>
			<label>Username: </label>
			<input type="text" name="username" value="${ u.username }" autofocus/>
		</div>
		<div>
			<label>Password: </label>
			<input type="password" name="password" />
		</div>
		<input type="submit" value="Login" />
	</form:form>
</body>
</html>