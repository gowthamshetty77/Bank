<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
    <link rel="stylesheet" href="Login.css">
</head>

<body>
<%
 String failure = (String)request.getAttribute("failure");
	%>
    <div class="container">

        <div class="img-container">
            
        </div>


        <div class="form-contaier">

            <h2>Login</h2>
            
            <%if(failure!=null){ %>
  				<h3 id="failure"><%=failure %></h3>
			<%} %>

            <form action="Login" method="post">

                <label for="accNo">Acc No</label>
                <input type="text" name="accNo" id="accNo" required>

                <label for="password">password</label>
                <input type="password" name="password" id="password" minlength="4" required>

               

                <input type="submit" name="submit" value="Login" id="submit">
                <p>Don't have a account? <a href="SignUp.jsp"> SignUp!</a></p>
            </form>
        </div>
    </div>

</body>

</html>