package model;

public class Food {

	String name;
	int daysUntilExpired;
	String type;
	int quantity;
	
	public Food() {
	}
	
	public Food(String name, int daysUntilExpired, String type, int quantity) {
		this.name = name;
		this.daysUntilExpired = daysUntilExpired;
		this.type = type;
		this.quantity = quantity;
	}
	
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getDaysUntilExpired() {
		return daysUntilExpired;
	}
	
	public void setDaysUntilExpired(int daysUntilExpired) {
		this.daysUntilExpired = daysUntilExpired;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
}
