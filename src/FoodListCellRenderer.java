import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;
import javax.swing.SwingUtilities;

public class FoodListCellRenderer extends JPanel implements ListCellRenderer<Food> {
	
	private JLabel nameLabel;
	private JButton removeButton;
	
	/**
	 * Constructor sets up layout and remove button for each cell in the food list
	 */
	public FoodListCellRenderer() {
		
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