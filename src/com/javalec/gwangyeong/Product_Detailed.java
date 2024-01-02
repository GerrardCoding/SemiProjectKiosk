/* 제품 상세 내용 Page - by. 광영 */

package com.javalec.gwangyeong;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.SwingConstants;

import com.javalec.base.Main;
import com.javalec.sumin.base.MyPage;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.DropMode;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Product_Detailed {

	private JFrame frame;
	private JLabel lblShopImage;
	private JLabel lblShopLogo;
	private JLabel lblTitleOfDetailed;
	private JLabel lblUserType;
	private JLabel lblWelcome;
	private JLabel lblUserImage;
	private JButton btnLogout;
	private JLabel lblProductImage;
	private JLabel lblProductName;
	private JTextField tfProductName;
	private JLabel lblProductColor;
	private JTextField tfProductColor;
	private JLabel lblProductSize;
	private JTextField tfProductSize;
	private JLabel lblProductQTY;
	private JTextField tfProductQTY;
	private JLabel lblPurchaseQTY;
	private JTextField tfPurchaseQTY;
	private JButton btnCart;
	private JLabel lblProductPrice;
	private JTextField textProductPrice;
	private JLabel lblTotalPrice;
	private JTextField textTotalPrice;
	private JLabel lblProductNum;
	private JTextField tfProductNum;
	private JLabel lblProductBrand;
	private JTextField tfProductBrand;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Product_Detailed window = new Product_Detailed();
					window.frame.setVisible(true);
					window.importAction();	// 초기에 importAction() 메소드 호출하기.
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Product_Detailed() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.BLACK);
		frame.setTitle("제품 상세 내용");
		frame.setBounds(100, 100, 1070, 780);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(getLblShopImage());
		frame.getContentPane().add(getLblShopLogo());
		frame.getContentPane().add(getLblTitleOfDetailed());
		frame.getContentPane().add(getLblUserType());
		frame.getContentPane().add(getLblWelcome());
		frame.getContentPane().add(getLblUserImage());
		frame.getContentPane().add(getBtnLogout());
		frame.getContentPane().add(getLblProductImage());
		frame.getContentPane().add(getLblProductName());
		frame.getContentPane().add(getTfProductName());
		frame.getContentPane().add(getLblProductColor());
		frame.getContentPane().add(getTfProductColor());
		frame.getContentPane().add(getLblProductSize());
		frame.getContentPane().add(getTfProductSize());
		frame.getContentPane().add(getLblProductQTY());
		frame.getContentPane().add(getTfProductQTY());
		frame.getContentPane().add(getLblPurchaseQTY());
		frame.getContentPane().add(getTfPurchaseQTY());
		frame.getContentPane().add(getBtnCart());
		frame.getContentPane().add(getLblProductPrice());
		frame.getContentPane().add(getTextProductPrice());
		frame.getContentPane().add(getLblTotalPrice());
		frame.getContentPane().add(getTextField_6_1());
		frame.getContentPane().add(getLblProductNum());
		frame.getContentPane().add(getTfProductNum());
		frame.getContentPane().add(getLblProductBrand());
		frame.getContentPane().add(getTfProductBrand());
	}

	private JLabel getLblShopImage() {
		if (lblShopImage == null) {
			lblShopImage = new JLabel("");
			lblShopImage.setIcon(new ImageIcon(Product_Detailed.class.getResource("/com/javalec/images/가게.gif")));
			lblShopImage.setBounds(28, 45, 50, 50);
		}
		return lblShopImage;
	}
	private JLabel getLblShopLogo() {
		if (lblShopLogo == null) {
			lblShopLogo = new JLabel("");
			lblShopLogo.setIcon(new ImageIcon(Product_Detailed.class.getResource("/com/javalec/images/로고.png")));
			lblShopLogo.setBounds(90, 15, 251, 106);
		}
		return lblShopLogo;
	}
	private JLabel getLblTitleOfDetailed() {
		if (lblTitleOfDetailed == null) {
			lblTitleOfDetailed = new JLabel("제품 상세 내용");
			lblTitleOfDetailed.setForeground(new Color(240, 164, 249));
			lblTitleOfDetailed.setFont(new Font("나눔고딕", Font.BOLD | Font.ITALIC, 35));
			lblTitleOfDetailed.setBounds(350, 30, 250, 80);
		}
		return lblTitleOfDetailed;
	}
	private JLabel getLblUserType() {
		if (lblUserType == null) {
			lblUserType = new JLabel("JOJO");
			lblUserType.setForeground(Color.WHITE);
			lblUserType.setFont(new Font("맑은 고딕", Font.BOLD, 18));
			lblUserType.setHorizontalAlignment(SwingConstants.TRAILING);
			lblUserType.setBounds(720, 2, 150, 40);
		}
		return lblUserType;
	}
	private JLabel getLblWelcome() {
		if (lblWelcome == null) {
			lblWelcome = new JLabel("님 환영합니다~♡");
			lblWelcome.setForeground(Color.WHITE);
			lblWelcome.setFont(new Font("맑은 고딕", Font.BOLD, 13));
			lblWelcome.setBounds(875, 9, 110, 30);
		}
		return lblWelcome;
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
			lblUserImage.setIcon(new ImageIcon(Product_Detailed.class.getResource("/com/javalec/images/원모양_사용자.gif")));
			lblUserImage.setBounds(996, 20, 48, 48);
		}
		return lblUserImage;
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
			btnLogout.setBounds(890, 43, 90, 25);
		}
		return btnLogout;
	}
	private JLabel getLblProductImage() {
		if (lblProductImage == null) {
			lblProductImage = new JLabel("");
			lblProductImage.setIcon(new ImageIcon("C:\\Users\\rhkdd\\Desktop\\[231120~]빅데이터 분석&추천시스템 개발자 양성과정 (직업훈련 교육)\\과제\\[231226_세미프로젝트]USINSA - 신발가게 KIOSK\\제품 현황\\채택 사진\\[Nike_1] Nike Air Zoom Alphafly Next% 2 - White Clear Jade.png"));
			lblProductImage.setBounds(50, 150, 510, 320);
		}
		return lblProductImage;
	}
	private JLabel getLblProductName() {
		if (lblProductName == null) {
			lblProductName = new JLabel("제품명");
			lblProductName.setForeground(Color.WHITE);
			lblProductName.setFont(new Font("맑은 고딕", Font.BOLD, 20));
			lblProductName.setBounds(580, 150, 80, 40);
		}
		return lblProductName;
	}
	private JTextField getTfProductName() {
		if (tfProductName == null) {
			tfProductName = new JTextField();
			tfProductName.setHorizontalAlignment(SwingConstants.TRAILING);
			tfProductName.setEditable(false);
			tfProductName.setFont(new Font("맑은 고딕", Font.BOLD, 20));
			tfProductName.setBounds(680, 151, 320, 40);
			tfProductName.setColumns(10);
		}
		return tfProductName;
	}
	private JLabel getLblProductColor() {
		if (lblProductColor == null) {
			lblProductColor = new JLabel("색상");
			lblProductColor.setForeground(Color.WHITE);
			lblProductColor.setFont(new Font("맑은 고딕", Font.BOLD, 20));
			lblProductColor.setBounds(580, 430, 80, 40);
		}
		return lblProductColor;
	}
	private JTextField getTfProductColor() {
		if (tfProductColor == null) {
			tfProductColor = new JTextField();
			tfProductColor.setHorizontalAlignment(SwingConstants.TRAILING);
			tfProductColor.setEditable(false);
			tfProductColor.setFont(new Font("맑은 고딕", Font.BOLD, 20));
			tfProductColor.setColumns(10);
			tfProductColor.setBounds(680, 431, 100, 40);
		}
		return tfProductColor;
	}
	private JLabel getLblProductSize() {
		if (lblProductSize == null) {
			lblProductSize = new JLabel("사이즈");
			lblProductSize.setForeground(Color.WHITE);
			lblProductSize.setFont(new Font("맑은 고딕", Font.BOLD, 20));
			lblProductSize.setBounds(580, 500, 80, 40);
		}
		return lblProductSize;
	}
	private JTextField getTfProductSize() {
		if (tfProductSize == null) {
			tfProductSize = new JTextField();
			tfProductSize.setHorizontalAlignment(SwingConstants.TRAILING);
			tfProductSize.setEditable(false);
			tfProductSize.setFont(new Font("맑은 고딕", Font.BOLD, 20));
			tfProductSize.setColumns(10);
			tfProductSize.setBounds(680, 501, 100, 40);
		}
		return tfProductSize;
	}
	private JLabel getLblProductQTY() {
		if (lblProductQTY == null) {
			lblProductQTY = new JLabel("매장 내 보유 수량");
			lblProductQTY.setForeground(Color.WHITE);
			lblProductQTY.setFont(new Font("맑은 고딕", Font.BOLD, 25));
			lblProductQTY.setBounds(50, 500, 210, 40);
		}
		return lblProductQTY;
	}
	private JTextField getTfProductQTY() {
		if (tfProductQTY == null) {
			tfProductQTY = new JTextField();
			tfProductQTY.setHorizontalAlignment(SwingConstants.TRAILING);
			tfProductQTY.setEditable(false);
			tfProductQTY.setFont(new Font("맑은 고딕", Font.BOLD, 20));
			tfProductQTY.setColumns(10);
			tfProductQTY.setBounds(280, 501, 80, 40);
		}
		return tfProductQTY;
	}
	private JLabel getLblPurchaseQTY() {
		if (lblPurchaseQTY == null) {
			lblPurchaseQTY = new JLabel("구매 필요 수량");
			lblPurchaseQTY.setForeground(Color.YELLOW);
			lblPurchaseQTY.setFont(new Font("맑은 고딕", Font.BOLD, 30));
			lblPurchaseQTY.setBounds(50, 570, 210, 40);
		}
		return lblPurchaseQTY;
	}
	private JTextField getTfPurchaseQTY() {
		if (tfPurchaseQTY == null) {
			tfPurchaseQTY = new JTextField();
			tfPurchaseQTY.setHorizontalAlignment(SwingConstants.TRAILING);
			tfPurchaseQTY.setFont(new Font("맑은 고딕", Font.BOLD, 30));
			tfPurchaseQTY.setColumns(10);
			tfPurchaseQTY.setBounds(280, 571, 80, 40);
		}
		return tfPurchaseQTY;
	}
	private JButton getBtnCart() {
		if (btnCart == null) {
			btnCart = new JButton("추가하기");
			btnCart.setBackground(new Color(204, 255, 153));
			btnCart.setFont(new Font("맑은 고딕", Font.BOLD, 30));
			btnCart.setBounds(650, 570, 300, 120);
		}
		return btnCart;
	}
	private JLabel getLblProductPrice() {
		if (lblProductPrice == null) {
			lblProductPrice = new JLabel("구매가");
			lblProductPrice.setForeground(Color.WHITE);
			lblProductPrice.setFont(new Font("맑은 고딕", Font.BOLD, 20));
			lblProductPrice.setBounds(580, 220, 80, 40);
		}
		return lblProductPrice;
	}
	private JTextField getTextProductPrice() {
		if (textProductPrice == null) {
			textProductPrice = new JTextField();
			textProductPrice.setHorizontalAlignment(SwingConstants.TRAILING);
			textProductPrice.setEditable(false);
			textProductPrice.setFont(new Font("맑은 고딕", Font.BOLD, 20));
			textProductPrice.setColumns(10);
			textProductPrice.setBounds(680, 221, 150, 40);
		}
		return textProductPrice;
	}
	private JLabel getLblTotalPrice() {
		if (lblTotalPrice == null) {
			lblTotalPrice = new JLabel("예상 구매 가격");
			lblTotalPrice.setForeground(Color.YELLOW);
			lblTotalPrice.setFont(new Font("맑은 고딕", Font.BOLD, 30));
			lblTotalPrice.setBounds(50, 640, 210, 50);
		}
		return lblTotalPrice;
	}
	private JTextField getTextField_6_1() {
		if (textTotalPrice == null) {
			textTotalPrice = new JTextField();
			textTotalPrice.setHorizontalAlignment(SwingConstants.TRAILING);
			textTotalPrice.setEditable(false);
			textTotalPrice.setForeground(Color.RED);
			textTotalPrice.setFont(new Font("맑은 고딕", Font.BOLD | Font.ITALIC, 35));
			textTotalPrice.setBounds(280, 641, 250, 50);
			textTotalPrice.setColumns(10);
		}
		return textTotalPrice;
	}
	private JLabel getLblProductNum() {
		if (lblProductNum == null) {
			lblProductNum = new JLabel("제품번호");
			lblProductNum.setForeground(Color.WHITE);
			lblProductNum.setFont(new Font("맑은 고딕", Font.BOLD, 20));
			lblProductNum.setBounds(580, 290, 80, 40);
		}
		return lblProductNum;
	}
	private JTextField getTfProductNum() {
		if (tfProductNum == null) {
			tfProductNum = new JTextField();
			tfProductNum.setHorizontalAlignment(SwingConstants.TRAILING);
			tfProductNum.setEditable(false);
			tfProductNum.setFont(new Font("맑은 고딕", Font.BOLD, 20));
			tfProductNum.setColumns(10);
			tfProductNum.setBounds(680, 291, 100, 40);
		}
		return tfProductNum;
	}
	private JLabel getLblProductBrand() {
		if (lblProductBrand == null) {
			lblProductBrand = new JLabel("제조사");
			lblProductBrand.setForeground(Color.WHITE);
			lblProductBrand.setFont(new Font("맑은 고딕", Font.BOLD, 20));
			lblProductBrand.setBounds(580, 360, 80, 40);
		}
		return lblProductBrand;
	}
	private JTextField getTfProductBrand() {
		if (tfProductBrand == null) {
			tfProductBrand = new JTextField();
			tfProductBrand.setHorizontalAlignment(SwingConstants.TRAILING);
			tfProductBrand.setEditable(false);
			tfProductBrand.setFont(new Font("맑은 고딕", Font.BOLD, 20));
			tfProductBrand.setColumns(10);
			tfProductBrand.setBounds(680, 361, 100, 40);
		}
		return tfProductBrand;
	}
	
	
	
	// --- Functions ----
	// 첫 화면(Home)으로 돌아가기
	private void homeScreen() {
		Main window = new Main();
		window.main(null);
		frame.setVisible(false);
	}
	
	
	// 마이페이지 화면으로 돌아가기
	private void mypageScreen() {
		MyPage window = new MyPage();
		window.main(null);
		frame.setVisible(false);
	}
	
	
	// Product_Search 클래스에서 불러온 값 출력하기
	private void importAction() {
		Product_Search searchpage = new Product_Search();
		
	}
	
	
	
	
	
	
}	// End
