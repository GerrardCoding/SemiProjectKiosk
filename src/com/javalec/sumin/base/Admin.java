package com.javalec.sumin.base;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import com.javalec.sumin.function.AdminDao;
import com.javalec.sumin.function.AdminDto;
import com.javalec.sumin.function.CustDao;
import com.javalec.sumin.function.CustDto;

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
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Admin {

	private JFrame frmAdmin;
	private JTabbedPane tabbedPane;
	private JPanel tabPurchase;
	private JComboBox cbYear;
	private JComboBox cbMonth;
	private JComboBox cbDay;
	private JScrollPane scrollPane;
	private JTable innerTable;
	private JTextField tfBestSeller;
	private JButton btnNewButton;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_1_1;
	private JTextField tfTotal;
	private JPanel tabProduct;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_2_1;
	private JLabel lblNewLabel_2_2;
	private final DefaultTableModel outerTable = new DefaultTableModel();
	private final DefaultTableModel outerTableCust = new DefaultTableModel();
	
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
	private JPanel tabCustomer;
	private JComboBox<?> cbSearchCust;
	private JTextField tfSearchCust;
	private JButton btnSearchCust;
	private JScrollPane scrollPane_1;
	private JTable innerTableCust;
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
		frmAdmin.setBounds(100, 100, 574, 711);
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
					case 2 : 
						tableInitCust(); 
						searchCustAction(); 
						break;	// 회원관리 tab
					default : break;
						
					}
				}
			});
			tabbedPane.setBounds(0, 0, 574, 690);
			tabbedPane.addTab("매출관리", null, getTabPurchase(), null);
			tabbedPane.addTab("상품관리", null, getPanel_1_1(), null);
			tabbedPane.addTab("회원관리", null, getTabCustomer(), null);
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
			tabPurchase.add(getTfBestSeller());
			tabPurchase.add(getBtnNewButton());
			tabPurchase.add(getLblNewLabel_1());
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
//			cbMonth.addActionListener(new ActionListener() {
//				public void actionPerformed(ActionEvent e) {
//					tableInit();
//					searchAction();
//				}
//			});
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
//			cbDay.addActionListener(new ActionListener() {
//				public void actionPerformed(ActionEvent e) {
//					tableInit();
//					searchAction();
//				}
//			});
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
			innerTable.setEnabled(false);
			innerTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			innerTable.setModel(outerTable);
		}
		return innerTable;
	}
	private JTextField getTfBestSeller() {
		if (tfBestSeller == null) {
			tfBestSeller = new JTextField();
			tfBestSeller.setHorizontalAlignment(SwingConstants.TRAILING);
			tfBestSeller.setEnabled(false);
			tfBestSeller.setEditable(false);
			tfBestSeller.setBounds(125, 516, 130, 26);
			tfBestSeller.setColumns(10);
		}
		return tfBestSeller;
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
			btnPurchaseSearch.setBounds(315, 25, 97, 23);
		}
		return btnPurchaseSearch;
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
			lblNewLabel_1_1 = new JLabel("총매출 : ");
			lblNewLabel_1_1.setBounds(285, 521, 61, 16);
		}
		return lblNewLabel_1_1;
	}
	private JTextField getTextField_2_1() {
		if (tfTotal == null) {
			tfTotal = new JTextField();
			tfTotal.setHorizontalAlignment(SwingConstants.TRAILING);
			tfTotal.setEnabled(false);
			tfTotal.setEditable(false);
			tfTotal.setColumns(10);
			tfTotal.setBounds(362, 516, 130, 26);
		}
		return tfTotal;
	}
	private JPanel getPanel_1_1() {
		if (tabProduct == null) {
			tabProduct = new JPanel();
			tabProduct.setLayout(null);
			tabProduct.add(getLblNewLabel_2());
			tabProduct.add(getLblNewLabel_2_1());
			tabProduct.add(getLblNewLabel_2_2());
		}
		return tabProduct;
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
	private JPanel getTabCustomer() {
		if (tabCustomer == null) {
			tabCustomer = new JPanel();
			tabCustomer.setLayout(null);
			tabCustomer.add(getCbSearchCust());
			tabCustomer.add(getTextField_3());
			tabCustomer.add(getBtnSearchCust());
			tabCustomer.add(getScrollPane_1_1());
		}
		return tabCustomer;
	}
	private JComboBox<?> getCbSearchCust() {
		if (cbSearchCust == null) {
			cbSearchCust = new JComboBox();
			cbSearchCust.setModel(new DefaultComboBoxModel(new String[] {"이름", "전화번호", "회원아이디"}));
			cbSearchCust.setBounds(28, 25, 112, 23);
		}
		return cbSearchCust;
	}
	private JTextField getTextField_3() {
		if (tfSearchCust == null) {
			tfSearchCust = new JTextField();
			tfSearchCust.addKeyListener(new KeyAdapter() {
				@Override
				public void keyPressed(KeyEvent e) {
					if (e.getKeyCode() == KeyEvent.VK_ENTER) {
						tableInitCust(); 
						searchCustAction(); 
					}
				}
			});
			tfSearchCust.setBounds(152, 26, 200, 21);
			tfSearchCust.setColumns(10);
		}
		return tfSearchCust;
	}
	private JButton getBtnSearchCust() {
		if (btnSearchCust == null) {
			btnSearchCust = new JButton("검색");
			btnSearchCust.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					tableInitCust(); 
					searchCustAction(); 
				}
			});
			btnSearchCust.setBounds(384, 25, 97, 23);
		}
		return btnSearchCust;
	}
	private JScrollPane getScrollPane_1_1() {
		if (scrollPane_1 == null) {
			scrollPane_1 = new JScrollPane();
			scrollPane_1.setBounds(28, 85, 490, 425);
			scrollPane_1.setViewportView(getInnerTableCust());
		}
		return scrollPane_1;
	}
	private JTable getInnerTableCust() {
		if (innerTableCust == null) {
			innerTableCust = new JTable();
			innerTableCust.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			innerTableCust.setModel(outerTableCust);
		}
		return innerTableCust;
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
		outerTable.addColumn("구매");
		outerTable.setColumnCount(6);
		if(innerTable != null) {
			// 주문번호
			int colNo = 0;
			TableColumn col = innerTable.getColumnModel().getColumn(colNo);
			int width = 30;
			col.setPreferredWidth(width);
			
			// 고객ID
			colNo = 1;
			col = innerTable.getColumnModel().getColumn(colNo);
			width = 100;
			col.setPreferredWidth(width);

			
			// 모델번호
			colNo = 2;
			col = innerTable.getColumnModel().getColumn(colNo);
			width = 100;
			col.setPreferredWidth(width);
			
			
			// 구매수량
			colNo = 3;
			col = innerTable.getColumnModel().getColumn(colNo);
			width = 50;
			col.setPreferredWidth(width);
			
			// 가격
			colNo = 4;
			col = innerTable.getColumnModel().getColumn(colNo);
			width = 100;
			col.setPreferredWidth(width);
			
			
			// 구매일
			colNo = 5;
			col = innerTable.getColumnModel().getColumn(colNo);
			width = 200;
			col.setPreferredWidth(width);
			
			
			// 테이블 내용 지우기.
			int i = outerTable.getRowCount();
			for(int j=0; j<i; j++) {
				outerTable.removeRow(0);
			}
			
			innerTable.setAutoResizeMode(innerTable.AUTO_RESIZE_OFF);
		}else {
			JOptionPane.showMessageDialog(null, "검색된 결과가 없습니다.");
		}
		
		
	}
	
	private boolean searchAction() {
		String srhDate = cbYear.getSelectedItem() + "-" + cbMonth.getSelectedItem() + "-" + cbDay.getSelectedItem();
		AdminDao dao = new AdminDao(srhDate);
		ArrayList<AdminDto> dtoList = dao.selectTodayList();
		
		int listCount = dtoList.size();
		if(listCount > 0) {
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
			return true;
		}else {
			return false;
		}
	}	// End of searchAction()
	
	
	// ----  [[ 회원관리 ]] - Method -----
	private void tableInitCust() {
		// Table Column 명 정하기.
		outerTableCust.addColumn("이름");
		outerTableCust.addColumn("회원ID");
		outerTableCust.addColumn("회원PW");
		outerTableCust.addColumn("전화번호");
		outerTableCust.addColumn("주소");
		outerTableCust.addColumn("가입일");
		outerTableCust.addColumn("탈퇴일");
		outerTableCust.setColumnCount(7);
		
		// 이름
		int colNo = 0;
		TableColumn col = innerTableCust.getColumnModel().getColumn(colNo);
		int width = 100;
		col.setPreferredWidth(width);
		
		// 회원ID
		colNo = 1;
		col = innerTableCust.getColumnModel().getColumn(colNo);
		width = 100;
		col.setPreferredWidth(width);

		
		// 회원PW
		colNo = 2;
		col = innerTableCust.getColumnModel().getColumn(colNo);
		width = 100;
		col.setPreferredWidth(width);
		
		
		// 전화번호
		colNo = 3;
		col = innerTableCust.getColumnModel().getColumn(colNo);
		width = 100;
		col.setPreferredWidth(width);
		
		// 주소
		colNo = 4;
		col = innerTableCust.getColumnModel().getColumn(colNo);
		width = 100;
		col.setPreferredWidth(width);
		
		
		// 가입일
		colNo = 5;
		col = innerTableCust.getColumnModel().getColumn(colNo);
		width = 150;
		col.setPreferredWidth(width);
		
		// 탈퇴일
		colNo = 6;
		col = innerTableCust.getColumnModel().getColumn(colNo);
		width = 150;
		col.setPreferredWidth(width);
		
		
		// 테이블 내용 지우기.
		int i = outerTableCust.getRowCount();
		for(int j=0; j<i; j++) {
			outerTableCust.removeRow(0);
		}
		
		innerTableCust.setAutoResizeMode(innerTableCust.AUTO_RESIZE_OFF);
	}
	
	private void searchCustAction() {
		int selectIndex = cbSearchCust.getSelectedIndex();
		CustDao dao= new CustDao();
		ArrayList<CustDto> dtoList = dao.selectCustList(selectIndex, tfSearchCust.getText().trim());
		
		int listCount = dtoList.size();
		
		for(int i=0; i<listCount; i++) {
			String[] qTxt = {dtoList.get(i).getCustname(), dtoList.get(i).getCustid(), dtoList.get(i).getCustpw(), dtoList.get(i).getPhone(), dtoList.get(i).getAddress(), dtoList.get(i).getActdate(), dtoList.get(i).getDactdate()};
			outerTableCust.addRow(qTxt);
		}
	}	// End of searchAction()

}
