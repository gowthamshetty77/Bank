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

@WebServlet("/Update")
public class Update extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = req.getParameter("name");
		String phoneNo = req.getParameter("phone");
		long phone = Long.parseLong(phoneNo);
		String email = req.getParameter("email");
		
		
		HttpSession session = req.getSession(false);
		Customer c = (Customer) session.getAttribute("success");
		c.setName(name);
		c.setPhone(phone);
		c.setMail(email);
		long accNo = c.getAccNo();
		
		CustomerDAO cdao = new CustomerDAOImpl();
		
		boolean result = cdao.updateCustomer(c);
		if(result) {
			req.setAttribute("success", "Successfully Updated");
			RequestDispatcher rd = req.getRequestDispatcher("Update.jsp");
			rd.forward(req, resp);
		}
		else {
			req.setAttribute("failure", "Failed to Update");
			RequestDispatcher rd = req.getRequestDispatcher("Update.jsp");
			rd.forward(req, resp);
		}
	}

}
