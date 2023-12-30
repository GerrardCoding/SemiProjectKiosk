package com.javalec.daegeun;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;

import com.javalec.base.Main;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Acount extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JRadioButton rdbSelect;
	private JRadioButton rdbUpdate;
	private JRadioButton rdbDelete;
	private JComboBox cbBox;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField tfSearch;
	private JButton btnSearch;
	private JScrollPane scrollPane;
	private JTable table;
	private JLabel lblLogout;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Acount dialog = new Acount();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Acount() {
		setTitle("관리자모드");
		setBounds(350, 100, 700, 700);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(119, 108, 106));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		contentPanel.add(getRdbSelect());
		contentPanel.add(getRdbUpdate());
		contentPanel.add(getRdbDelete());
		contentPanel.add(getCbBox());
		contentPanel.add(getTfSearch());
		contentPanel.add(getBtnSearch());
		contentPanel.add(getScrollPane());
		contentPanel.add(getLblLogout());
		contentPanel.add(getBtnNewButton());
		contentPanel.add(getBtnNewButton_1());
		contentPanel.add(getBtnNewButton_2());
	}
	private JRadioButton getRdbSelect() {
		if (rdbSelect == null) {
			rdbSelect = new JRadioButton("회원 조회");
			rdbSelect.setFont(new Font("굴림", Font.BOLD, 20));
			rdbSelect.setForeground(new Color(255, 255, 255));
			rdbSelect.setBackground(new Color(119, 108, 106));
			rdbSelect.setSelected(true);
			buttonGroup.add(rdbSelect);
			rdbSelect.setBounds(100, 88, 140, 23);
		}
		return rdbSelect;
	}
	private JRadioButton getRdbUpdate() {
		if (rdbUpdate == null) {
			rdbUpdate = new JRadioButton("회원 수정");
			rdbUpdate.setFont(new Font("굴림", Font.BOLD, 20));
			rdbUpdate.setForeground(new Color(255, 255, 255));
			rdbUpdate.setBackground(new Color(119, 108, 106));
			buttonGroup.add(rdbUpdate);
			rdbUpdate.setBounds(278, 88, 149, 23);
		}
		return rdbUpdate;
	}
	private JRadioButton getRdbDelete() {
		if (rdbDelete == null) {
			rdbDelete = new JRadioButton("회원 삭제");
			rdbDelete.setFont(new Font("굴림", Font.BOLD, 20));
			rdbDelete.setForeground(new Color(255, 255, 255));
			rdbDelete.setBackground(new Color(119, 108, 106));
			buttonGroup.add(rdbDelete);
			rdbDelete.setBounds(441, 88, 149, 23);
		}
		return rdbDelete;
	}
	private JComboBox getCbBox() {
		if (cbBox == null) {
			cbBox = new JComboBox();
			cbBox.setModel(new DefaultComboBoxModel(new String[] {"ID", "이름", "주소", "상태"}));
			cbBox.setBounds(34, 130, 115, 41);
		}
		return cbBox;
	}
	private JTextField getTfSearch() {
		if (tfSearch == null) {
			tfSearch = new JTextField();
			tfSearch.setBounds(159, 130, 337, 41);
			tfSearch.setColumns(10);
		}
		return tfSearch;
	}
	private JButton getBtnSearch() {
		if (btnSearch == null) {
			btnSearch = new JButton("검색");
			btnSearch.setBounds(506, 130, 149, 41);
		}
		return btnSearch;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(34, 179, 621, 351);
			scrollPane.setViewportView(getTable());
		}
		return scrollPane;
	}
	private JTable getTable() {
		if (table == null) {
			table = new JTable();
			table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		}
		return table;
	}
	private JLabel getLblLogout() {
	    if (lblLogout == null) {
	    	// 원래 이미지의 파일을 icon에 담는다
	    	ImageIcon icon = new ImageIcon(Acount.class.getResource("/com/javalec/images/logout.png"));
	    	// img에 이미지를 담는다.
			Image img = icon.getImage();
			// 그 이미지를 사이즈 조절해서 담아준다
			Image changeImg = img.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
			// 변경된 이미지를 다시 ImageIcon에 담아준다
			ImageIcon changeIcon = new ImageIcon(changeImg);
	    	lblLogout = new JLabel(changeIcon); // 변경된 이미지로 JLabel 생성
	    	
	    	// 바뀌는 이미지 담아주기
	    	ImageIcon icon2 = new ImageIcon(Acount.class.getResource("/com/javalec/images/logout2.png"));
			Image img2 = icon2.getImage();
			Image changeImg2 = img2.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
			ImageIcon changeIcon2 = new ImageIcon(changeImg2);
	    	
	    	lblLogout.setToolTipText("로그아웃");
	    	lblLogout.addMouseListener(new MouseAdapter() {
	    		@Override
	    		public void mouseClicked(MouseEvent e) {
	    			homeScreen();
	    		}
	    		@Override
	    		public void mouseEntered(MouseEvent e) {
	    			lblLogout.setIcon(changeIcon2);
	    		}
	    		@Override
	    		public void mouseExited(MouseEvent e) {
	    			lblLogout.setIcon(changeIcon);
	    		}
	    	});
	    	lblLogout.setBounds(617, 10, 50, 50);
	    }
		return lblLogout;
	}
	
	// ---- Function ----
	private void homeScreen() {
		// 첫 화면으로 돌아가기
		Main window = new Main();
		window.main(null);
		this.setVisible(false);
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("회원");
			btnNewButton.setBounds(127, 23, 85, 39);
		}
		return btnNewButton;
	}
	
	
	private JButton getBtnNewButton_1() {
		if (btnNewButton_1 == null) {
			btnNewButton_1 = new JButton("회원");
			btnNewButton_1.setBounds(293, 23, 85, 39);
		}
		return btnNewButton_1;
	}
	private JButton getBtnNewButton_2() {
		if (btnNewButton_2 == null) {
			btnNewButton_2 = new JButton("회원");
			btnNewButton_2.setBounds(456, 23, 85, 39);
		}
		return btnNewButton_2;
	}
} // End
