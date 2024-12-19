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

@WebServlet("/Remove")
public class Remove extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String acc = req.getParameter("remove");
		long accNo = Long.parseLong(acc);
		
		Customer c = new Customer();
		CustomerDAO cdao = new CustomerDAOImpl();
		
		if(accNo!=1100110011) {
			c.setAccNo(accNo);
			boolean res = cdao.deleteCustomer(c);
			if(res) {
				RequestDispatcher rd = req.getRequestDispatcher("Remove.jsp");
				rd.forward(req, resp);
			}
			else{
				req.setAttribute("failure", "Failed to delete the data");
				RequestDispatcher rd = req.getRequestDispatcher("Remove.jsp");
				rd.forward(req, resp);
			}
			
		}else {
			req.setAttribute("failure", "Admin Account Can't Be Deleted");
			RequestDispatcher rd = req.getRequestDispatcher("Remove.jsp");
			rd.forward(req, resp);
		}
	}

}
