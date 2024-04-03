package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Food;
import model.Fridge;

	/**
	 * Listener for removing food from a list
	 */
	public class RemoveFoodListener implements ActionListener {
		
	    private FridgeListView listView;
	    
	    public RemoveFoodListener(FridgeListView listView) {
	        this.listView = listView;
	    }
	    
	    @Override
	    public void actionPerformed(ActionEvent e) {
	        // Get the selected index in the FridgeListView
	        int selectedIndex = listView.getSelectedIndex();
	        
	        // Remove the item from the Fridge model
	        if (selectedIndex != -1) {
	        	Food food = listView.getSelectedValue();
	            listView.getFridge().removeFood(food);
	        }
	    }
	}