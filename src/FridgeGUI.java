import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FridgeGUI extends JFrame implements ActionListener{
	
	private Fridge fridge;
	private JButton addButton;
	private JButton removeButton;
	private JPanel north;
	private JPanel list;
	private String types[] = {"Protein", "Dairy", "Fruit", "Vegetable", "Leftovers", "Beverage"};
	private JList<String> foodList;
	
	public FridgeGUI() {
		JFrame f = new JFrame();
		// intialize fridge
		
		fridge = new Fridge();
		
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
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == addButton) {
			addFoodDialog();
			displayFridge();
		}
		
	}
	
	private void displayFridge() {
		DefaultListModel<String> listModel = (DefaultListModel<String>) foodList.getModel();
		listModel.clear();
		
		for (Food food : fridge.getFoods()) {
			listModel.addElement(food.getName());
		}
	}
	
	private void addFoodDialog() {
		
		// intializing fields for food constructor
		JTextField nameField = new JTextField();
		JTextField expirationField = new JTextField();
		JComboBox typeField = new JComboBox(types);
		JTextField quantityField = new JTextField();
		
		// displaying menu in new panel
		JPanel p = new JPanel();
		p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
		p.add(new JLabel("Name:"));
        p.add(nameField);
        p.add(new JLabel("Days Until Expiration:"));
        p.add(expirationField);
        p.add(new JLabel("Type:"));
        p.add(typeField);
        p.add(new JLabel("Quantity:"));
        p.add(quantityField);
        
        // if the user presses the add food button, add a food to the fridge
        int result = JOptionPane.showConfirmDialog(null, p, "Add Food", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
        	
        	// getting all fields 
            String name = nameField.getText();
            int expiration = Integer.parseInt(expirationField.getText());
            int typeIndex = typeField.getSelectedIndex();
            String type = types[typeIndex];
            int quantity = Integer.parseInt(quantityField.getText());

            // Creating a Food object and adding it to the fridge
            Food newFood = new Food();
            newFood.setName(name);
            newFood.setDaysUntilExpired(expiration);
            newFood.setType(type);
            newFood.setQuantity(quantity);
            fridge.addFood(newFood);
        }
		
	}

	public static void main(String[] args) {
		new FridgeGUI();
	}

	
}
