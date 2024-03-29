import java.util.List;

/**
 * Interface for Fridge listeners
 */
public interface FridgeListener {
	
	/**
	 * Called when the fridge changes
	 */
	public void update(List<Food> foods);
	
}
