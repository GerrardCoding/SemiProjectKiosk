package com.javalec.sumin.base;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

import com.javalec.daegeun.Account;
import com.javalec.sumin.function.AdminDao;
import com.javalec.sumin.function.AdminDto;

public class Admin {

	private JFrame frmAdmin;
	private JTabbedPane tabbedPane;
	private JPanel tabPurchase;
	private JComboBox cbYear;
	private JComboBox cbMonth;
	private JComboBox cbDay;
	private JScrollPane scrollPane;
	private JTable innerTable;
	private JButton btnNewButton;
	private JLabel lblNewLabel_1_1;
	private JTextField tfTotal;
	private final DefaultTableModel outerTable = new DefaultTableModel();
	private final DefaultTableModel outerTableCust = new DefaultTableModel();
	DecimalFormat df = new DecimalFormat("###,###,###,###");
	
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
	private JButton btnPurchaseSearch;
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
		frmAdmin.setBounds(500, 100, 574, 711);
		frmAdmin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAdmin.getContentPane().setLayout(null);
		frmAdmin.getContentPane().add(getTabbedPane());
	}
	private JTabbedPane getTabbedPane() {
		if (tabbedPane == null) {
			tabbedPane = new JTabbedPane(JTabbedPane.TOP);
			tabbedPane.addChangeListener(new ChangeListener() {
				public void stateChanged(ChangeEvent e) {
					int selectedIndex = tabbedPane.getSelectedIndex();
					switch(selectedIndex) {
					case 0 :
						tableInit();
						searchAction(); 
						break;
					case 1 : break;
//					case 2 : 
//						tableInitCust(); 
//						searchCustAction(); 
//						break;	// 회원관리 tab
					default : break;
						
					}
				}
			});
			tabbedPane.setBounds(0, 0, 574, 690);
			tabbedPane.addTab("매출관리", null, getTabPurchase(), null);
		}
		return tabbedPane;
	}
	private JPanel getTabPurchase() {
		if (tabPurchase == null) {
			tabPurchase = new JPanel();
			tabPurchase.setLayout(null);
			tabPurchase.add(getCbYear());
			tabPurchase.add(getCbMonth());
			tabPurchase.add(getCbDay());
			tabPurchase.add(getScrollPane());
			tabPurchase.add(getBtnNewButton());
			tabPurchase.add(getLblNewLabel_1_1());
			tabPurchase.add(getTextField_2_1());
			tabPurchase.add(getBtnPurchaseSearch());
		}
		return tabPurchase;
	}
	private JComboBox getCbYear() {
		if (cbYear == null) {
			// 년도
			arrYear = new ArrayList<String>();
			
			for (int i = toYear +10; i>=toYear-10; i--) {
				arrYear.add(String.valueOf(i));
			}
			
			cbYear = new JComboBox<String>(arrYear.toArray(new String[arrYear.size()]));
//			cbYear.addActionListener(new ActionListener() {
//				public void actionPerformed(ActionEvent e) {
//					tableInit();
//					searchAction();
//				}
//			});

			cbYear.setBounds(17, 23, 103, 27);
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
//			cbMonth.addActionListener(new ActionListener() {
//				public void actionPerformed(ActionEvent e) {
//					tableInit();
//					searchAction();
//				}
//			});
			cbMonth.setBounds(123, 23, 77, 27);
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
//			cbDay.addActionListener(new ActionListener() {
//				public void actionPerformed(ActionEvent e) {
//					tableInit();
//					searchAction();
//				}
//			});
			cbDay.setBounds(212, 23, 77, 27);
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
			innerTable.setEnabled(false);
			innerTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			innerTable.setModel(outerTable);
		}
		return innerTable;
	}
	private JButton getBtnPurchaseSearch() {
		if (btnPurchaseSearch == null) {
			btnPurchaseSearch = new JButton("검색");
			btnPurchaseSearch.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					tableInit();
					searchAction();
				}
			});
			btnPurchaseSearch.setBounds(313, 25, 97, 23);
		}
		return btnPurchaseSearch;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("뒤로가기");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					toAdmin();
				}
			});
			btnNewButton.setBounds(199, 577, 117, 29);
		}
		return btnNewButton;
	}
	private JLabel getLblNewLabel_1_1() {
		if (lblNewLabel_1_1 == null) {
			lblNewLabel_1_1 = new JLabel("총매출 : ");
			lblNewLabel_1_1.setBounds(285, 521, 61, 16);
		}
		return lblNewLabel_1_1;
	}
	private JTextField getTextField_2_1() {
		if (tfTotal == null) {
			tfTotal = new JTextField();
			tfTotal.setHorizontalAlignment(SwingConstants.TRAILING);
			tfTotal.setEditable(false);
			tfTotal.setColumns(10);
			tfTotal.setBounds(362, 516, 130, 26);
		}
		return tfTotal;
	}
	
	
	// -----  [[ 매출관리 ]] - Method -----
	
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
		outerTable.addColumn("구매일");
		outerTable.setColumnCount(6);
		// 주문번호
		int colNo = 0;
		TableColumn col = innerTable.getColumnModel().getColumn(colNo);
		int width = 50;
		col.setPreferredWidth(width);
		
		// 고객ID
		colNo = 1;
		col = innerTable.getColumnModel().getColumn(colNo);
		width = 80;
		col.setPreferredWidth(width);

		
		// 모델번호
		colNo = 2;
		col = innerTable.getColumnModel().getColumn(colNo);
		width = 80;
		col.setPreferredWidth(width);
		
		
		// 구매수량
		colNo = 3;
		col = innerTable.getColumnModel().getColumn(colNo);
		width = 50;
		col.setPreferredWidth(width);
		
		// 가격
		colNo = 4;
		col = innerTable.getColumnModel().getColumn(colNo);
		width = 80;
		col.setPreferredWidth(width);
		
		
		// 구매일
		colNo = 5;
		col = innerTable.getColumnModel().getColumn(colNo);
		width = 150;
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
		
		int totPrice = 0;		
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
			String tmpPurprice = df.format(purprice);
			totPrice += purprice;
			String[] qTxt = {tmpPurnum, custid, stomodelnum, tmpPurqty, tmpPurprice, purdate};
			outerTable.addRow(qTxt);
		}
		
		// Table Column별 정렬하기.
		// Table Column(Cell) 가운데 정렬
		DefaultTableCellRenderer center = new DefaultTableCellRenderer();
		center.setHorizontalAlignment(SwingConstants.CENTER);
		
		TableColumnModel tcm = innerTable.getColumnModel();
		
		// 특정 Column(Cell) 가운데 정렬
		tcm.getColumn(0).setCellRenderer(center);
		tcm.getColumn(1).setCellRenderer(center);
		tcm.getColumn(2).setCellRenderer(center);
		tcm.getColumn(3).setCellRenderer(center);
		
		// Table Column(Cell) 우측 정렬
		DefaultTableCellRenderer right = new DefaultTableCellRenderer();
		right.setHorizontalAlignment(SwingConstants.RIGHT);
		
		// 특정 Column(Cell) 우측 정렬
		tcm.getColumn(4).setCellRenderer(right);
		tcm.getColumn(5).setCellRenderer(center);		
		
		String strPrice = df.format(totPrice);
		tfTotal.setText(strPrice);
	}	// End of searchAction()
	
	
//	// ----  [[ 회원관리 ]] - Method -----
//	private void tableInitCust() {
//		// Table Column 명 정하기.
//		outerTableCust.addColumn("이름");
//		outerTableCust.addColumn("회원ID");
//		outerTableCust.addColumn("회원PW");
//		outerTableCust.addColumn("전화번호");
//		outerTableCust.addColumn("주소");
//		outerTableCust.addColumn("가입일");
//		outerTableCust.addColumn("탈퇴일");
//		outerTableCust.setColumnCount(7);
//		
//		// 이름
//		int colNo = 0;
//		TableColumn col = innerTableCust.getColumnModel().getColumn(colNo);
//		int width = 80;
//		col.setPreferredWidth(width);
//		
//		// 회원ID
//		colNo = 1;
//		col = innerTableCust.getColumnModel().getColumn(colNo);
//		width = 80;
//		col.setPreferredWidth(width);
//
//		
//		// 회원PW
//		colNo = 2;
//		col = innerTableCust.getColumnModel().getColumn(colNo);
//		width = 80;
//		col.setPreferredWidth(width);
//		
//		
//		// 전화번호
//		colNo = 3;
//		col = innerTableCust.getColumnModel().getColumn(colNo);
//		width = 100;
//		col.setPreferredWidth(width);
//		
//		// 주소
//		colNo = 4;
//		col = innerTableCust.getColumnModel().getColumn(colNo);
//		width = 150;
//		col.setPreferredWidth(width);
//		
//		
//		// 가입일
//		colNo = 5;
//		col = innerTableCust.getColumnModel().getColumn(colNo);
//		width = 150;
//		col.setPreferredWidth(width);
//		
//		// 탈퇴일
//		colNo = 6;
//		col = innerTableCust.getColumnModel().getColumn(colNo);
//		width = 150;
//		col.setPreferredWidth(width);
//		
//		
//		// 테이블 내용 지우기.
//		int i = outerTableCust.getRowCount();
//		for(int j=0; j<i; j++) {
//			outerTableCust.removeRow(0);
//		}
//		
//		innerTableCust.setAutoResizeMode(innerTableCust.AUTO_RESIZE_OFF);
//	}
//	
//	private void searchCustAction() {
//		int selectIndex = cbSearchCust.getSelectedIndex();
//		CustDao dao= new CustDao();
//		ArrayList<CustDto> dtoList = dao.selectCustList(selectIndex, tfSearchCust.getText().trim());
//		
//		int listCount = dtoList.size();
//		
//		for(int i=0; i<listCount; i++) {
//			String[] qTxt = {dtoList.get(i).getCustname(), dtoList.get(i).getCustid(), dtoList.get(i).getCustpw(), dtoList.get(i).getPhone(), dtoList.get(i).getAddress(), dtoList.get(i).getActdate(), dtoList.get(i).getDactdate()};
//			outerTableCust.addRow(qTxt);
//		}
//		
//		// Table Column별 정렬하기.
//		// Table Column(Cell) 가운데 정렬
//		DefaultTableCellRenderer center = new DefaultTableCellRenderer();
//		center.setHorizontalAlignment(SwingConstants.CENTER);
//		
//		TableColumnModel tcm = innerTableCust.getColumnModel();
//		
//		// 특정 Column(Cell) 가운데 정렬
//		tcm.getColumn(0).setCellRenderer(center);
//		tcm.getColumn(1).setCellRenderer(center);
//		tcm.getColumn(2).setCellRenderer(center);
//		tcm.getColumn(3).setCellRenderer(center);
//		
//		// Table Column(Cell) 우측 정렬
////		DefaultTableCellRenderer right = new DefaultTableCellRenderer();
////		right.setHorizontalAlignment(SwingConstants.RIGHT);
//		
//		// 특정 Column(Cell) 우측 정렬
//		tcm.getColumn(4).setCellRenderer(center);
//		tcm.getColumn(5).setCellRenderer(center);		
//		tcm.getColumn(6).setCellRenderer(center);		
//	}	// End of searchAction()
	
	private void toAdmin() {
		frmAdmin.setVisible(false);
		Account account = new Account();
		account.main(null);
	}
}
