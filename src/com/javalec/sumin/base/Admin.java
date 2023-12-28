package com.javalec.sumin.base;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;

public class Admin {

	private JFrame frmAdmin;
	private JTabbedPane tabbedPane;
	private JPanel panel;
	private JLabel lblNewLabel;
	private JTextField textField;
	private JComboBox cbYear;
	private JComboBox cbMonth;
	private JComboBox cbDay;
	private JScrollPane scrollPane;
	private JTable table;
	private JTextField textField_1;
	private JButton btnNewButton;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_1_1;
	private JTextField textField_2;
	private JPanel panel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_2_1;
	private JLabel lblNewLabel_2_2;
	
	// ----- 날짜 시작 -----------------------------------------
	// 날짜 배열 선언
	ArrayList<String> arrYear;
	ArrayList<String> arrMonth;
	ArrayList<String> arrDay;
	
	// 현재 날짜, 시간 등의 정보 받아오기.
	Calendar calendar = Calendar.getInstance();
	
	// 현재 날짜
	int toYear = calendar.get(Calendar.YEAR);
	int toMonth = calendar.get(Calendar.MONTH)+1;
	int toDay = calendar.get(Calendar.DAY_OF_MONTH);
	// ----- 날짜 끝 -----------------------------------------
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin window = new Admin();
					window.frmAdmin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Admin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAdmin = new JFrame();
		frmAdmin.setTitle("Admin");
		frmAdmin.setBounds(100, 100, 574, 711);
		frmAdmin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAdmin.getContentPane().setLayout(null);
		frmAdmin.getContentPane().add(getTabbedPane());
	}
	private JTabbedPane getTabbedPane() {
		if (tabbedPane == null) {
			tabbedPane = new JTabbedPane(JTabbedPane.TOP);
			tabbedPane.setBounds(0, 0, 574, 690);
			tabbedPane.addTab("Sales", null, getPanel(), null);
			tabbedPane.addTab("Report", null, getPanel_1_1(), null);
		}
		return tabbedPane;
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setLayout(null);
			panel.add(getLblNewLabel());
			panel.add(getTextField());
			panel.add(getCbYear());
			panel.add(getCbMonth());
			panel.add(getCbDay());
			panel.add(getScrollPane());
			panel.add(getTextField_1());
			panel.add(getBtnNewButton());
			panel.add(getLblNewLabel_1());
			panel.add(getLblNewLabel_1_1());
			panel.add(getTextField_2_1());
		}
		return panel;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("총 매출:");
			lblNewLabel.setBounds(320, 34, 61, 16);
		}
		return lblNewLabel;
	}
	private JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.setBounds(393, 29, 130, 26);
			textField.setColumns(10);
		}
		return textField;
	}
	private JComboBox getCbYear() {
		if (cbYear == null) {
			// 년도
			arrYear = new ArrayList<String>();
			
			for (int i = toYear +10; i>=toYear-10; i--) {
				arrYear.add(String.valueOf(i));
			}
			
			cbYear = new JComboBox<String>(arrYear.toArray(new String[arrYear.size()]));
			cbYear.setBounds(41, 28, 77, 27);
			cbYear.setSelectedItem(String.valueOf(toYear));
		}
		return cbYear;
	}
	private JComboBox getCbMonth() {
		if (cbMonth == null) {
			// 월
			arrMonth = new ArrayList<String>();
			
			for (int i=1; i <=12; i++) {
				arrMonth.add(addZeroString(i));
			}
			cbMonth = new JComboBox<String>(arrMonth.toArray(new String[arrMonth.size()]));
			cbMonth.setBounds(119, 28, 77, 27);
			String mcom = toMonth >= 10?String.valueOf(toMonth):"0"+toMonth;
			cbMonth.setSelectedItem(mcom);
		}
		return cbMonth;
	}
	private JComboBox getCbDay() {
		if (cbDay == null) {
			// 일    
			arrDay = new ArrayList<String>();
			for(int i = 1; i <= 31; i++){
				arrDay.add(addZeroString(i));
			}
			cbDay = new JComboBox<String>(arrDay.toArray(new String[arrDay.size()]));
			cbDay.setBounds(199, 28, 77, 27);
			String dcom = toDay >= 10?String.valueOf(toDay):"0"+toDay;
			cbDay.setSelectedItem(dcom);
		}
		return cbDay;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(17, 62, 512, 442);
			scrollPane.setViewportView(getTable());
		}
		return scrollPane;
	}
	private JTable getTable() {
		if (table == null) {
			table = new JTable();
		}
		return table;
	}
	private JTextField getTextField_1() {
		if (textField_1 == null) {
			textField_1 = new JTextField();
			textField_1.setBounds(125, 516, 130, 26);
			textField_1.setColumns(10);
		}
		return textField_1;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("뒤로가기");
			btnNewButton.setBounds(199, 577, 117, 29);
		}
		return btnNewButton;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("베스트셀러:");
			lblNewLabel_1.setBounds(48, 521, 61, 16);
		}
		return lblNewLabel_1;
	}
	private JLabel getLblNewLabel_1_1() {
		if (lblNewLabel_1_1 == null) {
			lblNewLabel_1_1 = new JLabel("베스트고객:");
			lblNewLabel_1_1.setBounds(285, 521, 61, 16);
		}
		return lblNewLabel_1_1;
	}
	private JTextField getTextField_2_1() {
		if (textField_2 == null) {
			textField_2 = new JTextField();
			textField_2.setColumns(10);
			textField_2.setBounds(362, 516, 130, 26);
		}
		return textField_2;
	}
	private JPanel getPanel_1_1() {
		if (panel_1 == null) {
			panel_1 = new JPanel();
			panel_1.setLayout(null);
			panel_1.add(getLblNewLabel_2());
			panel_1.add(getLblNewLabel_2_1());
			panel_1.add(getLblNewLabel_2_2());
		}
		return panel_1;
	}
	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("재고수량");
			lblNewLabel_2.setBounds(6, 6, 61, 16);
		}
		return lblNewLabel_2;
	}
	private JLabel getLblNewLabel_2_1() {
		if (lblNewLabel_2_1 == null) {
			lblNewLabel_2_1 = new JLabel("입고수량");
			lblNewLabel_2_1.setBounds(6, 218, 61, 16);
		}
		return lblNewLabel_2_1;
	}
	private JLabel getLblNewLabel_2_2() {
		if (lblNewLabel_2_2 == null) {
			lblNewLabel_2_2 = new JLabel("출고수량");
			lblNewLabel_2_2.setBounds(6, 417, 61, 16);
		}
		return lblNewLabel_2_2;
	}
	
	
	// ---- Method -----
	// 한자리 숫자 앞에 + 0 예) 7일 -> 07일  
	private String addZeroString(int k){
		String value=Integer.toString(k);
		if(value.length()==1) {
			value="0"+value;
		}
		return value;
	}
}
