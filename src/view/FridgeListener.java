package view;
import java.util.List;

import model.Food;

/**
 * Interface for Fridge listeners
 */
public interface FridgeListener {
	
	/**
	 * Called when the fridge changes
	 */
	public void update(List<Food> foods);
	
}
