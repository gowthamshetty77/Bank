<%@page import="com.bank.dto.Customer"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Balance</title>
    <link rel="stylesheet" href="Balance.css">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css" rel="stylesheet">

    

    
</head>

<body>
	<%Customer c = (Customer)session.getAttribute("success"); %>
    
    <a href="Dashboard.jsp" id="button">
        <button>Back</button>
    </a>

    <div class="container">
    <h2>Your Available Balance</h2>
    <br>
    <%if(c!=null){ %>
    <h3 id="balance"><%=c.getBal() %></h3>
    <%}else{%>
    <h3 style="color: red;">No Data Available</h3>
    <%} %>
    </div>

</body>

</html>