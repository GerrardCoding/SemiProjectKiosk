package com.javalec.sumin.base;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import com.javalec.sumin.function.AdminDao;
import com.javalec.sumin.function.AdminDto;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.ListSelectionModel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;

public class Admin {

	private JFrame frmAdmin;
	private JTabbedPane tabbedPane;
	private JPanel tabSales;
	private JLabel lblNewLabel;
	private JTextField tfTotalPrice;
	private JComboBox cbYear;
	private JComboBox cbMonth;
	private JComboBox cbDay;
	private JScrollPane scrollPane;
	private JTable innerTable;
	private JTextField tfBestSeller;
	private JButton btnNewButton;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_1_1;
	private JTextField tfBestCustomer;
	private JPanel tabReport;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_2_1;
	private JLabel lblNewLabel_2_2;
	private final DefaultTableModel outerTable = new DefaultTableModel();
	
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
	
	String srhDate = toYear + "-" + toMonth + "-" + toDay;
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
		frmAdmin.addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				tableInit();
				searchAction();
			}
		});
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
			tabbedPane.addTab("Sales", null, getTabSales(), null);
			tabbedPane.addTab("Report", null, getPanel_1_1(), null);
		}
		return tabbedPane;
	}
	private JPanel getTabSales() {
		if (tabSales == null) {
			tabSales = new JPanel();
			tabSales.setLayout(null);
			tabSales.add(getLblNewLabel());
			tabSales.add(getTfTotalPrice());
			tabSales.add(getCbYear());
			tabSales.add(getCbMonth());
			tabSales.add(getCbDay());
			tabSales.add(getScrollPane());
			tabSales.add(getTfBestSeller());
			tabSales.add(getBtnNewButton());
			tabSales.add(getLblNewLabel_1());
			tabSales.add(getLblNewLabel_1_1());
			tabSales.add(getTextField_2_1());
		}
		return tabSales;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("총 매출:");
			lblNewLabel.setBounds(326, 28, 61, 16);
		}
		return lblNewLabel;
	}
	private JTextField getTfTotalPrice() {
		if (tfTotalPrice == null) {
			tfTotalPrice = new JTextField();
			tfTotalPrice.setBounds(399, 23, 130, 26);
			tfTotalPrice.setColumns(10);
		}
		return tfTotalPrice;
	}
	private JComboBox getCbYear() {
		if (cbYear == null) {
			// 년도
			arrYear = new ArrayList<String>();
			
			for (int i = toYear +10; i>=toYear-10; i--) {
				arrYear.add(String.valueOf(i));
			}
			
			cbYear = new JComboBox<String>(arrYear.toArray(new String[arrYear.size()]));
			cbYear.addPropertyChangeListener(new PropertyChangeListener() {
				public void propertyChange(PropertyChangeEvent evt) {
				}
			});
			cbYear.setBounds(19, 23, 103, 27);
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
			cbMonth.addPropertyChangeListener(new PropertyChangeListener() {
				public void propertyChange(PropertyChangeEvent evt) {
				}
			});
			cbMonth.setBounds(125, 23, 77, 27);
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
			cbDay.addPropertyChangeListener(new PropertyChangeListener() {
				public void propertyChange(PropertyChangeEvent evt) {
				}
			});
			cbDay.setBounds(214, 23, 77, 27);
			String dcom = toDay >= 10?String.valueOf(toDay):"0"+toDay;
			cbDay.setSelectedItem(dcom);
		}
		return cbDay;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(17, 62, 512, 442);
			scrollPane.setViewportView(getInnerTable());
		}
		return scrollPane;
	}
	private JTable getInnerTable() {
		if (innerTable == null) {
			innerTable = new JTable();
			innerTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			innerTable.setModel(outerTable);
		}
		return innerTable;
	}
	private JTextField getTfBestSeller() {
		if (tfBestSeller == null) {
			tfBestSeller = new JTextField();
			tfBestSeller.setBounds(125, 516, 130, 26);
			tfBestSeller.setColumns(10);
		}
		return tfBestSeller;
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
		if (tfBestCustomer == null) {
			tfBestCustomer = new JTextField();
			tfBestCustomer.setColumns(10);
			tfBestCustomer.setBounds(362, 516, 130, 26);
		}
		return tfBestCustomer;
	}
	private JPanel getPanel_1_1() {
		if (tabReport == null) {
			tabReport = new JPanel();
			tabReport.setLayout(null);
			tabReport.add(getLblNewLabel_2());
			tabReport.add(getLblNewLabel_2_1());
			tabReport.add(getLblNewLabel_2_2());
		}
		return tabReport;
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
	
	private void tableInit() {
		// Table Column 명 정하기.
		outerTable.addColumn("주문번호");
		outerTable.addColumn("고객ID");
		outerTable.addColumn("모델번호");
		outerTable.addColumn("구매수량");
		outerTable.addColumn("가격");
		outerTable.addColumn("구매");
		outerTable.setColumnCount(6);
		
		// 주문번호
		int colNo = 0;
		TableColumn col = innerTable.getColumnModel().getColumn(colNo);
		int width = 100;
		col.setPreferredWidth(width);
		
		// 고객ID
		colNo = 1;
		col = innerTable.getColumnModel().getColumn(colNo);
		width = 100;
		col.setPreferredWidth(width);

		
		// 모델번호
		colNo = 2;
		col = innerTable.getColumnModel().getColumn(colNo);
		width = 200;
		col.setPreferredWidth(width);
		
		
		// 구매수량
		colNo = 3;
		col = innerTable.getColumnModel().getColumn(colNo);
		width = 100;
		col.setPreferredWidth(width);
		
		// 가격
		colNo = 4;
		col = innerTable.getColumnModel().getColumn(colNo);
		width = 100;
		col.setPreferredWidth(width);
		
		
		// 구매
		colNo = 5;
		col = innerTable.getColumnModel().getColumn(colNo);
		width = 100;
		col.setPreferredWidth(width);
		
		
		// 테이블 내용 지우기.
		int i = outerTable.getRowCount();
		for(int j=0; j<i; j++) {
			outerTable.removeRow(0);
		}
		
		innerTable.setAutoResizeMode(innerTable.AUTO_RESIZE_OFF);
	}
	
	private void searchAction() {
		String srhDate = cbYear.getSelectedItem() + "-" + cbMonth.getSelectedItem() + "-" + cbDay.getSelectedItem();
		AdminDao dao = new AdminDao(srhDate);
		ArrayList<AdminDto> dtoList = dao.selectTodayList();
		
		int listCount = dtoList.size();
		
		for(int i=0; i<listCount; i++) {
			int purnum = dtoList.get(i).getPurnum();
			String custid = dtoList.get(i).getCustid();
			String stomodelnum = dtoList.get(i).getStomodelnum();
			int purqty = dtoList.get(i).getPurqty();
			int purprice = dtoList.get(i).getPurprice(); 
			String purdate = dtoList.get(i).getPurdate();
			
			String tmpPurnum = Integer.toString(purnum);
			String tmpPurqty = Integer.toString(purqty);
			String tmpPurprice = Integer.toString(purprice);
			
			String[] qTxt = {tmpPurnum, custid, stomodelnum, tmpPurqty, tmpPurprice, purdate};
			outerTable.addRow(qTxt);
		}
	}	// End of searchAction()
}
