package shop;

public class PizzaShop extends Shop implements Nameable {

	String companyName;
	
	String[] foodOfferings = {
			"pizza",
			"Spaghetti",
			"Garden Salad",
			"Antipasto",
			"Calzone"
	};
	
	@Override
	public String getName() {
		return companyName;
	}

	@Override
	public void setName(String name) {
		companyName = name;
	}

	@Override
	public String[] getInventory() {
		return foodOfferings;
	}

	@Override
	public void buyInventory(String item) {
		System.out.println("\nYou have Just purchased " + item);
	}

}
