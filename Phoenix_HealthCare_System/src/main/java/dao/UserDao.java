package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import Connection_Provider.DatabaseConfig;
import entities.User;
public class UserDao {
DatabaseConfig db = new DatabaseConfig();
Connection con = db.getCon();

//METHOD TO FETCH USER BY EMAIL AND PASSWORD
public User getUserByEmailAndPassword(String email,String password){
	User user=null;
	try {
		PreparedStatement pst = con.prepareStatement("select * from user where email=? and password=?");
		pst.setString(1, email);
		pst.setString(2, password);
		ResultSet rst = pst.executeQuery();
		if(rst.next()) {
	        user = new User();
	        user.setUsername(rst.getString("username"));
	        user.setEmail(rst.getString("email"));
	        user.setPassword(rst.getString("password"));   
		}
	}
	catch(Exception e) {
		e.printStackTrace();
	}
	return user;
}
}
