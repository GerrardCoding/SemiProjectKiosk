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
	}
	private JRadioButton getRdbSelect() {
		if (rdbSelect == null) {
			rdbSelect = new JRadioButton("회원 정보 조회");
			rdbSelect.setFont(new Font("굴림", Font.BOLD, 12));
			rdbSelect.setForeground(new Color(255, 255, 255));
			rdbSelect.setBackground(new Color(119, 108, 106));
			rdbSelect.setSelected(true);
			buttonGroup.add(rdbSelect);
			rdbSelect.setBounds(33, 32, 115, 23);
		}
		return rdbSelect;
	}
	private JRadioButton getRdbUpdate() {
		if (rdbUpdate == null) {
			rdbUpdate = new JRadioButton("회원 정보 수정");
			rdbUpdate.setFont(new Font("굴림", Font.BOLD, 12));
			rdbUpdate.setForeground(new Color(255, 255, 255));
			rdbUpdate.setBackground(new Color(119, 108, 106));
			buttonGroup.add(rdbUpdate);
			rdbUpdate.setBounds(232, 32, 115, 23);
		}
		return rdbUpdate;
	}
	private JRadioButton getRdbDelete() {
		if (rdbDelete == null) {
			rdbDelete = new JRadioButton("회원 정보 삭제");
			rdbDelete.setFont(new Font("굴림", Font.BOLD, 12));
			rdbDelete.setForeground(new Color(255, 255, 255));
			rdbDelete.setBackground(new Color(119, 108, 106));
			buttonGroup.add(rdbDelete);
			rdbDelete.setBounds(433, 32, 115, 23);
		}
		return rdbDelete;
	}
	private JComboBox getCbBox() {
		if (cbBox == null) {
			cbBox = new JComboBox();
			cbBox.setModel(new DefaultComboBoxModel(new String[] {"ID", "이름", "주소", "상태"}));
			cbBox.setBounds(33, 74, 115, 41);
		}
		return cbBox;
	}
	private JTextField getTfSearch() {
		if (tfSearch == null) {
			tfSearch = new JTextField();
			tfSearch.setBounds(158, 74, 337, 41);
			tfSearch.setColumns(10);
		}
		return tfSearch;
	}
	private JButton getBtnSearch() {
		if (btnSearch == null) {
			btnSearch = new JButton("검색");
			btnSearch.setBounds(505, 74, 149, 41);
		}
		return btnSearch;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(33, 123, 621, 351);
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
	    	lblLogout.setToolTipText("로그아웃");
	    	lblLogout.addMouseListener(new MouseAdapter() {
	    		@Override
	    		public void mouseClicked(MouseEvent e) {
	    			homeScreen();
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
	
	
	
	
} // End
