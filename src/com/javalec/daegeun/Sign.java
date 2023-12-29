package com.javalec.daegeun;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.javalec.base.Main;

public class Sign extends JDialog {

	private static final long serialVersionUID = 1L;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JTextField tfId;
	private JLabel lblNewLabel_1_1;
	private JCheckBox chbShow;
	private JLabel lblNewLabel_1_1_1;
	private JPasswordField pfPassword1;
	private JPasswordField pfPassword2;
	private JLabel lblNewLabel_1_1_1_1;
	private JTextField tfName;
	private JLabel lblNewLabel_1_1_1_1_1;
	private JTextField tfPhone;
	private JLabel lblNewLabel_1_1_1_1_2;
	private JTextField tfAddress;
	private JButton btnSign;
	private JButton btnCancel;
	private JButton btnCheck;
	private JButton btnIdSame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Sign dialog = new Sign();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the dialog.
	 */
	public Sign() {
		getContentPane().setBackground(new Color(7, 7, 7));
		setTitle("회원가입");
		setBounds(100, 100, 502, 514);
		getContentPane().setLayout(null);
		getContentPane().add(getLblNewLabel());
		getContentPane().add(getLblNewLabel_1());
		getContentPane().add(getTfId());
		getContentPane().add(getLblNewLabel_1_1());
		getContentPane().add(getChbShow());
		getContentPane().add(getLblNewLabel_1_1_1());
		getContentPane().add(getPfPassword1());
		getContentPane().add(getPfPassword2());
		getContentPane().add(getLblNewLabel_1_1_1_1());
		getContentPane().add(getTfName());
		getContentPane().add(getLblNewLabel_1_1_1_1_1());
		getContentPane().add(getTfPhone());
		getContentPane().add(getLblNewLabel_1_1_1_1_2());
		getContentPane().add(getTfAddress());
		getContentPane().add(getBtnSign());
		getContentPane().add(getBtnCancel());
		getContentPane().add(getBtnCheck());
		getContentPane().add(getBtnIdSame());

	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("");
			lblNewLabel.setIcon(new ImageIcon(Sign.class.getResource("/com/javalec/images/로고.png")));
			lblNewLabel.setBounds(122, 10, 251, 106);
		}
		return lblNewLabel;
	}

	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("ID :");
			lblNewLabel_1.setHorizontalAlignment(SwingConstants.TRAILING);
			lblNewLabel_1.setForeground(new Color(255, 255, 255));
			lblNewLabel_1.setBounds(92, 130, 39, 15);
		}
		return lblNewLabel_1;
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
						pfPassword1.requestFocus();
					}
				}
			});
			tfId.setBounds(164, 126, 148, 23);
			tfId.setColumns(10);
		}
		return tfId;
	}

	private JLabel getLblNewLabel_1_1() {
		if (lblNewLabel_1_1 == null) {
			lblNewLabel_1_1 = new JLabel("PW :");
			lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.TRAILING);
			lblNewLabel_1_1.setForeground(Color.WHITE);
			lblNewLabel_1_1.setBounds(92, 173, 39, 15);
		}
		return lblNewLabel_1_1;
	}

	private JCheckBox getChbShow() {
		if (chbShow == null) {
			chbShow = new JCheckBox("비밀번호 표시");
			chbShow.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					checkPassword();
				}
			});
			chbShow.setForeground(Color.WHITE);
			chbShow.setBackground(new Color(7, 7, 7));
			chbShow.setBounds(159, 199, 107, 23);
		}
		return chbShow;
	}

	private JLabel getLblNewLabel_1_1_1() {
		if (lblNewLabel_1_1_1 == null) {
			lblNewLabel_1_1_1 = new JLabel("PW Check : ");
			lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.TRAILING);
			lblNewLabel_1_1_1.setForeground(Color.WHITE);
			lblNewLabel_1_1_1.setBounds(62, 237, 69, 15);
		}
		return lblNewLabel_1_1_1;
	}

	private JPasswordField getPfPassword1() {
		if (pfPassword1 == null) {
			pfPassword1 = new JPasswordField();
			pfPassword1.addKeyListener(new KeyAdapter() {
				@Override
				public void keyPressed(KeyEvent e) {
					if (e.getKeyCode() == KeyEvent.VK_ENTER) {
						pfPassword2.requestFocus();
					}
				}
			});
			pfPassword1.setBounds(164, 169, 148, 23);
		}
		return pfPassword1;
	}

	private JPasswordField getPfPassword2() {
		if (pfPassword2 == null) {
			pfPassword2 = new JPasswordField();
			pfPassword2.addKeyListener(new KeyAdapter() {
				@Override
				public void keyPressed(KeyEvent e) {
					if (e.getKeyCode() == KeyEvent.VK_ENTER) {
						tfName.requestFocus();
					}
				}
			});
			pfPassword2.setBounds(164, 233, 148, 23);
		}
		return pfPassword2;
	}

	private JLabel getLblNewLabel_1_1_1_1() {
		if (lblNewLabel_1_1_1_1 == null) {
			lblNewLabel_1_1_1_1 = new JLabel("성명 :");
			lblNewLabel_1_1_1_1.setHorizontalAlignment(SwingConstants.TRAILING);
			lblNewLabel_1_1_1_1.setForeground(Color.WHITE);
			lblNewLabel_1_1_1_1.setBounds(81, 279, 50, 15);
		}
		return lblNewLabel_1_1_1_1;
	}

	private JTextField getTfName() {
		if (tfName == null) {
			tfName = new JTextField();
			tfName.addKeyListener(new KeyAdapter() {
				@Override
				public void keyPressed(KeyEvent e) {
					// TextField에 숫자가 입력 되면 지운다
					char specialKey = e.getKeyChar();
					if (e.getKeyChar() >= '0' && e.getKeyChar() <= '9' || e.getKeyCode() == KeyEvent.VK_SPACE
							|| specialCharacter(specialKey)) {
						JOptionPane.showMessageDialog(null, "이름칸에 글자만 입력하세요", "경고", JOptionPane.ERROR_MESSAGE);
						tfName.setText("");
						// Enter키로 다음 입력칸 이동!!
					} else if (e.getKeyCode() == KeyEvent.VK_ENTER) {
						tfPhone.requestFocus();
					} else {

					}
				}
			});
			tfName.setColumns(10);
			tfName.setBounds(164, 275, 148, 23);
		}
		return tfName;
	}

	private JLabel getLblNewLabel_1_1_1_1_1() {
		if (lblNewLabel_1_1_1_1_1 == null) {
			lblNewLabel_1_1_1_1_1 = new JLabel("전화번호 :");
			lblNewLabel_1_1_1_1_1.setHorizontalAlignment(SwingConstants.TRAILING);
			lblNewLabel_1_1_1_1_1.setForeground(Color.WHITE);
			lblNewLabel_1_1_1_1_1.setBounds(62, 324, 69, 15);
		}
		return lblNewLabel_1_1_1_1_1;
	}

	private JTextField getTfPhone() {
		if (tfPhone == null) {
			tfPhone = new JTextField();
			tfPhone.addKeyListener(new KeyAdapter() {
				@Override
				public void keyPressed(KeyEvent e) {
					// TextField에 숫자가 입력 되게한다
					if (e.getKeyChar() >= '0' && e.getKeyChar() <= '9' || e.getKeyCode() == KeyEvent.VK_BACK_SPACE
							|| e.getKeyCode() == KeyEvent.VK_SUBTRACT || e.getKeyCode() == KeyEvent.VK_MINUS) {
						// Enter키로 다음 입력칸 이동!!
					} else if (e.getKeyCode() == KeyEvent.VK_ENTER) {
						tfAddress.requestFocus();
						// 글자 잘못 입력시 지우기
					} else {
						JOptionPane.showMessageDialog(null, "잘못 입력 되었습니다. 다시 입력하세요.", "경고",
								JOptionPane.ERROR_MESSAGE);
						tfAddress.setText("");
					}
				}
			});
			tfPhone.setColumns(10);
			tfPhone.setBounds(164, 320, 251, 23);
		}
		return tfPhone;
	}

	private JLabel getLblNewLabel_1_1_1_1_2() {
		if (lblNewLabel_1_1_1_1_2 == null) {
			lblNewLabel_1_1_1_1_2 = new JLabel("주소 :");
			lblNewLabel_1_1_1_1_2.setHorizontalAlignment(SwingConstants.TRAILING);
			lblNewLabel_1_1_1_1_2.setForeground(Color.WHITE);
			lblNewLabel_1_1_1_1_2.setBounds(81, 369, 50, 15);
		}
		return lblNewLabel_1_1_1_1_2;
	}

	private JTextField getTfAddress() {
		if (tfAddress == null) {
			tfAddress = new JTextField();
			tfAddress.addKeyListener(new KeyAdapter() {
				@Override
				public void keyPressed(KeyEvent e) {
					char specialKey = e.getKeyChar();
					if (specialCharacter(specialKey)) {
						JOptionPane.showMessageDialog(null, "특수문자는 안됩니다.", "경고", JOptionPane.ERROR_MESSAGE);
						tfAddress.setText("");
					} else if (e.getKeyCode() == KeyEvent.VK_ENTER) {
						insertAction();
					}
				}
			});
			tfAddress.setColumns(10);
			tfAddress.setBounds(164, 365, 251, 23);
		}
		return tfAddress;
	}

	private JButton getBtnSign() {
		if (btnSign == null) {
			btnSign = new JButton("작성 완료");
			btnSign.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					insertAction();
				}
			});
			btnSign.setBounds(81, 416, 124, 53);
		}
		return btnSign;
	}

	private JButton getBtnCancel() {
		if (btnCancel == null) {
			btnCancel = new JButton("취소");
			btnCancel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					homeScreen();
				}
			});
			btnCancel.setBounds(288, 416, 124, 53);
		}
		return btnCancel;
	}

	private JButton getBtnCheck() {
		if (btnCheck == null) {
			btnCheck = new JButton("확인");
			btnCheck.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					comparePassword();
				}
			});
			btnCheck.setBounds(322, 232, 93, 23);
		}
		return btnCheck;
	}

	// --- function ---
	private void checkPassword() {
		if (chbShow.isSelected()) {
			pfPassword1.setEchoChar((char) 0); // 비밀번호 표시
		} else {
			pfPassword1.setEchoChar('\u2022'); // 비밀번호 숨김
		}
	}

	private void homeScreen() {
		// 첫 화면으로 돌아가기
		Main window = new Main();
		window.main(null);
		this.setVisible(false);
	}
	
	private void comparePassword() {
		char[] pass1 = pfPassword1.getPassword();
		String passString1 = new String(pass1);

		char[] pass2 = pfPassword2.getPassword();
		String passString2 = new String(pass2);

		if (passString1.equals("") && passString2.equals("")) {
			JOptionPane.showMessageDialog(null, "비밀번호가 입력되지 않았습니다. 다시 입력하세요.");
		} else if (passString1.equals(passString2)) {
			JOptionPane.showMessageDialog(null, "비밀번호가 일치합니다.");
		} else {
			JOptionPane.showMessageDialog(null, "비밀번호가 일치하지 않습니다. 다시 입력하세요.");
		}
	}


	// 작성 안했을시 처리
	private int inputCheck() {
		int checkResult = 0;
		char[] passwordChars = pfPassword1.getPassword();

		if (tfId.getText().trim().length() == 0) { // ID에 입력 안했을 때
			checkResult++;
			tfId.requestFocus();
		}
		if (passwordChars.length == 0) { // PW에 입력 안했을 때
			checkResult++;
			pfPassword1.requestFocus();
		}
		if (tfName.getText().trim().length() == 0) {
			checkResult++;
			tfName.requestFocus();
		}
		if (tfPhone.getText().trim().length() == 0) {
			checkResult++;
			tfPhone.requestFocus();
		}
		if (tfAddress.getText().trim().length() == 0) {
			checkResult++;
			tfAddress.requestFocus();
		}

		return checkResult;
	}

	private boolean specialCharacter(char specialKey) {
		// 특수 문자 확인을 위한 조건 추가
		return "!@#$%^&*()-_=+`~/?,.<>{}[];:|\"'\\".indexOf(specialKey) != -1;
	}

	private JButton getBtnIdSame() {
		if (btnIdSame == null) {
			btnIdSame = new JButton("중복 확인");
			btnIdSame.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					sameCheckAction();
				}
			});
			btnIdSame.setBounds(322, 126, 93, 23);
		}
		return btnIdSame;
	}

	private void insertAction() {
		// 입력 안했을시 체크 받기
		int check = inputCheck();
		
		String custid = tfId.getText();
		char[] charcustpw = pfPassword1.getPassword();
		String custpw = new String(charcustpw);
		String custname = tfName.getText();
		String phone = tfPhone.getText();
		String address = tfAddress.getText();
		
		if (check != 0) {
			JOptionPane.showMessageDialog(null, "항목을 입력 하세요.");
		} else {
			SignLoginDao signLoginDao = new SignLoginDao(custid, custpw, custname, phone, address);
			boolean result = signLoginDao.insertAction(); // 회원가입 성공 여부 확인

//			if (custid.equals("") && custpw.equals("")) {
//				JOptionPane.showMessageDialog(null, custname + "님의 회원가입을 환영합니다!");
//			}

			if (result) {
				// 회원가입 성공 시
				JOptionPane.showMessageDialog(null, custname + "님의 회원가입을 환영합니다!");
				// 홈 화면으로 전환
				homeScreen();
			} else {
				// 회원가입 실패 시
				JOptionPane.showMessageDialog(null, "회원가입에 실패하였습니다! 다시 작성하여 주세요");
				// 다시 맨 처음 화면
				this.setVisible(false);
				setVisible(true);
			}
		}
	}

	private void sameCheckAction() {
		String custid1 = tfId.getText().trim();
//		String custid1 = custid.replaceAll("[^ㄱ-ㅎㅏ-ㅣ가-힣a-zA-Z0-9]", "");
		SignLoginDao signLoginDao = new SignLoginDao();

		signLoginDao.sameCheckAction(custid1);


//		if (custid1.equals(custid2)) {
//			JOptionPane.showMessageDialog(null, "아이디를 다시 입력하여 주세요.");
//		}

	}

} // End
