<%@page import="com.bank.dao.CustomerDAOImpl"%>
<%@page import="com.bank.dao.CustomerDAO"%>
<%@page import="com.bank.dto.Transaction"%>
<%@page import="com.bank.dao.TransactionDAOImpl"%>
<%@page import="com.bank.dao.TransactionDAO"%>
<%@page import="java.util.*"%>

<%@page import="com.bank.dto.Customer"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">


</style>

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Accounts Details</title>
    <link rel="stylesheet" href="test.css">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css" rel="stylesheet">

    

    
</head>

<body>

<h2 id="heading">All Bank Accounts Details</h2>
<%Customer c = (Customer)session.getAttribute("success");
CustomerDAO cdao = new CustomerDAOImpl();
	List<Customer> cc = cdao.getCustomer();
%>
    
    <a href="Dashboard.jsp" id="button">
        <button>Back</button>
    </a>

    <div class="container">
    
   
    <div class="body">
    
    	<table>
    	
    	<thead >
    	
    	<tr id="head" >
    		<th>ACC_NO</th>
    		<th>Name</th>
    		<th>Phone</th>
    		<th>Mail</th>
    		<th>Balance</th>
    		<th>Pin</th>
    		
    	</tr>
    	
    	</thead>
    	
    	
    	<%
    	int i=0;
    		while(i!=20){
    			i++;
    		
    		%>
    		
    		<tr>
    		
    		<td>ct.getAccNo() %></td>
    		<td>ct.getName() %></td>
    		<td>ct.getPhone() %>C</td>
    		<td>ct.getMail() %></td>
    		<td>ct.getBal() %></td>
    		<td>ct.getPin() %></td>
    		
    		
    		</tr>
    		
    		
    	<%} %>
    	
    </table>
     </div>
    </div>
   

</body>

</html>