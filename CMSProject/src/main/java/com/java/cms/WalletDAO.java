package com.java.cms;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public class WalletDAO {
	
	Connection connection;
	PreparedStatement pst;
	
	
	public List<Wallet> showwallet() throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "select * from wallet";
		pst = connection.prepareStatement(cmd);
		ResultSet rs = pst.executeQuery();
		List<Wallet> walletList = new ArrayList<Wallet>();
		Wallet wallet = null; 
		while(rs.next()) {
			wallet  = new Wallet();
			wallet .setwalletid(rs.getInt("walletid"));
			wallet .setcustomerid(rs.getInt("customerid"));
			wallet  .setwallettype(rs.getString("wallettype"));
			wallet  .setamount(rs.getInt("amount"));
			
			walletList.add(wallet );
		}
		return walletList;
	}
	public Wallet searchwallet(int walletid) throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "select * from Wallet where walletid=?";
		pst = connection.prepareStatement(cmd);
		pst.setInt(1, walletid);
		ResultSet rs = pst.executeQuery();
		Wallet wallet = null;
		if (rs.next()) {
			wallet = new Wallet();
			wallet .setwalletid(rs.getInt("walletid"));
			wallet .setcustomerid(rs.getInt("customerid"));
			wallet .setwallettype(rs.getString("wallettype"));
			wallet .setamount(rs.getInt("amount"));
			
		}
		return wallet ;
	}
	public Wallet searchByWalletId(int walletId) {
		// TODO Auto-generated method stub
		return null;
	}
	public void deductBalance(int walletId, int billAmount) {
		// TODO Auto-generated method stub
		
	}

}
