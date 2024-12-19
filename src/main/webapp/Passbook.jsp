<%@page import="com.bank.dto.Transaction"%>
<%@page import="com.bank.dao.TransactionDAOImpl"%>
<%@page import="com.bank.dao.TransactionDAO"%>
<%@page import="java.util.*"%>

<%@page import="com.bank.dto.Customer"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Passbook</title>
    <link rel="stylesheet" href="Passbook.css">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css" rel="stylesheet">

    

    
</head>

<body>
<h1 id="heading">Passbook</h1>
<%Customer c = (Customer)session.getAttribute("success");
TransactionDAO tdao = new TransactionDAOImpl();
	List<Transaction> t = tdao.getTransation(c.getAccNo());
%>
    
    <a href="Dashboard.jsp" id="button">
        <button>Back</button>
    </a>

    <div class="container">
    
    <div class="head">
 
    </div>
    <div class="body">
    
    	<table>
    	<tr id=head>
    		<th>TRAN_ID</th>
    		<th>USER_ACC</th>
    		<th>REC_ACC</th>
    		<th>TRAN_DATE</th>
    		<th>TRAN_TYPE</th>
    		<th>AMOUNT</th>
    		<th>BALANCE</th>
    	</tr>
    	
    	<%Iterator<Transaction> tr = t.iterator();
    		while(tr.hasNext()){
    			Transaction ts = tr.next();
    		
    		%>
    		
    		<tr>
    		
    		<td><%=ts.getTransID() %></td>
    		<td><%=ts.getUserAcc() %></td>
    		<td><%=ts.getRecAcc() %></td>
    		<td><%=ts.getDate() %></td>
    		<td><%=ts.getTransType() %></td>
    		<td><%=ts.getAmount() %></td>
    		<td><%=ts.getBalance() %></td>
    		
    		</tr>
    		
    	<%} %>
    	
    </table>
     </div>
    </div>
   

</body>

</html>