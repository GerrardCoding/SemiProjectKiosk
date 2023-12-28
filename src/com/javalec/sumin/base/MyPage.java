package com.javalec.sumin.base;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.util.ArrayList;

import javax.sound.midi.Sequence;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import com.javalec.sumin.function.MyCartDao;
import com.javalec.sumin.function.MyCartDto;
import com.javalec.sumin.function.MyOrdersDao;
import com.javalec.sumin.function.MyOrdersDto;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MyPage {

	private JFrame frame;
	private JTabbedPane tabbedPane;
	private JPanel accountInfo;
	private JPanel orders;
	private JPanel cart;
	private JLabel lblNewLabel;
	private JLabel lblId;
	private JTextField tfId;
	private JLabel lblPw;
	private JTextField tfPw;
	private JLabel lblName;
	private JTextField tfName;
	private JLabel lblPhone;
	private JTextField tfPhone;
	private JLabel lblAddress;
	private JTextField tfAddress;
	private JButton btnBack;
	private JButton btnEdit;
	private JButton btnDeactivate;
	private JScrollPane scrollPane;
	private JTable order_Table;
	private JScrollPane scrollPane_1;
	private JTable cart_Table;
	private JLabel lblNewLabel_1;
	private JTextField tfSeqNo;
	private JLabel lbl;
	private JTextField tfModelNo;
	private JLabel lblPrice;
	private JTextField tfPrice;
	private JLabel lblSize;
	private JTextField tfSize;
	private JLabel lblColor;
	private JTextField tfColor;
	private JLabel lblQty;
	private JButton btnNewButton_1;
	private JButton btnEmptyCart;
	private JButton btnCheckout;
	private JLabel lblNewLabel_2;
	private JComboBox cbDate;
	private JTextField tfSearch;
	private JButton btnSearch;
	private JButton btnNewButton;
	private JSpinner spQty;
	
	
	//--Table--
	
	private final DefaultTableModel outerTable = new DefaultTableModel();
	
	


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyPage window = new MyPage();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MyPage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.addWindowListener(new WindowAdapter() {});
		frame.setTitle("마이페이지");
		frame.setBounds(100, 100, 470, 540);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(getTabbedPane_1());
	}
	private JTabbedPane getTabbedPane_1() {
		if (tabbedPane == null) {
			tabbedPane = new JTabbedPane(JTabbedPane.TOP);
			tabbedPane.setBounds(0, 0, 466, 517);
			tabbedPane.setBackground(Color.WHITE);
			tabbedPane.addTab("Account Info", new ImageIcon("/Users/tj/Downloads/icons8-테스트-계정-parakeet-line/icons8-테스트-계정-30.png"), getAccountInfo(), null);
			tabbedPane.addTab("My Orders", new ImageIcon("/Users/tj/Downloads/icons8-bookmark-sf-regular/icons8-bookmark-30.png"), getOrders(), null);
			tabbedPane.addTab("My Cart", new ImageIcon("/Users/tj/Downloads/icons8-쇼핑-카트-32.png"), getCart(), null);
			tabbedPane.addChangeListener(new ChangeListener() {
				
				@Override
				public void stateChanged(ChangeEvent e) {
					// TODO Auto-generated method stub
					int selectedIndex = tabbedPane.getSelectedIndex();
					if(selectedIndex==0) {
						
					}else if(selectedIndex==1) {
						orderTableInit();	
						orderSearchAction();
					}else if(selectedIndex==2) {
						cartTableInit();
						cartSearchAction();
						
						
					}
				}
			});
		}
		return tabbedPane;
	}
	private JPanel getAccountInfo() {
		if (accountInfo == null) {
			accountInfo = new JPanel();
			accountInfo.setLayout(null);
			accountInfo.add(getLblNewLabel());
			accountInfo.add(getLblId());
			accountInfo.add(getTfId());
			accountInfo.add(getLblPw());
			accountInfo.add(getTfPw());
			accountInfo.add(getLblName());
			accountInfo.add(getTfName());
			accountInfo.add(getLblPhone());
			accountInfo.add(getTfPhone());
			accountInfo.add(getLblAddress());
			accountInfo.add(getTfAddress());
			accountInfo.add(getBtnBack());
			accountInfo.add(getBtnEdit());
			accountInfo.add(getBtnDeactivate());
		}
		return accountInfo;
	}
	private JPanel getOrders() {
		if (orders == null) {
			orders = new JPanel();
			orders.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					orderTableInit();
					orderSearchAction();
				}
			});
			orders.setLayout(null);
			orders.add(getScrollPane());
			orders.add(getCbDate());
			orders.add(getTfSearch());
			orders.add(getBtnSearch());
			orders.add(getBtnNewButton());
		}
		return orders;
	}
	private JPanel getCart() {
		if (cart == null) {
			cart = new JPanel();
			cart.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					cartTableInit();
					cartSearchAction();
				}
			});
			cart.setLayout(null);
			cart.add(getScrollPane_1());
			cart.add(getLblNewLabel_1());
			cart.add(getTfSeqNo());
			cart.add(getLbl());
			cart.add(getTfModelNo());
			cart.add(getLblPrice());
			cart.add(getTfPrice());
			cart.add(getLblSize());
			cart.add(getTfSize());
			cart.add(getLblColor());
			cart.add(getTfColor());
			cart.add(getLblQty());
			cart.add(getBtnNewButton_1());
			cart.add(getBtnEmptyCart());
			cart.add(getBtnCheckout());
			cart.add(getLblNewLabel_2());
			cart.add(getSpQty());
		}
		return cart;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Welcome Back, Kim !");
			lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
			lblNewLabel.setBounds(116, 29, 179, 16);
		}
		return lblNewLabel;
	}
	private JLabel getLblId() {
		if (lblId == null) {
			lblId = new JLabel("ID: ");
			lblId.setBounds(80, 96, 61, 16);
		}
		return lblId;
	}
	private JTextField getTfId() {
		if (tfId == null) {
			tfId = new JTextField();
			tfId.setBounds(146, 91, 111, 26);
			tfId.setColumns(10);
		}
		return tfId;
	}
	private JLabel getLblPw() {
		if (lblPw == null) {
			lblPw = new JLabel("PW:");
			lblPw.setBounds(80, 144, 61, 16);
		}
		return lblPw;
	}
	private JTextField getTfPw() {
		if (tfPw == null) {
			tfPw = new JTextField();
			tfPw.setColumns(10);
			tfPw.setBounds(146, 139, 111, 26);
		}
		return tfPw;
	}
	private JLabel getLblName() {
		if (lblName == null) {
			lblName = new JLabel("이름:");
			lblName.setBounds(80, 188, 61, 16);
		}
		return lblName;
	}
	private JTextField getTfName() {
		if (tfName == null) {
			tfName = new JTextField();
			tfName.setColumns(10);
			tfName.setBounds(146, 183, 111, 26);
		}
		return tfName;
	}
	private JLabel getLblPhone() {
		if (lblPhone == null) {
			lblPhone = new JLabel("전화번호:");
			lblPhone.setBounds(80, 241, 61, 16);
		}
		return lblPhone;
	}
	private JTextField getTfPhone() {
		if (tfPhone == null) {
			tfPhone = new JTextField();
			tfPhone.setColumns(10);
			tfPhone.setBounds(146, 236, 149, 26);
		}
		return tfPhone;
	}
	private JLabel getLblAddress() {
		if (lblAddress == null) {
			lblAddress = new JLabel("주소:");
			lblAddress.setBounds(80, 295, 61, 16);
		}
		return lblAddress;
	}
	private JTextField getTfAddress() {
		if (tfAddress == null) {
			tfAddress = new JTextField();
			tfAddress.setColumns(10);
			tfAddress.setBounds(146, 290, 197, 26);
		}
		return tfAddress;
	}
	private JButton getBtnBack() {
		if (btnBack == null) {
			btnBack = new JButton("돌아가기");
			btnBack.setIcon(null);
			btnBack.setBounds(34, 371, 111, 29);
		}
		return btnBack;
	}
	private JButton getBtnEdit() {
		if (btnEdit == null) {
			btnEdit = new JButton("수정하기");
			btnEdit.setBounds(154, 371, 117, 29);
		}
		return btnEdit;
	}
	private JButton getBtnDeactivate() {
		if (btnDeactivate == null) {
			btnDeactivate = new JButton("회원탈퇴");
			btnDeactivate.setBounds(271, 371, 117, 29);
		}
		return btnDeactivate;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(6, 48, 433, 322);
			scrollPane.setViewportView(getOrder_Table());
		}
		return scrollPane;
	}
	private JTable getOrder_Table() {
		if (order_Table == null) {
			order_Table = new JTable();
			order_Table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			order_Table.setModel(outerTable);
		}
		return order_Table;
	}
	private JScrollPane getScrollPane_1() {
		if (scrollPane_1 == null) {
			scrollPane_1 = new JScrollPane();
			scrollPane_1.setBounds(6, 6, 433, 175);
			scrollPane_1.setViewportView(getCart_Table());
		}
		return scrollPane_1;
	}
	private JTable getCart_Table() {
		if (cart_Table == null) {
			cart_Table = new JTable();
			cart_Table.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if (e.getButton()==1) {
						tableClick();
					}
				}
			});
			cart_Table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			cart_Table.setModel(outerTable);
		}
		return cart_Table;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("상품번호:");
			lblNewLabel_1.setBounds(16, 198, 61, 16);
		}
		return lblNewLabel_1;
	}
	private JTextField getTfSeqNo() {
		if (tfSeqNo == null) {
			tfSeqNo = new JTextField();
			tfSeqNo.setEditable(false);
			tfSeqNo.setBounds(80, 193, 130, 26);
			tfSeqNo.setColumns(10);
		}
		return tfSeqNo;
	}
	private JLabel getLbl() {
		if (lbl == null) {
			lbl = new JLabel("제품ID:");
			lbl.setBounds(16, 297, 61, 16);
		}
		return lbl;
	}
	private JTextField getTfModelNo() {
		if (tfModelNo == null) {
			tfModelNo = new JTextField();
			tfModelNo.setEditable(false);
			tfModelNo.setColumns(10);
			tfModelNo.setBounds(80, 292, 130, 26);
		}
		return tfModelNo;
	}
	private JLabel getLblPrice() {
		if (lblPrice == null) {
			lblPrice = new JLabel("금액:");
			lblPrice.setBounds(16, 231, 61, 16);
		}
		return lblPrice;
	}
	private JTextField getTfPrice() {
		if (tfPrice == null) {
			tfPrice = new JTextField();
			tfPrice.setEditable(false);
			tfPrice.setColumns(10);
			tfPrice.setBounds(80, 226, 130, 26);
		}
		return tfPrice;
	}
	private JLabel getLblSize() {
		if (lblSize == null) {
			lblSize = new JLabel("사이즈:");
			lblSize.setBounds(16, 330, 61, 16);
		}
		return lblSize;
	}
	private JTextField getTfSize() {
		if (tfSize == null) {
			tfSize = new JTextField();
			tfSize.setEditable(false);
			tfSize.setColumns(10);
			tfSize.setBounds(80, 325, 83, 26);
		}
		return tfSize;
	}
	private JLabel getLblColor() {
		if (lblColor == null) {
			lblColor = new JLabel("색상:");
			lblColor.setBounds(16, 264, 61, 16);
		}
		return lblColor;
	}
	private JTextField getTfColor() {
		if (tfColor == null) {
			tfColor = new JTextField();
			tfColor.setEditable(false);
			tfColor.setColumns(10);
			tfColor.setBounds(80, 259, 83, 26);
		}
		return tfColor;
	}
	private JLabel getLblQty() {
		if (lblQty == null) {
			lblQty = new JLabel("수량:");
			lblQty.setBounds(16, 363, 61, 16);
		}
		return lblQty;
	}
	private JButton getBtnNewButton_1() {
		if (btnNewButton_1 == null) {
			btnNewButton_1 = new JButton("돌아가기");
			btnNewButton_1.setBounds(53, 423, 117, 29);
		}
		return btnNewButton_1;
	}
	private JButton getBtnEmptyCart() {
		if (btnEmptyCart == null) {
			btnEmptyCart = new JButton("장바구니에서 삭제");
			btnEmptyCart.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					deleteAction();
				}
			});
			btnEmptyCart.setBounds(170, 423, 117, 29);
		}
		return btnEmptyCart;
	}
	private JButton getBtnCheckout() {
		if (btnCheckout == null) {
			btnCheckout = new JButton("결제하기");
			btnCheckout.setBounds(287, 423, 117, 29);
		}
		return btnCheckout;
	}
	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("IMAGE");
			lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_2.setBounds(208, 193, 231, 186);
		}
		return lblNewLabel_2;
	}
	private JComboBox getCbDate() {
		if (cbDate == null) {
			cbDate = new JComboBox();
			cbDate.setModel(new DefaultComboBoxModel(new String[] {"3 Months", "6 Months", "1 Year"}));
			cbDate.setBounds(6, 9, 117, 27);
		}
		return cbDate;
	}
	private JTextField getTfSearch() {
		if (tfSearch == null) {
			tfSearch = new JTextField();
			tfSearch.setBounds(122, 8, 191, 26);
			tfSearch.setColumns(10);
		}
		return tfSearch;
	}
	private JButton getBtnSearch() {
		if (btnSearch == null) {
			btnSearch = new JButton("검색");
			btnSearch.setBounds(322, 6, 117, 29);
		}
		return btnSearch;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("돌아가기");
			btnNewButton.setBounds(171, 411, 117, 29);
		}
		return btnNewButton;
	}
	private JSpinner getSpQty() {
		if (spQty == null) {
			spQty = new JSpinner();
			spQty.setBounds(79, 358, 55, 26);
		}
		return spQty;
	}
	
	//------FUNCTIONS-------
	
	//MY ORDERS TABLE 초기화 시키기
	
	private void orderTableInit() {
	//System.out.println("hello");
	//Table Column 명 정하기
	outerTable.addColumn("No.");
	outerTable.addColumn("Model No.");
	outerTable.addColumn("Size");
	outerTable.addColumn("Qty");
	outerTable.addColumn("Order Date");
	outerTable.setColumnCount(5);	
	

		
	//Table Column 크기 정하기 
	int colNo = 0; 
	TableColumn col = order_Table.getColumnModel().getColumn(colNo);
	int width = 30;
	col.setPreferredWidth(width);
	
	
	colNo = 1; 
	col = order_Table.getColumnModel().getColumn(colNo);
	width = 90;
	col.setPreferredWidth(width);
	
	
	colNo = 2; 
	col = order_Table.getColumnModel().getColumn(colNo);
	width = 40;
	col.setPreferredWidth(width);
	
	
	colNo = 3; 
	col = order_Table.getColumnModel().getColumn(colNo);
	width = 40;
	col.setPreferredWidth(width);
	
	colNo = 4; 
	col = order_Table.getColumnModel().getColumn(colNo);
	width = 100;
	col.setPreferredWidth(width);
	
	
	
	order_Table.setAutoResizeMode (order_Table.AUTO_RESIZE_OFF); 
	
	int i = outerTable.getRowCount();
	for (int j =0; j<i; j++ ) {
		outerTable.removeRow(0);
	}
}	
		
	//Orders 검색
	
	private void orderSearchAction() {
		MyOrdersDao myPageDao = new MyOrdersDao();
		ArrayList<MyOrdersDto> dtoList = myPageDao.selectList();
		
		int listCount = dtoList.size();
		
		for (int i=0; i<listCount; i++) {
			
			String [] temp = {Integer.toString(dtoList.get(i).getStgseqno()),
							  dtoList.get(i).getStomodelnum(),
							  Integer.toString(dtoList.get(i).getStgsize()),
							  Integer.toString(dtoList.get(i).getStgqty()),
							  dtoList.get(i).getStgdate(),  
							  };
			outerTable.addRow(temp);
		}

	}
	

	
	
	//MY CART TABLE 초기화 시키기
		
	private void cartTableInit() {
		
		//Table Column 명 정하기
		outerTable.addColumn("No.");
		outerTable.addColumn("Model No.");
		outerTable.addColumn("Size");
		outerTable.addColumn("Cart Qty");
		outerTable.addColumn("Price");	
		outerTable.addColumn("Color");
		outerTable.setColumnCount(6);	
		

			
		//Table Column 크기 정하기 
		int colNo = 0; 
		TableColumn col = cart_Table.getColumnModel().getColumn(colNo);
		int width = 50;
		col.setPreferredWidth(width);
		
		colNo = 1; 
		col = cart_Table.getColumnModel().getColumn(colNo);
		width = 150;
		col.setPreferredWidth(width);
		
		colNo = 2; 
		col = cart_Table.getColumnModel().getColumn(colNo);
		width = 50;
		col.setPreferredWidth(width);
	
		colNo = 3; 
		col = cart_Table.getColumnModel().getColumn(colNo);
		width = 50;
		col.setPreferredWidth(width);
		
		colNo = 4; 
		col = cart_Table.getColumnModel().getColumn(colNo);
		width = 50;
		col.setPreferredWidth(width);
		
		colNo = 5; 
		col = cart_Table.getColumnModel().getColumn(colNo);
		width = 50;
		col.setPreferredWidth(width);
		
		
			
	
		cart_Table.setAutoResizeMode (cart_Table.AUTO_RESIZE_OFF); 
		
		int i = outerTable.getRowCount();
		for (int j =0; j<i; j++ ) {
			outerTable.removeRow(0);
		}
	}		
		
		
	//Cart 검색
	
		private void cartSearchAction() {
			MyCartDao myCartDao = new MyCartDao();
			ArrayList<MyCartDto> dtoList = myCartDao.selectList();
			
			int listCount = dtoList.size();
			
			for (int i=0; i<listCount; i++) {
				
				String [] temp = {Integer.toString(dtoList.get(i).getCartseqno()),
								  dtoList.get(i).getModelnum(),
								  Integer.toString(dtoList.get(i).getStosize()),
								  Integer.toString(dtoList.get(i).getCartqty()),
								  Integer.toString(dtoList.get(i).getStoprice()),
								  dtoList.get(i).getColor()};
				outerTable.addRow(temp);
			}

		}	
		
	
		
	//Cart table 에서 Row 를 Click 했을 경우
	
	private void tableClick() {
		int i = cart_Table.getSelectedRow(); 
		String tkSequence = (String) cart_Table.getValueAt(i, 0);
		int wkSequence = Integer.parseInt(tkSequence);
	
		MyCartDao dao = new MyCartDao(wkSequence); 
		MyCartDto dto = dao.tableClick(); 
		
		
		tfSeqNo.setText(Integer.toString(dto.getCartseqno()));
		tfModelNo.setText(dto.getModelnum());
		tfSize.setText(Integer.toString(dto.getStosize()));
		spQty.setValue(Integer.toString(dto.getCartqty()));
		tfPrice.setText(Integer.toString(dto.getStoprice()));
		tfColor.setText(dto.getColor());
	
	}
	
	
	//Cart 에서 삭제할 경우 
	
	
	private void deleteAction() {
		int cartseqno = Integer.parseInt(tfSeqNo.getText());
		
		MyCartDao dao = new MyCartDao(cartseqno);
		boolean result = dao.deleteAction(); 
		
		if(result == true) {		
			JOptionPane.showMessageDialog(null, tfSeqNo.getText() + "님의 정보가 삭제되었습니다."); 
		}else {
			JOptionPane.showMessageDialog(null, "입력중 문제가 발생");
		}
			
		}
		
		
		
		
		
	
	
	
	
	
	
	
	
		
		
	
}
