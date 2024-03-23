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
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import DTO.HoaDonDTO;
import BUS.HoaDonBUS;
import java.text.SimpleDateFormat;
import java.util.Vector;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import BUS.MatHangBUS;
public class HoaDonGUI extends JFrame {

	private JPanel contentPane;
	private JTextField textField_hd;
	private JTextField textField_mh;
	private JTextField textField_nv;
	private JTextField textField_kh;
	private JTextField textField_n;
	private JTextField textField_6;
	MatHangBUS mh = new MatHangBUS();
	HoaDonBUS bus = new HoaDonBUS();
	DefaultTableModel dtm = new DefaultTableModel();
	JTable table = new JTable(dtm);
	private JTextField textField_sl;
	public void loadList() {
	Vector<HoaDonDTO> arr = new Vector<>();
	arr = bus.hoadon();
	for(int i=0; i<arr.size(); i++) {
		HoaDonDTO hd = arr.get(i);
		String ma = hd.getmaHD();
		String mh = hd.getmaMH();
		String nv = hd.getmaNV();
		String kh = hd.getmaKH();
		String ngay = hd.getNgay();
		int soluong = hd.getSl();
		long gia = hd.getGia();
		Object[] row= {ma, mh, nv, kh, ngay,soluong,gia};
		dtm.addRow(row);
	}
}
	public void deleteAllDataTable() {
		dtm = (DefaultTableModel) table.getModel();
		dtm.getDataVector().removeAllElements();
	}
	public void TimKiem(String id) {
		Vector<HoaDonDTO> arr = new Vector<>();
		arr = bus.Tim(id);
		for(int i=0; i<arr.size(); i++) {
			HoaDonDTO hd = arr.get(i);
			String ma = hd.getmaHD();
			String mh = hd.getmaMH();
			String nv = hd.getmaNV();
			String kh = hd.getmaKH();
			String ngay = hd.getNgay();
			int soluong = hd.getSl();
			long gia = hd.getGia();
			Object[] row= {ma, mh, nv, kh, ngay, soluong, gia};
			dtm.addRow(row);
		}
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HoaDonGUI frame = new HoaDonGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public HoaDonGUI() {
		setTitle("H\u00D3A \u0110\u01A0N");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 858, 550);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 248, 220));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 228, 196));
		panel.setBounds(10, 11, 822, 70);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("JV STORE");
		lblNewLabel.setForeground(new Color(139, 0, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblNewLabel.setBounds(294, 11, 214, 51);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 228, 196));
		panel_1.setBounds(10, 92, 822, 136);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("M\u00E3 h\u00F3a \u0111\u01A1n:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(10, 11, 134, 20);
		panel_1.add(lblNewLabel_1);
		
		textField_hd = new JTextField();
		textField_hd.setBounds(10, 31, 176, 26);
		panel_1.add(textField_hd);
		textField_hd.setColumns(10);
		
		JLabel lblNewLabel_1_2 = new JLabel("M\u00E3 m\u1EB7t h\u00E0ng:");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_2.setBounds(270, 11, 134, 20);
		panel_1.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("M\u00E3 nh\u00E2n vi\u00EAn:");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_3.setBounds(10, 75, 134, 20);
		panel_1.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("M\u00E3 kh\u00E1ch h\u00E0ng:");
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_4.setBounds(270, 75, 134, 20);
		panel_1.add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_5 = new JLabel("Ng\u00E0y l\u1EADp:");
		lblNewLabel_1_5.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_5.setBounds(512, 11, 83, 20);
		panel_1.add(lblNewLabel_1_5);
		
		textField_mh = new JTextField();
		textField_mh.setColumns(10);
		textField_mh.setBounds(270, 31, 176, 26);
		panel_1.add(textField_mh);
		
		textField_nv = new JTextField();
		textField_nv.setColumns(10);
		textField_nv.setBounds(10, 99, 176, 26);
		panel_1.add(textField_nv);
		
		textField_kh = new JTextField();
		textField_kh.setColumns(10);
		textField_kh.setBounds(270, 99, 176, 26);
		panel_1.add(textField_kh);
		
		textField_n = new JTextField();
		textField_n.setColumns(10);
		textField_n.setBounds(512, 31, 176, 26);
		panel_1.add(textField_n);
		
		JButton btnThot_1 = new JButton("RESET");
		btnThot_1.setBounds(682, 91, 102, 39);
		panel_1.add(btnThot_1);
		btnThot_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_hd.setText("");
				textField_mh.setText("");
				textField_nv.setText("");
				textField_kh.setText("");
				textField_n.setText("");
			}
		});
		btnThot_1.setForeground(new Color(165, 42, 42));
		btnThot_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		textField_sl = new JTextField();
		textField_sl.setColumns(10);
		textField_sl.setBounds(516, 99, 96, 26);
		panel_1.add(textField_sl);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Số lượng");
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_2_1.setBounds(522, 75, 134, 20);
		panel_1.add(lblNewLabel_1_2_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 228, 196));
		panel_2.setBounds(10, 239, 632, 261);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 52, 612, 198);
		panel_2.add(scrollPane);
		
		dtm.addColumn("Mã đơn hàng");
		dtm.addColumn("Mã mặt hàng");
		dtm.addColumn("Mã nhân viên");
		dtm.addColumn("Mã khách hàng");
		dtm.addColumn("Ngày lập hóa đơn");
		dtm.addColumn("Số lượng");
		dtm.addColumn("Giá");
		/*table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"M\u00E3 h\u00F3a \u0111\u01A1n", "M\u00E3 s\u1EA3n ph\u1EA9m", "M\u00E3 m\u1EB7t h\u00E0ng", "M\u00E3 nh\u00E2n vi\u00EAn", "M\u00E3 kh\u00E1ch h\u00E0ng", "Ng\u00E0y l\u1EADp"
			}
		));*/
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int i = table.getSelectedRow();
			    dtm = (DefaultTableModel) table.getModel();
			    textField_hd.setText(dtm.getValueAt(i, 0).toString());
			    textField_mh.setText(dtm.getValueAt(i, 1).toString());
			    textField_nv.setText(dtm.getValueAt(i, 2).toString());
			    textField_kh.setText(dtm.getValueAt(i, 3).toString());
			    textField_n.setText(dtm.getValueAt(i, 4).toString());
			    textField_sl.setText(dtm.getValueAt(i, 5).toString());
			}
		});
		scrollPane.setViewportView(table);
		loadList();
		JButton btnTmKim = new JButton("T\u00CCM KI\u1EBEM");
		btnTmKim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dtm.setRowCount(0);
				String search = textField_6.getText();
				TimKiem(search);
			}
		});
		btnTmKim.setForeground(new Color(165, 42, 42));
		btnTmKim.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnTmKim.setBounds(308, 11, 114, 30);
		panel_2.add(btnTmKim);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(432, 11, 190, 30);
		panel_2.add(textField_6);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 228, 196));
		panel_3.setBounds(652, 239, 180, 261);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		JButton btnNewButton = new JButton("TH\u00CAM");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField_hd.getText().trim().equals("") || textField_mh.getText().trim().equals("") ||
						textField_nv.getText().trim().equals("") || textField_kh.getText().trim().equals("") || 
						textField_n.getText().trim().equals("")|| textField_sl.getText().trim().equals("") ) {
					JOptionPane.showMessageDialog(null, "Vui lòng nhập nhập đầy đủ thông tin");
				}
					else {
						int soluong = Integer.parseInt(textField_sl.getText());
						long gia = mh.gia(textField_mh.getText());
						long tong = soluong * gia;
						HoaDonDTO hd = new HoaDonDTO();
						hd.setmaHD(textField_hd.getText());
						hd.setmaMH(textField_mh.getText());
						hd.setmaNV(textField_nv.getText());
						hd.setmaKH(textField_kh.getText());
						hd.setNgay(textField_n.getText());
						hd.setSl(soluong);
						hd.setGia(tong);
						try {
							JOptionPane.showMessageDialog(null, bus.Them(hd));
						}catch(Exception e1) {
							
						}
					}
				deleteAllDataTable();
				loadList();
				}

			
			
			});
		btnNewButton.setForeground(new Color(165, 42, 42));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(43, 119, 102, 39);
		panel_3.add(btnNewButton);
		
		JButton btnXa = new JButton("X\u00D3A");
		btnXa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = table.getSelectedRow();
				String id = dtm.getValueAt(i, 0).toString();
				if(i>=0) {
					JOptionPane.showMessageDialog(null, bus.Xoa(id));
				}
				deleteAllDataTable();
				loadList();
			}
		});
		btnXa.setForeground(new Color(165, 42, 42));
		btnXa.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnXa.setBounds(43, 61, 102, 39);
		panel_3.add(btnXa);
		
		JButton btnSa = new JButton("S\u1EECA");
		btnSa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = table.getSelectedRow();
				String id = dtm.getValueAt(i, 0).toString();
				 HoaDonDTO hoadon = new HoaDonDTO();
				if(i>=0) {
					int soluong = Integer.parseInt(textField_sl.getText());
					long gia = mh.gia(textField_mh.getText());
					long tong = soluong * gia;
				  hoadon.setmaHD(textField_hd.getText());
				  hoadon.setmaMH(textField_mh.getText());
				  hoadon.setmaNV(textField_nv.getText());
				  hoadon.setmaKH(textField_kh.getText());
				  hoadon.setNgay(textField_n.getText());
				  hoadon.setSl(soluong);
				  hoadon.setGia(tong);
				  try {
					  JOptionPane.showMessageDialog(null, bus.Sua(id, hoadon));
					  
				  }catch(Exception e1) {
					  
				  }
				}
				deleteAllDataTable();
				loadList();
			}
		});
		btnSa.setForeground(new Color(165, 42, 42));
		btnSa.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSa.setBounds(43, 11, 102, 39);
		panel_3.add(btnSa);
		
		JButton btnThot = new JButton("THOÁT");
		btnThot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnThot.setForeground(new Color(165, 42, 42));
		btnThot.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnThot.setBounds(43, 182, 102, 39);
		panel_3.add(btnThot);
	}
}