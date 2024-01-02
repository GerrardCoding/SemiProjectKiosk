package com.javalec.gwangyeong;

import java.awt.Component;

import javax.swing.JCheckBox;
import javax.swing.JTable;

//public class MyDefaultTableCellRenderer extends DefaultTableCellRenderer {
//	
//	@Override
//	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
//		Component comp = null;
//		if(column == 6) {
//			comp = new JCheckBox();
//		}
//		return comp;
//		
//	}
//	
//	
//	
//}

public class MyDefaultTableCellRenderer extends JCheckBox implements javax.swing.table.TableCellRenderer {
	
	// 7번째 Column에 CheckBox 추가하기
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        // 부모 클래스인 JCheckBox를 사용하므로 MyDefaultTableCellRenderer를 따로 생성할 필요가 없습니다.
        this.setSelected(value != null && (boolean) value);
        this.setHorizontalAlignment(CENTER); // CheckBox의 정렬 방식 설정 (가운데 정렬)
        this.setBackground(isSelected ? table.getSelectionBackground() : table.getBackground());
        return this;
    }
    
    
    
}
