package servlet_package;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Connection_Provider.DatabaseConfig;
import Connection_Provider.Message;

@WebServlet("/Reg")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RegisterServlet() {
        super();
        
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		try {
		//Database Connection
		DatabaseConfig db = new DatabaseConfig();
		Connection con = db.getCon();
		
		//Fetching all register form data  using servlet 
		String username = request.getParameter("username");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		PreparedStatement pst = con.prepareStatement("insert into user(name,email,password) values(?,?,?)");
		pst.setString(1, username);
		pst.setString(2, email);
		pst.setString(3, password);
		pst.executeUpdate();
		HttpSession ht = request.getSession();
		Message m = new Message("Congratulations!! Your account has been registered successfully","success","alert-success");
		ht.setAttribute("msg", m);
		response.sendRedirect("login.jsp");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
