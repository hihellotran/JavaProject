package DAO;
import DTO.KhachHangDTO;

import java.sql.*;
import java.util.Vector;
public class KhachHangDAO {
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
	public Vector<KhachHangDTO> khachhang(){
		Vector <KhachHangDTO> arr = new Vector<>();
		if(openConnection()) {
			try {
				String sql = "select * from khachhang";
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				while(rs.next()) {
					KhachHangDTO nv = new KhachHangDTO();
					nv.setmaKH(rs.getString("makh"));
					nv.settenKH(rs.getString("tenkh"));
					nv.setDiaChi(rs.getString("diachi"));
					nv.setsoDTH(rs.getInt("sodth"));
					arr.add(nv);
				}
			}catch(Exception e) {
				System.out.println(e);
			}finally{
				closeConnection();
			}
		}
		return arr;
	}
	public boolean Themkh(KhachHangDTO kh) {
		boolean result = false;
		if(openConnection()) {
			try {
				String sql = "Insert into khachhang values(?,?,?,?)";
				PreparedStatement stmt = con.prepareStatement(sql);
				stmt.setString(1, kh.getmaKH());
				stmt.setString(2, kh.gettenKH());
				stmt.setString(3, kh.getDiaChi());
				stmt.setInt(4, kh.getsoDTH());
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
	public boolean Xoakh(String id) {
		boolean result = false;
		if(openConnection()) {
			try {
				String sql = "delete from khachhang where makh=?";
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
	public boolean Suakh(String id, KhachHangDTO nv) {
		boolean result = false;
		if(openConnection()) {
			try {
				String sql = "update khachhang set makh=?, tenkh=?, diachi=?, sodth=? where makh=?";
				PreparedStatement stmt = con.prepareStatement(sql);
				stmt.setString(1, nv.getmaKH());
				stmt.setString(2, nv.gettenKH());
				stmt.setString(3, nv.getDiaChi());
				stmt.setInt(4, nv.getsoDTH() );
				stmt.setString(5, id);
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
	public Vector<KhachHangDTO> khtheoten(String ten){
		Vector<KhachHangDTO> arr = new Vector<>();
		if(openConnection()) {
			try {
				String sql = "select * from khachhang where tenkh='"+ten +"'";
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				while(rs.next()) {
					KhachHangDTO kh = new KhachHangDTO();
				    kh.setmaKH(rs.getString("makh"));
					kh.settenKH(rs.getString("tenkh"));
					kh.setDiaChi(rs.getString("diachi"));
					kh.setsoDTH(rs.getInt("sodth"));
					arr.add(kh);
				}
			}catch(Exception e) {
				System.out.println(e);
			}finally {
				closeConnection();
			}
		}
		return arr;
	}
	
	public KhachHangDTO khtheomaDetail(String id){
		KhachHangDTO kh = new KhachHangDTO();
		if(openConnection()) {
			try {
				String sql = "select * from khachhang where makh='"+id +"'";
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				while(rs.next()) {
				    kh.setmaKH(rs.getString("makh"));
					kh.settenKH(rs.getString("tenkh"));
					kh.setDiaChi(rs.getString("diachi"));
					kh.setsoDTH(rs.getInt("sodth"));
				}
			}catch(Exception e) {
				System.out.println(e);
			}finally {
				closeConnection();
			}
		}
		return kh;
	}
	
	public boolean Trungma(String id) {
		boolean result = false;
		if(openConnection()) {
			try {
				String sql = "select * from khachhang where makh='"+id+"'";
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

