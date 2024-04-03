package view;

import java.util.List;
import java.awt.*;
import java.awt.event.*;

import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;

import model.Food;
import model.Fridge;

public class FridgeListView extends JList<Food> implements FridgeListener {
	
	
	private Fridge fridge;
	
	public FridgeListView(Fridge fridge){
		
		super(new DefaultListModel<>());
		this.fridge = fridge;
		
		// initial update to the list model upon construction
		update(fridge.getFoods());
		
		setCellRenderer(new FridgeListCellRenderer());
		
		/**
		 * Mouse listener that shows a food's attributes when clicked once
		 */
		addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e) {

				if(e.getClickCount() == 2) {  // single click to display
					
					int index = locationToIndex(e.getPoint());
                    if (index >= 0) {
                        // Get the selected food item and display its attributes
                        Food f = getModel().getElementAt(index);
                        displayAttributes(f);
                    }
                    
				}
			}
		});
	}
	
	
	/**
	 * Updates view of the all items in the fridge as a list
	 */
	@Override
	public void update(List<Food> foods) {
		
		DefaultListModel<Food> listModel = (DefaultListModel<Food>) getModel();
        listModel.clear();

        // Adds foods from the fridge's food list to the list model
		for (Food food : foods) {
			listModel.addElement(food);
		}
	}
	
	/**
	 * Helper for mouse listener
	 * Displays the attributes of a given food
	 * @param food
	 */
	public void displayAttributes(Food food) {

		JOptionPane.showMessageDialog(this,
	            "Name: " + food.getName() + "\n" +
	            "Type: " + food.getType() + "\n" +
	            "Days until expired: " + food.getDaysUntilExpired() + "\n" +
	            "Quantity: " + food.getQuantity(),
	            food.getName() + "Information", JOptionPane.INFORMATION_MESSAGE);
	}
	
	/**
	 * fridge getter
	 * @return fridge
	 */
	public Fridge getFridge() {
		return this.fridge;
	}
	
}
