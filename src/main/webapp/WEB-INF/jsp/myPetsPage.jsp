<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>My Pets</title>
</head>
<body>
	<nav class="navbar navbar-inverse">
	<div class="container-fluid">
		<div class="navbar-header">
			<a class="navbar-brand" href="#">PetShop</a>
		</div>
		<ul class="nav navbar-nav">
			<li><a href="home">Home</a></li>
			<li class="active"><a href="#">My Pet</a></li>
			<li><a href="addPet">Add Pet</a></li>
		</ul>
		<ul class="nav navbar-nav navbar-right">
			<li><a href="logout"><span class="glyphicon glyphicon-log-in"></span>
					Logout</a></li>
		</ul>
		
		
	</div>
	
	</nav>
	<div align="center" class="table-responsive">
		<table class="table table-striped">
			<thead>
				<tr>
					<th>PET Id</th>
					<th>PET Name</th>
					<th>PET Age</th>
					<th>PET Place</th>

				</tr>
			</thead>
			<tbody>
				
				<c:forEach items="${myPets}" var="pet">
				
				<tr>
					<td>${pet.getPetId()}</td>
					<td>${pet.getPetName()}</td>
					<td>${pet.getPetAge()}</td>
					<td>${pet.getPetPlace()}</td>
								
				</tr>
				
				</c:forEach>
			</tbody>
		</table>
	</div>

</body>
</html>