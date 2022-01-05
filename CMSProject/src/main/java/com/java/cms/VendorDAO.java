package com.java.cms;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VendorDAO {
	Connection connection;
	PreparedStatement pst;
	
	

	
	public Vendor searchVendor(int vendorid) throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "select * from Vendor where vendorid=?";
		pst = connection.prepareStatement(cmd);
		pst.setInt(1, vendorid);
		ResultSet rs = pst.executeQuery();
		Vendor vendor = null;
		if (rs.next()) {
			vendor = new Vendor();
			vendor .setVendorid(rs.getInt("vendorid"));
			vendor .setVendorname(rs.getString("vendorname"));
			vendor .setVendorstate(rs.getString("vendorstate"));
			vendor .setVendorcity(rs.getString("vendorcity"));
			vendor .setVendoremail(rs.getString("vendoremail"));
			vendor .setVendormobile(rs.getString("vendormobile"));
		}
		return vendor ;
	}
	
	public List<Vendor> showVendor() throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "select * from Vendor";
		pst = connection.prepareStatement(cmd);
		ResultSet rs = pst.executeQuery();
		List<Vendor> vendorList = new ArrayList<Vendor>();
		Vendor vendor = null; 
		while(rs.next()) {
			vendor  = new Vendor();
			vendor .setVendorid(rs.getInt("vendorid"));
			vendor .setVendorname(rs.getString("vendorname"));
			vendor  .setVendorstate(rs.getString("vendorstate"));
			vendor  .setVendorcity(rs.getString("vendorcity"));
			vendor  .setVendoremail(rs.getString("vendoremail"));
			vendor  .setVendormobile(rs.getString("vendormobile"));
			vendorList.add(vendor );
		}
		return vendorList;
	}
}


