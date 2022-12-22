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

@WebServlet("/feedback")
public class FeedbackServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public FeedbackServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		try {
		//Database Connection
		DatabaseConfig db = new DatabaseConfig();
		Connection con = db.getCon();
		String username = request.getParameter("username");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String message = request.getParameter("message");
		PreparedStatement pst = con.prepareStatement("insert into feedback(username,email,phone,feedback) values(?,?,?,?)");
		pst.setString(1, username);
		pst.setString(2, email);
		pst.setString(3, phone);
		pst.setString(4, message);		
		pst.executeUpdate();
		HttpSession ht = request.getSession();
		Message m = new Message("Thanku for your valuable feedback...We will get back to u as soon as possible","success","alert-success");
		ht.setAttribute("msg", m);
		response.sendRedirect("feedback.jsp");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
