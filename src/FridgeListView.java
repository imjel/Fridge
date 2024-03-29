import java.util.List;
import java.awt.*;
import java.awt.event.*;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;

public class FridgeListView extends JList<String> implements FridgeListener {
	
	
	private Fridge fridge;
	
	FridgeListView(Fridge fridge){
		
		super(new DefaultListModel<>());
		this.fridge = fridge;
		
		// initial update to the list model upon construction
		update(fridge.getFoods());
		
		/**
		 * Mouse listener that shows a food's attributes when clicked once
		 */
		addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e) {

				if(e.getClickCount() == 1) {  // single click
					int index = locationToIndex(e.getPoint());
                    if (index >= 0) {
                        // Get the selected food item and display its attributes
                        Food f = fridge.getFoods().get(index);
                        displayAttributes(f);
                    }
				}
			}
		});
	}
	
	
	
	/**
	 * View of the all items in the fridge as a list
	 */
	@Override
	public void update(List<Food> foods) {
		
		DefaultListModel<String> listModel = (DefaultListModel<String>) getModel();
        listModel.clear();

        // Adds foods from the fridge's food list to the list model
		for (Food food : foods) {
			listModel.addElement(food.getName());
		}
	}
	
	public void displayAttributes(Food food) {

		JOptionPane.showMessageDialog(this,
	            "Name: " + food.getName() + "\n" +
	            "Type: " + food.getType() + "\n" +
	            "Days until expired: " + food.getDaysUntilExpired() + "\n" +
	            "Quantity: " + food.getQuantity(),
	            food.getName() + "Information", JOptionPane.INFORMATION_MESSAGE);
	}
		

}
