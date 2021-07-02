<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
     pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
<link rel="stylesheet"
href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
</head>
<script type="text/javascript">
     function validate() {
          if (document.getElementById("userName").value == "") {
              document.getElementById("error").innerHTML = "<center>User Name required</center>";
              return false;
          } else if (document.getElementById("userPassword").value == "") {
              document.getElementById("error").innerHTML = "<center>Password required</center>";
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
              <a class="navbar-brand" href="./">Pet Shop</a>
          </div>
          <ul class="nav navbar-nav navbar-right">
              <li><a href="registration"><span
                        class="glyphicon glyphicon-user"></span> Sign Up</a></li>
          </ul>

     </div>
     </nav>
     <div class="container">
   <h4> Login</h4>
          <p id="error" style="color: red;">${errorMsg }</p>
          <p id ="success" style = "color : green;">${successMsg }</p>
          <form:form action="authenticateUser"  modelAttribute="user">
              <label for="Name">Name:</label>
              <form:input path="userName" class="form-control" />
              <br>
              <label for="password">Password:</label>
              <form:password path="userPassword" class="form-control" />
              <br>
              <input type="submit" value="LogIn" onclick="return validate()"
                   class="btn btn-primary" />
          </form:form>
     </div>
</body>
</html>
