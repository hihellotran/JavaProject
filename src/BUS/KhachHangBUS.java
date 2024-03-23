package BUS;
import DTO.KhachHangDTO;
import DAO.KhachHangDAO;

import java.util.Vector;
public class KhachHangBUS {
		KhachHangDAO kh = new KhachHangDAO();
		public Vector<KhachHangDTO> khachhang(){
			return kh.khachhang() ;
			}
		public String them(KhachHangDTO k) {
			if(kh.Trungma(k.getmaKH()))
				return "Trùng mã";
			if(kh.Themkh(k))
				return "Thêm thành công";
			return "Thêm thất bại";
		}
		public String xoa(String id) {
			if(kh.Xoakh(id))
				return "Xóa thành công ";
			else
				return "Xóa thất bại";
		}
		public String sua(String id, KhachHangDTO k) {
			if(kh.Trungma(k.getmaKH()))
				return "Trùng mã khách hàng";
			if(kh.Suakh(id, k)) 
				return "Sửa thành công";
			return "Sửa thất bại";
				
		}
		public Vector<KhachHangDTO> timkiem(String ten){
			return kh.khtheoten(ten);
		}
		
		public KhachHangDTO khtheomaDetail(String id) {
			return kh.khtheomaDetail(id);
		}
			
}
