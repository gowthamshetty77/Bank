package com.bank.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bank.connectors.connectionFactory;
import com.bank.dto.Customer;

public class CustomerDAOImpl implements CustomerDAO {
	Connection con = null;
	public CustomerDAOImpl(){
		this.con = connectionFactory.requestConnection();
	}

	@Override
	public boolean insertCustomer(Customer c) {
		// TODO Auto-generated method stub
		PreparedStatement ps = null;
		int res =0;
		String query = "insert into Customer(Name,Phone,Mail,Pin) values(?,?,?,?)";
		
		try {
			con.setAutoCommit(false);
			ps = con.prepareStatement(query);
			ps.setString(1, c.getName());
			ps.setLong(2, c.getPhone());
			ps.setString(3, c.getMail());
			ps.setInt(4, c.getPin());
			res = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(res>0) {
			try {
				con.commit();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return true;
		}
		else {
			try {
				con.rollback();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;
		}
		
		
	}

	@Override
	public Customer getCustomer(long accNo, int pin) {
		// TODO Auto-generated method stub
		PreparedStatement ps = null;
		ResultSet rs = null;
		Customer c =null;
		String query = "select * from customer where Acc_No=? and Pin = ?";
		
		try {
			ps = con.prepareStatement(query);
			ps.setLong(1,accNo);
			ps.setInt(2,pin);
			rs=ps.executeQuery(); 
			if(rs.next()) {
				c = new Customer();
				c.setAccNo(rs.getLong(1));
				c.setName(rs.getString(2));
				c.setPhone(rs.getLong(3));
				c.setMail(rs.getString(4));
				c.setBal(rs.getDouble(5));
				c.setPin(rs.getInt(6));
				
				
				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return c;
	}

	@Override
	public Customer getCustomer(long phone, String mail) {
		// TODO Auto-generated method stub
		PreparedStatement ps = null;
		ResultSet rs = null;
		Customer c  =null;
		String query = "select * from Customer where Phone = ? and  mail = ?";
		
		try {
			ps = con.prepareStatement(query);
			ps.setLong(1, phone);
			ps.setString(2, mail);
			rs = ps.executeQuery();
			if(rs.next()) {
				c = new Customer();
				c.setAccNo(rs.getLong(1));
				c.setName(rs.getString(2));
				c.setPhone(rs.getLong(3));
				c.setMail(rs.getString(4));
				c.setBal(rs.getDouble(5));
				c.setPin(rs.getInt(6));
				
				
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return c;
	}

	@Override
	public Customer getCustomer(long accNo) {
		// TODO Auto-generated method stub
		PreparedStatement ps = null;
		ResultSet rs = null;
		Customer c  =null;
		String query = "select * from Customer where Acc_No = ? ";
		
		try {
			ps = con.prepareStatement(query);
			ps.setLong(1, accNo);
			
			rs = ps.executeQuery();
			if(rs.next()) {
				c = new Customer();
				c.setAccNo(rs.getLong(1));
				c.setName(rs.getString(2));
				c.setPhone(rs.getLong(3));
				c.setMail(rs.getString(4));
				c.setBal(rs.getDouble(5));
				c.setPin(rs.getInt(6));
				
				
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return c;
	
	}

	@Override
	public List getCustomer() {
		// TODO Auto-generated method stub
		ArrayList<Customer> Customers = new ArrayList<>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		Customer c = null;
		String query ="select * from customer";
		
		try {
			ps= con.prepareStatement(query);
			rs = ps.executeQuery();
			while(rs.next()) {
				
				c = new Customer();
				c.setAccNo(rs.getLong(1));
				c.setName(rs.getString(2));
				c.setPhone(rs.getLong(3));
				c.setMail(rs.getString(4));
				c.setBal(rs.getDouble(5));
				c.setPin(rs.getInt(6));
				Customers.add(c);
				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Customers;
	}
	@Override
	public boolean Deposite(Customer c) {
		// TODO Auto-generated method stub
		PreparedStatement ps = null;
		int res =0;
		String query = "update customer set Balance = ? where Acc_No = ? and Pin = ?";
		try {
			con.setAutoCommit(false);
			ps = con.prepareStatement(query);
			ps.setDouble(1,c.getBal() );
			ps.setLong(2, c.getAccNo());
			ps.setInt(3, c.getPin());
			res =ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(res>0) {
			try {
				con.commit();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return true;
			
		}
		else {
			return false;
		}
	}
	
	@Override
	public boolean ResetPin(Customer c) {
		// TODO Auto-generated method stub
		PreparedStatement ps = null;
		int res= 0;
		String query = "update customer set  Pin = ? where Acc_No = ? and Mail = ?";
		
		try {
			con.setAutoCommit(false);
			ps = con.prepareStatement(query);
			ps.setInt(1,c.getPin());
			ps.setLong(2,c.getAccNo());
			ps.setString(3, c.getMail());
			res = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(res>0) {
			try {
				con.commit();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return true;
			
		}
		else {
			return false;
		}
	}
	

	@Override
	public boolean updateCustomer(Customer c) {
		// TODO Auto-generated method stub
		PreparedStatement ps = null;
		int res= 0;
		String query = "update customer set Name  = ?, Phone = ?, Mail = ?, Balance = ?, Pin = ? where Acc_No = ?";
		
		try {
			con.setAutoCommit(false);
			ps = con.prepareStatement(query);
			ps.setString(1,c.getName());
			ps.setLong(2, c.getPhone());
			ps.setString(3, c.getMail());
			ps.setDouble(4, c.getBal());
			ps.setInt(5, c.getPin());
			ps.setLong(6,c.getAccNo());
			res = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(res>0) {
			try {
				con.commit();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return true;
			
		}
		else {
			return false;
		}
	}

	@Override
	public boolean deleteCustomer(Customer c) {
		// TODO Auto-generated method stub
		
		PreparedStatement ps = null;
		int res =0;
		String query = "Delete from Customer where Acc_No = ?";
		
		try {
			con.setAutoCommit(false);
			ps = con.prepareStatement(query);
			ps.setLong(1, c.getAccNo());
			res = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(res>0) {
			try {
				con.commit();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return true;
		}
		else {
		return false;
		}
	}
	
	

}
