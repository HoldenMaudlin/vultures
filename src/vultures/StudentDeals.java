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

@WebServlet("/StudentDeals")
public class StudentDeals extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public StudentDeals() {
        super();
        DatabaseDriver.initConnection();
    }

    // Returns all orders for username in Orders table
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String username = request.getParameter("username");
		int userID = DatabaseDriver.getUserID(username);
		// not done yet
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
