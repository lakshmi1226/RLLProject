package com.java.cms;

public class Wallet {
	
	private int walletid;
	private int customerid;
	private String wallettype;
	private int amount;
	
	public int getwalletid()
	{
		return walletid;
	}
	public void setwalletid(int walletid)
	{
		this.walletid=walletid;
	}
	public int getcustomerid()
	{
		return customerid;
	}
	public void setcustomerid(int customerid)
	{
		this.customerid=customerid;
	}
	public String getwallettype()
	{
		return wallettype;
	}
	public void setwallettype(String wallettype)
	{
		this.wallettype=wallettype;
	}
	public int getamount()
	{
		return amount;
	}
	public void setamount(int amount)
	{
		this.amount=amount;
	}
	@Override
	public String toString() {
		return "Wallet [Walletid=" + walletid + ", Customerid=" + customerid + ", Wallettype=" + wallettype
				+ ", Amount=" + amount + "]";
	}
	

}
