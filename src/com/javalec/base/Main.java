package com.javalec.base;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.javalec.common.ShareVar;
import com.javalec.daegeun.Account;
import com.javalec.daegeun.AdminDao;
import com.javalec.daegeun.Sign;
import com.javalec.daegeun.SignLoginDao;
import com.javalec.gwangyeong.Product_Search;

public class Main {

	private JFrame frame;
	private JLabel lblLogo;
	private JButton btnSign;
	private JRadioButton rdbCust;
	private JRadioButton rdbAdmin;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_1_1;
	private JButton btnLogin;
	private JTextField tfId;
	private JPasswordField pfPassword;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JCheckBox chbShow;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_3_1;
	private JLabel lblNewLabel_3_1_1;
	private JLabel lblNewLabel_3_1_1_1;
	private JLabel lblNewLabel_3_1_1_1_1;
	private JLabel lblNewLabel_3_1_1_1_1_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
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
	public Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(7, 7, 7));
		frame.setTitle("로그인");
		frame.setBounds(500, 100 , 485, 612);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(getLblLogo());
		frame.getContentPane().add(getBtnSign());
		frame.getContentPane().add(getRdbCust());
		frame.getContentPane().add(getRdbAdmin());
		frame.getContentPane().add(getLblNewLabel_1());
		frame.getContentPane().add(getLblNewLabel_1_1());
		frame.getContentPane().add(getBtnLogin());
		frame.getContentPane().add(getTfId());
		frame.getContentPane().add(getPfPassword());
		frame.getContentPane().add(getChbShow());
		frame.getContentPane().add(getLblNewLabel());
		frame.getContentPane().add(getLblNewLabel_2());
		frame.getContentPane().add(getLblNewLabel_3());
		frame.getContentPane().add(getLblNewLabel_3_1());
		frame.getContentPane().add(getLblNewLabel_3_1_1());
		frame.getContentPane().add(getLblNewLabel_3_1_1_1());
		frame.getContentPane().add(getLblNewLabel_3_1_1_1_1());
		frame.getContentPane().add(getLblNewLabel_3_1_1_1_1_1());
	}

	private JLabel getLblLogo() {
		if (lblLogo == null) {
			lblLogo = new JLabel("");
			lblLogo.setToolTipText("메인화면으로 이동합니다");
			lblLogo.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if (e.getButton() == 1) {
						homeScreen();
					}
				}
			});
			lblLogo.setIcon(new ImageIcon(Main.class.getResource("/com/javalec/images/로고.png")));
			lblLogo.setBounds(124, 10, 236, 129);
		}
		return lblLogo;
	}

	private JButton getBtnSign() {
		if (btnSign == null) {
			btnSign = new JButton("회원가입");
			btnSign.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					signAction();
				}
			});
			btnSign.setBounds(67, 333, 124, 53);
		}
		return btnSign;
	}

	private JRadioButton getRdbCust() {
		if (rdbCust == null) {
			rdbCust = new JRadioButton("회원");
			rdbCust.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					actionPartition();
				}
			});
			rdbCust.setSelected(true);
			buttonGroup.add(rdbCust);
			rdbCust.setForeground(new Color(255, 255, 255));
			rdbCust.setBackground(new Color(7, 7, 7));
			rdbCust.setBounds(155, 145, 54, 23);
		}
		return rdbCust;
	}

	private JRadioButton getRdbAdmin() {
		if (rdbAdmin == null) {
			rdbAdmin = new JRadioButton("관리자");
			rdbAdmin.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					actionPartition();
				}
			});
			buttonGroup.add(rdbAdmin);
			rdbAdmin.setForeground(Color.WHITE);
			rdbAdmin.setBackground(new Color(7, 7, 7));
			rdbAdmin.setBounds(267, 145, 76, 23);
		}
		return rdbAdmin;
	}

	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("ID : ");
			lblNewLabel_1.setHorizontalAlignment(SwingConstants.TRAILING);
			lblNewLabel_1.setForeground(new Color(255, 255, 255));
			lblNewLabel_1.setBounds(111, 193, 33, 34);
		}
		return lblNewLabel_1;
	}

	private JLabel getLblNewLabel_1_1() {
		if (lblNewLabel_1_1 == null) {
			lblNewLabel_1_1 = new JLabel("PW : ");
			lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.TRAILING);
			lblNewLabel_1_1.setForeground(Color.WHITE);
			lblNewLabel_1_1.setBounds(111, 249, 33, 34);
		}
		return lblNewLabel_1_1;
	}

	private JButton getBtnLogin() {
		if (btnLogin == null) {
			btnLogin = new JButton("로그인");
			btnLogin.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					loginAction();
				}
			});
			btnLogin.setBounds(274, 333, 124, 53);
		}
		return btnLogin;
	}

	private JTextField getTfId() {
		if (tfId == null) {
			tfId = new JTextField();
			tfId.addKeyListener(new KeyAdapter() {
				@Override
				public void keyPressed(KeyEvent e) {
					char specialKey = e.getKeyChar();
					if (specialCharacter(specialKey)) {
						JOptionPane.showMessageDialog(null, "ID에 특수문자는 안됩니다.", "경고", JOptionPane.ERROR_MESSAGE);
						tfId.setText("");
					} else if (e.getKeyCode() == KeyEvent.VK_ENTER) {
						pfPassword.requestFocus();
					}
				}
			});
			tfId.setBounds(163, 194, 184, 34);
			tfId.setColumns(10);
		}
		return tfId;
	}

	private JPasswordField getPfPassword() {
		if (pfPassword == null) {
			pfPassword = new JPasswordField();
			pfPassword.addKeyListener(new KeyAdapter() {
				@Override
				public void keyPressed(KeyEvent e) {
					if (e.getKeyCode() == KeyEvent.VK_ENTER) {
						loginAction();
					}
				}
			});
			pfPassword.setBounds(163, 249, 184, 34);
		}
		return pfPassword;
	}

	private JCheckBox getChbShow() {
		if (chbShow == null) {
			chbShow = new JCheckBox("비밀번호 표시");
			chbShow.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					checkPassword();
				}
			});
			chbShow.setBackground(new Color(7, 7, 7));
			chbShow.setForeground(new Color(255, 255, 255));
			chbShow.setBounds(162, 292, 107, 23);
		}
		return chbShow;
	}

	// --------- Functions ----------
	private void checkPassword() {
		if (chbShow.isSelected()) {
			pfPassword.setEchoChar((char) 0); // 비밀번호 표시
		} else {
			pfPassword.setEchoChar('\u2022'); // 비밀번호 숨김
		}
	}

	private void homeScreen() {
		this.frame.setVisible(false); // 현재화면 끄고
		Main window = new Main();
		window.frame.setVisible(true); // 홈 화면 키기
	}

	private void loginAction() {
		// 입력 안했을시 어디를 안했는지 체크 받기
		int check = inputCheck();

		String id1 = tfId.getText();
		char[] charcustpw = pfPassword.getPassword();
		String pw1 = new String(charcustpw);
		
		// 입력을 안했을시 공지 또는 빈칸
		if (check != 0 || (id1.equals("") && (pw1.equals("")))) {
			JOptionPane.showMessageDialog(null, "항목을 입력 하세요.");
			tfId.setText("");
			pfPassword.setText("");
			tfId.requestFocus();
		} else {
			if (rdbCust.isSelected() == true) {

				SignLoginDao signLoginDao = new SignLoginDao();
				boolean result = signLoginDao.loginCheckAction(id1, pw1); // 로그인 성공 여부 확인

				if (result) {
					// 로그인 성공시
					ShareVar.loginID = id1;
					frame.setVisible(false);
					Product_Search ps = new Product_Search();
					ps.main(null);
				} else {
					// 로그인 실패 시
					JOptionPane.showMessageDialog(null, "정보가 잘못 입력되었습니다. 다시 입력하여 주세요.");
					tfId.setText("");
					pfPassword.setText("");
					tfId.requestFocus();
				}
			}
			if (rdbAdmin.isSelected() == true) {

				AdminDao adminDao = new AdminDao();
				boolean result = adminDao.loginCheckAction(id1, pw1); // 로그인 성공 여부 확인

				if (result) {
					// 로그인 성공시
					ShareVar.loginID = id1; 
					frame.setVisible(false);
					Account account = new Account();
					account.setVisible(true);
				} else {
					// 로그인 실패 시
					JOptionPane.showMessageDialog(null, "정보가 잘못 입력되었습니다. 다시 입력하여 주세요.");
					tfId.setText("");
					pfPassword.setText("");
					tfId.requestFocus();
				}
			}
		}
	}

	private int inputCheck() {
		int checkResult = 0;
		char[] passwordChars = pfPassword.getPassword();

		if (tfId.getText().trim().length() == 0) { // ID에 입력 안했을 때
			checkResult++;
			tfId.requestFocus();
		}
		if (passwordChars.length == 0) { // PW에 입력 안했을 때
			checkResult++;
			pfPassword.requestFocus();
		}

		return checkResult;
	}

	private boolean specialCharacter(char specialKey) {
		// ID에 특수 문자 체크
		return "!@#$%^&*()-_=+`~/?,.<>{}[];:|\"'\\".indexOf(specialKey) != -1;
	}

	// 회원가입 시
	private void signAction() {
		frame.setVisible(false);
		Sign sign = new Sign();
		sign.setVisible(true);
	}

	private void actionPartition() {
		if (rdbCust.isSelected() == true) {
			screenPartition();
		}

		if (rdbAdmin.isSelected() == true) {
			screenPartition();
		}
	}

	// 회원과 관리자 화면 바꿔주기
	private void screenPartition() {
		if (rdbCust.isSelected() == true) {
			frame.getContentPane().setBackground(new Color(7, 7, 7));
			rdbCust.setBackground(new Color(7, 7, 7));
			rdbAdmin.setBackground(new Color(7, 7, 7));
			chbShow.setBackground(new Color(7, 7, 7));
			btnSign.setVisible(true);
		}

		if (rdbAdmin.isSelected() == true) {
			frame.getContentPane().setBackground(new Color(119, 108, 106));
			rdbCust.setBackground(new Color(119, 108, 106));
			rdbAdmin.setBackground(new Color(119, 108, 106));
			chbShow.setBackground(new Color(119, 108, 106));
			btnSign.setVisible(false);
		}
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("CS CENTER");
			lblNewLabel.setFont(new Font("굴림", Font.BOLD, 12));
			lblNewLabel.setForeground(new Color(192, 192, 192));
			lblNewLabel.setBounds(32, 402, 76, 23);
		}
		return lblNewLabel;
	}
	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("1234-5678");
			lblNewLabel_2.setFont(new Font("맑은 고딕", Font.BOLD, 17));
			lblNewLabel_2.setForeground(Color.LIGHT_GRAY);
			lblNewLabel_2.setBounds(32, 426, 110, 23);
		}
		return lblNewLabel_2;
	}
	private JLabel getLblNewLabel_3() {
		if (lblNewLabel_3 == null) {
			lblNewLabel_3 = new JLabel("(주)유신사    |");
			lblNewLabel_3.setForeground(new Color(192, 192, 192));
			lblNewLabel_3.setBounds(32, 459, 83, 23);
		}
		return lblNewLabel_3;
	}
	private JLabel getLblNewLabel_3_1() {
		if (lblNewLabel_3_1 == null) {
			lblNewLabel_3_1 = new JLabel("대표 : 3조   |");
			lblNewLabel_3_1.setForeground(Color.LIGHT_GRAY);
			lblNewLabel_3_1.setBounds(124, 459, 76, 23);
		}
		return lblNewLabel_3_1;
	}
	private JLabel getLblNewLabel_3_1_1() {
		if (lblNewLabel_3_1_1 == null) {
			lblNewLabel_3_1_1 = new JLabel("이메일 : usinsa@usinsa.com");
			lblNewLabel_3_1_1.setForeground(Color.LIGHT_GRAY);
			lblNewLabel_3_1_1.setBounds(210, 459, 174, 23);
		}
		return lblNewLabel_3_1_1;
	}
	private JLabel getLblNewLabel_3_1_1_1() {
		if (lblNewLabel_3_1_1_1 == null) {
			lblNewLabel_3_1_1_1 = new JLabel("주소 : 서울 특별시 강남구 한국빌딩 4층(유신사)");
			lblNewLabel_3_1_1_1.setForeground(Color.LIGHT_GRAY);
			lblNewLabel_3_1_1_1.setBounds(32, 480, 269, 23);
		}
		return lblNewLabel_3_1_1_1;
	}
	private JLabel getLblNewLabel_3_1_1_1_1() {
		if (lblNewLabel_3_1_1_1_1 == null) {
			lblNewLabel_3_1_1_1_1 = new JLabel("사업자등록번호 : 1234567890");
			lblNewLabel_3_1_1_1_1.setForeground(Color.LIGHT_GRAY);
			lblNewLabel_3_1_1_1_1.setBounds(32, 502, 167, 23);
		}
		return lblNewLabel_3_1_1_1_1;
	}
	private JLabel getLblNewLabel_3_1_1_1_1_1() {
		if (lblNewLabel_3_1_1_1_1_1 == null) {
			lblNewLabel_3_1_1_1_1_1 = new JLabel("copyright. 유신사. all rights reserved. Designed by gerrard");
			lblNewLabel_3_1_1_1_1_1.setForeground(Color.LIGHT_GRAY);
			lblNewLabel_3_1_1_1_1_1.setBounds(32, 544, 343, 23);
		}
		return lblNewLabel_3_1_1_1_1_1;
	}
} // End
