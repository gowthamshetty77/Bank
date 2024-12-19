package com.bank.dao;

import java.util.List;

import com.bank.dto.Customer;

public interface CustomerDAO {
	public boolean insertCustomer(Customer c);
	public Customer getCustomer(long accNo,int pin);
	public Customer getCustomer(long phone,String mail);
	public Customer getCustomer(long accNo);
	public List getCustomer();
	public boolean updateCustomer(Customer c);
	public boolean ResetPin(Customer c);
	public boolean Deposite(Customer c);
	public boolean deleteCustomer(Customer c);
	

}
