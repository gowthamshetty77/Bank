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
import jakarta.servlet.http.HttpSession;

@WebServlet("/Deposite")
public class Deposite extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String amt = req.getParameter("amount");
		int amount = Integer.parseInt(amt);
		String pass = req.getParameter("pin");
		int pin = Integer.parseInt(pass);
		
		HttpSession session = req.getSession(false);
		Customer cs = (Customer) session.getAttribute("success");
		long accNo = cs.getAccNo();
		double bal = cs.getBal();
		
		Customer c = new Customer();
		
		c.setAccNo(accNo);
		c.setPin(pin);
		c.setBal(bal+amount);
		
		CustomerDAO cdao = new CustomerDAOImpl();
		
		boolean result = cdao.Deposite(c);
		

		if(result) {
			req.setAttribute("success", c);
			RequestDispatcher rd = req.getRequestDispatcher("Deposite.jsp");
			rd.forward(req, resp);
		}else {
			req.setAttribute("failure", "Failed to deposite");
			RequestDispatcher rd = req.getRequestDispatcher("Deposite.jsp");
			rd.forward(req, resp);
		}
	
		
		
		
		
		
	}

}
