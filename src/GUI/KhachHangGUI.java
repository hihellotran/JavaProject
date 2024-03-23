package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import DTO.KhachHangDTO;
import DTO.NhanVienDTO;
import BUS.KhachHangBUS;

import java.awt.event.ActionListener;
import java.util.Vector;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class KhachHangGUI extends JFrame {
	KhachHangBUS bus = new KhachHangBUS();
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	DefaultTableModel dtm = new DefaultTableModel();
    JTable table = new JTable(dtm);
    public void loadList() {
		Vector<KhachHangDTO> arr = new Vector<KhachHangDTO>();
		arr= bus.khachhang();
		for(int i=0; i<arr.size(); i++) {
		   KhachHangDTO kh = arr.get(i);
			String ma = kh.getmaKH();
			String ten= kh.gettenKH();
			String dc = kh.getDiaChi();
			int dth = kh.getsoDTH();
			Object[] row = {ma, ten, dc, dth};
			dtm.addRow(row);
		}
	}
	public void deleteAllDataTable() {
		dtm = (DefaultTableModel) table.getModel();
		dtm.getDataVector().removeAllElements();
	}
	public void TimKiem(String ten) {
		Vector<KhachHangDTO> arr = new Vector<KhachHangDTO>();
		arr = bus.timkiem(ten);
		for(int i=0; i<arr.size(); i++) {
			KhachHangDTO k = arr.get(i);
			String ma = k.getmaKH();
			String name = k.gettenKH();
			String dc = k.getDiaChi();
			int dth = k.getsoDTH();
			Object[] row = {ma, ten, dc, dth};
			dtm.addRow(row); 
		}
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					KhachHangGUI frame = new KhachHangGUI();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public KhachHangGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("QU\u1EA2N L\u00DD KH\u00C1CH H\u00C0NG");
		setBounds(100, 100, 770, 553);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 248, 220));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 228, 196));
		panel.setBounds(10, 11, 734, 59);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("JV STORE");
		lblNewLabel.setForeground(new Color(139, 0, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 35));
		lblNewLabel.setBounds(269, 11, 196, 37);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 228, 196));
		panel_1.setBounds(10, 81, 206, 342);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("M\u00E3 kh\u00E1ch h\u00E0ng:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(10, 11, 117, 19);
		panel_1.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(10, 31, 174, 28);
		panel_1.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("H\u1ECD v\u00E0 t\u00EAn:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1.setBounds(10, 76, 117, 19);
		panel_1.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_3 = new JLabel("S\u1ED1 \u0111i\u1EC7n tho\u1EA1i:");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_3.setBounds(10, 146, 117, 19);
		panel_1.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("\u0110\u1ECBa ch\u1EC9:");
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_4.setBounds(10, 207, 60, 19);
		panel_1.add(lblNewLabel_1_4);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(10, 96, 174, 28);
		panel_1.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(10, 168, 174, 28);
		panel_1.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(10, 233, 174, 28);
		panel_1.add(textField_3);
		dtm.addColumn("Mã");
		dtm.addColumn("Tên");
		dtm.addColumn("Địa Chỉ");
		dtm.addColumn("sdt");
		JButton btnThm = new JButton("TH\u00CAM");
		btnThm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField.getText().trim().equals("")|| textField_1.getText().trim().equals("")|| textField_2.getText().trim().equals("")||
						textField_3.getText().trim().equals("")){
					JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin");
				}
				else {
					KhachHangDTO kh = new KhachHangDTO();
					kh.setmaKH(textField.getText());
					kh.settenKH(textField_1.getText());
					kh.setDiaChi(textField_3.getText());
					kh.setsoDTH(Integer.parseInt(textField_2.getText()));
					try {
						JOptionPane.showMessageDialog(null, bus.them(kh));
					}catch (HeadlessException e1) {
						e1.printStackTrace();
					}
					//System.out.print(nv.getmaNV());
		
				}
				deleteAllDataTable();
				loadList();
			}
		});
		btnThm.setBounds(10, 298, 85, 33);
		panel_1.add(btnThm);
		btnThm.setForeground(new Color(165, 42, 42));
		btnThm.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JButton btnHy = new JButton("HỦY");
		btnHy.setForeground(new Color(165, 42, 42));
		btnHy.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnHy.setBounds(99, 298, 85, 33);
		panel_1.add(btnHy);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 228, 196));
		panel_2.setBounds(10, 434, 206, 69);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JButton btnNewButton = new JButton("S\u1EECA");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)  {
				int i = table.getSelectedRow();
				String id = dtm.getValueAt(i, 0).toString();
				KhachHangDTO kh = new KhachHangDTO();
				if(i>=0) {
					
					kh.setmaKH(textField.getText());
					kh.settenKH(textField_1.getText());
					kh.setsoDTH(Integer.parseInt(textField_2.getText()));
					kh.setDiaChi(textField_3.getText());					
				}
				try {
					JOptionPane.showMessageDialog(null, bus.sua(id, kh));
					
				}catch(Exception e1) {
					System.out.println(e1);
				} 
				deleteAllDataTable();
				loadList();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setForeground(new Color(165, 42, 42));
		btnNewButton.setBounds(22, 16, 65, 33);
		panel_2.add(btnNewButton);
		
		JButton btnXa = new JButton("X\u00D3A");
		btnXa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = table.getSelectedRow();
				String id = dtm.getValueAt(i, 0).toString();
				if(i>=0) {
					JOptionPane.showMessageDialog(null, bus.xoa(id));
				}
				deleteAllDataTable();
				loadList();
			}
		});
		btnXa.setForeground(new Color(165, 42, 42));
		btnXa.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnXa.setBounds(110, 16, 65, 33);
		panel_2.add(btnXa);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 228, 196));
		panel_3.setBounds(228, 81, 516, 422);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		JButton btnTmKim = new JButton("T\u00CCM KI\u1EBEM");
		btnTmKim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dtm.setRowCount(0);
				String tim = textField_4.getText();
				TimKiem(tim);
			}
		});
		btnTmKim.setForeground(new Color(165, 42, 42));
		btnTmKim.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnTmKim.setBounds(397, 11, 109, 33);
		panel_3.add(btnTmKim);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 60, 496, 307);
		panel_3.add(scrollPane);
		
		//table = new JTable();
		/*table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"M\u00E3 kh", "T\u00EAn", "\u0110\u1ECBa ch\u1EC9 ", "S\u1ED1 \u0111th"
			}
		));*/
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int i = table.getSelectedRow();
				dtm = (DefaultTableModel) table.getModel();
				textField.setText(dtm.getValueAt(i, 0).toString());
				textField_1.setText(dtm.getValueAt(i, 1).toString());
				textField_2.setText(dtm.getValueAt(i, 3).toString());
				textField_3.setText(dtm.getValueAt(i, 2).toString());
			}
		});
		scrollPane.setViewportView(table);
		
		textField_4 = new JTextField();
		textField_4.setBounds(166, 15, 174, 28);
		panel_3.add(textField_4);
		textField_4.setColumns(10);
		
		JButton btnThot = new JButton("THOÁT");
		btnThot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		btnThot.setForeground(new Color(165, 42, 42));
		btnThot.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnThot.setBounds(411, 378, 95, 33);
		panel_3.add(btnThot);
		loadList();
	}
}