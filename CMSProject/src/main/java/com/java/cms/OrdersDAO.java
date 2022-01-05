package com.java.cms;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class OrdersDAO {

	Connection connection;
	PreparedStatement pst;
	
	public String placeOrder(Orders order) throws SQLException, ClassNotFoundException {
		int oid = generateOrderId();
		order.setOrderStatus("PENDING");
		java.util.Date today = new Date();
		java.sql.Date dbDate = new java.sql.Date(today.getTime());
		order.setOrderDate(dbDate);
		Menu menu = new MenuDAO().searchMenu(order.getMenuId());
		int price = menu.getprice();
		int  billAmount = order.getQuantityOrdered() * price;
		Wallet wallet = new WalletDAO().searchByWalletId(order.getWalletId());
		int amount = wallet.getamount();
		if (amount - billAmount > 0) {
			order.setBillAmount(billAmount);
			order.setOrderId(oid);
			String cmd = "insert into Orders(orderId,VendorId,CustomerId,MenuID,"
					+ "WalletId,OrderDate,QuantityOrdered,OrderStatus,BillAmount,Comments) "
					+ "values(?,?,?,?,?,?,?,?,?,?)";
			pst = connection.prepareStatement(cmd);
			pst.setInt(1, order.getOrderId());
			pst.setInt(2, order.getVendorId());
			pst.setInt(3, order.getCustomerId());
			pst.setInt(4, order.getMenuId());
			pst.setInt(5, order.getWalletId());
			pst.setDate(6, order.getOrderDate()); 
			pst.setInt(7, order.getQuantityOrdered());
			pst.setString(8, order.getOrderStatus());
			pst.setInt(9, order.getBillAmount());
			pst.setString(10, order.getOrderComments());
			pst.executeUpdate();
			new WalletDAO().deductBalance(order.getWalletId(), billAmount);
			return "Order Placed Successfully...Wallet Balance Deducted...";
		}
		return "Insufficient Funds...";
		//order.setBillAmount(billAmount);
	}
	
	public int generateOrderId() throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "select case when max(ORDERID) is NULL THEN 1"
				+ " else max(ORDERID)+1 end oid from orders";
		pst = connection.prepareStatement(cmd);
		ResultSet rs = pst.executeQuery();
		rs.next();
		int id = rs.getInt("oid");
		return id;
	}
}
