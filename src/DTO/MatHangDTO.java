package DTO;

public class MatHangDTO {
	private String maMH,tenMH, loai;
	private double gia;
	private int soLuong;
	public MatHangDTO() {
		
	}
	public MatHangDTO(String maMH, String tenMH,String loai, double gia, int SoLuong) {
		this.maMH = maMH;
		this.tenMH = tenMH;
		this.loai = loai;
		this.gia = gia;
		this.soLuong = soLuong;
		
	}
	public String getmaMH() {
		return maMH;
	}
	public void setmaMH(String maMH) {
		this.maMH = maMH;
	}
	public String gettenMH() {
		return tenMH;
	}
	public void settenMH(String tenMH) {
		this.tenMH = tenMH;
	}
	public String getloai() {
		return loai;
	}
	public void setloai(String loai) {
		this.loai = loai;
	}
	public double getgia() {
		return gia;
	}
	public void setgia(double gia ) {
		this.gia = gia;
	}
	public int getsoLuong() {
		return soLuong;
	}
	public void setsoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	

}
