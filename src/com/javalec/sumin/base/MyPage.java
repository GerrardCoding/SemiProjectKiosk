package com.javalec.sumin.base;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JSpinner;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

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
	private JTextField textField;
	private JLabel lbl;
	private JTextField textField_1;
	private JLabel lblPrice;
	private JTextField textField_2;
	private JLabel lblSize;
	private JTextField textField_3;
	private JLabel lblColor;
	private JTextField textField_4;
	private JLabel lblQty;
	private JButton btnNewButton_1;
	private JButton btnEmptyCart;
	private JButton btnCheckout;
	private JLabel lblNewLabel_2;
	private JComboBox cbDate;
	private JTextField tfSearch;
	private JButton btnSearch;
	private JButton btnNewButton;
	private JSpinner spinner;
	
	
	
	
	

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
			tabbedPane.addTab("Account Info", new ImageIcon("/Users/tj/Downloads/icons8-테스트-계정-parakeet-line/icons8-테스트-계정-30.png"), getAccountInfo(), null);
			tabbedPane.addTab("My Orders", new ImageIcon("/Users/tj/Downloads/icons8-bookmark-sf-regular/icons8-bookmark-30.png"), getOrders(), null);
			tabbedPane.addTab("My Cart", new ImageIcon("/Users/tj/Downloads/icons8-쇼핑-카트-32.png"), getCart(), null);
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
			cart.setLayout(null);
			cart.add(getScrollPane_1());
			cart.add(getLblNewLabel_1());
			cart.add(getTextField());
			cart.add(getLbl());
			cart.add(getTextField_1());
			cart.add(getLblPrice());
			cart.add(getTextField_2());
			cart.add(getLblSize());
			cart.add(getTextField_3());
			cart.add(getLblColor());
			cart.add(getTextField_4());
			cart.add(getLblQty());
			cart.add(getBtnNewButton_1());
			cart.add(getBtnEmptyCart());
			cart.add(getBtnCheckout());
			cart.add(getLblNewLabel_2());
			cart.add(getSpinner());
		}
		return cart;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Welcome Back, Kim Bap!");
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
	private JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.setEditable(false);
			textField.setBounds(80, 193, 130, 26);
			textField.setColumns(10);
		}
		return textField;
	}
	private JLabel getLbl() {
		if (lbl == null) {
			lbl = new JLabel("제품ID:");
			lbl.setBounds(16, 297, 61, 16);
		}
		return lbl;
	}
	private JTextField getTextField_1() {
		if (textField_1 == null) {
			textField_1 = new JTextField();
			textField_1.setEditable(false);
			textField_1.setColumns(10);
			textField_1.setBounds(80, 292, 130, 26);
		}
		return textField_1;
	}
	private JLabel getLblPrice() {
		if (lblPrice == null) {
			lblPrice = new JLabel("금액:");
			lblPrice.setBounds(16, 231, 61, 16);
		}
		return lblPrice;
	}
	private JTextField getTextField_2() {
		if (textField_2 == null) {
			textField_2 = new JTextField();
			textField_2.setEditable(false);
			textField_2.setColumns(10);
			textField_2.setBounds(80, 226, 130, 26);
		}
		return textField_2;
	}
	private JLabel getLblSize() {
		if (lblSize == null) {
			lblSize = new JLabel("사이즈:");
			lblSize.setBounds(16, 330, 61, 16);
		}
		return lblSize;
	}
	private JTextField getTextField_3() {
		if (textField_3 == null) {
			textField_3 = new JTextField();
			textField_3.setEditable(false);
			textField_3.setColumns(10);
			textField_3.setBounds(80, 325, 83, 26);
		}
		return textField_3;
	}
	private JLabel getLblColor() {
		if (lblColor == null) {
			lblColor = new JLabel("색상:");
			lblColor.setBounds(16, 264, 61, 16);
		}
		return lblColor;
	}
	private JTextField getTextField_4() {
		if (textField_4 == null) {
			textField_4 = new JTextField();
			textField_4.setEditable(false);
			textField_4.setColumns(10);
			textField_4.setBounds(80, 259, 83, 26);
		}
		return textField_4;
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
	private JSpinner getSpinner() {
		if (spinner == null) {
			spinner = new JSpinner();
			spinner.setBounds(79, 358, 55, 26);
		}
		return spinner;
	}
	
	//------FUNCTIONS-------
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
