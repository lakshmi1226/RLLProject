package com.java.cms;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RestNewDAO {

	Connection connection;
	PreparedStatement pst;
	
	public String addRestaurent(Restaurent rest) throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "Insert into Restaurant(restaurenid,restaurentname,city,branch,emailid,contactno )   "
				+ " values(?,?,?,?,?,?) ";
		pst = connection.prepareStatement(cmd);
		pst.setInt(1, rest.getrestid());
		pst.setString(2, rest.getName());
		pst.setString(3, rest.getcity());
		pst.setString(4, rest.getbranch());
		pst.setString(5, rest.getemailid());
		pst.setInt(6, rest.getcontact());
		pst.executeUpdate();
		return "Record Inserted...";
	}
	
	public Restaurent searchRest(int restaurenid) throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "select * from restaurant where restaurenid=?";
		pst = connection.prepareStatement(cmd);
		pst.setInt(1, restaurenid);
		ResultSet rs = pst.executeQuery();
		Restaurent rest = null;
		if (rs.next()) {
			rest = new Restaurent();
			rest.setrestid(rs.getInt("restaurenid"));
			rest.setName(rs.getString("restaurantname"));
			rest.setcity(rs.getString("city"));
			rest.setbranch(rs.getString("branch"));
			rest.setemailid(rs.getString("emailid"));
			rest.setcontactno(rs.getInt("contact"));
		}
		return rest;
	}
	
	public List<Restaurent> showrest() throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "select * from restaurant";
		pst = connection.prepareStatement(cmd);
		ResultSet rs = pst.executeQuery();
		List<Restaurent> restList = new ArrayList<Restaurent>();
		Restaurent rest = null; 
		while(rs.next()) {
			rest = new Restaurent();
			rest.setrestid(rs.getInt("restaurenid"));
			rest.setName(rs.getString("restaurantname"));
			rest.setcity(rs.getString("city"));
			rest.setbranch(rs.getString("branch"));
			rest.setemailid(rs.getString("emailid"));
			rest.setcontactno(rs.getInt("contact"));
			restList.add(rest);
		}
		return restList;
	}
}


