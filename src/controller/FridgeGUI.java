package controller;

import javax.swing.*;

import model.Food;
import model.Fridge;
import view.FridgeListView;
import view.RemoveFoodListener;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class FridgeGUI implements ActionListener{
	
	private Fridge fridge;
	private FridgeListView listView;
	
	private JButton addButton;
	private JButton removeButton;
	
	private JPanel north;
	private JPanel east;
	private JPanel west;
	private JPanel center;
	
	private String types[] = {"Protein", "Dairy", "Fruit", "Vegetable", "Leftovers", "Beverage"};
	
	private JLabel sortLabel;
	private JComboBox sortMenu;
	private static final String TYPE = "Type";
	private static final String EXPIRATION = "Expiration";
	private static final String NAME = "Name";
	
	public FridgeGUI() {
		
		// initialize jframe and fridge
		JFrame f = new JFrame();
		fridge = new Fridge();
		
		// main gui buttons
		addButton = new JButton("Add Food");
		removeButton = new JButton("Remove");
		
		// sort menu
		sortLabel = new JLabel("Sort by:");
		sortMenu = new JComboBox();
		//sortMenu.addItem(TYPE);
		sortMenu.addItem(EXPIRATION);
		sortMenu.addItem(NAME);
		
		
		// north panel
		north = new JPanel();
		north.add(addButton);
		north.add(removeButton);
		north.add(sortLabel);
		north.add(sortMenu);
		f.add(north, BorderLayout.NORTH);
		
		// fridge list view
		listView = new FridgeListView(fridge);
		fridge.addListener(listView);

        // button listeners
		addButton.addActionListener(this);
        removeButton.addActionListener(new RemoveFoodListener(listView));
        
        // sorts the fridge according to user's selected sort algorithm
        sortMenu.addActionListener(event -> {
        	
        	String sortAlgo = (String) sortMenu.getSelectedItem();
        	switch(sortAlgo) {
        		case EXPIRATION:
        			fridge.sortByExpiration();
        			break;
        		case NAME:
        			fridge.sortAlphabetically();
        			break;
        		default:
        			break;
        	}
        	
        });
        
        // instructions for use
        String instructionsString = "<html><body>" + 
        		"<p>Instructions:</p>" +
        		"<p>Double click an item to view its information.</p>" +
        		"<p>Select and item and click 'remove'</p>" +
        		"<p>to remove it from the fridge.</p>" +
        		"</body></html>";
        JLabel instructions = new JLabel(instructionsString);
        instructions.setFont(new Font("Serif", Font.PLAIN, 14));
        
        // center panel
     	center = new JPanel();
     	center.add(instructions);
     	center.add(new JScrollPane(listView), BorderLayout.CENTER);
     	f.add(center);

		f.setSize(500, 700);
	    f.setVisible(true);
	    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	     
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == addButton) {
            addFoodDialog();
		}
	}
	
	private void addFoodDialog() {
		
		// initializing fields for food constructor
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

        // if the user clicks the add food button, add a food to the fridge
        int result = JOptionPane.showConfirmDialog(null, p, "Add Food", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {

        	// getting all fields 
            String name = nameField.getText();
            int expiration = Integer.parseInt(expirationField.getText());
            int typeIndex = typeField.getSelectedIndex();
            String type = types[typeIndex];
            int quantity = Integer.parseInt(quantityField.getText());

            // Creating a Food object and adding it to the fridge
            Food newFood = new Food(name, expiration, type, quantity);
            fridge.addFood(newFood);
        }
		
	}
	
	public static void main(String args[]) {
		new FridgeGUI();
	}
	
}
