package com.bank.app;

import java.io.IOException;

import com.bank.dao.CustomerDAO;
import com.bank.dao.CustomerDAOImpl;
import com.bank.dto.Customer;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/SignUp")
public class SignUp extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = req.getParameter("name");
		String phoneNo = req.getParameter("phone");
		Long phone = Long.parseLong(phoneNo);
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		int pin = Integer.parseInt(password);
		String confirm = req.getParameter("confirm");
		int cPin = Integer.parseInt(confirm);
		
		Customer c = new Customer();
		c.setName(name);
		c.setPhone(phone);
		c.setMail(email);
	
		CustomerDAO cdao = new CustomerDAOImpl();
		if(pin==cPin) {
			c.setPin(pin);
			boolean result = cdao.insertCustomer(c);
			if(result) {
				
				Customer c1 = cdao.getCustomer(phone, email);
				req.setAttribute("success", "SignUp SuccessFull!"+"\n"+"Your Acc No:"+c1.getAccNo());
				RequestDispatcher rd = req.getRequestDispatcher("SignUp.jsp");
				rd.forward(req, resp);
			}else {
				req.setAttribute("failure", "Failed to SignUp!");
				RequestDispatcher rd = req.getRequestDispatcher("SignUp.jsp");
				rd.forward(req, resp);
			}
			
		}else {
			req.setAttribute("failure", "Password mismatch");
			RequestDispatcher rd = req.getRequestDispatcher("SignUp.jsp");
			rd.forward(req, resp);
		}
		
	}

}
