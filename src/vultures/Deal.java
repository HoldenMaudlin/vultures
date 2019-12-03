package vultures;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Deal {
	
	// Public because not sure what is required to access these when passed to front end.
	public String name;
	public String restaurantName;
	public double price;
	public String startTime;
	public String endTime;
	
	public Deal(String name, String restaurantName, double price, Timestamp startTime, Timestamp endTime) {
		this.name = name;
		this.price = price;
		this.restaurantName = restaurantName;
		
		Date date = new Date();
		date.setTime(startTime.getTime());
		this.startTime = new SimpleDateFormat("MM-dd HH:mm").format(date).toString();
		date.setTime(endTime.getTime());
		this.endTime = new SimpleDateFormat("MM-dd HH:mm").format(date).toString();
	}
	
	public void setStartTime(String st) { this.startTime = st; }
	public void setEndTime(String et) { this.startTime = et; }
	public void setPrice(double p) { this.price = p; }
	public void setName(String n) { this.name = n; }
	public void setRestaurantName(String rn) { this.restaurantName = rn; }
	
	public String getName() { return this.name; }
	public double getPrice() { return this.price; }
	public String getStartTime() { return this.startTime; }
	public String getEndtime() { return this.endTime; }
	public String getRestaurantName() { return this.restaurantName; }
}
