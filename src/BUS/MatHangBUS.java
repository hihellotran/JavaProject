 package BUS;
 import DTO.MatHangDTO;
 import DAO.MatHangDAO;

import java.sql.SQLException;
import java.util.*;
public class MatHangBUS {
	MatHangDAO mh = new MatHangDAO();
	public Vector<MatHangDTO> mathang(){
		return mh.mathang();
		
	}
	public String them(MatHangDTO m) {
		if(mh.trungMa(m.getmaMH())) 
			return "Mã đã tồn tại";
		if(mh.themHang(m)) 
		return "Thêm thành công";
		return "Thêm thất bại";
	}
	public String xoa(String ma) {
		if(mh.xoaHang(ma)) 
			return "Xóa thành công";
			else
				return "Xóa thất bại";
	}
	public String sua(String ma, MatHangDTO mathang) {
		if(mh.suaHang(ma, mathang)) {
		return "Sửa thành công";
		}
		if(mh.trungMa(ma)) {
			return "Mã đã tồn tại";
		}
		else {
			return "Sửa thất bại";
		}
	}
		public Vector<MatHangDTO> timkiem(String ma){
			return mh.mathangtheoma(ma);
			
		}
		public Vector<MatHangDTO> timkiem2(String ten){
			return mh.mathangtheoten(ten);
	}
		public long gia(String id) {
			return mh.ThanhTien(id);
			
		}
		
	}
