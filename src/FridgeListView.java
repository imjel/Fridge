import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JList;

public class FridgeListView extends JList<String> implements FridgeListener {
	
	
	private Fridge fridge;
	
	FridgeListView(Fridge fridge){
		super(new DefaultListModel<>());
		this.fridge = fridge;
		
		// initial update to the list model upon construction
		update(fridge.getFoods());
		
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

}
