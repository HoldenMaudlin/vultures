package vultures;

import java.sql.Connection;
import java.sql.Timestamp;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


// Note: Because the classes that correspond to these methods haven't been created
// yet, I've written them up using manually set parameters and the Timestamp class rather than LocalDate.
// Once the necessary classes are created, it'll be an easy switch to use them as parameters instead.
public class DatabaseDriver {
	
	public static final String credentials = "jdbc:mysql://google/Vultures?cloudSqlInstance=vultures:us-west1:vultures&socketFactory=com.google.cloud.sql.mysql.SocketFactory&useSSL=false&user=vultures&password=password";
	static Connection connection = null;
	
	// Initializes the connection to the Cloud SQL Server Database using
	// the defined credential string and the JDBC driver
	public static void initConnection() {
		if (connection != null) {
			System.out.println("[WARN] Connection has already been established.");
			return;
		}
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(credentials);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	// Inserts a new restaurant into the database using the defined parameters
	public static void registerRestaurant(String username, String password, String name, String address) {
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO Restaurants(username, password, name, address) VALUES (?, ?, ?, ?)");
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, password);
			preparedStatement.setString(3, name);
			preparedStatement.setString(4, address);
			preparedStatement.execute();
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Inserts a new user into the database using the defined parameters
	public static void registerUser(String username, String password, String name, String email) {
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO Users(username, password, name, email) VALUES (?, ?, ?, ?)");
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, password);
			preparedStatement.setString(3, name);
			preparedStatement.setString(4, email);
			preparedStatement.execute();
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// Inserts a new deal into the database using the defined parameters
	// Use the Timestamp class to define our start and end times
	// Usage: 
	// 		java.sql.Timestamp time = java.sql.Timestamp.valueOf("YYYY-MM-DD HH:MM:SS");
	// 		Define the start and end times of the deal this way, and use the Timestamps as parameters for this method
	//
	public static void addDeal(int restaurantID, String dealName, Timestamp startTime, Timestamp endTime, double price) {
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO Deals(restaurantID, dealName, startTime, endTime, price) VALUES (?, ?, ?, ?, ?)");
			preparedStatement.setInt(1, restaurantID);
			preparedStatement.setString(2, dealName);
			preparedStatement.setObject(3, startTime);
			preparedStatement.setObject(4, endTime);
			preparedStatement.setDouble(5, price);
			preparedStatement.execute();
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// Inserts a new order into the database using the defined parameters
	public static void addOrder(int userID, int dealID) {
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO Orders(userID, dealID, created_at) VALUES (?, ?, ?)");
			preparedStatement.setInt(1, userID);
			preparedStatement.setInt(2, dealID);
			preparedStatement.setObject(3, new Timestamp(System.currentTimeMillis()));
			preparedStatement.execute();
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Retrieves all orders associated with the given user
	// Current functionality returns a list of the order IDs
	public static ArrayList<Integer> getOrdersByUserID(int userID) {
		ArrayList<Integer> orders = new ArrayList<Integer>();
		if(userID == -1) {
			return orders;
		}
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Orders WHERE userID=?");
			preparedStatement.setInt(1, userID);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				int orderID = resultSet.getInt("orderID");
				orders.add(orderID);
			}
			preparedStatement.close();
			resultSet.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return orders;
	}
	
	// Retrieves all deals associated with the given restaurant
	// Current functionality returns a list of the deal IDs
	public static ArrayList<Integer> getDealsByRestaurantID(int restaurantID) {
		ArrayList<Integer> deals = new ArrayList<Integer>();
		if(restaurantID == -1) {
			return deals;
		}
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Deals WHERE restaurantID=?");
			preparedStatement.setInt(1, restaurantID);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				int dealID = resultSet.getInt("dealID");
				deals.add(dealID);
			}
			preparedStatement.close();
			resultSet.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return deals;
	}

	// Returns whether the given restaurant is registered in the database
	public static boolean isValidRestaurant(int restaurantID) {
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Restaurants WHERE restaurantID=?");
			preparedStatement.setInt(1, restaurantID);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				preparedStatement.close();
				resultSet.close();
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	// Returns whether the given user is registered in the database
	public static boolean isValidUser(int userID) {
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Users WHERE userID=?");
			preparedStatement.setInt(1, userID);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				preparedStatement.close();
				resultSet.close();
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
}