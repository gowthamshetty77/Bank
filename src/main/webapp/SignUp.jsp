<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>SignUp</title>
    <link rel="stylesheet" href="SignUp.css">

    
</head>

<body>
<%String success = (String)request.getAttribute("success");
 String failure = (String)request.getAttribute("failure");
	%>
    <div class="container">

        <div class="img-container">
            <h2>Secure your future,</h2>
            <br>
            <h3>one step at a time.</h3>
        </div>


        <div class="form-contaier">
        
       
		
            <h2>Sign Up</h2>
            
              <%if(success!=null){ %>
  				<h3 id="success"><%=success %></h3>
			<%} %>
            
            <%if(failure!=null){ %>
  				<h3 id="failure"><%=failure %></h3>
			<%} %>
            
           

            <form action="SignUp" method="POST">
                <label for="name">Name</label>
                <input type="text" name="name" id="name" required>

                <label for="phone">phone No</label>
                <input type="tel" name="phone" id="phone" required>

                <label for="email">Email ID</label>
                <input type="email" name="email" id="email" required>

                <label for="password">password</label>
                <input type="password" name="password" id="password" minlength="4" required>

                <label for="confirm">Confirm password</label>
                <input type="password" name="confirm" id="confirm" minlength="4" required>

                <input type="submit" name="submit" value="SignUp" id="submit">
                <p>Already have a account? <a href="Login.jsp"> login!</a></p>
            </form>
        </div>
    </div>

</body>

</html>