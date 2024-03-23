package BUS;
import DTO.HoaDonDTO;

import java.util.Vector;

import DAO.HoaDonDAO;
public class HoaDonBUS {
	HoaDonDAO hd = new HoaDonDAO();
	public Vector<HoaDonDTO> hoadon(){
		return hd.hoadon();
	}
	public String Them(HoaDonDTO h) {
		if(hd.Trungma(h.getmaHD()))
			return "Mã hóa đơn đã tồn tại";
		if(hd.Themhd(h)) 
			return "Thêm Thành công";
		return "Thêm thất bại";
	}
	public String Xoa(String id) {
		if(hd.Xoahd(id))
			return "Xóa thành công";
		return "Xóa thất bại";
	}
	public String Sua (String id,HoaDonDTO h) {
		if(hd.Suahd(id, h)) {
			return "Sửa thành công";
		}
		if(hd.Trungma(id)) {
			return "Mã hóa đơn đã tồn tại";
		}
		else {
			return "Sửa thất bại";
		}
	}
	public Vector<HoaDonDTO> Tim(String id){
		return hd.TimKiem(id);
	}
}
