package DAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;
import DTO.HoaDonDTO;
public class HoaDonDAO {
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
	public Vector<HoaDonDTO> hoadon(){
		Vector <HoaDonDTO> arr = new Vector<>();
		if(openConnection()) {
			try {
				String sql = "select * from hoadon";
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				while(rs.next()) {
					HoaDonDTO hd = new HoaDonDTO();
					hd.setmaHD(rs.getString("mahd"));
					hd.setmaMH(rs.getString("mahang"));
					hd.setmaNV(rs.getString("manv"));
					hd.setmaKH(rs.getString("makh"));
					hd.setNgay(rs.getString("ngay"));
					hd.setSl(rs.getInt("soluong"));
					hd.setGia(rs.getLong("gia"));
					arr.add(hd);
				}
			}catch(Exception e) {
				System.out.println(e);
			}finally{
				closeConnection();
			}
		}
		return arr;
	}
	
	
	public boolean Themhd(HoaDonDTO hd) {
		boolean result = false;
		if(openConnection()) {
			try {
				String sql = "Insert into hoadon values(?,?,?,?,?,?,?)";
				PreparedStatement stmt = con.prepareStatement(sql);
				stmt.setString(1, hd.getmaHD());
				stmt.setString(2, hd.getmaMH());
				stmt.setString(3, hd.getmaNV());
				stmt.setString(4, hd.getmaKH());
				stmt.setString(5, hd.getNgay());
				stmt.setInt(6, hd.getSl());
				stmt.setLong(7, hd.getGia());
				if(stmt.executeUpdate()>=1) {
					result = true;
				}
			}catch(Exception e) {
				System.out.println(e);
			}finally {
				closeConnection();
			}
		}
		return result;
	}

	
	
	/*public boolean Themhd1(HoaDonDTO hd) {
		boolean result = false;
		if(openConnection()) {
			try {
				String sql = "insert into hoadon values(?,?,?,?,?,?,?)";
				PreparedStatement stmt = con.prepareStatement(sql);
				stmt.setString(1, hd.getmaHD());
				stmt.setString(2, hd.getmaMH());
				stmt.setString(3, hd.getmaNV());
				stmt.setString(4, hd.getmaKH());
				stmt.setString(5, hd.getNgay());
				stmt.setInt(6, hd.getSl());
				stmt.setLong(7, hd.getGia());
				if(stmt.executeUpdate()>=1) {
					result = true;
				}
				
			}catch(Exception e) {
				System.out.println(e);
			}finally {
				closeConnection();
			}
		}
		return result;
	}*/
	public boolean Xoahd(String id) {
		boolean result = false;
		if(openConnection()) {
			try {
				String sql = "delete from hoadon where mahd=?";
				PreparedStatement stmt = con.prepareStatement(sql);
				stmt.setString(1, id);
				if(stmt.executeUpdate()>=1) {
					result = true;
				}
			}catch(Exception e) {
				System.out.print(e);
			}finally {
				closeConnection();
			}
		}
		return result;
	}
	
	public boolean Suahd(String id, HoaDonDTO hd) {
		boolean result = false;
		if(openConnection()) {
			try {
				String sql = "update hoadon set mahd=?, mahang=?, manv=?, makh=?, ngay=?, soluong=?, gia=? where mahd=?";
				PreparedStatement stmt = con.prepareStatement(sql);
				stmt.setString(1, hd.getmaHD());
				stmt.setString(2, hd.getmaMH());
				stmt.setString(3, hd.getmaNV());
				stmt.setString(4, hd.getmaKH());
				stmt.setString(5, hd.getNgay());
				stmt.setInt(6, hd.getSl());
				stmt.setLong(7, hd.getGia());
				stmt.setString(8, id);
				if(stmt.executeUpdate()>=1) {
					result = true;
				}
			}catch(Exception e) {
				System.out.println(e);
			}finally {
				closeConnection();
			}
		}
		return result;
	}
	

	public Vector<HoaDonDTO> TimKiem(String id){
		Vector<HoaDonDTO> arr = new Vector<>();
		if(openConnection()) {
			try {
				String sql = "select * from hoadon where mahd='"+id +"'";
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				while(rs.next()) {
					HoaDonDTO hd = new HoaDonDTO();
					hd.setmaHD(rs.getString("mahd"));
					hd.setmaMH(rs.getString("mahang"));
					hd.setmaNV(rs.getString("manv"));
				    hd.setmaKH(rs.getString("makh"));
					hd.setNgay(rs.getString("ngay"));
					hd.setSl(rs.getInt("soluong"));
					hd.setGia(rs.getLong("gia"));
					arr.add(hd);
				}
			}catch(Exception e) {
				System.out.println(e);
			}finally {
				closeConnection();
			}
		}
		return arr;
	}
	
	
	public boolean Trungma(String id) {
		boolean result = false;
		if(openConnection()) {
			try {
				String sql = "select * from hoadon where mahd='"+id+"'";
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				rs.next(); 
				
			}catch(Exception e) {
				
			}finally {
				closeConnection();
			}
		}
		return result;
	}

}
