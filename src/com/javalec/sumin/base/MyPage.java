package com.javalec.sumin.base;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;

import javax.sound.midi.Sequence;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
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
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

import com.javalec.base.Main;
import com.javalec.common.ShareVar;
import com.javalec.gwangyeong.Product_Search;
import com.javalec.sumin.function.MyCartDao;
import com.javalec.sumin.function.MyCartDto;
import com.javalec.sumin.function.MyInfoDao;
import com.javalec.sumin.function.MyInfoDto;
import com.javalec.sumin.function.MyOrdersDao;
import com.javalec.sumin.function.MyOrdersDto;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;

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
	private JLabel lblImage;
	private JButton btnNewButton;

	// --Table--

	private final DefaultTableModel outerTable = new DefaultTableModel();
	private final DefaultTableModel cartOuterTable = new DefaultTableModel();
	private JTextField tfQty;
	private JLabel lblLogo;
	private JLabel lblNewLabel_2;
	private JLabel lblLogout;

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
		frame.getContentPane().setBackground(new Color(25, 25, 25));
		frame.setBackground(new Color(255, 255, 255));
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				myInfoAction();
			}
		});
		frame.setTitle("마이페이지");
		frame.setBounds(100, 100, 739, 594);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(getTabbedPane_1());
	}

	private JTabbedPane getTabbedPane_1() {
		if (tabbedPane == null) {
			tabbedPane = new JTabbedPane(JTabbedPane.TOP);
			tabbedPane.setBounds(0, 0, 740, 564);
			tabbedPane.setBackground(new Color(255, 255, 255));
			tabbedPane.addTab("Account Info",
					new ImageIcon("/Users/tj/Downloads/icons8-테스트-계정-parakeet-line/icons8-테스트-계정-30.png"),
					getAccountInfo(), null);
			tabbedPane.setForegroundAt(0, new Color(255, 146, 0));
			tabbedPane.addTab("My Orders",
					new ImageIcon("/Users/tj/Downloads/icons8-bookmark-sf-regular/icons8-bookmark-30.png"), getOrders(),
					null);
			tabbedPane.setForegroundAt(1, new Color(255, 146, 0));
			tabbedPane.addTab("My Cart", new ImageIcon("/Users/tj/Downloads/icons8-쇼핑-카트-32.png"), getCart(),
					null);
			tabbedPane.setForegroundAt(2, new Color(255, 146, 0));
			tabbedPane.addChangeListener(new ChangeListener() {

				@Override
				public void stateChanged(ChangeEvent e) {
					// TODO Auto-generated method stub
					int selectedIndex = tabbedPane.getSelectedIndex();
					if (selectedIndex == 0) {
						myInfoAction();
					} else if (selectedIndex == 1) {
						orderTableInit();
						orderSearchAction();
					} else if (selectedIndex == 2) {
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
			accountInfo.setForeground(new Color(255, 255, 255));
			accountInfo.setBackground(new Color(25, 25, 25));
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
			accountInfo.add(getLblLogo());
			accountInfo.add(getLblLogout());
			
		}
		return accountInfo;
	}

	private JPanel getOrders() {
		if (orders == null) {
			orders = new JPanel();
			orders.setForeground(new Color(0, 0, 0));
			orders.setBackground(new Color(0, 0, 0));
			orders.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					orderTableInit();
					orderSearchAction();
				}
			});
			orders.setLayout(null);
			orders.add(getScrollPane());
			orders.add(getBtnNewButton());
		}
		return orders;
	}

	private JPanel getCart() {
		if (cart == null) {
			cart = new JPanel();
			cart.setForeground(new Color(255, 255, 255));
			cart.setBackground(new Color(0, 0, 0));
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
			cart.add(getLblImage());
			cart.add(getTfQty());
		}
		return cart;
	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Welcome Back!");
			lblNewLabel.setForeground(new Color(254, 255, 255));
			lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
			lblNewLabel.setBounds(276, 99, 179, 16);
		}
		return lblNewLabel;
	}

	private JLabel getLblId() {
		if (lblId == null) {
			lblId = new JLabel("ID: ");
			lblId.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
			lblId.setForeground(new Color(254, 255, 255));
			lblId.setBounds(243, 160, 40, 16);
		}
		return lblId;
	}

	private JTextField getTfId() {
		if (tfId == null) {
			tfId = new JTextField();
			tfId.setEnabled(false);
			tfId.setBounds(295, 156, 111, 26);
			tfId.setColumns(10);
		}
		return tfId;
	}

	private JLabel getLblPw() {
		if (lblPw == null) {
			lblPw = new JLabel("PW:");
			lblPw.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
			lblPw.setForeground(new Color(254, 255, 255));
			lblPw.setBounds(243, 208, 40, 16);
		}
		return lblPw;
	}

	private JTextField getTfPw() {
		if (tfPw == null) {
			tfPw = new JTextField();
			tfPw.setColumns(10);
			tfPw.setBounds(295, 204, 111, 26);
		}
		return tfPw;
	}

	private JLabel getLblName() {
		if (lblName == null) {
			lblName = new JLabel("이름:");
			lblName.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
			lblName.setForeground(new Color(254, 255, 255));
			lblName.setBounds(243, 252, 40, 16);
		}
		return lblName;
	}

	private JTextField getTfName() {
		if (tfName == null) {
			tfName = new JTextField();
			tfName.setColumns(10);
			tfName.setBounds(295, 248, 111, 26);
		}
		return tfName;
	}

	private JLabel getLblPhone() {
		if (lblPhone == null) {
			lblPhone = new JLabel("전화번호:");
			lblPhone.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
			lblPhone.setForeground(new Color(254, 255, 255));
			lblPhone.setBounds(229, 306, 61, 16);
		}
		return lblPhone;
	}

	private JTextField getTfPhone() {
		if (tfPhone == null) {
			tfPhone = new JTextField();
			tfPhone.setColumns(10);
			tfPhone.setBounds(295, 301, 149, 26);
		}
		return tfPhone;
	}

	private JLabel getLblAddress() {
		if (lblAddress == null) {
			lblAddress = new JLabel("주소:");
			lblAddress.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
			lblAddress.setForeground(new Color(254, 255, 255));
			lblAddress.setBounds(243, 359, 40, 16);
		}
		return lblAddress;
	}

	private JTextField getTfAddress() {
		if (tfAddress == null) {
			tfAddress = new JTextField();
			tfAddress.setColumns(10);
			tfAddress.setBounds(295, 355, 149, 26);
		}
		return tfAddress;
	}

	private JButton getBtnBack() {
		if (btnBack == null) {
			btnBack = new JButton("돌아가기");
			btnBack.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					psAction(); 
				}
			});
			btnBack.setForeground(new Color(0, 0, 0));
			btnBack.setIcon(null);
			btnBack.setBounds(172, 441, 111, 29);
		}
		return btnBack;
	}

	private JButton getBtnEdit() {
		if (btnEdit == null) {
			btnEdit = new JButton("수정하기");
			btnEdit.setForeground(new Color(0, 0, 0));
			btnEdit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					updateAction();
					myInfoAction();

				}
			});
			btnEdit.setBounds(292, 441, 117, 29);
		}
		return btnEdit;
	}

	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(6, 14, 708, 435);
			scrollPane.setViewportView(getOrder_Table());
		}
		return scrollPane;
	}

	private JTable getOrder_Table() {
		if (order_Table == null) {
			order_Table = new JTable();
			order_Table.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
				}
			});
			order_Table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			order_Table.setModel(outerTable);
		}
		return order_Table;
	}

	private JScrollPane getScrollPane_1() {
		if (scrollPane_1 == null) {
			scrollPane_1 = new JScrollPane();
			scrollPane_1.setBounds(6, 6, 707, 175);
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
					if (e.getButton() == 1) {
						tableClick();
					}
				}
			});
			cart_Table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			cart_Table.setModel(cartOuterTable);
		}
		return cart_Table;
	}

	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("상품번호:");
			lblNewLabel_1.setForeground(new Color(255, 255, 255));
			lblNewLabel_1.setBounds(16, 222, 61, 16);
		}
		return lblNewLabel_1;
	}

	private JTextField getTfSeqNo() {
		if (tfSeqNo == null) {
			tfSeqNo = new JTextField();
			tfSeqNo.setHorizontalAlignment(SwingConstants.TRAILING);
			tfSeqNo.setEditable(false);
			tfSeqNo.setBounds(80, 217, 90, 26);
			tfSeqNo.setColumns(10);
		}
		return tfSeqNo;
	}

	private JLabel getLbl() {
		if (lbl == null) {
			lbl = new JLabel("제품ID:");
			lbl.setForeground(new Color(255, 255, 255));
			lbl.setBounds(16, 321, 61, 16);
		}
		return lbl;
	}

	private JTextField getTfModelNo() {
		if (tfModelNo == null) {
			tfModelNo = new JTextField();
			tfModelNo.setHorizontalAlignment(SwingConstants.TRAILING);
			tfModelNo.setEditable(false);
			tfModelNo.setColumns(10);
			tfModelNo.setBounds(80, 316, 90, 26);
		}
		return tfModelNo;
	}

	private JLabel getLblPrice() {
		if (lblPrice == null) {
			lblPrice = new JLabel("금액:");
			lblPrice.setForeground(new Color(255, 255, 255));
			lblPrice.setBounds(16, 255, 61, 16);
		}
		return lblPrice;
	}

	private JTextField getTfPrice() {
		if (tfPrice == null) {
			tfPrice = new JTextField();
			tfPrice.setHorizontalAlignment(SwingConstants.TRAILING);
			tfPrice.setEditable(false);
			tfPrice.setColumns(10);
			tfPrice.setBounds(80, 250, 90, 26);
		}
		return tfPrice;
	}

	private JLabel getLblSize() {
		if (lblSize == null) {
			lblSize = new JLabel("사이즈:");
			lblSize.setForeground(new Color(255, 255, 255));
			lblSize.setBounds(16, 354, 61, 16);
		}
		return lblSize;
	}

	private JTextField getTfSize() {
		if (tfSize == null) {
			tfSize = new JTextField();
			tfSize.setHorizontalAlignment(SwingConstants.TRAILING);
			tfSize.setEditable(false);
			tfSize.setColumns(10);
			tfSize.setBounds(80, 349, 90, 26);
		}
		return tfSize;
	}

	private JLabel getLblColor() {
		if (lblColor == null) {
			lblColor = new JLabel("색상:");
			lblColor.setForeground(new Color(255, 255, 255));
			lblColor.setBounds(16, 288, 61, 16);
		}
		return lblColor;
	}

	private JTextField getTfColor() {
		if (tfColor == null) {
			tfColor = new JTextField();
			tfColor.setHorizontalAlignment(SwingConstants.TRAILING);
			tfColor.setEditable(false);
			tfColor.setColumns(10);
			tfColor.setBounds(80, 283, 90, 26);
		}
		return tfColor;
	}

	private JLabel getLblQty() {
		if (lblQty == null) {
			lblQty = new JLabel("수량:");
			lblQty.setForeground(new Color(255, 255, 255));
			lblQty.setBounds(16, 387, 61, 16);
		}
		return lblQty;
	}

	private JButton getBtnNewButton_1() {
		if (btnNewButton_1 == null) {
			btnNewButton_1 = new JButton("돌아가기");
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					psAction(); 
				}
			});
			btnNewButton_1.setForeground(new Color(0, 0, 0));
			btnNewButton_1.setBounds(155, 460, 117, 29);
		}
		return btnNewButton_1;
	}

	private JButton getBtnEmptyCart() {
		if (btnEmptyCart == null) {
			btnEmptyCart = new JButton("삭제");
			btnEmptyCart.setForeground(new Color(0, 0, 0));
			btnEmptyCart.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					deleteAction();
					cartTableInit();
					cartSearchAction();
				}
			});
			btnEmptyCart.setBounds(299, 460, 117, 29);
		}
		return btnEmptyCart;
	}

	private JButton getBtnCheckout() {
		if (btnCheckout == null) {
			btnCheckout = new JButton("결제하기");
			btnCheckout.setForeground(new Color(0, 0, 0));
			btnCheckout.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					checkout();
					clearColumn();
					cartTableInit();
					cartSearchAction();
				}
			});
			btnCheckout.setBounds(447, 460, 117, 29);
		}
		return btnCheckout;
	}

	private JLabel getLblImage() {
		if (lblImage == null) {
			lblImage = new JLabel("");
			lblImage.setHorizontalAlignment(SwingConstants.CENTER);
			lblImage.setBounds(182, 193, 531, 243);
		}
		return lblImage;
	}

	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("돌아가기");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					psAction(); 
				}
			});
			btnNewButton.setForeground(new Color(0, 0, 0));
			btnNewButton.setBounds(299, 473, 117, 29);
		}
		return btnNewButton;
	}
	private JLabel getLblLogo() {
		if (lblLogo == null) {
			//원래 이미지의 파일을 ICON에 담는다 . 
			ImageIcon icon = new ImageIcon(MyPage.class.getResource("/com/javalec/images/로고.png"));
			//img 안에 이미지를 담는다. 
			Image img = icon.getImage(); 
			//change the image size
			Image changeImg = img.getScaledInstance(100, 40, 100);
			//변경된 이미지를 다시 iMAGE ICON 에 담아준다. 
			ImageIcon changeIcon = new ImageIcon(changeImg); 
			lblLogo = new JLabel(changeIcon); 
			lblLogo.setBounds(12, 10, 157, 62);
		}
		return lblLogo;
	}
	private JLabel getLblLogout() {
		if (lblLogout == null) {
			lblLogout = new JLabel("");
			lblLogout.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					logoutAction(); 
				}
			});
			lblLogout.setBackground(new Color(0, 0, 0));
			lblLogout.setForeground(new Color(0, 0, 0));
			lblLogout.setIcon(new ImageIcon(MyPage.class.getResource("/com/javalec/images/logout3.png")));
			lblLogout.setBounds(645, 10, 48, 69);
		}
		return lblLogout;
	}
	// ------FUNCTIONS-------

	// MY ORDERS TABLE 초기화 시키기

	private void orderTableInit() {
		// System.out.println("hello");
		// Table Column 명 정하기
		outerTable.addColumn("Order No.");
		outerTable.addColumn("Cust ID");
		outerTable.addColumn("Model No");
		outerTable.addColumn("Order Qty");
		outerTable.addColumn("Order Price");
		outerTable.addColumn("Order Date");
		outerTable.setColumnCount(6);

		// Table Column 크기 정하기
		int colNo = 0;
		TableColumn col = order_Table.getColumnModel().getColumn(colNo);
		int width = 100;
		col.setPreferredWidth(width);

		colNo = 1;
		col = order_Table.getColumnModel().getColumn(colNo);
		width = 135;
		col.setPreferredWidth(width);

		colNo = 2;
		col = order_Table.getColumnModel().getColumn(colNo);
		width = 110;
		col.setPreferredWidth(width);

		colNo = 3;
		col = order_Table.getColumnModel().getColumn(colNo);
		width = 90;
		col.setPreferredWidth(width);

		colNo = 4;
		col = order_Table.getColumnModel().getColumn(colNo);
		width = 150;
		col.setPreferredWidth(width);
		
		colNo = 5;
		col = order_Table.getColumnModel().getColumn(colNo);
		width = 120;
		col.setPreferredWidth(width);

		order_Table.setAutoResizeMode(order_Table.AUTO_RESIZE_OFF);

		int i = outerTable.getRowCount();
		for (int j = 0; j < i; j++) {
			outerTable.removeRow(0);
		}
	}
	

	// Orders 검색

	private void orderSearchAction() {
		MyOrdersDao myPageDao = new MyOrdersDao();
		ArrayList<MyOrdersDto> dtoList = myPageDao.selectList();

		int listCount = dtoList.size();

		for (int i = 0; i < listCount; i++) {

			String[] temp = { Integer.toString(dtoList.get(i).getPurnum()), 
							dtoList.get(i).getCustid(),
							dtoList.get(i).getStomodelnum(),
							Integer.toString(dtoList.get(i).getPurqty()), 
							Integer.toString(dtoList.get(i).getPurprice()),
							dtoList.get(i).getPurdate(), };
			outerTable.addRow(temp);
		}

	}

	// MY CART TABLE 초기화 시키기

	private void cartTableInit() {

		// Table Column 명 정하기
		cartOuterTable.addColumn("No.");
		cartOuterTable.addColumn("Model No.");
		cartOuterTable.addColumn("Size");
		cartOuterTable.addColumn("Cart Qty");
		cartOuterTable.addColumn("Price");
		cartOuterTable.addColumn("Color");
		cartOuterTable.setColumnCount(6);

		// Table Column 크기 정하기
		int colNo = 0;
		TableColumn col = cart_Table.getColumnModel().getColumn(colNo);
		int width = 100;
		col.setPreferredWidth(width);

		colNo = 1;
		col = cart_Table.getColumnModel().getColumn(colNo);
		width = 135;
		col.setPreferredWidth(width);

		colNo = 2;
		col = cart_Table.getColumnModel().getColumn(colNo);
		width = 110;
		col.setPreferredWidth(width);

		colNo = 3;
		col = cart_Table.getColumnModel().getColumn(colNo);
		width = 90;
		col.setPreferredWidth(width);

		colNo = 4;
		col = cart_Table.getColumnModel().getColumn(colNo);
		width = 150;
		col.setPreferredWidth(width);

		colNo = 5;
		col = cart_Table.getColumnModel().getColumn(colNo);
		width = 120;
		col.setPreferredWidth(width);

		cart_Table.setAutoResizeMode(cart_Table.AUTO_RESIZE_OFF);

		int i = cartOuterTable.getRowCount();
		for (int j = 0; j < i; j++) {
			cartOuterTable.removeRow(0);
		}
	}

	// Cart 검색

	private void cartSearchAction() {
		MyCartDao myCartDao = new MyCartDao();
		ArrayList<MyCartDto> dtoList = myCartDao.selectList();

		int listCount = dtoList.size();

		for (int i = 0; i < listCount; i++) {

			String[] temp = { Integer.toString(dtoList.get(i).getCartseqno()), dtoList.get(i).getModelnum(),
					Integer.toString(dtoList.get(i).getStosize()), Integer.toString(dtoList.get(i).getCartqty()),
					Integer.toString(dtoList.get(i).getStoprice()), dtoList.get(i).getColor() };
			cartOuterTable.addRow(temp);
		}

	}

	// Cart table 에서 Row 를 Click 했을 경우

	private void tableClick() {
		int i = cart_Table.getSelectedRow();
		String tkSequence = (String) cart_Table.getValueAt(i, 1);

		MyCartDao dao = new MyCartDao(tkSequence);
		MyCartDto dto = dao.tableClick();

		tfSeqNo.setText(Integer.toString(dto.getCartseqno()));
		tfModelNo.setText(dto.getModelnum());
		tfSize.setText(Integer.toString(dto.getStosize()));
		tfQty.setText(Integer.toString(dto.getCartqty()));
		tfPrice.setText(Integer.toString(dto.getStoprice()));
		tfColor.setText(dto.getColor());

		// Image 처리 : fileName이 틀려야 보여주기가 가능.
		String filePath = Integer.toString(ShareVar.filename);
		// tfFilePath.setText(filePath);
		lblImage.setIcon(new ImageIcon(filePath));
		lblImage.setHorizontalAlignment(SwingConstants.CENTER);

	}

	// Cart 에서 삭제할 경우

	private void deleteAction() {
		int cartseqno = Integer.parseInt(tfSeqNo.getText());

		MyCartDao dao = new MyCartDao(cartseqno);
		boolean result = dao.deleteAction();

		if (result == true) {
			JOptionPane.showMessageDialog(null, "장바구니에서 삭제되었습니다.");
		} else {
			JOptionPane.showMessageDialog(null, "입력중 문제가 발생");
		}

	}
	
	private void checkout() {
		if(insertOrder() && deleteCart()) {
			JOptionPane.showMessageDialog(null, "결제되었습니다.");
		}else {
			JOptionPane.showMessageDialog(null, "결제 중 문제가 발생했습니다.");
		}
	}

	// 결제
	private boolean deleteCart() {

		// cart
		MyCartDao dao = new MyCartDao();
		
		boolean result = dao.deleteCart();	// 카트에 있는 정보 삭제.
		
		if ( dao.deleteCart()) {
			return true;
		
		}
		return false;
	}

	private JTextField getTfQty() {
		if (tfQty == null) {
			tfQty = new JTextField();
			tfQty.setHorizontalAlignment(SwingConstants.TRAILING);
			tfQty.setBounds(80, 382, 90, 26);
			tfQty.setColumns(10);
		}
		return tfQty;
	}

	// MY INFO

	private void myInfoAction() {

		MyInfoDao dao = new MyInfoDao(ShareVar.loginID);
		MyInfoDto myInfoDto = dao.selectList();

		tfId.setText(myInfoDto.getCustid());
		tfPw.setText(myInfoDto.getCustpw());
		tfName.setText(myInfoDto.getCustname());
		tfPhone.setText(myInfoDto.getPhone());
		tfAddress.setText(myInfoDto.getAddress());

	}

	// MYINFO 에서 수정할 경우

	private void updateAction() {
		String custid = ShareVar.loginID;
		String custpw = tfPw.getText().trim();
		String custname = tfName.getText().trim();
		String phone = tfPhone.getText().trim();
		String address = tfAddress.getText().trim();

		MyInfoDao dao = new MyInfoDao(custid, custpw, custname, phone, address);
		boolean result = dao.updateAction();

		if (result == true) {
			JOptionPane.showMessageDialog(null, tfName.getText() + "님의 정보가 수정되었습니다.");
		} else {
			JOptionPane.showMessageDialog(null, "입력중 문제가 발생");
		}

	}

	private void clearColumn() {
		tfSeqNo.setText("");
		tfModelNo.setText("");
		tfPrice.setText("");
		tfSize.setText("");
		tfColor.setText("");
		tfQty.setText("");
		lblImage.setIcon(null);
	}
	
	
	//My Account 에서 돌아가기 버튼 눌렀을 경우 
	
	private void psAction() {
		
		frame.setVisible(false);
		Product_Search ps = new Product_Search();
		ps.main(null);
			
	}
	
	//MY INFO 패이지 에서 로그아웃 아이콘을 눌렀을 경우 
		
	private void logoutAction() {
	// 첫 화면으로 돌아가기
		Main window = new Main();
		window.main(null);
		frame.setVisible(false);

	}
	
	
	//MY CART 에서 결제했을 경우 결제한 값이 PURCHASE TABLE (MY ORDER) 로 이동한다
	
	private boolean insertOrder() {
		boolean result = false;
		MyCartDao myCartDao = new MyCartDao();
		ArrayList<MyCartDto> dtoList = myCartDao.selectList();
		
		MyOrdersDao maxPurDao = new MyOrdersDao();
		int maxPurnum = maxPurDao.getMaxPurnum();

		int listCount = dtoList.size();
		for (int i = 0; i < listCount; i++) {

			String modelnum = dtoList.get(i).getModelnum();
			int qty = dtoList.get(i).getCartqty();
			int price = dtoList.get(i).getStoprice();
			
			MyOrdersDao dao = new MyOrdersDao(maxPurnum+1, ShareVar.loginID, modelnum, qty, price);
			result = dao.insertAction();
		}
		
		return result;
	}
		
}	
	

