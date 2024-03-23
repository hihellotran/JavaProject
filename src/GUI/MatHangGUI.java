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
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

import DTO.MatHangDTO;
import BUS.MatHangBUS;
import java.util.Vector;
public class MatHangGUI extends JFrame {
	MatHangBUS bus = new MatHangBUS();
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	//private JTable table;
	
	DefaultTableModel dtm = new DefaultTableModel();
	JTable table = new JTable(dtm);
	JComboBox box1;
	public void loadList() {
		
		//table.setModel(dtm);
		Vector<MatHangDTO> arr = new Vector<MatHangDTO>();
		arr= bus.mathang();
		for(int i=0; i<arr.size(); i++) {
			MatHangDTO mathang = arr.get(i);
			String ma = mathang.getmaMH();
			String ten= mathang.gettenMH();
			String loai = mathang.getloai();
			double gia = mathang.getgia();
			int sl = mathang.getsoLuong();
			Object[] row = {ma, ten, loai, gia, sl};
			dtm.addRow(row);
	}
} 
	public void TimKiem(String id) {
		dtm.setRowCount(0);
		Vector<MatHangDTO> arr = new Vector<>();
		arr = bus.timkiem(id);
		for(int i=0; i<arr.size(); i++) {
			MatHangDTO m = arr.get(i);
			String ma = m.getmaMH();
			String ten = m.gettenMH();
			String loai = m.getloai();
			double gia = m.getgia();
			int sl = m.getsoLuong();
			Object[] row = {ma, ten, loai, gia, sl};
			dtm.addRow(row);
		}
	}
	public void TimKiem2(String name) {
		dtm.setRowCount(0);
		Vector<MatHangDTO> arr = new Vector<>();
		arr= bus.timkiem2(name);
		for(int i=0; i<arr.size(); i++) {
			MatHangDTO m = arr.get(i);
			String ma = m.getmaMH();
			String ten = m.gettenMH();
			String loai = m.getloai();
			double gia = m.getgia();
			int sl = m.getsoLuong();
			Object[] row = {ma, ten, loai, gia, sl};
			dtm.addRow(row);
		}
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MatHangGUI frame = new MatHangGUI();
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
	public MatHangGUI() {
		setTitle("QU\u1EA2N L\u00DD S\u1EA2N PH\u1EA8M");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 674, 517);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 248, 220));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 228, 196));
		panel.setBounds(10, 11, 638, 63);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("JV STORE");
		lblNewLabel.setForeground(new Color(128, 0, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblNewLabel.setBounds(190, 11, 241, 47);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 228, 196));
		panel_1.setBounds(10, 92, 201, 266);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("M\u00E3 s\u1EA3n ph\u1EA9m:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(10, 30, 98, 14);
		panel_1.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(10, 55, 162, 20);
		panel_1.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("T\u00EAn s\u1EA3n ph\u1EA9m:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2.setBounds(10, 86, 119, 14);
		panel_1.add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		textField_1.setBounds(10, 111, 162, 20);
		panel_1.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Lo\u1EA1i:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_3.setBounds(10, 146, 48, 14);
		panel_1.add(lblNewLabel_3);
		
	    box1 = new JComboBox();
		box1.setFont(new Font("Tahoma", Font.BOLD, 11));
		box1.setModel(new DefaultComboBoxModel(new String[] {"\u00C1o", "Qu\u1EA7n", "V\u00E1y", "Gi\u00E0y d\u00E9p", "T\u00FAi x\u00E1ch", "Ph\u1EE5 ki\u1EC7n"}));
		box1.setSelectedIndex(5);
		box1.setBounds(10, 166, 75, 22);
		panel_1.add(box1);
		
		JLabel lblNewLabel_4 = new JLabel("Gi\u00E1:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_4.setBounds(10, 198, 98, 14);
		panel_1.add(lblNewLabel_4);
		
		textField_2 = new JTextField();
		textField_2.setBounds(10, 223, 162, 20);
		panel_1.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("S\u1ED1 l\u01B0\u1EE3ng:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_5.setBounds(103, 142, 88, 22);
		panel_1.add(lblNewLabel_5);
		
		textField_3 = new JTextField();
		textField_3.setBounds(103, 167, 86, 20);
		panel_1.add(textField_3);
		textField_3.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 228, 196));
		panel_2.setBounds(10, 369, 201, 98);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JButton btnNewButton = new JButton("SỬA");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = table.getSelectedRow();
				String id = dtm.getValueAt(i, 0).toString();
				MatHangDTO mathang = new MatHangDTO();
				if(i>=0) {
					mathang.setmaMH(textField.getText());
					mathang.settenMH(textField_1.getText());
					mathang.setloai(box1.getSelectedItem().toString());
					mathang.setgia(Double.parseDouble(textField_2.getText()));
					mathang.setsoLuong(Integer.parseInt(textField_3.getText()));
					try {
						JOptionPane.showMessageDialog(null,bus.sua(id, mathang));
					}catch(Exception e1) {
						System.out.println(e1);
					}
				}
				deleteAllDataTable();
				loadList();
			}
		});
		btnNewButton.setForeground(new Color(178, 34, 34));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.setBounds(20, 11, 74, 23);
		panel_2.add(btnNewButton);
		
		JButton btnNewButton_2 = new JButton("TÌM");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//String id= textField.getText();
				String ten = textField_1.getText();
				//TimKiem(id);
				TimKiem2(ten);				
			}
		});
		btnNewButton_2.setForeground(new Color(178, 34, 34));
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_2.setBounds(20, 53, 74, 23);
		panel_2.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("XÓA");
		btnNewButton_3.setForeground(new Color(178, 34, 34));
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					int i = table.getSelectedRow();
					String id = dtm.getValueAt(i, 0).toString();
				//System.out.print(id);
					if(i>=0) {
						JOptionPane.showMessageDialog(null, bus.xoa(id));
					}
					deleteAllDataTable();
					loadList();
			}
			
		});
		btnNewButton_3.setBounds(101, 53, 77, 23);
		panel_2.add(btnNewButton_3);
		dtm.addColumn("Mã ");
		dtm.addColumn("Tên");
		dtm.addColumn("Loại");
		dtm.addColumn("Giá");
		dtm.addColumn("Số lượng");
		JButton btnThm = new JButton("THÊM");
		btnThm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField.getText().trim().equals("") || textField_1.getText().trim().equals("") 
						|| textField_2.getText().trim().equals("")|| textField_3.getText().trim().equals("")) {
				JOptionPane.showMessageDialog(null, "Vui lòng nhập đủ thông tin");
					
				}
				else {
					
					MatHangDTO mh = new MatHangDTO();
					mh.setmaMH(textField.getText());
					mh.settenMH(textField_1.getText());
					mh.setloai(box1.getSelectedItem().toString());
					mh.setgia(Double.parseDouble(textField_2.getText()));
					mh.setsoLuong(Integer.parseInt(textField_3.getText()));
					
					/*dtm.addRow(new Object[] {
							mh.getmaMH(), mh.gettenMH(), mh.getloai(), mh.getgia(), mh.getsoLuong()
					});*/
					try {
						JOptionPane.showMessageDialog(null, bus.them(mh));
					}catch (HeadlessException e1) {
						e1.printStackTrace();
					}
					deleteAllDataTable();
					loadList();
				}
				
			}
		});
		btnThm.setForeground(new Color(178, 34, 34));
		btnThm.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnThm.setBounds(104, 12, 74, 23);
		panel_2.add(btnThm);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 228, 196));
		panel_3.setBounds(229, 92, 419, 375);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_6 = new JLabel("QU\u1EA2N L\u00DD S\u1EA2N PH\u1EA8M");
		lblNewLabel_6.setForeground(new Color(153, 51, 0));
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_6.setBounds(98, 11, 220, 48);
		panel_3.add(lblNewLabel_6);
		
		JButton btnNewButton_4 = new JButton("THOÁT");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_4.setForeground(new Color(178, 34, 34));
		btnNewButton_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_4.setBounds(312, 335, 85, 29);
		panel_3.add(btnNewButton_4);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(21, 68, 376, 252);
		panel_3.add(scrollPane);
		
		/*table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"M\u00E3 ", "T\u00EAn", "Lo\u1EA1i", "Gi\u00E1", "S\u1ED1 l\u01B0\u1EE3ng"
			}
		));*/
		table.getColumnModel().getColumn(0).setMinWidth(14);
		scrollPane.setViewportView(table);
		//loadList();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int i = table.getSelectedRow();
				dtm = (DefaultTableModel) table.getModel();
				textField.setText(dtm.getValueAt(i, 0).toString()); 
				textField_1.setText(dtm.getValueAt(i, 1).toString());
				textField_2.setText(dtm.getValueAt(i, 3).toString());
				textField_3.setText(dtm.getValueAt(i, 4).toString());
				box1.setSelectedItem(dtm.getValueAt(i, 2).toString());
				
				
			}
		});
		JButton btnNewButton_1 = new JButton("HỦY");
		btnNewButton_1.setBounds(21, 336, 86, 26);
		panel_3.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
				textField_3.setText("");
				box1.setSelectedIndex(0);
			}
		});
		btnNewButton_1.setForeground(new Color(178, 34, 34));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		loadList();
		//deleteAllDataTable();

	}
	public void deleteAllDataTable() {
		dtm = (DefaultTableModel) table.getModel();
		dtm.getDataVector().removeAllElements();
	}
	
}