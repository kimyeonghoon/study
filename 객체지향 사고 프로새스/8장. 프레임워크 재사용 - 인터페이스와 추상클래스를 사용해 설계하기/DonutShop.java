package shop;

public class DonutShop extends Shop implements Nameable {

	String companyName;
	
	String menuItems[] = {
			"Donuts",
			"Muffins",
			"Danish",
			"Coffee",
			"Tea"
	};
	
	public String[] getInventory() {
		return menuItems;
	}
	
	public void buyInventory(String item) {
		System.out.println("\nYou have just purchased" + item);
	}
	
	public String getName() {
		return companyName;
	}
	
	public void setName(String name) {
		companyName = name;
	}
}
