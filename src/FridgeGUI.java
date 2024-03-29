import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class FridgeGUI implements ActionListener{
	
	private Fridge fridge;
	private JButton addButton;
	private JPanel north;
	private JPanel east;
	private String types[] = {"Protein", "Dairy", "Fruit", "Vegetable", "Leftovers", "Beverage"};
	private FridgeListView listView;
	
	public FridgeGUI() {
		
		// initialize jframe and fridge
		JFrame f = new JFrame();
		fridge = new Fridge();
		
		// main gui buttons
		addButton = new JButton("Add Food");
		
		// north panel
		north = new JPanel();
		north.add(addButton);
		f.add(north, BorderLayout.NORTH);
		
		// fridge list view
		listView = new FridgeListView(fridge);
		fridge.addListener(listView);
        f.add(new JScrollPane(listView), BorderLayout.CENTER);
        
        // instructions for use
        String instructionsString = "<html><body>" + 
        		"<p>Instructions:</p>" +
        		"<p>Click an item to view its information.</p>" +
        		"<p>Double click an item to remove it from the fridge</p>" +
        		"</body></html>";
        JLabel instructions = new JLabel(instructionsString);
        instructions.setFont(new Font("Serif", Font.PLAIN, 14));
        
        // east panel with instructions
        east = new JPanel();
        east.add(instructions);
        f.add(east, BorderLayout.EAST);
		
		addButton.addActionListener(this);
		
		f.setSize(500, 700);
	    f.setVisible(true);
	    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	     
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
            Food newFood = new Food();
            newFood.setName(name);
            newFood.setDaysUntilExpired(expiration);
            newFood.setType(type);
            newFood.setQuantity(quantity);
            fridge.addFood(newFood);
        }
		
	}
	
}
