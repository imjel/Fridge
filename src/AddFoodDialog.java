import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AddFoodDialog {

	private static String types[] = {"Protein", "Dairy", "Fruit", "Vegetable", "Leftovers", "Beverage"};
	
	public static Food showDialog() {
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
			
			return newFood;
		}
		
		return null;
	}
}
