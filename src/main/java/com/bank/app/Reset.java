package com.bank.app;

import java.io.IOException;

import com.bank.dao.CustomerDAO;
import com.bank.dao.CustomerDAOImpl;
import com.bank.dto.Customer;
import com.mysql.cj.Session;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/Reset")
public class Reset extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String acc = req.getParameter("accNo");
		long accNo = Long.parseLong(acc);
		
		String email = req.getParameter("email");
		
		
		String pass = req.getParameter("pin");
		int pin = Integer.parseInt(pass);
		
		
		String Cpass = req.getParameter("confirm");
		int confirm = Integer.parseInt(Cpass);
		
		HttpSession session = req.getSession(false);
		Customer c = (Customer)session.getAttribute("success");
		if(pin==confirm) {
			if(accNo ==c.getAccNo() && email.equals(c.getMail())) {
		
		c.setPin(pin);
		
		CustomerDAO cdao = new CustomerDAOImpl();
		boolean res = cdao.ResetPin(c);
		if(res) {
			req.setAttribute("success", "Reset SuccessFull");
			RequestDispatcher rd = req.getRequestDispatcher("Reset.jsp");
			rd.forward(req, resp);
		}else {
			req.setAttribute("failure", "Failed To Reset");
			RequestDispatcher rd = req.getRequestDispatcher("Reset.jsp");
			rd.forward(req, resp);
		}
			}else {
				req.setAttribute("failure", "Enter valid email and AccNo");
				RequestDispatcher rd = req.getRequestDispatcher("Reset.jsp");
				rd.forward(req, resp);
			}
		
		
		
		
	}else {
		req.setAttribute("failure", "InValid CredentialS");
		RequestDispatcher rd = req.getRequestDispatcher("Reset.jsp");
		rd.forward(req, resp);
	}
		
	}

}
