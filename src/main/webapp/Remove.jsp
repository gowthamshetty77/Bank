<%@page import="com.bank.dao.CustomerDAOImpl"%>
<%@page import="com.bank.dao.CustomerDAO"%>
<%@page import="com.bank.dto.Customer"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Delete Customer</title>
    <link rel="stylesheet" href="Remove.css">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css" rel="stylesheet">

    

    
</head>

<body>
<%
	Customer c = (Customer)session.getAttribute("success");

	String failure = (String)request.getAttribute("failure");
	CustomerDAO cdao = new CustomerDAOImpl();
	if(c!=null){
	List<Customer> cc = cdao.getCustomer();
	
%>
    <h1 id="heading">Delete The Account</h1>
    <a href="Dashboard.jsp" id="button">
        <button>Back</button>
    </a>
    
    <% if(failure!=null){%>
    <h2><%=failure %></h2>
    <%} %>
    
    

    <div class="container">
			
	
    
    <div class="body">
    
    
    
    	<table>
    	
    	<tr id="head">
    		<th>ACC_NO</th>
    		<th>Name</th>
    		<th>Phone</th>
    		<th>Mail</th>
    		<th>Balance</th>
    		<th>Delete</th>
    	</tr>
    	
    	<%Iterator<Customer> cs = cc.iterator();
		while(cs.hasNext()){
			Customer ct  = cs.next();
		
		%>
		<tr>
		
			<td><%=ct.getAccNo() %></td>
			<td><%=ct.getName() %></td>
			<td><%=ct.getPhone() %></td>
			<td><%=ct.getMail() %></td>
			<td><%=ct.getBal() %></td>
			<td>
			<form action="Remove" method="post">
    			<input type="hidden" name="remove" value="<%= ct.getAccNo() %>">
    			<button id="remove" type="submit" >Delete</button>
			</form>
			</td>
		
		
		</tr>
		
	<%}} %>
    	
    </table>
     </div>
       

        </form>
    </div>

</body>

</html>