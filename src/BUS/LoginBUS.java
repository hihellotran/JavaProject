package BUS;
import DTO.LoginDTO;
import DAO.LoginDAO;
import java.util.ArrayList;
public class LoginBUS {
	  public static ArrayList<LoginDTO> list;    
	    public LoginBUS(){}
	    public ArrayList<LoginDTO> docLogin(){
	        LoginDAO data = new LoginDAO();
	        try{
	        if(list== null){
	            list = new ArrayList<LoginDTO>();
	            list = data.log();
	            }
	        }catch(Exception e){
	            e.printStackTrace();
	        }
	        return list;
	    }
	    public boolean kiemtradangnhap(String manv,String password){
	    for(LoginDTO lg : docLogin()){
	        if(lg.getmaNV().trim().toLowerCase().equals(manv.trim().toLowerCase())){
	            if(lg.getpass().trim().toLowerCase().equals(password.trim().toLowerCase()))
	                    return true;}
	                return false;}
	            return true;}    
		
	}

