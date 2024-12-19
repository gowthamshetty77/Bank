<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Transfer Amount</title>
    <link rel="stylesheet" href="Transfer.css">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css" rel="stylesheet">

    

    
</head>

<body>
<%String failure = (String)request.getAttribute("failure");
String success = (String)request.getAttribute("success");%>
    
    <a href="Dashboard.jsp" id="button">
        <button>Back</button>
    </a>

    <div class="container">

       

            <h3>Transfer Amount</h3>
            <%if(failure!=null){ %>
            <h4 id="failure"><%=failure %></h4>
            <%} %>
            <%if(success!=null){ %>
            <h4 id="success"><%=success %></h4>
            <%} %>
            <div class="form-container">
            <form action="Transfer" method="POST">

                <label for="accNo">Account Number</label>
                <input type="number" name="accNo" id="accNo" placeholder="Enter the benificiary account number" required>

                <label for="amount"><i class="fa-solid fa-indian-rupee-sign"></i></label>
                <input type="number" name="amount" id="amount" placeholder="Amount in rupees" required>

                <label for="pin">Pin</label>
                <input type="password" name="pin" id="pin">

                

                

                <input type="submit" name="submit" value="Send" id="submit">
                
            </form>
        </div>
    </div>

</body>

</html>