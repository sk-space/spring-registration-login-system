<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
	<h2>Register Here...</h2>
	<form method="post" action="register" enctype="multipart/form-data">
		<div>
			<label>Full Name:</label>
			<input type="text" name="fullName" required autofocus/>
		</div>
		<div>
			<label>Country</label>
			<input type="text" name="country"/>
		</div>
		<div>
			<label>State</label>
			<input type="text" name="state"/>
		</div>
		<div>
			<label>City</label>
			<input type="text" name="city" required/>
		</div>
		<div>
			<label>Street</label>
			<input type="text" name="street"/>
		</div>
		<div>
			<label>Zip</label>
			<input type="text" name="zip"/>
		</div>
		<div>
			<label>Mobile</label>
			<input type="text" name="mobile"/>
		</div>
		<div>
			<label>Username</label>
			<input type="text" name="username" required/>
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
			<input type="file" name="photo"/>
		</div>
		<input type="submit" value="Register"/>
	</form>
</body>
</html>
