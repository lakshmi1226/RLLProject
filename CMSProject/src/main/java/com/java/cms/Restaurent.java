package com.java.cms;

public class Restaurent {
	
	private int restaurenid;
	private String restaurantname;
	private String city;
	private String branch;
	private String emailid;
	private int contact;
	
	public int getrestid()
	{
		return restaurenid;
		
	}
	public void setrestid(int restuarenid) {
		this.restaurenid = restuarenid;
	}
	public String getName() {
		return restaurantname;
	}
	public void setName(String restaurantname) {
		this.restaurantname = restaurantname;
	}
	public String getcity() {
		return city;
	}
	public void setcity(String city) {
		this.city = city;
	}
	public String getbranch() {
		return branch;
	}
	public void setbranch(String branch) {
		this.branch = branch;
	}
	public String getemailid() {
		return emailid;
	}
	public void setemailid(String emailid) {
		this.emailid = emailid;
	}
	public int getcontact() {
		return contact;
	}
	public void setcontactno(int contact) {
		this.contact = contact;
	}
	@Override
	public String toString() {
		return "Restaurent [restaurenid=" + restaurenid + ", restaurantname=" + restaurantname + ", city=" + city
				+ ", branch=" + branch + ", emailid=" + emailid + ", contact=" + contact + "]";
	}
	
	
}

	


