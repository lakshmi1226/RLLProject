package com.java.cms;

public class Menu {
	
	private int menuid;
	private int restaurnatid;
	private String itemname;
	private int calaroies;
	private String menutype;
	private int price;
	
	public int getmenuid()
	{
		return menuid;
	}
	public void setmenuid(int menuid)
	{
		this.menuid = menuid;
	}
	public int getrestaurantid()
	{
		return restaurnatid;
	}
	public void setresturantid(int restaurantid)
	{
		this.restaurnatid = restaurantid;
	}
	public String getitemname()
	{
		return itemname;
	}
	public void setitemname(String itemname)
	{
		this.itemname = itemname;
	}
	public String getmenutype()
	{
		return menutype;
	}
	public void setmenutype(String menutype)
	{
		this.menutype = menutype;
	}
	public int getcalories()
	{
		return calaroies;
	}
	public void setcalories(int calories)
	{
		this.calaroies = calories;
	}
	public int getprice()
	{
		return price;
	}
	public void setprice(int price)
	{
		this.price = price;
	}
	@Override
	public String toString() {
		return "Menu [MenuID=" + menuid + ", RestaurantID=" + restaurnatid + ", Itemname=" + itemname + ", Calories="
				+ calaroies + ", Menutype=" + menutype + ", Price=" + price + "]";
	}
	

}
