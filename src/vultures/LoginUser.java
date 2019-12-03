package vultures;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LoginUser")
public class LoginUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public LoginUser() {
        super();
        DatabaseDriver.initConnection();
    }

 // This function checks if the user exists in the Users table
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		Boolean check = DatabaseDriver.isValidUser(username, password);
		
		if (check) {
			out.println("User exists");
			int userId = DatabaseDriver.getUserID(username);
			request.getSession().setAttribute("userId", userId);
		}
		else out.println("User does not exist");
	}
	
	// This function inserts the user into the Users table
		// if the username is not already in the table
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		
		if (DatabaseDriver.getUserID(username) != -1) {
			out.println("User already exists in the database");
		} else {
			DatabaseDriver.registerUser(username, password, name, email);
			int userId = DatabaseDriver.getUserID(username);
			request.getSession().setAttribute("userId", userId);
			out.println("User does not exist");
		}
	}

}
