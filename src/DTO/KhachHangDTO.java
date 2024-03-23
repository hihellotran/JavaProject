package DTO;

public class KhachHangDTO {
	private String maKH, tenKH,DiaChi ;
	private int soDTH;
	public  KhachHangDTO(){
		
	}
	public KhachHangDTO(String maKH, String tenKH, String DiaChi, int soDTH){
		this.maKH = maKH;
		this.tenKH = tenKH;
		this.DiaChi = DiaChi;
		this.soDTH = soDTH;
	}
	public String getmaKH() {
		return maKH;
	}
	public void setmaKH(String maKH) {
		this.maKH = maKH;
	}
	public String gettenKH() {
		return tenKH;
	}
	public void settenKH(String tenKH) {
		this.tenKH = tenKH;
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

}
