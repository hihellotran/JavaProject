package BUS;
import DAO.NhanVienDAO;
import DTO.NhanVienDTO;
import java.util.Vector;
public class NhanVienBUS {
	NhanVienDAO nv = new NhanVienDAO();
	public Vector<NhanVienDTO> nhanvien(){
		return nv.nhanvien() ;
		}
	public String them(NhanVienDTO n) {
		if(nv.Trungma(n.getmaNV()))
			return "Trùng mã";
		if(nv.Themnv(n))
			return "Thêm thành công";
		return "Thêm thất bại";
	}
	public String xoa(String id) {
		if(nv.Xoanv(id))
			return "Xóa thành công ";
		else
			return "Xóa thất bại";
	}
	public String sua(String id, NhanVienDTO n) {
		if(nv.Trungma(n.getmaNV()))
			return "Trùng mã nhân viên";
		if(nv.Suanv(id, n)) 
			return "Sửa thành công";
		return "Sửa thất bại";
			
	}
	public Vector<NhanVienDTO> timkiem(String ten){
		return nv.nvtheoten(ten);
	}
		
}
