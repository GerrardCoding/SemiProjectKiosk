package com.javalec.sujin;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import javax.swing.ButtonGroup;

public class AdminSujin {

	private JFrame frame;
	private JRadioButton rdbtnSearch;
	private JRadioButton rdbtnInsert;
	private JRadioButton rdbtnUpdate;
	private JRadioButton rdbtnDelete;
	private JScrollPane scrollPane;
	private JComboBox cbSelect;
	private JTextField tfSelect;
	private JButton btnSearch;
	private JTable table;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminSujin window = new AdminSujin();
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
	public AdminSujin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("관리자 등록 수정 삭제");
		frame.setBounds(100, 100, 450, 545);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(getRdbtnSearch());
		frame.getContentPane().add(getRdbtnInsert());
		frame.getContentPane().add(getRdbtnUpdate());
		frame.getContentPane().add(getRdbtnDelete());
		frame.getContentPane().add(getScrollPane());
		frame.getContentPane().add(getCbSelect());
		frame.getContentPane().add(getTfSelect());
		frame.getContentPane().add(getBtnSearch());
	}
	private JRadioButton getRdbtnSearch() {
		if (rdbtnSearch == null) {
			rdbtnSearch = new JRadioButton("검색");
			buttonGroup.add(rdbtnSearch);
			rdbtnSearch.setSelected(true);
			rdbtnSearch.setBounds(32, 40, 55, 23);
		}
		return rdbtnSearch;
	}
	private JRadioButton getRdbtnInsert() {
		if (rdbtnInsert == null) {
			rdbtnInsert = new JRadioButton("등록");
			buttonGroup.add(rdbtnInsert);
			rdbtnInsert.setBounds(107, 40, 55, 23);
		}
		return rdbtnInsert;
	}
	private JRadioButton getRdbtnUpdate() {
		if (rdbtnUpdate == null) {
			rdbtnUpdate = new JRadioButton("수정");
			buttonGroup.add(rdbtnUpdate);
			rdbtnUpdate.setBounds(185, 40, 55, 23);
		}
		return rdbtnUpdate;
	}
	private JRadioButton getRdbtnDelete() {
		if (rdbtnDelete == null) {
			rdbtnDelete = new JRadioButton("삭제");
			buttonGroup.add(rdbtnDelete);
			rdbtnDelete.setBounds(265, 40, 55, 23);
		}
		return rdbtnDelete;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(32, 121, 368, 146);
			scrollPane.setViewportView(getTable());
		}
		return scrollPane;
	}
	private JComboBox getCbSelect() {
		if (cbSelect == null) {
			cbSelect = new JComboBox();
			cbSelect.setModel(new DefaultComboBoxModel(new String[] {"상품명", "브랜드", "모델번호", "사이즈", "색상", "재고갯수"}));
			cbSelect.setBounds(32, 88, 74, 23);
		}
		return cbSelect;
	}
	private JTextField getTfSelect() {
		if (tfSelect == null) {
			tfSelect = new JTextField();
			tfSelect.setBounds(118, 89, 142, 21);
			tfSelect.setColumns(10);
		}
		return tfSelect;
	}
	private JButton getBtnSearch() {
		if (btnSearch == null) {
			btnSearch = new JButton("검색");
			btnSearch.setBounds(303, 88, 97, 23);
		}
		return btnSearch;
	}
	private JTable getTable() {
		if (table == null) {
			table = new JTable();
		}
		return table;
	}
}
