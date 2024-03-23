package DAO;
import DTO.MatHangDTO;
import java.sql.*;
import java.util.*;
public class MatHangDAO {
	private Connection con;
	public boolean openConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String dbUrl = "jdbc:mysql://localhost:3306/chtt" ;
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
	public void closeConnection(){
		try {
		if(con!=null) {
			con.close();
		}
	} catch(Exception e) {
		System.out.println(e);
	     }
	}
		public Vector<MatHangDTO> mathang(){ {
			Vector<MatHangDTO> arr = new Vector<MatHangDTO>();
			if(openConnection()) {
				try {
					String sql = "SELECT *FROM mathang";
					Statement stmt = con.createStatement();
					ResultSet rs = stmt.executeQuery(sql);
					while(rs.next()) {
						MatHangDTO m = new MatHangDTO();
						m.setmaMH(rs.getString("mahang"));
						m.settenMH(rs.getString("tenhang"));
						m.setloai(rs.getString("loai"));
						m.setgia(rs.getDouble("gia"));
						m.setsoLuong(rs.getInt("soluong"));
						arr.add(m);
					}
				}
				catch(Exception e) {
					System.out.println(e.toString());
				}
				finally {
					closeConnection();
				}
			}
			return arr;
		   }
		}
		public boolean themHang(MatHangDTO m) {
			boolean result = false;
			if (openConnection()) {
			try {
			String sql = "Insert into mathang values(?,?,?,?,?)";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, m.getmaMH());
			stmt.setString(2, m.gettenMH());
			stmt.setString(3, m.getloai());
			stmt.setDouble(4, m.getgia());
			stmt.setInt(5, m.getsoLuong());
			if(stmt.executeUpdate()>=1) {
				result = true;
			}
		}catch(Exception e) {
			System.out.println(e);
		}
			finally {
				closeConnection();
			}
    }
			return result;
  }    
		public boolean trungMa(String ma) {
			boolean result = false; 
			if(openConnection()) {
				try {
					String sql= "select *from mathang where mahang='"+ ma +"'";
					Statement stmt = con.createStatement();
					ResultSet rs = stmt.executeQuery(sql);
					result = rs.next();
				}catch(Exception e) {
					System.out.println(e);
				}finally {
					closeConnection();
		  }
			}
			return result;
		}
	public boolean xoaHang(String ma)  {
		boolean result = false;
		if(openConnection()) {
			
			try {
				String sql = "delete from mathang where mahang= ?";
				PreparedStatement stmt = con.prepareStatement(sql);
				stmt.setString(1, ma);
				if(stmt.executeUpdate()>=1) {
					result= true;
				}
			}catch(Exception e) {
				e.printStackTrace();
				System.out.println(e);
			}finally {
				closeConnection();
			}
		}
		return result;
	}
	public boolean suaHang(String ma, MatHangDTO mh) {
		boolean result = false;
		if(openConnection()) {
			try {
				String sql = "update mathang set mahang=?, tenhang=?, loai=?, gia=?, soluong=? where mahang=?";
				PreparedStatement stmt = con.prepareStatement(sql);
				stmt.setString(1,mh.getmaMH());
				stmt.setString(2, mh.gettenMH());
				stmt.setString(3, mh.getloai());
				stmt.setDouble(4, mh.getgia());
				stmt.setInt(5, mh.getsoLuong());
				stmt.setString(6,ma);
				if(stmt.executeUpdate()>=1) {
					result = true;
				}
			}catch (Exception e) {
				System.out.println(e);
			}finally {
				closeConnection();
			}
		}
		return result;
	}
	public Vector<MatHangDTO> mathangtheoma(String ma){
		Vector<MatHangDTO> arr = new Vector<>();
		if(openConnection()) {
			try {
					String sql = "select * from mathang where mahang='"+ma+ "'"; 
					Statement stmt = con.createStatement();
					ResultSet rs = stmt.executeQuery(sql);
					while(rs.next()) {
						MatHangDTO m = new MatHangDTO();
						m.setmaMH(rs.getString("mahang"));
						m.settenMH(rs.getString("tenhang"));
						m.setloai(rs.getString("loai"));
						m.setgia(rs.getDouble("gia"));
						m.setsoLuong(rs.getInt("soluong"));
						arr.add(m);
					}
			}catch (Exception e) {
				System.out.println(e);
			} finally {
				closeConnection();
			}
		}
		return arr;
	}
	public Vector<MatHangDTO> mathangtheoten(String ten){
		Vector<MatHangDTO> arr = new Vector<>();
		if(openConnection()) {
			try {
				String sql = "select * from mathang where tenhang='"+ten +"'";
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				while(rs.next()) {
					MatHangDTO mh = new MatHangDTO();
				    mh.setmaMH(rs.getString("mahang"));
					mh.settenMH(rs.getString("tenhang"));
					mh.setloai(rs.getString("loai"));
					mh.setgia(rs.getDouble("gia"));
					mh.setsoLuong(rs.getInt("soluong"));
					arr.add(mh);
				}
			}catch(Exception e) {
				System.out.println(e);
			}finally {
				closeConnection();
			}
		}
		return arr;
	}
	/*public long ThanhTien(String id) {
		long sum=0;
		if(openConnection()) {
			try {
				String sql = "select gia from mathang where mahang=?"; 
				PreparedStatement stmt = con.prepareStatement(sql);
				stmt.setString(1, id);
				ResultSet rs = stmt.executeQuery();
				if(rs.next()) {
					sum= rs.getLong(1);
				}
			}catch(Exception e) {
				
			}finally {
				closeConnection();
			}
		}
		return sum;
	}*/
	public long ThanhTien(String id) {
		long sum =0;
		if(openConnection()) {
			try {
				String sql = "select gia from mathang where mahang='"+id+"'";
				Statement stmt =con.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				if(rs.next()) {
					sum=rs.getLong(1);
				}
			}catch(Exception e) {
				
			}finally {
				closeConnection();
			}
		}
		return sum;
	}
}
