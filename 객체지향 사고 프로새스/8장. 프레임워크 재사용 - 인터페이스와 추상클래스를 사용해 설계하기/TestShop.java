package shop;

public class TestShop {

	public static void main(String[] args) {
		Shop shop = null;
		
		String className = args[0];
		
		System.out.println("Instantiate the class : " + className + "\n");
		
		try {
			// new pizzaShop();
			shop = (Shop)Class.forName(className).newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		String[] inventory = shop.getInventory();
		
		for(int i = 0; i < inventory.length; i++) {
			System.out.println("Argument" + i + " = " + inventory[i]);
		}
		
		shop.buyInventory(inventory[1]);
	}

}
