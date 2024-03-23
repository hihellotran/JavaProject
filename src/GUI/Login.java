package GUI;

import java.awt.BorderLayout;
import BUS.LoginBUS;
import java.sql.*;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Button;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import javax.swing.JSeparator;
import javax.swing.JEditorPane;
import javax.swing.JToggleButton;
import javax.swing.JSpinner;
import javax.swing.SwingConstants;
import DTO.LoginDTO;
public class Login extends JFrame {
	LoginBUS bus = new LoginBUS();
	public boolean Check() {
	if(bus.kiemtradangnhap(textField.getText(),textField_1.getText()))
		return true;
	return false;
	}
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 556, 405);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel_1 = new JPanel();
		panel_1.setForeground(new Color(204, 0, 0));
		panel_1.setBackground(new Color(255, 204, 204));
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("UserName");
		lblNewLabel_1.setForeground(new Color(255, 0, 102));
		lblNewLabel_1.setFont(new Font("Wide Latin", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(36, 117, 139, 50);
		panel_1.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setForeground(new Color(255, 51, 102));
		textField.setBounds(221, 124, 223, 36);
		panel_1.add(textField); 
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Password");
		lblNewLabel_2.setFont(new Font("Wide Latin", Font.PLAIN, 15));
		lblNewLabel_2.setForeground(new Color(255, 0, 102));
		lblNewLabel_2.setBounds(36, 183, 155, 44);
		panel_1.add(lblNewLabel_2);
		
		textField_1 = new JPasswordField();
		textField_1.setForeground(new Color(250, 128, 114));
		textField_1.setBounds(221, 186, 223, 38);
		panel_1.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("SUBMIT");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.setForeground(new Color(255, 105, 180));
		btnNewButton.setBackground(new Color(255, 192, 203));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Check()==true){
			       JOptionPane.showMessageDialog(null, "Đăng nhập thành công");
		            new Home().setVisible(true);
		            setVisible(false);
 	            
		        }else{
		          if(textField.getText().trim().equals("")||textField_1.getText().trim().equals("")){
		             JOptionPane.showMessageDialog(null, "Bạn bỏ trống tài khoản hoặc mật khẩu");                             
		          }else {
		             JOptionPane.showMessageDialog(null, "Nhập sai tài khoản hoặc mật khẩu");}            
		        }   

			}
		});
		btnNewButton.setBounds(221, 252, 139, 36);
		panel_1.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("LOGIN");
		lblNewLabel.setBounds(234, 31, 126, 37);
		panel_1.add(lblNewLabel);
		lblNewLabel.setForeground(new Color(255, 51, 102));
		lblNewLabel.setFont(new Font("Tw Cen MT", Font.BOLD | Font.ITALIC, 32));
		
		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(255, 102, 153));
		separator.setBounds(476, 71, -428, -3);
		panel_1.add(separator);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 102, 204));
		panel.setForeground(new Color(255, 0, 102));
		panel.setBounds(62, 75, 439, -7);
		panel_1.add(panel);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(new Color(255, 105, 180));
		separator_1.setBackground(new Color(220, 20, 60));
		separator_1.setBounds(36, 80, 475, 2);
		panel_1.add(separator_1);
	}
}
