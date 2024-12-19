
<!DOCTYPE html>
<%@page import="com.bank.dto.Customer"%>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Deposite</title>
    <link rel="stylesheet" href="Deposite.css">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css" rel="stylesheet">

    

    
</head>

<body>
	<%Customer c = (Customer)request.getAttribute("success"); 
		String failure = (String)request.getAttribute("failure");%>
    
    <a href="Dashboard.jsp" id="button">
        <button>Back</button>
    </a>
   	

    <div class="container">

       		

            <h3>Enter the amount to be deposited</h3>
            <%if(c!=null){ %>
    			<h4 style="color: green;">Deposited Successfully</h4>	
   			<%} %>
            <%if(failure!=null){ %>
            <h4 id="failure"><%=failure %></h4>
            <%} %>
            <div class="form-container">
            <form action="Deposite" method="POST">

                <label for="amount"><i class="fa-solid fa-indian-rupee-sign"></i></label>
                <input type="number" name="amount" id="amount" placeholder="Amount in rupees" required>
                
                <label for="pin">Pin</label>
                <input type="password" name="pin" id="pin" placeholder="Enter the pin" required">

                

                <input type="submit" name="submit" value="Deposite" id="submit">
                
            </form>
        </div>
    </div>
    
    <%if(c!=null){ %>
    
   
   	<h3 id="balance">Current Balance : <%=c.getBal() %></h3>
   	<%} %>

</body>

</html>