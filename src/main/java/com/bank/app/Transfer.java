package com.bank.app;

import java.io.IOException;

import com.bank.dao.CustomerDAO;
import com.bank.dao.CustomerDAOImpl;
import com.bank.dao.TransactionDAO;
import com.bank.dao.TransactionDAOImpl;
import com.bank.dto.Customer;
import com.bank.dto.Transaction;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/Transfer")
public class Transfer extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String acc = req.getParameter("accNo");
		long accNo = Long.parseLong(acc);
		
		String amt = req.getParameter("amount");
		int amount = Integer.parseInt(amt);
		
		String pass = req.getParameter("pin");
		int pin = Integer.parseInt(pass);
		
		HttpSession session = req.getSession(false);
		Customer cc = (Customer) session.getAttribute("success");
		CustomerDAO cdao = new CustomerDAOImpl();
		
		Transaction t1=null;
		Transaction t2=null;
		
		TransactionDAO ti = new TransactionDAOImpl();
		
		if(cc.getBal()>amount && amount>0 && cc.getPin()==pin && cc.getAccNo()!=accNo) {
			cc.setBal(cc.getBal()-amount);
			boolean result1 = cdao.updateCustomer(cc);
			if(result1) {
				t1= new Transaction();
				t1.setTransID(TransactionID.generateTransactionId());
				t1.setUserAcc(cc.getAccNo());
				t1.setRecAcc(accNo);
				t1.setTransType("Debited");
				t1.setAmount(amount);
				t1.setBalance(cc.getBal());
				ti.insertTransaction(t1);
				
			}
			
			
		
				Customer r = cdao.getCustomer(accNo);
				r.setBal(r.getBal()+amount);
				boolean result2=cdao.updateCustomer(r);
				if(result2) {
					t2= new Transaction();
					t2.setTransID(t1.getTransID());
					t2.setUserAcc(accNo);
					t2.setRecAcc(r.getAccNo());
					t2.setTransType("Credited");
					t2.setAmount(amount);
					t2.setBalance(r.getBal());
					ti.insertTransaction(t2);
					
				
				
				if(result1&&result2) {
					req.setAttribute("success", "Transaction Successfull");
					RequestDispatcher rd = req.getRequestDispatcher("Transfer.jsp");
					rd.forward(req, resp);
				}else {
					req.setAttribute("failure","Transaction failed");
					RequestDispatcher rd = req.getRequestDispatcher("Transfer.jsp");
					rd.forward(req, resp);
				}
				
			
				
			}else {
				req.setAttribute("failure","Failed to debit");
				RequestDispatcher rd = req.getRequestDispatcher("Transfer.jsp");
				rd.forward(req, resp);
			}
			
		}else {
			req.setAttribute("failure","Invalid Credentials");
			RequestDispatcher rd = req.getRequestDispatcher("Transfer.jsp");
			rd.forward(req, resp);
		}
		
		
	}

}
