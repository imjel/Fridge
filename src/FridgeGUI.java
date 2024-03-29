import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class FridgeGUI implements ActionListener, FridgeListener{
	
	private Fridge fridge;
	private JButton addButton;
	private JButton removeButton;
	private JPanel north;
	private JPanel list;
	private String types[] = {"Protein", "Dairy", "Fruit", "Vegetable", "Leftovers", "Beverage"};
	private JList<String> foodList;
	
	@Override
	public void update(List<Food> foods) {
		
		// When fridge changes, update View
        DefaultListModel<String> listModel = (DefaultListModel<String>) foodList.getModel();
        listModel.clear();

        for (Food food : foods) {
            listModel.addElement(food.getName());
        }
		
	}
	
	public FridgeGUI() {
		
		JFrame f = new JFrame();
		// initialize fridge
		
		fridge = new Fridge();
		fridge.addListener(this);
		
		removeButton = new JButton("Remove Food");
		addButton = new JButton("Add Food");
		
		// list for foods
		DefaultListModel<String> listModel = new DefaultListModel<>();
		foodList = new JList<>(listModel);
		
		// north panel
		north = new JPanel();
		north.add(addButton);
		f.add(north, BorderLayout.NORTH);
		
		// list panel
		list = new JPanel();
		list.add(foodList);
		f.add(list, BorderLayout.CENTER);
		
		
		addButton.addActionListener(this);
	
		
		f.setSize(400, 400);
	    f.setVisible(true);
	    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        
	     
	}
	
	
	private void displayFridge() {
		DefaultListModel<String> listModel = (DefaultListModel<String>) foodList.getModel();
		listModel.clear();
		
		for (Food food : fridge.getFoods()) {
			listModel.addElement(food.getName());
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == addButton) {
            addFoodDialog();
		}
//        } else if (e.getSource() == removeButton) {
//        	fridge.removeFood(null);
//        }
		
	}
	
	private void addFoodDialog() {
		
		
		
	}

	public static void main(String[] args) {
		new FridgeGUI();
	}

	
}
