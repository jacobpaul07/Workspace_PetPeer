<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Pet</title>
</head>
<script type="text/javascript">
	function validate() {
		if (document.getElementById("Name").value == "") {
			document.getElementById("error").innerHTML = "<center>Pet Name required</center>";
			return false;
		} else if (document.getElementById("Age").value == "") {
			document.getElementById("error").innerHTML = "<center>Pet Age required</center>";
			return false;
		} else if (document.getElementById("Age").value < 0
				|| document.getElementById("Age").value > 99) {
			document.getElementById("error").innerHTML = "<center>Age should be 0 and 99 years </center>";
			return false;

		} else if (document.getElementById("place").value == "") {
			document.getElementById("error").innerHTML = "<center>Pet Place required</center>";
			return false;
		} else {
			return true;
		}
	}
</script>
<body>
	<nav class="navbar navbar-inverse">
	<div class="container-fluid">
		<div class="navbar-header">
			<a class="navbar-brand" href="#">PetShop</a>
		</div>
		<ul class="nav navbar-nav">
			<li><a href="home">Home</a></li>
			<li><a href="myPets">My Pet</a></li>
			<li class="active"><a href="#">Add Pet</a></li>
		</ul>
		<ul class="nav navbar-nav navbar-right">
			<li><a href="logout"><span
					class="glyphicon glyphicon-log-out"></span> Logout</a></li>
		</ul>
	</div>
	</nav>

	<center>
		<h2>Pet Information</h2>
		<p id="error" style="color: red;">${errorMsg }</p>
		<form:form action="savePet" modelAttribute="pet">

			<table>
				<tr>
					<td>Name</td>
					<td><form:input id="Name" path="petName" class="form-control" /></td>

				</tr>
				<tr>
					<td>Age</td>
					<td><form:input id="Age" path="petAge" class="form-control" /></td>
				</tr>

				<tr>
					<td>Place</td>
					<td><form:input id="place" path="petPlace"
							class="form-control" /></td>
				</tr>
				<tr>
				</tr>
			</table>
			<br>
			<input type="submit" value="Add Pet" onclick="return validate()"
				class="btn btn-primary">
			<input type="reset" value="cancel" class="btn btn-primary">
		</form:form>
	</center>

</body>
</html>