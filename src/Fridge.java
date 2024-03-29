
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Fridge {
	
	private List<Food> foods;
	private List<FridgeListener> listeners;
	
	public Fridge() {
		foods = new ArrayList<>();
		listeners = new ArrayList<>();
	}
	
	/**
	 * Adds a food item to the fridge
	 */
	public void addFood(Food item) {
		foods.add(item);
		notifyListeners();
	}
	
	/**
	 * Removes a food item from the fridge
	 */
	public void removeFood(Food item) {
		foods.remove(item);
		notifyListeners();
	}
	
	/**
	 * Adds a listener to the fridge's listener list
	 * Listener is notified when fridge's list value changes 
	 * @param listener
	 */
	public void addListener(FridgeListener listener) {
        listeners.add(listener);
    }

	public void notifyListeners() {
        for (FridgeListener listener : listeners) {
            listener.update(foods);
        }
    }
	
	/**
	 * Sorts foods by expiration date
	 * Foods that will expire the soonest are at the front of the list
	 */
	public void sortByExpiration() {
		Collections.sort(foods, Comparator.comparingInt(Food::getDaysUntilExpired));
	}
	
	/**
	 * Display food items by type
	 */
	public ArrayList<String> displayByType(String type) {
		
		ArrayList<String> foodsOfType = new ArrayList<String>();
		
		for(Food food : foods) {
			if (food.getType().equals(type)) {
				foodsOfType.add(food.getName());			}
		}
		
		return foodsOfType;
	}
	
	public List<Food> getFoods(){
		return foods;
	}
	
}
