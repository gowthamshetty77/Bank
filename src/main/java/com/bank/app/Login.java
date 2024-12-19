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

@WebServlet("/Login")
public class Login extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String acc = req.getParameter("accNo");
		Long accNo = Long.parseLong(acc);
		String password = req.getParameter("password");
		int pin = Integer.parseInt(password);
		
		Customer c = new Customer();
		CustomerDAO cdao = new CustomerDAOImpl();
		
		
		HttpSession session = req.getSession();
		Customer co = cdao.getCustomer(accNo, pin);
		
		if(co!=null) {
			session.setAttribute("success", co);
			RequestDispatcher rd = req.getRequestDispatcher("Dashboard.jsp");
			rd.forward(req, resp);
		}
		else {
			req.setAttribute("failure", "Failed to Login");
			RequestDispatcher rd = req.getRequestDispatcher("Login.jsp");
			rd.forward(req, resp);
			
		}
	}
	
}
