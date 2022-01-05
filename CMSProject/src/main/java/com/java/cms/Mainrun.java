package com.java.cms;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
public class Mainrun {


	static Scanner sc =  new Scanner(System.in);
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		int choice;
		do {
			System.out.println("O P T I O N S");
			System.out.println("---------------");
			System.out.println("1. Show Restaurant ");
			System.out.println("2. Search Restaurant");
			System.out.println("3. Show Menu");
			System.out.println("4. Search Menu");
			System.out.println("5. Show Vendor ");
			System.out.println("6. Search Vendor");
			System.out.println("7. Search Customer");
			System.out.println("8. Show Customer");
			System.out.println("9. Search Wallet");
			System.out.println("10. Show Wallet");
			System.out.println("11. Exit");


			System.out.println("Enter Your Choice   ");
			choice = sc.nextInt();
			switch(choice) {
			case 1 : 
				showRestaurant();
				break;
			case 2 : 
				try {
					searchRestaurant();
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 3 : 
				showMenu();
				break;
			case 4 : 
				try {
					searchMenu();
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 5 : 
				showVendor();
				break;
			case 6 : 
				try {
					searchVendor();
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 7 :
				try {
					searchcust();
				}catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 8 :
				showcust();
				break;
			case 9:
			   try {
				searchwallet();
			   }catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			   }
			   break;
			case 10:
				showwallet();
				break;
			
				
			case 11 : 
				return;
			}
		} while(choice!=11);
	}
	public static void searchRestaurant() throws ClassNotFoundException, SQLException {
		int rid;
		System.out.println("Enter Restaurant id   ");
		rid = sc.nextInt();
		Restaurent restaurant = new RestNewDAO().searchRest(rid);
		System.out.println(restaurant);
	}
	public static void showRestaurant() {
		try {
			List<Restaurent> restaurantList = new RestNewDAO().showrest();
			for (Restaurent restaurant : restaurantList) {
				System.out.println(restaurant);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void searchMenu() throws ClassNotFoundException, SQLException {
		int mid;
		System.out.println("Enter Menu id   ");
		mid = sc.nextInt();
		Menu menu = new MenuDAO().searchMenu(mid);
		System.out.println(menu);
		}
	
		public static void showMenu() {
			try {
				List<Menu> menuList = new MenuDAO().showmenu();
				for (Menu menu : menuList) {
					System.out.println(menu);
				}
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		public static void searchVendor() throws ClassNotFoundException, SQLException {
			int vid;
			System.out.println("Enter Vendor id   ");
			vid = sc.nextInt();
			Vendor vendor = new VendorDAO().searchVendor(vid);
			System.out.println(vendor);
		}
		public static void showVendor() {
			try {
				List<Vendor> vendorList = new VendorDAO().showVendor();
				for (Vendor vendor : vendorList) {
					System.out.println(vendor);
				}
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		public static void searchcust() throws ClassNotFoundException, SQLException {
			int cus;
			System.out.println("Enter Customer id   ");
			cus = sc.nextInt();
			Customer cust = new CustDAO().searchcust(cus);
			System.out.println(cust);
			}
		
			public static void showcust() {
				try {
					List<Customer> custList = new CustDAO().showcust();
					for (Customer cust : custList) {
						System.out.println(cust);
					}
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			public static void searchwallet() throws ClassNotFoundException, SQLException {
				int wal;
				System.out.println("Enter Wallet id   ");
				wal = sc.nextInt();
				Wallet wallet = new WalletDAO().searchwallet(wal);
				System.out.println(wallet);
				}
			
				public static void showwallet() {
					try {
						List<Wallet> walList = new WalletDAO().showwallet();
						for (Wallet wal : walList) {
							System.out.println(wal);
						}
					} catch (ClassNotFoundException | SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

}

