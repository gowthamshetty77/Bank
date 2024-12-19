package com.bank.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.bank.connectors.connectionFactory;
import com.bank.dto.Customer;
import com.bank.dto.Transaction;
import java.util.*;

public class TransactionDAOImpl implements TransactionDAO{
	Connection con = null;
	
	public TransactionDAOImpl(){
		this.con = connectionFactory.requestConnection();
	}

	@Override
	public boolean insertTransaction(Transaction t) {
		// TODO Auto-generated method stub
		PreparedStatement ps = null;
		int res = 0;
		String query = "insert into passbook values(?,?,?,sysdate(),?,?,?)";
		
		try {
			con.setAutoCommit(false);
			ps = con.prepareStatement(query);
			ps.setLong(1, t.getTransID());
			ps.setLong(2,t.getUserAcc());
			ps.setLong(3, t.getRecAcc());
			ps.setString(4, t.getTransType());
			ps.setDouble(5, t.getAmount());
			ps.setDouble(6, t.getBalance());
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
	public List getTransation(Long AccNo) {
		// TODO Auto-generated method stub
		ArrayList<Transaction> trans = new ArrayList<Transaction>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		Transaction t = null;
		String query = "select * from passbook where user_Acc = ? order by tran_date desc";
		
		try {
			ps = con.prepareStatement(query);
			ps.setLong(1, AccNo);
			rs = ps.executeQuery();
			while(rs.next()) {
				t = new Transaction();
				t.setTransID(rs.getLong(1));
				t.setUserAcc(rs.getLong(2));
				t.setRecAcc(rs.getLong(3));
				t.setDate(rs.getDate(4));
				t.setTransType(rs.getString(5));
				t.setAmount(rs.getDouble(6));
				t.setBalance(rs.getDouble(7));
				trans.add(t);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	
		return trans;
	}
	
	public List getTransation() {
		// TODO Auto-generated method stub
		ArrayList<Transaction> trans = new ArrayList<Transaction>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		Transaction t = null;
		String query = "select * from passbook";
		
		try {
			ps = con.prepareStatement(query);
			
			rs = ps.executeQuery();
			while(rs.next()) {
				t = new Transaction();
				t.setTransID(rs.getLong(1));
				t.setUserAcc(rs.getLong(2));
				t.setRecAcc(rs.getLong(3));
				t.setDate(rs.getDate(4));
				t.setTransType(rs.getString(5));
				t.setAmount(rs.getDouble(6));
				t.setBalance(rs.getDouble(7));
				trans.add(t);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	
		return trans;
	}
	

}
