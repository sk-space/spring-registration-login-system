<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>

	${ error }
	
	<input type="button" value="Register" onclick="register()">
	<input type="button" value="Login" onclick="login()">
	
	<script type="text/javascript">
		function register(){
			location.href = "${pageContext.request.contextPath}/register";
		}
		
		function login(){
			location.href = "${pageContext.request.contextPath}/login";
		}
	</script>
	
</body>
</html>
