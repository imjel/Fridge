package view;

import java.awt.BorderLayout;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;

import model.Food;

public class FridgeListCellRenderer extends JPanel implements ListCellRenderer<Food> {
	
	private JLabel nameLabel;
	
	/**
	 * Constructor sets up layout and remove button for each cell in the food list
	 */
	public FridgeListCellRenderer() {
		
		setLayout(new BorderLayout());
		nameLabel = new JLabel();
		add(nameLabel, BorderLayout.WEST);
	
	}
	
	/**
	 * set the text of the list cell to the food's name
	 */
	@Override
	public Component getListCellRendererComponent(JList<? extends Food> list, Food value, int index, boolean isSelected, boolean cellHasFocus) {
		
		nameLabel.setText(value.getName());
		return this;
		
	}
	
	
	
}