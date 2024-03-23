package DAO;
import DTO.LoginDTO;
import java.sql.*;
import java.util.ArrayList;
public class LoginDAO {
	private Connection con;
	boolean openConnection() {
	try{
		Class.forName("com.mysql.cj.jdbc.Driver");
		String dbUrl = "jdbc:mysql://localhost:3306/chtt";
		String username = "root"; 
		String password= "";
		con=DriverManager.getConnection(dbUrl, username, password);
		return true;
		} 
	    catch(Exception e){
		System.out.println(e); 
		return false;
		}
	}
	public void closeConnection() {
		try {
		if(con!=null) {
			con.close();
		}
		}catch(Exception e) {
			System.out.println(e);
		}
	}
		
  public ArrayList<LoginDTO> log() throws Exception{
			ArrayList<LoginDTO> list = new ArrayList<>();
			if(openConnection()) {
				try {
					String sql = "select *from login";
					Statement stmt = con.createStatement();
					ResultSet rs = stmt.executeQuery(sql);
					while(rs.next()) {
						LoginDTO lg = new LoginDTO();
					    lg.setmaMV(rs.getString(1));
					    lg.setpass(rs.getString(2));
					    list.add(lg);
					}
					
				}catch(Exception e) {
					System.out.println(e);
				}finally {
					closeConnection();
				}
			}
			return list;
		}
	

}
