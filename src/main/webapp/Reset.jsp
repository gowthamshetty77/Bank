<%@page import="com.bank.dto.Customer"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Reset Pin</title>
    <link rel="stylesheet" href="Reset.css">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css" rel="stylesheet">

    

    
</head>

<body>
<%	
	Customer c = (Customer) session.getAttribute("success");
	String success = (String)request.getAttribute("success");
	String failure = (String)request.getAttribute("failure");
%>
    
    <a href="Dashboard.jsp" id="button">
        <button>Back</button>
    </a>
    

    <div class="container">

        <h1>Reset Pin</h1>
        
        
        <%if(success!=null){ %>
        <h3 id="success"><%=success%></h2>
        <%} %>
        
        
        <%if(failure!=null){ %>
        <h3 id="failure"><%=failure%></h2>
        <%} %>
        

        <form action="Reset" method="post">
            

            
            <label for="accNo">Acc No</label>
            <input type="number" name="accNo" id="accNo" value="<%=c.getAccNo() %>" required="required">

            <label for="email">Email Id</label>
            <input type="email" name="email" id="email" required="required">
            
            <label for="email">Pin</label>
            <input type="password" name="pin" id="pin"  minlength="4" required="required">
            
            <label for="confirm">confirm</label>
            <input type="password" name="confirm" id="confirm"  minlength="4" required="required">
            
            
            <input type="submit" name="submit" id="submit" value="Reset">

        </form>
    </div>

</body>

</html>