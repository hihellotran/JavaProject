package DAO;

import java.sql.*;
public class ConnectDB {
	public Connection getConnection() {
		Connection con = null;
	try{
		Class.forName("com.mysql.cj.jdbc.Driver");
		String dbUrl = "jdbc:mysql://localhost:3306/chtt" ;
		String username = "root"; 
		String password= "";
		con=DriverManager.getConnection(dbUrl, username, password);
		} 
	    catch(Exception e){
		System.out.println(e); 
		}
	return con;
	}
}

