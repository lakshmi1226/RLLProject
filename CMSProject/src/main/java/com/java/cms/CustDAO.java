package com.java.cms;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustDAO {
	
	Connection connection;
	PreparedStatement pst;

	public List<Customer> showcust() throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "select * from customer";
		pst = connection.prepareStatement(cmd);
		ResultSet mn = pst.executeQuery();
		List<Customer> custlist = new ArrayList<Customer>();
		Customer cust = null; 
		while(mn.next()) {
			cust = new Customer();
			cust.setCustomerid(mn.getInt("COSTUMERID"));
			cust.setCustomername(mn.getString("COSTUMERNAME"));
			cust.setCustomerstate(mn.getString("COSTUMERSTATE"));
			cust.setCustomercity(mn.getString("COSTUMERCITY"));
			cust.setCustomeremail(mn.getString("COSTUMEREMAIL"));
			cust.setCustomermobile(mn.getInt("COSTUMERMOBILE"));

			custlist.add(cust);
		}
		return custlist;
	}
	public Customer searchcust(int cusid) throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "select * from customer where cusid=?";
		pst = connection.prepareStatement(cmd);
		pst.setInt(1, cusid);
		ResultSet cu = pst.executeQuery();
		Customer cust = null;
		if (cu.next()) {
			cust = new Customer();
			cust.setCustomerid(cu.getInt("COSTUMERID"));
			cust.setCustomername(cu.getString("COSTUMERNAME"));
			cust.setCustomerstate(cu.getString("COSTUMERSTATE"));
			cust.setCustomercity(cu.getString("COSTUMERCITY"));
			cust.setCustomeremail(cu.getString("COSTUMEREMAIL"));
			cust.setCustomermobile(cu.getInt("COSTUMERMOBILE"));
		}
		return cust;
}
}
