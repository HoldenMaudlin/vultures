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

@WebServlet("/StudentOrders")
public class StudentOrders extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public StudentOrders() {
        super();
        DatabaseDriver.initConnection();
    }

    /* Returns all orders for username in Orders table
	   The JSON response will be in this format
	   {
	       "data": {
	           "orderID"   : ...,
	           "dealID"    : ...,
	           "created_at": ...,
	           "username"  : ...,
	           "dealName"  : ...,
	           "startTime" : ...,
	           "endTime"   : ...,
	           "price"     : ...
	       }
	   }
	*/
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String username = request.getParameter("username");
		int userID = DatabaseDriver.getUserID(username);
		JSONArray orders = DatabaseDriver.getOrdersByUserID(userID);
		JSONObject obj = new JSONObject();
		obj.put("data", orders);
		out.println(obj.toString());
	}
	
	// This function adds new order to Orders table
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String username = request.getParameter("username");
		String dealIDStr = request.getParameter("dealID");
		
		int userID = DatabaseDriver.getUserID(username);
		int dealID = Integer.parseInt(dealIDStr);
		DatabaseDriver.addOrder(userID, dealID);
		out.println("Sucessfully added new order to the Orders table");
	}

}
