
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Fridge {
	
	private List<Food> foods;
	
	public Fridge() {
		foods = new ArrayList<>();
	}
	
	/**
	 * Prints all items in the fridge
	 */
	public void displayFridge() {
		
		System.out.println("\nNumber of foods in fridge: " + foods.size());
		
		for (Food food : foods) {
			System.out.println("\n" + food.getName());
		}
	}
	
	/**
	 * Adds a food item to the fridge
	 */
	public void addFood(Food item) {
		foods.add(item);
	}
	
	/**
	 * Removes a food item from the fridge
	 */
	public void removeFood(Food item) {
		foods.remove(item);
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
	public void displayByType(String type) {
		
		for(Food food : foods) {
			if (food.getType().equals(type)) {
				System.out.println("\n" + food.getName());
			}
		}
	}
	
	public List<Food> getFoods(){
		return foods;
	}
	
}
