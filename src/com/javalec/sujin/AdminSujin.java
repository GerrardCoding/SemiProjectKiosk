package com.javalec.sujin;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import com.javalec.common.ShareVar;

import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.ButtonGroup;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminSujin {

	private JFrame frame;
	private JRadioButton rdbtnSearch;
	private JRadioButton rdbtnUpdate;
	private JRadioButton rdbtnInsert;
	private JRadioButton rdbtnDelete;
	private JScrollPane scrollPane;
	private JComboBox cbSelect;
	private JTextField tfSelect;
	private JButton btnSearch;
	private JTable innerTable;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final DefaultTableModel outerTable = new DefaultTableModel();
	private JLabel lblNewLabel;
	private JTextField tfModelnum;
	private JTextField tfBrand;
	private JLabel lblNewLabel_4;
	private JTextField tfModelname;
	private JLabel lblNewLabel_2;
	private JTextField tfColor;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_1;
	private JTextField tfSize;
	private JTextField tfQty;
	private JLabel lblNewLabel_4_1;
	private JTextField tfPrice;
	private JLabel lblNewLabel_2_1;
	private JLabel lblImage;
	private JTextField tfImage;
	private JLabel lblNewLabel_2_1_1;
	private JButton btnImage;
	private JButton btnOK;
	private int lastQty;
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
		frame.setBounds(100, 100, 1065, 724);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(getRdbtnSearch());
		frame.getContentPane().add(getRdbtnUpdate());
		frame.getContentPane().add(getRdbtnInsert());
		frame.getContentPane().add(getRdbtnDelete());
		frame.getContentPane().add(getScrollPane());
		frame.getContentPane().add(getCbSelect());
		frame.getContentPane().add(getTfSelect());
		frame.getContentPane().add(getBtnSearch());
		frame.getContentPane().add(getLblNewLabel());
		frame.getContentPane().add(getTfModelnum());
		frame.getContentPane().add(getTfBrand());
		frame.getContentPane().add(getLblNewLabel_4());
		frame.getContentPane().add(getTfModelname());
		frame.getContentPane().add(getLblNewLabel_2());
		frame.getContentPane().add(getTfColor());
		frame.getContentPane().add(getLblNewLabel_3());
		frame.getContentPane().add(getLblNewLabel_1());
		frame.getContentPane().add(getTfSize());
		frame.getContentPane().add(getTfQty());
		frame.getContentPane().add(getLblNewLabel_4_1());
		frame.getContentPane().add(getTfPrice());
		frame.getContentPane().add(getLblNewLabel_2_1());
		frame.getContentPane().add(getLblImage());
		frame.getContentPane().add(getTextField_7());
		frame.getContentPane().add(getLblNewLabel_2_1_1());
		frame.getContentPane().add(getBtnImage());
		frame.getContentPane().add(getBtnOK());
	}
	private JRadioButton getRdbtnSearch() {
		if (rdbtnSearch == null) {
			rdbtnSearch = new JRadioButton("검색");
			rdbtnSearch.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					screenPartition();
				}
			});
			rdbtnSearch.setBounds(589, 22, 55, 23);
			buttonGroup.add(rdbtnSearch);
			rdbtnSearch.setSelected(true);
		}
		return rdbtnSearch;
	}
	private JRadioButton getRdbtnUpdate() {
		if (rdbtnUpdate == null) {
			rdbtnUpdate = new JRadioButton("기존상품 추가");
			rdbtnUpdate.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					screenPartition();
				}
			});
			rdbtnUpdate.setBounds(656, 22, 117, 23);
			buttonGroup.add(rdbtnUpdate);
		}
		return rdbtnUpdate;
	}
	private JRadioButton getRdbtnInsert() {
		if (rdbtnInsert == null) {
			rdbtnInsert = new JRadioButton("새모델 추가");
			rdbtnInsert.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					screenPartition();
				}
			});
			rdbtnInsert.setBounds(773, 22, 117, 23);
			buttonGroup.add(rdbtnInsert);
		}
		return rdbtnInsert;
	}
	private JRadioButton getRdbtnDelete() {
		if (rdbtnDelete == null) {
			rdbtnDelete = new JRadioButton("삭제");
			rdbtnDelete.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					screenPartition();
				}
			});
			rdbtnDelete.setBounds(883, 22, 55, 23);
			buttonGroup.add(rdbtnDelete);
		}
		return rdbtnDelete;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(32, 57, 1001, 240);
			scrollPane.setViewportView(getInnerTable());
		}
		return scrollPane;
	}
	private JComboBox getCbSelect() {
		if (cbSelect == null) {
			cbSelect = new JComboBox();
			cbSelect.setBounds(57, 24, 105, 23);
			cbSelect.setModel(new DefaultComboBoxModel(new String[] {"상품명", "사이즈", "색상", "재고갯수"}));
		}
		return cbSelect;
	}
	private JTextField getTfSelect() {
		if (tfSelect == null) {
			tfSelect = new JTextField();
			tfSelect.setBounds(174, 23, 142, 21);
			tfSelect.setColumns(10);
		}
		return tfSelect;
	}
	private JButton getBtnSearch() {
		if (btnSearch == null) {
			btnSearch = new JButton("검색");
			btnSearch.setBounds(328, 24, 97, 23);
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
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("모델번호 : ");
			lblNewLabel.setBounds(42, 320, 61, 16);
		}
		return lblNewLabel;
	}
	private JTextField getTfModelnum() {
		if (tfModelnum == null) {
			tfModelnum = new JTextField();
			tfModelnum.setBounds(145, 315, 245, 26);
			tfModelnum.setColumns(10);
		}
		return tfModelnum;
	}
	private JTextField getTfBrand() {
		if (tfBrand == null) {
			tfBrand = new JTextField();
			tfBrand.setColumns(10);
			tfBrand.setBounds(145, 353, 245, 26);
		}
		return tfBrand;
	}
	private JLabel getLblNewLabel_4() {
		if (lblNewLabel_4 == null) {
			lblNewLabel_4 = new JLabel("브랜드 : ");
			lblNewLabel_4.setBounds(42, 358, 61, 16);
		}
		return lblNewLabel_4;
	}
	private JTextField getTfModelname() {
		if (tfModelname == null) {
			tfModelname = new JTextField();
			tfModelname.setColumns(10);
			tfModelname.setBounds(145, 391, 245, 26);
		}
		return tfModelname;
	}
	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("모델이름 : ");
			lblNewLabel_2.setBounds(42, 396, 61, 16);
		}
		return lblNewLabel_2;
	}
	private JTextField getTfColor() {
		if (tfColor == null) {
			tfColor = new JTextField();
			tfColor.setColumns(10);
			tfColor.setBounds(145, 429, 245, 26);
		}
		return tfColor;
	}
	private JLabel getLblNewLabel_3() {
		if (lblNewLabel_3 == null) {
			lblNewLabel_3 = new JLabel("색상 : ");
			lblNewLabel_3.setBounds(42, 434, 61, 16);
		}
		return lblNewLabel_3;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("사이즈 : ");
			lblNewLabel_1.setBounds(42, 479, 61, 16);
		}
		return lblNewLabel_1;
	}
	private JTextField getTfSize() {
		if (tfSize == null) {
			tfSize = new JTextField();
			tfSize.setColumns(10);
			tfSize.setBounds(145, 474, 245, 26);
		}
		return tfSize;
	}
	private JTextField getTfQty() {
		if (tfQty == null) {
			tfQty = new JTextField();
			tfQty.setColumns(10);
			tfQty.setBounds(145, 512, 245, 26);
		}
		return tfQty;
	}
	private JLabel getLblNewLabel_4_1() {
		if (lblNewLabel_4_1 == null) {
			lblNewLabel_4_1 = new JLabel("갯수 : ");
			lblNewLabel_4_1.setBounds(42, 517, 61, 16);
		}
		return lblNewLabel_4_1;
	}
	private JTextField getTfPrice() {
		if (tfPrice == null) {
			tfPrice = new JTextField();
			tfPrice.setColumns(10);
			tfPrice.setBounds(145, 550, 245, 26);
		}
		return tfPrice;
	}
	private JLabel getLblNewLabel_2_1() {
		if (lblNewLabel_2_1 == null) {
			lblNewLabel_2_1 = new JLabel("가격 : ");
			lblNewLabel_2_1.setBounds(42, 555, 61, 16);
		}
		return lblNewLabel_2_1;
	}
	private JLabel getLblImage() {
		if (lblImage == null) {
			lblImage = new JLabel("");
			lblImage.setBackground(Color.GRAY);
			lblImage.setBounds(429, 307, 555, 269);
		}
		return lblImage;
	}
	private JTextField getTextField_7() {
		if (tfImage == null) {
			tfImage = new JTextField();
			tfImage.setColumns(10);
			tfImage.setBounds(145, 601, 245, 26);
		}
		return tfImage;
	}
	private JLabel getLblNewLabel_2_1_1() {
		if (lblNewLabel_2_1_1 == null) {
			lblNewLabel_2_1_1 = new JLabel("이미지 경로 : ");
			lblNewLabel_2_1_1.setBounds(42, 606, 61, 16);
		}
		return lblNewLabel_2_1_1;
	}
	private JButton getBtnImage() {
		if (btnImage == null) {
			btnImage = new JButton("이미지 추가");
			btnImage.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					filePath();
				}
			});
			btnImage.setBounds(407, 601, 117, 29);
		}
		return btnImage;
	}
	private JButton getBtnOK() {
		if (btnOK == null) {
			btnOK = new JButton("OK");
			btnOK.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					actionPartition();
				}
			});
			btnOK.setBounds(143, 649, 117, 29);
		}
		return btnOK;
	}
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
		
		// 모델번호
		int colNo = 0;
		TableColumn col = innerTable.getColumnModel().getColumn(colNo);
		int width = 100;
		col.setPreferredWidth(width);
		
		// 브랜드
		colNo = 1;
		col = innerTable.getColumnModel().getColumn(colNo);
		width = 100;
		col.setPreferredWidth(width);

		
		// 모델명
		colNo = 2;
		col = innerTable.getColumnModel().getColumn(colNo);
		width = 200;
		col.setPreferredWidth(width);
		
		
		// 색상
		colNo = 3;
		col = innerTable.getColumnModel().getColumn(colNo);
		width = 100;
		col.setPreferredWidth(width);
		
		// 사이즈
		colNo = 4;
		col = innerTable.getColumnModel().getColumn(colNo);
		width = 100;
		col.setPreferredWidth(width);
		
		
		// 재고량
		colNo = 5;
		col = innerTable.getColumnModel().getColumn(colNo);
		width = 100;
		col.setPreferredWidth(width);
		
		
		// 가격
		colNo = 6;
		col = innerTable.getColumnModel().getColumn(colNo);
		width = 150;
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
			btnImage.setVisible(false);
			tfModelnum.setEditable(false);
			tfBrand.setEditable(false);
			tfModelname.setEditable(false);
			tfColor.setEditable(false);
			tfSize.setEditable(false);
			tfQty.setEditable(false);
			tfPrice.setEditable(false);
			tfImage.setEditable(false);
			lblImage.setVisible(true);
		}
		// 기존제품 추가.
		if(rdbtnUpdate.isSelected() == true) {
			btnOK.setVisible(true);
			btnImage.setVisible(false);
			tfModelnum.setEditable(false);
			tfBrand.setEditable(false);
			tfModelname.setEditable(false);
			tfColor.setEditable(false);
			tfSize.setEditable(false);
			tfQty.setEditable(true);
			tfPrice.setEditable(false);
			tfImage.setEditable(false);
			lblImage.setVisible(true);
		}
		// 새제품 추가.
		if(rdbtnInsert.isSelected() == true) {
			btnOK.setVisible(true);
			btnImage.setVisible(true);
			tfModelnum.setEditable(true);
			tfBrand.setEditable(true);
			tfModelname.setEditable(true);
			tfColor.setEditable(true);
			tfSize.setEditable(true);
			tfQty.setEditable(true);
			tfPrice.setEditable(true);
			tfImage.setEditable(true);
			lblImage.setVisible(false);
			
		}
		// 삭제.
		if(rdbtnDelete.isSelected() == true) {
			btnOK.setVisible(true);
			btnImage.setVisible(false);
			tfModelnum.setEditable(false);
			tfBrand.setEditable(false);
			tfModelname.setEditable(false);
			tfColor.setEditable(false);
			tfSize.setEditable(false);
			tfQty.setEditable(false);
			tfPrice.setEditable(false);
			tfImage.setEditable(false);
			lblImage.setVisible(true);
		}
	}	// End of screenPartition()
	private void tableClick() {
		int i = innerTable.getSelectedRow();
		String tkModelnum = (String) innerTable.getValueAt(i, 0);
//		int wkModelnum = Integer.parseInt(tkModelnum);
		ProductDao dao = new ProductDao(tkModelnum);
		ProductDto dto = dao.tableClick();
		
		tfModelnum.setText(dto.getModelnum());
		tfBrand.setText(dto.getBrand());
		tfModelname.setText(dto.getModelname());
		tfColor.setText(dto.getColor());
		tfSize.setText(Integer.toString(dto.getStosize()));
		tfQty.setText(Integer.toString(dto.getStoqty()));
		tfPrice.setText(Integer.toString(dto.getStoprice()));
		lastQty = dto.getStoqty();
		// Image 처리 : fileName이 틀려야 보여주기가 가능.
		String filePath = Integer.toString(ShareVar.filename);
//		tfFilePath.setText(filePath);
		
		lblImage.setIcon(new ImageIcon(filePath));
		lblImage.setHorizontalAlignment(SwingConstants.CENTER);
	}	//End of tableClick()
	
	// 필드 체크.
	private int insertFieldCheck() {
		int i = 0;
		
		if(tfModelnum.getText().trim().length() == 0) {
			i++;
			tfModelnum.requestFocus();
		}
		if(tfBrand.getText().trim().length() == 0) {
			i++;
			tfBrand.requestFocus();
		}
		if(tfModelname.getText().trim().length() == 0) {
			i++;
			tfModelname.requestFocus();
		}
		if(tfColor.getText().trim().length() == 0) {
			i++;
			tfColor.requestFocus();
		}
		if(tfSize.getText().trim().length() == 0) {
			i++;
			tfSize.requestFocus();
		}
		if(tfQty.getText().trim().length() == 0) {
			i++;
			tfSize.requestFocus();
		}
		if(tfPrice.getText().trim().length() == 0) {
			i++;
			tfSize.requestFocus();
		}
		return i;
	}
	
	//이미지 파일 체크
	private boolean imageCheck() {
		if(tfImage.getText().trim().length() == 0) {
			return false;
		}
		return true;
	}
	
	// OK 버튼 눌렀을 때 액션.
	private void actionPartition() {
		// 검색일 경우
		if(rdbtnSearch.isSelected() == true) {
			screenPartition();
		}
		
		// 기존제품 추가.
		if(rdbtnUpdate.isSelected() == true) {
			int i_chk = insertFieldCheck();
			if(i_chk == 0) {
				updateAction();
				tableInit();
				searchAction();
				clearColumn();
			}else {
				JOptionPane.showMessageDialog(null, "데이터를 확인하세요");
			}
			
			screenPartition();
		}
		// 새제품 추가.
		if(rdbtnInsert.isSelected() == true) {
			lblImage.setText("");
			int i_chk = insertFieldCheck();
			if(i_chk == 0) {
				if(imageCheck()) {
					insertAction();
					tableInit();
					searchAction();
					clearColumn();
				}else {
					JOptionPane.showMessageDialog(null, "이미지를 넣어주세요");
					tfImage.requestFocus();
				}
			}else {
				JOptionPane.showMessageDialog(null, "데이터를 확인하세요");
			}
			
			screenPartition();
		}
		// 삭제.
		if(rdbtnDelete.isSelected() == true) {
			int i_chk = insertFieldCheck();
			if(i_chk == 0) {
				deleteAction();
				tableInit();
				searchAction();
				clearColumn();
			}else {
				JOptionPane.showMessageDialog(null, "데이터를 확인하세요");
			}
			
			screenPartition();
		}
		
	}
	
	
	// 컬럼 내용 지우기.
	private void clearColumn() {
		tfModelnum.setText("");
		tfBrand.setText("");
		tfModelname.setText("");
		tfColor.setText("");
		tfSize.setText("");
		tfQty.setText("");
		tfPrice.setText("");
		tfImage.setText("");
		lblImage.setVisible(false);
	}
	
	// 기존제품 추가.
	private void insertAction() {
		String modelnum = tfModelnum.getText().trim();
		String brand = tfBrand.getText().trim();
		String modelname = tfModelname.getText().trim();
		String color = tfColor.getText().trim();
		int size = Integer.parseInt(tfSize.getText().trim());
		int qty = Integer.parseInt(tfQty.getText().trim());
		int price = Integer.parseInt(tfPrice.getText().trim());
		
		// Image File
		FileInputStream input = null;
		File file = new File(tfImage.getText());
		try {
			input = new FileInputStream(file);
			
		}catch(FileNotFoundException e) { 
			e.printStackTrace();
		}
		
		ProductDao dao = new ProductDao(modelnum, brand, modelname, color, size, qty, price, input);
		boolean result = dao.insertAction();
		
		if(result == true) {
			JOptionPane.showMessageDialog(null,  tfModelnum.getText() + " 새상품이 "+ tfQty.getText().trim() +"등록 되었습니다.");
		}else {
			JOptionPane.showMessageDialog(null, "입력중 문제가 발생했습니다.");
		}
	}
	
	private void updateAction() {
		String modelnum = tfModelnum.getText().trim();
		String brand = tfBrand.getText().trim();
		String modelname = tfModelname.getText().trim();
		String color = tfColor.getText().trim();
		int size = Integer.parseInt(tfSize.getText().trim());
		int qty = Integer.parseInt(tfQty.getText().trim());
		int price = Integer.parseInt(tfPrice.getText().trim());
		
		ProductDao dao = new ProductDao(modelnum,lastQty+qty);
		boolean result = dao.updateAction();
		
		if(result == true) {
			JOptionPane.showMessageDialog(null,  tfModelnum.getText() + " 상품이 "+ tfQty.getText().trim() +"개 추가 되었습니다.");
		}else {
			JOptionPane.showMessageDialog(null, "입력중 문제가 발생했습니다.");
		}
	}
	
	private void deleteAction() {
		String modelnum = tfModelnum.getText().trim(); 
		
		ProductDao dao = new ProductDao(modelnum);
		boolean result = dao.deleteAction();
		
		if(result == true) {
			JOptionPane.showMessageDialog(null,  tfModelnum.getText() + " 상품이 삭제 되었습니다.");
		}else {
			JOptionPane.showMessageDialog(null, "입력중 문제가 발생했습니다.");
		}
	}
	
	// -----------------[[[ File ]]]]]]---------------------------------------------------

	private void filePath() {
		JFileChooser chooser = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG", "PNG", "BMP", "GIF", "jpg", "png", "bmp", "gifs");
		chooser.setFileFilter(filter);
		
		int ret = chooser.showOpenDialog(null);
		if(ret != JFileChooser.APPROVE_OPTION) {
			JOptionPane.showMessageDialog(null, "파일을 선택하지 않았습니다.");
			return;
		}
		String filePath = chooser.getSelectedFile().getPath();
		tfImage.setText(filePath);
		lblImage.setIcon(new ImageIcon(filePath));
		lblImage.setHorizontalAlignment(SwingConstants.CENTER);
		
	}

}	//	End 
