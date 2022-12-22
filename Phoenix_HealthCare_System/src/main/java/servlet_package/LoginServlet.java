package servlet_package;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Connection_Provider.DatabaseConfig;
import Connection_Provider.Message;
import dao.UserDao;
import entities.User;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginServlet() {
        super();
      
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		try {
			DatabaseConfig db = new DatabaseConfig();
			Connection con = db.getCon();
		String email = request.getParameter("email");
		String password = request.getParameter("password");		
		UserDao dao = new UserDao();
		User u = dao.getUserByEmailAndPassword(email, password);
		if(email.equals("admin")&&password.equals("admin")) {
			response.sendRedirect("admindashboard.jsp");
		}
		else if(u==null) {		
			HttpSession ht = request.getSession();
			Message m = new Message("OOPS!! The email and password u entered does not match in our database.Please try again with valid email and password","error","alert-error");
			ht.setAttribute("msg", m);
			response.sendRedirect("login.jsp");
			}
		else {
			HttpSession s = request.getSession();
			s.setAttribute("currentUser", u);
			response.sendRedirect("patientdashboard.jsp");
		}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	
	}

}
