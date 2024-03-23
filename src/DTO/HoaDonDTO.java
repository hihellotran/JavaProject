package DTO;


public class HoaDonDTO {
	private String maHD,maMH, maNV, maKH;
	private String ngay;
	private int sl;
	private long gia;
	public HoaDonDTO() {
		
	}
	public HoaDonDTO(String maHD,String maMH, String maNV, String maKH, String ngay, int sl, long gia) {
		this.maHD = maHD;
		this.maNV= maNV;
		this.maKH = maKH;
		this.maMH= maMH;
		this.ngay= ngay;
		this.sl = sl;
		this.gia= gia;
	}
	public String getmaHD() {
		return maHD;
	}
	public void setmaHD(String maHD) {
		this.maHD = maHD;
	}
	public String getmaMH() {
		return maMH;
	}
	public void setmaMH(String maMH) {
		this.maMH = maMH;
	}
	public String getmaNV() {
		return maNV;
	}
	public void setmaNV(String maNV) {
		this.maNV= maNV;
	}
	public String getmaKH() {
		return maKH;
	}
	public void setmaKH(String maKH) {
		this.maKH= maKH;
	}
	public String getNgay() {
		return ngay;
	}
	public void setNgay(String ngay) {
		this.ngay = ngay;
	}
	public int getSl() {
		return sl;
	}
	public void setSl(int sl) {
		this.sl = sl;
	}
	public long getGia() {
		return gia;
	}
	public void setGia(long gia) {
		this.gia = gia;
	}
	
}
