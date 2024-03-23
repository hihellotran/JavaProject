package DAO;
import DTO.NhanVienDTO;
import java.util.Vector;
import java.sql.*;

public class NhanVienDAO {
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
	public Vector<NhanVienDTO> nhanvien(){
		Vector <NhanVienDTO> arr = new Vector<>();
		if(openConnection()) {
			try {
				String sql = "select * from nhanvien";
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				while(rs.next()) {
					NhanVienDTO nv = new NhanVienDTO();
					nv.setmaNV(rs.getString("manv"));
					nv.settenNV(rs.getString("tennv"));
					nv.setChucVu(rs.getString("chucvu"));
					nv.setDiaChi(rs.getString("diachi"));
					nv.setsoDTH(rs.getInt("sodth"));
					nv.setLuong(rs.getDouble("luong"));
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
	public boolean Themnv(NhanVienDTO nv) {
		boolean result = false;
		if(openConnection()) {
			try {
				String sql = "Insert into nhanvien values(?,?,?,?,?,?)";
				PreparedStatement stmt = con.prepareStatement(sql);
				stmt.setString(1, nv.getmaNV());
				stmt.setString(2, nv.gettenNV());
				stmt.setString(3, nv.getChucVu());
				stmt.setString(4, nv.getDiaChi());
				stmt.setInt(5, nv.getsoDTH());
				stmt.setDouble(6, nv.getLuong());
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
	public boolean Xoanv(String id) {
		boolean result = false;
		if(openConnection()) {
			try {
				String sql = "delete from nhanvien where manv=?";
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
	public boolean Suanv(String id, NhanVienDTO nv) {
		boolean result = false;
		if(openConnection()) {
			try {
				String sql = "update nhanvien set manv=?, tennv=?, chucvu=?, diachi=?, sodth=?, luong=? where manv=?";
				PreparedStatement stmt = con.prepareStatement(sql);
				stmt.setString(1, nv.getmaNV());
				stmt.setString(2, nv.gettenNV());
				stmt.setString(3, nv.getChucVu());
				stmt.setString(4, nv.getDiaChi());
				stmt.setInt(5, nv.getsoDTH() );
				stmt.setDouble(6, nv.getLuong());
				stmt.setString(7, id);
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
	public Vector<NhanVienDTO> nvtheoten(String ten){
		Vector<NhanVienDTO> arr = new Vector<>();
		if(openConnection()) {
			try {
				String sql = "select * from nhanvien where tennv='"+ten +"'";
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				while(rs.next()) {
					NhanVienDTO nv = new NhanVienDTO();
				    nv.setmaNV(rs.getString("manv"));
					nv.settenNV(rs.getString("tennv"));
					nv.setChucVu(rs.getString("chucvu"));
					nv.setDiaChi(rs.getString("diachi"));
					nv.setsoDTH(rs.getInt("sodth"));
					nv.setLuong(rs.getDouble("luong"));
					arr.add(nv);
				}
			}catch(Exception e) {
				System.out.println(e);
			}finally {
				closeConnection();
			}
		}
		return arr;
	}
	public boolean Trungma(String ma) {
		boolean result = false;
		if(openConnection()) {
			try {
				String sql = "select * from nhanvien where manv='"+ma+"'";
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
