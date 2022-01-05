package com.java.cms;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public class MenuDAO {

	Connection connection;
	PreparedStatement pst;
	
	
	public Menu searchMenu(int menuid) throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "select * from menu where restaurantid=?";
		pst = connection.prepareStatement(cmd);
		pst.setInt(1, menuid);
		ResultSet mn = pst.executeQuery();
		Menu menu = null;
		if (mn.next()) {
			menu = new Menu();
			menu.setmenuid(mn.getInt("menuid"));
			menu.setresturantid(mn.getInt("restaurantid"));
			menu.setitemname(mn.getString("itemname"));
			menu.setmenutype(mn.getString("menutype"));
			menu.setcalories(mn.getInt("calories"));
			menu.setprice(mn.getInt("price"));
		}
		return menu;

	}
	public List<Menu> showmenu() throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "select * from menu";
		pst = connection.prepareStatement(cmd);
		ResultSet mn = pst.executeQuery();
		List<Menu> menulist = new ArrayList<Menu>();
		Menu menu = null; 
		while(mn.next()) {
			menu = new Menu();
			menu.setmenuid(mn.getInt("menuid"));
			menu.setresturantid(mn.getInt("restaurnatid"));
			menu.setitemname(mn.getString("itemname"));
			menu.setmenutype(mn.getString("menutype"));
			menu.setcalories(mn.getInt("calaroies"));
			menu.setprice(mn.getInt("price"));
			menulist.add(menu);
		}
		return menulist;
	}
}
