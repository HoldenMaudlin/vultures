package vultures;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.text.ParseException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

@WebServlet("/RestaurantDeals")
public class RestaurantDeals extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public RestaurantDeals() {
        super();
        DatabaseDriver.initConnection();
    }

    /* Returns all deals for restaurant in Orders table
	   The JSON response will be in this format
	   {
	       "data": {
	           "dealID"    : ...,
	           "dealName"  : ...,
	           "startTime" : ...,
	           "endTime"   : ...,
	           "price"     : ...,
	           "orderID"   : ..., (only if there is an order in Orders table)
	           "created_at": ..., (only if there is an order in Orders table)
	           "username"  : ...  (only if there is an order in Orders table)
	           
	       }
	   }
	*/
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String username = request.getParameter("username");
		int restaurantID = DatabaseDriver.getRestaurantID(username);
//		//JSONArray deals = DatabaseDriver.getDealsByRestaurantID(restaurantID);
//		//JSONObject obj = new JSONObject();
//		obj.put("data", deals);
//		out.println(obj.toString());
	}
	
	// This function adds new deal to Deals table
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String username = request.getParameter("username");
		String dealName =request.getParameter("dealName");
		String startTimeStr =request.getParameter("startTime");
		String endTimeStr =request.getParameter("endTime");
		String priceStr = request.getParameter("price");
		
		int restaurantID = DatabaseDriver.getUserID(username);
		Double price = Double.parseDouble(priceStr);
		Timestamp startTime = null;
		Timestamp endTime = null;
		
		try {
			startTime = Helper.convertToTimestamp(startTimeStr);
			endTime = Helper.convertToTimestamp(endTimeStr);
		} catch (ParseException e) {
			out.println("Unable to parse startTime and endTime from string to Timestamp");
		}
		
		DatabaseDriver.addDeal(restaurantID, dealName, startTime, endTime, price);
		out.println("Sucessfully added new order to the Orders table");
	}

}
