package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;

public class Home extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home frame = new Home();
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
	public Home() {
		setTitle("HOME");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 624, 456);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 245, 238));
		contentPane.setForeground(new Color(204, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Quản lí sản phẩm ");
		btnNewButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/clothes-rack.png")));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MatHangGUI().setVisible(true);
			}
		});
		btnNewButton.setBackground(new Color(255, 228, 225));
		btnNewButton.setBounds(332, 61, 234, 101);
		contentPane.add(btnNewButton);
		
		JButton btnQunLNhn = new JButton("Quản lí nhân viên ");
		btnQunLNhn.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnQunLNhn.setIcon(new ImageIcon(Home.class.getResource("/img/customer-service.png")));
		btnQunLNhn.setBackground(new Color(255, 228, 225));
		btnQunLNhn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			new NhanVienGUI().setVisible(true);
				
			}
		});
		btnQunLNhn.setBounds(55, 61, 234, 101);
		contentPane.add(btnQunLNhn);
		
		JButton btnQunLKhch = new JButton("Quản lí khách hàng");
		btnQunLKhch.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnQunLKhch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/rating.png")));
		btnQunLKhch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new KhachHangGUI().setVisible(true);
			}
		});
		btnQunLKhch.setBackground(new Color(255, 228, 225));
		btnQunLKhch.setBounds(332, 224, 234, 101);
		contentPane.add(btnQunLKhch);
		
		JButton btnNewButton_2_1 = new JButton("Quản lí hóa đơn");
		btnNewButton_2_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_2_1.setIcon(new ImageIcon(Home.class.getResource("/img/bill.png")));
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new HoaDonGUI().setVisible(true);
			}
		});
		btnNewButton_2_1.setBackground(new Color(255, 228, 225));
		btnNewButton_2_1.setBounds(55, 224, 234, 101);
		contentPane.add(btnNewButton_2_1);
	}
}
