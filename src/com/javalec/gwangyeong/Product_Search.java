/* 제품 검색 Page - by. 광영 */

package com.javalec.gwangyeong;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

import com.javalec.base.Main;
import com.javalec.sumin.base.MyPage;

import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JComboBox;
import java.awt.Font;

import javax.swing.DefaultCellEditor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ListSelectionModel;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Product_Search {

	private JFrame frame;
	private JLabel lblUserImage;
	private JComboBox cbProductSearch;
	private JTextField tfProductSearch;
	private JButton btnProductSearch;
	private JLabel lblShopLogo;
	private JLabel lblTitleOfSearch;
	private JLabel lblShopImage;
	private JLabel lblWelcome;
	private JLabel lblUserType;
	private JButton btnLogout;
	private JScrollPane scrollPane;
	private JTable innerTableProductSearch;
	private JButton btnCart;
	private JButton btnPutCart;
	
	
	// --- Table ----
	private final DefaultTableModel outerTable = new DefaultTableModel();
	
	
//	// --- File 정리 ----
//	ArrayList<Product_Search_Dto> dtoList = null;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Product_Search window = new Product_Search();
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
	public Product_Search() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				tableInit();
				searchAction();
			}
//			@Override
//			public void windowClosing(WindowEvent e) {
//				closingAction();
//			}
		});
		frame.getContentPane().setBackground(new Color(0, 0, 0));
		frame.setTitle("제품 검색");
		frame.setBounds(100, 100, 1100, 780);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(getLblUserImage());
		frame.getContentPane().add(getCbProductSearch());
		frame.getContentPane().add(getTfProductSearch());
		frame.getContentPane().add(getBtnProductSearch());
		frame.getContentPane().add(getLblShopLogo());
		frame.getContentPane().add(getLblTitleOfSearch());
		frame.getContentPane().add(getLblShopImage());
		frame.getContentPane().add(getLblWelcome());
		frame.getContentPane().add(getLblUserType());
		frame.getContentPane().add(getBtnLogout());
		frame.getContentPane().add(getScrollPane());
		frame.getContentPane().add(getBtnCart());
		frame.getContentPane().add(getBtnPutCart());
	}
	private JLabel getLblUserImage() {
		if (lblUserImage == null) {
			lblUserImage = new JLabel("");
			lblUserImage.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if(e.getButton() == 1) {
						mypageScreen();
					}
				}
			});
			lblUserImage.setToolTipText("<html><font face='맑은 고딕' size='5'><b>마이페이지로 이동합니다.</b></font></html>");
			lblUserImage.setIcon(new ImageIcon(Product_Search.class.getResource("/com/javalec/images/원모양_사용자.gif")));
			lblUserImage.setHorizontalAlignment(SwingConstants.CENTER);
			lblUserImage.setBounds(1026, 20, 48, 48);
		}
		return lblUserImage;
	}
	private JComboBox getCbProductSearch() {
		if (cbProductSearch == null) {
			cbProductSearch = new JComboBox();
			cbProductSearch.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					tableInit();
				}
			});
			cbProductSearch.setBackground(new Color(153, 255, 255));
			cbProductSearch.setModel(new DefaultComboBoxModel(new String[] {"제품명", "제조사", "제품번호", "색상", "사이즈"}));
			cbProductSearch.setFont(new Font("맑은 고딕", Font.BOLD, 20));
			cbProductSearch.setBounds(100, 140, 150, 40);
		}
		return cbProductSearch;
	}
	private JTextField getTfProductSearch() {
		if (tfProductSearch == null) {
			tfProductSearch = new JTextField();
			tfProductSearch.setFont(new Font("맑은 고딕", Font.BOLD, 20));
			tfProductSearch.setBounds(260, 140, 550, 40);
			tfProductSearch.setColumns(10);
		}
		return tfProductSearch;
	}
	private JButton getBtnProductSearch() {
		if (btnProductSearch == null) {
			btnProductSearch = new JButton("검색");
			btnProductSearch.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					conditionSearch();
				}
			});
			btnProductSearch.setBackground(new Color(191, 255, 128));
			btnProductSearch.setFont(new Font("맑은 고딕", Font.BOLD, 25));
			btnProductSearch.setBounds(830, 140, 170, 40);
		}
		return btnProductSearch;
	}
	private JLabel getLblShopLogo() {
		if (lblShopLogo == null) {
			lblShopLogo = new JLabel("");
			lblShopLogo.setIcon(new ImageIcon(Product_Search.class.getResource("/com/javalec/images/로고.png")));
			lblShopLogo.setForeground(new Color(0, 0, 0));
			lblShopLogo.setFont(new Font("Comic Sans MS", Font.BOLD, 50));
			lblShopLogo.setBounds(90, 15, 251, 106);
		}
		return lblShopLogo;
	}
	private JLabel getLblTitleOfSearch() {
		if (lblTitleOfSearch == null) {
			lblTitleOfSearch = new JLabel("제품 검색");
			lblTitleOfSearch.setForeground(new Color(240, 164, 249));
			lblTitleOfSearch.setFont(new Font("나눔고딕", Font.BOLD | Font.ITALIC, 35));
			lblTitleOfSearch.setBounds(350, 30, 200, 80);
		}
		return lblTitleOfSearch;
	}
	private JLabel getLblShopImage() {
		if (lblShopImage == null) {
			lblShopImage = new JLabel("");
			lblShopImage.setIcon(new ImageIcon(Product_Search.class.getResource("/com/javalec/images/가게.gif")));
			lblShopImage.setBounds(28, 45, 50, 50);
		}
		return lblShopImage;
	}
	private JLabel getLblWelcome() {
		if (lblWelcome == null) {
			lblWelcome = new JLabel("님 환영합니다~♡");
			lblWelcome.setForeground(new Color(255, 255, 255));
			lblWelcome.setFont(new Font("맑은 고딕", Font.BOLD, 13));
			lblWelcome.setBounds(905, 9, 110, 30);
		}
		return lblWelcome;
	}
	private JLabel getLblUserType() {
		if (lblUserType == null) {
			lblUserType = new JLabel("JOJO");
			lblUserType.setForeground(new Color(255, 255, 255));
			lblUserType.setHorizontalAlignment(SwingConstants.TRAILING);
			lblUserType.setFont(new Font("맑은 고딕", Font.BOLD, 18));
			lblUserType.setBounds(750, 2, 150, 40);
		}
		return lblUserType;
	}
	private JButton getBtnLogout() {
		if (btnLogout == null) {
			btnLogout = new JButton("로그아웃");
			btnLogout.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					homeScreen();
				}
			});
			btnLogout.setFont(new Font("맑은 고딕", Font.BOLD, 12));
			btnLogout.setBackground(new Color(255, 128, 128));
			btnLogout.setBounds(920, 43, 90, 25);
		}
		return btnLogout;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(100, 200, 900, 400);
			scrollPane.setViewportView(getInnerTableProductSearch());
		}
		return scrollPane;
	}
	private JTable getInnerTableProductSearch() {
		if (innerTableProductSearch == null) {
			innerTableProductSearch = new JTable();
//			{
//				public Class getColumnClass(int column) {
//					return (column == 0) ? Icon.class : Object.class;
//				}
//			};
			innerTableProductSearch.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if(e.getButton() == 1) {
						tableClick();
					}
				}
			});
			innerTableProductSearch.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
			innerTableProductSearch.setFont(new Font("맑은 고딕", Font.BOLD, 15));
			innerTableProductSearch.setRowHeight(100);	// Cell 행 높이 지정하기.
			innerTableProductSearch.setModel(outerTable);
		}
		return innerTableProductSearch;
	}
	private JButton getBtnCart() {
		if (btnCart == null) {
			btnCart = new JButton(" 장바구니로 이동");
			btnCart.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					cartScreen();
				}
			});
			btnCart.setIcon(new ImageIcon(Product_Search.class.getResource("/com/javalec/images/쇼핑카트.gif")));
			btnCart.setFont(new Font("맑은 고딕", Font.BOLD, 20));
			btnCart.setBounds(600, 630, 250, 70);
		}
		return btnCart;
	}
	
	private JButton getBtnPutCart() {
		if (btnPutCart == null) {
			btnPutCart = new JButton(" 장바구니에 담기");
			btnPutCart.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			btnPutCart.setIcon(new ImageIcon(Product_Search.class.getResource("/com/javalec/images/쇼핑카트.gif")));
			btnPutCart.setFont(new Font("맑은 고딕", Font.BOLD, 20));
			btnPutCart.setBounds(250, 630, 250, 70);
		}
		return btnPutCart;
	}
	
	
	// --- Functions ----
	// Talbe 초기화 하기
	private void tableInit() {
		// Table Column명 정하기
//		outerTable.addColumn("제품사진");
		outerTable.addColumn("제품번호");
		outerTable.addColumn("제조사");
		outerTable.addColumn("제품명");
		outerTable.addColumn("색상");
		outerTable.addColumn("크기");
		outerTable.addColumn("구매 수량");
//		outerTable.addColumn("");
		outerTable.setColumnCount(6);
		
		
		// Table Column 크기 정하기
//		// 제품사진
//		int colNo = 0;
//		TableColumn col = innerTableProductSearch.getColumnModel().getColumn(colNo);
//		int width = 300;
//		col.setPreferredWidth(width);
		
		// 제품번호
		int colNo = 0;
		TableColumn col = innerTableProductSearch.getColumnModel().getColumn(colNo);
		int width = 70;
		col.setPreferredWidth(width);
		
		// 제조사
		colNo = 1;
		col = innerTableProductSearch.getColumnModel().getColumn(colNo);
		width = 100;
		col.setPreferredWidth(width);
		
		// 제품명
		colNo = 2;
		col = innerTableProductSearch.getColumnModel().getColumn(colNo);
		width = 150;
		col.setPreferredWidth(width);
		
		// 색상
		colNo = 3;
		col = innerTableProductSearch.getColumnModel().getColumn(colNo);
		width = 100;
		col.setPreferredWidth(width);
		
		// 크기
		colNo = 4;
		col = innerTableProductSearch.getColumnModel().getColumn(colNo);
		width = 100;
		col.setPreferredWidth(width);
		
		// 구매수량
		colNo = 5;
		col = innerTableProductSearch.getColumnModel().getColumn(colNo);
		width = 100;
		col.setPreferredWidth(width);
		
//		// 체크박스
//		colNo = 6;
//		col = innerTableProductSearch.getColumnModel().getColumn(colNo);
//		width = 50;
//		col.setPreferredWidth(width);
//		col.setCellRenderer(new MyDefaultTableCellRenderer());
		
		innerTableProductSearch.setAutoResizeMode(innerTableProductSearch.AUTO_RESIZE_ALL_COLUMNS);
		
		// Table 내용 지우기
		int i = outerTable.getRowCount();
		for(int j = 0; j < i; j++) {
			outerTable.removeRow(0);
		}
		
		
	}
	
	
	// 검색
	private void searchAction() {
		Product_Search_Dao dao = new Product_Search_Dao();
		ArrayList<Product_Search_Dto> dtoList = dao.selectList();
		
		int listCount = dtoList.size();
		
		for(int i=0; i<listCount; i++) {
			String temp = Integer.toString(dtoList.get(i).getStosize());
			
			String[] qTxt = {dtoList.get(i).getModelnum(),
							 dtoList.get(i).getBrand(),
					 		 dtoList.get(i).getModelname(),
					 		 dtoList.get(i).getColor(),
					 		 temp};
			
//			// Image를 DB에서 불러와서 Table에 표시하기.
//			ImageIcon icon = new ImageIcon("./" + dtoList.get(i).getFilename());
//			Object[] qTxt = {icon,
//							 dtoList.get(i).getBrand(),
//							 dtoList.get(i).getModelname(),
//							 dtoList.get(i).getColor(),
//							 temp};
			
			outerTable.addRow(qTxt);
		}
		
		
		// Table Column별 정렬하기.
		// Table Column(Cell) 가운데 정렬
		DefaultTableCellRenderer center = new DefaultTableCellRenderer();
		center.setHorizontalAlignment(SwingConstants.CENTER);
		
		TableColumnModel tcm = innerTableProductSearch.getColumnModel();
		
		// 특정 Column(Cell) 가운데 정렬
		tcm.getColumn(0).setCellRenderer(center);
		tcm.getColumn(1).setCellRenderer(center);
		tcm.getColumn(2).setCellRenderer(center);
		tcm.getColumn(3).setCellRenderer(center);
		tcm.getColumn(4).setCellRenderer(center);
		
//		// Table Column(Cell) 우측 정렬
//		DefaultTableCellRenderer right = new DefaultTableCellRenderer();
//		right.setHorizontalAlignment(SwingConstants.RIGHT);
//		
//		// 특정 Column(Cell) 우측 정렬
//		tcm.getColumn(4).setCellRenderer(right);
//		tcm.getColumn(5).setCellRenderer(right);
		
//		// Table 여섯 번째 Column에 체크박스 추가하기.
//		innerTableProductSearch.getColumnModel().getColumn(6).setCellRenderer(new MyDefaultTableCellRenderer());
//		innerTableProductSearch.getColumnModel().getColumn(6).setCellEditor(new DefaultCellEditor(new JCheckBox()));
//		
////		DefaultTableCellRenderer renderer = new MyDefaultTableCellRenderer();
////		innerTableProductSearch.getColumn("").setCellRenderer(renderer);
////		
////		innerTableProductSearch.getColumnModel().getColumn(6).setCellEditor(new DefaultCellEditor(new JCheckBox()));
		
		
		
	}
	
	
//	// Image 처리하기 : filename이 틀려야 보여주기가 가능하다.
//	private void closingAction() {
//		
//		for(int i=0; i<dtoList.size(); i++) {
//			File file = new File("./" + dtoList.get(i).getFilename());
//			file.delete();
//		}
//	}
	
	
	// Table 내 검색 조건 분류한다.
	private void conditionSearch() {
		int i = cbProductSearch.getSelectedIndex();
		String conditionSearchName = "";
		
		switch(i) {
		case 0:
			conditionSearchName = "modelname";
			break;
		case 1:
			conditionSearchName = "brand";
			break;
		case 2:
			conditionSearchName = "modelnum";
			break;
		case 3:
			conditionSearchName = "color";
			break;
		case 4:
			conditionSearchName = "stosize";
			break;
		default:
			break;
		}
		
		tableInit();
		conditionSearchAction(conditionSearchName);
		
		
	}
	
	
	// Table 내 조건별 Data를 검색한다.
	private void conditionSearchAction(String conditionSearchName) {
		String searchName = conditionSearchName;
		String searchText = tfProductSearch.getText();
		DefaultTableModel table = outerTable;
		
		Product_Search_Dao dao = new Product_Search_Dao(searchName, searchText, table);
		dao.conditionSearchAction();
		
		// Cell 내용 정렬하기.
		DefaultTableCellRenderer center = new DefaultTableCellRenderer();
		center.setHorizontalAlignment(SwingConstants.CENTER);
		
		TableColumnModel tcm = innerTableProductSearch.getColumnModel();
		
		tcm.getColumn(0).setCellRenderer(center);
		tcm.getColumn(1).setCellRenderer(center);
		tcm.getColumn(2).setCellRenderer(center);
		tcm.getColumn(3).setCellRenderer(center);
		
		DefaultTableCellRenderer right = new DefaultTableCellRenderer();
		right.setHorizontalAlignment(SwingConstants.RIGHT);
		
		tcm.getColumn(4).setCellRenderer(right);
		tcm.getColumn(5).setCellRenderer(right);
		
		
	}
	
	
	// Table에서 Row를 Click 했을 경우
	private void tableClick() {
		int i = innerTableProductSearch.getSelectedRow();
		String wkModelnum = (String) innerTableProductSearch.getValueAt(i, 0);
		
		// Product_Search_Dao 클래스의 생성자를 통해 값을 전달
		Product_Search_Dao dao = new Product_Search_Dao(wkModelnum);
		Product_Search_Dto dto = dao.tableClick();
		
		// 전달받은 값 사용
	    String modelnum = dto.getModelnum();
		
		detailedScreen();
	}
	
	
	// 첫 화면(Home)으로 돌아가기
	private void homeScreen() {
		Main window = new Main();
		window.main(null);
		frame.setVisible(false);
	}
	
	
	// 제품 상세 내용 화면으로 이동하기
	private void detailedScreen() {
		Product_Detailed window = new Product_Detailed();
		window.main(null);
		frame.setVisible(false);
		
		
	}
	
	
	// 장바구니 화면으로 이동하기
	private void cartScreen() {
		Shop_Cart window = new Shop_Cart();
		window.main(null);
		frame.setVisible(false);
	}
	
	
	// 마이페이지 화면으로 돌아가기
	private void mypageScreen() {
		MyPage window = new MyPage();
		window.main(null);
		frame.setVisible(false);
	}
	
	
	
	
	
	
	
}	// End
