package vultures;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Deals")
public class Deals extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public Deals() {
        super();
        DatabaseDriver.initConnection();
    }

    // Returns all deals in Deals table
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	
	// This function adds new deal to Deals table
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String restaurantIdString = request.getParameter("restaurantId");
		String dealName = request.getParameter("dealName");
		String startTimeStr = request.getParameter("startTime");
		String endTimeStr = request.getParameter("endTime");
		String priceStr = request.getParameter("price");
		Timestamp startTime = null;
		Timestamp endTime = null;
		
		// try to convert startTime and endTime from string to Timestamp
		try {
			int restaurantID = Integer.parseInt(restaurantIdString);
			startTime = Helper.convertToTimestamp(startTimeStr);
			endTime = Helper.convertToTimestamp(endTimeStr);		
			double price = Double.parseDouble(priceStr);
			DatabaseDriver.addDeal(restaurantID, dealName, startTime, endTime, price);
			out.println("Sucessfully added new deal to the Deals table");
			System.out.println("Sucessfully added new deal to the Deals table");
		} catch (ParseException e) {
			out.println("Unable to parse startTime and endTime from string to Timestamp");
			System.out.println("Unable to parse startTime and endTime from string to Timestamp");
			e.printStackTrace();
		}

	}

}
