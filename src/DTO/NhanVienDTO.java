package DTO;

public class NhanVienDTO {
	private String maNV, tenNV, ChucVu,DiaChi;
	private int soDTH;
	private double Luong;
	public NhanVienDTO() {
		
	}
	public NhanVienDTO(String maNV, String tenNV, String ChucVu, String DiaChi, int soDTH, double Luong){
		this.maNV = maNV;
		this.tenNV = tenNV;
		this.ChucVu = ChucVu;
		this.DiaChi = DiaChi;
		this.soDTH = soDTH;
		this.Luong = Luong;
	}
	public String getmaNV() {
		return maNV;
	}
	public void setmaNV(String maNV) {
		this.maNV = maNV;
	}
	public String gettenNV() {
		return tenNV;
	}
	public void settenNV(String tenNV) {
		this.tenNV = tenNV;
	}
	public String getChucVu() {
		return ChucVu;
	}
	public void setChucVu(String ChucVu) {
		this.ChucVu = ChucVu;
	}
	public String getDiaChi() {
		return DiaChi;
	}
	public void setDiaChi(String DiaChi) {
		this.DiaChi = DiaChi;
	}
	public int getsoDTH() {
		return soDTH;
	}
	public void setsoDTH(int soDTH) {
		this.soDTH = soDTH;
	}
	public double getLuong() {
		return Luong;
	}
	public void setLuong(double Luong) {
		this.Luong = Luong;
	}
}
