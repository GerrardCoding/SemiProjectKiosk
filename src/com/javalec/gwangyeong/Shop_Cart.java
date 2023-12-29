/* 장바구니 Page - by. 광영 */

package com.javalec.gwangyeong;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.JTextField;

public class Shop_Cart {

	private JFrame frame;
	private JLabel lblShopImage;
	private JLabel lblShopLogo;
	private JLabel lblTitleOfCart;
	private JLabel lblUserType;
	private JLabel lblWelcome;
	private JLabel lblUserImage;
	private JButton btnLogout;
	private JScrollPane scrollPane;
	private JTable innerTableCart;
	private JButton btnCartUpdate;
	private JButton btnCartDelete;
	private JButton btnCharge;
	private JLabel lblPurchaseQTY;
	private JTextField tfPurchaseQTY;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Shop_Cart window = new Shop_Cart();
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
	public Shop_Cart() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.BLACK);
		frame.setTitle("장바구니");
		frame.setBounds(100, 100, 1100, 780);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(getLblShopImage());
		frame.getContentPane().add(getLblShopLogo());
		frame.getContentPane().add(getLblTitleOfCart());
		frame.getContentPane().add(getLblUserType());
		frame.getContentPane().add(getLblWelcome());
		frame.getContentPane().add(getLblUserImage());
		frame.getContentPane().add(getBtnLogout());
		frame.getContentPane().add(getScrollPane());
		frame.getContentPane().add(getBtnCartUpdate());
		frame.getContentPane().add(getBtnCartDelete());
		frame.getContentPane().add(getBtnCharge());
		frame.getContentPane().add(getLblPurchaseQTY());
		frame.getContentPane().add(getTfPurchaseQTY());
	}

	private JLabel getLblShopImage() {
		if (lblShopImage == null) {
			lblShopImage = new JLabel("");
			lblShopImage.setIcon(new ImageIcon(Shop_Cart.class.getResource("/com/javalec/images/장바구니.gif")));
			lblShopImage.setBounds(28, 45, 50, 50);
		}
		return lblShopImage;
	}
	private JLabel getLblShopLogo() {
		if (lblShopLogo == null) {
			lblShopLogo = new JLabel("");
			lblShopLogo.setIcon(new ImageIcon(Shop_Cart.class.getResource("/com/javalec/images/로고.png")));
			lblShopLogo.setBounds(90, 15, 251, 106);
		}
		return lblShopLogo;
	}
	private JLabel getLblTitleOfCart() {
		if (lblTitleOfCart == null) {
			lblTitleOfCart = new JLabel("장바구니");
			lblTitleOfCart.setForeground(new Color(240, 164, 249));
			lblTitleOfCart.setFont(new Font("나눔고딕", Font.BOLD | Font.ITALIC, 35));
			lblTitleOfCart.setBounds(350, 30, 200, 80);
		}
		return lblTitleOfCart;
	}
	private JLabel getLblUserType() {
		if (lblUserType == null) {
			lblUserType = new JLabel("다오니");
			lblUserType.setForeground(Color.WHITE);
			lblUserType.setHorizontalAlignment(SwingConstants.TRAILING);
			lblUserType.setFont(new Font("맑은 고딕", Font.BOLD, 18));
			lblUserType.setBounds(750, 2, 150, 40);
		}
		return lblUserType;
	}
	private JLabel getLblWelcome() {
		if (lblWelcome == null) {
			lblWelcome = new JLabel("님 환영합니다~♡");
			lblWelcome.setForeground(Color.WHITE);
			lblWelcome.setFont(new Font("맑은 고딕", Font.BOLD, 13));
			lblWelcome.setBounds(905, 9, 110, 30);
		}
		return lblWelcome;
	}
	private JLabel getLblUserImage() {
		if (lblUserImage == null) {
			lblUserImage = new JLabel("");
			lblUserImage.setIcon(new ImageIcon(Shop_Cart.class.getResource("/com/javalec/images/원모양_사용자.gif")));
			lblUserImage.setBounds(1026, 20, 48, 48);
		}
		return lblUserImage;
	}
	private JButton getBtnLogout() {
		if (btnLogout == null) {
			btnLogout = new JButton("로그아웃");
			btnLogout.setBackground(new Color(255, 128, 128));
			btnLogout.setFont(new Font("맑은 고딕", Font.BOLD, 12));
			btnLogout.setBounds(920, 43, 90, 25);
		}
		return btnLogout;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(50, 150, 990, 390);
			scrollPane.setViewportView(getInnerTableCart());
		}
		return scrollPane;
	}
	private JTable getInnerTableCart() {
		if (innerTableCart == null) {
			innerTableCart = new JTable();
			innerTableCart.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
			innerTableCart.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		}
		return innerTableCart;
	}
	private JButton getBtnCartUpdate() {
		if (btnCartUpdate == null) {
			btnCartUpdate = new JButton("수정");
			btnCartUpdate.setFont(new Font("맑은 고딕", Font.BOLD, 20));
			btnCartUpdate.setBounds(820, 550, 100, 30);
		}
		return btnCartUpdate;
	}
	private JButton getBtnCartDelete() {
		if (btnCartDelete == null) {
			btnCartDelete = new JButton("삭제");
			btnCartDelete.setBackground(new Color(255, 51, 102));
			btnCartDelete.setFont(new Font("맑은 고딕", Font.BOLD, 20));
			btnCartDelete.setBounds(940, 550, 100, 30);
		}
		return btnCartDelete;
	}
	private JButton getBtnCharge() {
		if (btnCharge == null) {
			btnCharge = new JButton(" 결제하기");
			btnCharge.setBackground(new Color(255, 255, 102));
			btnCharge.setFont(new Font("맑은 고딕", Font.BOLD, 30));
			btnCharge.setIcon(new ImageIcon(Shop_Cart.class.getResource("/com/javalec/images/지갑_결제.gif")));
			btnCharge.setBounds(385, 620, 330, 80);
		}
		return btnCharge;
	}
	private JLabel getLblPurchaseQTY() {
		if (lblPurchaseQTY == null) {
			lblPurchaseQTY = new JLabel("구매 수량");
			lblPurchaseQTY.setFont(new Font("맑은 고딕", Font.BOLD, 20));
			lblPurchaseQTY.setForeground(Color.YELLOW);
			lblPurchaseQTY.setBounds(50, 550, 100, 40);
		}
		return lblPurchaseQTY;
	}
	private JTextField getTfPurchaseQTY() {
		if (tfPurchaseQTY == null) {
			tfPurchaseQTY = new JTextField();
			tfPurchaseQTY.setHorizontalAlignment(SwingConstants.TRAILING);
			tfPurchaseQTY.setBounds(164, 551, 120, 40);
			tfPurchaseQTY.setColumns(10);
		}
		return tfPurchaseQTY;
	}
}
