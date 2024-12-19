package com.bank.dto;

import java.sql.Date;

public class Transaction {
	
	private long transID;
	private long userAcc;
	private long recAcc;
	private Date date;
	private String transType;
	private double amount;
	private double balance;

	public long getTransID() {
		return transID;
	}
	public void setTransID(long transID) {
		this.transID = transID;
	}
	public long getUserAcc() {
		return userAcc;
	}
	public void setUserAcc(long userAcc) {
		this.userAcc = userAcc;
	}
	public long getRecAcc() {
		return recAcc;
	}
	public void setRecAcc(long recAcc) {
		this.recAcc = recAcc;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getTransType() {
		return transType;
	}
	public void setTransType(String transType) {
		this.transType = transType;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	@Override
	public String toString() {
		return "Transaction [transID=" + transID + ", userAcc=" + userAcc + ", recAcc=" + recAcc + ", date=" + date
				+ ", transType=" + transType + ", amount=" + amount + ", balance=" + balance + "]";
	}
	
	
	
	
	
	
}
