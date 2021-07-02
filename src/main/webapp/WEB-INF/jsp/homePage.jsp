<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"
      xmlns:th="http://www.thymeleaf.org">
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<title>Home Page</title>
</head>
<body>
	<!-- <nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="./">WebSiteName</a>
    </div>
    
    <ul class="nav navbar-nav navbar-right">
      <li><a href="addPet"><span class="glyphicon glyphicon-user"></span> Add pet</a></li>
      <li><a href="#"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
    </ul>
  </div>
</nav> -->

	<nav class="navbar navbar-inverse">
	<div class="container-fluid">
		<div class="navbar-header">
			<a class="navbar-brand" href="home">PetShop</a>
		</div>
		<ul class="nav navbar-nav">
			<li class="active"><a href="home">Home</a></li>
			<li><a href="myPets">My Pet</a></li>
			<li><a href="addPet">Add Pet</a></li>
		</ul>
		<ul class="nav navbar-nav navbar-right">
			<li><a href="logout"><span
					class="glyphicon glyphicon-log-in"></span> Logout</a></li>
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
					<th>PET Buy</th>

				</tr>
			</thead>
			<tbody>
				<c:forEach items="${pets}" var="pet">
				
				<tr>
					<td>${pet.getPetId()}</td>
					<td>${pet.getPetName()}</td>
					<td>${pet.getPetAge()}</td>
					<td>${pet.getPetPlace()}</td>
					
					<td>
					<form action="buyPet" method = "get">
					<c:set var="iter" value="${pet.getUser().getUserId()}"/>
					<c:choose>
					<c:when test="${iter >0 }">
					
					<input type="button" value="Sold" disabled="disabled">
					</c:when>
					<c:otherwise>
					<input type="hidden" name="petId" value="${pet.getPetId()}"/>
					<input type = "submit" value = "Buy" class = "btn btn-primary"/>
					</c:otherwise>
					</c:choose>
					</form>
					</td>
					
				
				</tr>
				
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>