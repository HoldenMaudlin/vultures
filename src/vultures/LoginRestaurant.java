package vultures;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LoginRestaurant")
public class LoginRestaurant extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public LoginRestaurant() {
        super();
        DatabaseDriver.initConnection();
    }
	
	// This function checks if the user exists in the Restaurants table
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		Boolean check = DatabaseDriver.isValidRestaurant(username, password);
		
		if (check) {
			out.println("User exists");
			int restaurantId = DatabaseDriver.getRestaurantID(username);
			request.getSession().setAttribute("restaurantId", restaurantId);
		}
		else out.println("User does not exist");
	}
	
	// This function inserts the user into the Restaurants table
	// if the username is not already in the table
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		
		if (DatabaseDriver.getRestaurantID(username) != -1) {
			out.println("User already exists in the database");
		}
		else {
			DatabaseDriver.registerRestaurant(username, password, name, email);
			int restaurantId = DatabaseDriver.getRestaurantID(username);
			request.getSession().setAttribute("restaurantId", restaurantId);
			out.println("User does not exist");
		}
	}

}
