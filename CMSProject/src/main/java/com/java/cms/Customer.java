package com.java.cms;

public class Customer {
	
	private int COSTUMERID;
	private String COSTUMERNAME;
	private String COSTUMERSTATE;
	private String COSTUMERCITY;
	private String COSTUMEREMAIL;
	private int COSTUMERMOBILE;
	public int getCustomerid() {
		return COSTUMERID;
	}
	public void setCustomerid(int COSTUMERID) {
		this.COSTUMERID = COSTUMERID;
	}
	public String getCustomername() {
		return COSTUMERNAME;
	}
	public void setCustomername(String customername) {
		this.COSTUMERNAME = customername;
	}
	public String getCustomerstate() {
		return COSTUMERNAME;
	}
	public void setCustomerstate(String customerstate) {
		this.COSTUMERSTATE = customerstate;
	}
	public String getCustomercity() {
		return COSTUMERCITY;
	}
	public void setCustomercity(String customercity) {
		this.COSTUMERCITY = customercity;
	}
	public String getCustomeremail() {
		return COSTUMEREMAIL;
	}
	public void setCustomeremail(String customeremail) {
		this.COSTUMEREMAIL = customeremail;
	}
	public int getCustomermobile() {
		return COSTUMERMOBILE;
	}
	public void setCustomermobile(int customermobile) {
		this.COSTUMERMOBILE = customermobile;
	}
	@Override
	public String toString() {
		return "Customer [customerid=" + COSTUMERID + ", customername=" + COSTUMERNAME + ", customerstate="
				+ COSTUMERSTATE + ", customercity=" + COSTUMERCITY + ", customeremail=" + COSTUMEREMAIL
				+ ", customermobile=" + COSTUMERMOBILE + "]";
	}
	
	
	
}
