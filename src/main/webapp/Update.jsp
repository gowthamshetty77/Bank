<%@page import="com.bank.dto.Customer"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Update</title>
    <link rel="stylesheet" href="Update.css">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css" rel="stylesheet">

    

    
</head>

<body>
<%Customer c = (Customer)session.getAttribute("success");
	String success = (String)request.getAttribute("success");
	String failure = (String)request.getAttribute("failure");
%>
    
    <a href="Dashboard.jsp" id="button">
        <button>Back</button>
    </a>
    

    <div class="container">

        <h1>Update Your Account</h1>
        <%if(c!=null){ %>
        <h3>Acc No :<%=c.getAccNo() %></h2>
        <%} %>
        
        
        <%if(success!=null){ %>
        <h3 id="success"><%=success%></h2>
        <%} %>
        
        
        <%if(failure!=null){ %>
        <h3 id="failure"><%=failure%></h2>
        <%} %>
        

        <form action="Update" method="post">
            <label for="name">Name</label>
            <input type="text" name="name" id="name" value="<%=c.getName()%>">

            
            <label for="phone">Phone</label>
            <input type="tel" name="phone" id="phone" value="<%=c.getPhone()%>">

            <label for="email">Email Id</label>
            <input type="email" name="email" id="email" value="<%=c.getMail()%>">
            
            <input type="submit" name="submit" id="submit" value="Update">

        </form>
    </div>

</body>

</html>