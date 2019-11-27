package vultures;

import java.sql.Timestamp;
import java.util.ArrayList;

public class DriverTest {

	public static void main(String[] args) {
		DatabaseDriver.initConnection();
		 
		/*
		Testing register methods
			DatabaseDriver.registerRestaurant("rtest", "rtest", "McDonald's", "1234 Main St");
			DatabaseDriver.registerUser("utest", "utest", "John Smith", "jsmith@test.com");
			DatabaseDriver.registerRestaurant("rtestb", "rtestb", "Chipotle", "5678 Main St");
			DatabaseDriver.registerUser("utestb", "utestb", "Bob Joe", "joebob@test.com");

		Testing addDeal and addOrder
			java.sql.Timestamp startTime = java.sql.Timestamp.valueOf("2019-11-23 10:00:00");
			java.sql.Timestamp endTime = java.sql.Timestamp.valueOf("2019-11-23 11:30:00");
			DatabaseDriver.addDeal(1, "Cheap Stuff", startTime, endTime, 4.99);	
			DatabaseDriver.addOrder(1, 1);
			
			java.sql.Timestamp startTime = java.sql.Timestamp.valueOf("2019-11-24 20:00:00");
			java.sql.Timestamp endTime = java.sql.Timestamp.valueOf("2019-11-24 22:30:00");
			DatabaseDriver.addDeal(1, "Cheaper Stuff", startTime, endTime, 2.99);	
			DatabaseDriver.addOrder(1, 2);

		Testing validation methods
			boolean restaurantTrue = DatabaseDriver.isValidRestaurant("rtest", "rtest");
			boolean restaurantFalse = DatabaseDriver.isValidRestaurant("rtest", "rtestf");
			boolean userTrue = DatabaseDriver.isValidUser("utest", "utest");
			boolean userFalse = DatabaseDriver.isValidUser("utest", "utestf");
			System.out.println(restaurantTrue);
			System.out.println(restaurantFalse);
			System.out.println(userTrue);
			System.out.println(userFalse);

		Testing GetOrders
			ArrayList<Integer> orders = DatabaseDriver.getOrdersByUserID(1);
			ArrayList<Integer> deals = DatabaseDriver.getDealsByRestaurantID(1);
		
			System.out.println("Orders:");
			for(int i : orders) {
				System.out.println(i);
			}
			System.out.println("Deals:");
			for(int i : deals) {
				System.out.println(i);
			}
		 */
		
		System.out.println("Done");
	}
}