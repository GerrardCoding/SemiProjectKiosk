package com.javalec.sujin;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import javax.swing.ButtonGroup;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ListSelectionModel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

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
	private JTable innerTable;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final DefaultTableModel outerTable = new DefaultTableModel();
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
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				tableInit();
				searchAction();
				screenPartition();
			}
		});
		frame.setTitle("관리자 상품 등록");
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
			rdbtnSearch.setBounds(32, 40, 55, 23);
			buttonGroup.add(rdbtnSearch);
			rdbtnSearch.setSelected(true);
		}
		return rdbtnSearch;
	}
	private JRadioButton getRdbtnInsert() {
		if (rdbtnInsert == null) {
			rdbtnInsert = new JRadioButton("기존상품 추가");
			rdbtnInsert.setBounds(99, 40, 146, 23);
			buttonGroup.add(rdbtnInsert);
		}
		return rdbtnInsert;
	}
	private JRadioButton getRdbtnUpdate() {
		if (rdbtnUpdate == null) {
			rdbtnUpdate = new JRadioButton("새모델 추가");
			rdbtnUpdate.setBounds(216, 40, 117, 23);
			buttonGroup.add(rdbtnUpdate);
		}
		return rdbtnUpdate;
	}
	private JRadioButton getRdbtnDelete() {
		if (rdbtnDelete == null) {
			rdbtnDelete = new JRadioButton("삭제");
			rdbtnDelete.setBounds(326, 40, 55, 23);
			buttonGroup.add(rdbtnDelete);
		}
		return rdbtnDelete;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(32, 121, 368, 146);
			scrollPane.setViewportView(getInnerTable());
		}
		return scrollPane;
	}
	private JComboBox getCbSelect() {
		if (cbSelect == null) {
			cbSelect = new JComboBox();
			cbSelect.setBounds(32, 88, 105, 23);
			cbSelect.setModel(new DefaultComboBoxModel(new String[] {"상품명", "사이즈", "색상", "재고갯수"}));
		}
		return cbSelect;
	}
	private JTextField getTfSelect() {
		if (tfSelect == null) {
			tfSelect = new JTextField();
			tfSelect.setBounds(149, 87, 142, 21);
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
	private JTable getInnerTable() {
		if (innerTable == null) {
			innerTable = new JTable();
			innerTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			innerTable.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if(e.getButton() == 1) {
						tableClick();
					}
				}
			});
			innerTable.setModel(outerTable);
		}
		return innerTable;
	}
	
	//modelnum, brand, modelname, color, stosize, stoqty, stoprice, file
	
	
	// ---- Function ------
	private void tableInit() {
		// Table Column 명 정하기.
		outerTable.addColumn("모델번호");
		outerTable.addColumn("브랜드");
		outerTable.addColumn("모델명");
		outerTable.addColumn("색상");
		outerTable.addColumn("사이즈");
		outerTable.addColumn("재고량");
		outerTable.addColumn("가격");
		outerTable.setColumnCount(7);
		
		int colNo = 0;
		TableColumn col = innerTable.getColumnModel().getColumn(colNo);
		int width = 30;
		col.setPreferredWidth(width);
		
		// 모델번호
		colNo = 1;
		col = innerTable.getColumnModel().getColumn(colNo);
		width = 50;
		col.setPreferredWidth(width);

		
		// 브랜드
		colNo = 2;
		col = innerTable.getColumnModel().getColumn(colNo);
		width = 100;
		col.setPreferredWidth(width);
		
		
		// 모델명
		colNo = 3;
		col = innerTable.getColumnModel().getColumn(colNo);
		width = 50;
		col.setPreferredWidth(width);
		
		// 색상
		colNo = 4;
		col = innerTable.getColumnModel().getColumn(colNo);
		width = 50;
		col.setPreferredWidth(width);
		
		
		// 사이
		colNo = 5;
		col = innerTable.getColumnModel().getColumn(colNo);
		width = 100;
		col.setPreferredWidth(width);
		
		
		// 재고량
		colNo = 6;
		col = innerTable.getColumnModel().getColumn(colNo);
		width = 50;
		col.setPreferredWidth(width);
		
		// 가격
		colNo = 7;
		col = innerTable.getColumnModel().getColumn(colNo);
		width = 50;
		col.setPreferredWidth(width);
		
		// 테이블 내용 지우기.
		int i = outerTable.getRowCount();
		for(int j=0; j<i; j++) {
			outerTable.removeRow(0);
		}
		
		innerTable.setAutoResizeMode(innerTable.AUTO_RESIZE_OFF);
	}	// End of tableInit()
	
	private void searchAction() {
		ProductDao dao = new ProductDao();
		ArrayList<ProductDto> dtoList = dao.selectList();
		
		int listCount = dtoList.size();
		
		for(int i=0; i<listCount; i++) {
			String modelnum;
			String brand;
			String modelname;
			String color;
			int stosize;
			int stoqty;
			int stoprice;
			String tmpSize = Integer.toString(dtoList.get(i).getStosize()); 
			String tmpQty = Integer.toString(dtoList.get(i).getStoqty()); 
			String tmpPrice = Integer.toString(dtoList.get(i).getStoprice()); 
			String[] qTxt = {dtoList.get(i).getModelnum(), dtoList.get(i).getBrand(), dtoList.get(i).getModelname(), dtoList.get(i).getColor(), tmpSize, tmpQty, tmpPrice};
			outerTable.addRow(qTxt);
		}
	}	// End of searchAction()
	private void screenPartition() {
		// 검색일 경우
		if(rdbtnSearch.isSelected() == true) {
			btnOK.setVisible(false);
			tfName.setEditable(false);
			tfTelNo.setEditable(false);
			tfAddress.setEditable(false);
			tfEmail.setEditable(false);
			tfRelation.setEditable(false);
		}
	}	// End of screenPartition()
	private void tableClick() {
		
	}	//End of tableClick()
	
	
}	//	End 
