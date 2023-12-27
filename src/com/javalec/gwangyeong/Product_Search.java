package com.javalec.gwangyeong;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JComboBox;
import java.awt.Font;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ListSelectionModel;
import javax.swing.JPanel;
import java.awt.GridLayout;

public class Product_Search {

	private JFrame frame;
	private JLabel lblNewLabel;
	private JComboBox comboBox;
	private JTextField textField;
	private JButton btnNewButton;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_1_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_3_1;
	private JButton btnNewButton_1;
	private JScrollPane scrollPane;
	private JTable table;
	private JButton btnNewButton_2;
	private JButton btnNewButton_2_1;

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
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.setTitle("제품 검색");
		frame.setBounds(100, 100, 1100, 780);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(getLblNewLabel());
		frame.getContentPane().add(getComboBox());
		frame.getContentPane().add(getTextField());
		frame.getContentPane().add(getBtnNewButton());
		frame.getContentPane().add(getLblNewLabel_1());
		frame.getContentPane().add(getLblNewLabel_1_1());
		frame.getContentPane().add(getLblNewLabel_2());
		frame.getContentPane().add(getLblNewLabel_3());
		frame.getContentPane().add(getLblNewLabel_3_1());
		frame.getContentPane().add(getBtnNewButton_1());
		frame.getContentPane().add(getScrollPane_1());
		frame.getContentPane().add(getBtnNewButton_2());
		frame.getContentPane().add(getBtnNewButton_2_1());
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("");
			lblNewLabel.setIcon(new ImageIcon("C:\\Users\\rhkdd\\Desktop\\[231120~]빅데이터 분석&추천시스템 개발자 양성과정 (직업훈련 교육)\\과제\\[231226_세미프로젝트]USINSA - 신발가게 KIOSK\\gif 모음\\icons8-원-사용자-남성.gif"));
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setBounds(1026, 10, 48, 48);
		}
		return lblNewLabel;
	}
	private JComboBox getComboBox() {
		if (comboBox == null) {
			comboBox = new JComboBox();
			comboBox.setBackground(new Color(153, 255, 255));
			comboBox.setModel(new DefaultComboBoxModel(new String[] {"제품명", "제조사", "상품코드", "색상", "사이즈"}));
			comboBox.setFont(new Font("맑은 고딕", Font.BOLD, 20));
			comboBox.setBounds(100, 100, 150, 40);
		}
		return comboBox;
	}
	private JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.setFont(new Font("맑은 고딕", Font.BOLD, 20));
			textField.setBounds(260, 100, 550, 40);
			textField.setColumns(10);
		}
		return textField;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("검색");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			btnNewButton.setBackground(new Color(191, 255, 128));
			btnNewButton.setFont(new Font("맑은 고딕", Font.BOLD, 25));
			btnNewButton.setBounds(830, 100, 170, 40);
		}
		return btnNewButton;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("USINSA:)");
			lblNewLabel_1.setForeground(new Color(0, 0, 0));
			lblNewLabel_1.setFont(new Font("Comic Sans MS", Font.BOLD, 50));
			lblNewLabel_1.setBounds(100, 10, 260, 80);
		}
		return lblNewLabel_1;
	}
	private JLabel getLblNewLabel_1_1() {
		if (lblNewLabel_1_1 == null) {
			lblNewLabel_1_1 = new JLabel("제품 검색");
			lblNewLabel_1_1.setForeground(new Color(0, 0, 0));
			lblNewLabel_1_1.setFont(new Font("나눔고딕", Font.BOLD | Font.ITALIC, 35));
			lblNewLabel_1_1.setBounds(380, 17, 200, 80);
		}
		return lblNewLabel_1_1;
	}
	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("");
			lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\rhkdd\\Desktop\\[231120~]빅데이터 분석&추천시스템 개발자 양성과정 (직업훈련 교육)\\과제\\[231226_세미프로젝트]USINSA - 신발가게 KIOSK\\gif 모음\\icons8-가게.gif"));
			lblNewLabel_2.setBounds(38, 25, 50, 50);
		}
		return lblNewLabel_2;
	}
	private JLabel getLblNewLabel_3() {
		if (lblNewLabel_3 == null) {
			lblNewLabel_3 = new JLabel("님 환영합니다~♡");
			lblNewLabel_3.setFont(new Font("맑은 고딕", Font.BOLD, 13));
			lblNewLabel_3.setBounds(920, 9, 110, 30);
		}
		return lblNewLabel_3;
	}
	private JLabel getLblNewLabel_3_1() {
		if (lblNewLabel_3_1 == null) {
			lblNewLabel_3_1 = new JLabel("다오니");
			lblNewLabel_3_1.setHorizontalAlignment(SwingConstants.TRAILING);
			lblNewLabel_3_1.setFont(new Font("맑은 고딕", Font.BOLD, 18));
			lblNewLabel_3_1.setBounds(765, 2, 150, 40);
		}
		return lblNewLabel_3_1;
	}
	private JButton getBtnNewButton_1() {
		if (btnNewButton_1 == null) {
			btnNewButton_1 = new JButton("로그아웃");
			btnNewButton_1.setFont(new Font("맑은 고딕", Font.BOLD, 12));
			btnNewButton_1.setBackground(new Color(255, 128, 128));
			btnNewButton_1.setBounds(930, 45, 90, 25);
		}
		return btnNewButton_1;
	}
	private JScrollPane getScrollPane_1() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(100, 160, 900, 393);
			scrollPane.setViewportView(getTable_1());
		}
		return scrollPane;
	}
	private JTable getTable_1() {
		if (table == null) {
			table = new JTable();
			table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
			table.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		}
		return table;
	}
	private JButton getBtnNewButton_2() {
		if (btnNewButton_2 == null) {
			btnNewButton_2 = new JButton("장바구니로 이동");
			btnNewButton_2.setFont(new Font("맑은 고딕", Font.BOLD, 20));
			btnNewButton_2.setBounds(100, 603, 281, 65);
		}
		return btnNewButton_2;
	}
	private JButton getBtnNewButton_2_1() {
		if (btnNewButton_2_1 == null) {
			btnNewButton_2_1 = new JButton("장바구니로 이동");
			btnNewButton_2_1.setFont(new Font("맑은 고딕", Font.BOLD, 20));
			btnNewButton_2_1.setBounds(719, 603, 281, 65);
		}
		return btnNewButton_2_1;
	}
}
