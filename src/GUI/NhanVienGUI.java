package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import DTO.NhanVienDTO;
import BUS.NhanVienBUS;
import java.util.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
public class NhanVienGUI extends JFrame {

	NhanVienBUS bus = new NhanVienBUS();
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	JComboBox box = new JComboBox();
	//private JTable table;

	DefaultTableModel dtm = new DefaultTableModel();
	JTable table = new JTable(dtm);
	public void loadList() {
		Vector<NhanVienDTO> arr = new Vector<NhanVienDTO>();
		arr= bus.nhanvien();
		for(int i=0; i<arr.size(); i++) {
		   NhanVienDTO nv = arr.get(i);
			String ma = nv.getmaNV();
			String ten= nv.gettenNV();
			String chuc = nv.getChucVu();
			String dc = nv.getDiaChi();
			int dth = nv.getsoDTH();
			double luong = nv.getLuong();
			Object[] row = {ma, ten, chuc, dc, dth, luong};
			dtm.addRow(row);
		}
	}
	public void deleteAllDataTable() {
		dtm = (DefaultTableModel) table.getModel();
		dtm.getDataVector().removeAllElements();
	}
	public void Tim(String ten) {
		Vector<NhanVienDTO> arr = new Vector<>();
		arr = bus.timkiem(ten);
		for(int i=0; i<arr.size(); i++) {
			NhanVienDTO nv = arr.get(i);
			String ma = nv.getmaNV();
			String name= nv.gettenNV();
			String chuc = nv.getChucVu();
			String dc = nv.getDiaChi();
			int dth = nv.getsoDTH();
			double luong = nv.getLuong();
			Object[] row = {ma, name, chuc, dc, dth, luong};
			dtm.addRow(row);
		}
		
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NhanVienGUI frame = new NhanVienGUI();
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
	public NhanVienGUI() {
		dtm.addColumn("Mã");
		dtm.addColumn("Tên");
		dtm.addColumn("Chức vụ");
		dtm.addColumn("Địa chỉ");
		dtm.addColumn("Số đth");
		dtm.addColumn("Lương");
		setTitle("QU\u1EA2N L\u00DD NH\u00C2N VI\u00CAN");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 807, 639);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 248, 220));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 228, 196));
		panel.setBounds(10, 11, 771, 61);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("JV STORE");
		lblNewLabel.setForeground(new Color(139, 0, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblNewLabel.setBounds(308, 11, 201, 39);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 228, 196));
		panel_1.setBounds(10, 83, 272, 411);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("M\u00E3 nh\u00E2n vi\u00EAn:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2.setBounds(20, 11, 99, 21);
		panel_1.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(20, 31, 220, 20);
		panel_1.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2_2 = new JLabel("Ch\u1EE9c v\u1EE5:");
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2_2.setBounds(20, 116, 54, 21);
		panel_1.add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_2_3 = new JLabel("Tên nhân viên ");
		lblNewLabel_2_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2_3.setBounds(20, 62, 99, 21);
		panel_1.add(lblNewLabel_2_3);
		
		JLabel lblNewLabel_2_4 = new JLabel("\u0110\u1ECBa ch\u1EC9:");
		lblNewLabel_2_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2_4.setBounds(20, 148, 61, 21);
		panel_1.add(lblNewLabel_2_4);
		
		JLabel lblNewLabel_2_5 = new JLabel("L\u01B0\u01A1ng:\r\n");
		lblNewLabel_2_5.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2_5.setBounds(20, 261, 54, 21);
		panel_1.add(lblNewLabel_2_5);
		
		JLabel lblNewLabel_2_8 = new JLabel("S\u1ED1 \u0111i\u1EC7n tho\u1EA1i:");
		lblNewLabel_2_8.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2_8.setBounds(20, 202, 99, 21);
		panel_1.add(lblNewLabel_2_8);
		

		box.setModel(new DefaultComboBoxModel(new String[] {"Nh\u00E2n vi\u00EAn b\u00E1n h\u00E0ng", "Nh\u00E2n vi\u00EAn thu ng\u00E2n", "Nh\u00E2n vi\u00EAn ki\u1EC3m kho", "K\u1EBF to\u00E1n"}));
		box.setBounds(84, 116, 140, 22);
		panel_1.add(box);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(20, 85, 220, 20);
		panel_1.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(20, 171, 220, 20);
		panel_1.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(20, 230, 220, 20);
		panel_1.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(20, 280, 220, 20);
		panel_1.add(textField_4);
		
		JButton btnNewButton_4_2 = new JButton("TH\u00CAM");
		btnNewButton_4_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField.getText().trim().equals("")|| textField_1.getText().trim().equals("")|| textField_2.getText().trim().equals("")||
						textField_3.getText().trim().equals("")||textField_4.getText().trim().equals("")) {
					JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin");
				}
				else {
					NhanVienDTO nv = new NhanVienDTO();
					nv.setmaNV(textField.getText());
					nv.settenNV(textField_1.getText());
					nv.setChucVu(box.getSelectedItem().toString());
					nv.setDiaChi(textField_2.getText());
					nv.setsoDTH(Integer.parseInt(textField_3.getText()));
					nv.setLuong(Double.parseDouble(textField_4.getText()));
					try {
						JOptionPane.showMessageDialog(null, bus.them(nv));
					}catch (HeadlessException e1) {
						e1.printStackTrace();
					}
					//System.out.print(nv.getmaNV());
		
				}
				deleteAllDataTable();
				loadList();
				//System.out.print(rootPaneCheckingEnabled);
			}
		});
		btnNewButton_4_2.setBounds(20, 318, 77, 37);
		panel_1.add(btnNewButton_4_2);
		btnNewButton_4_2.setForeground(new Color(178, 34, 34));
		btnNewButton_4_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JButton btnNewButton_4_2_1 = new JButton("ĐẶT LẠI");
		btnNewButton_4_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
				textField_3.setText("");
				box.setSelectedIndex(0);
			}
		});
		btnNewButton_4_2_1.setForeground(new Color(178, 34, 34));
		btnNewButton_4_2_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_4_2_1.setBounds(141, 318, 99, 37);
		panel_1.add(btnNewButton_4_2_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 228, 196));
		panel_2.setBounds(10, 507, 272, 86);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JButton btnNewButton_4 = new JButton("S\u1EECA");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = table.getSelectedRow();
				String id = dtm.getValueAt(i, 0).toString();
				NhanVienDTO nv = new NhanVienDTO();
				if(i>=0) {
					
					nv.setmaNV(textField.getText());
					nv.settenNV(textField_1.getText());
					nv.setChucVu(box.getSelectedItem().toString());
					nv.setDiaChi(textField_2.getText());
					nv.setsoDTH(Integer.parseInt(textField_3.getText()));
					nv.setLuong(Double.parseDouble(textField_4.getText()));
				}
				try {
					JOptionPane.showMessageDialog(null, bus.sua(id, nv));
					
				}catch(Exception e1) {
					
				}
				deleteAllDataTable();
				loadList();
			}
		});
		btnNewButton_4.setForeground(new Color(178, 34, 34));
		btnNewButton_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_4.setBounds(28, 27, 77, 37);
		panel_2.add(btnNewButton_4);
		
		JButton btnNewButton_4_1 = new JButton("X\u00D3A");
		btnNewButton_4_1.addActionListener(new ActionListener() {
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
		btnNewButton_4_1.setForeground(new Color(178, 34, 34));
		btnNewButton_4_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_4_1.setBounds(141, 27, 77, 37);
		panel_2.add(btnNewButton_4_1);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 228, 196));
		panel_3.setBounds(292, 83, 489, 510);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		JButton btnNewButton_4_1_1 = new JButton("T\u00CCM KI\u1EBEM");
		btnNewButton_4_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dtm.setRowCount(0);
				String id = textField_5.getText();
				Tim(id);
			}
		});
		btnNewButton_4_1_1.setForeground(new Color(178, 34, 34));
		btnNewButton_4_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_4_1_1.setBounds(377, 11, 102, 37);
		panel_3.add(btnNewButton_4_1_1);
		
		textField_5 = new JTextField();
		textField_5.setBounds(124, 11, 243, 37);
		panel_3.add(textField_5);
		textField_5.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 57, 469, 393);
		panel_3.add(scrollPane);
		
		/*table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"M\u00E3 ", "T\u00EAn ", "Ch\u1EE9c v\u1EE5 ", "\u0110\u1ECBa ch\u1EC9 ", "S\u1ED1 \u0111th ", "L\u01B0\u01A1ng"
			}
		));*/
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int i= table.getSelectedRow();
				dtm = (DefaultTableModel) table.getModel();
				textField.setText(dtm.getValueAt(i, 0).toString());
				textField_1.setText(dtm.getValueAt(i, 1).toString());
				textField_2.setText(dtm.getValueAt(i, 3).toString());
				textField_3.setText(dtm.getValueAt(i, 4).toString());
				textField_4.setText(dtm.getValueAt(i, 5).toString());
				box.setSelectedItem(dtm.getValueAt(i, 2).toString());
			}
		});
		scrollPane.setViewportView(table);
		
		JButton btnNewButton_4_2_2 = new JButton("THOÁT");
		btnNewButton_4_2_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_4_2_2.setForeground(new Color(178, 34, 34));
		btnNewButton_4_2_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_4_2_2.setBounds(402, 462, 77, 37);
		panel_3.add(btnNewButton_4_2_2);
		loadList();
		
	}
	
}